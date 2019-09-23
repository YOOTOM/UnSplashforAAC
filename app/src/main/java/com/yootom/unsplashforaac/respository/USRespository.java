package com.yootom.unsplashforaac.respository;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.yootom.unsplashforaac.data.USDataFactory;
import com.yootom.unsplashforaac.data.model.UnSplash;

//USRespository는 LiveData로 Wrapping된 PagedList으로 실시간 데이터 모니터링이 가능하도록 설정하는 클래스
public class USRespository {

    private LiveData<PagedList<UnSplash>> unSplashedPagedListLiveData;

    public USRespository() {

        //USDataFactory 객체 생성
        USDataFactory dataSource = new USDataFactory();

        //PagedList.Config.Builder를 이용해 PagedList가 데이터를 불러오는 옵션을 작성
        PagedList.Config Pconfig = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)//PagedList에서 null 자리 표시자를 비활성화여부
                .setPageSize(10) //DataSource에서 한 번에로드 된 항목 수를 정의
                .build();

        //LivePagedListBuilder에 Page 속성, DataSource를 정의하고 빌드를 하면 LiveData<PagedList<Item>> 타입을 반환을 합니다.
        // 그리고 객체 생성을 합니다.
        unSplashedPagedListLiveData = new LivePagedListBuilder(dataSource, Pconfig).build();
    }

    //실시간으로 갱신된 데이터를 전달하는 함수
    public LiveData<PagedList<UnSplash>> getUnSplashedPagedListLiveData() {
        return unSplashedPagedListLiveData;
    }
}

