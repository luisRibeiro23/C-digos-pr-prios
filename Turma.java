import java.util.ArrayList;
/**
 * Classe SessaoJediMain - Classe principal para testar a funcionalidade da sessão Jedi.
 * @author Luis Ribeiro
 * @version 1.0, 21-09-2024
 */
public class Turma {
    //define os atributos de uma Turma
    String nome;
    String professor;
    int numAlunos;
    boolean acessivel;
    ArrayList<Integer> horarios;
    //Construtor padrão
    Turma(){
        this("0","",0,false);
    }
    Turma(String nome,String professor,int numAlunos,boolean acessivel){
        this.nome = nome;
        this.professor = professor;
        this.numAlunos = numAlunos;
        this.acessivel = acessivel;
        this.horarios = new ArrayList<>();
    }
    //Adiciona um novo horário para turma
    void addHorario(int horario){
        horarios.add(horario);
    }
    /**
	 * 
	 * @return devolve uma String contendo os horarios da turma
	 */

     
    String getHorariosString(){
        String pal = "";
        int i;
        String horas[] = {"20","8","10","12","14","16","18"};
        for(i=0;i<horarios.size();i++){
            if(i>0){
                pal = String.format("%s, ", pal);
            }
            if(horarios.get(i)<=7 && horarios.get(i)>=1){
                pal = String.format("%ssegunda %shs",pal,horas[horarios.get(i)%7]);
            }
            else if(horarios.get(i)<=14&& horarios.get(i)>=8){
                pal =String.format("%sterça %shs",pal,horas[horarios.get(i)%7]);
            }
            else if(horarios.get(i)<=21&& horarios.get(i)>=15){
                pal = String.format("%squarta %shs",pal,horas[horarios.get(i)%7]);
            }
            else if (horarios.get(i)<=28&& horarios.get(i)>=22) {
                pal = String.format("%squinta %shs",pal, horas[horarios.get(i)%7]);
            }
            else{
                pal = String.format("%ssexta %shs",pal,horas[horarios.get(i)%7]);
            }
        }
        
        return pal;
    }
    
    /**
	 * 
	 * @return devolve uma descrição sobre a turma
	 */
    String getDescricao(){
        if(acessivel == true) {
			return String.format("Turma: %s\nProfessor: %s\nNúmero de Alunos: %d\nHorário: %s\nAcessível: sim",nome,professor,numAlunos,getHorariosString());
		}
		else {
			return String.format("Turma: %s\nProfessor: %s\nNúmero de Alunos: %d\nHorário: %s\nAcessível: não",nome,professor,numAlunos,getHorariosString());
		}
    }
}
