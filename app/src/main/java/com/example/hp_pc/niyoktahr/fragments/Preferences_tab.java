package com.example.hp_pc.niyoktahr.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp_pc.niyoktahr.MainActivity;
import com.example.hp_pc.niyoktahr.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hp-pc on 8/17/2018.
 */

public class Preferences_tab extends Fragment {
    EditText city1,city2,city3;
    Button btsumbit;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    public String city111,city12,city13;




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.prefrences_tab, container, false);
        city1 = (EditText) rootView.findViewById(R.id.etcity1);
        city2 = (EditText)rootView.findViewById(R.id.etcity2);
        city3 = (EditText)rootView. findViewById(R.id.etcity3);

        btsumbit = (Button)rootView. findViewById(R.id.btprefsumbit);
        firebaseAuth = FirebaseAuth.getInstance();

        btsumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserDetails();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });


        return rootView;


    }
    private void sendUserDetails() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("employee");
       city111  = city1.getText().toString();

        city12 = city2.getText().toString();
        city13= city3.getText().toString();
        PreferencesConstructor userProfile = new PreferencesConstructor(city111,city12,city13);
        myRef.child(firebaseAuth.getCurrentUser().getUid()).child("Preferences details").setValue(userProfile);


    }

}

