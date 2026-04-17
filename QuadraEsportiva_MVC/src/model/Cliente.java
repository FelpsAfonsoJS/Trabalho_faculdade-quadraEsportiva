package model;

public class Cliente {
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome esta vazio");
        }
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}