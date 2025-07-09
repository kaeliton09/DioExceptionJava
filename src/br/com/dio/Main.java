package br.com.dio;

import br.com.dio.dao.UserDAO;
<<<<<<< HEAD
import br.com.dio.model.UserModel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

=======
import br.com.dio.exception.EmptyStorageException;
import br.com.dio.exception.ValidatorException;
import br.com.dio.exception.userNotFoundException;
import br.com.dio.model.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static br.com.dio.validator.UserValidator.verifyModel;

>>>>>>> 9132223 (criando excecoes)
public class Main {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            System.out.println("bem vindo ao cadastro de usuarios, selecione a operacao desejada ");
            System.out.println("1 - cadastrar");
            System.out.println("2 - atualizar");
            System.out.println("3 - excluir");
            System.out.println("4 - buscar por id");
            System.out.println("5 - listar");
            System.out.println("6 - sair");
            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values()[userInput-1];
            switch (selectedOption){
                case SAVE -> {
<<<<<<< HEAD
                    var user = dao.save(requestToSave());
                    System.out.printf("usuario %s cadastrado com sucesso\n", user.getName());
                }
                case UPDATE -> {
                    var user = dao.update(requestToUpdate());
                    System.out.printf("usuario %s atualizado com sucesso\n", user.getName());
                }
                case DELETE -> {
                    dao.delete(requestId());
                    System.out.println("usuario deletado com sucesso");
                }
                case FIND_BY_ID -> {
                    var user = dao.findByid(requestId());
                    System.out.printf("usuario com id %s: \n", user.getId());
                    System.out.println(user);
=======
                    try {
                        var user = dao.save(requestToSave());
                        System.out.printf("usuario %s cadastrado com sucesso\n", user.getName());
                    }catch(ValidatorException ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                case UPDATE -> {
                    try {
                        var user = dao.update(requestToUpdate());
                        System.out.printf("usuario %s atualizado com sucesso\n", user.getName());
                    }catch (userNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }catch (ValidatorException ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("usuario deletado com sucesso");
                    }catch (userNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        var user = dao.findByid(requestId());
                        System.out.printf("usuario com id %s: \n", user.getId());
                        System.out.println(user);
                    } catch (userNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
>>>>>>> 9132223 (criando excecoes)
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("usuarios cadastrados: ");
                    users.forEach(System.out::println);
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    private static long requestId(){
        System.out.print("informe o id do usuario: ");
        return scanner.nextLong();
    }

<<<<<<< HEAD
    private static UserModel requestToSave(){
=======
    private static UserModel requestToSave() throws ValidatorException {
>>>>>>> 9132223 (criando excecoes)
        System.out.print("informe o nome do usuario: ");
        var name = scanner.next();
        System.out.print("informe o e-mail do usuario: ");
        var email = scanner.next();
        System.out.print("informe a data de nascimento do usuario (dd/MM/yyyy): ");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
<<<<<<< HEAD
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(0, name, email, birthday);
    }

    private static UserModel requestToUpdate(){
=======
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validatorInputs(0, name, email, birthday);
    }

    private static UserModel validatorInputs(final long id, final String name, final String email, final LocalDate birthday) throws ValidatorException {
        var user = new UserModel(0, name, email, birthday);
        verifyModel(user);
        return user;
    }

    private static UserModel requestToUpdate() throws ValidatorException {
>>>>>>> 9132223 (criando excecoes)
        System.out.print("informe o id do usuario: ");
        var id = scanner.nextLong();
        System.out.print("informe o nome do usuario: ");
        var name = scanner.next();
        System.out.print("informe o e-mail do usuario: ");
        var email = scanner.next();
        System.out.print("informe a data de nascimento do usuario (dd/MM/yyyy): ");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
<<<<<<< HEAD
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(id, name, email, birthday);
=======
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validatorInputs(0, name, email, birthday);
>>>>>>> 9132223 (criando excecoes)
    }


}
