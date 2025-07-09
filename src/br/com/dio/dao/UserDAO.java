package br.com.dio.dao;

import br.com.dio.exception.EmptyStorageException;
import br.com.dio.exception.userNotFoundException;
import br.com.dio.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private long nextId = 1L;
    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model){
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model){
        var toUpade = findByid(model.getId());
        models.remove(toUpade);
        models.add(model);
        return model;
    }

    public void delete(final long id){
        var toDelete = findByid(id);
        models.remove(toDelete);
    }

    public UserModel findByid(final long id){
        verifyStorage();
        var menssage = String.format("nao existe usuario com id %s cadastrado", id);
        return models.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(() -> new userNotFoundException(menssage));
    }

    public List<UserModel> findAll() {
        List<UserModel> result;
        try{//verifica se esta vazio
            verifyStorage();
            result = models;
        }catch (EmptyStorageException ex){//trata excecao
            ex.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    private void verifyStorage(){
        if(models.isEmpty()) throw new EmptyStorageException("o armazenamento esta vazio");
    }
}
