package com.denysque.testdemo.core.repository.photo;

import android.widget.ImageView;

public interface PhotoRepository {

    void loadImage(String url, ImageView imageView);
}
