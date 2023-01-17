package com.tunity.assignment.data.database.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.tunity.assignment.data.database.room.util.DatabaseConstants;
import com.tunity.assignment.ui.model.BaseModel;

import java.io.Serializable;

@Entity(tableName = "article_table")
public class ArticleEntity extends BaseModel implements Serializable {

    @ColumnInfo(name = DatabaseConstants.SOURCE)
    public SourceLocal sourceLocal;

    @ColumnInfo(name = DatabaseConstants.AUTHOR)
    public String author;

    @ColumnInfo(name = DatabaseConstants.TITLE)
    public String title;

    @ColumnInfo(name = DatabaseConstants.DESCRIPTION)
    public String description;

    @ColumnInfo(name = DatabaseConstants.URL)
    public String url;

    @ColumnInfo(name = DatabaseConstants.URL_TO_IMAGE)
    public String urlToImage;

    @ColumnInfo(name = DatabaseConstants.PUBLISH_AT)
    public String publishedAt;

    //Ids from network sometime null,so i added primary key as autogenerate but kept adding same items
    //So i found out the only unique columnInfo(Content) and set as primary key
    //Sorry for rapid solution for this ,needs to find out a better solution.
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = DatabaseConstants.CONTENT)
    public String content;

    public ArticleEntity(SourceLocal sourceLocal, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
        this.sourceLocal = sourceLocal;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }
}
