package csi;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * Controlador principal da aplicação.
 * 
 * @author Murilo Ito, Janaina Cheim, Alexandre Jimenez e Patrick Guedes.
 */
public class Controller {
    // Instancia Singleton
    // private static final Controller controller = new Controller();
    // Jogador atual
    // private Jogador jogador = null;
    //Caso atual que esta sendo resolvido
    // private Caso caso = null;
    //Local atual que esta sendo visitado
    // private Local local = null;
    //Lista de pistas para processas
    // private ArrayList<Pista> pistasProcessar = new ArrayList<Pista>();
    //Interface para entrar no jogo
    //private LoginGUI loginGUI = new LoginGUI();
    //Interface para exibir os casos
    // private CasosGUI casosGUI = new CasosGUI();
    //Interface para exibir os locais que pode visitar
    // private LocaisGUI locaisGUI = new LocaisGUI();
    // Interface para exibir o local e as pistas
    // private LocalGUI localGUI = new LocalGUI();
    // Interface do laboratorio para processas as pistas
    // private LaboratorioGUI labGUI = new LaboratorioGUI();

    /**
     * Construtor privado para aplicar o padrão singleton
     */
    private Controller() {
    }

    /**
     * Metodo para retornar a instancia Singleton.
     * 
     * @return  Instancia singleton
     */
    public void getController() {
        // return controller;
    }

    /**
     * Inicia o jogo executando a interface para entrar.
     */
    public void iniciaJogo() {
        // java.awt.EventQueue.invokeLater(new Runnable() {

            // public void run() {
                // loginGUI.setVisible(true);
            // }
        // });
    }

    /**
     * Recebe a solicitacao de novo jogador e carrega os casos.
     * 
     * @param nome Nome do jogador.
     */
    public void novoJogador(String nome) {
        // TODO: o que fazer quando ja houver um jogador ativo?
        // jogador = new Jogador();
        // jogador.setNome(nome);
        // System.out.println("Criado novo jogador: " + nome);

        // mostraCasos(loginGUI);
    }

    /**
     * Mostra os casos disponíveis para o jogador.
     * 
     * @param janela Janela anterior que deve ser escondida.
     * @return 
     */
    public void mostraCasos(javax.swing.JFrame janela) {
        // ArrayList<ArrayList<String>> casos;
        // ArrayList<Integer> casosConcluidos;
        // ArrayList<String> casosAbertos = new ArrayList<String>();
        // ArrayList<String> caso;
        // Iterator i;
        
        // if (janela != null) janela.setVisible(false);

        //atualiza info na tela
        // casosGUI.setEnergia(Integer.toString(jogador.getEnergia()));
        // casosGUI.setJogador("Jogador: " + jogador.getNome());
        // casosGUI.setXP(Integer.toString(jogador.getExperiencia()));

        //exibe a tela
        // casosGUI.setVisible(true);

        // if (jogador == null) {
            // System.out.println("Nao tem jogador para exibir os casos.");
           //return; essa condicao nao deve acontecer
        // }

        // casos = Caso.getTodosCasos();
        // casosConcluidos = jogador.getCasosConcluidos();

        // i = casos.iterator();

        //TODO: quando tiver a interface grafica, limpar e atualizar com os dados
        //abaixo dos casos
        // while (i.hasNext()) {
            // caso = (ArrayList<String>) i.next();

            //se eh um caso concluido pelo usuario
            // if (casosConcluidos.contains(Integer.parseInt(caso.get(0)))) {
                // System.out.println("Caso concluido ja: " + caso);

                //novo caso
            // } else {
                // System.out.println("Caso novo: " + caso);
                // casosAbertos.add("#" + caso.get(0) + " - " + caso.get(1));
            // }
        // }
        
        // casosGUI.setCasos(casosAbertos);
    }

    /**
     * Carrega um caso escolhido pelo usuario.
     * 
     * @param id Identificador do caso.
     * 
     * @return True se carregou com sucesso.
     */
    public boolean carregaCaso(int id) {

        // if (jogador == null) {
            // System.out.println("Nao tem jogador para carregar um caso.");
            // return false;
        // }

        // if (caso != null) {
            // System.out.println("Ja existe um caso ativo.");
            // return false;
        // }

        // caso = new Caso();

        // if (caso.carrega(id) == false) {
            // caso = null;
            // JOptionPane.showMessageDialog(null, "Caso nao carregado");
            // System.out.println("Caso NAO carregado: " + id);
            // return false;
        // }

        // System.out.println("Caso carregado: " + id + " - " + caso.getNome());

        // mostraLocais(casosGUI);

         return true;
    }

    /**
     * Mostra os casos na tela para o jogador poder escolher.
     * 
     * @param janela janela antiga que deve ser escondida se desejável.
     */
    public void mostraLocais(javax.swing.JFrame janela) {

        // ArrayList<Local> locais = caso.getLocais();
        // Iterator i = locais.iterator();
        // Local local;

        // while (i.hasNext()) {
            // local = (Local) i.next();

            // System.out.println("Exibindo local: " + local.getNome());
        // }
        
        // locaisGUI.setLocais(locais);

        // if (janela != null) janela.setVisible(false);

        //atualiza info na tela
        // locaisGUI.setEnergia(Integer.toString(jogador.getEnergia()));
        // locaisGUI.setJogador("Jogador: " + jogador.getNome());
        // locaisGUI.setXP(Integer.toString(jogador.getExperiencia()));
        // locaisGUI.setCaso(caso.getNome());
        // locaisGUI.setDescricao(caso.getDescricao());

        // locaisGUI.setVisible(true);
    }

