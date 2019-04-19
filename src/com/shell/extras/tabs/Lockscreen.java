/*
 * Copyright (C) 2017 The Dirty Unicorns Project
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

package com.shell.extras.tabs;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.preference.ListPreference;
import android.preference.Preference.OnPreferenceChangeListener;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.nano.MetricsProto;

public class Lockscreen extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

    private ListPreference clockAlign, clockSelect;
    private PreferenceScreen preferenceScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.lockscreen);
        preferenceScreen = getPreferenceScreen();
        clockSelect = (ListPreference) findPreference("lockscreen_clock_selection");
        clockAlign = (ListPreference) findPreference("lockscreen_text_clock_align");
        clockSelect.setOnPreferenceChangeListener(this);
        String value = clockSelect.getValue();
        if (value.equals("6")) {
            preferenceScreen.addPreference(clockAlign);
        } else {
            preferenceScreen.removePreference(clockAlign);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        if (objValue.toString().equals("6")) {
            preferenceScreen.addPreference(clockAlign);
        } else {
            preferenceScreen.removePreference(clockAlign);
        }
        return true;
    }


    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.SHELLEXTRAS;
    }
}
