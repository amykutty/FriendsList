package com.list.friends.friendslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FriendDetails extends AppCompatActivity {

    public final static String EXTRA_FRIEND_ID = "com.friends.list.FRIEND_ID";
    public final static String EXTRA_FRIEND_NAME = "com.friends.list.FRIEND_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_details);
        String friend_id = getIntent().getStringExtra(EXTRA_FRIEND_ID);
        final String friend_name = getIntent().getStringExtra(EXTRA_FRIEND_NAME);
        TextView id_text = (TextView) findViewById(R.id.friend_id);
        final TextView name_text = (TextView) findViewById(R.id.friend_name);
        id_text.setText("Friend Id:" + friend_id);
        name_text.setText("Name:" + friend_name);

        Button remove = (Button) findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(v.getContext(), "Removing " + name_text.getText().toString(), Toast.LENGTH_LONG);
                t.show();

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
