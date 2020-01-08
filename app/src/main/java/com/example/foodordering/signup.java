package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText email,password, name;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email=(EditText) findViewById(R.id.editText3);
        password=(EditText) findViewById(R.id.editText4);
        name=(EditText) findViewById(R.id.editText);
        signup=(Button) findViewById(R.id.button3);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddata();
            }
        });
    }
    private void adddata()
    {
        final String editText3 =  email.getText().toString().trim();
        final String editText4 =  password.getText().toString().trim();
        final String editText =  name.getText().toString().trim();


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        //ref.child("Users").child(editText3).setValue(editText4);

        ref.child("Users").child(editText).child("email").setValue(editText3);
        ref.child("Users").child(editText).child("password").setValue(editText4);
        //ref.child().child("email").setValue(editText3);
        //ref.child("Users").child("password").setValue(editText4);
        Toast.makeText(this, "Welcome "+editText , Toast.LENGTH_SHORT).show();
        Intent i = new Intent(signup.this, HomeScreen.class);
        startActivity(i);
    }

}
