package com.example.aplikasiskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aplikasiskripsi.Fragment.About;
import com.example.aplikasiskripsi.Fragment.DetailPahlawan;
import com.example.aplikasiskripsi.Fragment.Pahlawan;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String recycler = "List";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        Fragment fragment = null;

        fragment = new Pahlawan();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_RECYCLER",recycler);
        fragment = new Pahlawan();
        fragment.setArguments(bundle);

        //IF ELSE
        Intent data = getIntent();
        String DetailExtra = data.getStringExtra("DetailExtra");
        final String Nama = data.getStringExtra("Nama");
        final String Remarks = data.getStringExtra("Remarks");
        final String Photo = data.getStringExtra("Photo");
        final String Detail = data.getStringExtra("Detail");
        final String Lahir = data.getStringExtra("Lahir");
        final String Wafat = data.getStringExtra("Wafat");
        if(DetailExtra != null){
            bundle = new Bundle();
            bundle.putString("Nama",Nama);
            bundle.putString("Remarks",Remarks);
            bundle.putString("Photo",Photo);
            bundle.putString("Detail",Detail);
            bundle.putString("Lahir",Lahir);
            bundle.putString("Wafat",Wafat);
            fragment = new DetailPahlawan();
            fragment.setArguments(bundle);
        }
        //DONE

        ChangeFragment(fragment);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        recycler = "List";

        switch (item.getItemId()){
            case R.id.action_list:
                recycler = "List";
                FragmentBundle(recycler);
                break;
            case R.id.action_grid:
                recycler = "Grid";
                FragmentBundle(recycler);
                break;
            case R.id.action_cardview:
                recycler = "CardView";
                FragmentBundle(recycler);
                break;
        }
        FragmentBundle(recycler);
        return super.onOptionsItemSelected(item);
    }

    private void FragmentBundle(String Recycler){
        Bundle bundle = new Bundle();
        bundle.putString("KEY_RECYCLER",Recycler);
        Fragment fragment = new Pahlawan();
        fragment.setArguments(bundle);
        ChangeFragment(fragment);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_dashboard) {
            fragment = new Pahlawan();
        } else if (id == R.id.nav_about) {
            fragment = new About();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void ChangeFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.Container,fragment);
            ft.commit();
        }
    }
}
