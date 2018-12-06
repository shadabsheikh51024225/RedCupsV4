package com.shadabsheikh07.redcupsv4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class LicenceAgreement  extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.licence_agreement);


        CheckBox agreement = (CheckBox)findViewById(R.id.agreement_check_box);

        TextView terms = (TextView)findViewById(R.id.terms);

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // setting the path for the terms and condition.

                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Terms_of_service"));
                startActivity(viewIntent);



            }
        });



        SharedPreferences settings=getSharedPreferences("prefs",0);
        boolean firstRun=settings.getBoolean("firstRun",false);
        if(firstRun==false)

        {
            SharedPreferences.Editor editor=settings.edit();
            editor.putBoolean("firstRun",true);
            editor.commit();
            agreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        //checked

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();

                    }
                }
            });

        }
        else
        {

            //   Toast.makeText(getApplicationContext(), "yoyo",
            //      Toast.LENGTH_LONG).show();

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        }

    }
}