package br.com.alura.domain;

public class Abrigo {

    public Abrigo() {

    }

    public Abrigo(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Pet[] getPets() {
        return pets;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\"id\": " + id + "," +
                "\"nome\": " + "\"" + nome + "\"," +
                "\"telefone\": " + telefone + "," +
                "\"email\": " + "\"" + email + "\"";
    }


    private long id;
    private String nome;
    private String telefone;
    private String email;
    private Pet[] pets;


}
