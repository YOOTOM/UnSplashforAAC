package com.yootom.unsplashforaac.data.rest;

import com.yootom.unsplashforaac.data.model.UnSplash;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
    retrofit2 + okhttp3을 이용하여 CRUD 구현
        참조문서 : https://square.github.io/retrofit/
                 https://square.github.io/okhttp/recipes/

    Retrofit2 어노테이션
        @Body - request body로 Java 객체를 전달합니다.
        @Url - 동적인 URL이 필요할때 사용합니다.
        @Query - 쿼리를 추가할 수 있으며, 쿼리를 URL 인코딩하려면 다음과 같이 작성합니다.
                 @Query(value = “auth_token”,encoded = true) String auth_token
        @Field - POST에서만 동작하며 form-urlencoded로 데이터를 전송합니다.
                 이 메소드에는 @FormUrlEncoded 어노테이션이 추가되어야 합니다.

    Retrofit2 HTTP method
        Retrofit은 @GET, @POST, @PUT, @DELETE, @PATCH or @HEAD와 같은 annotation을 통해 HTTP method를 이용

    OkHttp Interceptors :
        Interceptor는 OkHttp에 있는 강력한 메커니즘으로
        호출을 모니터, 재작성 및 재시도를 할 수 있습니다.
        Interceptor는 크게 두 가지 카테고리로 분류할 수 있습니다.

    Application Interceptors :
        Application Interceptor를 등록하려면 OkHttpClient.Builder에서 addInterceptor()를 호출해야 합니다.

    Network Interceptors :
        Network Interceptor를 등록하려면 addInterceptor() 대신 addNetworkInterceptor()를 추가해야 합니다.

    * 프로세스
        1. Retrofit2는 기본적으로 OkHttp를 네트워킹 계층으로 활용하며 그 위에 구축
        2. Retrofit은 자동적으로 JSON 응답을 사전에 정의된 POJO를 통해 직렬화(model)
        3. JSON을 직렬화 하기 위해서 Gson로 converter작업
 */

public class Client {
    public static RestApiInterface apiInterface;

    public static String baseapi = "https://api.unsplash.com/";

    //getClient() 메서드는 Retrofit 인터페이스를 설정할 때마다 호출됩니다.
    public static RestApiInterface getClient() {

        if (apiInterface == null) {
            //HTTP 요청 및 응답 데이터를 기록 하는 OkHttp 인터셉터
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            /*
            HttpLoggingInterceptor의 로그설정 레벨 종류
                BASIC
                    요청 및 응답 라인을 기록합니다.
                BODY
                    요청 및 응답 행과 해당 헤더 및 본문 (있는 경우)을 기록합니다.
                HEADERS
                    요청 및 응답 행과 해당 헤더를 기록합니다.
                NONE
                    로그가 없습니다.
            */
            //원하는 로그 레벨 설정
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);


            //OkHttp 초기화
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.interceptors().add(logging);
            builder.addInterceptor(logging);
            OkHttpClient httpClient = builder.build();

            //Retrofit 초기화
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseapi)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
            apiInterface = client.create(RestApiInterface.class);
        }
        return apiInterface;
    }

    //Retrofit으로 Rest(Http)통신
    public interface RestApiInterface {

        // 사진목록 가져오기
        // GET /photos
        // https://api.unsplash.com/photos/?client_id=YOUR_ACCESS_KEY

        @GET("photos/")
        Call<List<UnSplash>> getListUnSplash(@Query("client_id") String user, @Query("page") int page);

    }
}
