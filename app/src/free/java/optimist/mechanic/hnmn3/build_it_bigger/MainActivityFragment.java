package optimist.mechanic.hnmn3.build_it_bigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import optimist.mechanic.hnmn3.joke_android_library.DisplayJokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */

public class MainActivityFragment extends Fragment implements MainActivity.JokeLoaderListener {

    Button tellJokeButton;
    ProgressBar progressBar;
    PublisherInterstitialAd interstitialAd;
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
                    if (interstitialAd.isLoaded()) {
                        interstitialAd.show();
                    } else {
                        Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
                        String[] jokes = new String[activity.jokesList.size()];
                        jokes = activity.jokesList.toArray(jokes);
                        intent.putExtra("jokes", jokes);
                        startActivity(intent);
                    }
                }
            }
        });

        //Adding Banner Ads
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        mAdView.setAdListener(new MyAdListener(getActivity()));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        //Adding Interstitial Ad
        interstitialAd = new PublisherInterstitialAd(getActivity());
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        getInterstitialAd();
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
                String[] jokes = new String[activity.jokesList.size()];
                jokes = activity.jokesList.toArray(jokes);
                intent.putExtra("jokes", jokes);
                startActivity(intent);
                getInterstitialAd();
            }
        });

        return root;
    }

    private void getInterstitialAd() {
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        interstitialAd.loadAd(adRequest);
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
