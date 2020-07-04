package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity3 extends AppCompatActivity {
    private TextView nameTxt,yearTxt;
    Button fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //REFERENCE VIEWS
        //nameTxt= (TextView) findViewById(R.id.nameTxt);
        yearTxt= (TextView) findViewById(R.id.yearTxt);

        fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment();
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();

        //DETERMINE WHO STARTED THIS ACTIVITY
        final String sender=this.getIntent().getExtras().getString("SENDER_KEY");

        //IF ITS THE FRAGMENT THEN RECEIVE DATA
        if(sender != null)
        {
            this.receiveData();
            Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show();

        }
    }

    /*
        OPEN FRAGMENT
         */
    private void openFragment()
    {
        //PASS OVER THE BUNDLE TO OUR FRAGMENT
        MetodeFragment myFragment = new MetodeFragment();
        //THEN NOW SHOW OUR FRAGMENT
        getSupportFragmentManager().beginTransaction().replace(R.id.container,myFragment).commit();
    }

    /*
    RECEIVE DATA FROM FRAGMENT
     */
    private void receiveData()
    {
        //RECEIVE DATA VIA INTENT
        Intent i = getIntent();
        //String name = i.getStringExtra("NAME_KEY");
        int year = i.getIntExtra("YEAR_KEY",0);
        String bulan = Integer.toString(year);


        //SET DATA TO TEXTVIEWS
       // nameTxt.setText(name);
        //yearTxt.setText(String.valueOf(year));

    }
}