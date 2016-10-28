package com.hebrf.template.mvp.ui.adapter;

import android.view.View;

import com.hebrf.template.R;
import com.hebrf.template.mvp.model.entity.User;
import com.hebrf.template.mvp.ui.holder.BaseHolder;
import com.hebrf.template.mvp.ui.holder.UserItemHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class UserAdapter extends DefaultAdapter<User> {
    public UserAdapter(List<User> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<User> getHolder(View v) {
        return new UserItemHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycle_list;
    }
}