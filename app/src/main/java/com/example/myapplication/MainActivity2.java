package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity2.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.home_menu:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.metode_menu:
                    selectedFragment = new MetodeFragment();
                    break;
                case R.id.favorite_menu:
                    selectedFragment = new FavoriteFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,
                    selectedFragment).commit();

            return true;
        }
    };
//
//        //Menampilkan halaman Fragment yang pertama kali muncul
//        getFragmentPage(new HomeFragment());
//
//        /*Inisialisasi BottomNavigationView beserta listenernya untuk
//         *menangkap setiap kejadian saat salah satu menu item diklik
//         */
//        BottomNavigationView bottomNavigation = findViewById(R.id.bn_main);
//        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                Fragment fragment = null;
//
//                //Menantukan halaman Fragment yang akan tampil
//                switch (item.getItemId()){
//                    case R.id.home_menu:
//                        fragment = new HomeFragment();
//                        break;
//
//                    case R.id.metode_menu:
//                        fragment = new MetodeFragment();
//                        break;
//
//                    case R.id.favorite_menu:
//                        fragment = new FavoriteFragment();
//                        break;
//                }
//                return getFragmentPage(fragment);
//            }
//        });
//    }
//
//    //Menampilkan halaman Fragment
//    private boolean getFragmentPage(Fragment fragment){
//        if (fragment != null){
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fl_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }

//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
//                builder.setMessage("Apakah yakin ingin keluar ?");
//                builder.setCancelable(true);
//                builder.setPositiveButton("Ok", new View.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog, int id){
//                        finish();
//                    }
//                });
//                builder.setNegativeButton("Cancel", new View.OnClickListener(){
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//
//                    }
//                });
//                AlertDialog alert = builder.create();
//                alert.show();

}