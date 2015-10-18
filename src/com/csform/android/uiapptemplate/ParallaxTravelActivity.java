package com.csform.android.uiapptemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.csform.android.uiapptemplate.adapter.ParallaxTravelAdapter;
import com.csform.android.uiapptemplate.util.DummyContent;
import com.csform.android.uiapptemplate.view.pzv.PullToZoomListViewEx;

public class ParallaxTravelActivity extends ActionBarActivity {

	public static final String TAG = "Parallax travel";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private boolean mShouldFinish = false;

	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parallax_travel);

		iv = (ImageView) findViewById(R.id.header_parallax_travel_image);

		PullToZoomListViewEx listView = (PullToZoomListViewEx) findViewById(R.id.paralax_travel_list_view);
		listView.setShowDividers(0);
		listView.setAdapter(new ParallaxTravelAdapter(this, DummyContent
                .getDummyModelListTravel(), false));

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Travel");
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);*/
		getSupportActionBar().hide();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
    @Override
    public void onBackPressed() {
        startActivity(new Intent(ParallaxTravelActivity.this, MainActivity.class));
        /*if (!mShouldFinish && !mDrawerLayout.isDrawerOpen(mDrawerList)) {
            Toast.makeText(getApplicationContext(), R.string.confirm_exit,
                    Toast.LENGTH_SHORT).show();
            mShouldFinish = true;
            mDrawerLayout.openDrawer(mDrawerList);
        } else if (!mShouldFinish && mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            super.onBackPressed();
        }*/
    }
}
