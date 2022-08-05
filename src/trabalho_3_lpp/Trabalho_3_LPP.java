package trabalho_3_lpp;

import java.util.HashSet;
import java.util.Scanner;

public class Trabalho_3_LPP {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int escolha;
        String tipo, nome, especie, opcao;
        Double peso;
        boolean existe = false, remove = false, pesquisa = false;
        //inicialização da coleção Hashset que guarda dados do tipo Mamífero
        HashSet<Mamifero> mam = new HashSet<Mamifero>();
        HashSet<Mamifero> mam2 = new HashSet<Mamifero>();

        do {
            System.out.println("\n|1 - Inserir Animal");
            System.out.println("|2 - Eliminar Animal");
            System.out.println("|3 - Total de Animais");
            System.out.println("|4 - Apresentar Animais com Peso Superior");
            System.out.println("|5 - Pesquisar Animal|");
            System.out.println("|6- Apresentação dos Animais|");
            System.out.println("|7- Guardar Animais numa coleção diferente|");
            System.out.println("|8 - Ver a Coleção Anterior|");
            System.out.println("|9- Sair |");
            System.out.printf("\nEscolha uma das opções: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    leitura.nextLine();
                    System.out.println("\nQual o tipo de mamífero?");
                    tipo = leitura.nextLine().toLowerCase();
                    /*A variavel "tipo" vai servir para comparar com o tipo de 
                    mamíferos presentes*/
                    if (tipo.equals("felino")) {
                        Mamifero fel = new Felinos();
                        System.out.println("\nQual o nome do Felino?");
                        nome = leitura.nextLine().toLowerCase();
                        System.out.println("\nQual a espécie do Felino?");
                        especie = leitura.nextLine().toLowerCase();
                        System.out.println("\nQual o peso do Felino?");
                        peso = leitura.nextDouble();
                        /*Caso um dos campos estiver incorretamente preenchido
                        desde nome ou espécie em branco ou com peso inferior a 0
                        os dados não serão inseridos no HashSet*/
                        if (nome.equals("") || especie.equals("") || peso <= 0) {
                            System.out.println("Dados Inseridos Inválidos");
                            break;
                        } else {
                            /*Após a verificação acima não detetar qualquer falha,
                            cada variavel é guardada no Felino que herda o Mamífero
                            sendo possível guardar o Felino do tipo Mamífero no HashSet
                             */
                            fel.nome(nome);
                            fel.especie(especie);
                            fel.peso(peso);
                            mam.add(fel);
                            System.out.println("Animal Inserido com Sucesso!");
                        }
                    } else if (tipo.equals("antilope")) {
                        //Processo repetitivo ao de cima 
                        Mamifero ant = new Antilopes();
                        System.out.println("\nQual o nome do Antilope?");
                        nome = leitura.nextLine().toLowerCase();
                        System.out.println("\nQual a espécie do Antilope?");
                        especie = leitura.nextLine().toLowerCase();
                        System.out.println("\nQual o peso do Antilope?");
                        peso = leitura.nextDouble();
                        if (nome.equals("") || especie.equals("") || peso <= 0) {
                            System.out.println("Dados Inseridos Inválidos");
                            break;
                        } else {
                            ant.nome(nome);
                            ant.especie(especie);
                            ant.peso(peso);
                            mam.add(ant);
                        }
                    } else if (tipo.equals("primata")) {
                        Mamifero pri = new Primatas();
                        System.out.println("\nQual o nome do Primata?");
                        nome = leitura.nextLine().toLowerCase();
                        System.out.println("\nQual a espécie do Primata?");
                        especie = leitura.nextLine().toLowerCase();
                        System.out.println("\nQual o peso do Primata?");
                        peso = leitura.nextDouble();
                        pri.peso(leitura.nextDouble());
                        mam.add(pri);
                        if (nome.equals("") || especie.equals("") || peso <= 0) {
                            System.out.println("Dados Inseridos Inválidos");
                            break;
                        } else {
                            pri.nome(nome);
                            pri.especie(especie);
                            pri.peso(peso);
                            mam.add(pri);
                        }
                    } else {
                        /*Caso o tipo de mamífero não corresponder a nenhum dos presentes é 
                        automaticamente verificado não realizando qualquer operação
                         */
                        System.out.println("\nO tipo de mamífero inserido é inválido! \nTente Novamente!");
                    }
                    break;

                case 2:
                    leitura.nextLine();
                    System.out.println("Digite o nome do animal que quer eliminar: ");
                    String eli = leitura.nextLine().toLowerCase();
                    //Percorrer o HashSet
                    for (Mamifero valor : mam) {
                        //Verificação se no HashSet existe algum Mamífero com o nome introduzido pelo utilizador
                        if (eli.equals(valor.nome)) {
                            //caso exista esse Animal será eliminado do HashSet
                            mam.remove(valor);
                            remove = true;
                            System.out.println("O animal foi eliminado com sucesso");
                        }
                    }
                    if (remove == false) {
                        //Caso não exista qualquer animal com o nome introduzido
                        System.out.println("Não existe nenhum animal com o nome " + eli);
                    }
                    break;

                case 3:
                    //Verifica se a coleção está vazia
                    if (mam.isEmpty()) {
                        System.out.println("Não existem quaisquer Animais!");
                    } else {
                        //Caso não esteja conta quantos Mamíferos estão presentes na coleção
                        System.out.println("Há " + mam.size() + " animais");
                    }
                    break;

                case 4:
                    leitura.nextLine();
                    System.out.println("Digite o peso mínimo do animal que quer visualizar: ");
                    double eli_peso = leitura.nextDouble();
                    //Percorrer o HashSet
                    for (Mamifero valor : mam) {
                        //Verificação de todos os Mamíferos presentes se algum está acima do peso digitado
                        if (valor.peso >= eli_peso) {
                            existe = true;
                            valor.print();
                        }
                    }
                    //Caso não exista Mamíferos presentes acima do peso digitado
                    if (existe == false) {
                        System.out.println("Não existem espécies com o peso " + eli_peso);
                    }
                    break;

                case 5:
                    pesquisa = false;
                    leitura.nextLine();
                    System.out.println("Deseja pesquisar pelo nome (N) ou por espécie (E)?");
                    String pes = leitura.nextLine().toLowerCase();
                    if (pes.equals("n")) {
                        System.out.println("Digite o nome do animal pelo qual pretende pesquisar: ");
                        String pes_nome = leitura.nextLine().toLowerCase();
                        //Percorrer o HashSet
                        for (Mamifero valor : mam) {
                            /*Verificação de todos os Mamíferos presentes se algum tem presente 
                        como espécie o nome digitado*/
                            if (valor.nome.equals(pes_nome)) {
                                pesquisa = true;
                                valor.print();
                            }
                        }
                        //Caso não exista Mamíferos presentes com o nome da espécie digitado
                        if (pesquisa == false) {
                            System.out.println("Não existem espécies com o nome " + pes_nome);
                        }
                    } else if (pes.equals("e")) {
                        System.out.println("Digite o nome da espécie pelo qual pretende pesquisar: ");
                        String pes_esp = leitura.nextLine().toLowerCase();
                        //Percorrer o HashSet
                        for (Mamifero valor : mam) {
                            /*Verificação de todos os Mamíferos presentes se algum tem presente 
                        como espécie o nome digitado*/
                            if (valor.especie.equals(pes_esp)) {
                                pesquisa = true;
                                valor.print();
                            }
                        }
                        //Caso não exista Mamíferos presentes com o nome da espécie digitado
                        if (pesquisa == false) {
                            System.out.println("Não existem espécies com o nome " + pes_esp);
                        }
                    } else {
                        System.out.println("Nenhuma das opções disponíveis foi selecionada");
                    }
                    break;

                case 6:
                    if (mam.isEmpty()) {
                        System.out.println("Não há animais presentes nesta coleção");
                    } else {
                        for (Mamifero valor : mam) {
                            valor.print();
                        }
                    }
                    break;

                case 7:
                    mam2.addAll(mam);
                    leitura.nextLine();
                    System.out.println("Todos os animais da coleção anterior estão presentes na nova coleção");
                    System.out.println("\nPara libertar a primeira coleção pretende eliminar todos os animais existentes nela (S/N)?");
                    opcao = leitura.nextLine().toLowerCase();
                    /*Verifica se o utilizador quer remover os animais da coleção 
                    antiga uma vez que foram todos copiados para uma outra coleção*/
                    if (opcao.equals("s")) {
                        mam.removeAll(mam);
                        System.out.println("Todos os animais presentes foram eliminados com sucesso");
                    } else {
                        System.out.println("Opção guardada, os animais irão se manter presentes nesta coleção");
                    }
                    break;

                case 8:
                    if (mam2.isEmpty()) {
                        System.out.println("Coleção não utilizada de momento");
                    }
                    for (Mamifero valor : mam2) {
                        valor.print();
                    }
                break;

                case 9:
                    System.out.println("Programa terminado ©HugoQueiros");
            }

        } while (escolha < 10);
    }

}
