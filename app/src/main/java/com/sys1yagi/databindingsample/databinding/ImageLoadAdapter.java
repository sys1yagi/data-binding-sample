package com.sys1yagi.databindingsample.databinding;

import com.squareup.picasso.Picasso;
import com.sys1yagi.databindingsample.tools.RoundedCornerTransformation;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class ImageLoadAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void bindImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter({"bind:imageUrl", "bind:corner"})
    public static void bindImage(ImageView view, String url, int corner) {
        Context context = view.getContext();
        Picasso.with(context).load(url)
                .transform(new RoundedCornerTransformation(corner))
                .into(view);
    }
}
