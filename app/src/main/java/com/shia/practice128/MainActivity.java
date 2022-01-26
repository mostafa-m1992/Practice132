package com.shia.practice128;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.shia.practice128.Activity.ActivityCategory;
import com.shia.practice128.Activity.ActivityLogin;
import com.shia.practice128.Activity.ActivityProfile;
import com.shia.practice128.Adapters.AdapterFree;
import com.shia.practice128.Adapters.AdapterOnly;
import com.shia.practice128.Adapters.AdapterSales;
import com.shia.practice128.Adapters.AdapterVisit;
import com.shia.practice128.Class.Put;
import com.shia.practice128.Models.ModelFree;
import com.shia.practice128.Models.ModelOnly;
import com.shia.practice128.Models.ModelSales;
import com.shia.practice128.Models.ModelVisit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerFree, recyclerOnly, recyclerVisit, recyclerSales;

    AdapterFree adapterFree;
    List<ModelFree> modelFrees = new ArrayList<>();

    AdapterOnly adapterOnly;
    List<ModelOnly> modelOnly = new ArrayList<>();

    AdapterVisit adapterVisit;
    List<ModelVisit> modelVisits = new ArrayList<>();

    AdapterSales adapterSales;
    List<ModelSales> modelSales = new ArrayList<>();

    ImageView imageNv;
    DrawerLayout drawer;

    TextView textLogin;
    ImageView loginIconToolbar;

    CardView cardCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Toolbar toolbarAppbar = findViewById(R.id.toolbarAppbar);
        setSupportActionBar(toolbarAppbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));

        findView();
        SharedPreferences preferences=getSharedPreferences(Put.shared,MODE_PRIVATE);
        textLogin.setText(preferences.getString(Put.email,"ورود/ثبت نام"));
    }

    private void findView() {
        recyclerFree = findViewById(R.id.recyclerFree);
        recyclerOnly = findViewById(R.id.recyclerOnly);
        recyclerVisit = findViewById(R.id.recyclerVisit);
        recyclerSales = findViewById(R.id.recyclerSales);
        imageNv = findViewById(R.id.imageNav);
        drawer = findViewById(R.id.drawer);
        textLogin = findViewById(R.id.textLogin);
        loginIconToolbar = findViewById(R.id.loginIconToolbar);
        cardCat = findViewById(R.id.cardCat);
        setDataFree();
        setDataOnly();
        setDataVisit();
        setDataSales();
        iconOnClick();
    }

    private void iconOnClick() {
        /*imageNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.RIGHT);
            }
        });*/
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textLogin.getText().equals("ورود/ثبت نام")){
                    Intent intent=new Intent(MainActivity.this, ActivityLogin.class);
                    startActivityForResult(intent, Put.REQUEST_CODE);
                }else {
                    Intent intent=new Intent(MainActivity.this, ActivityProfile.class);
                    //startActivity(intent);
                    startActivityForResult(intent,Put.REQUEST_EXIT);
                }
            }
        });
        /*loginIconToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
                startActivityForResult(intent, Put.REQUEST_CODE);
                startActivity(intent);
            }
        });*/
        cardCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityCategory.class));
            }
        });
    }

    private void setDataSales() {
        adapterSales = new AdapterSales(getApplicationContext(), modelSales);
        recyclerSales.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerSales.setAdapter(adapterSales);

        /*modelSales.add(new ModelSales(1, R.drawable.backpack20,"گوشی آیفون", "50", "20000"));
        modelSales.add(new ModelSales(1, R.drawable.laptop20,"گوشی آیفون", "50", "20000"));
        modelSales.add(new ModelSales(1, R.drawable.lexusb,"گوشی آیفون", "50", "20000"));
        modelSales.add(new ModelSales(1, R.drawable.phone6,"گوشی آیفون", "50", "20000"));
        modelSales.add(new ModelSales(1, R.drawable.backpack20,"گوشی آیفون", "50", "20000"));
        modelSales.add(new ModelSales(1, R.drawable.laptop20,"گوشی آیفون", "50", "20000"));
        modelSales.add(new ModelSales(1, R.drawable.lexusb,"گوشی آیفون", "50", "20000"));
        modelSales.add(new ModelSales(1, R.drawable.phone6,"گوشی آیفون", "50", "20000"));

        adapterOnly.notifyDataSetChanged();*/
    }

    private void setDataVisit() {
        adapterVisit = new AdapterVisit(getApplicationContext(), modelVisits);
        recyclerVisit.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        recyclerVisit.setAdapter(adapterVisit);

        /*modelVisits.add(new ModelVisit(1, R.drawable.backpack20,"گوشی آیفون", "50", "20000"));
        modelVisits.add(new ModelVisit(1, R.drawable.laptop20,"گوشی آیفون", "50", "20000"));
        modelVisits.add(new ModelVisit(1, R.drawable.lexusb,"گوشی آیفون", "50", "20000"));
        modelVisits.add(new ModelVisit(1, R.drawable.phone6,"گوشی آیفون", "50", "20000"));
        modelVisits.add(new ModelVisit(1, R.drawable.backpack20,"گوشی آیفون", "50", "20000"));
        modelVisits.add(new ModelVisit(1, R.drawable.laptop20,"گوشی آیفون", "50", "20000"));
        modelVisits.add(new ModelVisit(1, R.drawable.lexusb,"گوشی آیفون", "50", "20000"));
        modelVisits.add(new ModelVisit(1, R.drawable.phone6,"گوشی آیفون", "50", "20000"));

        adapterOnly.notifyDataSetChanged();*/
    }

    private void setDataOnly() {
        adapterOnly = new AdapterOnly(getApplicationContext(), modelOnly);
        recyclerOnly.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerOnly.setAdapter(adapterOnly);

        /*modelOnly.add(new ModelOnly(1, R.drawable.backpack20,"گوشی آیفون", "50", "20000"));
        modelOnly.add(new ModelOnly(1, R.drawable.laptop20,"گوشی آیفون", "50", "20000"));
        modelOnly.add(new ModelOnly(1, R.drawable.lexusb,"گوشی آیفون", "50", "20000"));
        modelOnly.add(new ModelOnly(1, R.drawable.phone6,"گوشی آیفون", "50", "20000"));
        modelOnly.add(new ModelOnly(1, R.drawable.backpack20,"گوشی آیفون", "50", "20000"));
        modelOnly.add(new ModelOnly(1, R.drawable.laptop20,"گوشی آیفون", "50", "20000"));
        modelOnly.add(new ModelOnly(1, R.drawable.lexusb,"گوشی آیفون", "50", "20000"));
        modelOnly.add(new ModelOnly(1, R.drawable.phone6,"گوشی آیفون", "50", "20000"));

        adapterOnly.notifyDataSetChanged();*/
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setDataFree(){
        adapterFree=new AdapterFree(getApplicationContext(),modelFrees);
        recyclerFree.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerFree.setAdapter(adapterFree);

        /*modelFrees.add(new ModelFree(1, R.drawable.backpack20, "گوشی آیفون", "50", "10000", "10%"));
        modelFrees.add(new ModelFree(2,R.drawable.laptop20,"گوشی آیفون 256 گیگ","20","200000","20%"));
        modelFrees.add(new ModelFree(3,R.drawable.lexusb,"گوشی آیفون 256 گیگ","30","300000","30%"));
        modelFrees.add(new ModelFree(4,R.drawable.phone6,"گوشی آیفون 256 گیگ","40","400000","40%"));
        modelFrees.add(new ModelFree(5,R.drawable.backpack20,"گوشی آیفون 256 گیگ","50","500000","50%"));
        modelFrees.add(new ModelFree(5,R.drawable.laptop20,"گوشی آیفون 256 گیگ","50","500000","50%"));
        modelFrees.add(new ModelFree(5,R.drawable.lexusb,"گوشی آیفون 256 گیگ","50","500000","50%"));
        modelFrees.add(new ModelFree(5,R.drawable.phone6,"گوشی آیفون 256 گیگ","50","500000","50%"));
        modelFrees.add(new ModelFree(5,R.drawable.backpack20,"گوشی آیفون 256 گیگ","50","500000","50%"));
        modelFrees.add(new ModelFree(5,R.drawable.laptop20,"گوشی آیفون 256 گیگ","50","500000","50%"));
        modelFrees.add(new ModelFree(5,R.drawable.lexusb,"گوشی آیفون 256 گیگ","50","500000","50%"));
        modelFrees.add(new ModelFree(5,R.drawable.phone6,"گوشی آیفون 256 گیگ","50","500000","50%"));

        adapterFree.notifyDataSetChanged();*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Put.REQUEST_CODE && resultCode==RESULT_OK){
            String email=data.getStringExtra(Put.email);
            textLogin.setText(email);
            SharedPreferences sharedPreferences=getSharedPreferences(Put.shared,MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString(Put.email,email);
            editor.apply();
        }
        else if(requestCode==Put.REQUEST_EXIT && resultCode==RESULT_OK){
            String email=data.getStringExtra(Put.email);
            textLogin.setText(email);
        }
    }
}