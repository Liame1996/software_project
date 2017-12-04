package com.example.liam.softwareproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DisplayData extends AppCompatActivity {

    private TextView tValue;

    private Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        tValue = (TextView) findViewById(R.id.valueView);

        firebase = new Firebase("https://software-project-4ae0c.firebaseio.com/distant/-L-6pDblwvOd1eJaorR2/value");

        //DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Distant");



        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("TAG", dataSnapshot.getChildren().toString());
                String value = dataSnapshot.getValue(String.class);
                tValue.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
