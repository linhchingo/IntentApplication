package com.intent.letha.intentapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        Uri uri = intent.getData();

        textView.setText(
                "Scheme: "+uri.getScheme()+"\n"+
                        "Host: "+uri.getHost()+"\n"+
                        "Param1: "+uri.getPathSegments().get(0)+"\n"+
                        "Param2: "+uri.getPathSegments().get(1)+"\n"+
                        "Action: "+getIntent().getAction()
        );
    }
}
