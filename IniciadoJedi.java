/**
 * 
 */

/**
 * Classe IniciadoJedi - contém as informações de um Jedi
 * @author luish 
 * @version 
 */
public class IniciadoJedi {
	//nome do Jedi
    String nome;
    String especie;
    int anoNascimento;
    //Construtor padrão
    IniciadoJedi(){
    	this("","",0);
    }

    /**
     * Construtor da classe.
     * @param nome nome do Jedi
     * @param especie especie do Jedi
     * @param anoNascimento ano de nascimento
     */
    // Construtor sobrecarregado
    IniciadoJedi(String nome, String especie, int anoNascimento) {
        this.nome = nome;
        this.especie = especie;
        this.anoNascimento = anoNascimento;
    }
    String getDescricao() {
    	return String.format("%s (especie=%s, nascimento=%s)", nome,especie,getAnoNascimento());
    }
    String getAnoNascimento() {
        if (anoNascimento < 0) {
            return Math.abs(anoNascimento) + " ABY";  
        } else {
            return anoNascimento + " DBY"; 
        }
    }

}
