/*
 *   Copyright  (c) 2016 Krupal Shah, Harsh Bhavsar
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.experiments.whereapp.modules.home.fragments;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import android.view.View;

import com.experiments.common.android.fragments.BaseFragment;
import com.experiments.whereapp.events.OnCurrentPlaceUpdated;
import com.google.android.gms.location.places.Place;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import hugo.weaving.DebugLog;

public abstract class BaseHomeFragment extends BaseFragment {

    protected EventBus eventBus;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents();
    }

    @Override
    public void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    @CallSuper
    @Override
    protected void initComponents() {
        eventBus = EventBus.getDefault();
    }


    @DebugLog
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCurrentPlaceUpdatedEvent(OnCurrentPlaceUpdated onCurrentPlaceUpdated) {
        Place place = onCurrentPlaceUpdated.getCurrentPlace().getPlaceData();
        if (place == null) return;
        //updating address
        CharSequence address = place.getAddress();
        if (TextUtils.isEmpty(address)) return;
        updateAddress(address);
    }

    protected abstract void updateAddress(CharSequence address);

}
