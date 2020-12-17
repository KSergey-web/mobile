package com.example.mobilepo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_change_frag:
                intent = new Intent(this, ChangeFragmentsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_open_link:
                intent = new Intent(this, OpenLinkActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_list:
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_anim:
                intent = new Intent(this, AnimationActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}