package com.yootom.unsplashforaac.data;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.yootom.unsplashforaac.data.model.UnSplash;

// 내부적으로 DataSource의 인스턴스 생성을 제어하기 위한 클래스
// UnSplashDataFactory은 DataSource.Factory을 상속받아 DataSource를 감싸서 LivePagedListBuilder 로 넘는 작업을 한다.

// *프로세스
// 1. LiveData를 사용하기위헤 자식 클래스이며, Public메서드를 가지고 있는 MutableLiveData을 객체생성한다.
// 2. MutableLiveData는 setValue(T) 와 postValue(T) 메소드를 가지고 있어서 이를 통해 데이터를 변경할 수 있다.
// 3. UnSplashRespository로 생성한 DataSource를 함수 호출을 통해 넘긴다.

public class USDataFactory extends DataSource.Factory {

    //MutableLiveData 객체 초기화
    private MutableLiveData<PageKeyedDataSource<Integer, UnSplash>> liveData = new MutableLiveData<>();

    //DataSource 생성
    @Override
    public DataSource<Integer, UnSplash> create() {
        USDataSource dataSource = new USDataSource();
        liveData.postValue(dataSource);
        return dataSource;
    }
}
