package csi;

import java.util.ArrayList;

/**
 * Classe que representa uma Pista de um Local de um Caso.
 * 
 * @author Murilo Ito, Janaina Cheim, Alexandre Jimenez e Patrick Guedes.
 */
public class Pista {
    /// Nome do arquivo que é utlizado para os locais
    private static final String csvNome = "pistas.csv";
    /// Numero de colunas do registro CSV
    private static final int csvNColunas = 4;
    /// Identificador unico
    private int id;
    /// Nome da pista
    private String nome;
    /// Experiencia adquirida pelo jogador ao processar a pista
    private int experiencia;
    /// Tempo que leva para processar
    private int tempo;
    /// Flag se a Pista ja foi processada
    private boolean processada = false;
    
    /**
     * Carrega uma pista de acordo com o ID informado.
     * 
     * @param id Identificado da pista desejada.
     * @return True se foi carregada.
     */
    public boolean carrega(int id) {
        CSVData csv = new CSVData(csvNome, csvNColunas);
        ArrayList<String> registro = csv.getRegitro(0, Integer.toString(id));
        
        // nao achou o registro
        if (registro == null) return false;
        
        this.id = Integer.parseInt( registro.get(0) );
        this.nome = registro.get(1);
        this.experiencia = Integer.parseInt( registro.get(2) );
        this.tempo = Integer.parseInt( registro.get(3) );
        
        return true;
    }
    
    public String getNome() {
        return nome;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * @return the tempo
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * @return the processada
     */
    public boolean isProcessada() {
        return processada;
    }

    /**
     * @param processada the processada to set
     */
    public void setProcessada(boolean processada) {
        this.processada = processada;
    }
    
}
