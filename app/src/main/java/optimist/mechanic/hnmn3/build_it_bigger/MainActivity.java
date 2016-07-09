package optimist.mechanic.hnmn3.build_it_bigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import Utils.AsyncResponse;
import Utils.AsyncTask_FetchJoke;
import optimist.mechanic.hnmn3.joke_android_library.DisplayJokeActivity;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

    List<String> jokesList = null;
    Boolean dataLoaded = false;

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

    public void tellJoke(View view) {
        if(dataLoaded==false){
            Toast.makeText(MainActivity.this, "Wait , jokes are still loading :(", Toast.LENGTH_SHORT).show();
        }else {
            /*JavaJokesClass javaJokesClass = new JavaJokesClass();
            String[] jokes = javaJokesClass.getJokes();*/
            Intent intent = new Intent(this, DisplayJokeActivity.class);
            String[] jokes = new String[jokesList.size()];
            jokes = jokesList.toArray(jokes);
            intent.putExtra("jokes", jokes);
            startActivity(intent);
        }
    }


    @Override
    public void processFinish(List<String> output) {
        jokesList =output;
        Toast.makeText(MainActivity.this, "Jokes Loaded sucessfully", Toast.LENGTH_SHORT).show();
        dataLoaded = true;
    }
}
