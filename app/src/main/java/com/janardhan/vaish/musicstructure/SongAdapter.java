package com.janardhan.vaish.musicstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter (Activity context, ArrayList<Song> songArrayList){
        super(context, 0, songArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);
        TextView songTextView = listItemView.findViewById(R.id.song_text_view);

        assert currentSong != null;

        //Set the song name
        if(currentSong.getSongName() != null) {
            songTextView.setText(currentSong.getSongName());
        }

        TextView artistTextView = listItemView.findViewById(R.id.artist_text_view);

        //Set the artist names
        if(currentSong.getArtistName() != null) {
            artistTextView.setText(currentSong.getArtistName());
        }

        ImageView songImageView = listItemView.findViewById(R.id.song_image);

        if (currentSong.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            songImageView.setImageResource(currentSong.getImageResourceId());
            // Make sure the view is visible
            songImageView.setVisibility(View.VISIBLE);
        }

        return listItemView;
    }
}