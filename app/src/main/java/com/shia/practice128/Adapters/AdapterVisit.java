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

import com.shia.practice128.Models.ModelVisit;
import com.shia.practice128.R;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterVisit extends RecyclerView.Adapter<AdapterVisit.ViewHolder> {

    Context context;
    List<ModelVisit> modelVisits;

    public AdapterVisit(Context context, List<ModelVisit> modelVisits) {
        this.context = context;
        this.modelVisits = modelVisits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_visit, parent, false);
        return new AdapterVisit.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelVisit visit = modelVisits.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format(Integer.valueOf(visit.getPrice()));
        holder.textprice.setText(price + " " + "تومان");
        holder.textvisit.setText(visit.getVisit());
        holder.texttitlevisit.setText(visit.getTitle());
        holder.imageViewvisit.setImageResource(visit.getImage());
    }

    @Override
    public int getItemCount() {
        return modelVisits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageViewvisit;
        TextView texttitlevisit,textvisit,textprice;
        Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/vaziri.ttf");

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardViewVisit);
            imageViewvisit = itemView.findViewById(R.id.imagevisit);
            texttitlevisit = itemView.findViewById(R.id.texttitlevisit);
            texttitlevisit.setTypeface(typeface);
            textvisit = itemView.findViewById(R.id.textvisitvisit);
            textvisit.setTypeface(typeface);
            textprice = itemView.findViewById(R.id.textpricevisit);
            textprice.setTypeface(typeface);
        }
    }
}
