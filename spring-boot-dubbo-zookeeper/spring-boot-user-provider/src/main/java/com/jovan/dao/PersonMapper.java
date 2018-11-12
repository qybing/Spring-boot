package com.jovan.dao;

import com.jovan.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonMapper {
    int deleteByPrimaryKey(String id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String id);

    List<Person> selectAll();

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}