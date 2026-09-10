import java.util.*;
import java.io.*;
import SubSistemaGestaoFuncionarios.*;
import SubSistemaGestaoTecnicos.*;
import SubSistemaGestaoGestores.*;

public class Main {
    public static void main(String[] args) {

        GesCentroReparacoesLNFacade facade = new GesCentroReparacoesLNFacade();

        System.out.println("Centro de Reparações\n\n");
        String[] sMenuPrincipal = {"Login Técnico", "Login Gestor", "Login Funcionário"};
        String[] sMenuTecnico = {"Realizar Reparação", "Suspender Reparação",
                "Concluir Reparação", "Analisar Equipamento",};
        String[] sMenuGestor = {"Adicionar Funcionário", "Adicionar Técnico", "Adicionar Gestor",
                "Listagem das Receções por Funcionário", "Listagem das Entregas por Funcionário", "" +
                "Listagem das Reparações por Técnico", "Listagem Exaustiva das Reparações por Técnico"};
        String[] sMenuFuncionario = {"Registar um Registo Normal", "Registar um Registo Expresso",
                "Confirmar Orçamentos", "Recusar Orçamento", "Verificação de Tempos", "Confirmação de Entregas"};
        int opMenuPrincipal;
        Menu menuPrincipal = new Menu(sMenuPrincipal);
        Menu menuTecnico = new Menu(sMenuTecnico);
        Menu menuGestor = new Menu(sMenuGestor);
        Menu menuFuncionario = new Menu(sMenuFuncionario);
        do {
            menuPrincipal.executa();
            opMenuPrincipal = menuPrincipal.getOpcao();
            switch (opMenuPrincipal) {
                case 1:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Login:");
                    String login1 = sc1.next();
                    System.out.println("Password");
                    String password1 = sc1.next();
                    if (facade.validaTecnico(login1, password1)) {
                        int opMenuTecnico;
                        do {
                            menuTecnico.executa();
                            opMenuTecnico = menuTecnico.getOpcao();
                            switch (opMenuTecnico) {
                                case 1:
                                    String r1_1 = facade.geraListaRegistosNormaisUrgencia().get(0).getIdEquipamento();
                                    System.out.println("Equipamento ->" + r1_1);
                                    break;
                                case 2:
                                    System.out.println("IDRegisto->");
                                    String r1_2 = sc1.next();
                                    facade.atualizaEstadoR(r1_2, "ReparacaoSuspensa");
                                    break;
                                case 3:
                                    System.out.println("IDRegisto->");
                                    String r1_3 = sc1.next();
                                    facade.registaConclusaoReparacao(r1_3, login1);
                                    break;
                                case 4:
                                    System.out.println("IDRegisto->");
                                    String r1_4 = sc1.next();
                                    System.out.println("Número de Passos->");
                                    int np1_4 = sc1.nextInt();
                                    int nsp1_4;
                                    List<SubPasso> lsp1_4 = new ArrayList<>();
                                    List<Passo> lp1_4 = new ArrayList<>();
                                    double c1_4, t1_4;
                                    for (int i = 0; i < np1_4; i++) {
                                        System.out.println("Numero de SubPassos->");
                                        nsp1_4 = sc1.nextInt();
                                        for (int j = 0; j < nsp1_4; j++) {
                                            System.out.println("Custo->");
                                            c1_4 = sc1.nextDouble();
                                            System.out.println("Tempo->");
                                            t1_4 = sc1.nextDouble();
                                            lsp1_4.add(facade.criaSubPasso(c1_4,t1_4));
                                        }
                                        lp1_4.add(facade.criaPasso(lsp1_4));
                                    }
                                    facade.associaOrcamento(facade.criaOrcamento(facade.criaPlanoDeTrabalhos(lp1_4)),r1_4);
                                    break;
                            }
                        } while (opMenuTecnico != 0);
                    }
                    break;
                case 2:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Login:");
                    String login2 = sc2.next();
                    System.out.println("Password");
                    String password2 = sc2.next();
                    if (facade.validaGestor(login2, password2)) {
                        int opMenuGestor;
                        do {
                            menuGestor.executa();
                            opMenuGestor = menuGestor.getOpcao();
                            switch (opMenuGestor) {
                                case 1:
                                    System.out.println("Novo Login->");
                                    String s2_1 = sc2.next();
                                    Long n2_1 = Long.parseLong(s2_1);
                                    System.out.println("Nova Password->");
                                    String p2_1 = sc2.next();
                                    facade.adicionaFuniconario(n2_1, p2_1);
                                    break;
                                case 2:
                                    System.out.println("Nova Password->");
                                    String p2_2 = sc2.next();
                                    facade.adicionaTecnico(p2_2);
                                    break;
                                case 3:
                                    System.out.println("Nova Password->");
                                    String p2_3 = sc2.next();
                                    facade.adicionaGestor(p2_3);
                                    break;
                                case 4:
                                    int m2_4 = sc2.nextInt();
                                    List<String> l2_4 = facade.showListGestorRececoes(m2_4);
                                    for (String s : l2_4)
                                        System.out.println(s);
                                    break;
                                case 5:
                                    int m2_5 = sc2.nextInt();
                                    List<String> l2_5 = facade.showListGestorEntregas(m2_5);
                                    for (String s : l2_5)
                                        System.out.println(s);
                                    break;
                                case 6:
                                    int m2_6 = sc2.nextInt();
                                    List<String> l2_6 = facade.showListGestorReparacoes(m2_6);
                                    for (String s : l2_6)
                                        System.out.println(s);
                                    break;
                                case 7:
                                    int m2_7 = sc2.nextInt();
                                    List<String> l2_7 = facade.showListGestorReparacoesExaustiva(m2_7);
                                    for (String s : l2_7)
                                        System.out.println(s);
                                    break;
                            }
                        } while (opMenuGestor != 0);
                    }
                    break;
                case 3:
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Login:");
                    long login3 = sc3.nextLong();
                    System.out.println("Password");
                    String password3 = sc3.next();
                    if (facade.validaFuncionario(login3, password3)) {
                        int opMenuFuncionario;
                        do {
                            menuFuncionario.executa();
                            opMenuFuncionario = menuFuncionario.getOpcao();
                            switch (opMenuFuncionario) {
                                case 1: System.out.println("Cliente->");
                                        long c3_1 = sc3.nextLong();
                                        System.out.println("Equipamento->");
                                        String e3_1 = sc3.next();
                                        RegistoNormal rn = facade.criaRegistoNormal(c3_1,login3,e3_1);
                                        facade.armazenaRegisto(rn);
                                        break;
                                case 2: if(facade.verificaPossibilidadeServicoExpresso()) {
                                            System.out.println("Cliente->");
                                            long cli3_2 = sc3.nextLong();
                                            System.out.println("Equipamento->");
                                            String e3_2 = sc3.next();
                                            System.out.println("Custo->");
                                            double custo3_2 = sc3.nextDouble();
                                            System.out.println("Tempo->");
                                            double t3_2 = sc3.nextDouble();
                                            RegistoExpresso re = facade.criaRegistoExpresso(cli3_2, login3, e3_2, custo3_2, t3_2);
                                            facade.armazenaRegisto(re);
                                        }
                                        else
                                            System.out.println("Sem Tecnicos Disponíveis");
                                        break;
                                case 3: System.out.println("Registo->");
                                        String r3_3 = sc3.next();
                                        facade.atualizaEstadoR(r3_3,"PendenteDeReparacao");
                                        break;
                                case 4: System.out.println("Registo->");
                                        String r3_4 = sc3.next();
                                        facade.atualizaEstadoR(r3_4,"Arquivado");
                                        break;
                                case 5: facade.verificaTempo();
                                        System.out.println("Verificado");
                                        break;
                                case 6: System.out.println("Registo->");
                                        String r3_6 = sc3.next();
                                        facade.registaEntrega(r3_6,login3);
                                        break;
                            }
                        } while (opMenuFuncionario != 0);
                    }
                    break;
            }
        }while(opMenuPrincipal != 0);
        facade.toFile();
    }
}
