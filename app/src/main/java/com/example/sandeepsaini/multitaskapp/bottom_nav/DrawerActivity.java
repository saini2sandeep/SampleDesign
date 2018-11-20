package com.example.sandeepsaini.multitaskapp.bottom_nav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sandeepsaini.multitaskapp.BottomNavigationViewHelper;
import com.example.sandeepsaini.multitaskapp.ExpendListActivity;
import com.example.sandeepsaini.multitaskapp.ExpendableListActivity2;
import com.example.sandeepsaini.multitaskapp.HomeFragment;
import com.example.sandeepsaini.multitaskapp.HomePageActivity;
import com.example.sandeepsaini.multitaskapp.R;
import com.example.sandeepsaini.multitaskapp.VegitableFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView stories;
    private TextView noticeBoard;
    private TextView chats;
    private ImageView logoImage;

    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;

    private VegitableFragment vegitableFragment;
    private HomeFragment homeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);


        stories = findViewById(R.id.stories_tv);
        chats = findViewById(R.id.chats_tv);
        noticeBoard = findViewById(R.id.notice_board_tv);
        logoImage = findViewById(R.id.home_app_logo_iv);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        navigation.setItemIconTintList(null);
//        Menu menu = navigation.getMenu();
//        menu.findItem(R.id.navigation_home).setIcon(getDrawable(R.drawable.ic_home_unselect));

        BottomNavigationViewHelper.disableShiftMode(navigation);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        vegitableFragment = VegitableFragment.newInstance();
        homeFragment = HomeFragment.newInstance();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this, ExpendListActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(this, ExpendableListActivity2.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(this, HomePageActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = homeFragment;
//                    mTextMessage.setText(R.string.title_home);
                    //  item.setIcon(getDrawable(R.drawable.ic_home));
                    manageHomeToolbarIcon("HOME");
                    break;
                case R.id.navigation_dashboard:
                    fragment = vegitableFragment;
//                    mTextMessage.setText(R.string.title_dashboard);
                    manageHomeToolbarIcon("VEJ");
                    break;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    manageHomeToolbarIcon("CHATS");
                    break;
                case R.id.navigation_notifications2:
//                    mTextMessage.setText(R.string.title_notifications);
                    manageHomeToolbarIcon("NOTICEBOARD");
                    break;
                case R.id.navigation_notifications3:

//                    mTextMessage.setText(R.string.title_notifications);
                    break;
            }
            return loadFragment(fragment);
        }
    };


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    private void manageHomeToolbarIcon(String source) {

        switch (source) {
            case "HOME":
                logoImage.setVisibility(View.VISIBLE);
                stories.setVisibility(View.GONE);
                chats.setVisibility(View.GONE);
                noticeBoard.setVisibility(View.GONE);
                break;
            case "STORIES":
                logoImage.setVisibility(View.GONE);
                stories.setVisibility(View.VISIBLE);
                chats.setVisibility(View.GONE);
                noticeBoard.setVisibility(View.GONE);
                break;
            case "CHATS":
                logoImage.setVisibility(View.GONE);
                stories.setVisibility(View.GONE);
                chats.setVisibility(View.VISIBLE);
                noticeBoard.setVisibility(View.GONE);
                break;
            case "NOTICEBOARD":
                logoImage.setVisibility(View.GONE);
                stories.setVisibility(View.GONE);
                chats.setVisibility(View.GONE);
                noticeBoard.setVisibility(View.VISIBLE);
                break;
            default:
                logoImage.setVisibility(View.VISIBLE);
                stories.setVisibility(View.GONE);
                chats.setVisibility(View.GONE);
                noticeBoard.setVisibility(View.GONE);
                break;
        }
    }
}
