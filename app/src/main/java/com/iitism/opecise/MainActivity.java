package com.iitism.opecise;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
  private TextInputLayout textInputEmail;
  private TextInputLayout textInputPassword;
  private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      textInputEmail=(TextInputLayout)findViewById(R.id.Edt_txt_email);
      textInputPassword=(TextInputLayout)findViewById(R.id.Edt_txt_password);
      btnLogin=(Button)findViewById(R.id.btn_login);

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
