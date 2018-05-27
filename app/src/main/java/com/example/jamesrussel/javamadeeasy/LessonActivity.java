package com.example.jamesrussel.javamadeeasy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.jamesrussel.javamadeeasy.fragment.FavoriteListFragment;
import com.example.jamesrussel.javamadeeasy.fragment.ProductListFragment;

public class LessonActivity extends AppCompatActivity {
    private Fragment contentFragment;
    ProductListFragment pdtListFragment;
    FavoriteListFragment favListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("content")) {
                String content = savedInstanceState.getString("content");
                if (content.equals(FavoriteListFragment.ARG_ITEM_ID)) {
                    if (fragmentManager.findFragmentByTag(FavoriteListFragment.ARG_ITEM_ID) != null) {
                        setFragmentTitle(R.string.favorites);
                        contentFragment = fragmentManager
                                .findFragmentByTag(FavoriteListFragment.ARG_ITEM_ID);
                    }
                }
            }
            if (fragmentManager.findFragmentByTag(ProductListFragment.ARG_ITEM_ID) != null) {
                pdtListFragment = (ProductListFragment) fragmentManager
                        .findFragmentByTag(ProductListFragment.ARG_ITEM_ID);
                contentFragment = pdtListFragment;
            }
        } else {
            pdtListFragment = new ProductListFragment();
            setFragmentTitle(R.string.lesson_title);
            switchContent(pdtListFragment, ProductListFragment.ARG_ITEM_ID);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (contentFragment instanceof FavoriteListFragment) {
            outState.putString("content", FavoriteListFragment.ARG_ITEM_ID);
        } else {
            outState.putString("content", ProductListFragment.ARG_ITEM_ID);
        }
        super.onSaveInstanceState(outState);
    }

    public void switchContent(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        while (fragmentManager.popBackStackImmediate());

        if (fragment != null) {
            FragmentTransaction transaction = fragmentManager
                    .beginTransaction();
            transaction.replace(R.id.content_frame, fragment, tag);
            if (!(fragment instanceof ProductListFragment)) {
                transaction.addToBackStack(tag);
            }
            transaction.commit();
            contentFragment = fragment;
        }
    }

    protected void setFragmentTitle(int resourseId) {
        setTitle(resourseId);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lesson");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {

        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            super.onBackPressed();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        } else if (contentFragment instanceof ProductListFragment
                || fm.getBackStackEntryCount() == 0) {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                super.onBackPressed();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }
}
