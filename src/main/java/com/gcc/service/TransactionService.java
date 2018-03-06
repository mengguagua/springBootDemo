package com.gcc.service;

import com.gcc.dao.TestDao;
import com.gcc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gcc on 2018/3/1.
 */
@Service
public class TransactionService {

    @Autowired
    TestDao testDao;

    @Transactional
    public void payMoney(int formPerson,int toPerson,int count){
        Person p1=testDao.getPersonById(formPerson);
        p1.setMoney(p1.getMoney()-count);
        testDao.updatePerson(p1);
        Person p2=testDao.getPersonById(toPerson);
        int zero=1/0;
        p2.setMoney(p2.getMoney()+count);
        testDao.updatePerson(p2);
    }

}
