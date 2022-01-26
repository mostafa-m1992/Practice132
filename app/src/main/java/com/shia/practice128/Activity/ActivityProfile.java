package com.shia.practice128.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shia.practice128.Class.Put;
import com.shia.practice128.R;

public class ActivityProfile extends AppCompatActivity {

    private Button btnEdit, btnFav, btnExit;
    private ImageView imageBack;
    private TextView textTilte;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findView();
    }

    private void findView() {

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityProfile.this,ActivityEditProfile.class));
            }
        });

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getSharedPreferences(Put.shared, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(Put.email, "ورود/ثبت نام");
                editor.apply();
                Intent intent = new Intent();
                intent.putExtra(Put.email, "ورود/ثبت نام");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}