package com.tunity.assignment.data.network.retrofit.response;

import com.google.gson.annotations.SerializedName;
import com.tunity.assignment.data.network.retrofit.util.NetworkConstants;

import java.util.List;

public class NewsResponse {

    @SerializedName(NetworkConstants.STATUS)
    public String resultStatus;

    @SerializedName(NetworkConstants.TOTAL_RESULT)
    public Integer resultCode;

    @SerializedName(NetworkConstants.ARTICLES)
    public List<ArticleVO> articlesList;

    public NewsResponse(List<ArticleVO> articlesList) {
        this.articlesList = articlesList;
    }

    public List<ArticleVO> getArticlesList() {
        return articlesList;
    }

    public void setArticlesList(List<ArticleVO> articlesList) {
        this.articlesList = articlesList;
    }
}
