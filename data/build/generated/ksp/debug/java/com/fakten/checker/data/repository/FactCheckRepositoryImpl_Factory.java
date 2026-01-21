package com.fakten.checker.data.repository;

import com.fakten.checker.data.remote.MyBackendApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
    "KotlinInternalInJava",
    "cast"
})
public final class FactCheckRepositoryImpl_Factory implements Factory<FactCheckRepositoryImpl> {
  private final Provider<MyBackendApi> apiProvider;

  public FactCheckRepositoryImpl_Factory(Provider<MyBackendApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public FactCheckRepositoryImpl get() {
    return newInstance(apiProvider.get());
  }

  public static FactCheckRepositoryImpl_Factory create(Provider<MyBackendApi> apiProvider) {
    return new FactCheckRepositoryImpl_Factory(apiProvider);
  }

  public static FactCheckRepositoryImpl newInstance(MyBackendApi api) {
    return new FactCheckRepositoryImpl(api);
  }
}
