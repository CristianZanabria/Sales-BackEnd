package com.zdevs.service.impl;

import com.zdevs.model.Role;
import com.zdevs.repo.IRoleRepo;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.service.IRoleService;
import com.zdevs.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CRUDImpl<Role, Integer> implements IRoleService {

    //@Autowired
    private final IRoleRepo repo;

    @Override
    protected IGenericRepo<Role, Integer> getRepo() {
        return repo;
    }

}
