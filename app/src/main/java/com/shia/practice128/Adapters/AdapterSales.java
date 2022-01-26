package com.shia.practice128.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shia.practice128.Models.ModelSales;
import com.shia.practice128.R;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterSales extends RecyclerView.Adapter<AdapterSales.ViewHolder> {

    Context context;
    List<ModelSales> modelSales;

    public AdapterSales(Context context, List<ModelSales> modelSales) {
        this.context = context;
        this.modelSales = modelSales;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_sales, parent, false);
        return new AdapterSales.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelSales sales = modelSales.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format(Integer.valueOf(sales.getPrice()));
        holder.textprice.setText(price + " " + "تومان");
        holder.textvisit.setText(sales.getVisit());
        holder.texttitlesales.setText(sales.getTitle());
        holder.imageViewSales.setImageResource(sales.getImage());
    }

    @Override
    public int getItemCount() {
        return modelSales.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        CardView cardView;
        ImageView imageViewSales;
        TextView texttitlesales,textvisit,textprice;
        Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/vaziri.ttf");

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardViewSales);
            imageViewSales = itemView.findViewById(R.id.imagesales);
            texttitlesales = itemView.findViewById(R.id.texttitlesales);
            texttitlesales.setTypeface(typeface);
            textvisit = itemView.findViewById(R.id.textvisitsales);
            textvisit.setTypeface(typeface);
            textprice = itemView.findViewById(R.id.textpricesales);
            textprice.setTypeface(typeface);
        }
    }
}
