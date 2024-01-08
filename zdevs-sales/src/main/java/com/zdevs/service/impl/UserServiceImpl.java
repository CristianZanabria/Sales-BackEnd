package com.zdevs.service.impl;

import com.zdevs.model.User;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.repo.IUserRepo;
import com.zdevs.service.IUserService;
import com.zdevs.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    //@Autowired
    private final IUserRepo repo;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }

}
