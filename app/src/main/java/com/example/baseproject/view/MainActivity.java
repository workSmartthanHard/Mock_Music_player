package com.example.baseproject.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.BottomNavigationViewKt;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Switch;

import com.example.baseproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

//  private NavController mNavController;
//  private NavHostFragment mNavHostFragment;

  private BottomNavigationView bottomNavigationView;

  Home homeFragment = new Home();
  Setting settingFragment = new Setting();
  Songs songsFragment = new Songs();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bottomNavigationView = findViewById(R.id.bottom_navigation_view);
    bottomNavigationView.setItemIconTintList(null);
    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,homeFragment).commit();

    bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
          case R.id.btn_bottom_nav_home:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,homeFragment).commit();
            return true;
          case R.id.btn_bottom_nav_songs:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,songsFragment).commit();
            return true;
          case R.id.btn_bottom_nav_setting:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,settingFragment).commit();
            return true;
        }
        return false;
      }
    });


//    mNavHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
//    mNavController = mNavHostFragment.getNavController();
//
//    NavigationUI.setupActionBarWithNavController(this,mNavController);

  }

  @Override
  public boolean onSupportNavigateUp() {
    return super.onSupportNavigateUp();
  }
}

