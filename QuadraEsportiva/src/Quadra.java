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

                LocalTime inicioExistente = a.getHoraInicio();
                LocalTime fimExistente = a.getHoraFim();

                if (inicio.isBefore(fimExistente) && fimNovo.isAfter(inicioExistente)) {
                    return false;
                }
            }
        }
        return true;
    }
    public void mostrarAgendaDoDia(LocalDate data){

        System.out.println("\nAgenda do dia");
        LocalTime hora = LocalTime.of(8, 0);

        while (hora.isBefore(LocalTime.of(22, 0))){

            LocalTime proximo = hora.plusMinutes(30);

            boolean ocupado = false;

            for (Aluguel a: alugueis){
                if(a.getData().equals(data)){

                    if (hora.isBefore(a.getHoraFim()) && proximo.isAfter(a.getHoraInicio())){
                        ocupado = true;
                        break;

                    }
                }
            }
            if (ocupado){
                System.out.println(hora + " - "+ proximo + " Ocupado!");
            }else {
                System.out.println(hora + " - "+ proximo + " Livre!");
            }

            hora = proximo;
        }
    }
    public List<Aluguel> BuscarPorNome(String nome){
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
}

