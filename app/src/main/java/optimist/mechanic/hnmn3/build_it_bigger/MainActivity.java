package optimist.mechanic.hnmn3.build_it_bigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import Utils.AsyncResponse;
import Utils.AsyncTask_FetchJoke;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

    List<String> jokesList = null;
    JokeLoaderListener mCallBack=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncTask_FetchJoke asyncTask_fetchJoke = new AsyncTask_FetchJoke();
        asyncTask_fetchJoke.delegate = this;
        asyncTask_fetchJoke.execute(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void processFinish(List<String> output) {
        jokesList = output;
        Toast.makeText(MainActivity.this, "Jokes Loaded sucessfully", Toast.LENGTH_SHORT).show();
        mCallBack = (JokeLoaderListener) getSupportFragmentManager().findFragmentById(R.id.fragment);
        mCallBack.JokeLoadedSucessfully();

    }


    public interface JokeLoaderListener {
        public void JokeLoadedSucessfully();
    }

}

