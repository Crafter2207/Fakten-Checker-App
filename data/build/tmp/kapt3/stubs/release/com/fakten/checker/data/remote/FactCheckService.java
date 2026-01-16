package com.fakten.checker.data.remote;

/**
 * Retrofit service interface for the fact-checking API.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/fakten/checker/data/remote/FactCheckService;", "", "checkText", "Lcom/fakten/checker/data/remote/dto/FactDto;", "text", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkUrl", "url", "data_release"})
public abstract interface FactCheckService {
    
    /**
     * Submits a text for fact-checking.
     */
    @retrofit2.http.POST(value = "check/text")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object checkText(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.fakten.checker.data.remote.dto.FactDto> $completion);
    
    /**
     * Submits a URL for fact-checking.
     */
    @retrofit2.http.POST(value = "check/url")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object checkUrl(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.fakten.checker.data.remote.dto.FactDto> $completion);
}