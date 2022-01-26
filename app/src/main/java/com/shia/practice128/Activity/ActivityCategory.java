package com.shia.practice128.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.shia.practice128.Adapters.AdapterCategory;
import com.shia.practice128.Class.Link;
import com.shia.practice128.Class.MySingleton;
import com.shia.practice128.Models.ModelCategory;
import com.shia.practice128.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ActivityCategory extends AppCompatActivity {

    private RecyclerView recyclerView;
    AdapterCategory adapterCategory;
    List<ModelCategory> modelCategories = new ArrayList<>();
    private ImageView imageBack;
    private TextView textTilte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.recyCategory);
        adapterCategory = new AdapterCategory(getApplicationContext(),modelCategories);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(adapterCategory);
        imageBack = findViewById(R.id.imageBack);
        textTilte = findViewById(R.id.textTitleActivity);
        textTilte.setText("دسته بندی محصولات");

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setCategory();
    }

    private void setCategory() {

        String url= Link.linkCategory;
        final ProgressDialog progressDialog = new ProgressDialog(ActivityCategory.this);
        progressDialog.show();

        Response.Listener<JSONArray> listener = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Gson gson = new Gson();
                ModelCategory[] categories = gson.fromJson(response.toString(),ModelCategory[].class);
                for (int i = 0 ; i<categories.length;i++)
                {
                    modelCategories.add(categories[i]);
                    adapterCategory.notifyDataSetChanged();
                    progressDialog.dismiss();
                }
            }
        };


        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ActivityCategory.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        };
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null,listener,errorListener);
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }
}