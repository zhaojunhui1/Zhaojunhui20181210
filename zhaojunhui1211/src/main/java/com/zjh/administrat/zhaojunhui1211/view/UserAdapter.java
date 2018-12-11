package com.zjh.administrat.zhaojunhui1211.view;

import android.content.Context;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.view.DragAndDropPermissions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zjh.administrat.zhaojunhui1211.R;
import com.zjh.administrat.zhaojunhui1211.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    private List<UserBean.DataBean> mData;
    private Context mContext;

    public UserAdapter(Context mContext) {
        this.mContext = mContext;
        mData = new ArrayList<>();
    }

    public void setDatas(List<UserBean.DataBean> data) {
        mData.clear();
        if (data != null){
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public UserBean.DataBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder mHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            mHolder = new Holder(convertView);
        }else {
            mHolder = (Holder) convertView.getTag();
        }
        mHolder.bindDatas(getItem(position));
        return convertView;
    }

    class Holder{
        ImageView imageView;
        TextView textView1, textView2;

        public Holder(View itemView){
            imageView = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            itemView.setTag(this);
        }

        public void bindDatas(UserBean.DataBean item) {
          textView1.setText(item.getTitle());
          textView2.setText(item.getCreatetime());
          if (imageView != null){
              ImageLoader.getInstance().displayImage(item.getIconHttp(), imageView);
          }
        }
    }

}
