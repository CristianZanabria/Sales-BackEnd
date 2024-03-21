package com.zdevs.repo;

import com.zdevs.model.User;

public interface IUserRepo extends IGenericRepo<User, Integer> {

    User findOneByUsername(String name);



}






















