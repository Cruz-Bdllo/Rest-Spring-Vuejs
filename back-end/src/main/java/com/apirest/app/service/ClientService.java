package com.apirest.app.service;

import com.apirest.app.entity.Client;
import com.apirest.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ClientService implements IClientService{

    @Autowired
    ClientRepository repositoryClient;


    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return (List<Client>) repositoryClient.findAll();
    } // end get

    @Transactional(readOnly = true)
    public Client findClientById(int id) {
        return repositoryClient.findById(id).orElse(null);
    } //  end get one client

    @Transactional(readOnly = false)
    public void saveClient(Client client) {
        repositoryClient.save(client);
    } // end save client

    @Transactional(readOnly = false)
    public void deleteClientById(int id){
        repositoryClient.deleteById(id);
    } // end delete client

} // end service client
