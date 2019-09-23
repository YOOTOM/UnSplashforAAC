package com.yootom.unsplashforaac.respository.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.yootom.unsplashforaac.R;
import com.yootom.unsplashforaac.data.model.UnSplash;

import butterknife.BindView;
import butterknife.ButterKnife;

//RecyclerItemadapter PagedList로부터 데이터를 UI에 나타내기 위한 RecyclerView.Adapter의 구현체 클래스
public class RecyclerItemadapter extends PagedListAdapter<UnSplash, RecyclerItemadapter.RecyclerItemViewHolder> {

    private Context context;

    public RecyclerItemadapter(Context context) {
        super(DIFF_CALLBACK);

        this.context = context;
    }

    //DiffUtil은 RecyclerView의 효율적인 갱신 처리를 편리하게 다룰 수 있도록 제공하는 util 클래스
    //DiffUtil을 이용해 이전 리스트와 비교해 변경된 요소들만을 업데이트
    private static DiffUtil.ItemCallback<UnSplash> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<UnSplash>() {
                //아이템이 동일한가의 여부의 콜백함수
                //아이템들이 고유한 ID값을 가질 때, 해당 메서드를 구현해 비교처리 하도록 한다.
                @Override
                public boolean areItemsTheSame(@NonNull UnSplash oldItem, @NonNull UnSplash newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                //아이템의 내용이 동일한가 여부의 콜백함수
                //areItemsTheSame이 true로 리턴되었을 때만 수행된다.
                //DiffUtil이 equal 비교를 할 때 사용한다.
                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull UnSplash oldItem, @NonNull UnSplash newItem) {
                    return oldItem.equals(newItem);
                }
            };

    //지정된 아이템의 새로운 아이템이 필요할 때 호출
    @NonNull
    @Override
    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new RecyclerItemViewHolder(v);
    }

    //지정된 위치에 데이터를 표시하기 위해 RecyclerView에 의해 호출
    @Override
    public void onBindViewHolder(RecyclerItemViewHolder holder, int position) {
        UnSplash item = getItem(position);
        assert item != null;
        holder.set(item);
    }


    //RecyclerItemViewHolder은 RecyclerView 내의 구현할 아이템의 UI 설정
    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {

        //‘Butter Knife’ 라이브러리을 이용하여 리싸이클 뷰를 갱신한다.
        // findViewById를 매번 해주어야 하는 번거로움을 줄이며, 속도향상에 도움이된다.
        @BindView(R.id.image)
        ImageView imagebanner;
        @BindView(R.id.proile)
        ImageView proilepic;
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.divSectiontwo)
        LinearLayout divSectiontwo;

        public RecyclerItemViewHolder(View itemView) {
            super(itemView);
            //‘Butter Knife’ 라이브러리을 이용하여 리싸이클 뷰를 갱신한다.
            //findViewById를 매번 해주어야 하는 번거로움을 줄이며, 속도향상에 도움이된다.
            ButterKnife.bind(this, itemView);
        }

        //UI 설정
        public void set(UnSplash unSplash) {
            //유저 네임 설정
            if (!checkNull(unSplash.getUser().getUsername())) {
                username.setText(unSplash.getUser().getUsername());
            } else {
                username.setText("NULL");
            }

            //프로파일 이미지 설정
            if (!checkNull(unSplash.getUser().getProfileImage().getLarge())) {

                //Glide 는 사용자가 대부분의 요청을 한 줄로 만들 수 있는 간단하고 유연한 API
                //참조문서 : https://kofboy2000.github.io/glide-doc-kr/doc/getting-started.html
                /*
                Glide.with(fragment)
                        .load(url)
                        .apply (requestOptions)
                        .into(imageView);
                */
                Glide.with(context)
                        //이미지 불러오기
                        .load(unSplash
                                .getUser()
                                .getProfileImage()
                                .getLarge())
                        //이미지 변형하기
                        //RequestOptions 를 사용하면 정의한 옵션을 개별 요청(request) 마다 공유해서 사용 할 수 있음
                        .apply(new RequestOptions()
                                // RoundedCorners(int roundingRadius) - 모서리 반경 설정 (기기 별 픽셀).
                                .transform(new RoundedCorners(16)))
                        //이미지뷰에 적용하기
                        .into(proilepic);
            }
            //이미지 배너 설정
            if (!checkNull(unSplash.getUrls().getFull())) {
                Glide.with(context)
                        //이미지 불러오기
                        .load(unSplash
                                .getUrls()
                                .getFull())
                        //이미지 변형하기
                        .apply(new RequestOptions()
                                //.override(int width, int height)
                                //리소스를로드하는 데 사용할 너비(픽셀)과 높이(픽셀)
                                .override(600, 200))
                        //이미지뷰에 적용하기
                        .into(imagebanner);
            }
        }
    }

    //데이터의 값이 null값 인지를 체크한다.
    public boolean checkNull(String input) {
        if (TextUtils.isEmpty(input)) {
            return true;

        }
        return false;
    }


}