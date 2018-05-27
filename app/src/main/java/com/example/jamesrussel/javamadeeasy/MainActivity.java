package com.example.jamesrussel.javamadeeasy;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.jamesrussel.javamadeeasy.fragment.FavoriteListFragment;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemLongClickListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements OnMenuItemClickListener, OnMenuItemLongClickListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    private final static String APP_TITLE = "SampleApp Rater";
    private final static String APP_PACKAGE_NAME = "com.example.jamesrussel.javamadeeasy";
    private ContextMenuDialogFragment mMenuDialogFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        initMenuFragment();
        addFragment(new HomeFragment(), true, R.id.main_container);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Java Made Easy");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Java Made Easy");
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Java Made Easy");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.bookmark_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                        fragmentTransaction.replace(R.id.main_container, new FavoriteListFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Bookmarks");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.references_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                        fragmentTransaction.replace(R.id.main_container, new ReferencesFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("References");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.feedback_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                        fragmentTransaction.replace(R.id.main_container, new FeedbackFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Feedback");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.about_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                        fragmentTransaction.replace(R.id.main_container, new AboutFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.developers_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                        fragmentTransaction.replace(R.id.main_container, new DevelopersFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Developers Profile");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                }

                return false;
            }
        });

    }

    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(this);
        mMenuDialogFragment.setItemLongClickListener(this);
    }

    private List<MenuObject> getMenuObjects() {
        // You can use any [resource, bitmap, drawable, color] as image:
        // item.setResource(...)
        // item.setBitmap(...)
        // item.setDrawable(...)
        // item.setColor(...)
        // You can set image ScaleType:
        // item.setScaleType(ScaleType.FIT_XY)
        // You can use any [resource, drawable, color] as background:
        // item.setBgResource(...)
        // item.setBgDrawable(...)
        // item.setBgColor(...)
        // You can use any [color] as text color:
        // item.setTextColor(...)
        // You can set any [color] as divider color:
        // item.setDividerColor(...)

        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject settings = new MenuObject("Settings");
        settings.setResource(R.drawable.icn_settings);

        MenuObject help = new MenuObject("Help");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_help2);
        help.setBitmap(b);

        MenuObject share = new MenuObject("Share");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_share));
        share.setDrawable(bd);

        MenuObject exit = new MenuObject("Exit");
        exit.setResource(R.drawable.icn_exit);


        menuObjects.add(close);
        menuObjects.add(settings);
        menuObjects.add(help);
        menuObjects.add(share);
        menuObjects.add(exit);
        return menuObjects;
    }

    protected void addFragment(Fragment fragment, boolean addToBackStack, int containerId) {
        invalidateOptionsMenu();
        String backStackName = fragment.getClass().getName();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStackName, 0);
        if (!fragmentPopped) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(containerId, fragment, backStackName);
            if (addToBackStack)
                transaction.addToBackStack(backStackName);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main1, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:
                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onMenuItemClick(View clickedView, int position) {
        switch (position) {
            case 1:
                new SettingsActivity();
                Intent settings = new Intent(getApplicationContext(), SettingsActivity.class);
                settings.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(settings);
                break;
            case 2:
                HelpMethod();
                break;
            case 3:
                shareApplication();
                break;
            case 4:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Exit");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Are you sure you want to exit?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", null);
                AlertDialog dialog = builder.create();
                dialog.show();
        }
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {

    }
    @Override
    public void onBackPressed() {
        /*if (mMenuDialogFragment != null && mMenuDialogFragment.isAdded()) {
            mMenuDialogFragment.dismiss();
        } else {
            buildDialog(R.style.DialogAnimation_2, "Are you sure you want to exit?");
             }*/
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            buildDialog(R.style.DialogAnimation_2, "Are you sure you want to exit?");
        }
    }

    private void buildDialog(int animationSource, String type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage(type);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
    }

    public void HelpMethod(){
        HelpDialog helpDialog= new HelpDialog();
        helpDialog.show(getSupportFragmentManager(), "Help");
    }

    private void shareApplication() {
        ApplicationInfo app = getApplicationContext().getApplicationInfo();
        String filePath = app.sourceDir;
        Intent intent = new Intent(Intent.ACTION_SEND);
// MIME of .apk is "application/vnd.android.package-archive".
// but Bluetooth does not accept this. Let's use "*/*" instead.
        intent.setType("*/*");
// Append file and send Intent
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
        startActivity(Intent.createChooser(intent, "Share app via"));
    }


}




