package me.utteiku.ryugu.juzu.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.databinding.CellFriendBinding;
import me.utteiku.ryugu.juzu.model.Friend;

/**
 * Created by ryugu on 2017/08/21.
 */

public class FriendAdapter extends RecyclerView.Adapter< FriendAdapter.ViewHolder>{

    private List<Friend> friends = new ArrayList<>();
    private ClickListener listener;

    public interface ClickListener {
        void onClickItem(Friend friend, View view);
    }

    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_friend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Friend friend = friends.get(position);
        holder.binding.personName.setText(friend.getName());
        holder.binding.personAge.setText("Age:" + String.valueOf( friend.getAge() ));
        holder.binding.personGender.setText(friend.getGender().getValue());
        holder.binding.personIntroduce.setText(friend.getIntroduction());
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (listener != null){
                    listener.onClickItem(friend, view);
                }
            }
        });
    }

    public void add(Friend friend){
        friends.add(friend);
    }
    public void addAll(List<Friend> friendList){
        for (Friend friend : friendList) {
            friends.add(friend);
        }
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CellFriendBinding binding;
        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
