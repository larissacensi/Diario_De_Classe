
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author larissa.pelenci
 */


public class Diario {
    private String disciplina;
    private HashMap <Integer, Aluno> alunos;
    private HashMap <Integer, ArrayList <Exame>> exames;
    private Exame notaex;
    
    public Diario(String disciplina){
        this.exames = new HashMap <>();
        this.alunos = new HashMap<>();
        this.disciplina=disciplina;
    }
    
    public void addAluno(Aluno aluno){
        alunos.put(aluno.getMatricula(), aluno); 
    }
    
    public void addExame(Exame exame){
       int matricula = exame.getAluno().getMatricula();
       if (!exames.containsKey(matricula)){
           exames.put(matricula, new ArrayList<>()); 
       } 
       exames.get(matricula).add(exame);
    }
    
    public ArrayList<Double> getNotaAluno(int matricula){
        ArrayList <Double> notas = new ArrayList<>();
        
        for(Exame exame : exames.get(matricula)){
            notas.add(exame.getNota());
        }
        
        return notas;
    }
    
    public HashMap<Integer, ArrayList<Exame>> getDiario(){
        return exames;
    }
    
    public String getDisciplina(){
        return disciplina;
    }
    
    public HashMap<Integer, Aluno> getListaAlunos(){    
        return alunos;
    }


    
    
}
