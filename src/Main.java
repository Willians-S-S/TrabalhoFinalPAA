import countSort.*;
import shellSort.*;
import mergeSort.*;
import java.util.Random;;

public class Main {


    public static int[] melhorCaso(int Tamanho){
        int[] array = new int[Tamanho];

        for(int i = 0; i < Tamanho; i++){
            array[i] = i;
        }

        return array;
    }

    public static int[] piorCaso(int Tamanho){
        int[] array = new int[Tamanho];

        for(int i = Tamanho - 1; i >= 0; i--){
            array[i] = i;
        }

        return array;
    }
    
    public static int[] aleatorioCaso(int Tamanho){
        Random gerador = new Random();
        int[] array = new int[Tamanho];

        for (int i = 0; i < Tamanho; i++) {
            array[i] = gerador.nextInt(Tamanho);
        }
        return array;
    }


    public static void medirTempo(String metodoOrdenacao, int tamanhoVetor){

        // -----------------Pior----------------------
        int[] vetorpior;
        vetorpior = piorCaso(tamanhoVetor);

        double inicio = System.currentTimeMillis();

        if(metodoOrdenacao.equals("shell")){
            ShellSort.sort(vetorpior);
        }else if(metodoOrdenacao.equals("merge")){
            MergeSort.sort(vetorpior, 0, vetorpior.length - 1);
        }else{
            CountSort.sort(vetorpior);
        }

        double fim = System.currentTimeMillis();
        double tempoGastoPior = fim - inicio;
        
        // -----------------Melhor--------------------------

        int[] vetormelhor;
        vetormelhor = melhorCaso(tamanhoVetor);

        inicio = System.currentTimeMillis();

        if(metodoOrdenacao.equals("shell")){
            ShellSort.sort(vetormelhor);
        }else if(metodoOrdenacao.equals("merge")){
            MergeSort.sort(vetormelhor, 0, vetormelhor.length - 1);
        }else{
            CountSort.sort(vetormelhor);
        }

        fim = System.currentTimeMillis();
        double tempoGastoMelhor = fim - inicio;
        
        // -----------------Aleatorio-------------------------
        int[] vetoraleatorio;
        vetoraleatorio = melhorCaso(tamanhoVetor);

        inicio = System.currentTimeMillis();

        if(metodoOrdenacao.equals("shell")){
            ShellSort.sort(vetoraleatorio);
        }else if(metodoOrdenacao.equals("merge")){
            MergeSort.sort(vetoraleatorio, 0, vetoraleatorio.length - 1);
        }else{
            CountSort.sort(vetoraleatorio);
        }

        fim = System.currentTimeMillis();
        double tempoGastoAleatorio = fim - inicio;


        System.out.printf("Testes com %d mil\nMetodo %s\npior caso: %f\nmelhor caso: %f\naleatorio caso: %f\n\n\n", tamanhoVetor, metodoOrdenacao, tempoGastoPior, tempoGastoMelhor, tempoGastoAleatorio);
    }

    public static void main(String[] args) {
        // Shell
        medirTempo("shell", 50_000);
        medirTempo("shell", 100_000);
        medirTempo("shell", 500_000);
        
        // merge
        System.out.println("_________________________________________________________");
        medirTempo("merge", 50_000);
        medirTempo("merge", 100_000);
        medirTempo("merge", 500_000);
        
        // count
        System.out.println("_________________________________________________________");
        medirTempo("count", 50_000);
        medirTempo("count", 100_000);
        medirTempo("count", 500_000);
    }
}
