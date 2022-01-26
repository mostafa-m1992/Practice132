package com.shia.practice128.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
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
import com.shia.practice128.R;

import java.util.HashMap;
import java.util.Map;

public class ActivityRegister extends AppCompatActivity {

    private TextView textTitle, textRegisterButton;
    EditText editEmail, editPass;
    CheckBox checkBoxPass;
    ImageView imageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findView();
    }

    private void findView() {
        textTitle = findViewById(R.id.textTitleActivity);
        textTitle = findViewById(R.id.textTitleActivity);
        textRegisterButton = findViewById(R.id.textRegisterButton);
        textTitle.setText("ثبت نام");
        editEmail = findViewById(R.id.edEmailRegister);
        editPass = findViewById(R.id.edPasswordRegister);
        checkBoxPass = findViewById(R.id.chkPass);
        imageBack = findViewById(R.id.imageBack);
        iconOnClick();
    }

    private void iconOnClick() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        checkBoxPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBoxPass.isChecked()){
                    editPass.setInputType(InputType.TYPE_CLASS_TEXT);
                }else {
                    editPass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
            }
        });
        textRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(editEmail.getText().toString().trim(),editPass.getText().toString().trim());
            }
        });
    }

    private void register(final String email, final String pass) {
        String url = Link.linkRegister;
        final ProgressDialog progressDialog=new ProgressDialog(ActivityRegister.this);
        editEmail.setText("");
        editPass.setText("");
        progressDialog.show();

        Response.Listener<String> listener=new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ActivityRegister.this, response.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        };
        Response.ErrorListener errorListener=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityRegister.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        };
        StringRequest request=new StringRequest(Request.Method.POST,url,listener,errorListener){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("email",email);
                map.put("password",pass);
                return map;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}