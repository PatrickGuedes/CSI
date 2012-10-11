package csi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que representa um Local relacionado a um Caso.
 * 
 * @author Murilo Ito, Janaina Cheim, Alexandre Jimenez e Patrick Guedes.
 */
class Local {
    /// Nome do arquivo que é utlizado para os locais
    private static final String csvNome = "locais.csv";
    /// Numero de colunas do registro CSV
    private static final int csvNColunas = 4;
    /// Identificador unico
    private int id;
    /// Nome do Local
    private String nome;
    // Energia necessaria para o jogador visitar o Local.
    private int energiaNecessaria;
    /// Lista de Pistas que esse local contém
    private ArrayList<Pista> pistas = new ArrayList<Pista>();
    
    /**
     * Carrega o Local da base de dados.
     * 
     * @param id Identificador do Local que deve ser carregado.
     * @return True se foi carregado
     */
    public boolean carrega(int id) {
        CSVData csv = new CSVData(csvNome, csvNColunas);
        ArrayList<String> registro = csv.getRegitro(0, Integer.toString(id));
        Pista pista;
        
        // nao achou o registro
        if (registro == null) return false;
        
        this.id = Integer.parseInt( registro.get(0) );
        this.nome = registro.get(1);
        this.energiaNecessaria = Integer.parseInt( registro.get(2) );
        
        String[] pistasTemp = registro.get(3).split("\\|");
        
        for (int i=0; i < pistasTemp.length; i++) {
            pista = new Pista();
            // carrega o Local do arquivo
            if (pista.carrega(Integer.parseInt(pistasTemp[i]))) {
                this.pistas.add(pista);
            }
        }
        
        return true;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getEnergiaNecessaria(){
        return energiaNecessaria;
    }
    
    public ArrayList<Pista> getPistas() {
        return pistas;
    }
    
    /**
     * Retorna uma Pista que pertence ao Local conforme ID.
     * 
     * @param id Identificador da Pista.
     * 
     * @return Pista ou null caso nao encontre.
     */
    public Pista getPista(int id) {
        Pista pista = null;
        
        Iterator i = pistas.iterator();
        
        while (i.hasNext()) {
            pista = (Pista) i.next();
            if (pista.getId() == id) {
                return pista;
            } else {
                pista = null;
            }
        }
        
        return null;
    }
    
    /**
     * Utilizado quando o local é exibido no jList do Caso.
     * 
     * @return Nome do local.
     */
    @Override
    public String toString() {
        return nome;
    }
        
    
}
