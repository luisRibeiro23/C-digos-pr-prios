/**
 * 
 */

/**
 * Classe TreinadorJedi - Representa as inforções sobre um treinador Jedi
 * @author luis Ribeiro - &lt;luis.henrique@icomp.ufam.edu.br&gt;
 * @version 1.0, 21-09-2024
 */
public class TurmaEmSala {
    Turma turma;
    Sala sala;
    TurmaEmSala(){
        this(null,null);
    }
    TurmaEmSala(Turma turma, Sala sala){
        this.turma = turma;
        this.sala = sala;
    }
    
}
