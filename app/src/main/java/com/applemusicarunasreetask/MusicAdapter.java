package com.applemusicarunasreetask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder>  {
    Context  context;
    List<MusicResponse.Feed.MusicDetails> musicList;

    public  MusicAdapter(Context  context, List<MusicResponse.Feed.MusicDetails> musicList){
        this.context = context;
        this.musicList  = musicList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.music_item_layout, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.artistName.setText(musicList.get(i).getArtistName());
        myViewHolder.songName.setText(musicList.get(i).getName());
        String imageUrl = musicList.get(i).getArtworkUrl100();
        Picasso.get().load(imageUrl).networkPolicy(NetworkPolicy.NO_CACHE).into(myViewHolder.musicThumbnail);
    }

    @Override
    public int getItemCount() {
        return (musicList != null && musicList.size() > 0) ? musicList.size(): 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView artistName, songName;
        public ImageView musicThumbnail;

        public MyViewHolder(View view) {
            super(view);
            artistName = (TextView) view.findViewById(R.id.artistName);
            songName = (TextView) view.findViewById(R.id.songName);
            musicThumbnail = view.findViewById(R.id.musicThumbnail);
        }
    }
}
