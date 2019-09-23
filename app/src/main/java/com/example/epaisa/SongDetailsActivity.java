package com.example.epaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.epaisa.Model.SongResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SongDetailsActivity extends AppCompatActivity {

    TextView txt_ArtistName,txt_CollectionPrice,CollectionName,txt_Country,txt_actionName;
    ImageView img_back;
    CircleImageView edit_profile_image;
    Button btn_playsong;
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        try {

            txt_actionName = findViewById(R.id.txt_actionName);
            img_back = findViewById(R.id.img_back);
            txt_ArtistName = findViewById(R.id.txt_ArtistName);
            txt_CollectionPrice = findViewById(R.id.txt_CollectionPrice);
            CollectionName = findViewById(R.id.CollectionName);
            txt_Country = findViewById(R.id.txt_Country);
            edit_profile_image = findViewById(R.id.edit_profile_image);
            btn_playsong = findViewById(R.id.btn_playsong);

            //Parse data from intent
            Intent data = getIntent();
            String stringLocation = data.getStringExtra("songDetails");
            final SongResponse.Result ObjSong = new Gson().fromJson(stringLocation, SongResponse.Result.class);
            Log.d("@tul","Song data:- " +ObjSong);

            //passing data to function
            setSongDetailsData(ObjSong);

            img_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

            btn_playsong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    btn_playsong.setEnabled(false);
                    mPlayer = new MediaPlayer();
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    try{

                        // Set the audio data source
                        mPlayer.setDataSource(ObjSong.getPreviewUrl());

                        // Prepare the media player
                        mPlayer.prepare();

                        // Start playing audio from http url
                        mPlayer.start();

                        // Inform user for audio streaming
                        Toast.makeText(SongDetailsActivity.this,"Playing",Toast.LENGTH_LONG).show();
                    }catch (IOException e){
                        // Catch the exception
                        e.printStackTrace();
                    }catch (IllegalArgumentException e){
                        e.printStackTrace();
                    }catch (SecurityException e){
                        e.printStackTrace();
                    }catch (IllegalStateException e){
                        e.printStackTrace();
                    }

                    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            Toast.makeText(SongDetailsActivity.this,"End",Toast.LENGTH_LONG).show();
                            btn_playsong.setEnabled(true);
                        }
                    });

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Set responsive data
    private void setSongDetailsData(SongResponse.Result objSong) {

        if (objSong.getArtistName() != null){
            txt_ArtistName.setText(objSong.getArtistName());
            txt_actionName.setText(objSong.getArtistName());
        }

        if (objSong.getCollectionPrice() != null){
            txt_CollectionPrice.setText("\u0024"+objSong.getCollectionPrice());
        }

        if (objSong.getCollectionName() != null){
            CollectionName.setText(objSong.getCollectionName());
        }

        if (objSong.getCountry() != null){
            txt_Country.setText(objSong.getCountry());
        }

        if (objSong.getArtworkUrl100() != null) {

            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(SongDetailsActivity.this));

            ImageLoader imageLoader = ImageLoader.getInstance();

            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .resetViewBeforeLoading(true) //ic_shop
                    .showImageForEmptyUri(R.color.gray) //ic_group_defaulting
                    .showImageOnFail(R.color.gray)
                    .showImageOnLoading(R.color.gray).build();


            imageLoader.displayImage(objSong.getArtworkUrl100(), edit_profile_image, options);

        } else {
            edit_profile_image.setImageResource(R.color.gray);
        }

    }
}
