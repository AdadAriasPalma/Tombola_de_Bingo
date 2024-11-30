import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La clase Tombola representa la tómbola de bingo, encargada de administrar
 * las bolas numeradas del 1 al 75, asegurando que cada bola salga una sola vez
 * en orden aleatorio.
 */
public class Tombola {
    private List<Integer> bolas; // Lista que contiene todas las bolas del 1 al 75
    private int indiceActual;    // Índice que rastrea la próxima bola a extraer

    /**
     * Constructor de la clase Tombola.
     * Inicializa las bolas del 1 al 75 en orden aleatorio.
     */
    public Tombola() {
        bolas = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            bolas.add(i); // Añade las bolas numeradas del 1 al 75
        }
        Collections.shuffle(bolas); // Mezcla aleatoriamente las bolas
        indiceActual = 0;           // Inicializa el índice de extracción en 0
    }

    /**
     * Extrae la próxima bola de la tómbola.
     *
     * @return El número de la bola extraída, o -1 si no quedan bolas.
     */
    public int sacarBola() {
        if (quedanBolas()) {
            return bolas.get(indiceActual++); // Devuelve la bola actual y avanza el índice
        }
        return -1; // Si no quedan bolas, retorna -1
    }

    /**
     * Verifica si quedan bolas por extraer en la tómbola.
     *
     * @return true si quedan bolas, false en caso contrario.
     */
    public boolean quedanBolas() {
        return indiceActual < bolas.size(); // Compara el índice actual con el tamaño de la lista
    }
}
