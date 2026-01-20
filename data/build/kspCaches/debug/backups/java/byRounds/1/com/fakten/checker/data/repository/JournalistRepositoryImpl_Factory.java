package com.fakten.checker.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
    "KotlinInternalInJava",
    "cast"
})
public final class JournalistRepositoryImpl_Factory implements Factory<JournalistRepositoryImpl> {
  @Override
  public JournalistRepositoryImpl get() {
    return newInstance();
  }

  public static JournalistRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static JournalistRepositoryImpl newInstance() {
    return new JournalistRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final JournalistRepositoryImpl_Factory INSTANCE = new JournalistRepositoryImpl_Factory();
  }
}
