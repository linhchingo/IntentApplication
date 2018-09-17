package com.intent.letha.intentapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StartForResultActivity extends AppCompatActivity {
    public static final int RESULT_CODE_UPPER = 100;
    public static final int RESULT_CODE_LOWER = 101;
    private final int REQUEST_CODE_TOP = 999;
    private final int REQUEST_CODE_BOTTOM = 998;
    private TextView tvTop, tvBot;

    public static void showToas(String s, Context context) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);

        tvBot = findViewById(R.id.tvBottom);
        tvTop = findViewById(R.id.tvTop);
    }

    public void changeTextView(View v) {
        switch (v.getId()) {
            case R.id.btnChangeTop:
                callChildResult(REQUEST_CODE_TOP);
                break;
            case R.id.btnChangeBot:
                callChildResult(REQUEST_CODE_BOTTOM);
                break;
        }
    }

    private void callChildResult(int requestCode) {
        Intent intent = new Intent(getApplicationContext(), ChildStartForResult.class);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       data.getStringExtra("Text");
        if (requestCode == REQUEST_CODE_TOP) changeTextType(resultCode,tvTop,data.getStringExtra("Text"));
        else if (requestCode == REQUEST_CODE_BOTTOM) changeTextType(resultCode,tvBot,data.getStringExtra("Text"));

    }

    private void changeTextType(int resultCode,TextView textView,String s){
        if (resultCode == RESULT_CODE_UPPER) textView.setText(s.toUpperCase());
        if (resultCode == RESULT_CODE_LOWER) textView.setText(s.toLowerCase());
    }
}
