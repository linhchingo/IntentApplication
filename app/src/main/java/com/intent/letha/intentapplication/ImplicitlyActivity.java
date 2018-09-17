package com.intent.letha.intentapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ImplicitlyActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PERMISSIONS_REQUEST_PHONE_CALL = 100;
    private static String[] PERMISSIONS_PHONECALL = {Manifest.permission.CALL_PHONE};
    private int[] idButton = {R.id.btnCallBrowser, R.id.btnSendmsg, R.id.btnViewContact, R.id.btnCallSomeOne, R.id.btnEditContact,R.id.btnOpenGallery};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicitly);

        init();
    }

    private void init() {

        for (int id : idButton
                ) {
            Button buttonTemp = findViewById(id);
            buttonTemp.setOnClickListener(this);
        }

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnCallBrowser:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/topics/permissions/overview"));
               /* intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://news.zing.vn/"));*/
                startActivity(intent);
                break;
            case R.id.btnSendmsg:
               /* intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"hello!");
                intent.setType("text/plain");

                //Tieu de gui tin nhan
               *//* Intent chooser = Intent.createChooser(intent,"Hello!");
                startActivity(chooser);*/

                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("sms:0903570367"));
                intent.putExtra("sms_body", "hello!");
                startActivity(intent);

                break;
            case R.id.btnViewContact:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;
            case R.id.btnCallSomeOne:
                call();

                break;
            case R.id.btnEditContact:
                intent.setAction(Intent.ACTION_EDIT);
                intent.setData(Uri.parse("content://contacts/people/50"));
                startActivity(intent);
                break;
            case R.id.btnOpenGallery:
                intent.setAction(Intent.ACTION_PICK);
//                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivity(intent);
                break;

        }

    }

    public void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    private void call() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_PHONE_CALL);
        } else {
            //Open call function
            String number = "+841699915380";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_PHONE_CALL) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                call();
            } else {
                Toast.makeText(this, "Sorry!!! Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

