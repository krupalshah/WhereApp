/*
 *
 *  Copyright  (c) 2016 Krupal Shah, Harsh Bhavsar
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

package com.experiments.whereapp.config;

import com.experiments.core.config.BaseConfig;
import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Author : Krupal Shah
 * Date : 17-Apr-16
 * <p>
 * configuration class specific for local db
 */
@Database(name = DbConfig.NAME, version = DbConfig.VERSION)
public class DbConfig extends BaseConfig {
    public static final String NAME = "wheredb";
    public static final int VERSION = 0;
}
