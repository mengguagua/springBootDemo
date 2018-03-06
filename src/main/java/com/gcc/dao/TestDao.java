package com.gcc.dao;

import com.gcc.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by gcc on 2018/2/28.
 */
@Mapper
public interface TestDao {
    @Select("select * from users;")
    public List<Person> find();

    public List<Person> findByXml();

    @Select("select * from users where id=#{formPerson}")
    Person getPersonById(int formPerson);

    @Update("update users set money=#{money} where id =#{id}")
    void updatePerson(Person p1);
}
