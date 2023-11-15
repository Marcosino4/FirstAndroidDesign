package com.marcosino4.firstdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.mcas2.firstdesign.R;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Animation moveUp = AnimationUtils.loadAnimation(this, R.anim.move_up);
        Animation moveDown = AnimationUtils.loadAnimation(this, R.anim.move_down);

        ImageView logo = findViewById(R.id.logo);
        TextView appName = findViewById(R.id.appName);
        TextInputLayout username = findViewById(R.id.usernameInput);
        TextInputLayout password = findViewById(R.id.passwordInputRegister);
        CheckBox remember = findViewById(R.id.rememberRegister);
        TextView watermark = findViewById(R.id.watermark);
        TextView gotAccount = findViewById(R.id.gotAccount);
        Button enterButton = findViewById(R.id.registerButton);
        TextView forgotPassword = findViewById(R.id.forgotPasswordText);


        gotAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                Pair[] pairs = new Pair[9];
                pairs[0] = new Pair<View, String>(logo, "logo");
                pairs[1] = new Pair<View, String>(appName, "appName");
                pairs[2] = new Pair<View, String>(username, "username");
                pairs[3] = new Pair<View, String>(password, "password");
                pairs[4] = new Pair<View, String>(remember, "rememberBox");
                pairs[5] = new Pair<View, String>(watermark, "watermark");
                pairs[6] = new Pair<View, String>(gotAccount, "gotAccount");
                pairs[7] = new Pair<View, String>(enterButton, "enterButton");
                pairs[8] = new Pair<View, String>(forgotPassword, "forgotPassword");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Register.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public void openMain(View view) {
        Toast toast = Toast.makeText(Register.this, "Entrar al Main", Toast.LENGTH_LONG);
        toast.show();
    }
}