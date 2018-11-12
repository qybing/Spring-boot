package com.jovan.service;

import com.jovan.model.Person;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PersonService {

    int deleteByPrimaryKey(String id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String id);

    PageInfo<Person> selectAll(Integer pageNum);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}
