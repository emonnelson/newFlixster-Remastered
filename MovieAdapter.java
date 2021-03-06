package adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newflixster.MainActivity;
import com.example.newflixster.R;
import com.example.newflixster.RatingActivity2;

import org.parceler.Parcels;

import java.util.List;

import models.Movies;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<Movies> films;


    public MovieAdapter(Context context, List<Movies> films) {
        this.context = context;
        this.films = films;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View viewMovie = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(viewMovie);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        // Get the movie at the passed in position
        Movies movie = films.get(position);
        // Bind the movie data into the VH
        holder.bind(movie);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return films.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
       RelativeLayout container;
        TextView titleTv;
        TextView txtOverview;
        ImageView posterIv;
        //private Context context;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv1);
            txtOverview = itemView.findViewById(R.id.txtOverview1);
            posterIv = itemView.findViewById(R.id.posterIv1);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Movies movie) {
            titleTv.setText(movie.getTitle());
            txtOverview.setText(movie.getOverView());
            String imageUrl;
            // if phone is in landscape
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                // then imageUrl = back
                // drop image
                imageUrl = movie.getBackdropPath();
            } else {
                // else imageUrl = poster image
                imageUrl = movie.getPosterPath();
            }



            Glide.with(context).load(imageUrl).into(posterIv);

            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(context, RatingActivity2.class);

                   i.putExtra("title", movie.getTitle());
                    i.putExtra("overview",movie.getOverView());
                    i.putExtra("poster_path", movie.getPosterPath());
                    //i.putExtra("backdrop_path", movie.getBackdropPath());
                   //i.putExtra("movie", Parcels.wrap(movie));
                    context.startActivity(i);
                }
            });
        }
    }
}
