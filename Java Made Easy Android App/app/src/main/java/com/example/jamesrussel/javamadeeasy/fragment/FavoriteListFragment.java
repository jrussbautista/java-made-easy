package com.example.jamesrussel.javamadeeasy.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.jamesrussel.javamadeeasy.MainActivity;
import com.example.jamesrussel.javamadeeasy.R;
import com.example.jamesrussel.javamadeeasy.adapter.ProductListAdapter;
import com.example.jamesrussel.javamadeeasy.beans.Product;
import com.example.jamesrussel.javamadeeasy.utils.SharedPreference;

import java.util.List;

public class FavoriteListFragment extends Fragment {

	public static final String ARG_ITEM_ID = "favorite_list";

	ListView favoriteList;
	SharedPreference sharedPreference;
	List<Product> favorites;

	Activity activity;
	ProductListAdapter productListAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_product_list, container,
				false);
		setHasOptionsMenu(true);
		sharedPreference = new SharedPreference();
		favorites = sharedPreference.getFavorites(activity);

		if (favorites == null) {
			showAlert(getResources().getString(R.string.no_favorites_items),
					getResources().getString(R.string.no_favorites_msg));
		} else {

			if (favorites.size() == 0) {
				showAlert(
						getResources().getString(R.string.no_favorites_items),
						getResources().getString(R.string.no_favorites_msg));
			}

			favoriteList = (ListView) view.findViewById(R.id.list_product);
			if (favorites != null) {
				productListAdapter = new ProductListAdapter(activity, favorites);
				favoriteList.setAdapter(productListAdapter);


				favoriteList.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> parent, View arg1,
											int position, long id) {
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
			});

				favoriteList
						.setOnItemLongClickListener(new OnItemLongClickListener() {

							@Override
							public boolean onItemLongClick(
									AdapterView<?> parent, View view,
									int position, long id) {

								ImageView button = (ImageView) view
										.findViewById(R.id.imgbtn_favorite);

								String tag = button.getTag().toString();
								if (tag.equalsIgnoreCase("grey")) {
									sharedPreference.addFavorite(activity,
											favorites.get(position));
									Toast.makeText(
											activity,
											activity.getResources().getString(
													R.string.add_favr),
											Toast.LENGTH_SHORT).show();
									button.setTag("red");
									button.setImageResource(R.drawable.bookmark_active);
								} else {
									sharedPreference.removeFavorite(activity,
											favorites.get(position));
									button.setTag("grey");
									button.setImageResource(R.drawable.bookmark_grey);
									productListAdapter.remove(favorites
											.get(position));
									Toast.makeText(
											activity,
											activity.getResources().getString(
													R.string.remove_favr),
											Toast.LENGTH_SHORT).show();
								}
								return true;
							}
						});
			}
		}
		return view;
	}

	public void showAlert(String title, String message) {
		if (activity != null && !activity.isFinishing()) {
			AlertDialog alertDialog = new AlertDialog.Builder(activity)
					.create();
			alertDialog.setTitle(title);
			alertDialog.setMessage(message);
			alertDialog.setCancelable(false);

			// setting OK Button
			alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							// activity.finish();
							getFragmentManager().popBackStackImmediate();
						}
					});
			alertDialog.show();
		}
	}


	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		MenuItem item=menu.findItem(R.id.context_menu);
		item.setVisible(false);
	}

	@Override
	public void onResume() {
		super.onResume();

		if(getView() == null){
			return;
		}
		getView().setFocusableInTouchMode(true);
		getView().requestFocus();
		getView().setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
					getActivity().finish();
					Intent intent = new Intent(getActivity(), MainActivity.class);
					startActivity(intent);
					return true;
				}
				return false;
			}
		});

	}
}
