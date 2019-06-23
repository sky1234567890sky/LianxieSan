package com.example.lianxiesan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lianxiesan.R;
import com.example.lianxiesan.adapter.AdapterRe;
import com.example.lianxiesan.api.FzBean;
import com.example.lianxiesan.api.Lei;
import com.example.lianxiesan.api.SjBean;
import com.example.lianxiesan.dao.DaoUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class WodeFragment extends Fragment {


    private View view;
    private RecyclerView mRv;
    private ArrayList<FzBean.DataBean> mList;
    private AdapterRe mAdapterRe;

    public WodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_wode, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(manager);

        mList = new ArrayList<>();
        mAdapterRe = new AdapterRe(mList, getContext());
        mRv.setAdapter(mAdapterRe);

        initjiexi();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            initjiexi();
        }
        else {
            if (mList!=null&&mList.size()>0){
                mList.clear();
            }
        }
    }

    private void initjiexi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Lei.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Lei lei = retrofit.create(Lei.class);
        lei.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FzBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FzBean fzBean) {
                        List<FzBean.DataBean> data = fzBean.getData();
                        mList.addAll(data);
                        mAdapterRe.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag", "onError: "+e );
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
