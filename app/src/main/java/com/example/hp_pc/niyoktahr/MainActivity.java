package com.example.hp_pc.niyoktahr;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private TextView userReg, forgetPassword;
    private ProgressDialog mProgressDialog;

    SignInButton mButton;
    FirebaseAuth mAuth;
    private final static int RC_SIGN_IN = 2;
    GoogleApiClient mGoogleApiClient;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    UserProfile userProfile;

    @Override
    protected void onStart() {
        super.onStart();
       // mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondone);

        mAuth = FirebaseAuth.getInstance();

        opening();
    }




    private void opening(){

        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        Log.e("here firebase ", firebaseUser + "       ll");
        if ((firebaseUser != null)) {

            //finish();
            //Log.e(" Here sourabh", FirebaseDatabase.getInstance().getReference(mAuth.getCurrentUser().getUid()) + "   kk");
            // second page  = edit educatiom
            // second one  =  hello

            Log.e(" value here",FirebaseDatabase.getInstance().getReference(mAuth.getCurrentUser().getUid())+"     l" );


            DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference(mAuth.getCurrentUser().getUid());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                     userProfile=dataSnapshot.getValue(UserProfile.class);

                    Log.e("hi",userProfile+"       hfv");

                    if (userProfile == null) {

                        Log.e(" here come s here", " here");
                        // take to education page
                        startActivityForResult(new Intent(MainActivity.this, Fill_details.class),121);

                    } else {
                        // startActivity(new Intent(MainActivity.this, Secondpage.class));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });


        }else{
            startActivityForResult(new Intent(MainActivity.this, LoginActivity.class),27);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 121){

        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.profileMenu:{
                startActivity(new Intent(MainActivity.this,Profile.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }


}
