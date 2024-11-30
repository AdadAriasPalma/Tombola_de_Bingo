import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase para representar un cartón de Bingo con 75 bolas
public class CartonBingo75 extends CartonBingo {

    @Override
    protected void generarCarton() {
        // Generar los números por columna según rangos específicos del bingo de 75 bolas
        List<Integer> columnaB = generarNumeros(1, 15);   // Columna B: Números del 1 al 15
        List<Integer> columnaI = generarNumeros(16, 30);  // Columna I: Números del 16 al 30
        List<Integer> columnaN = generarNumeros(31, 45);  // Columna N: Números del 31 al 45
        List<Integer> columnaG = generarNumeros(46, 60);  // Columna G: Números del 46 al 60
        List<Integer> columnaO = generarNumeros(61, 75);  // Columna O: Números del 61 al 75

        // Asignar números generados a las posiciones del cartón
        for (int fila = 0; fila < 5; fila++) {
            numeros[fila][0] = columnaB.get(fila); // Números para la columna B
            numeros[fila][1] = columnaI.get(fila); // Números para la columna I
            if (fila != 2) { // Casilla central se maneja de manera especial
                numeros[fila][2] = columnaN.get(fila); // Números para la columna N
            } else {
                numeros[fila][2] = 0; // Casilla central es "FREE"
                marcados[fila][2] = true; // Marcar automáticamente la casilla central
            }
            numeros[fila][3] = columnaG.get(fila); // Números para la columna G
            numeros[fila][4] = columnaO.get(fila); // Números para la columna O
        }
    }

    // Método auxiliar para generar una lista de números aleatorios en un rango específico
    private List<Integer> generarNumeros(int inicio, int fin) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = inicio; i <= fin; i++) {
            numeros.add(i); // Añadir cada número al rango
        }
        Collections.shuffle(numeros); // Mezclar los números
        return numeros.subList(0, 5); // Tomar los primeros 5 números aleatorios
    }
}
