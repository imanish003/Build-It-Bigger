package Utils;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import optimist.mechanic.hnmn3.build_it_bigger.backend.myApi.MyApi;

/**
 * Created by Manish Menaria on 09-Jul-16.
 */
public class AsyncTask_FetchJoke extends AsyncTask<Context, List<String>, List<String>> {
    private MyApi myApiService = null;
    private Context context;
    public AsyncResponse delegate = null;

    @Override
    protected List<String> doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1366.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0];


        try {
            return myApiService.gceJokes().execute().getJokes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        list.add("Nothing fatched");
        return list;
    }

    @Override
    protected void onPostExecute(List<String> result) {
        if(delegate!=null)
        delegate.processFinish(result);
    }

}


