package com.yootom.unsplashforaac.data;


import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.yootom.unsplashforaac.data.model.UnSplash;
import com.yootom.unsplashforaac.data.rest.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//USDataSource는 PageKeyedDataSource<key, Value)을 상속받으며,
//서버로 부터 수신과 송신을의 결과를 처리한다.
public class USDataSource extends PageKeyedDataSource<Integer, UnSplash> {

    //로드할 첫 페이지
    private static final int FIRST_PAGE = 1;
    //Access Key - UnSplash개발자 계정생성 후 고유의 엑세스키 발급
    private static final String CLIENT_TOKEN = "ab2bd2d318fc4c8ba7bfb78423cc195ce71cc7ed1e584b2185f66f71d7848acb";

    //초기값 로드
    //loadInitial 메소드를 통해 한페이지의 데이터를 받는다.
    /**
     *
     * @param params 요청 된로드 크기를 포함한 초기로드에 대한 매개 변수
     * @param callback 초기로드 데이터를 수신하는 콜백
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, UnSplash> callback) {

        //Retrofit2로 Rest(Http)통신
        final Client.RestApiInterface restApiInterface= Client.getClient();
        restApiInterface.getListUnSplash(CLIENT_TOKEN,FIRST_PAGE).enqueue(new Callback<List<UnSplash>>() {

            /**
             *
             * @param call 서버에 요청내용
             * @param response 서버로부터 응답내용
             */
            //수신 된 HTTP 요청과 응답 호출
            @Override
            public void onResponse(@NonNull Call<List<UnSplash>> call, @NonNull Response<List<UnSplash>> response) {
                if(response.body()!=null){
                    //페이지수를 증가하여 요청
                    callback.onResult(response.body(),null,FIRST_PAGE+1);
                }
            }

            /**
             *
             * @param call 서버에 요청내용
             * @param t 예외처리 유도
             */
            //네트워크 예외가 서버와 통신 중이거나 요청을 작성하거나 응답을 처리하는 중 예기치 않은 예외가 발생한 경우에 호출
            @Override
            public void onFailure(@NonNull Call<List<UnSplash>> call, @NonNull Throwable t) {
            }
        });
    }

    //loadAfter 메소드를 통해 전 페이지를 로드
    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, UnSplash> callback) {
        Client.RestApiInterface restApiInterface= Client.getClient();

        restApiInterface.getListUnSplash(CLIENT_TOKEN,params.key).enqueue(new Callback<List<UnSplash>>() {
            @Override
            public void onResponse(@NonNull Call<List<UnSplash>> call, @NonNull Response<List<UnSplash>> response) {
                Integer BeforeKey=(params.key>1)?params.key-1:null;

                if(response.body()!=null){
                    //전 페이지 요청
                    callback.onResult(response.body(),BeforeKey);
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<UnSplash>> call, @NonNull Throwable t) {
            }
        });
    }

    //loadAfter 메소드를 통해 다음 페이지를 로드
    @Override
    public void loadAfter(@NonNull  final LoadParams<Integer> params, @NonNull final  LoadCallback<Integer, UnSplash> callback) {
        Client.RestApiInterface restApiInterface= Client.getClient();

        restApiInterface.getListUnSplash(CLIENT_TOKEN,params.key).enqueue(new Callback<List<UnSplash>>() {
            @Override
            public void onResponse(@NonNull Call<List<UnSplash>> call, @NonNull Response<List<UnSplash>> response) {
                Integer AfterKey=(params.key>1)?params.key+1:null;

                if(response.body()!=null){
                    //다음 페이지 요청
                    callback.onResult(response.body(),AfterKey);

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<UnSplash>> call, @NonNull Throwable t) {
            }
        });
    }
}
