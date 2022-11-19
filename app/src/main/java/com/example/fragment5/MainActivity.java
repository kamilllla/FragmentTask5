package com.example.fragment5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private NavigationBarView.OnItemSelectedListener mOnNavigationItemSelectedListener= new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.home:
                    loadFragment(Home.newInstance());
                    return true;

                case  R.id.search:
                    loadFragment(Dashboard.newInstance());
                    return true;

                case R.id.more:
                    loadFragment(Notification.newInstance());
                    return true;

            }
            return  false;
        }
    };
    private void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fl_content,fragment).commit();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.bn);
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}