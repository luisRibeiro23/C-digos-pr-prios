
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância de Ensalamento
        Ensalamento ensalamento = new Ensalamento();
        Random random = new Random();

        // Adicionando Salas
        ensalamento.addSala(new Sala(1, 101, 30, true));  // Sala acessível
        ensalamento.addSala(new Sala(1, 102, 25, false)); // Sala não acessível
        ensalamento.addSala(new Sala(2, 201, 40, true));  // Sala acessível
        ensalamento.addSala(new Sala(2, 202, 15, true));  // Sala acessível
        ensalamento.addSala(new Sala(3, 301, 20, false)); // Sala não acessível
        ensalamento.addSala(new Sala(3, 302, 10, true));  // Sala acessível

        // Adicionando 50 Turmas com dados aleatórios
        for (int i = 1; i <= 50; i++) {
            String nome = "Turma " + i;
            String professor = "Prof. " + (char) ('A' + random.nextInt(26)); // Professores aleatórios de A a Z
            int numAlunos = random.nextInt(35) + 1; // Número de alunos entre 1 e 35
            boolean acessivel = random.nextBoolean(); // Acessibilidade aleatória
            Turma turma = new Turma(nome, professor, numAlunos, acessivel);
            turma.addHorario(random.nextInt(28) + 1); // Adiciona um horário aleatório
            ensalamento.addTurma(turma);
        }

        // Alocando turmas
        ensalamento.alocarTodas();

        // Resultados
        int totalAlocadas = ensalamento.getTotalTurmasAlocadas();
        int totalNaoAlocadas = ensalamento.turmas.size() - totalAlocadas;
        int totalEspacoLivre = ensalamento.getTotalEspacoLivre();

        System.out.printf("Total de Turmas Alocadas: %d\n", totalAlocadas);
        System.out.printf("Total de Turmas Não Alocadas: %d\n", totalNaoAlocadas);
        System.out.printf("Espaços Livres: %d\n", totalEspacoLivre);

        // Exibindo as turmas que não foram alocadas
        System.out.println("\nTurmas Não Alocadas:");
        for (Turma turma : ensalamento.turmas) {
            if (ensalamento.getSala(turma) == null) { // Se a turma não tiver sala alocada
                System.out.println(turma.getDescricao());
            }
        }
        
        // Relatório de salas por turma
        System.out.printf("\n%s\n", ensalamento.relatorioSalasPorTurma());
    }
}
