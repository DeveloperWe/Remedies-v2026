package com.app.eunice.remedies;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.io.InputStream;

public class About extends AppCompatActivity {


    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(com.app.eunice.remedies.R.layout.activity_about);

        MobileAds.initialize(this,
                "ca-app-pub-1997809280967848/3121120076");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1997809280967848/3121120076");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
        readFromTextFile();
    }
    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(com.app.eunice.remedies.R.menu.about, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            //respond to the action bar settings button
            case com.app.eunice.remedies.R.id.home:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                return true;
            case com.app.eunice.remedies.R.id.share:
                String text = "Check out this app Remedies " +
                        "https://play.google.com/store/apps/details?id=com.app.eunice.remedies";
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, text);
                sharingIntent.setType("text/plain");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                return true;
            case com.app.eunice.remedies.R.id.feedback:
                Intent feedbackEmail = new Intent(Intent.ACTION_SEND);
                feedbackEmail.setType("text/email");
                feedbackEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"developerwe7@gmail.com"});
                startActivity(Intent.createChooser(feedbackEmail, "Send Feedback:"));
                return true;
            case com.app.eunice.remedies.R.id.disc:
                startActivity(new Intent(getApplicationContext(),Disclaimer.class));
                return true;
            case com.app.eunice.remedies.R.id.about:
                Toast.makeText(getApplicationContext(),"You are here",Toast.LENGTH_LONG).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }




    public void readFromTextFile() {
        try {
            InputStream input = getAssets().open("about.txt");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();//closing input stream to avoid resource leaks
            String text = new String(buffer);//convert the read buffer to sting
            TextView tvAbout = (TextView) findViewById(com.app.eunice.remedies.R.id.tvAbout);
            tvAbout.setText(text);

            Typeface typeface = Typeface.createFromAsset(getAssets(), "Strawberry Muffins.ttf");
            tvAbout.setTypeface(typeface);

        } catch (IOException ioe) {
            Toast.makeText(getApplicationContext(), "Sorry, app has encountered an error", Toast.LENGTH_LONG).show();
        }
    }
}

