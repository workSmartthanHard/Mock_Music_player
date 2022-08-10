package com.example.baseproject.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.BottomNavigationViewKt;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;

import com.example.baseproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

//  private NavController mNavController;
//  private NavHostFragment mNavHostFragment;

  private BottomNavigationView mBottomNavigationView;
  private DrawerLayout mDrawerLayout;
  private Toolbar mToolBar;
  private NavigationView mNavigationView;
  private ActionBarDrawerToggle mActionBarDrawerToggle;
  private SearchView mSearchView;

  Home homeFragment = new Home();
  Setting settingFragment = new Setting();
  Songs songsFragment = new Songs();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
    mBottomNavigationView.setItemIconTintList(null);

    mNavigationView = findViewById(R.id.nav_drawer);
    mNavigationView.setItemIconTintList(null);

    mDrawerLayout = findViewById(R.id.drawer_layout);
    mToolBar = findViewById(R.id.tool_bar);
    setSupportActionBar(mToolBar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    mSearchView = findViewById(R.id.search_bar);
    mSearchView.setQueryHint("Search album song");
//    mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//      @Override
//      public boolean onQueryTextSubmit(String query) {
//        return false;
//      }
//
//      @Override
//      public boolean onQueryTextChange(String newText) {
//        return false;
//      }
//    });


    mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolBar,R.string.open_drawer,R.string.close_drawer);
    mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    mActionBarDrawerToggle.syncState();
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.burger_menu);

    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,homeFragment).commit();

    mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
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

