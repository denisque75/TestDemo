package com.denysque.testdemo.core.repository.photo;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoRepository implements PhotoRepository {

    @Override
    public void loadImage(String url, ImageView imageView) {
        Picasso.get().load(url).into(imageView);
    }
}
