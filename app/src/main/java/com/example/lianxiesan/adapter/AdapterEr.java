package com.example.lianxiesan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lianxiesan.R;
import com.example.lianxiesan.api.FzBean;
import com.example.lianxiesan.api.SjBean;
import com.example.lianxiesan.dao.DaoUtil;

import java.util.ArrayList;

/**
 * Created by 小乐乐 on 2019/6/23.
 */

public class AdapterEr extends RecyclerView.Adapter<AdapterEr.ViewHolder> {
    private ArrayList<SjBean> mList;
    private Context context;

    public AdapterEr(ArrayList<SjBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yixml, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mTvFoodStr.setText(mList.get(position).getFood_str());
        holder.mCob.setChecked(true);
        holder.mCob.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                } else {
                    SjBean sjBean1 = mList.get(position);
                    DaoUtil.getDaoUtil().deleteItem(sjBean1);
                    Toast.makeText(context, "删除", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView mTvFoodStr;
        CheckBox mCob;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            this.mTvFoodStr = (TextView) itemView.findViewById(R.id.tv_food_str);
            this.mCob = (CheckBox) itemView.findViewById(R.id.cob);
        }
    }

    public interface OnClickListener {
        void OnClickListener(int position);
    }

    private OnClickListener OnClickListener;

    public void setOnClickListener(AdapterEr.OnClickListener onClickListener) {
        OnClickListener = onClickListener;
    }
}
