package com.fakten.checker.data.repository;

import com.fakten.checker.data.local.dao.FactDao;
import com.fakten.checker.data.remote.FactCheckService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class FactRepositoryImpl_Factory implements Factory<FactRepositoryImpl> {
  private final Provider<FactCheckService> factCheckServiceProvider;

  private final Provider<FactDao> factDaoProvider;

  public FactRepositoryImpl_Factory(Provider<FactCheckService> factCheckServiceProvider,
      Provider<FactDao> factDaoProvider) {
    this.factCheckServiceProvider = factCheckServiceProvider;
    this.factDaoProvider = factDaoProvider;
  }

  @Override
  public FactRepositoryImpl get() {
    return newInstance(factCheckServiceProvider.get(), factDaoProvider.get());
  }

  public static FactRepositoryImpl_Factory create(
      Provider<FactCheckService> factCheckServiceProvider, Provider<FactDao> factDaoProvider) {
    return new FactRepositoryImpl_Factory(factCheckServiceProvider, factDaoProvider);
  }

  public static FactRepositoryImpl newInstance(FactCheckService factCheckService, FactDao factDao) {
    return new FactRepositoryImpl(factCheckService, factDao);
  }
}
