package com.example.newflixster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Movie;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import adapters.MovieAdapter;
import models.Movies;

public class RatingActivity2 extends AppCompatActivity {
    RatingBar ratingBar;
    Button btnSubmit;
    ImageView posterIv1;
    TextView titleTv1;
    TextView txtOverview1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating2);

        posterIv1 = findViewById(R.id.posterIv1);

        titleTv1 = findViewById(R.id.titleTv1);

        txtOverview1 = findViewById(R.id.txtOverview1);
            ratingBar = findViewById(R.id.rating_bar);

            btnSubmit =findViewById(R.id.btn_submit);

            btnSubmit.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), s + " Star"
                        , Toast.LENGTH_SHORT).show();
            }
            });

        String title = getIntent().getStringExtra("title");
        titleTv1.setText(title);

        String Overview = getIntent().getStringExtra("overview");
        txtOverview1.setText(Overview);

        String imgurl1 = getIntent().getStringExtra("poster_path");
        //Movies m = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
        Picasso.get().load(imgurl1).into(posterIv1);


            }




    }

    /*
class ImageViewHolder extends RecyclerView.ViewHolder {
    RelativeLayout llcontainer;
    ImageView posterIv1;
    Context context1;
    List<Movies> newFilms;



    public ImageViewHolder(@NonNull View itemView1) {
        super(itemView1);

            posterIv1 = itemView1.findViewById(R.id.posterIv1);
            llcontainer = itemView1.findViewById(R.id.llContainer);
        }


        public void bind(Movies m) {
            String imageUrl1;
            // if phone is in landscape
            if (context1.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                // then imageUrl = back
                // drop image
                imageUrl1 = m.getBackdropPath();
            } else {
                // else imageUrl = poster image
                imageUrl1 = m.getPosterPath();
            }



            Glide.with(context1).load(imageUrl1).into(posterIv1);
        }
    }

*/




