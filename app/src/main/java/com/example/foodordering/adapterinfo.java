package com.example.foodordering;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodordering.R;
import androidx.cardview.widget.CardView;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapterinfo extends RecyclerView.Adapter<adapterinfo.ViewHolder> {
    private static final String TAG = "adapterinfo";

    private ArrayList<String> mRestaurantName = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mCuisineName = new ArrayList<>();
    private Context mcontext;

    public adapterinfo(ArrayList<String> mImageName, ArrayList<String> mImages, ArrayList<String> mCuisineName, Context mcontext) {
        this.mRestaurantName = mImageName;
        this.mCuisineName = mCuisineName;
        this.mImages = mImages;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mcontext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mRestaurantName.get(position));
        holder.cuisineName.setText(mCuisineName.get(position));

        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG, "onClick: clicked on.");
                Toast.makeText(mcontext, mRestaurantName.get(position), Toast.LENGTH_SHORT).show();
                //Intent intent= new Intent(view.getContext(), info.class);
                //view.getContext().startActivity(intent);

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mRestaurantName.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imageName;
        TextView cuisineName;
        androidx.cardview.widget.CardView  parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            imageName = itemView.findViewById(R.id.textViewName);
            cuisineName = itemView.findViewById(R.id.textViewVersion);
            parentLayout = itemView.findViewById(R.id.card_view);

        }
    }
}
