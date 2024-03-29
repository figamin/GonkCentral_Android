package com.figdev.gonkcentraldroid1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;

public class Login extends AppCompatActivity {

    private TextView titleText;
    private ProgressBar loading;
    private Button loginButton;
    private AutoCompleteTextView userID, password;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        titleText = findViewById(R.id.textlogo);
        loading = findViewById(R.id.loginLoading);
        loginButton = findViewById(R.id.loginpress);
        userID = findViewById(R.id.ipassid);
        password = findViewById(R.id.ipasswd);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(userID.getText().toString().isEmpty())
                {
                    userID.setError("User ID is required.");
                }
                else if(password.getText().toString().isEmpty())
                {
                    password.setError("Password is required.");
                }
                else
                {
                    userID.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);
                    titleText.setText("Loading...");
                    loading.setVisibility(View.VISIBLE);
                    new LoginTask(Login.this).execute(userID.getText().toString(), password.getText().toString());
                }
            }
        });
    }
    private void checkLogin(Boolean result)
    {
        Toast message;
        if(!result)
        {
            message = Toast.makeText(getApplicationContext(), "Login failed.", Toast.LENGTH_SHORT);
        }
        else
        {
            message = Toast.makeText(getApplicationContext(), "Login succeeded.", Toast.LENGTH_SHORT);
            Intent intention = new Intent(this, MainInterface.class);
            startActivity(intention);
        }
        message.show();
    }
    private static class LoginTask extends AsyncTask<String, Void, Boolean>{

        private WeakReference<Login> reference;

        LoginTask(Login context)
        {
            reference = new WeakReference<>(context);
        }
        @Override
        protected Boolean doInBackground(String... strings)
        {
            boolean result = true;
            try
            {
                 IPassLogin login = new IPassLogin(strings[0], strings[1]);
                 String scrapedPage = login.scrapePage(new URL("https://ipassweb.harrisschool.solutions/school/nsboro/syslogin.htm"));
                 if (scrapedPage.length() > 150)
                 {
                     result = false;
                 }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result)
        {
            Login aliveLogin = reference.get();
            if(aliveLogin == null || aliveLogin.isFinishing())
            {
                return;
            }
            aliveLogin.checkLogin(result);
        }
    }
}
