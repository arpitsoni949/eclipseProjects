package com.springmvc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springmvc.Entity.User;
import com.springmvc.service.UserService;

public class ContainerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        try {
			LogManager.getLogManager().readConfiguration(new FileInputStream("src/main/resources/log4j.properties"));
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		final Logger logger=Logger.getLogger(ContainerTest.class.getName());
		
		logger.info("log aya ");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.springmvc");//This will load the configured components UserService, UserRepository,
        ctx.refresh();
        
        System.out.println("AnnotationConfigApplicationContext"+ctx);
        UserService userService = ctx.getBean("userService", UserService.class);
        
        List<User> allUser = userService.getAllUsers();
        for (User u : allUser)
        {
            System.out.println("allUser"+u);
        }
        
        User user = new User(2, "arpit", "hyderabad");
        userService.saveUser(user);
        System.out.println("Newly created User:: ="+user);
        
        logger.error("error aya");
//        Integer id = userService.createUser(user);
//        System.out.println("Newly created User Id="+id);
//        
//        
//        
//        allUser = userService.getAllUsers();
//        for (User u : allUser)
//        {
//            System.out.println("allUser::"+u);
//        }
	}

}
