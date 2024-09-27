/**
 * Classe SessaoJediMain - Classe principal para testar a funcionalidade da sessão Jedi.
 * @author Luis Ribeiro
 * @version 1.0, 21-09-2024
 */
public class SessaoJediMain {
	//construtor para geração do JavaDoc
	public SessaoJediMain() {
        // Construtor padrão.
    }
    /**
     * Método principal que inicia a execução do programa.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Criando um treinador Jedi
        TreinadorJedi treinador = new TreinadorJedi("Grão-Mestre","Fae Coven");

        // Criando uma sessão Jedi
        SessaoJedi sessao = new SessaoJedi("Instruções de Uso da Força", treinador);

        // Criando Iniciados da classe IniciadoJedi
        IniciadoJedi iniciado1 = new IniciadoJedi("Katooni", "Tholothian", 23);
        IniciadoJedi iniciado2 = new IniciadoJedi("Byph", "Ithorian", 21);
        IniciadoJedi iniciado3 = new IniciadoJedi("Gungi", "Wookiee", 23);
        IniciadoJedi iniciado4 = new IniciadoJedi("Petro", "Human", 22);

        // Adicionando iniciados à lista
        sessao.addIniciado(iniciado1);
        sessao.addIniciado(iniciado2);
        sessao.addIniciado(iniciado3);
        sessao.addIniciado(iniciado4);
        // Teste de iniciado com mesmo nome
        sessao.addIniciado(iniciado1); // Não deve ser adicionado

        // Imprimindo a descrição da sessão
        System.out.println(sessao.getDescricao());

        // Imprimindo a média do ano de nascimento
        System.out.println("Média do ano de nascimento: " + sessao.getMediaAnoNascimento());
    }
}
