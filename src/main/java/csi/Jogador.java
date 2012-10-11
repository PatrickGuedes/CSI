package csi;

import java.util.ArrayList;

/**
 * Classe que representa o jogador/investigador.
 * 
 * Nessa classe será controlado todas informações referentes ao jogador, como
 * dados pessoais, experiência, casos resolvidos, etc.
 * 
 * @author Murilo Ito, Janaina Cheim, Alexandre Jimenez e Patrick Guedes.
 */
public class Jogador {
    /// Nome do arquivo que é utlizado para os jogadores
    private static final String csvNome = "jogadores.csv";
    /// Numero de colunas do registro CSV
    private static final int csvNColunas = 2;
    /// Controle se é um novo cadastro
    private boolean novoRegistro;
    /// Identificador único do Jogador
    private int id;
    /// Nome do Jogador
    private String nome;
    /// Energia disponível do Jogador
    private int energia;
    /// Experiencia atual
    private int experiencia;
    /// Lista de IDs dos casos que o Jogador já resolveu
    private ArrayList<Integer> casosConcluidos;

    public Jogador() {
        // inicializa com valores básicos para jogador novo
        this.energia = 100;
        this.experiencia = 0;
        this.casosConcluidos = new ArrayList<Integer>();
        this.novoRegistro = true;
    }

    /**
     * Carrega um usuario que já existe. Funcionalidade nao utilizada por enquanto.
     * 
     * @param id Identificador do usuario.
     * @return True se carrgou corretamente.
     */
    public boolean carrega(String id) {
        CSVData csv = new CSVData(csvNome, csvNColunas);
        ArrayList<String> registro = csv.getRegitro(0, id);
        
        // nao achou o registro
        if (registro == null) return false;
        
        // TODO: carrega os dados do registro
        
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {        
        this.nome = nome;
    }

    /**
     * @return the energia
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * @return the experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * @return the casosConcluidos
     */
    public ArrayList<Integer> getCasosConcluidos() {
        return casosConcluidos;
    }

    /**
     * Jogador ganhou energia, nao podendo ultrapassar o limite.
     * 
     * @param energia que ganhou
     */
    public void addEnergia(int energia) {
        // nao pode ser negativo
        if (energia <= 0) return;
        
        this.energia += energia;
        
        if (this.energia > 100) {
            this.energia = 100;
        }
    }

    /**
     * Remove energia do Jogador, não podendo ficar negativa.
     * 
     * @param energia a ser removida.
     */
    public void rmEnergia(int energia) {
        // nao pode ser negativo
        if (energia <= 0) return;
        
        this.energia -= energia;
        
        if (this.energia < 0) {
            this.energia = 0;
        }
    }

    /**
     * Experiencia que o Jogador ganhou.
     * @param experiencia the experiencia to set
     */
    public void addExperiencia(int experiencia) {
        // nao pode perder experiencia
        if (experiencia <= 0) return;
        
        this.experiencia += experiencia;
    }
    
    /**
     * Jogador encerrou um caso, adicionar a lista.
     * 
     * @param id Identificador do caso resolvido.
     */
    public void addCasoEncerrado(int id) {
        casosConcluidos.add(id);
    }
}
