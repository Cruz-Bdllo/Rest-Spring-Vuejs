export default class Client{
    idClient;
    name;
    email;
    age;
    genre;

    set idClient(idClient){
        this.idClient = idClient;
    }
    get idClient(){
        return this.idClient;
    }

    set name(name){
        this.name = name;
    }
    get name(){
        return this.name;
    }

    set age(age){
        this.age = age;
    }
    get age(){
        return this.age;
    }

    set genre(genre){
        this.genre = genre;
    }
    get genre(){
        return this.genre;
    }

}