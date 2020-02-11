package com.example.recyclermultipleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclermultipleview.Constants;
import com.example.recyclermultipleview.R;
import com.example.recyclermultipleview.model.Chat;
import com.example.recyclermultipleview.model.Video;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Object> mData;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public int getItemViewType(int position) {
        if (mData.get(position) instanceof Chat) {
            return Constants.TYPE_CHAT;
        } else if (mData.get(position) instanceof Video) {
            return Constants.TYPE_VIDEO;
        }
        return -1;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout;
        @NonNull
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case Constants.TYPE_CHAT:
                layout = R.layout.recyclerview_chat_row;
                View chatView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                viewHolder = new ChatViewHolder(chatView);
                break;
            case Constants.TYPE_VIDEO:
                layout = R.layout.recyclerview_video_row;
                View videoView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                viewHolder = new VideoViewHolder(videoView);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case Constants.TYPE_CHAT:
                Chat chat = (Chat) mData.get(position);
                ((ChatViewHolder) holder).showDetails(chat);
                break;
            case Constants.TYPE_VIDEO:
                Video video = (Video) mData.get(position);
                ((VideoViewHolder) holder).showDetails(video);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(ArrayList<Object> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        private TextView userNameTextView, TimeTextView;

        public ChatViewHolder(View itemView) {
            super(itemView);
            // Initiate view
            userNameTextView = (TextView) itemView.findViewById(R.id.tv_name);
            TimeTextView = (TextView) itemView.findViewById(R.id.tv_time);
        }

        public void showDetails(Chat chat) {
            // Attach values for each item
            String userName = chat.name;
            String Time = chat.time;
            userNameTextView.setText(userName);
            TimeTextView.setText(Time);
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private TextView userNameTextView, title, time;

        public VideoViewHolder(View itemView) {
            super(itemView);

            userNameTextView = (TextView) itemView.findViewById(R.id.tv_name);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            time = (TextView) itemView.findViewById(R.id.tv_time);
        }

        public void showDetails(Video video) {

            String vidoeName = video.name;
            String videoTitle = video.title;
            String videoTime = video.time;
            userNameTextView.setText(vidoeName);
            title.setText(videoTitle);
            time.setText(videoTime);
        }
    }
}