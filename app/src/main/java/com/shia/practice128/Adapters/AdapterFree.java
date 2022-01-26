package com.shia.practice128.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shia.practice128.Models.ModelFree;
import com.shia.practice128.R;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterFree extends RecyclerView.Adapter<AdapterFree.ViewHolder> {

    Context context;
    List<ModelFree> modelFrees;

    public AdapterFree(Context context, List<ModelFree> modelFrees) {
        this.context = context;
        this.modelFrees = modelFrees;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_free, parent,false);
        return new AdapterFree.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelFree free = modelFrees.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format(Integer.valueOf(free.getPrice()));
        holder.textprice.setText(price + " " + "تومان");
        holder.textvisit.setText(free.getVisit());
        holder.texttitle.setText(free.getTitle());
        holder.textfree.setText(free.getFree());
        holder.imageViewfree.setImageResource(free.getImage());
    }

    @Override
    public int getItemCount() {
        return modelFrees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        CardView cardView;
        ImageView imageViewfree;
        TextView texttitle,textvisit,textprice,textfree;
        Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/vaziri.ttf");

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            cardView = itemView.findViewById(R.id.cardViewFree);
            imageViewfree = itemView.findViewById(R.id.imagefree);
            texttitle = itemView.findViewById(R.id.texttitle);
            texttitle.setTypeface(typeface);
            textvisit = itemView.findViewById(R.id.textvisitfree);
            textvisit.setTypeface(typeface);
            textprice = itemView.findViewById(R.id.textpricefree);
            textprice.setTypeface(typeface);
            textfree = itemView.findViewById(R.id.textfreeprice);
            textfree.setTypeface(typeface);
        }
    }
}
