package shellSort;
    // Classe para ordenar um array usando o shell sort
public class ShellSort {

  // Método para ordenar um array usando o shell sort
  public static void sort(int[] array) {
    // Determinar o intervalo inicial
    int intervalo = array.length / 2;
    // Repetir até que o intervalo seja zero
    while (intervalo > 0) {
      // Percorrer o array com o intervalo
      for (int i = intervalo; i < array.length; i++) {
        // Armazenar o elemento atual
        int temp = array[i];
        // Encontrar a posição correta para inserir o elemento
        int j = i;
        // Comparar o elemento com os elementos anteriores no intervalo
        while (j >= intervalo && array[j - intervalo] > temp) {
          // Trocar os elementos
          array[j] = array[j - intervalo];
          // Decrementar o índice
          j -= intervalo;
        }
        // Inserir o elemento na posição correta
        array[j] = temp;
      }
      // Reduzir o intervalo pela metade
      intervalo /= 2;
    }
  }
}
