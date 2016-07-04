/*
 *   Copyright 2016 Krupal Shah, Harsh Bhavsar
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package com.experiments.common.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.experiments.common.listeners.AsyncTaskCallback;
import com.experiments.common.utilities.BaseUtils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import hugo.weaving.DebugLog;

/**
 * Author : Krupal Shah
 * Date : 10-Apr-16
 * <p>
 * fetches address using {@link Geocoder} from given latitude and longitude
 * gives address in callback. address can be null
 */
public class FetchAddressTask extends AsyncTask<Void, Void, String> {

    private final double mLatitude;
    private final double mLongitude;
    private final AsyncTaskCallback<String> mTaskCallback;
    private final Context mContext;
    private Geocoder mGeocoder;
    private String strAddress;

    @DebugLog
    public FetchAddressTask(Context context, double latitude, double longitude, @NonNull AsyncTaskCallback<String> asyncTaskCallback) {
        mContext = context.getApplicationContext();
        mLatitude = latitude;
        mLongitude = longitude;
        mTaskCallback = asyncTaskCallback;
    }

    @Override
    @DebugLog
    protected void onPreExecute() {
        super.onPreExecute();
        mGeocoder = new Geocoder(mContext, Locale.ENGLISH);
    }

    @Override
    @DebugLog
    protected String doInBackground(Void... params) {
        try {
            List<Address> addresses = mGeocoder.getFromLocation(mLatitude, mLongitude, 1);
            if (addresses == null || addresses.isEmpty()) return strAddress;
            strAddress = BaseUtils.generateAddressLine(addresses.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strAddress;
    }

    @Override
    @DebugLog
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mTaskCallback.onAsyncOperationCompleted(result);
    }
}
