package com.janardhan.vaish.musicstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a list of words
        final ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Aaya Na Tu","Arjun Kanungo, Momina Mustehsan",R.drawable.song1));
        songs.add(new Song("Faded","Alan Walker",R.drawable.song2));
        songs.add(new Song("Soulmate","Justin Timberlake",R.drawable.song3));
        songs.add(new Song("Paniyon Sa","Atif Aslam, Tulsi Kumar",R.drawable.song4));
        songs.add(new Song("Tareefan","Qaran Ft. Badshah",R.drawable.song5));
        songs.add(new Song("Ondu Malebillu","Armaan Malik, Shreya Ghoshal",R.drawable.song6));
        songs.add(new Song("Belageddu","Vijay Prakash",R.drawable.song7));

        SongAdapter songAdapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.list);


        if (listView != null) {
            listView.setAdapter(songAdapter);
        }

        //Start the Now Playing Activity when a song item is clicked by passing the song object
        if (listView != null) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // Get the {@link Song} object at the given position the user clicked on
                    Song song = songs.get(position);
                    //Passing object using Parcelable
                    Intent intent = new Intent(MainActivity.this, SongActivity.class);
                    intent.putExtra("sampleObject", song);
                    startActivity(intent);
                }
            });
        }

    }
}
