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
public final class LearningRepositoryImpl_Factory implements Factory<LearningRepositoryImpl> {
  @Override
  public LearningRepositoryImpl get() {
    return newInstance();
  }

  public static LearningRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LearningRepositoryImpl newInstance() {
    return new LearningRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final LearningRepositoryImpl_Factory INSTANCE = new LearningRepositoryImpl_Factory();
  }
}
