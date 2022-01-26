package com.shia.practice128.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.shia.practice128.Class.Link;
import com.shia.practice128.Class.MySingleton;
import com.shia.practice128.Class.Put;
import com.shia.practice128.R;

import java.util.HashMap;
import java.util.Map;

public class ActivityEditProfile extends AppCompatActivity {

    private TextView textEdit;
    private EditText edusername, edaddress, edphone;
    private ImageView imageback;
    private TextView textTitle;

    SharedPreferences preferences;
    private String emailEdit;

    SharedPreferences preferences2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        findview();

        preferences=getSharedPreferences(Put.shared,MODE_PRIVATE);
        emailEdit=preferences.getString(Put.email,"ایمیل");
    }

    private void findview() {

        edaddress = findViewById(R.id.edAddress);
        edphone = findViewById(R.id.edPhone);
        edusername = findViewById(R.id.edUsername);
        textEdit = findViewById(R.id.textEdit);
        imageback = findViewById(R.id.imageBack);
        textTitle = findViewById(R.id.textTitleActivity);
        textTitle.setText("ویرایش اطلاعات");
        preferences2 = getSharedPreferences(Put.shared2,MODE_PRIVATE);
        edusername.setText(preferences2.getString(Put.username,""));
        edphone.setText(preferences2.getString(Put.phone,""));
        edaddress.setText(preferences2.getString(Put.address,""));

        onclick();
    }

    private void onclick() {
        imageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=edusername.getText().toString().trim();
                String address=edaddress.getText().toString().trim();
                String phone=edphone.getText().toString().trim();
                if(user.equalsIgnoreCase("") || address.equalsIgnoreCase("") || phone.equalsIgnoreCase("")){
                    Toast.makeText(ActivityEditProfile.this, "پرکردن تمامی فیلدها الزامیست!", Toast.LENGTH_SHORT).show();
                }else {
                    editProfile(emailEdit,user,phone,address);
                }
            }
        });
    }

    private void editProfile(final String email, final String username, final String phone, final String address){
        String url= Link.linkEdit;
        final ProgressDialog progressDialog=new ProgressDialog(ActivityEditProfile.this);
        progressDialog.show();

        Response.Listener<String> listener=new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.toString().equals("1")){
                    preferences2=getSharedPreferences(Put.shared2,MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences2.edit();
                    editor.putString(Put.username,username);
                    editor.putString(Put.phone,phone);
                    editor.putString(Put.address,address);
                    editor.apply();
                    Toast.makeText(ActivityEditProfile.this, "به روز رسانی انجام شد", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        };

        Response.ErrorListener errorListener=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityEditProfile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        };

        StringRequest request=new StringRequest(Request.Method.POST,url,listener,errorListener){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put(Put.email,email);
                map.put(Put.username,username);
                map.put(Put.phone,phone);
                map.put(Put.address,address);
                return map;
            }
        };

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }
}