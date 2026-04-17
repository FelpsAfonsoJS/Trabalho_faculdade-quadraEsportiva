package controller;

import model.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SistemaController {

    private Quadra sistema = new Quadra();

    public void cadastrarCliente(String nome, String telefone) {
        Cliente cliente = new Cliente(nome, telefone);
        sistema.cadastrarCliente(cliente);
    }

    public boolean registrarAluguel(String nome, LocalDate data, LocalTime hora, int duracao) {

        Cliente cliente = null;

        for (Cliente c : sistema.getClientes()) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                cliente = c;
            }
        }

        if (cliente == null) return false;

        if (!sistema.horarioDisponivel(data, hora, duracao)) {
            return false;
        }

        Aluguel aluguel = new Aluguel(cliente, data, hora, duracao);
        sistema.registrarAluguel(aluguel);

        return true;
    }

    public List<Aluguel> buscarPorData(LocalDate data) {
        return sistema.buscarPorData(data);
    }

    public List<Aluguel> buscarPorNome(String nome) {
        return sistema.buscarPorNome(nome);
    }

    public List<Aluguel> getAlugueis() {
        return sistema.getAlugueis();
    }
}