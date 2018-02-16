package com.example.revern.vkontaktetest.utils.network;

import com.example.revern.vkontaktetest.utils.network.models.RetrofitException;

import org.reactivestreams.Publisher;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class RxErrorHandlingCallAdapterFactory
//    extends CallAdapter.Factory
{

//    private final RxJavaCallAdapterFactory original;
//
//    private RxErrorHandlingCallAdapterFactory() {
//        original = RxJavaCallAdapterFactory.create();
//    }
//
//    public static CallAdapter.Factory create() {
//        return new RxErrorHandlingCallAdapterFactory();
//    }
//
//    @Override
//    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
//        return new RxCallAdapterWrapper(retrofit, original.get(returnType, annotations, retrofit));
//    }
//
//    private static class RxCallAdapterWrapper implements CallAdapter<Flowable<?>> {
//
//        private final Retrofit       retrofit;
//        private final CallAdapter<?> wrapped;
//
//        RxCallAdapterWrapper(Retrofit retrofit, CallAdapter<?> wrapped) {
//            this.retrofit = retrofit;
//            this.wrapped = wrapped;
//        }
//
//        @Override
//        public Type responseType() {
//            return wrapped.responseType();
//        }
//
//        @SuppressWarnings("unchecked")
//        @Override
//        public <R> Flowable<?> adapt(Call<R> call) {
//            return ((Flowable) wrapped.adapt(call))
//                .onErrorResumeNext((Function<? super Throwable, ? extends Publisher>) throwable ->
//                    Flowable.error(RxCallAdapterWrapper.this.asRetrofitException(throwable)));
//        }
//
//        private RetrofitException asRetrofitException(Throwable throwable) {
//            // We had non-200 http error
//            if (throwable instanceof HttpException) {
//                HttpException httpException = (HttpException) throwable;
//                Response response = httpException.response();
////                if (response.code() == 401) {
////                    Bus.event(UserUnauthorizedEvent.EVENT);
////                }
//                return RetrofitException
//                    .httpError(response.raw().request().url().toString(), response, retrofit);
//            }
//            // A network error happened
//            if (throwable instanceof IOException) {
//                return RetrofitException.networkError((IOException) throwable);
//            }
//
//            // We don't know what happened. We need to simply convert to an unknown error
//
//            return RetrofitException.unexpectedError(throwable);
//        }
//    }

}
