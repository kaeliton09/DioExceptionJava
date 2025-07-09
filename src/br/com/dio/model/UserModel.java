package br.com.dio.model;

<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> 9132223 (criando excecoes)
import java.time.OffsetDateTime;
import java.util.Objects;

public class UserModel {

    private long id;
    private String name;
    private String email;
<<<<<<< HEAD
    private OffsetDateTime birthday;

    public UserModel(long id, String name, String email, OffsetDateTime birthday) {
=======
    private LocalDate birthday;

    public UserModel(long id, String name, String email, LocalDate birthday) {
>>>>>>> 9132223 (criando excecoes)
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public UserModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(OffsetDateTime birthday) {
=======
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
>>>>>>> 9132223 (criando excecoes)
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserModel UserModel = (UserModel) o;
        return id == UserModel.id && Objects.equals(name, UserModel.name) && Objects.equals(email, UserModel.email) && Objects.equals(birthday, UserModel.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthday);
    }

    @Override
    public String toString() {
        return "userModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
