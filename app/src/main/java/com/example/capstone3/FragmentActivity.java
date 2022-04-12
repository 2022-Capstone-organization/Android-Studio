package com.example.capstone3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment_Plus fragment_plus;
    private Fragment_Home fragment_home;
    private Fragment_Search fragment_search;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.navi);
        getSupportFragmentManager().beginTransaction().replace(R.id.main,fragment_home).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.plus:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main,fragment_plus).commit();
                        return true;
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main,fragment_home).commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main,fragment_search).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
        /**
        fragment_plus=new Fragment_Plus();
        fragment_home=new Fragment_Home();
        fragment_search=new Fragment_Search();
        setFrag(0);**/
    }

    /**
    private void setFrag(int n){
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        switch (n){
            case 0:
                fragmentTransaction.replace(R.id.main_frame,fragment_plus);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.main_frame,fragment_home);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.main_frame,fragment_search);
                fragmentTransaction.commit();
                break;
        }

    }**/
}
