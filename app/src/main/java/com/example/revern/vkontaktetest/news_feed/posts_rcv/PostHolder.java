package com.example.revern.vkontaktetest.news_feed.posts_rcv;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.revern.vkontaktetest.R;
import com.example.revern.vkontaktetest.news_feed.models.Poster;
import com.example.revern.vkontaktetest.news_feed.models.group.Group;
import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.news_feed.models.post.Wallpost;
import com.example.revern.vkontaktetest.news_feed.models.user.User;
import com.example.revern.vkontaktetest.utils.Dates;
import com.example.revern.vkontaktetest.utils.Images;
import com.example.revern.vkontaktetest.utils.Lists;
import com.example.revern.vkontaktetest.utils.TextViews;
import com.example.revern.vkontaktetest.utils.ui.rcv.BaseHolder;

import java.util.List;

import butterknife.Bind;
import rx.functions.Func1;

/**
 * Created by Revern on 23.08.2017.
 */

public class PostHolder extends BaseHolder<Post> {

    @NonNull private List<User>  users;
    @NonNull private List<Group> groups;

    @Bind(R.id.poster)        RelativeLayout uiPoster;
    @Bind(R.id.poster_avatar) ImageView      uiPosterAvatar;
    @Bind(R.id.poster_name)   TextView       uiPosterName;
    @Bind(R.id.post_date)     TextView       uiPostDate;

    @Bind(R.id.original_post_author)        RelativeLayout uiOriginalPostAuthor;
    @Bind(R.id.original_post_author_avatar) ImageView      uiOriginalPostAuthorAvatar;
    @Bind(R.id.original_post_author_name)   TextView       uiOriginalPostAuthorName;
    @Bind(R.id.original_post_date)          TextView       uiOriginalPostDate;

    @Bind(R.id.text)  TextView  uiText;
    @Bind(R.id.photo) ImageView uiPhoto;

    @Bind(R.id.original_post_text)  TextView  uiOriginalPostText;
    @Bind(R.id.original_post_photo) ImageView uiOriginalPostPhoto;

    @Bind(R.id.likes)    TextView uiLikes;
    @Bind(R.id.comments) TextView uiComments;
    @Bind(R.id.reposts)  TextView uiReposts;

    public static Func1<ViewGroup, PostHolder> creator(@NonNull List<User> users,
                                                       @NonNull List<Group> groups) {
        return viewGroup -> new PostHolder(LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_post, viewGroup, false), users, groups);
    }

    public PostHolder(@NonNull View itemView, @NonNull List<User> users,
                      @NonNull List<Group> groups) {
        super(itemView);
        this.users = users;
        this.groups = groups;
    }

    @Override protected void bind(@NonNull Post post) {

        drawPosterInfo(post);
        drawAuthorInfoIfExists(post);

        TextViews.setTextOrHide(uiText, post.getText());
        TextViews.setTextOrHide(uiLikes, post.getLikes().getCount());
        TextViews.setTextOrHide(uiComments, post.getComments().getCount());
        TextViews.setTextOrHide(uiReposts, post.getReposts().getCount());

        Images.drawPostImage(uiPhoto, post.getAttachments());

    }

    private void drawPosterInfo(@NonNull Post post) {
        Poster poster = findPoster(post.getSourceId() < 0 ? groups : users, post.getSourceId());

        if (poster != null) {
            uiPoster.setVisibility(View.VISIBLE);
            uiPosterName.setText(poster.getDisplayName());
            uiPostDate.setText(Dates.getFormattedDate(post.getDate()));
            Images.drawCircle(uiPosterAvatar, poster.getPhoto100());
        } else {
            uiPoster.setVisibility(View.GONE);
        }
    }

    @Nullable private Poster findPoster(List<? extends Poster> posters, int id) {
        if (id < 0) id *= -1;

        for (Poster poster : posters) {
            if (poster.getId() == id) return poster;
        }
        return null;
    }

    private void drawAuthorInfoIfExists(@NonNull Post post) {
        List<Wallpost> copyHistory = post.getCopyHistory();
        if (Lists.isEmpty(copyHistory)) {
            uiOriginalPostAuthor.setVisibility(View.GONE);
            uiOriginalPostPhoto.setVisibility(View.GONE);
            uiOriginalPostText.setVisibility(View.GONE);
        } else {
            Wallpost primaryPost = copyHistory.get(copyHistory.size() - 1);

            Poster poster = findPoster(post.getSourceId() < 0 ? groups : users, primaryPost.getOwnerId());
            if (poster != null) {
                uiOriginalPostAuthor.setVisibility(View.VISIBLE);
                Images.drawCircle(uiOriginalPostAuthorAvatar, poster.getPhoto100());
                uiOriginalPostAuthorName.setText(poster.getDisplayName());
                uiOriginalPostDate.setText(Dates.getFormattedDate(primaryPost.getDate()));
            } else {
                uiOriginalPostAuthor.setVisibility(View.GONE);
            }

            TextViews.setTextOrHide(uiOriginalPostText, primaryPost.getText());
            Images.drawPostImage(uiOriginalPostPhoto, primaryPost.getAttachments());
        }
    }

}

