import java.util.ArrayList;
import java.util.List;
public class EnsalamentoMain {
    public static void main(String[] args) {
        // Criação do objeto de Ensalamento
        Ensalamento ensalamento = new Ensalamento();
        
        // Criação de Salas
       
        Sala sala1 = new Sala(6, 101, 50, true);
        Sala sala2 = new Sala(6, 102, 100, true);
        Sala sala3 = new Sala(6, 203, 50, false);
        Sala sala4 = new Sala(6, 204, 100, false);
        
        // Adicionando salas ao ensalamento
        ensalamento.addSala(sala1);
        ensalamento.addSala(sala2);
        ensalamento.addSala(sala3);
        ensalamento.addSala(sala4);

        // Criação de Turmas
        Turma turma1 = new Turma("Técnicas de Programação", "Horácio Fernandes", 50, false);
        turma1.addHorario(4);  // terça 14hs
        turma1.addHorario(11); // quarta 14hs
        turma1.addHorario(25); // quinta 14hs
        
        Turma turma2 = new Turma("Laboratório de Programação C", "Edson Nascimento", 25, true);
        turma2.addHorario(1);  // segunda 8hs
        turma2.addHorario(15); // quarta 8hs
        turma2.addHorario(29); // sexta 8hs
        
        Turma turma3 = new Turma("Algoritmos e Estrutura de Dados I", "Edleno Silva", 60, false);
        turma3.addHorario(8);  // terça 8hs
        turma3.addHorario(16); // quarta 10hs
        turma3.addHorario(23); // quinta 12hs

        Turma turma4 = new Turma("Redes de Computadores", "Edjair Souza", 70, true);
        turma4.addHorario(2);  // segunda 10hs
        turma4.addHorario(9);  // terça 10hs

        // Adicionando turmas ao ensalamento
        ensalamento.addTurma(turma1);
        ensalamento.addTurma(turma2);
        ensalamento.addTurma(turma3);
        ensalamento.addTurma(turma4);
        
        // Teste de alocação de todas as turmas
        ensalamento.alocarTodas();

        // Relatórios
        System.out.println("Resumo do Ensalamento:");
        System.out.println(ensalamento.relatorioResumoEnsalamento());
        
        System.out.println("\nRelatório de Turmas por Sala:");
        System.out.println(ensalamento.relatorioTurmasPorSala());
        
        System.out.println("\nRelatório de Salas por Turma:");
        System.out.println(ensalamento.relatorioSalasPorTurma());
        
        // Testando métodos individuais de disponibilidade e alocação
        System.out.println("\nSala 101 disponível na terça 14hs? " + ensalamento.salaDisponivel(sala1, 4));
        System.out.println("Sala 102 disponível em horários [8hs, 10hs, 12hs]? " + ensalamento.salaDisponivel(sala2, new ArrayList<>(List.of(1, 2, 3))));
        
        // Alocando uma turma manualmente
        System.out.println("\nTentando alocar a turma de Redes de Computadores na Sala 102:");
        if (ensalamento.alocar(turma4, sala2)) {
            System.out.println("Turma de Redes de Computadores alocada na Sala 102.");
        } else {
            System.out.println("Falha ao alocar a turma de Redes de Computadores na Sala 102.");
        }
        
        // Relatório final após alocação manual
        System.out.println("\nRelatório final de Turmas por Sala:");
        System.out.println(ensalamento.relatorioTurmasPorSala());
    }
}
