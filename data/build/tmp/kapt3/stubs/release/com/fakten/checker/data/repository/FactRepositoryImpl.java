package com.fakten.checker.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/fakten/checker/data/repository/FactRepositoryImpl;", "Lcom/fakten/checker/domain/repository/FactRepository;", "factCheckService", "Lcom/fakten/checker/data/remote/FactCheckService;", "factDao", "Lcom/fakten/checker/data/local/dao/FactDao;", "(Lcom/fakten/checker/data/remote/FactCheckService;Lcom/fakten/checker/data/local/dao/FactDao;)V", "checkFactFromText", "Lcom/fakten/checker/domain/model/Fact;", "text", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkFactFromUrl", "url", "getClaimStatus", "Lcom/fakten/checker/domain/model/Claim;", "claimId", "getContraArguments", "", "Lcom/fakten/checker/domain/model/Argument;", "factId", "getProArguments", "submitClaim", "", "claim", "(Lcom/fakten/checker/domain/model/Claim;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"})
public final class FactRepositoryImpl implements com.fakten.checker.domain.repository.FactRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.fakten.checker.data.remote.FactCheckService factCheckService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fakten.checker.data.local.dao.FactDao factDao = null;
    
    @javax.inject.Inject()
    public FactRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.fakten.checker.data.remote.FactCheckService factCheckService, @org.jetbrains.annotations.NotNull()
    com.fakten.checker.data.local.dao.FactDao factDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object checkFactFromText(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.fakten.checker.domain.model.Fact> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object checkFactFromUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.fakten.checker.domain.model.Fact> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getProArguments(@org.jetbrains.annotations.NotNull()
    java.lang.String factId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.fakten.checker.domain.model.Argument>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getContraArguments(@org.jetbrains.annotations.NotNull()
    java.lang.String factId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.fakten.checker.domain.model.Argument>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object submitClaim(@org.jetbrains.annotations.NotNull()
    com.fakten.checker.domain.model.Claim claim, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getClaimStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String claimId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.fakten.checker.domain.model.Claim> $completion) {
        return null;
    }
}