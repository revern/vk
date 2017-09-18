package com.example.revern.vkontaktetest.news_feed.posts_rcv;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.revern.vkontaktetest.R;
import com.example.revern.vkontaktetest.news_feed.models.group.Group;
import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.news_feed.models.post.Wallpost;
import com.example.revern.vkontaktetest.news_feed.models.post.WallpostAttachment;
import com.example.revern.vkontaktetest.news_feed.models.post.WallpostAttachmentType;
import com.example.revern.vkontaktetest.news_feed.models.user.User;
import com.example.revern.vkontaktetest.utils.ui.rcv.BaseHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import rx.functions.Func1;

/**
 * Created by Revern on 23.08.2017.
 */

public class PostHolder extends BaseHolder<Post> {

    @NonNull private List<User>  users;
    @NonNull private List<Group> groups;

    @Nullable private User   posterUser;
    @Nullable private User   authorUser;
    @Nullable private Group  posterGroup;
    @Nullable private Group  authorGroup;
    @Nullable private String text;
    @Nullable private String photoUri;
    @Nullable private String postDate;
    @Nullable private String authorDate;

    @Bind(R.id.poster)        RelativeLayout uiPoster;
    @Bind(R.id.poster_avatar) ImageView      uiPosterAvatar;
    @Bind(R.id.poster_name)   TextView       uiPosterName;
    @Bind(R.id.post_date)     TextView       uiPostDate;

    @Bind(R.id.original_post_author)        RelativeLayout uiRepostAuthor;
    @Bind(R.id.original_post_author_avatar) ImageView      uiRepostAuthorAvatar;
    @Bind(R.id.original_post_author_name)   TextView       uiRepostAuthorName;
    @Bind(R.id.original_post_date)          TextView       uiOriginalPostDate;

    @Bind(R.id.text)     TextView  uiText;
    @Bind(R.id.photo)    ImageView uiPhoto;
    @Bind(R.id.likes)    TextView  uiLikes;
    @Bind(R.id.comments) TextView  uiComments;
    @Bind(R.id.reposts)  TextView  uiReposts;

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

        findNeedUsersAndGroups(post);

        uiPostDate.setText(getFormattedDate(post.getDate()));
        if (post.getText() != null) {
            uiText.setText(post.getText());
        } else {
            uiText.setVisibility(View.GONE);
        }
        if (post.getLikes() != null) {
            uiLikes.setText(post.getLikes().getCount() + "");
        } else {
            uiLikes.setVisibility(View.INVISIBLE);
        }
        if (post.getComments() != null) {
            uiComments.setText(post.getComments().getCount() + "");
        } else {
            uiComments.setVisibility(View.INVISIBLE);
        }
        if (post.getReposts() != null) {
            uiReposts.setText(post.getReposts().getCount() + "");
        } else {
            uiReposts.setVisibility(View.INVISIBLE);
        }

        String photoUri = null;

        for (WallpostAttachment att : post.getAttachments()) {
            if (att.getType() == WallpostAttachmentType.PHOTO) {
                photoUri = att.getPhoto() != null ?
                    att.getPhoto().getPhoto807() != null ? att.getPhoto().getPhoto807() :
                        att.getPhoto().getPhoto604() != null ? att.getPhoto().getPhoto604() :
                            att.getPhoto().getPhoto130() != null ? att.getPhoto().getPhoto130() :
                                att.getPhoto().getPhoto75() != null ? att.getPhoto().getPhoto75()
                                    : null
                    : null;
            }
        }

        if (photoUri != null) {
            Glide.with(uiPhoto.getContext())
                .load(photoUri)
                .into(uiPhoto);
        } else {
            uiPhoto.setVisibility(View.GONE);
        }

    }

    private void findNeedUsersAndGroups(@NonNull Post post) {
        if (post.getSourceId() > 0) {

        } else {

        }
        List<Wallpost> copyHistory = post.getCopyHistory();
        if (copyHistory != null) {
            Wallpost primaryPost = copyHistory.get(copyHistory.size() - 1);
        }
    }

    @NonNull private String getFormattedDate(long dateMillis) {
        Date date = new Date(dateMillis * 1000L);
        Date now = new Date();
        Date yesterday = new Date(now.getTime() - (24L * 60L * 60L * 1000L));
        if (date.getYear() == now.getYear() &&
            date.getMonth() == now.getMonth() &&
            date.getDay() == now.getDay()) {
            long secondsAgo = (now.getTime() - date.getTime()) / 1000L;
            if (secondsAgo < 5) {
                return "just now";
            } else if (secondsAgo / 60 == 0) {
                return secondsAgo + " seconds ago";
            } else if (secondsAgo / 60 / 60 == 0) {
                return secondsAgo / 60 + " minutes ago";
            } else {
                return secondsAgo / 60 / 60 + " hours ago";
            }
        } else if (date.getYear() == yesterday.getYear() &&
            date.getMonth() == yesterday.getMonth() &&
            date.getDay() == yesterday.getDay()) {
            SimpleDateFormat formatter = new SimpleDateFormat("'tomorrow at' hh:mm", Locale.ENGLISH);
            return formatter.format(date);
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy 'at' hh:mm", Locale.ENGLISH);
            return formatter.format(date);
        }
    }

}
