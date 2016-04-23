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

package com.droidexperiments.android.pinplace.interfaces.presenters.base;

import android.app.Dialog;
import android.support.annotation.StringRes;

import com.droidexperiments.android.pinplace.utilities.PermissionsHelper;

/**
 * Author : Krupal Shah
 * Date : 10-Apr-16
 */
public interface BaseAppPresenter {

    void showToast(@StringRes int msgResId);

    void showToast(String msg);

    void dismissDialogs(Dialog... dialogs);

    PermissionsHelper providePermissionsHelper();

    boolean isComponentDestroyed();

}