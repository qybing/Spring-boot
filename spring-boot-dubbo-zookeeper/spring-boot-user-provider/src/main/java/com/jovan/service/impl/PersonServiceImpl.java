package com.jovan.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jovan.dao.PersonMapper;
import com.jovan.model.Person;
import com.jovan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Person record) {
        return personMapper.insert(record);
    }

    @Override
    public int insertSelective(Person record) {
        return personMapper.insertSelective(record);
    }

    @Override
    public Person selectByPrimaryKey(String id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Person> selectAll(Integer pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<Person> persons = personMapper.selectAll();
        PageInfo result = new PageInfo(persons);
        return result;
    }

    @Override
    public int updateByPrimaryKeySelective(Person record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return 0;
    }
}
