package com.example.a1405264.sun;



import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText em,pw;
    Button b1;
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();



        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this,MainActivity.class));
            finish();
        }


        pw=(EditText)findViewById(R.id.editText2);
        em=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button);
        imageView=(ImageView)findViewById(R.id.image);

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!= null)
                {
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
            }
        };

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signIn();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void signIn(){
        String s1=em.getText().toString().trim();
        String s2=pw.getText().toString().trim();
        progressDialog =ProgressDialog.show(this,"Logging","Please Wait",true);
        if(TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            Toast.makeText(Login.this,"Fields are Empty",Toast.LENGTH_SHORT).show();

        }
        else {
            mAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, "SignIn Problem", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        startActivity(new Intent(Login.this,MainActivity.class));
                    }
                }
            });
        }
    }
}
