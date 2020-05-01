package com.apirest.app.controller;

import com.apirest.app.entity.Client;
import com.apirest.app.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private IClientService serviceClient;

    @GetMapping(path = {"/", "index"})
    public String index(){
        return "Hello world!";
    } // end index --

    @GetMapping(path = {"/all"})
    @ResponseStatus(HttpStatus.OK)
    public List<Client> FindAllClient(){
        return serviceClient.getAllClients();
    } // end get

    @GetMapping(path = {"/find/{id}"}, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Client getClient(@PathVariable int id){
        return serviceClient.findClientById(id);
    } // end get one client

    @PostMapping(path = {"/save"})
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody Client client){
        serviceClient.saveClient(client);
    } // end save client

    @PutMapping(path = {"/update/{id}"})
    public Client updateClient(@RequestBody Client client, @PathVariable int id){
        Client clientController = serviceClient.findClientById(id);

        clientController.setName(client.getName());
        clientController.setEmail(client.getEmail());
        clientController.setAge(client.getAge());
        clientController.setGenre(client.getGenre());

        serviceClient.saveClient(clientController);

        return clientController;
    } // end update client

    @DeleteMapping(path = {"/delete/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable int id){
        serviceClient.deleteClientById(id);
    }

} // end controller
