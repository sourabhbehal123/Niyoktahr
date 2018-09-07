package com.example.hp_pc.niyoktahr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class job_posting extends AppCompatActivity {
    public EditText mEditTitle;
    public EditText mEditcontent;
    public EditText mEditdetails;
    private Button btsubmit;
    FirebaseAuth mFirebaseAuth;
    public String jobTitle;
    public String jobDescription;
    public String salary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_posting);
        mEditTitle = (EditText) findViewById(R.id.note_title);
        mEditcontent = (EditText) findViewById(R.id.note_content);
        mEditdetails = (EditText) findViewById(R.id.note_details);
        btsubmit=(Button)findViewById(R.id.btjobsubmit);
        mFirebaseAuth=FirebaseAuth.getInstance();
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendUserDetails();
                sendDetails();
                Toast.makeText(job_posting.this, "Submited", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void sendUserDetails() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("jobs");
        jobTitle = mEditTitle.getText().toString();
         String userid= mFirebaseAuth.getCurrentUser().getUid();
        jobDescription = mEditcontent.getText().toString();
        salary = mEditdetails.getText().toString();
        jobpost_constructor userProfile = new jobpost_constructor(jobTitle,jobDescription,salary,userid);
        myRef.push().setValue(userProfile);


    }
    private void sendDetails() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("job");
        jobTitle = mEditTitle.getText().toString();
        String userid= mFirebaseAuth.getCurrentUser().getUid();
        jobDescription = mEditcontent.getText().toString();
        salary = mEditdetails.getText().toString();
        jobpost_constructor userProfile = new jobpost_constructor(jobTitle,jobDescription,salary,userid);
        myRef.child(mFirebaseAuth.getCurrentUser().getUid()).push().setValue(userProfile);


    }
}
