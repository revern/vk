package com.example.revern.vkontaktetest.news_feed.models;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id") private         int    id;
    @SerializedName("album_id") private   int    albumId;
    @SerializedName("owner_id") private   int    ownerId;
    @SerializedName("user_id") private    int    userId;
    @SerializedName("photo_75") private   String photo75;
    @SerializedName("photo_130") private  String photo130;
    @SerializedName("photo_604") private  String photo604;
    @SerializedName("photo_807") private  String photo807;
    @SerializedName("photo_1280") private String photo1280;
    @SerializedName("photo_2560") private String photo2560;
    @SerializedName("post_id") private    int    postId;
    @SerializedName("width") private      int    width;
    @SerializedName("height") private     int    height;
    @SerializedName("text") private       String text;
    @SerializedName("date") private       long   date;
    @SerializedName("lat") private        float  lat;
    @SerializedName("long") private       float  lng;
    @SerializedName("access_key") private String accessKey;

    public int getId() {
        return id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getUserId() {
        return userId;
    }

    public String getPhoto75() {
        return photo75;
    }

    public String getPhoto130() {
        return photo130;
    }

    public String getPhoto604() {
        return photo604;
    }

    public String getPhoto807() {
        return photo807;
    }

    public String getPhoto1280() {
        return photo1280;
    }

    public String getPhoto2560() {
        return photo2560;
    }

    public int getPostId() {
        return postId;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    public long getDate() {
        return date;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public String getAccessKey() {
        return accessKey;
    }

}
