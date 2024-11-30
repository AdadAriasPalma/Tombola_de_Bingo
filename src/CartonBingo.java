
// Clase abstracta que define la estructura lógica de un cartón de Bingo
public abstract class CartonBingo {
    protected int[][] numeros;       // Matriz de números en el cartón
    protected boolean[][] marcados; // Matriz booleana para indicar números marcados

    // Constructor que inicializa las matrices y genera el cartón
    public CartonBingo() {
        numeros = new int[5][5];   // Inicializar la matriz de números
        marcados = new boolean[5][5]; // Inicializar la matriz de marcación
        generarCarton();           // Método abstracto implementado en subclases
    }

    // Método abstracto para generar los números del cartón (implementación en subclases)
    protected abstract void generarCarton();

    // Marca un número en el cartón si existe
    public void marcarNumero(int numero) {
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                if (numeros[fila][columna] == numero) {
                    marcados[fila][columna] = true; // Marcar como seleccionado
                    return; // Salir del bucle después de marcar
                }
            }
        }
    }

    // Verifica si el cartón cumple con un patrón de victoria
    public boolean verificarVictoria(int[][] patron) {
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                // Si el patrón requiere una celda marcada pero no lo está, no hay victoria
                if (patron[fila][columna] == 1 && !marcados[fila][columna]) {
                    return false;
                }
            }
        }
        return true; // Todas las celdas requeridas por el patrón están marcadas
    }

    // Devuelve la matriz de números del cartón
    public int[][] getNumeros() {
        return numeros;
    }

    // Devuelve la matriz booleana de marcaciones del cartón
    public boolean[][] getMarcados() {
        return marcados;
    }
}
