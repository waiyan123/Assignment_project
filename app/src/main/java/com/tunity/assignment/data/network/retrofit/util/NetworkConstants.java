package com.tunity.assignment.data.network.retrofit.util;

public class NetworkConstants {

    //base url && end points
    public static String BASE_URL = "https://newsapi.org/";
    public static String POPULAR_NEWS_API_END_POINT = "v2/everything?q=apple&from=2023-01-12&to=2023-01-12&sortBy=popularity";

    //api key
    public static String API_KEY = "eee76ebc3c424890b56ba1daa4048ca4";

    //News Response
    public static final String ARTICLES = "articles";
    public static final String STATUS = "status";
    public static final String TOTAL_RESULT = "totalResults";

    //Article
    public static final String SOURCE = "source";
    public static final String AUTHOR = "author";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String URL = "url";
    public static final String URL_TO_IMAGE = "urlToImage";
    public static final String PUBLISH_AT = "publishedAt";
    public static final String CONTENT = "content";

    //Source
    public static final String ID = "id";
    public static final String NAME = "name";

}
