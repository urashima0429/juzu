package me.utteiku.ryugu.juzu.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.utteiku.ryugu.juzu.Gender;
import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.databinding.CellFriendBinding;
import me.utteiku.ryugu.juzu.model.Person;

/**
 * Created by ryugu on 2017/08/21.
 */

public class FriendAdapter extends RecyclerView.Adapter< FriendAdapter.ViewHolder>{

    private List<Person> friends = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_friend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person friend = friends.get(position);
        holder.binding.personName.setText(friend.getName());
        holder.binding.personAge.setText("Age:" + String.valueOf( friend.getAge() ));
        holder.binding.personGender.setText(friend.getGender().getValue());
        holder.binding.personIntroduce.setText(friend.getIntroduction());
    }

    public void add(Person friend){
        friends.add(friend);
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
