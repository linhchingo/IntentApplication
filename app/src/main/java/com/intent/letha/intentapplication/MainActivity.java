package com.intent.letha.intentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Book book;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        book = new Book("B01","Tieng Viet 1",2018);
        string = "telegrap";
    }

    public void toChild(View v){
        Bundle bundle = new Bundle();
        bundle.putString("dataString",string);
        bundle.putSerializable("dataBook",book);

        Intent intent = new Intent(getApplicationContext(),ChildActivity.class);
        intent.putExtra("bundleInParent",bundle);
        startActivity(intent);

    }
}
