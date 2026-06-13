package com.app.eunice.remedies;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.io.IOException;
import java.io.InputStream;

public class Burns extends AppCompatActivity {

    private BottomBar mBottomBar;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.app.eunice.remedies.R.layout.activity_burns);
        Toolbar toolbar = (Toolbar) findViewById(com.app.eunice.remedies.R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(com.app.eunice.remedies.R.id.toolbar_layout);
        toolbarLayout.setExpandedTitleTextAppearance(com.app.eunice.remedies.R.style.toolbar_text);
        toolbarLayout.setCollapsedTitleTextAppearance(com.app.eunice.remedies.R.style.toolbar_text);
        Typeface font = Typeface.createFromAsset(getAssets(), "Strawberry Muffins.ttf");
        toolbarLayout.setExpandedTitleTypeface(font);
        toolbarLayout.setCollapsedTitleTypeface(font);

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.app.eunice.remedies.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "Check out this app Remedies " +
                        "https://play.google.com/store/apps/details?id=com.app.eunice.remedies";
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, text);
                sharingIntent.setType("text/plain");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });
        MobileAds.initialize(this,
                "ca-app-pub-1997809280967848/2483234942");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1997809280967848/2483234942");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
        readFromTextFile();
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.noTopOffset();
        mBottomBar.setItems(com.app.eunice.remedies.R.menu.bottombar);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                int position = menuItemId;
                switch (position) {
                    case com.app.eunice.remedies.R.id.bottomBarItemOne :

                        break;
                    case  com.app.eunice.remedies.R.id.bottomBarItemTwo :
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        break;
                    case  com.app.eunice.remedies.R.id.bottomBarItemThree :
                        Intent feedbackEmail = new Intent(Intent.ACTION_SEND);
                        feedbackEmail.setType("text/email");
                        feedbackEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"developerwe7@gmail.com"});
                        startActivity(Intent.createChooser(feedbackEmail, "Send Feedback:"));
                        break;
                    case com.app.eunice.remedies.R.id.bottomBarItemFour :
                        startActivity(new Intent(getApplicationContext(),About.class));
                        break;
                    case com.app.eunice.remedies.R.id.bottomBarItemFive:
                        startActivity(new Intent(getApplicationContext(),Disclaimer.class));
                        break;
                }
            }
            @Override
            public void onMenuTabReSelected ( @IdRes int menuItemId){

                int position = menuItemId;
                switch (position) {
                    case  com.app.eunice.remedies.R.id.bottomBarItemOne :

                        break;

                    case com.app.eunice.remedies.R.id.bottomBarItemTwo :
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        break;
                    case  com.app.eunice.remedies.R.id.bottomBarItemThree :
                        Intent feedbackEmail = new Intent(Intent.ACTION_SEND);
                        feedbackEmail.setType("text/email");
                        feedbackEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"developerwe7@gmail.com"});
                        startActivity(Intent.createChooser(feedbackEmail, "Send Feedback:"));
                        break;
                    case  com.app.eunice.remedies.R.id.bottomBarItemFour:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        break;
                    case com.app.eunice.remedies.R.id.bottomBarItemFive:
                        startActivity(new Intent(getApplicationContext(),Disclaimer.class));
                        break;
                }

            }

        });


        mBottomBar.setTypeFace("Strawberry Muffins.ttf");
        mBottomBar.useDarkTheme();


    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }
    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void readFromTextFile() {
        try {
            InputStream input = getAssets().open("burns.txt");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();//closing input stream to avoid resource leaks
            String text = new String(buffer);//convert the read buffer to sting
            TextView tvBurn = (TextView) findViewById(com.app.eunice.remedies.R.id.tvBurn);
            tvBurn.setText(text);

            Typeface typeface = Typeface.createFromAsset(getAssets(), "Strawberry Muffins.ttf");
            tvBurn.setTypeface(typeface);

        } catch (IOException ioe) {
            Toast.makeText(getApplicationContext(), "Sorry, app has encountered an error", Toast.LENGTH_LONG).show();
        }
    }
}