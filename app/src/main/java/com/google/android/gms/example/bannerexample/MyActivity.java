/*
 * Copyright (C) 2013 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.gms.example.bannerexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;



import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Main Activity. Inflates main activity xml and child fragments.
 */
public class MyActivity extends ActionBarActivity {


    private Button startButton;
    private TextView YOUWIN;
    private RelativeLayout relativeLayout;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        startButton = (Button) findViewById(R.id.startButton);
        YOUWIN = (TextView) findViewById(R.id.YOUWIN);
        relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout);

        mAdView = (AdView) findViewById(R.id.ad_view);


        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();


        mAdView.loadAd(adRequest);
    }

    private void setupListeners()
    {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                YOUWIN.setVisibility(View.VISIBLE);
                relativeLayout.setBackgroundColor(Color.YELLOW);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onPause()
    {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }


    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
