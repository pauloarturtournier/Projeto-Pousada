import java.util.Scanner;

public class Menu {

    static Hospede[] hospedes = new Hospede[10];
    static Quarto[] quartos = new Quarto[10];
    static Reserva[] reservas = new Reserva[10];

    static int totalHospedes = 0;
    static int totalQuartos = 0;
    static int totalReservas = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n=== Pousada XYZ ===");
            System.out.println("1. Gerenciar Hospedes");
            System.out.println("2. Gerenciar Quartos");
            System.out.println("3. Gerenciar Reservas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                menuHospede(scanner);
            } else if (opcao == 2) {
                menuQuarto(scanner);
            } else if (opcao == 3) {
                menuReserva(scanner);
            } else if (opcao == 4) {
                System.out.println("Encerrando sistema. Ate logo!");
            } else {
                System.out.println("Opcao invalida!");
            }
        }

        scanner.close();
    }

    // =================== HOSPEDE ===================

    static void menuHospede(Scanner scanner) {
        System.out.println("\n--- Hospedes ---");
        System.out.println("1. Cadastrar Hospede");
        System.out.println("2. Listar Hospedes");
        System.out.println("3. Buscar Hospede por CPF");
        System.out.println("4. Editar Hospede");
        System.out.print("Escolha uma opcao: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            cadastrarHospede(scanner);
        } else if (opcao == 2) {
            listarHospedes();
        } else if (opcao == 3) {
            buscarHospedePorCpf(scanner);
        } else if (opcao == 4) {
            editarHospede(scanner);
        } else {
            System.out.println("Opcao invalida!");
        }
    }

    static void cadastrarHospede(Scanner scanner) {
        if (totalHospedes == hospedes.length) {
            System.out.println("Limite de hospedes atingido!");
            return;
        }

        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        hospedes[totalHospedes] = new Hospede(nome, cpf, telefone, email);
        totalHospedes++;
        System.out.println("Hospede cadastrado com sucesso!");
    }

    static void listarHospedes() {
        if (totalHospedes == 0) {
            System.out.println("Nenhum hospede cadastrado.");
            return;
        }
        for (int i = 0; i < totalHospedes; i++) {
            System.out.println("\n--- Hospede " + (i + 1) + " ---");
            System.out.println(hospedes[i].MostraValores());
        }
    }

    static void buscarHospedePorCpf(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        for (int i = 0; i < totalHospedes; i++) {
            if (hospedes[i].getCpf().equals(cpf)) {
                System.out.println("\nHospede encontrado:");
                System.out.println(hospedes[i].MostraValores());
                return;
            }
        }

        System.out.println("Hospede nao encontrado!");
    }

    static void editarHospede(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite o CPF do hospede que deseja editar: ");
        String cpf = scanner.nextLine();

        for (int i = 0; i < totalHospedes; i++) {
            if (hospedes[i].getCpf().equals(cpf)) {
                System.out.println("Hospede encontrado:");
                System.out.println(hospedes[i].MostraValores());

                System.out.print("\nNovo nome (" + hospedes[i].getNome() + "): ");
                String nome = scanner.nextLine();
                System.out.print("Novo telefone (" + hospedes[i].getTelefone() + "): ");
                String telefone = scanner.nextLine();
                System.out.print("Novo email (" + hospedes[i].getEmail() + "): ");
                String email = scanner.nextLine();

                hospedes[i].setNome(nome);
                hospedes[i].setTelefone(telefone);
                hospedes[i].setEmail(email);

                System.out.println("Hospede atualizado com sucesso!");
                return;
            }
        }

        System.out.println("Hospede nao encontrado!");
    }

    // =================== QUARTO ===================

    static void menuQuarto(Scanner scanner) {
        System.out.println("\n--- Quartos ---");
        System.out.println("1. Cadastrar Quarto");
        System.out.println("2. Listar Quartos");
        System.out.println("3. Listar Quartos Disponiveis");
        System.out.println("4. Filtrar por Tipo");
        System.out.println("5. Editar Quarto");
        System.out.print("Escolha uma opcao: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            cadastrarQuarto(scanner);
        } else if (opcao == 2) {
            listarQuartos();
        } else if (opcao == 3) {
            listarQuartosDisponiveis();
        } else if (opcao == 4) {
            filtrarQuartosPorTipo(scanner);
        } else if (opcao == 5) {
            editarQuarto(scanner);
        } else {
            System.out.println("Opcao invalida!");
        }
    }

    static void cadastrarQuarto(Scanner scanner) {
        if (totalQuartos == quartos.length) {
            System.out.println("Limite de quartos atingido!");
            return;
        }

        scanner.nextLine();
        System.out.print("Numero do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Preco por diaria: R$");
        double preco = scanner.nextDouble();

        System.out.println("Tipo do quarto:");
        System.out.println("1. Simples");
        System.out.println("2. Casal");
        System.out.println("3. Luxo");
        System.out.print("Escolha uma opcao: ");
        int tipo = scanner.nextInt();

        if (tipo == 1) {
            System.out.print("Tem ventilador? (true/false): ");
            boolean temVentilador = scanner.nextBoolean();
            quartos[totalQuartos] = new QuartoSimples(numero, preco, true, temVentilador);
        } else if (tipo == 2) {
            System.out.print("Tem varanda? (true/false): ");
            boolean temVaranda = scanner.nextBoolean();
            quartos[totalQuartos] = new QuartoCasal(numero, preco, true, temVaranda);
        } else if (tipo == 3) {
            System.out.print("Tem jacuzzi? (true/false): ");
            boolean temJacuzzi = scanner.nextBoolean();
            quartos[totalQuartos] = new QuartoLuxo(numero, preco, true, temJacuzzi);
        } else {
            System.out.println("Tipo invalido!");
            return;
        }

        totalQuartos++;
        System.out.println("Quarto cadastrado com sucesso!");
    }

    static void listarQuartos() {
        if (totalQuartos == 0) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }
        for (int i = 0; i < totalQuartos; i++) {
            System.out.println("\n--- Quarto " + (i + 1) + " ---");
            System.out.println(quartos[i].MostraValores());
        }
    }

    static void listarQuartosDisponiveis() {
        boolean encontrou = false;

        for (int i = 0; i < totalQuartos; i++) {
            if (quartos[i].getDisponivel()) {
                System.out.println("\n--- Quarto " + (i + 1) + " ---");
                System.out.println(quartos[i].MostraValores());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum quarto disponivel.");
        }
    }

    static void filtrarQuartosPorTipo(Scanner scanner) {
        System.out.println("Filtrar por:");
        System.out.println("1. Simples");
        System.out.println("2. Casal");
        System.out.println("3. Luxo");
        System.out.print("Escolha uma opcao: ");
        int tipo = scanner.nextInt();

        boolean encontrou = false;

        for (int i = 0; i < totalQuartos; i++) {
            if (tipo == 1 && quartos[i] instanceof QuartoSimples) {
                System.out.println("\n--- Quarto " + (i + 1) + " ---");
                System.out.println(quartos[i].MostraValores());
                encontrou = true;
            } else if (tipo == 2 && quartos[i] instanceof QuartoCasal) {
                System.out.println("\n--- Quarto " + (i + 1) + " ---");
                System.out.println(quartos[i].MostraValores());
                encontrou = true;
            } else if (tipo == 3 && quartos[i] instanceof QuartoLuxo) {
                System.out.println("\n--- Quarto " + (i + 1) + " ---");
                System.out.println(quartos[i].MostraValores());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum quarto encontrado para esse tipo.");
        }
    }

    static void editarQuarto(Scanner scanner) {
        System.out.print("Digite o numero do quarto que deseja editar: ");
        int numero = scanner.nextInt();

        for (int i = 0; i < totalQuartos; i++) {
            if (quartos[i].getNumero() == numero) {
                System.out.println("Quarto encontrado:");
                System.out.println(quartos[i].MostraValores());

                System.out.print("\nNovo preco por diaria (" + quartos[i].getPrecoPorDiaria() + "): R$");
                double preco = scanner.nextDouble();

                System.out.print("Disponivel? (true/false): ");
                boolean disponivel = scanner.nextBoolean();

                quartos[i].setPrecoPorDiaria(preco);
                quartos[i].setDisponivel(disponivel);

                System.out.println("Quarto atualizado com sucesso!");
                return;
            }
        }

        System.out.println("Quarto nao encontrado!");
    }

    // =================== RESERVA ===================

    static void menuReserva(Scanner scanner) {
        System.out.println("\n--- Reservas ---");
        System.out.println("1. Cadastrar Reserva");
        System.out.println("2. Listar Reservas");
        System.out.println("3. Buscar Reserva por Hospede");
        System.out.println("4. Cancelar Reserva");
        System.out.print("Escolha uma opcao: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            cadastrarReserva(scanner);
        } else if (opcao == 2) {
            listarReservas();
        } else if (opcao == 3) {
            buscarReservaPorHospede(scanner);
        } else if (opcao == 4) {
            cancelarReserva(scanner);
        } else {
            System.out.println("Opcao invalida!");
        }
    }

    static void cadastrarReserva(Scanner scanner) {
        if (totalHospedes == 0 || totalQuartos == 0) {
            System.out.println("Cadastre ao menos um hospede e um quarto antes!");
            return;
        }

        if (totalReservas == reservas.length) {
            System.out.println("Limite de reservas atingido!");
            return;
        }

        System.out.println("Escolha o hospede:");
        for (int i = 0; i < totalHospedes; i++) {
            System.out.println((i + 1) + ". " + hospedes[i].getNome());
        }
        int indexHospede = scanner.nextInt() - 1;

        if (indexHospede < 0 || indexHospede >= totalHospedes) {
            System.out.println("Hospede invalido!");
            return;
        }

        System.out.println("Escolha o quarto disponivel:");
        for (int i = 0; i < totalQuartos; i++) {
            if (quartos[i].getDisponivel()) {
                System.out.println((i + 1) + ". Quarto " + quartos[i].getNumero());
            }
        }
        int indexQuarto = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indexQuarto < 0 || indexQuarto >= totalQuartos) {
            System.out.println("Quarto invalido!");
            return;
        }

        if (!quartos[indexQuarto].getDisponivel()) {
            System.out.println("Esse quarto nao esta disponivel!");
            return;
        }

        System.out.print("Data de entrada (DD/MM/AAAA): ");
        String entrada = scanner.nextLine();
        System.out.print("Data de saida (DD/MM/AAAA): ");
        String saida = scanner.nextLine();

        reservas[totalReservas] = new Reserva(hospedes[indexHospede], quartos[indexQuarto], entrada, saida);
        totalReservas++;

        quartos[indexQuarto].setDisponivel(false);

        System.out.println("Reserva cadastrada com sucesso!");
    }

    static void listarReservas() {
        if (totalReservas == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }
        for (int i = 0; i < totalReservas; i++) {
            System.out.println("\n--- Reserva " + (i + 1) + " ---");
            System.out.println(reservas[i].MostraValores());
        }
    }

    static void buscarReservaPorHospede(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite o nome do hospede: ");
        String nome = scanner.nextLine();

        boolean encontrou = false;

        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i].getHospede().getNome().equalsIgnoreCase(nome)) {
                System.out.println("\n--- Reserva " + (i + 1) + " ---");
                System.out.println(reservas[i].MostraValores());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma reserva encontrada para esse hospede.");
        }
    }

    static void cancelarReserva(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite o nome do hospede da reserva: ");
        String nome = scanner.nextLine();

        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i].getHospede().getNome().equalsIgnoreCase(nome) && reservas[i].getStatus().equals("Ativa")) {
                reservas[i].setStatus("Cancelada");
                reservas[i].getQuarto().setDisponivel(true);
                System.out.println("Reserva cancelada com sucesso!");
                return;
            }
        }

        System.out.println("Nenhuma reserva ativa encontrada para esse hospede.");
    }
}