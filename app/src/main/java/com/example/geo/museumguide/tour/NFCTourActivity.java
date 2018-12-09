package com.example.geo.museumguide.tour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.geo.museumguide.R;
import com.example.geo.museumguide.connection.artefact.GetArtifactByIdAndShowTask;
import com.example.geo.museumguide.connection.photo_artefact.GetPhotoArtefactTask;
import com.example.geo.museumguide.gallery.GalleryActivity;
import com.example.geo.museumguide.model.Artefact;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

/**
 * Created by Geo on 1/28/2017.
 */

public class NFCTourActivity extends Activity {

    TextView title;
    TextView author;
    TextView year;
    TextView description;

    ImageButton playBtn;
    ImageButton pauseBtn;
    ImageButton galleryBtn;
    TextToSpeech t1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nfc_tour_layout);
        final ArtefactBean artefact= (ArtefactBean) getIntent().getExtras().get("artefact");

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });


        final Long id=artefact.getId();
        title=(TextView) findViewById(R.id.titleT1);
        author=(TextView) findViewById(R.id.authorT1);
        year=(TextView) findViewById(R.id.yearT1);
        description=(TextView) findViewById(R.id.descriptionT1);

        title.setText(artefact.getTitle());
        author.setText(artefact.getAuthor());
        year.setText(String.valueOf(artefact.getYear()));
        description.setText(artefact.getDescription());

        playBtn=(ImageButton)findViewById(R.id.playBtn);
        pauseBtn=(ImageButton)findViewById(R.id.pauseBtn);
        galleryBtn=(ImageButton)findViewById(R.id.galleryBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=artefact.getTitle()+"   "+"   "+artefact.getAuthor()+"     "+artefact.getYear()+"     "+artefact.getDescription();
                t1.speak(message, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t1 !=null){
                    t1.stop();
                }
            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              new GetPhotoArtefactTask(NFCTourActivity.this).execute(id);
            }
        });
    }

    @Override
    protected void onPause() {

        if (t1 != null) {
            t1.stop();
        }
        super.onPause();
    }
}
