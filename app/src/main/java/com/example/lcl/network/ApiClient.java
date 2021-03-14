package com.example.lcl.network;

import android.util.Log;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.lcl.util.Constants.BASE_URL;

public class ApiClient {

    public static ApiService create() {
        return create(HttpUrl.parse(BASE_URL));
    }

    private static ApiService create(HttpUrl httpUrl) {
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor(
                message -> Log.d("==API==", message));
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logger)
                .build();
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }
}
