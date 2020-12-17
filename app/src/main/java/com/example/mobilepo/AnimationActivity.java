package com.example.mobilepo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.mobilepo.databinding.ActivityAnimationBinding;
import com.example.mobilepo.viewmodel.AnimationActivityVM;
import com.example.mobilepo.viewmodel.ChangeFragmentsActivityVM;

public class AnimationActivity extends AppCompatActivity {

    AnimationActivityVM animationActivityVM;
    ActivityAnimationBinding activityAnimationBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activityAnimationBinding = DataBindingUtil.setContentView(this, R.layout.activity_animation);
        animationActivityVM = new AnimationActivityVM(this, R.id.image_anim);
        activityAnimationBinding.setVm(animationActivityVM);
    }
}