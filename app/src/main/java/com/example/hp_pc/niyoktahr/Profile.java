package com.example.hp_pc.niyoktahr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp_pc.niyoktahr.fragments.Fill_details;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    private ImageView profilepic;
    private TextView profileeduaction,profileskills,profilejobs,profilecourse,profileuniversity,profilequal;
    private Button profileUpdate;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //profilepic=(ImageView)findViewById(R.id.ivProfilepic);
        profileeduaction=(TextView)findViewById(R.id.tvEducation);
        profileskills=(TextView)findViewById(R.id.tvSkills);

       // profilecourse=(TextView)findViewById(R.id.tvcourse);
        ///profileuniversity=(TextView)findViewById(R.id.tvuniversity);
        //profilequal=(TextView)findViewById(R.id.tvQualification);

        profilejobs=(TextView)findViewById(R.id.tvJobs);
        profileUpdate=(Button)findViewById(R.id.bteditprofile);

        profileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this,Fill_details.class));
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();

        DatabaseReference databaseReference=firebaseDatabase.getReference("employee").child(firebaseAuth.getCurrentUser().getUid()).child("Personal details");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile userProfile=dataSnapshot.getValue(UserProfile.class);
                profileeduaction.setText(userProfile.getPersonal_namecon());
                profileskills.setText(userProfile.getPersonal_emailcon());
                profilejobs.setText(userProfile.getPersonal_dobcon());
             //   profilecourse.setText(userProfile.getCourse());
                //profileuniversity.setText(userProfile.getUniversity());
                //profilequal.setText(userProfile.getQualifications());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Profile.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });


    }
    }
