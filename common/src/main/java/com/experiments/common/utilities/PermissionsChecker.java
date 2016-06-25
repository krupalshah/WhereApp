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

package com.experiments.common.utilities;

import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;

import hugo.weaving.DebugLog;

/**
 * Author : Krupal Shah
 * Date : 03-Apr-16
 */
public final class PermissionsChecker {

    /**
     * checks permission and asks if not granted
     *
     * @param appCompatActivity       activity
     * @param requestCode        permission request code
     * @param permissionsToCheck permissions to check and ask
     * @return true if all asked permissionsToCheck are granted; false otherwise
     */
    @DebugLog
    public final boolean askPermissionsIfNotGranted(AppCompatActivity appCompatActivity, int requestCode, String... permissionsToCheck) {
        boolean hasPermissionGranted = true;
        for (String permission : permissionsToCheck) {
            if (ContextCompat.checkSelfPermission(appCompatActivity, permission) == PermissionChecker.PERMISSION_GRANTED) {
                continue;
            }
            ActivityCompat.requestPermissions(appCompatActivity, permissionsToCheck, requestCode);
            hasPermissionGranted = false;
            break;
        }
        return hasPermissionGranted;
    }

    /**
     * checks grant results from {@link ActivityCompat.OnRequestPermissionsResultCallback}.
     * <br> Shows snake bar with rationale message if permission denied.
     * <br> Asks again if user allow on showing rationale
     *
     * @param appCompatActivity     activity
     * @param requestCode      permission request code
     * @param grantResults     grant results from {@link ActivityCompat.OnRequestPermissionsResultCallback}
     * @param rationaleMessage message resource id for rationale
     * @param permissionsAsked asked permissions for given request code
     * @return true if all permissions asked have been granted; false otherwise
     */
    @DebugLog
    public final boolean checkGrantResults(final AppCompatActivity appCompatActivity, final int requestCode, int[] grantResults, @StringRes int rationaleMessage, final String... permissionsAsked) {
        boolean allPermissionGranted = true;
        for (int grantResult : grantResults) {
            if (grantResult == PermissionChecker.PERMISSION_GRANTED) {
                continue;
            }
            for (String permission : permissionsAsked) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(appCompatActivity, permission)) {
                    continue;
                }
                /*appCompatActivity.showSnakeBar(rationaleMessage, R.string.allow, view -> {
                    askPermissionsIfNotGranted(appCompatActivity, requestCode, permissionsAsked);
                });*/
                break;
            }
            allPermissionGranted = false;
            break;
        }

        return allPermissionGranted;
    }

}