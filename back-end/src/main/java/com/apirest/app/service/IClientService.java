package com.apirest.app.service;

import com.apirest.app.entity.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<Client> getAllClients();

    Client findClientById(int id);

    void saveClient(Client client);

    void deleteClientById(int id);
} // end service