    /**
     * Visita um local escolhido pelo usuario.
     * 
     * @param id Identificador do Local escolhido.
     */
    public void visitaLocal(int id) {

        // local = caso.getLocal(id);

        // if (local == null) {
            // System.out.println("Local NAO carregado: " + id);
            // return;
        // }

        //checa se o usuario tem energia suficiente
        // if (jogador.getEnergia() < local.getEnergiaNecessaria()) {
            // JOptionPane.showMessageDialog(locaisGUI, "Voce nao tem energia suficiente");
            // System.out.println("Falta energia para conseguir ir ao local, minimo: " + local.getEnergiaNecessaria());
            // local = null;
            // return;
        // }

        //remove energia
        // jogador.rmEnergia(local.getEnergiaNecessaria());

        // System.out.println("Local carregado: " + id + " - " + local.getNome());

        // ArrayList<Pista> pistas = local.getPistas();
        // ArrayList<Pista> pistasPendentes = new ArrayList<Pista>();
        // Iterator i = pistas.iterator();
        // Pista pista;

        // while (i.hasNext()) {
            // pista = (Pista) i.next();

            //a pista ja esta para processar ou ja foi processada
            // if (pistasProcessar.contains(pista) || pista.isProcessada()) {
                // continue;
            // }
            
            // pistasPendentes.add(pista);

            // System.out.println("Exibindo pista: " + pista.getNome());
        // }

        // locaisGUI.setVisible(false);

        // atualiza info na tela
        // localGUI.setEnergia(Integer.toString(jogador.getEnergia()));
        // localGUI.setJogador("Jogador: " + jogador.getNome());
        // localGUI.setXP(Integer.toString(jogador.getExperiencia()));
        // localGUI.setLocal(local.getNome());
        // localGUI.setPistas(pistasPendentes);

        //localGUI.setVisible(true);
    }

    /**
     * Jogador achou uma pista, ela será armazenada na lista para processamento
     * posterior no laboratorio.
     * 
     * @param id Identificador da pista achada.
     */
    void achouPista(int id) {
        // Pista pista = local.getPista(id);

        // if (pista == null) {
            // return;
        // }

        // if (pista.isProcessada()) {
            // return;
        // }

        // if (pistasProcessar.contains(pista)) {
            // JOptionPane.showMessageDialog(localGUI, "Essa pista ja foi encontrada: " + pista.getNome());
            // return;
        // }

        // pistasProcessar.add(pista);

        // System.out.println("Pista adicionada: " + pista.getNome());

        // JOptionPane.showMessageDialog(localGUI, "Pista encontrada: " + pista.getNome());
    }

    /**
     * Jogador esta visitando o laboratorio.
     * 
     * @param janela Janela que deverá ser escondida se desejado.
     */
    void visitaLaboratorio(javax.swing.JFrame janela) {
        // if (janela != null) janela.setVisible(false);
        
        // labGUI.setEnergia(Integer.toString(jogador.getEnergia()));
        // labGUI.setJogador("Jogador: " + jogador.getNome());
        // labGUI.setXP(Integer.toString(jogador.getExperiencia()));
        // labGUI.setVisible(true);
        
        // Iterator i = pistasProcessar.iterator();
        // Pista pista;
        // ArrayList<String> pistas = new ArrayList<String>();

        // while (i.hasNext()) {
            // pista = (Pista) i.next();
            // pistas.add(pista.getNome());
        // }

        // labGUI.setPistas(pistas);
    }

    /**
     * Metodo para processar as pistas, e caso nao tenha mais nenhuma pista 
     * sem processar no caso atual, o caso será considerado resolvido.
     */
    void processarPistas() {
        // Pista pista;
        // Iterator i = pistasProcessar.iterator();

        // while (i.hasNext()) {
            // pista = (Pista) i.next();
            // jogador.addExperiencia(pista.getExperiencia());
            // pista.setProcessada(true);
        // }

        // pistasProcessar.clear();

        // System.out.println("Experiencia atual: " + jogador.getExperiencia());
        
        // labGUI.setXP(Integer.toString(jogador.getExperiencia()));
        // labGUI.setPistas(new ArrayList<String>());
        
        // JOptionPane.showMessageDialog(labGUI, "Suas pistas foram processadas");
        
        //verifica se o caso acabou
        // if (casoEncerrado()) {
            // JOptionPane.showMessageDialog(labGUI, "PARABENS! O caso foi encerrado.");
            // jogador.addCasoEncerrado(caso.getId());
            // caso = null;
            // mostraCasos(labGUI);
        // }
    }
    
    /**
     * Jogador esta bebendo cafe para ganhar energia.
     */
    void beberCafe() {
        // jogador.addEnergia(50);
        // labGUI.setEnergia(Integer.toString(jogador.getEnergia()));
    }

    /**
     * Verifica se todas as pistas ja foram processadas do caso atual.
     * 
     * @return  True se todas pistas foram processadas.
     */
    boolean casoEncerrado() {

        // if (caso == null) {
            // return false;
        // }

        // Local local;
        // Pista pista;
        // Iterator iLocal = caso.getLocais().iterator();
        // Iterator iPista;

        // while (iLocal.hasNext()) {
            // local = (Local) iLocal.next();

            // iPista = local.getPistas().iterator();

            // while (iPista.hasNext()) {
                // pista = (Pista) iPista.next();

                //achou pista sem processar
                // if (pista.isProcessada() == false) {
                    // return false;
                // }
            // }
        // }

         return true;
    }
}
