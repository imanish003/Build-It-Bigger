package optimist.mechanic.hnmn3.build_it_bigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */

public class MainActivityFragment extends Fragment implements MainActivity.JokeLoaderListener {

    Button tellJokeButton ;
    ProgressBar progressBar;

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

        //Adding Banner Ads
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        mAdView.setAdListener(new MyAdListener(getActivity()));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    @Override
    public void JokeLoadedSucessfully() {
        tellJokeButton.setText("Click here for Jokes");
        tellJokeButton.setClickable(true);
        progressBar.setVisibility(View.GONE);
    }
}
