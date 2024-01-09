package com.masum035.simple_tts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button speaker_button;
    EditText editor;
    TextToSpeech t1;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(t1 != null){
            t1.stop();
            t1.shutdown();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speaker_button = (Button) findViewById(R.id.speak_btn);
        editor = (EditText) findViewById(R.id.editTextTextMultiLine);

        t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.KOREA);

                }
            }
        });

        speaker_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = editor.getText().toString();
                t1.speak(txt,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}