package com.example.forfoodiesbyfoodies.Views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.forfoodiesbyfoodies.R;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;

    private EditText editTextFirstName, editTextLastName, editTextUserName, editTextemail, editTextpw, editTextcpw;
    private ProgressBar progressBar;
    private ImageView logo2back;
    private TextView registerUser;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        logo2back = (ImageView) findViewById(R.id.im_logo2);
        logo2back.setOnContextClickListener(this);

        registerUser = (Button) findViewById(R.id.btn_register_user);
        registerUser.setOnContextClickListener(this);

        editTextFirstName = (EditText) findViewById(R.id.et_fn);
        editTextLastName = (EditText) findViewById(R.id.et_sn);
        editTextUserName = (EditText) findViewById(R.id.et_user);
        editTextemail = (EditText) findViewById(R.id.et_em);
        editTextpw = (EditText) findViewById(R.id.et_em);
        editTextpw = (EditText) findViewById(R.id.et_pw);
        editTextcpw = (EditText) findViewById(R.id.et_cpw);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_logo2:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn_register_user:
                registerUser();
                break;
        }

    }
    //create method for registerUser
    private void registerUser() {
        String email = editTextemail.getText().toString().trim();
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String username = editTextUserName.getText().toString().trim();
        String password = editTextpw.getText().toString().trim();
        String confirmPassword = editTextcpw.getText().toString().trim();

        if (firstName.isEmpty()){
            editTextFirstName.setError("First name is required!");
            editTextFirstName.requestFocus();
            return;

        }
        if (lastName.isEmpty()){
            editTextLastName.setError("Last name is required!");
            editTextLastName.requestFocus();
            return;
        }

        if (email.isEmpty()){
            editTextemail.setError("Email is requieried");
            editTextemail.requestFocus();
            return;
        }


    }
}