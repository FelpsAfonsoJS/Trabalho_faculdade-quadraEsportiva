package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Quadra {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void registrarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public boolean horarioDisponivel(LocalDate data, LocalTime inicio, int duracao) {
        LocalTime fimNovo = inicio.plusMinutes(duracao);

        for (Aluguel a : alugueis) {
            if (a.getData().equals(data)) {
                if (inicio.isBefore(a.getHoraFim()) && fimNovo.isAfter(a.getHoraInicio())) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Aluguel> buscarPorNome(String nome){
        List<Aluguel> lista = new ArrayList<>();
        for (Aluguel a : alugueis){
            if (a.getCliente().getNome().equalsIgnoreCase(nome)){
                lista.add(a);
            }
        }
        return lista;
    }

    public List<Aluguel> buscarPorData(LocalDate data){
        List<Aluguel> lista = new ArrayList<>();
        for (Aluguel a : alugueis){
            if(a.getData().equals(data)){
                lista.add(a);
            }
        }
        return lista;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }
}