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

import com.shia.practice128.Models.ModelOnly;
import com.shia.practice128.R;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterOnly extends RecyclerView.Adapter<AdapterOnly.ViewHolder> {

    Context context;
    List<ModelOnly> modelOnly;

    public AdapterOnly(Context context, List<ModelOnly> modelOnly) {
        this.context = context;
        this.modelOnly = modelOnly;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_only, parent, false);
        return new AdapterOnly.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelOnly only = modelOnly.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format(Integer.valueOf(only.getPrice()));
        holder.textprice.setText(price + " " + "تومان");
        holder.textvisit.setText(only.getVisit());
        holder.texttitleonly.setText(only.getTitle());
        holder.imageViewonly.setImageResource(only.getImage());
    }

    @Override
    public int getItemCount() {
        return modelOnly.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageViewonly;
        TextView texttitleonly,textvisit,textprice;
        Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/vaziri.ttf");

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardViewOnly);
            imageViewonly = itemView.findViewById(R.id.imageonly);
            texttitleonly = itemView.findViewById(R.id.texttitleonly);
            texttitleonly.setTypeface(typeface);
            textvisit = itemView.findViewById(R.id.textvisitonly);
            textvisit.setTypeface(typeface);
            textprice = itemView.findViewById(R.id.textpriceonly);
            textprice.setTypeface(typeface);
        }
    }
}
