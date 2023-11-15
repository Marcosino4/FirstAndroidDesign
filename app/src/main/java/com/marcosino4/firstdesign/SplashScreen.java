package com.marcosino4.firstdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.mcas2.firstdesign.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logo = findViewById(R.id.logo);
        TextView appName = findViewById(R.id.appName);
        ImageView background = findViewById(R.id.backgroundSplash);

        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        appName.startAnimation(fadeAnimation);

        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        logo.startAnimation(shakeAnimation);

        Animation moveUpAnimation = AnimationUtils.loadAnimation(this, R.anim.move_up);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1533240332313-0db49b459ad6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .into(background);

        logo.setAnimation(moveUpAnimation);
        appName.setAnimation(moveUpAnimation);
        //Open Login
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(logo, "logo");
                pairs[1] = new Pair<View, String>(appName, "appName");
                pairs[2] = new Pair<View, String>(background, "background");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }

            }
        }, 3000);
    }
}