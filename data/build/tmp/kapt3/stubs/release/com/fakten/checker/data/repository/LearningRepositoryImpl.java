package com.fakten.checker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0096@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/fakten/checker/data/repository/LearningRepositoryImpl;", "Lcom/fakten/checker/domain/repository/LearningRepository;", "()V", "getLearningModuleProgress", "", "moduleId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLearningModules", "", "Lcom/fakten/checker/domain/model/LearningModule;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLearningModuleProgress", "", "progress", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"})
public final class LearningRepositoryImpl implements com.fakten.checker.domain.repository.LearningRepository {
    
    public LearningRepositoryImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getLearningModules(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.fakten.checker.domain.model.LearningModule>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getLearningModuleProgress(@org.jetbrains.annotations.NotNull()
    java.lang.String moduleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateLearningModuleProgress(@org.jetbrains.annotations.NotNull()
    java.lang.String moduleId, int progress, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}