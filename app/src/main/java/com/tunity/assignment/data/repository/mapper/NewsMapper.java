package com.tunity.assignment.data.repository.mapper;

import android.util.Log;

import com.tunity.assignment.data.database.room.entity.ArticleEntity;
import com.tunity.assignment.data.database.room.entity.SourceLocal;
import com.tunity.assignment.data.network.retrofit.response.ArticleVO;
import com.tunity.assignment.data.network.retrofit.response.SourceNetwork;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NewsMapper {

    public ArticleEntity mapVoToEntity(ArticleVO vo) {
        return new ArticleEntity(
                new SourceLocal(vo.sourceNetwork.id,vo.sourceNetwork.name),
                vo.author,
                vo.title,
                vo.description,
                vo.url,
                vo.urlToImage,
                vo.publishedAt,
                vo.content
        );
    }

    public ArticleVO mapEntityToVo(ArticleEntity entity) {
        return new ArticleVO(
                new SourceNetwork(entity.sourceLocal.id,entity.sourceLocal.name),
                entity.author,
                entity.title,
                entity.description,
                entity.url,
                entity.urlToImage,
                entity.publishedAt,
                entity.content

        );
    }

    public List<ArticleEntity> mapVoListToEntityList(List<ArticleVO> voList) {
        ArrayList<ArticleEntity> entityArrayList = new ArrayList<>();
        for (ArticleVO vo : voList) {
            entityArrayList.add(mapVoToEntity(vo));
        }
        return entityArrayList;
    }

//    public List<ArticleVO> mapEntityListToVoList(List<ArticleEntity> entityList) {
//        ArrayList<ArticleVO> voArrayList = new ArrayList<>();
//        for (ArticleEntity entity : entityList) {
//            voArrayList.add(mapEntityToVo(entity));
//        }
//        return voArrayList;
//    }
}
