package com.example.courseraapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsFragment extends Fragment {
    public static final String APP_PREFERENCES = "preferences";
    public static final String APP_PREFERENCES_NAME = "Browser";
    public static final String APP_BOOLEAN_YANDEX = "yandex";
    public static final String APP_BOOLEAN_GOOGLE = "google";
    public static final String APP_BOOLEAN_BING = "bing";
    private RadioGroup radioGroup;
    private RadioButton yandex,google,bing;
     SharedPreferences mSettings;
    public SettingsFragment() {

    }

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        yandex=view.findViewById(R.id.radio_yandex);
        google=view.findViewById(R.id.radio_google);
        bing=view.findViewById(R.id.radio_bing);
        radioGroup=view.findViewById(R.id.radioGroup);
        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        yandex.setOnClickListener(radioClickListener);
        google.setOnClickListener(radioClickListener);
        bing.setOnClickListener(radioClickListener);
        yandex.setChecked(mSettings.getBoolean(APP_BOOLEAN_YANDEX,false));
        google.setChecked(mSettings.getBoolean(APP_BOOLEAN_GOOGLE,false));
        bing.setChecked(mSettings.getBoolean(APP_BOOLEAN_BING,false));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    View.OnClickListener radioClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.radio_yandex:
                    mSettings
                            .edit()
                            .putString(APP_PREFERENCES_NAME,"Yandex")
                            .putBoolean(APP_BOOLEAN_YANDEX,true)
                            .putBoolean(APP_BOOLEAN_GOOGLE,false)
                            .putBoolean(APP_BOOLEAN_BING,false)
                            .apply();
                    break;
                case R.id.radio_google:
                    mSettings
                            .edit()
                            .putString(APP_PREFERENCES_NAME,"Google")
                            .putBoolean(APP_BOOLEAN_GOOGLE,true)
                            .putBoolean(APP_BOOLEAN_BING,false)
                            .putBoolean(APP_BOOLEAN_YANDEX,false)
                            .apply();
                    break;
                case R.id.radio_bing:
                    mSettings
                            .edit()
                            .putString(APP_PREFERENCES_NAME,"Bing")
                            .putBoolean(APP_BOOLEAN_BING,true)
                            .putBoolean(APP_BOOLEAN_YANDEX,false)
                            .putBoolean(APP_BOOLEAN_GOOGLE,false)
                            .apply();
                    break;
                default:
                    break;
            }
        }
    };


}