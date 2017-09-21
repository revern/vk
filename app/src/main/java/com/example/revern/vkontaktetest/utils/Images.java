package com.example.revern.vkontaktetest.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.revern.vkontaktetest.R;
import com.example.revern.vkontaktetest.news_feed.models.post.WallpostAttachment;
import com.example.revern.vkontaktetest.news_feed.models.post.WallpostAttachmentType;

import java.util.List;

/**
 * Created by Revern on 20.09.2017.
 */

public class Images {

    public static void drawCircle(@Nullable ImageView imageView, @Nullable String uri) {
        if (imageView == null || uri == null) return;

        Glide.with(imageView.getContext())
            .load(uri)
            .apply(new RequestOptions().circleCrop())
            .into(imageView);
    }

    public static void drawPostImage(@Nullable ImageView imageView,
                                     @Nullable List<WallpostAttachment> attachments) {
        if (imageView == null) return;

        if (!Lists.isEmpty(attachments)) {
            for (WallpostAttachment attachment : attachments) {
                if (attachment.getType() == WallpostAttachmentType.PHOTO) {
                    String photoUri = attachment.getPhoto() != null ?
                        attachment.getPhoto().getPhoto807() != null ? attachment.getPhoto().getPhoto807() :
                            attachment.getPhoto().getPhoto604() != null ? attachment.getPhoto().getPhoto604() :
                                attachment.getPhoto().getPhoto130() != null ? attachment.getPhoto().getPhoto130() :
                                    attachment.getPhoto().getPhoto75() != null ? attachment.getPhoto().getPhoto75()
                                        : null
                        : null;
                    int width = attachment.getPhoto().getWidth();
                    int height = attachment.getPhoto().getHeight();
                    Images.drawFullWidth(imageView, photoUri, width, height);
                    return;
                }
            }
        }
        imageView.setVisibility(View.GONE);
    }

    public static void drawFullWidth(@Nullable ImageView imageView, @Nullable String uri,
                                     int width, int height) {
        if (imageView == null) return;

        if (uri == null) {
            imageView.setVisibility(View.GONE);
            return;
        }

        imageView.setVisibility(View.VISIBLE);

        int finalWidth = imageView.getContext().getResources().getDisplayMetrics().widthPixels;
        int finalHeight = height * finalWidth / width;

        imageView.getLayoutParams().width = finalWidth;
        imageView.getLayoutParams().height = finalHeight;

        Glide.with(imageView.getContext())
//            .asBitmap()
            .load(uri)
            .apply(new RequestOptions()
                .override(finalWidth, finalHeight)
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .dontAnimate())
            .into(imageView);
//            .into(new SimpleTarget<Bitmap>() {
//                @Override
//                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
//                    imageView.getLayoutParams().width = width;
//                    imageView.getLayoutParams().height = resource.getHeight() * width / resource.getWidth();
//                    imageView.setImageBitmap(resource);
//                }
//            });
    }

}
