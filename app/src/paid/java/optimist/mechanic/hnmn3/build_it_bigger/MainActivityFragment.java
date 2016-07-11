package optimist.mechanic.hnmn3.build_it_bigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import optimist.mechanic.hnmn3.joke_android_library.DisplayJokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */

public class MainActivityFragment extends Fragment implements MainActivity.JokeLoaderListener {

    Button tellJokeButton;
    ProgressBar progressBar;
    Boolean dataLoaded = false;
    MainActivity activity = null;

    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        tellJokeButton = (Button) root.findViewById(R.id.tell_joke_button);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        tellJokeButton.setText("Loading Jokes");
        tellJokeButton.setClickable(false);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  if (activity != null) {
                                                      {
                                                          Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
                                                          String[] jokes = new String[activity.jokesList.size()];
                                                          jokes = activity.jokesList.toArray(jokes);
                                                          intent.putExtra("jokes", jokes);
                                                          startActivity(intent);
                                                      }
                                                  }
                                              }
                                          }
        );

        return root;
    }

    @Override
    public void JokeLoadedSucessfully() {
        tellJokeButton.setText("Click here for Jokes");
        tellJokeButton.setClickable(true);
        progressBar.setVisibility(View.GONE);
        dataLoaded = true;
        activity = (MainActivity) getActivity();
    }
}
