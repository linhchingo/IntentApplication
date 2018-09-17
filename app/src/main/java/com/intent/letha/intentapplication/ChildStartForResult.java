package com.intent.letha.intentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class ChildStartForResult extends AppCompatActivity {
    private EditText edtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_start_for_result);
        edtResult = findViewById(R.id.edtResult);
    }


    public void changeTitleType(View view) {
        if (TextUtils.isEmpty(edtResult.getText())) {
            StartForResultActivity.showToas("Khong duong de trong!", this);
        } else {
            switch (view.getId()) {
                case R.id.btnUpper: backParent(StartForResultActivity.RESULT_CODE_UPPER);   break;
                case R.id.btnLower: backParent(StartForResultActivity.RESULT_CODE_LOWER);   break;
            }
        }
    }

    private void backParent(int reSultCode){
        Intent intent = getIntent();
        intent.putExtra("Text", edtResult.getText().toString());
        setResult(reSultCode, intent);
        finish();
    }
}
