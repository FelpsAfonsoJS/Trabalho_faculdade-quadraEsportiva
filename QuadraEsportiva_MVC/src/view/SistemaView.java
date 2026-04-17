package view;

import controller.SistemaController;
import model.Aluguel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class SistemaView {

    private SistemaController controller = new SistemaController();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
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
                case 1 -> cadastrarCliente();
                case 2 -> registrarAluguel();
                case 3 -> buscarPorData();
                case 4 -> buscarPorNome();
            }

        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Telefone:");
        String telefone = sc.nextLine();

        try {
            controller.cadastrarCliente(nome, telefone);
            System.out.println("Cliente cadastrado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void registrarAluguel() {
        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Data (AAAA-MM-DD):");
        LocalDate data = LocalDate.parse(sc.nextLine());

        System.out.println("Hora (HH:MM):");
        LocalTime hora = LocalTime.parse(sc.nextLine());

        System.out.println("Duração:");
        int duracao = sc.nextInt();
        sc.nextLine();

        boolean sucesso = controller.registrarAluguel(nome, data, hora, duracao);

        if (sucesso) {
            System.out.println("Aluguel realizado!");
        } else {
            System.out.println("Erro: cliente não encontrado ou horário ocupado!");
        }
    }

    private void buscarPorData() {
        System.out.println("Data:");
        LocalDate data = LocalDate.parse(sc.nextLine());

        List<Aluguel> lista = controller.buscarPorData(data);

        for (Aluguel a : lista) {
            System.out.println(a.getCliente().getNome() + " - " + a.getHoraInicio());
        }
    }

    private void buscarPorNome() {
        System.out.println("Nome:");
        String nome = sc.nextLine();

        List<Aluguel> lista = controller.buscarPorNome(nome);

        for (Aluguel a : lista) {
            System.out.println(a.getData() + " - " + a.getHoraInicio());
        }
    }
}