package com.example.p6exam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p6exam1.view.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextTextPersonName2;
    private EditText editTextTextPassword2;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        editTextTextPassword2 = (EditText) findViewById(R.id.editTextTextPassword2);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextTextPersonName2.getText().toString();
                String paw = editTextTextPassword2.getText().toString();

                if (name.equals("H2003xs") && paw.equals("H2003")){
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "账号或者密码错误", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}