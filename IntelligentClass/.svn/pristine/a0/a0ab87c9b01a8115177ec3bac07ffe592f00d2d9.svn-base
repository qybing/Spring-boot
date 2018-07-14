package com.tiye.IntelligentClass.dao;

import com.tiye.IntelligentClass.model.ClassPhotoPic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassPhotoPicMapper {
    int deleteByPrimaryKey(Long id);



    int batchInsertPic(List<ClassPhotoPic> pics);

    int deleteByPhotoId(Long photoId);

    List<ClassPhotoPic> getPicsByPhotoId(Long photoId);

}