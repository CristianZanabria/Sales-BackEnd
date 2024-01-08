package com.zdevs.service.impl;

import com.zdevs.model.Client;
import com.zdevs.repo.IClientRepo;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDImpl<Client, Integer> implements IClientService {

    //@Autowired
    private final IClientRepo repo; //= new ClientRepository();

    @Override
    protected IGenericRepo<Client, Integer> getRepo() {
        return repo;
    }


   /* public Client saveAndValid(Client Client) {
        if (Client.getIdClient() > 0) {
            System.out.println("Client ID is the DB");
            return null;
        } else {
            return repository.save(Client);
        }
    }*/
}
