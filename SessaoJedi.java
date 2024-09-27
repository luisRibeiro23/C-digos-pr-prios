import java.util.ArrayList;
/**
 * 
 */

/**
 * Classe TreinadorJedi - Representa as inforções sobre um treinador Jedi
 * @author luis Ribeiro - &lt;luis.henrique@icomp.ufam.edu.br&gt;
 * @version 1.0, 21-09-2024
 */
public class SessaoJedi {
	String nome;
	TreinadorJedi treinador;
	ArrayList<IniciadoJedi> iniciados;
	//construtor padrão
	SessaoJedi(String nome,TreinadorJedi treinador) {
		this.nome = nome;
		this.treinador = treinador;
		this.iniciados = new ArrayList<>();
	}
	/**
	 * 
	 * @return Adiciona um Iniciado a lista caso deste não esteja presenta na lista.
	 */
	void addIniciado(IniciadoJedi iniciado) {
		for(int i=0;i<iniciados.size();i++) {
			if(iniciados.get(i).nome.equals(iniciado.nome)) {
				return;
			}
		}
		iniciados.add(iniciado);
	}
	/**
	 * 
	 * @return Verifica se há algum Iniciado com o nome e buscado e devolve suas informações
	 */
	IniciadoJedi getIniciado(String nome) {
		for (int i = 0;i <iniciados.size();i++) {
			if(iniciados.get(i).nome.equals(nome)) {
				return iniciados.get(i);
			}
		}
		return null;
	}
	/**
	 * 
	 * @return Devolve a média de idade de todos os Iniciados da lista.
	 */
	double getMediaAnoNascimento() {
		double som=0.0;
		int tam = iniciados.size();
		for (int i=0;i<tam;i++) {
			som += iniciados.get(i).anoNascimento;
		}
		return som/tam;
	}
	/**
	 * 
	 * @return Dá as descrições de todos Iniciados oriantados por aquele treinador.
	 */
	String getDescricao() {
		String res = String.format("--> SESSÃO %s (Treinador: %s)",nome, treinador.getDescricao());
		for (int i=0;i<iniciados.size();i++) {
			res = String.format("%s\n  - Iniciado %d: %s",res,i+1,iniciados.get(i).getDescricao());
		}
		return res;
	}
}
