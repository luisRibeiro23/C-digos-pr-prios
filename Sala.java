/**
 * 
 */

/**
 * Classe TreinadorJedi - Representa as inforções sobre um treinador Jedi
 * @author luis Ribeiro - &lt;luis.henrique@icomp.ufam.edu.br&gt;
 * @version 1.0, 21-09-2024
 */
public class Sala {
	//define os atributos de uma sala
	int bloco;
	int sala;
	int capacidade;
	boolean acessivel;
	//construtor padrão
	Sala(){
		this(0,0,0,false);//acessivel é false por padrão
	}
	//construtor padrão
	Sala(int bloco,int sala,int capacidade,boolean acessivel){
		this.bloco = bloco;
		this.sala = sala;
		this.capacidade = capacidade;
		this.acessivel = acessivel;
	}
	/**
	 * 
	 * @return Devolve a descrição de uma sala e verifica se ela é acessível ou não
	 */
	String getDescricao() {
		if(acessivel == true) {
			return String.format("Bloco %d, Sala %d (%d lugares, acessível)", bloco,sala,capacidade);
		}
		else {
			return String.format("Bloco %d, Sala %d (%d lugares, não acessível)", bloco,sala,capacidade);
		}
		
	}
}
