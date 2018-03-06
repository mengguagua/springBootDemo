package com.gcc.web;

import com.gcc.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gcc on 2018/2/28.
 */
@Controller
@SpringBootApplication
public class thymeleafDemoController {

    @RequestMapping("/home")
    public String index(Model model){
        Person single = new Person("sky",21);
        List<Person> personList = new ArrayList<Person>();
        Person p1 = new Person("OK_mary",27);
        Person p2= new Person("jack",16);
        Person p3= new Person("faker",22);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",personList);
        return "index";
    }

}
