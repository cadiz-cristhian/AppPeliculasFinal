package com.example.apppeliculasfinal.UI.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.apppeliculasfinal.R;
import com.example.apppeliculasfinal.data.InformacionProvider;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class Youtube extends AppCompatActivity {

    String t = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        getSupportActionBar().hide();
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            t = extras.getString("URL");
        }
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {


                youTubePlayerView.enterFullScreen();
                youTubePlayer.loadVideo(t, 0);
            }
        });
    }
}