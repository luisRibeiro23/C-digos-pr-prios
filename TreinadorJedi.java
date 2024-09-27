/**
 * 
 */

/**
 * Classe TreinadorJedi - Representa as inforções sobre um treinador Jedi
 * @author luis Ribeiro - &lt;luis.henrique@icomp.ufam.edu.br&gt;
 * @version 1.0, 21-09-2024
 */
public class TreinadorJedi {
	// Informações Treinado Jedi
	String titulacao;
	String nome;
	/**
	 * 
	 */
	// Construtor padrão
	TreinadorJedi() {
		this("","");
	}
	TreinadorJedi(String titulacao,String nome){
		this.titulacao = titulacao;
		this.nome = nome;
	}
	/**
	 * 
	 * @return devolve uma descrição sobre o treinador Jedi
	 */
	String getDescricao() {
		return String.format("%s %s",titulacao,nome);
	}

}
