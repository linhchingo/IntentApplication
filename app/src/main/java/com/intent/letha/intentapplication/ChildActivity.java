package com.intent.letha.intentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    private TextView tvShowDataIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);


        tvShowDataIntent = findViewById(R.id.tvShowDataIntent);
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("bundleInParent");
        Book book = (Book) bundle.getSerializable("dataBook");
        String s = bundle.getString("dataString");
        tvShowDataIntent.setText(book.getMaBook()+"     "+book.getTenBook()+"       "+book.getNamSX()+"     "+s);


    }

    public void finishChild(View v){
        finish();
    }
}
