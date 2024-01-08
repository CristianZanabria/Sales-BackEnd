package com.zdevs.service.impl;

import com.zdevs.model.Provider;
import com.zdevs.repo.IProviderRepo;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.service.IProviderService;
import com.zdevs.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl extends CRUDImpl<Provider, Integer> implements IProviderService {

    //@Autowired
    private final IProviderRepo repo;

    @Override
    protected IGenericRepo<Provider, Integer> getRepo() {
        return repo;
    }

}
