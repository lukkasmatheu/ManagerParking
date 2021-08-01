package manager.parking.models;

import java.util.Date;

public class Users {
    private String name;
    private String senha;
    public static int id;
    private String email;
    private String dataNascimento;


    public Users(){
        this.id += 1;
    }

    public static int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String data) {
        this.dataNascimento = data;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
