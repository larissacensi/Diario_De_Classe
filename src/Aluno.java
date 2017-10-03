/**
 * @author larissa.pelenci
 */

public class Aluno {
   private String nome;
   private int matricula;
   private String nascimento;

    
   public Aluno(){
       
       
   }
    public Aluno(String nome, int matricula, String nascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.nascimento = nascimento;
    }



    public String getNome() {
        return nome;
    }


    public int getMatricula() {
        return matricula;
    }


    public String getNascimento() {
        return nascimento;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", matricula=" + matricula + ", nascimento=" + nascimento + '}';
    }

    
    
   
}
