/**
 * @author larissa.pelenci
 */
public class Exame {
    private Aluno aluno;
    private String data;
    private double nota;

    public Exame(Aluno aluno, String data, double nota){
        this.aluno=aluno;
        this.data=data;
        this.nota=nota;
    }
 
    public Aluno getAluno() {
        return aluno;
    }

    public String getData() {
        return data;
    }
    
    public double getNota() {
        return nota;
    }
    
    
}
