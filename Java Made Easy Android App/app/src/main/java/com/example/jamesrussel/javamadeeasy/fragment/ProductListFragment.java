package com.example.jamesrussel.javamadeeasy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jamesrussel.javamadeeasy.Lesson1;
import com.example.jamesrussel.javamadeeasy.Lesson10;
import com.example.jamesrussel.javamadeeasy.Lesson2;
import com.example.jamesrussel.javamadeeasy.Lesson3;
import com.example.jamesrussel.javamadeeasy.Lesson4;
import com.example.jamesrussel.javamadeeasy.Lesson5;
import com.example.jamesrussel.javamadeeasy.Lesson6;
import com.example.jamesrussel.javamadeeasy.Lesson7;
import com.example.jamesrussel.javamadeeasy.Lesson8;
import com.example.jamesrussel.javamadeeasy.Lesson9;
import com.example.jamesrussel.javamadeeasy.R;
import com.example.jamesrussel.javamadeeasy.adapter.ProductListAdapter;
import com.example.jamesrussel.javamadeeasy.beans.Product;
import com.example.jamesrussel.javamadeeasy.utils.SharedPreference;

import java.util.ArrayList;
import java.util.List;



public class ProductListFragment extends Fragment implements
        OnItemClickListener, OnItemLongClickListener {

    public static final String ARG_ITEM_ID = "favorite_list";
    Activity activity;
    ListView productListView;
    List<Product> products;
    ProductListAdapter productListAdapter;

    SharedPreference sharedPreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        sharedPreference = new SharedPreference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container,
                false);
        findViewsById(view);

        setProducts();

        productListAdapter = new ProductListAdapter(activity, products);
        productListView.setAdapter(productListAdapter);
        productListView.setOnItemClickListener(this);
        productListView.setOnItemLongClickListener(this);
        return view;
    }

    private void setProducts() {

        Product product1 = new Product(1, "Chapter 1", "Introduction", 60000);
        Product product2 = new Product(2, "Chapter 2",
                "Object Oriented Programming", 50000);
        Product product3 = new Product(3, "Chapter 3",
                "Variable and Data types", 45000);
        Product product4 = new Product(4, "Chapter 4",
                "Operators and Expressions", 46000);
        Product product5 = new Product(5, "Chapter 5",
                "Flow Control", 48000);
        Product product6 = new Product(6, "Chapter 6", "Classes and Objects",
                50000);
        Product product7 = new Product(7, "Chapter 7",
                "Arrays, String and Vector", 40000);
        Product product8 = new Product(8, "Chapter 8",
                "Interfaces", 38000);
        Product product9 = new Product(9, "Chapter 9",
                "Packages", 39000);
        Product product10 = new Product(10, "Chapter 10",
                "Multithreading Programming", 50000);

        products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);
    }

    private void findViewsById(View view) {
        productListView = (ListView) view.findViewById(R.id.list_product);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Product product = (Product) parent.getItemAtPosition(position);
        if (product.getId() == 1){
            Intent intent = new Intent(getContext(), Lesson1.class);
            startActivity(intent);
        }
        if (product.getId() == 2){
            Intent intent = new Intent(getContext(), Lesson2.class);
            startActivity(intent);
        }
        if (product.getId() == 3){
            Intent intent = new Intent(getContext(), Lesson3.class);
            startActivity(intent);
        }
        if (product.getId() == 4){
            Intent intent = new Intent(getContext(), Lesson4.class);
            startActivity(intent);
        }
        if (product.getId() == 5){
            Intent intent = new Intent(getContext(), Lesson5.class);
            startActivity(intent);
        }
        if (product.getId() == 6){
            Intent intent = new Intent(getContext(), Lesson6.class);
            startActivity(intent);
        }
        if (product.getId() == 7){
            Intent intent = new Intent(getContext(), Lesson7.class);
            startActivity(intent);
        }
        if (product.getId() == 8){
            Intent intent = new Intent(getContext(), Lesson8.class);
            startActivity(intent);
        }
        if (product.getId() == 9){
            Intent intent = new Intent(getContext(), Lesson9.class);
            startActivity(intent);
        }
        if (product.getId() == 10){
            Intent intent = new Intent(getContext(), Lesson10.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View view,
                                   int position, long arg3) {
        ImageView button = (ImageView) view.findViewById(R.id.imgbtn_favorite);

        String tag = button.getTag().toString();
        if (tag.equalsIgnoreCase("grey")) {
            sharedPreference.addFavorite(activity, products.get(position));
            Toast.makeText(activity,
                    activity.getResources().getString(R.string.add_favr),
                    Toast.LENGTH_SHORT).show();

            button.setTag("red");
            button.setImageResource(R.drawable.bookmark_active);
        } else {
            sharedPreference.removeFavorite(activity, products.get(position));
            button.setTag("grey");
            button.setImageResource(R.drawable.bookmark_grey);
            Toast.makeText(activity,
                    activity.getResources().getString(R.string.remove_favr),
                    Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
