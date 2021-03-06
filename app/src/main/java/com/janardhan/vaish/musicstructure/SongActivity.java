package com.janardhan.vaish.musicstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Song song = (Song) intent.getParcelableExtra("sampleObject");

        //Now Playing Screen displaying the name of the song, the artists' names and an image
        TextView songTextView = findViewById(R.id.song_text_view);
        TextView artistTextView = findViewById(R.id.artist_text_view);
        ImageView songImageView = findViewById(R.id.song_image_view);

        songTextView.setText(song.getSongName());
        artistTextView.setText(song.getArtistName());
        songImageView.setImageResource(song.getImageResourceId());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
