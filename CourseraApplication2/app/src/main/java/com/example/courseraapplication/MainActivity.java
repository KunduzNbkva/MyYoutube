package com.example.courseraapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment=MainFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).addToBackStack(null).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.settings_menu:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                fragment=SettingsFragment.newInstance();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit();
            break;
            case R.id.search_menu:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                fragment=SearchFragment.newInstance();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container,fragment )
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.exit_menu:
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}