package com.ftmk.mhariznaim.hellowwduniakotlin;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewPictureActivity extends AppCompatActivity {

    RecyclerView recyclerViewPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_picture);

        CustomAdapterPic customAdapterPic = new CustomAdapterPic(getApplicationContext());
        recyclerViewPic = findViewById(R.id.recVwPic);
        recyclerViewPic.setAdapter(customAdapterPic);
        recyclerViewPic.setLayoutManager(new LinearLayoutManager(RecyclerViewPictureActivity.this));


    }

    private class CustomViewHoldersPic extends RecyclerView.ViewHolder
    {
        TextView txtVwTitle, txtvwSubtitle;
        ImageView imgViwLoc;
        public CustomViewHoldersPic(LayoutInflater inflater, ViewGroup group) {
            super(inflater.inflate(R.layout.picture_malaysia,group,false));
            txtVwTitle = itemView.findViewById(R.id.txtVwTitle);
            txtvwSubtitle = itemView.findViewById(R.id.txtVwSubTitle);
            imgViwLoc = itemView.findViewById(R.id.imgVwLoc);
        }
    }

    private class CustomAdapterPic extends RecyclerView.Adapter<CustomViewHoldersPic>
    {
        public final String[] arrLocTitle, arrLocImg, arrLocSubTitle;
        public final Drawable[] arrDrawLoc;
        public CustomAdapterPic(Context applicationContext )
        {
            Resources resources = getApplicationContext().getResources();
            arrLocTitle = resources.getStringArray(R.array.titleLocation);
            arrLocImg = resources.getStringArray(R.array.imageDrawLoc);
            arrLocSubTitle = resources.getStringArray(R.array.subtitleLoc);

            TypedArray typedArray = resources.obtainTypedArray(R.array.imageDrawLoc);
            arrDrawLoc = new Drawable[typedArray.length()];
            for (int i = 0 ; i < arrDrawLoc.length; i++)
            {
                arrDrawLoc[i] = typedArray.getDrawable(i);
            }
        }

        @NonNull
        @Override
        public CustomViewHoldersPic onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new CustomViewHoldersPic(LayoutInflater.from(parent.getContext()),parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHoldersPic holder, int position)
        {
            holder.txtVwTitle.setText(arrLocTitle[position]);
            holder.txtvwSubtitle.setText(arrLocSubTitle[position]);
            holder.imgViwLoc.setImageDrawable(arrDrawLoc[position]);
            //Bitmap bitmap = new Bitmap()
        }

        @Override
        public int getItemCount() {
            return arrLocTitle.length;
        }
    }
}
