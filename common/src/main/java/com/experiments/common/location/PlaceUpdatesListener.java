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

import android.location.Location;

import com.google.android.gms.location.LocationSettingsResult;

/**
 * Author : Krupal Shah
 * Date : 10-Apr-16
 */
public interface PlaceUpdatesListener {

    void onApiClientConnected();

    void onLocationSettingsResult(LocationSettingsResult locationSettingsResult);

    void onGotLastKnownPlace(Place lastKnownPlace);

    void onLocationUpdated(Location newLocation);

}
