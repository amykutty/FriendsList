package com.list.friends.friendslist;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddFriend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        Button add = (Button) findViewById(R.id.button);
        final TextView friendId = (TextView) findViewById(R.id.editText);
        friendId.setTextColor(Color.RED);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String friend = friendId.getText().toString();
                Toast t = Toast.makeText(v.getContext(), friend + " Added", Toast.LENGTH_LONG);
                t.show();
                // Add friend using backend service and launch the list activity

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
