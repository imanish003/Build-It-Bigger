package optimist.mechanic.hnmn3.build_it_bigger;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

public class MyAdListener extends AdListener {
    private Context mContext;
    private String mErrorReason;

    public MyAdListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void onAdLoaded() {
        Toast.makeText(mContext, "onAdLoaded()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdOpened() {
        Toast.makeText(mContext, "onAdOpened()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdClosed() {
        Toast.makeText(mContext, "onAdClosed()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLeftApplication() {
        Toast.makeText(mContext, "onAdLeftApplication()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        mErrorReason = "";
        switch(errorCode) {
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                mErrorReason = "Internal error";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                mErrorReason = "Invalid request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                mErrorReason = "Network Error";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                mErrorReason = "No fill";
                break;
        }
        Toast.makeText(mContext,
                String.format("onAdFailedToLoad(%s)", mErrorReason),
                Toast.LENGTH_SHORT).show();
    }

    public String getErrorReason() {
        return mErrorReason == null ? "" : mErrorReason;
    }

}
