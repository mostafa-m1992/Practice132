package com.shia.practice128.Activity;

import static com.shia.practice128.Class.Put.email;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class ActivityLogin extends AppCompatActivity {

    private TextView textTitle, textRegister;
    private ImageView imageBack;

    private EditText editEmail,editPass;
    private TextView textLogin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        findView();
    }

    private void findView() {
        textTitle = findViewById(R.id.textTitleActivity);
        textTitle.setText("صفحه ورود");
        imageBack = findViewById(R.id.imageBack);
        textRegister = findViewById(R.id.textRegister);
        editEmail=findViewById(R.id.edEmailLogin);
        editPass=findViewById(R.id.edPasswordLogin);
        textLogin=findViewById(R.id.textLogin);
        iconOnClick();
    }

    private void iconOnClick() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivity(intent);
            }
        });
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(editEmail.getText().toString(),editPass.getText().toString());
            }
        });
    }

    private void login(final String email, final String pass) {
        String url= Link.linkLogin;
        final ProgressDialog progressDialog=new ProgressDialog(ActivityLogin.this);

        progressDialog.show();

        Response.Listener<String> listener=new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("نام کاربری یا رمز عبور اشتباه میباشد!")){
                    Toast.makeText(ActivityLogin.this, response.toString(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else {
                    Toast.makeText(ActivityLogin.this, response.toString(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.putExtra(email,response.toString());
                    setResult(RESULT_OK,intent);
                    finish();

                    progressDialog.dismiss();
                }

            }
        };
        Response.ErrorListener errorListener=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityLogin.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        };
        StringRequest request=new StringRequest(Request.Method.POST,url,listener,errorListener){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put(email,email);
                map.put(Put.password,pass);
                return map;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}