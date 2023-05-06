package com.example.vibro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.vibro.DataBaseHelper;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);
        dbHelper = new DataBaseHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (checkEmailAndPassword(email, password)) {
                    goToMainActivity();
                } else {
                    // show an error message here
                }
            }
        });
    }

    private boolean checkEmailAndPassword(String email, String password) {
        // validate user input here

        return dbHelper.authenticateUser(email, password);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

    private boolean checkEmailAndPassword(String email, String password) {
        // validate user input here

        return dbHelper.authenticateUser(email, password);
    }
}