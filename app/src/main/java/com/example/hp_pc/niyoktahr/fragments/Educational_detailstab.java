package com.example.hp_pc.niyoktahr.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp_pc.niyoktahr.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hp-pc on 8/17/2018.
 */

public class Educational_detailstab extends Fragment {
    EditText education, skills, jobs;
    Button  btsumbit;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    public String course;
    public String university;
    public String qualifiactions;
    ViewPager viewPager;




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_education_details, container, false);
        education = (EditText) rootView.findViewById(R.id.etCourse);
        skills = (EditText)rootView.findViewById(R.id.etUniversity);
        jobs = (EditText)rootView. findViewById(R.id.etqualification);

        btsumbit = (Button)rootView. findViewById(R.id.btEdusumbit);
        firebaseAuth = FirebaseAuth.getInstance();

        btsumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              sendUserDetails();
                viewPager = (ViewPager) getActivity().findViewById(
                        R.id.container);
                viewPager.setCurrentItem(2);
                Toast.makeText(getActivity(),"information sumbited",Toast.LENGTH_SHORT).show();

            }
        });


        return rootView;


    }
    private void sendUserDetails() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("employee");
        course  = education.getText().toString();

        university = skills.getText().toString();
        qualifiactions= jobs.getText().toString();
        Education_constructor userProfile = new Education_constructor(course,university,qualifiactions);
        myRef.child(firebaseAuth.getCurrentUser().getUid()).child("eduaction details").setValue(userProfile);


    }

}


