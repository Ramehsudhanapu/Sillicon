package com.example.ramesh.sillicon.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.ramesh.sillicon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
public class VideosActivity extends AppCompatActivity {
    @BindView(R.id.display_stores)
    VideoView displayVideo;
    Uri video = Uri.parse("https://www.youtube.com/watch?v=DNKdP_k6QOs");
    @Override
    public void supportNavigateUpTo(@NonNull Intent upIntent) {
        super.supportNavigateUpTo(upIntent);
        finish();
    }
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        ButterKnife.bind(this);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        displayTeluguStories();
    }
    private void displayTeluguStories() {
        try {
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(displayVideo);
            displayVideo.setMediaController(mediaController);
            displayVideo.setVideoURI(video);
            displayVideo.requestFocus();
            displayVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (Exception ex)
        {
            ex.printStackTrace();
            Log.d("DisplayView",ex.getMessage());
        }
    }
    public Uri getVideo() {
        return video;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
           finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }


}
