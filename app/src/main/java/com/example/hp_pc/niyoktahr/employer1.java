package com.example.hp_pc.niyoktahr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hp-pc on 8/24/2018.
 */

public class employer1 extends Fragment {
    EditText education, skills, jobs;
    Button btsumbit;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    public String company;
    public String profession;
    public String job;

    ViewPager viewPager;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_employer_details, container, false);
        education = (EditText) rootView.findViewById(R.id.etCompany);
        skills = (EditText)rootView.findViewById(R.id.etProfession);
        jobs = (EditText)rootView. findViewById(R.id.etjob);

        btsumbit = (Button)rootView. findViewById(R.id.btemployeesumbit);
        firebaseAuth = FirebaseAuth.getInstance();

        btsumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserDetails();
               viewPager = (ViewPager) getActivity().findViewById(
                        R.id.container);
                viewPager.setCurrentItem(1);
              //  Intent intent = new Intent(getActivity(), job_posting.class);
               // startActivity(intent);
                Toast.makeText(getActivity(),"information sumbited",Toast.LENGTH_SHORT).show();

            }
        });
        return rootView;
    }
    private void sendUserDetails() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("employer");
        company  = education.getText().toString();
        profession = skills.getText().toString();
        job= jobs.getText().toString();
        employer1_constructor userProfile = new employer1_constructor(company,profession,job);
        myRef.child(firebaseAuth.getCurrentUser().getUid()).child("Personal details").setValue(userProfile);


    }


}

