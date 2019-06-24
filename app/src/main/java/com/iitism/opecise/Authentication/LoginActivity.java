package com.iitism.opecise.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iitism.opecise.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;
    private Button btnLogin;
    private TextView newusersignup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textInputEmail=(TextInputLayout)findViewById(R.id.Edt_txt_email);
        textInputPassword=(TextInputLayout)findViewById(R.id.Edt_txt_password);
        btnLogin=(Button)findViewById(R.id.btn_login);
        newusersignup=(TextView)findViewById(R.id.Txt_view_new_user);

        newusersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);
            }
        });
    }



    private  boolean validateEmail()
    {
        String email=textInputEmail.getEditText().getText().toString().trim();
        if(email.isEmpty())
        {
            textInputEmail.setError("This field cannot be empty");
            return false;
        }
        else{
            textInputEmail.setError(null);
            return true;
        }
    }
    private  boolean validatePassword()
    {
        String password=textInputPassword.getEditText().getText().toString().trim();
        if(password.isEmpty())
        {
            textInputPassword.setError("This field cannot be empty");
            return false;
        }
        else{
            textInputPassword.setError(null);
            return true;
        }
    }

    @Override
    public void onClick(View v) {
        if(v==btnLogin)
        {
            if(!validateEmail() | !validatePassword()){
                return;
            }
            Toast.makeText(this, "Working Fine", Toast.LENGTH_SHORT).show();
        }


    }


}
