package com.tunity.assignment.data.network.retrofit.response;

import com.google.gson.annotations.SerializedName;
import com.tunity.assignment.data.network.retrofit.util.NetworkConstants;

public class ArticleVO {

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
        if(sourceNetwork!=null) {
            this.sourceNetwork = sourceNetwork;
        } else {
            this.sourceNetwork = new SourceNetwork("-","Unknown");
        }
        if(author!=null) {
            this.author = author;
        } else {
            this.author = "Anonymous";
        }
        if(title!=null) this.title = title;
        else this.title = "Unknown";
        if(description!=null) this.description = description;
        else this.description = "Undefined";
        if(url!=null) this.url = url;
        else this.url = " ";
        if(urlToImage!=null) this.urlToImage = urlToImage;
        else this.urlToImage = "";
        if(publishedAt!=null) this.publishedAt = publishedAt;
        else this.publishedAt = "-";
        if(content!=null) this.content = content;
        else this.content = "-";
    }
}
