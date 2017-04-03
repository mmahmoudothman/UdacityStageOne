package app.com.example.mmahmoudothmaon.udacityone;

import org.json.JSONException;


public interface AsyncTaskCompleteListener
{
    public void onTaskComplete(String result) throws JSONException;
}
