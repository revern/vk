package com.example.revern.vkontaktetest.news_feed.posts_rcv;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.utils.ui.rcv.BaseAdapter;
import com.example.revern.vkontaktetest.utils.ui.rcv.OnItemClickListener;

import java.util.List;

import io.reactivex.functions.Function;

public class PostsAdapter extends BaseAdapter<Post, PostHolder> {

    public PostsAdapter(@NonNull List<Post> items,
                        @NonNull Function<ViewGroup, PostHolder> func,
                        @Nullable OnItemClickListener<Post> onItemClickListener) {
        super(items, func, onItemClickListener);
    }

    @Override public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return super.onCreateViewHolder(parent, viewType);
    }

}
