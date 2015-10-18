package com.csform.android.uiapptemplate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.android.uiapptemplate.adapter.SearchAdapter;
import com.csform.android.uiapptemplate.model.DummyModel;
import com.csform.android.uiapptemplate.util.DummyContent;

import java.util.ArrayList;

public class SearchBarShopActivity extends Activity implements OnClickListener {
	private static ArrayList<String> cities = new ArrayList<>();
	private static ArrayList<String> dates = new ArrayList<>();
	public static final String TAG = "Shop Search Bar";

	private EditText mSearchField;
	private EditText mSearchField1;
	private TextView mXMark;
	private TextView mXMark1;
	private View mMicrofon;
	private View mMicrofon1;
	private ListView mListView;
	private ArrayList<DummyModel> searchableArrayList;

	private TextView mShoes;
	private TextView mClothes;
	private TextView mMobile;
	private TextView mIT;
	private TextView mFoood;
	private TextView mFruits;
	private TextView mVegetable;
	private TextView mDrinks;
	private TextView mAlcohol;
	private TextView mBooks;
	
	private TextView mFilters;
	private TextView mArrow;
	private LinearLayout mFiltersLayout;
	private TextView mSearchButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE); // We hide Action
																// Bar
		setContentView(R.layout.activity_search_bar_shop);

		/*mShoes = (TextView) findViewById(R.id.activity_search_bar_shop_shoes);
		mClothes = (TextView) findViewById(R.id.activity_search_bar_shop_clothes);
		mMobile = (TextView) findViewById(R.id.activity_search_bar_shop_mobile);
		mIT = (TextView) findViewById(R.id.activity_search_bar_shop_it);
		mFoood = (TextView) findViewById(R.id.activity_search_bar_shop_food);
		mFruits = (TextView) findViewById(R.id.activity_search_bar_shop_fruits);
		mVegetable = (TextView) findViewById(R.id.activity_search_bar_shop_vegetable);
		mDrinks = (TextView) findViewById(R.id.activity_search_bar_shop_drinks);
		mAlcohol = (TextView) findViewById(R.id.activity_search_bar_shop_alcohol);
		mBooks = (TextView) findViewById(R.id.activity_search_bar_shop_books);*/
		
		/*mFilters = (TextView) findViewById(R.id.activity_search_bar_shop_filters);
		mArrow = (TextView) findViewById(R.id.activity_search_bar_shop_arrow);*/
		mSearchButton = (TextView) findViewById(R.id.search_button);
		/*mFiltersLayout = (LinearLayout) findViewById(R.id.activity_search_bar_shop_filters_layout);*/
		
		//mFilters.setOnClickListener(this);

		/*mSearchButton.setOnClickListener(this);
		mShoes.setOnClickListener(this);
		mClothes.setOnClickListener(this);
		mMobile.setOnClickListener(this);
		mIT.setOnClickListener(this);
		mFoood.setOnClickListener(this);
		mFruits.setOnClickListener(this);
		mVegetable.setOnClickListener(this);
		mDrinks.setOnClickListener(this);
		mAlcohol.setOnClickListener(this);
		mBooks.setOnClickListener(this);
		mArrow.setOnClickListener(this);*/

		mSearchField = (EditText) findViewById(R.id.search_field);
		mSearchField1 = (EditText) findViewById(R.id.search_field1);
		mXMark = (TextView) findViewById(R.id.search_x);
		mXMark1 = (TextView) findViewById(R.id.search_x1);
		mMicrofon = findViewById(R.id.search_microfon);
		mMicrofon1 = findViewById(R.id.search_microfon1);
		mListView = (ListView) findViewById(R.id.list_view);

		searchableArrayList = DummyContent.getDummyModelList();

		mXMark.setOnClickListener(this);
		mMicrofon.setOnClickListener(this);
		mXMark1.setOnClickListener(this);
		mMicrofon1.setOnClickListener(this);

		mSearchField.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@SuppressLint("DefaultLocale")
			@Override
			public void afterTextChanged(Editable editable) {
				String searchText = editable.toString().trim();
				ArrayList<String> searchedArray = new ArrayList<String>();
				for (DummyModel dm : searchableArrayList) {
					if (dm.getText().toLowerCase()
							.contains(searchText.toLowerCase())) {
						searchedArray.add(dm.getText());
					}
				}
				if (searchText.isEmpty()) {
					mListView.setAdapter(null);
					mXMark.setText(R.string.fontello_x_mark);
				} else {
					mListView.setAdapter(new SearchAdapter(
							SearchBarShopActivity.this, searchedArray));
					mXMark.setText(R.string.fontello_x_mark_masked);
				}
			}
		});

		mSearchField1.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@SuppressLint("DefaultLocale")
			@Override
			public void afterTextChanged(Editable editable) {
				String searchText = editable.toString().trim();
				ArrayList<String> searchedArray = new ArrayList<String>();
				for (DummyModel dm : searchableArrayList) {
					if (dm.getText().toLowerCase()
							.contains(searchText.toLowerCase())) {
						searchedArray.add(dm.getText());
					}
				}
				if (searchText.isEmpty()) {
					mListView.setAdapter(null);
					mXMark1.setText(R.string.fontello_x_mark);
				} else {
					mListView.setAdapter(new SearchAdapter(
							SearchBarShopActivity.this, searchedArray));
					mXMark1.setText(R.string.fontello_x_mark_masked);
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.search_x:
				cities.add(mSearchField.getText().toString());
				System.out.println(cities);
				mSearchField.setText(null);
				//dates.add(mSearchField1.getText().toString());
				//System.out.println(dates);
				//mSearchField1.setText(null);
				break;

			case R.id.search_x1:
				//System.out.println(1);
				dates.add(mSearchField1.getText().toString());
				System.out.println(dates);
				mSearchField1.setText(null);
				break;

			case R.id.search_microfon:
                startActivity(new Intent(SearchBarShopActivity.this, ExpandableListViewActivity.class));
                /*System.out.println("in search_microfon");
                try {

                    Toast.makeText(this, "Calculating Optimal Route!", Toast.LENGTH_LONG).show();
                String urlString = "http://andyfang.me:5555/route/";
                urlString = urlString + cities.get(0) + "/" + cities.get(0);
                for(int i = 1; i < cities.size(); i++) {
                    if(cities.get(i) != ""){
                    urlString = urlString + "," + cities.get(i);
                    }
                }
                urlString += "/2/";
                double startDate = Double.parseDouble(dates.get(0));
                double endDate = Double.parseDouble(dates.get(1));
                int duration =(int)((Math.floor(endDate) - Math.floor(startDate)) * 30 + (endDate - startDate) * 100);
                urlString += duration;
                urlString = urlString.trim();
                // end of url preparation

                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                System.out.println(urlString);
                String flightJsonStr;

                    URL url = new URL(urlString);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    // Read the input stream into a String
                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer buffer = new StringBuffer();
                    if (inputStream == null) {
                        // Nothing to do.
                        //return null;
                    }
                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                        // But it does make debugging a *lot* easier if you print out the completed
                        // buffer for debugging.
                        buffer.append(line + "\n");
                    }

                    if (buffer.length() == 0) {
                        // Stream was empty.  No point in parsing.
                        //return null;
                    }
                    flightJsonStr = buffer.toString();
                    System.out.println(flightJsonStr);//printing the dictionary returned by the server
                } catch (IOException e) {
                    //Log.e(LOG_TAG, "Error ", e);
                    // If the code didn't successfully get the weather data, there's no point in attemping
                    // to parse it.
                    //return null;
                }*/
				break;

			case R.id.search_microfon1:
				Toast.makeText(this, "Implement voice search", Toast.LENGTH_LONG)
						.show();
				break;
			default:
				System.out.println("default");
				break;
		}

		/*case R.id.activity_search_bar_shop_shoes:
			if (mShoes.getText() == getString(R.string.material_icon_check_empty)) {
				mShoes.setText(getString(R.string.material_icon_check_full));
			} else {
				mShoes.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_clothes:
			if (mClothes.getText() == getString(R.string.material_icon_check_empty)) {
				mClothes.setText(getString(R.string.material_icon_check_full));
			} else {
				mClothes.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_mobile:
			if (mMobile.getText() == getString(R.string.material_icon_check_empty)) {
				mMobile.setText(getString(R.string.material_icon_check_full));
			} else {
				mMobile.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_it:
			if (mIT.getText() == getString(R.string.material_icon_check_empty)) {
				mIT.setText(getString(R.string.material_icon_check_full));
			} else {
				mIT.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_food:
			if (mFoood.getText() == getString(R.string.material_icon_check_empty)) {
				mFoood.setText(getString(R.string.material_icon_check_full));
			} else {
				mFoood.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_fruits:
			if (mFruits.getText() == getString(R.string.material_icon_check_empty)) {
				mFruits.setText(getString(R.string.material_icon_check_full));
			} else {
				mFruits.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_vegetable:
			if (mVegetable.getText() == getString(R.string.material_icon_check_empty)) {
				mVegetable
						.setText(getString(R.string.material_icon_check_full));
			} else {
				mVegetable
						.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_drinks:
			if (mDrinks.getText() == getString(R.string.material_icon_check_empty)) {
				mDrinks.setText(getString(R.string.material_icon_check_full));
			} else {
				mDrinks.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_alcohol:
			if (mAlcohol.getText() == getString(R.string.material_icon_check_empty)) {
				mAlcohol.setText(getString(R.string.material_icon_check_full));
			} else {
				mAlcohol.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_books:
			if (mBooks.getText() == getString(R.string.material_icon_check_empty)) {
				mBooks.setText(getString(R.string.material_icon_check_full));
			} else {
				mBooks.setText(getString(R.string.material_icon_check_empty));
			}
			break;
		case R.id.activity_search_bar_shop_filters:
			if(mFiltersLayout.getVisibility() == View.VISIBLE) {
				mFiltersLayout.setVisibility(View.GONE);
			} else {
				mFiltersLayout.setVisibility(View.VISIBLE);
			}
			if (mArrow.getText() == getString(R.string.material_icon_chevron_up)) {
				mArrow.setText(getString(R.string.material_icon_chevron_down));
			} else {
				mArrow.setText(getString(R.string.material_icon_chevron_up));
			}
			break;
		case R.id.activity_search_bar_shop_arrow:
			if(mFiltersLayout.getVisibility() == View.VISIBLE) {
				mFiltersLayout.setVisibility(View.GONE);
			} else {
				mFiltersLayout.setVisibility(View.VISIBLE);
			}
			if (mArrow.getText() == getString(R.string.material_icon_chevron_up)) {
				mArrow.setText(getString(R.string.material_icon_chevron_down));
			} else {
				mArrow.setText(getString(R.string.material_icon_chevron_up));
			}
			break;
		case R.id.search_button:
			Toast.makeText(this, "SEARCH", Toast.LENGTH_SHORT);
			break;
		*/
	}
}
