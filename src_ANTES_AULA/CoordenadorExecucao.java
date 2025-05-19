// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : POLIMORFISMO em JAVA
// Ano/S: 2025/1S
// ----------------------------------------
 
// classe principal (faz o papel efetivo de 'main',
// sendo instanciada pelo programa principal do projeto)
// -----------------------------------------------------

// importação do pacote que contém o código para uso do calendario
import java.time.LocalDate;

// importação do pacote que contém o código para uso do teclado
import java.util.Scanner;

// classe coordenadora da execução dos testes
public class CoordenadorExecucao {

    // método que realiza todos os testes
    public void executaTudo() {

        // criação de um objeto 'Scanner' para a interação com o teclado
        Scanner teclado = new Scanner(System.in);


        // declaração de constantes para uso no menu
        final int PROCESSAMENTO_INDIVIDUAL = 1;
        final int PROCESSAMENTO_POLIMORFICO = 2;
        final int PROCESSAMENTO_POLIMORFICO_ACESSO_INDIVIDUAL = 3;
        final int EXIBICAO_NOME_CLASSE = 4;
        final int SAIR = 9;

        // cria objetos das subclasses
        EmpregadoAssalariado assalariado
                = new EmpregadoAssalariado(
                    "Carlos", 
                    "Filho", 
                    "111.111.111-11",
                    13,
                    5,
                    1979,
                    800.00);

        EmpregadoHorista horista
                = new EmpregadoHorista(
                    "Marcos", 
                    "Neto", 
                    "222.222.222-22",
                    33,
                    5,
                    1991,
                    16.75, 
                    40);

        EmpregadoComissionado comissionado
                = new EmpregadoComissionado(
                        "Renato",
                        "Sobrinho", 
                        "333.333.333-33",
                        5,
                        5,
                        1998,
                        10000,
                        .06);

        EmpregadoComissionadoMaisFixo comissionadoMaisFixo
                = new EmpregadoComissionadoMaisFixo(
                        "Robert",
                        "Junior",
                        "444.444.444-44",
                        25,
                        5,
                        2001,
                        5000,
                        .04,
                        300);

        EmpregadoProducao producao
                = new EmpregadoProducao(
                    "João", 
                    "Carvalho", 
                    "555.555.555-55",
                    33,
                    5,
                    1991,
                    17.50, 
                    40);
                    
     
        // cria um array Empregado de quatro elementos
        Empregado empregados[] = new Empregado[5];

        // inicializa o array com Empregado          
        empregados[0] = assalariado;
        empregados[1] = horista;
        empregados[2] = comissionado;
        empregados[3] = comissionadoMaisFixo;
        empregados[4] = producao;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1: Processamento INDIVIDUAL  de vários tipos de objetos 'Empregado'");
            System.out.println("2 - Atividade 2: Processamento POLIMÓRFICO de vários tipos de objetos 'Empregado'");
            System.out.println("3 - Atividade 3: Processamento POLIMÓRFICO COM ACESSO INDIVIDUALIZADO a cada tipo de objeto 'Empregado'");
            System.out.println("4 - Atividade 4: Exibição do nome da classe efetiva de cada objeto da classe 'Empregado'");
            System.out.println("9 - Sair");

            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();

            // avaliação da opção e acionamento da respectiva Atividade
            switch (escolha) {

                case PROCESSAMENTO_INDIVIDUAL:
                    System.out.println("\nAtividade 1: Processamento INDIVIDUAL  de vários tipos de objetos 'Empregado'");
                    System.out.println("-----------------------------------------------------------------------------");

                    System.out.println("Empregados processados individualmente:\n");

                    System.out.printf("%s\n%s: R$%,.2f\n\n",
                            assalariado, "Vencimentos", assalariado.vencimentos());
                    System.out.printf("%s\n%s: R$%,.2f\n\n",
                            horista, "Vencimentos", horista.vencimentos());
                    System.out.printf("%s\n%s: R$%,.2f\n\n",
                            comissionado, "Vencimentos", comissionado.vencimentos());
                    System.out.printf("%s\n%s: R$%,.2f\n\n",
                            comissionadoMaisFixo,
                            "Vencimentos", comissionadoMaisFixo.vencimentos());
                    System.out.printf("%s\n%s: R$%,.2f\n\n",
                            producao, "Vencimentos", producao.vencimentos());  

                    break;

                case PROCESSAMENTO_POLIMORFICO:
                    System.out.println("\nAtividade 2: Processamento POLIMÓRFICO de vários tipos de objetos 'Empregado'");
                    System.out.println("-----------------------------------------------------------------------------");

                    System.out.println("Empregados processados polimorficamente:\n");

                    // processa genericamente cada elemento no empregados
                    for (Empregado empregadoAtual : empregados) {

                        double vencimento = empregadoAtual.vencimentos();

                        System.out.println(empregadoAtual); // invoca toString  

                        LocalDate dataAtual = LocalDate.now();
                        int mesNumerico = dataAtual.getMonthValue();

                        if (empregadoAtual.getDataNascimento().getMonth() == mesNumerico) {
                        System.out.println(">>> ANIVERSÁRIO NO MÊS! Bônus aplicado!");

                        // Aplica bônus sem alterar os atributos
                        if (empregadoAtual instanceof EmpregadoAssalariado) {
                            vencimento += 100.00;
                        } else if (empregadoAtual instanceof EmpregadoComissionadoMaisFixo) {
                            vencimento *= 1.5;
                        } else if (empregadoAtual instanceof EmpregadoComissionado) {
                            vencimento += ((EmpregadoComissionado) empregadoAtual).getVendasBrutas() * 
                                        (((EmpregadoComissionado) empregadoAtual).getTaxaComissao() * 0.5); // 50% extra sobre comissão
                        } else if (empregadoAtual instanceof EmpregadoHorista) {
                            double valorExtra = ((EmpregadoHorista) empregadoAtual).getSalarioPorHora() * 0.4;
                            vencimento += valorExtra * ((EmpregadoHorista) empregadoAtual).getQtdHorasSemanais();
                        } else if (empregadoAtual instanceof EmpregadoProducao) {
                            double valorExtra = ((EmpregadoProducao) empregadoAtual).getValorPecaProduzida() * 0.3;
                            vencimento += valorExtra * ((EmpregadoProducao) empregadoAtual).getQtdPecaProduzida();
                        }
                    }

                    //System.out.println(empregadoAtual); // toString
                    System.out.printf("Vencimentos R$%,.2f\n\n", vencimento);
    

                        //System.out.printf("Vencimentos R$%,.2f\n\n", empregadoAtual.vencimentos());
                    } // for final

                    break;

                case PROCESSAMENTO_POLIMORFICO_ACESSO_INDIVIDUAL:
                    System.out.println("\nAtividade 3: Processamento POLIMÓRFICO COOM ACESSO INDIVIDUALIZADO a cada tipo de objeto 'Empregado'");
                    System.out.println("------------------------------------------------------------------------------------------------------");

                    System.out.println("Empregados processados polimorficamente, mas acesso individual ao tipo 'EmpregadoComissionadoMaisFixo:\n");

                    // processa genericamente cada elemento no empregados
                    for (Empregado empregadoAtual : empregados) {

                        // determina se elemento é um 'EmpregadoComissionadoMaisFixo'
                        if (empregadoAtual instanceof EmpregadoComissionadoMaisFixo) {
                            // 'downcast' da referência de 'Empregado' para
                            // referência a 'EmpregadoComissionadoFixo'
                            EmpregadoComissionadoMaisFixo empregado
                                    = (EmpregadoComissionadoMaisFixo) empregadoAtual;

                            double salarioBaseAnterior = empregado.getSalarioBase();
                            empregado.setSalarioBase(1.10 * salarioBaseAnterior);
                            System.out.printf(
                                    "Novo salário base com 10%% de aumento é: R$%,.2f\n",
                                    empregado.getSalarioBase());

                            System.out.println(empregado); // invoca toString
                            System.out.printf(
                                "Vencimentos R$%,.2f\n\n", empregado.vencimentos());

                        } // fim do if

                    } // for final

                    break;

                case EXIBICAO_NOME_CLASSE:
                    System.out.println("\nAtividade 4: Exibição do nome da classe efetiva de cada objeto da classe 'Empregado'");
                    System.out.println("--------------------------------------------------------------------------------------");

                    System.out.println("Nome da classe efetiva de cada Empregado no vetor 'empregados':");

                    // obtém o nome do tipo de cada objeto no array empregados
                    for (int j = 0; j < empregados.length; j++) {
                        System.out.printf("empregados[%d] é um %s\n", j,
                                empregados[j].getClass().getName());
                    }

                    break;

                case SAIR:
                    System.out.println("\nSair ...\n");
                    break;

                default:
                    System.out.println("\nOpção inválida !  Tente novamente ...\n");
            }

        } while (escolha != SAIR);

        teclado.close();

        // aciona método para exibição dos dados do autor do trabalho
        Autor autor = new Autor();
        autor.exibeDadosAutor(
                "ESTRUTURAS DE DADOS - 2025/1S",
                "POLIMORFISMO em JAVA",
                "Bruno Gabriel Struzziatto Vilela",
                "121 092 241 3 023");

    }

}