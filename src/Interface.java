
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author larissa.pelenci
 */
public class Interface {
    private Diario diario;
    private Scanner reader;
    
    public Interface(){
        reader = new Scanner(System.in);
        reader.useDelimiter("\\n");
    }

    public void executa(){
        String opcao;
        inicializaDiario();
        boolean sair = false;
        while(sair == false){
            opcao = imprimeMenu();
             switch( opcao )
            {
                case "1":
                    cadastrarAluno();
                 break;
    
                case "2":
                     cadastrarExame();
                break;
    
                case "3":
                    ListaNotasAluno();
                break;
            
                case "4":
                    mostrarDiario();
                break;
                case "S":
                    sair = true;
                    break;
                default:
                    System.out.println("Essa opção não existe!");
                    break;
                }
        };
    }
    
    private void inicializaDiario() {
        System.out.println("Diário de Classe");
        System.out.println();
        System.out.print("Entre o nome da disciplina: ");
        String disciplina = reader.next(); 
        diario = new Diario(disciplina);
    }
    
    private String imprimeMenu(){
        boolean sair = false;
        System.out.println("1 - Cadastrar alunos");
        System.out.println("2 - Cadastrar Exame");
        System.out.println("3 - Lista de notas do aluno");
        System.out.println("4 - Mostrar diario");
        System.out.println("S - Sair");
        String opcao = reader.next();
        return opcao;
    }
    
   private void cadastrarAluno(){
       System.out.println("Cadastro Aluno");
       System.out.println("Digite o nome do aluno");
       String nome =  reader.next();
       System.out.println("Digite a matricula do aluno");
       int matricula =  reader.nextInt();       
       System.out.println("Digite a data de nescimento do aluno");
       String nascimento =  reader.next();
       diario.addAluno(new Aluno (nome, matricula, nascimento));
       System.out.println("Aluno cadastrado com sucesso");
       System.out.println();
       System.out.println();
   }  
   private void cadastrarExame(){
        Aluno alunoselecionado = new Aluno();
        System.out.println("Cadastro Exame");
        System.out.println("Escolha um aluno");
        listarAlunos();
        System.out.println("Digite a matricula do aluno");
        int matricula = reader.nextInt(); 
        for(Aluno aluno : diario.getListaAlunos().values()){
            if(matricula == aluno.getMatricula()){
                alunoselecionado = aluno;
                System.out.println("Encontrou aluno");
            } 
        }
        System.out.println("Digite a data do exame");
        String data =  reader.next();
        System.out.println("Digite a nota do aluno ");
        double nota =  reader.nextDouble();
        diario.addExame(new Exame (alunoselecionado , data, nota));
        System.out.println("Exame cadastrado com sucesso");
        System.out.println();
        System.out.println();
            
   } 
   
   private void ListaNotasAluno(){
        Aluno alunoselecionado = new Aluno();
        System.out.println("Lista Notas Aluno");
        System.out.println("Escolha um aluno");
        listarAlunos();
        System.out.println("Digite a matricula do aluno");
        int matricula = reader.nextInt();
        for (double nota : diario.getNotaAluno(matricula)) {
            System.out.print(nota + " ");
        }
        System.out.println();
        System.out.println();
   } 
      
   private void mostrarDiario(){
       double media = 0;
       int notas = 0; 
       System.out.println("Mostrar Diario");
        System.out.println("Disciplina: " + diario.getDisciplina());
        for (ArrayList<Exame> exames : diario.getDiario().values()) {
            System.out.print(exames.get(0).getAluno().getNome() + "\t");
            for(Exame exame : exames) {
                System.out.print(exame.getNota() + "\t");
                media = media + exame.getNota() ;
                notas = notas +1;
            }
            System.out.println("A media é: " + media/notas);
            System.out.println();
        }
   } 
   
   private void listarAlunos() {
        System.out.println("Alunos");
        
        for (Aluno aluno : diario.getListaAlunos().values()) {
            System.out.println(aluno.getMatricula() + " - " + aluno.getNome());
        }
    }
   
   
    
}
