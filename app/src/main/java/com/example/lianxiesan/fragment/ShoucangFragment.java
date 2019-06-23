package com.example.lianxiesan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lianxiesan.R;
import com.example.lianxiesan.adapter.AdapterEr;
import com.example.lianxiesan.adapter.AdapterRe;
import com.example.lianxiesan.api.SjBean;
import com.example.lianxiesan.dao.DaoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoucangFragment extends Fragment {


    private View view;
    private RecyclerView mRvsc;
    public static ArrayList<SjBean> mList;
    public static AdapterEr mAdapterEr;

    public ShoucangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shoucang, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRvsc = (RecyclerView) inflate.findViewById(R.id.rvsc);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvsc.setLayoutManager(manager);

        mList = new ArrayList<>();
        mAdapterEr = new AdapterEr(mList, getActivity());
        mRvsc.setAdapter(mAdapterEr);
        initxianshi();
    }

    public static void initxianshi() {
        mList.clear();
        List<SjBean> sjBeans = DaoUtil.getDaoUtil().LoallAll();
        mList.addAll(sjBeans);
        mAdapterEr.notifyDataSetChanged();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            initxianshi();
        }
        else {
            if (mList!=null&&mList.size()>0){
                mList.clear();
            }
        }
    }
}
