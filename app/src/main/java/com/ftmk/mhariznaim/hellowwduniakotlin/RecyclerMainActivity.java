package com.ftmk.mhariznaim.hellowwduniakotlin;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        recyclerView = findViewById(R.id.customRecyclerView);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerMainActivity.this));
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder  //subclass for defining repeated row
    {
        TextView textViewHalluu;
        public CustomViewHolder(LayoutInflater inflater, ViewGroup group) {
            super(inflater.inflate(R.layout.custom_row, group, false));
            textViewHalluu = itemView.findViewById(R.id.txtVwHelloRecyler);
        }
    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> //subclass for binding data with UI(viewHolder)
    {
        public final String[] restoranName;
        public CustomAdapter(Context applicationContext)
        {
            Resources resources = getApplicationContext().getResources();
            restoranName =resources.getStringArray(R.array.namaRestoran);
        }



        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new CustomViewHolder(LayoutInflater.from(parent.getContext()),parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) // to set the data on the view
        {
            holder.textViewHalluu.setText(restoranName[position]);
        }

        @Override
        public int getItemCount()  // to indicate how many loops to generate view
        {
            return restoranName.length;
        }

    }
}
