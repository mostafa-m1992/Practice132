package com.shia.practice128.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shia.practice128.Models.ModelCategory;
import com.shia.practice128.R;

import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.viewHolder> {

    Context context;
    List<ModelCategory> modelCategories;

    public AdapterCategory(Context context, List<ModelCategory> modelCategories) {
        this.context = context;
        this.modelCategories = modelCategories;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutcategory,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final ModelCategory category = modelCategories.get(position);
        holder.textView.setText(category.getTitlecategory());
        holder.imageView.setImageResource(Integer.parseInt(category.getImage()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, category.getId()+"", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelCategories.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardviewCategory);
            imageView = itemView.findViewById(R.id.imageCategory);
            textView = itemView.findViewById(R.id.texttilteCtegory);
        }
    }
}
