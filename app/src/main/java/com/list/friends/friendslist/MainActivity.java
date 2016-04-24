package com.list.friends.friendslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView list = (ListView) findViewById(R.id.listView);
        SimpleAdapter a = new SimpleAdapter(this, getFriendsList(), R.layout.list_item, new String[]{"line1", "status", "status_off"}, new int[]{R.id.itemLine1, R.id.status, R.id.status_off});
        list.setAdapter(a);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.print(parent);
                HashMap<String, String> o = (HashMap<String, String>) parent.getItemAtPosition(position);
                Intent detail = new Intent(view.getContext(), FriendDetails.class);
                detail.putExtra(FriendDetails.EXTRA_FRIEND_ID, o.get("id"));
                detail.putExtra(FriendDetails.EXTRA_FRIEND_NAME, o.get("line1"));
                startActivity(detail);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddFriend.class);
                startActivity(intent);
            }
        });
    }


    public List<Map<String, String>> getFriendsList(){
        /**
         * Get the friends list from backend.
         *
         */


        ArrayList<Map<String, String>> dummy_user_data = new ArrayList<Map<String, String>>();
        Map row = new HashMap();
        row.put("line1", "Gipsy Gopinathan");
        row.put("status", "On line");
        row.put("id", "1");
        dummy_user_data.add(row);
        row = new HashMap();
        row.put("line1", "Yesudas John");
        row.put("status", "On line");
        row.put("id", "2");
        dummy_user_data.add(row);
        row = new HashMap();
        row.put("line1", "Vidhya");
        row.put("status_off", "Off ine");
        row.put("id", "3");
        dummy_user_data.add(row);

        return dummy_user_data;
    }
}
