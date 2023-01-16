package com.tunity.assignment.data.network.retrofit.response;

import com.google.gson.annotations.SerializedName;
import com.tunity.assignment.data.network.retrofit.util.NetworkConstants;
import com.tunity.assignment.ui.model.BaseModel;

public class ArticleVO extends BaseModel {

    @SerializedName(NetworkConstants.SOURCE)
    public SourceNetwork sourceNetwork;
    @SerializedName(NetworkConstants.AUTHOR)
    public String author;
    @SerializedName(NetworkConstants.TITLE)
    public String title;
    @SerializedName(NetworkConstants.DESCRIPTION)
    public String description;
    @SerializedName(NetworkConstants.URL)
    public String url;
    @SerializedName(NetworkConstants.URL_TO_IMAGE)
    public String urlToImage;
    @SerializedName(NetworkConstants.PUBLISH_AT)
    public String publishedAt;
    @SerializedName(NetworkConstants.CONTENT)
    public String content;

    public ArticleVO(SourceNetwork sourceNetwork, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
        this.sourceNetwork = sourceNetwork;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }
}
