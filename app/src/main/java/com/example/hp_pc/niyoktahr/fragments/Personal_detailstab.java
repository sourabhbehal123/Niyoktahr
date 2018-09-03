package com.example.hp_pc.niyoktahr.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp_pc.niyoktahr.MainActivity;
import com.example.hp_pc.niyoktahr.R;
import com.example.hp_pc.niyoktahr.UserProfile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hp-pc on 8/17/2018.
 */

public class Personal_detailstab extends Fragment {
    EditText education, skills, jobs;
    Button button, btsumbit;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    String name, loaction, dateofbirth;
    ViewPager viewPager;
    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthStateListener);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
        education = (EditText) rootView.findViewById(R.id.etEduaction);
        skills = (EditText)rootView.findViewById(R.id.etSkills);
        jobs = (EditText)rootView. findViewById(R.id.etJobs);
        button = (Button)rootView. findViewById(R.id.logout);
        viewPager = (ViewPager) getActivity().findViewById(R.id.container);

        btsumbit = (Button)rootView. findViewById(R.id.btEdusumbit);
        firebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
            }
        });
        btsumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserDetails();
                viewPager = (ViewPager) getActivity().findViewById(
                        R.id.container);
                viewPager.setCurrentItem(1);


                Toast.makeText(getActivity(),"information sumbited",Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;


    }
    private void sendUserDetails() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("employee");

        name = education.getText().toString();

        loaction = skills.getText().toString();
        dateofbirth = jobs.getText().toString();
        UserProfile userProfile = new UserProfile(name, loaction, dateofbirth);

        myRef.child(firebaseAuth.getCurrentUser().getUid()).child("Personal details").setValue(userProfile);


    }

    }

