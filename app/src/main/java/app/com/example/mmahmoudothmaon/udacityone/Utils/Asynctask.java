package app.com.example.mmahmoudothmaon.udacityone.Utils;

import android.net.Uri;

import org.json.JSONException;

import java.net.URL;

import app.com.example.mmahmoudothmaon.udacityone.AsyncTaskCompleteListener;


public class Asynctask extends android.os.AsyncTask<String,Void,String> {

    private AsyncTaskCompleteListener callback;

            // constructor
    public Asynctask(AsyncTaskCompleteListener callback)
    {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... urls)
    {
        if(urls!=null)
        {
            try {
                Uri uri = Uri.parse(urls[0]).buildUpon().build();
                return NetworkUtils.getResponseFromHttpUrl(new URL(uri.toString()));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s)
    {
        try {
	    if(s != null)
	    {
            callback.onTaskComplete(s);
        }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}
