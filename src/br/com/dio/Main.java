package br.com.dio;

import br.com.dio.dao.UserDAO;
import br.com.dio.model.UserModel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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

    private static UserModel requestToSave(){
        System.out.print("informe o nome do usuario: ");
        var name = scanner.next();
        System.out.print("informe o e-mail do usuario: ");
        var email = scanner.next();
        System.out.print("informe a data de nascimento do usuario (dd/MM/yyyy): ");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(0, name, email, birthday);
    }

    private static UserModel requestToUpdate(){
        System.out.print("informe o id do usuario: ");
        var id = scanner.nextLong();
        System.out.print("informe o nome do usuario: ");
        var name = scanner.next();
        System.out.print("informe o e-mail do usuario: ");
        var email = scanner.next();
        System.out.print("informe a data de nascimento do usuario (dd/MM/yyyy): ");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(id, name, email, birthday);
    }


}
