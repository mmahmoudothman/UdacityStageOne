package app.com.example.mmahmoudothmaon.udacityone.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.com.example.mmahmoudothmaon.udacityone.Movie;
import app.com.example.mmahmoudothmaon.udacityone.R;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MovieViewHolder>
{
    private List<Movie> movieList;
    private Context context;
    private ListItemClickListener mOnClickListener=null;


                // constructor
    public RecyclerViewAdapter(List<Movie> movieList, Context context, ListItemClickListener mOnClickListener)
    {
        this.movieList = movieList;
        this.context = context;
        this.mOnClickListener = mOnClickListener;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        LayoutInflater  inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_item, viewGroup, false);
       return  new MovieViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position)
    {
        Picasso.with(context).load("http://image.tmdb.org/t/p/w185/"+movieList.get(position).getPosterPath()).into(holder.imageView);

    }

    @Override
    public int getItemCount()
    {
        return movieList.size();
    }

    public interface ListItemClickListener
    {
        void onListItemClick(int clickedItemIndex);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imageView;
        public MovieViewHolder(View itemView)
        {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.rv_image);
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
