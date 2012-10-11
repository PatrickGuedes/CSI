package csi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que representa um Caso a ser resolvido pelo jogador.
 * 
 * @author Murilo Ito, Janaina Cheim, Alexandre Jimenez e Patrick Guedes.
 */
public class Caso {
    /// Nome do arquivo que é utlizado para os casos
    private static final String csvNome = "casos.csv";
    /// Numero de colunas do registro CSV
    private static final int csvNColunas = 4;
    /// Identificador unico
    private int id;
    /// Nome do caso
    private String nome;
    /// Descricao do caso
    private String descricao;
    /// Locais relacionados a esse caso onde podem ser recolhidas pistas
    private ArrayList<Local> locais = new ArrayList<Local>();
    
    /**
     * Retornar todos os casos existentes.
     * 
     * @return Lista dos casos.
     */
    public static ArrayList<ArrayList<String>> getTodosCasos() {
        CSVData csv = new CSVData(csvNome, csvNColunas);
        return csv.getTodosRegistros();
    }
    
    /**
     * Carrega um caso conforme o identificador informado.
     * 
     * @param id Identificador do caso.
     * @return True se o caso foi carregado.
     */
    public boolean carrega(int id) {
        CSVData csv = new CSVData(csvNome, csvNColunas);
        ArrayList<String> registro = csv.getRegitro(0, Integer.toString(id));
        Local local;
        
        // nao achou o registro
        if (registro == null) return false;
        
        this.id = Integer.parseInt( registro.get(0) );
        this.nome = registro.get(1);
        this.descricao = registro.get(2);
        
        String[] locaisTemp = registro.get(3).split("\\|");
        
        for (int i=0; i < locaisTemp.length; i++) {
            local = new Local();
            // carrega o Local do arquivo
            if (local.carrega(Integer.parseInt(locaisTemp[i]))) {
                this.locais.add(local);
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
    
    public String getDescricao() {
        return descricao;
    }
    
    public ArrayList<Local> getLocais() {
        return locais;
    }
    
    /**
     * Retorna um Local do caso conforme o ID informado.
     * 
     * @param id Identificador do local desejado.
     * @return Local ou null se nao achou.
     */
    public Local getLocal(int id) {
        Local local = null;
        Iterator i = locais.iterator();
        
        while (i.hasNext()) {
            local = (Local) i.next();
            if (local.getId() == id) {
                return local;
            } else {
                local = null;
            }
        }
        
        return local;
    }
    
    /**
     * Utilizado quando o caso é exibido no jList dos Casos.
     * 
     * @return Nome do caso.
     */
    @Override
    public String toString() {
        return nome;
    }
}
