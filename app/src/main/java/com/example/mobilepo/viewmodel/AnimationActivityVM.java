package com.example.mobilepo.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BaseObservable;

import com.example.mobilepo.R;

public class AnimationActivityVM extends BaseObservable {
    public Context ctx;
    public int id_image;
    public AnimationActivityVM(Context context, int id_image) {
        this.ctx = context;
        this.id_image = id_image;
    }

    public void onScaleClicked(){
        setAnimation(R.anim.scale);
    }

    public void onRotateClicked(){
        setAnimation(R.anim.rotate);
    }

    public void onTransparencyClicked(){
        setAnimation(R.anim.transparency);
    }

    public void onTranslateClicked(){
        setAnimation(R.anim.transfer);
    }

    public void setAnimation(int id_anim){
        ImageView photo = (ImageView)  ((Activity)this.ctx).findViewById(id_image);
        photo.startAnimation(AnimationUtils.loadAnimation(ctx, id_anim));
    }
}
