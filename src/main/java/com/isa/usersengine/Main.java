package com.isa.usersengine;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;

import java.util.Random;

public class Main {

    public static void main(String[] args){

        UsersRepositoryDao u = new UsersRepositoryDaoBean();
        u.getUsersList().stream()
                .map((x)-> x.getName())
                .forEach(System.out::println);
        int index = new Random().nextInt(3)+1;
        System.out.println( index);
    }
}
