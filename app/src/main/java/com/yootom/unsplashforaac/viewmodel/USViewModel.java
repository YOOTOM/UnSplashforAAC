package com.yootom.unsplashforaac.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.yootom.unsplashforaac.data.model.UnSplash;
import com.yootom.unsplashforaac.respository.USRespository;

public class USViewModel extends AndroidViewModel {

    private LiveData<PagedList<UnSplash>> list;

    public USViewModel(@NonNull Application application) {
        super(application);

        //USRespository 초기화.
        USRespository usRespository = new USRespository();

        //실시간 데이터를 담는 LiveData<PagedList<UnSplash>> 타입 변수 생성
        list = usRespository.getUnSplashedPagedListLiveData();

    }

    //뷰에게 갱신할 데이터를 넘기는 함수
    public LiveData<PagedList<UnSplash>> getUnSplashList() {
        return list;
    }
}
