package com.yootom.unsplashforaac.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.yootom.unsplashforaac.R;
import com.yootom.unsplashforaac.data.model.UnSplash;
import com.yootom.unsplashforaac.respository.adapter.RecyclerItemadapter;
import com.yootom.unsplashforaac.viewmodel.USViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    //‘Butter Knife’ 라이브러리을 이용하여 리싸이클 뷰를 갱신한다.
    //findViewById를 매번 해주어야 하는 번거로움을 줄이며, 속도향상에 도움이된다.
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    USViewModel unSplashViewModel;
    private RecyclerItemadapter recyclerItemadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Butter Knife bind
        ButterKnife.bind(this);

        //사용하려는 레이아웃 설정
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        //각 Item 들이 RecyclerView 의 전체 크기를 변경여부
        recyclerview.setHasFixedSize(true);

        //androidViewModel생성
        unSplashViewModel = ViewModelProviders.of(this).get(USViewModel.class);

        recyclerItemadapter = new RecyclerItemadapter(this);


        unSplashViewModel.getUnSplashList().observe(this, new Observer<PagedList<UnSplash>>() {
            @Override
            public void onChanged(@Nullable PagedList<UnSplash> unSplashes) {
                recyclerItemadapter.submitList(unSplashes);
            }
        });
        recyclerview.setAdapter(recyclerItemadapter);
    }
}
