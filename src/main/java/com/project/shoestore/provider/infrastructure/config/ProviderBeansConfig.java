package com.project.shoestore.provider.infrastructure.config;

import com.project.shoestore.provider.adapters.repositories.ProviderRepositoryAdapter;
import com.project.shoestore.provider.domain.usecases.CreateProviderService;
import com.project.shoestore.provider.domain.usecases.DeleteProviderService;
import com.project.shoestore.provider.domain.usecases.FindProviderService;
import com.project.shoestore.provider.domain.usecases.UpdateProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderBeansConfig {
  @Bean
  public CreateProviderService createProviderService(ProviderRepositoryAdapter repository) {
    return new CreateProviderService(repository);
  }

  @Bean
  public UpdateProviderService updateProviderService(ProviderRepositoryAdapter repository) {
    return new UpdateProviderService(repository);
  }

  @Bean
  public DeleteProviderService deleteProviderService(ProviderRepositoryAdapter repository, FindProviderService findProviderService) {
    return new DeleteProviderService(repository, findProviderService);
  }

  @Bean
  public FindProviderService findProviderService(ProviderRepositoryAdapter repository) {
    return new FindProviderService(repository);
  }
}
