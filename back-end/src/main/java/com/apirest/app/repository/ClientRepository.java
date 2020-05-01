package com.apirest.app.repository;

import com.apirest.app.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
} // end repository
