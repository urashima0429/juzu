package me.utteiku.ryugu.juzu.views.Huntee;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.databinding.CellHunteeBinding;
import me.utteiku.ryugu.juzu.model.Huntee;

/**
 * Created by ryugu on 2017/08/21.
 */

public class HunteeAdapter extends RecyclerView.Adapter< HunteeAdapter.ViewHolder>{

    private List<Huntee> huntees = new ArrayList<>();
    private ClickListener listener;

    public interface ClickListener {
        void onClickItem(Huntee huntee, View view);
    }

    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_huntee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Huntee huntee = huntees.get(position);
        holder.binding.name.setText(huntee.name);
        holder.binding.age.setText("Age:" + String.valueOf( huntee.age ));
        holder.binding.gender.setText(huntee.gender.getValue());
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (listener != null){
                    listener.onClickItem(huntee, view);
                }
            }
        });
    }

    public void add(Huntee huntee){
        huntees.add(huntee);
    }
    public void addAll(List<Huntee> hunteeList){
        for (Huntee huntee : hunteeList) {
            huntees.add(huntee);
        }
    }

    @Override
    public int getItemCount() {
        return huntees.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CellHunteeBinding binding;
        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
