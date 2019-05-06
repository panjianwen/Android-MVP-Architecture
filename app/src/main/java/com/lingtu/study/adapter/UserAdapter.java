package com.lingtu.study.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lingtu.study.R;
import com.lingtu.study.databinding.ItemMainUserBinding;
import com.lingtu.study.entity.User2;

import java.util.List;

/**
 * Created by pan on 2019/4/28.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    private List<User2> mUsers;

    public UserAdapter(List<User2> users) {
        mUsers = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMainUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main_user, parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemMainUserBinding binding=DataBindingUtil.getBinding(holder.itemView);
        User2 user = mUsers.get(position);
        binding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return mUsers == null ? 0 : mUsers.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }

    }

}
