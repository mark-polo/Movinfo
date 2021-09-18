package com.mrm.movinfo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private final List<Model> movies;
    private final Context context;

    public MovieAdapter(List<Model> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieAdapter.MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

//        int img = context.getResources().getIdentifier(movies.get(position).getPoster(), "drawable", context.getPackageName());
//        holder.poster.setImageResource(img);

        holder.name.setText(movies.get(position).getName());
        holder.year.setText(movies.get(position).getYear());
        holder.director.setText(movies.get(position).getDirector());
        holder.description.setText(movies.get(position).getDescription());

        holder.itemView.setOnClickListener(l -> {
            Intent i = new Intent(context, MovieInfoActivity.class);

//            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
//                    new Pair<>(holder.poster, "filmPoster"));

            i.putExtra("Name", movies.get(position).getName());
            i.putExtra("Year", movies.get(position).getYear());
            i.putExtra("Director", movies.get(position).getDirector());
            i.putExtra("Description", movies.get(position).getDescription());

            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView name , year , director , description;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.filmName);
            year = itemView.findViewById(R.id.filmYear);
            director = itemView.findViewById(R.id.filmDirector);
            description = itemView.findViewById(R.id.filmDescription);
        }
    }
}