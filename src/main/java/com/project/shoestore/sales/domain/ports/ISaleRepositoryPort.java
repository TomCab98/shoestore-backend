package com.project.shoestore.sales.domain.ports;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.sales.domain.models.Refund;
import com.project.shoestore.sales.domain.models.Sale;

public interface ISaleRepositoryPort extends IRepositoryPort<Sale, String> {
  void refundProduct(Refund refund);
}
