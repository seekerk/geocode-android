package org.fruct.oss.geocode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener {
    private static String TAG = MainActivity.class.getName();

    ActionBarDrawerToggle mDrawerToggle;

    /** Настройки приложения */
    SharedPreferences pref;

    private boolean mToolBarNavigationListenerIsRegistered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        pref = PreferenceManager.getDefaultSharedPreferences(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.container, AddItemFragment.getInstance(), "add-item");
//                ft.addToBackStack(null);
//                ft.commit();
//            }
//        });

        //Listen for changes in the back stack
        getSupportFragmentManager().addOnBackStackChangedListener(this);

        displayView(R.id.nav_points);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add: {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, AddItemFragment.getInstance());
                ft.addToBackStack(null);
                ft.commit();
                return true;
            }
            case R.id.action_settings: {
                //TODO: add settings window
                Log.w(TAG, "Not implemented");
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displayView(id);

        return true;

    }

    private void displayView(int id) {
        //TODO:
        Fragment f = null;

        if (id == R.id.nav_points) {
            // отображение списка контактов (по умолчанию
            //f = ContactsFragment.newInstance();
            f = new MainActivityFragment();
            Log.d(TAG, "Show contacts");
        }

        if (f != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, f);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }


    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
        hideSoftKeyboard();

    }

    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canback = getSupportFragmentManager().getBackStackEntryCount()>0;
        Log.d(TAG, "Fragment stack contains " + getSupportFragmentManager().getBackStackEntryCount() + " items");
        showBackButton(canback);
    }

    public void hideSoftKeyboard() {
        if (this.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) this.getSystemService(
                            Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(
                    this.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * To be semantically or contextually correct, maybe change the name
     * and signature of this function to something like:
     *
     * private void showBackButton(boolean show)
     * Just a suggestion.
     */
    private void showBackButton(boolean show) {

        // To keep states of ActionBar and ActionBarDrawerToggle synchronized,
        // when you enable on one, you disable on the other.
        // And as you may notice, the order for this operation is disable first, then enable - VERY VERY IMPORTANT.
        if(show) {
            if(!mToolBarNavigationListenerIsRegistered) {
                // Remove hamburger
                mDrawerToggle.setDrawerIndicatorEnabled(false);
                // Show back button
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                // when DrawerToggle is disabled i.e. setDrawerIndicatorEnabled(false), navigation icon
                // clicks are disabled i.e. the UP button will not work.
                // We need to add a listener, as in below, so DrawerToggle will forward
                // click events to this listener.
                mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Doesn't have to be onBackPressed
                        onBackPressed();
                    }
                });

                mToolBarNavigationListenerIsRegistered = true;
            }
        } else {
            // Remove back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // Show hamburger
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            // Remove the/any drawer toggle listener
            mDrawerToggle.setToolbarNavigationClickListener(null);
            mToolBarNavigationListenerIsRegistered = false;
        }

        // So, one may think "Hmm why not simplify to:
        // .....
        // getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        // mDrawer.setDrawerIndicatorEnabled(!enable);
        // ......
        // To re-iterate, the order in which you enable and disable views IS important #dontSimplify.
    }


}
