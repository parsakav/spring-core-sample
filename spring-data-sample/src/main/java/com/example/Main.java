package com.example;

import com.example.conf.Config;
import com.example.model.Member;
import com.example.dao.MemberDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
   MemberDao mem= ctx.getBean(MemberDao.class);
mem.save(new Member("Amir"));

    }
}
