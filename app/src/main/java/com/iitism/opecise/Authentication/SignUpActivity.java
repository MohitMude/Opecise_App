package com.iitism.opecise.Authentication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iitism.opecise.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout textInputSignUpName;
    private TextInputLayout textInputSignUpEmail;
    private TextInputLayout textInputSignUpNumber;
    private TextInputLayout textInputSignUpPassword;
    private TextInputLayout textInputSignUpConfirmPassword;
    private Button signUp;
    private TextView alreadyUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        textInputSignUpName=(TextInputLayout)findViewById(R.id.Edt_txt_sign_up_name);
        textInputSignUpEmail=(TextInputLayout)findViewById(R.id.Edt_txt_sign_up_email);
        textInputSignUpNumber=(TextInputLayout)findViewById(R.id.Edt_txt_sign_up_mobile_no);
        textInputSignUpPassword=(TextInputLayout)findViewById(R.id.Edt_txt_sign_up_password);
        textInputSignUpConfirmPassword=(TextInputLayout)findViewById(R.id.Edt_txt_sign_up_confirm_password);
        signUp=findViewById(R.id.btn_signup);
        alreadyUser=findViewById(R.id.Txt_view_already_user);

        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(j);
            }
        });


        signUp.setOnClickListener(this);

    }

    private boolean validate(TextInputLayout v)
    {
        String x=v.getEditText().getText().toString().trim();
        if(x.isEmpty())
        {
            v.setError("This field cannot be empty");
            return false;
        }
        else{
            textInputSignUpEmail.setError(null);
            return true;
        }
    }


    private  boolean validatePassword()
    {
        String password=textInputSignUpPassword.getEditText().getText().toString().trim();
        String confirmpassword=textInputSignUpConfirmPassword.getEditText().getText().toString().trim();
        if(password.equals(confirmpassword)) {
            if (password.isEmpty() && confirmpassword.isEmpty()) {
                textInputSignUpPassword.setError("This field cannot be empty");
                textInputSignUpConfirmPassword.setError("This field cannot be empty");
                return false;
            } else {
                textInputSignUpPassword.setError(null);
                textInputSignUpConfirmPassword.setError(null);
                return true;
            }
        }

        else
        {
            Toast.makeText(this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
            return false;
        }
    }



    @Override
    public void onClick(View v) {
        if(v==signUp)
        {
            if(!validate(textInputSignUpName)| !validate(textInputSignUpNumber)| !validate(textInputSignUpEmail)|! validatePassword())
            {
                return ;
            }
            else
            Toast.makeText(getApplicationContext(),"Signnned in",Toast.LENGTH_LONG).show();
        }
    }
}
