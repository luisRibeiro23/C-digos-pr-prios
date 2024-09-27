import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe Ensalamento - Responsável por gerenciar a alocação de turmas em salas.
 * @author Luis Ribeiro
 * @version 1.0, 21-09-2024
 */
@SuppressWarnings("unused")
public class Ensalamento {
    // Listas que contêm as informações de turmas, salas e ensalamento
    ArrayList<Sala> salas;
    ArrayList<Turma> turmas;
    ArrayList<TurmaEmSala> ensalamento;

    // Construtor padrão
    Ensalamento(){
        this.salas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.ensalamento = new ArrayList<>();
    }

    void addSala(Sala sala){
        salas.add(sala);
    }

    void addTurma(Turma turma){
        turmas.add(turma);
    }

    Sala getSala(Turma turma){
        for(TurmaEmSala alocacao : ensalamento){
            if(alocacao.turma.equals(turma)){
                return alocacao.sala;
            }
        }
        return null;
    }

    boolean salaDisponivel(Sala sala, int horario) {
        if (horario < 1 || horario > 35) {
            System.out.println("Horário inválido: " + horario);
            return false;
        }

        // Verifica se a sala está ocupada no horário fornecido
        for (TurmaEmSala alocacao : ensalamento) {
            if (alocacao.sala.equals(sala)) {
                for (int h : alocacao.turma.horarios) {
                    if (h == horario) {
                        return false;  // Sala já ocupada no horário
                    }
                }
            }
        }
        return true;  // Sala disponível no horário
    }

    boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios){
        for(TurmaEmSala alocacao : ensalamento){
            if(alocacao.sala.equals(sala)){
                ArrayList<Integer> v = alocacao.turma.horarios;
                for(int i = 0; i < horarios.size(); i++){
                    if(v.contains(horarios.get(i))){  // Corrigido índice e lógica de comparação
                        return false;  // Sala ocupada em algum dos horários
                    }
                }
            }
        }
        return true;  // Sala disponível em todos os horários
    }

    boolean verifica(Turma turma, Sala sala){
        // Verifica acessibilidade, capacidade e disponibilidade de horários
        int i =0 ;
        if(turma.acessivel == sala.acessivel){
            i = 1;
        }
        else if(turma.acessivel == false && sala.acessivel==true){i=1;}
        return i == 1 
            && turma.numAlunos <= sala.capacidade 
            && salaDisponivel(sala, turma.horarios);
    }
    boolean veT(Turma turma){
        for(int i = 0; i<ensalamento.size(); i++){
            if(ensalamento.get(i).turma.equals(turma)){
                if(ensalamento.get(i).sala != null){
                    return false;
                }
            }
        }
        return true;
    }
    boolean alocar(Turma turma, Sala sala){
        if(!verifica(turma, sala)){
            return false;
        }
        TurmaEmSala novaTurma = new TurmaEmSala();
        novaTurma.sala = sala;
        novaTurma.turma = turma;
        ensalamento.add(novaTurma);
        return true;
    }

    void ord(ArrayList<Turma> turmas) {
        // Ordena turmas pela quantidade de alunos em ordem decrescente
        Collections.sort(turmas, (t1, t2) -> Integer.compare(t2.numAlunos, t1.numAlunos));
    }
    void orde(ArrayList<Sala> salas) {
        // Ordena a lista de salas em ordem crescente de capacidade
        Collections.sort(salas, new Comparator<Sala>() {
            @Override
            public int compare(Sala s1, Sala s2) {
                // Compara as salas pela capacidade de forma crescente
                return Integer.compare(s1.capacidade, s2.capacidade);
            }
        });
    }
    void realoca() {
        for(int i=0;i<ensalamento.size();i++){
            
        }
    }
    void alocarTodas() {
        // Ordena as turmas antes de alocar
        ArrayList<Turma> turmaCopia = new ArrayList<>(turmas);
        ord(turmaCopia);
        // Faz uma cópia da lista de salas e a ordena
        ArrayList<Sala> salasCopia = new ArrayList<>(salas);
        //orde(salasCopia); // colab com err? quanto maior o espaço mais na parte de cima fico
        for (int i = 0;i<turmaCopia.size();i++) {
            boolean alocada = false;
            for (int j = 0;j<salasCopia.size();j++) {
                if (verifica(turmaCopia.get(i), salasCopia.get(j)) && veT(turmaCopia.get(i))) {
                        alocar(turmaCopia.get(i), salasCopia.get(j));
                        alocada = true;
                }
            }
        }
    }
    int getTotalTurmasAlocadas(){
        int cont =0;
        int n =0;
        for(int i=0;i<ensalamento.size();i++){
            if(ensalamento.get(i).sala.equals(null)){
                n ++;
            }
            else{
                cont++;
            }
        }
        return cont;
    }
    int getTotalEspacoLivre(){
        int total = 0;
        for(TurmaEmSala alocacao : ensalamento){
            if(alocacao.sala!=null&&alocacao.turma!=null){
                total += alocacao.sala.capacidade - alocacao.turma.numAlunos;
            }
        }
        return total;
    }

    String relatorioResumoEnsalamento(){
        int totalSalas = salas.size();
        int totalTurmas = turmas.size();

        return String.format("Total de Salas: %d\nTotal de Turmas: %d\nTurmas Alocadas: %d\nEspaços Livres: %d",
                             totalSalas, totalTurmas, getTotalTurmasAlocadas(), getTotalEspacoLivre());
    }

    String relatorioTurmasPorSala() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append(relatorioResumoEnsalamento());

        for (Sala sala : salas) {
            relatorio.append(String.format("\n--- %s ---", sala.getDescricao()));

            boolean encontrouTurma = false;
            for (TurmaEmSala alocacao : ensalamento) {
                if (alocacao.sala.equals(sala)) {
                    relatorio.append(String.format("\n%s", alocacao.turma.getDescricao()));
                    encontrouTurma = true;
                }
            }
        }
        return relatorio.toString();
    }

    String relatorioSalasPorTurma() {
        // Inicia a string com o resumo do ensalamento
        String relatorio = "Total de Salas: " + salas.size() + "\n";
        relatorio += "Total de Turmas: " + turmas.size() + "\n";
        relatorio += "Turmas Alocadas: " + getTotalTurmasAlocadas() + "\n";
        relatorio += "Espaços Livres: " + getTotalEspacoLivre() + "\n\n";
    
        // Percorre as turmas e busca a sala correspondente
        for (Turma turma : turmas) {
            relatorio += turma.getDescricao() + "\n";
            Sala sala = getSala(turma);  // Busca a sala alocada para a turma
    
            if (sala != null) {
                relatorio += "Sala: " + sala.getDescricao() + "\n";
            } else {
                relatorio += "Sala: SEM SALA\n";
            }
            relatorio += "\n";  // Linha em branco entre as descrições das turmas
        }
    
        return relatorio;
    }
    
    
}
