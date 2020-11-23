package com.example.courseraapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SearchFragment extends Fragment {
    TextView textView;
    Button startSearch;
    SharedPreferences preferences;
    Intent intent;

    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences=this.getActivity().getSharedPreferences(SettingsFragment.APP_PREFERENCES, Context.MODE_PRIVATE);
        textView = view.findViewById(R.id.search_edit_text);
        startSearch = view.findViewById(R.id.start_search_btn);
        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStartSearch();
            }
        });
    }

    public void setStartSearch() {
        String word = textView.getText().toString();
        String browser = preferences.getString(SettingsFragment.APP_PREFERENCES_NAME, "Yandex");
        Log.e("prefs",""+browser);
        if (browser.equals("Google")) {
            Uri uri = Uri.parse("https://www.google.com/search?q=");
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri + word));
            startActivity(intent);
        } else if(browser.equals("Yandex")){
            Uri uri = Uri.parse("https://yandex.com/search/?text=");
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri + word));
            startActivity(intent);
        } else{
            Uri uri = Uri.parse("https://www.bing.com/search?q=");
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri + word));
            startActivity(intent);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
}