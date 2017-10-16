package me.utteiku.ryugu.juzu.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.databinding.CellNotificationBinding;
import me.utteiku.ryugu.juzu.model.Notification;

/**
 * Created by ryugu on 2017/08/21.
 */

public class NotificationAdapter extends RecyclerView.Adapter< NotificationAdapter.ViewHolder>{

    private List<Notification> notifications = new ArrayList<>();
    private ClickListener listener;

    public interface ClickListener {
        void onClickItem(Notification notification, View view);
    }

    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_notification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Notification notification = notifications.get(position);
        holder.binding.notificationId.setText("ID:" + String.valueOf( notification.getId() ));
        holder.binding.notificationContent.setText("content:" + String.valueOf(notification.getContent()));
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (listener != null ){
                    listener.onClickItem(notification, view);
                }
            }
        });
    }

    public void add(Notification notification){
        notifications.add(notification);
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CellNotificationBinding binding;
        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
