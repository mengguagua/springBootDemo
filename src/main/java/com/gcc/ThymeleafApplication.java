package com.gcc;

import com.gcc.dao.TestDao;
import com.gcc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//第三个是开启缓存
@SpringBootApplication
@RestController
@EnableCaching
public class ThymeleafApplication {

	@Autowired
	TestDao testDao;
	@Autowired
	TransactionService transactionService;

	@Value("${book.name}")
	private String name;

	@RequestMapping("/")
	public String home(){
		return "welcome to home the book's name is "+name;
	}

	@RequestMapping("/test")
	public String testMybatis(){
		return testDao.find().get(0).getName();
	}
	@RequestMapping("/testXml")
	public String testMybatisXml(){
		return testDao.findByXml().get(0).getName();
	}

	@RequestMapping("/pay")
	public String payMoneyController(){
		try {
			transactionService.payMoney(1,2,300);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}


}
