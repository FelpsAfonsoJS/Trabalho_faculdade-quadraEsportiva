import java.util.*;
import java.time.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Quadra sistema = new Quadra();

        int opcao;

        do {
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Registrar Aluguel");
            System.out.println("3 - Buscar por Data");
            System.out.println("4 - Buscar por Nome");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(sc, sistema);
                    break;
                case 2:
                    registrarAluguel(sc, sistema);
                    break;
                case 3:
                    buscarPorData(sc, sistema);
                    break;
                case 4:
                    buscarPorNome(sc, sistema);
                    break;
            }

        } while (opcao != 0);
    }

    public static void cadastrarCliente(Scanner sc, Quadra sistema) {
        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Telefone:");
        String telefone = sc.nextLine();

        try {
            Cliente cliente = new Cliente(nome, telefone);
            sistema.cadastrarCliente(cliente);
            System.out.println("Cliente cadastrado!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void registrarAluguel(Scanner sc, Quadra sistema) {

        System.out.println("Nome do cliente:");
        String nome = sc.nextLine();

        Cliente cliente = null;

        for (Cliente c : sistema.getClientes()) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                cliente = c;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Data (AAAA-MM-DD):");
        LocalDate data = LocalDate.parse(sc.nextLine());

        sistema.mostrarAgendaDoDia(data);

        System.out.println("Hora início (HH:MM):");
        LocalTime hora = LocalTime.parse(sc.nextLine());

        System.out.println("Duração (30, 60, 90, 120):");
        int duracao = sc.nextInt();
        sc.nextLine();

        if (!sistema.horarioDisponivel(data, hora, duracao)) {
            System.out.println("Horário ocupado!");
            return;
        }

        Aluguel aluguel = new Aluguel(cliente, data, hora, duracao);
        sistema.registrarAluguel(aluguel);

        System.out.println("Aluguel realizado!");
        System.out.println("Total: R$ " + aluguel.calcularTotal());
    }

    public static void buscarPorData(Scanner sc, Quadra sistema) {
        System.out.println("Data:");
        LocalDate data = LocalDate.parse(sc.nextLine());

        List<Aluguel> lista = sistema.buscarPorData(data);

        for (Aluguel a : lista) {
            System.out.println(a.getCliente().getNome() + " - " + a.getHoraInicio());
        }
    }

    public static void buscarPorNome(Scanner sc, Quadra sistema) {
        System.out.println("Nome:");
        String nome = sc.nextLine();

        List<Aluguel> lista = sistema.BuscarPorNome(nome);

        for (Aluguel a : lista) {
            System.out.println(a.getData() + " - " + a.getHoraInicio());
        }
    }
}