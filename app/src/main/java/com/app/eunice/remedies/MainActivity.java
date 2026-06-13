package com.app.eunice.remedies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String titles[] = {
            "Achy Feet", "Acne", "Allergies and sinus", "Anxiety", "Arthritis", "Athlete's Foot", "Bad Breath", "Bites",
            "Blisters", "Brittle Nails", "Brittle Teeth", "Burns", "Calluses and corn", "Canker Sore", "Cold and flu",
            "Cold sore", "Constipation", "Cracked heels", "Cuticle Infection", "Dandruff", "Eczema", "Foot Odor", "Head Lice",
            "Heartburn", "High Blood Pressure", "Indigestion", "Morning Sickness", "Motion Sickness", "Nail Fungus",
            "Natural hair loss", "Nausea", "Smooth Skin", "Sore throat", "Sunburn", "Swimmer's Ear", "UTI",
            "Warts", "White Teeth"
    };

    private String desc[] = {
            "A feeling of pain experienced in...", "Acne is a common skin disease characterized...",
            "Allergic Rhinitis,Sinusitis and Rhinosinusitis...", "It is the feeling of fear or panic...",
            "This is the painful inflammation and stiffness of...", "This is a fungal infection that affects the...",
            "An unpleasant-smelling breath; halitosis...", "Move away from the stinging or biting insect...",
            "A small bubble on the skin filled with serum...", "Splitting of the fingernails is a common...",
            "It is a fairly common condition in which teeth...", "Stop a burn from spreading by running cold...",
            "These are thick, hardened layers of skin that...",
            "An ulcerous conditions or disease, in...", "The common cold, including chest cold and head...",
            "An inflamed blister in or near the mouth caused...", "Refers to bowel movements that are tough to...",
            "Naturally dry skin or thick dry skin(callus)...", "Acute paronychia - This usually appears as a...",
            "Small piece of dead skin in person's hair...", "It's a term for group of medical conditions...",
            "The bacteria that live on your skin and in...",
            "Are wingless insects spending their entire life...", "Heartburn is a burning sensation in the chest...",
            "Normal blood pressure is below 120/80 mm Hg...", "Indigestion, which is sometimes called dyspepsia...",
            "Nausea in pregnancy, typically occurring in the...", "Nausea caused by motion, especially by traveling...",
            "Nail fungus is a common condition that begins...",
            "Stress, illness, and child birth can cause...", "A feeling of sickness with an inclination to vomit...",
            "One of the most important things you can do...", "A condition marked by pain in the throat...",
            "Reddening, inflammation, and, in severe cases...",
            "Inflammation of the canal in the outer ear that is...","A urinary tract infection (UTI) is an infection...",
            "A small, hard, benign growth on the skin...", "There is evidence that strawberries can help..."

    };

    private Integer imageid[] = {
            com.app.eunice.remedies.R.drawable.achyfeet, com.app.eunice.remedies.R.drawable.acne, com.app.eunice.remedies.R.drawable.allergies_sinus, com.app.eunice.remedies.R.drawable.anxiety,
            com.app.eunice.remedies.R.drawable.arthritis, com.app.eunice.remedies.R.drawable.athletef, com.app.eunice.remedies.R.drawable.badb, com.app.eunice.remedies.R.drawable.bites,
            com.app.eunice.remedies.R.drawable.blisters, com.app.eunice.remedies.R.drawable.brittlen, com.app.eunice.remedies.R.drawable.brittlet, com.app.eunice.remedies.R.drawable.burns,
            com.app.eunice.remedies.R.drawable.calluses_corn, com.app.eunice.remedies.R.drawable.cankersore, com.app.eunice.remedies.R.drawable.cold_flu, com.app.eunice.remedies.R.drawable.coldsore,
            com.app.eunice.remedies.R.drawable.constipation, com.app.eunice.remedies.R.drawable.crackedh, com.app.eunice.remedies.R.drawable.cuticle_infection,
            com.app.eunice.remedies.R.drawable.dandruff, com.app.eunice.remedies.R.drawable.eczema, com.app.eunice.remedies.R.drawable.footodor, com.app.eunice.remedies.R.drawable.lice,
            com.app.eunice.remedies.R.drawable.heartburn, com.app.eunice.remedies.R.drawable.hbp, com.app.eunice.remedies.R.drawable.indigestion,
            com.app.eunice.remedies.R.drawable.morngs, com.app.eunice.remedies.R.drawable.mtions, com.app.eunice.remedies.R.drawable.nailfungus, com.app.eunice.remedies.R.drawable.nathairloss,
            com.app.eunice.remedies.R.drawable.nausea, com.app.eunice.remedies.R.drawable.smoothskin, com.app.eunice.remedies.R.drawable.sorethroat,
            com.app.eunice.remedies.R.drawable.sunburn, com.app.eunice.remedies.R.drawable.swimmersear, com.app.eunice.remedies.R.drawable.uti, com.app.eunice.remedies.R.drawable.warts,
            com.app.eunice.remedies.R.drawable.whiteteeth


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.app.eunice.remedies.R.layout.activity_main);

        CustomList customList = new CustomList(this, titles, desc, imageid);


        listView = (ListView) findViewById(com.app.eunice.remedies.R.id.listView);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), AchyFeet.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Acne.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), AllergiesSinus.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), Anxiety.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), Arthritis.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(), AthleteFoot.class));
                        break;
                    case 6:
                        startActivity(new Intent(getApplicationContext(), BadBreath.class));
                        break;
                    case 7:
                        startActivity(new Intent(getApplicationContext(), Bites.class));
                        break;
                    case 8:
                        startActivity(new Intent(getApplicationContext(), Blisters.class));
                        break;
                    case 9:
                        startActivity(new Intent(getApplicationContext(), BrittleNails.class));
                        break;
                    case 10:
                        startActivity(new Intent(getApplicationContext(), BrittleTeeth.class));
                        break;
                    case 11:
                        startActivity(new Intent(getApplicationContext(), Burns.class));
                        break;
                    case 12:
                        startActivity(new Intent(getApplicationContext(), Calluses_corn.class));
                        break;
                    case 13:
                        startActivity(new Intent(getApplicationContext(), Canker_sore.class));
                        break;
                    case 14:
                        startActivity(new Intent(getApplicationContext(), Cold_flu.class));
                        break;
                    case 15:
                        startActivity(new Intent(getApplicationContext(), coldsore.class));
                        break;
                    case 16:
                        startActivity(new Intent(getApplicationContext(), constipation.class));
                        break;
                    case 17:
                        startActivity(new Intent(getApplicationContext(), cracked_heels.class));
                        break;
                    case 18:
                        startActivity(new Intent(getApplicationContext(), Cuticle_infection.class));
                        break;
                    case 19:
                        startActivity(new Intent(getApplicationContext(), Dandruff.class));
                        break;
                    case 20:
                        startActivity(new Intent(getApplicationContext(), Eczema.class));
                        break;
                    case 21:
                        startActivity(new Intent(getApplicationContext(), FootOdor.class));
                        break;
                    case 22:
                        startActivity(new Intent(getApplicationContext(), Headlice.class));
                        break;
                    case 23:
                        startActivity(new Intent(getApplicationContext(), Heartburn.class));
                        break;
                    case 24:
                        startActivity(new Intent(getApplicationContext(), high_blood_pressure.class));
                        break;
                    case 25:
                        startActivity(new Intent(getApplicationContext(), Indigestion.class));
                        break;
                    case 26:
                        startActivity(new Intent(getApplicationContext(), Morning_sick.class));
                        break;
                    case 27:
                        startActivity(new Intent(getApplicationContext(), Motion_sick.class));
                        break;
                    case 28:
                        startActivity(new Intent(getApplicationContext(), Nail_fung.class));
                        break;
                    case 29:
                        startActivity(new Intent(getApplicationContext(), Natural_hair_loss.class));
                        break;
                    case 30:
                        startActivity(new Intent(getApplicationContext(), Nausea.class));
                        break;
                    case 31:
                        startActivity(new Intent(getApplicationContext(), Smooth_skin.class));
                        break;
                    case 32:
                        startActivity(new Intent(getApplicationContext(), Sore_throat.class));
                        break;
                    case 33:
                        startActivity(new Intent(getApplicationContext(), Sunburn.class));
                        break;
                    case 34:
                        startActivity(new Intent(getApplicationContext(), Swimmers_ear.class));
                        break;
                    case 35:
                        startActivity(new Intent(getApplicationContext(), UTIs.class));
                        break;
                    case 36:
                        startActivity(new Intent(getApplicationContext(), Warts.class));
                        break;
                    case 37:
                        startActivity(new Intent(getApplicationContext(), White_teeth.class));
                        break;

                    default:
                }


            }
        });
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-1997809280967848/8309774097");
        AdView adView = (AdView) findViewById(com.app.eunice.remedies.R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

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
                Toast.makeText(getApplicationContext(),"You are home",Toast.LENGTH_LONG).show();
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
                startActivity(new Intent(getApplicationContext(),About.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
