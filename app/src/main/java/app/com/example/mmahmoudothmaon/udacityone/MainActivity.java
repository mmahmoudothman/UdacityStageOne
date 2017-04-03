package app.com.example.mmahmoudothmaon.udacityone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


import org.json.JSONException;

import java.util.List;

import app.com.example.mmahmoudothmaon.udacityone.Utils.Asynctask;
import app.com.example.mmahmoudothmaon.udacityone.Utils.MovieJsonUtils;
import app.com.example.mmahmoudothmaon.udacityone.Utils.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements AsyncTaskCompleteListener,RecyclerViewAdapter.ListItemClickListener{
    String popular ="http://api.themoviedb.org/3/movie/popular?api_key=c135edccccf4887c539861e27205b457";
    String topRated ="http://api.themoviedb.org/3/movie/top_rated?api_key=c135edccccf4887c539861e27205b457";
    List<Movie> movies;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        new Asynctask(this).execute(popular);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.mostPopular)
        {
            new Asynctask(this).execute(popular);
        }
        else if(item.getItemId()==R.id.topRated)
        {
            new Asynctask(this).execute(topRated);
        }

        return true;
    }
    @Override
    public void onListItemClick(int clickedItemIndex)
    {
        Intent intent = new Intent(this,DetailsActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, movies.get(clickedItemIndex));
        startActivity(intent);
    }

    @Override
    public void onTaskComplete(String result) throws JSONException
    {
        if(result!=null)
        {
            movies= MovieJsonUtils.getMoviesDataFromJson(result);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(movies,this,this);
            RecyclerView.LayoutManager  manager= new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        }
    }


}
