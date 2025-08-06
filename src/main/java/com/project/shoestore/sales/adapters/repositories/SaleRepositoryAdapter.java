package com.project.shoestore.sales.adapters.repositories;

import com.project.shoestore.client.infrastructure.repositories.ClientRepository;
import com.project.shoestore.client.infrastructure.repositories.entities.ClientEntity;
import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.core.domain.exceptions.NotFoundException;
import com.project.shoestore.employee.infrastructure.repositories.EmployeeRepository;
import com.project.shoestore.employee.infrastructure.repositories.entities.EmployeeEntity;
import com.project.shoestore.product.infrastructure.repositories.ProductRepository;
import com.project.shoestore.product.infrastructure.repositories.entities.ProductEntity;
import com.project.shoestore.sales.adapters.mappers.RefundRepositoryMapper;
import com.project.shoestore.sales.adapters.mappers.SaleDetailRepositoryMapper;
import com.project.shoestore.sales.adapters.mappers.SaleRepositoryMapper;
import com.project.shoestore.sales.domain.models.Refund;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.domain.models.SaleDetail;
import com.project.shoestore.sales.domain.ports.ISaleRepositoryPort;
import com.project.shoestore.sales.infrastructure.repositories.RefundRepository;
import com.project.shoestore.sales.infrastructure.repositories.SaleDetailRepository;
import com.project.shoestore.sales.infrastructure.repositories.SaleRepository;
import com.project.shoestore.sales.infrastructure.repositories.StatusRepository;
import com.project.shoestore.sales.infrastructure.repositories.entities.RefundEntity;
import com.project.shoestore.sales.infrastructure.repositories.entities.SaleDetailEntity;
import com.project.shoestore.sales.infrastructure.repositories.entities.SaleEntity;
import com.project.shoestore.sales.infrastructure.repositories.entities.StatusEntity;
import com.project.shoestore.sales.infrastructure.repositories.ids.SaleDetailId;
import org.springframework.stereotype.Component;

@Component
public class SaleRepositoryAdapter extends RepositoryAdapter<Sale, SaleEntity, String> implements ISaleRepositoryPort {
  private final EmployeeRepository employeeRepository;
  private final ClientRepository clientRepository;
  private final SaleDetailRepositoryMapper detailMapper;
  private final ProductRepository productRepository;
  private final RefundRepositoryMapper refundMapper;
  private final SaleDetailRepository detailRepository;
  private final RefundRepository refundRepository;
  private final StatusRepository statusRepository;

  public SaleRepositoryAdapter(
    SaleRepository repository,
    SaleRepositoryMapper mapper,
    EmployeeRepository employeeRepository,
    ClientRepository clientRepository,
    SaleDetailRepositoryMapper detailMapper,
    ProductRepository productRepository,
    RefundRepositoryMapper refundMapper,
    SaleDetailRepository detailRepository,
    RefundRepository refundRepository,
    StatusRepository statusRepository
  ) {
    super(repository, mapper);
    this.clientRepository = clientRepository;
    this.employeeRepository = employeeRepository;
    this.detailMapper = detailMapper;
    this.productRepository = productRepository;
    this.refundMapper = refundMapper;
    this.detailRepository = detailRepository;
    this.refundRepository = refundRepository;
    this.statusRepository = statusRepository;
  }

  @Override
  public Sale create(Sale sale) {
    EmployeeEntity employee = employeeRepository.findById(sale.getEmployee().getId())
      .orElseThrow(() -> new NotFoundException("not found employee"));

    ClientEntity client = clientRepository.findById(sale.getClient().getId())
      .orElseThrow(() -> new NotFoundException("not found client"));

    StatusEntity status = statusRepository.findByName(sale.getStatus().name());

    SaleEntity saleEntity = mapper.toEntity(sale);
    saleEntity.setClient(client);
    saleEntity.setEmployee(employee);
    saleEntity.setStatus(status);

    for (SaleDetail detail: sale.getDetails()) {
      SaleDetailEntity detailEntity = detailMapper.toEntity(detail);

      ProductEntity product = productRepository.findById(detail.getProduct().getId())
        .orElseThrow(() -> new NotFoundException("not found product"));

      SaleDetailId id = new SaleDetailId(product.getId());

      detailEntity.setId(id);
      detailEntity.setProduct(product);

      saleEntity.addDetails(detailEntity);
    }

    SaleEntity created = repository.save(saleEntity);
    return mapper.toDomain(created);
  }

  @Override
  public void refundProduct(Refund refund) {
    SaleDetailId detailId = new SaleDetailId(refund.getProduct(), refund.getSale());
    SaleDetailEntity detailEntity = detailRepository.findById(detailId)
      .orElseThrow(() -> new NotFoundException("not found sale"));
    StatusEntity status = statusRepository.findByName(refund.getStatus().name());

    RefundEntity entity = refundMapper.toEntity(refund);
    entity.setDetail(detailEntity);
    entity.setStatus(status);

    refundRepository.save(entity);
  }
}
