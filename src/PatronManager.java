import java.util.ArrayList;
import java.util.List;

// Clase para gestionar los patrones de victoria en el Bingo
public class PatronManager {
    private final List<int[][]> patrones; // Lista que almacena los patrones de victoria
    private int indicePatronSeleccionado = -1; // Índice del patrón actualmente seleccionado (-1 indica ninguno)

    // Constructor: inicializa la lista de patrones y carga los patrones predefinidos
    public PatronManager() {
        patrones = new ArrayList<>();
        cargarPatrones(); // Llama al método para cargar los patrones
    }


    private void cargarPatrones() {
        // 1. Vertical en la primera columna
        patrones.add(new int[][]{
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0}
        });

// 2. Vertical en la segunda columna
        patrones.add(new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0}
        });

// 3. Vertical en la tercera columna
        patrones.add(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}
        });

// 4. Vertical en la cuarta columna
        patrones.add(new int[][]{
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0}
        });

// 5. Vertical en la quinta columna
        patrones.add(new int[][]{
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}
        });

// 6. Diagonal de izquierda a derecha
        patrones.add(new int[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        });

// 7. Horizontal en la primera fila
        patrones.add(new int[][]{
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 8. Horizontal en la segunda fila
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 9. Horizontal en la tercera fila
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 10. Horizontal en la cuarta fila
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        });

// 11. Horizontal en la quinta fila
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        });

// 12. Diagonal de derecha a izquierda
        patrones.add(new int[][]{
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0}
        });

// 13. 6-Pack en la esquina superior izquierda
        patrones.add(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 14. 6-Pack en la parte media izquierda
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 15. 6-Pack en la parte inferior izquierda
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0}
        });

// 16. 6-Pack en la parte superior central
        patrones.add(new int[][]{
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 17. 6-Pack en la parte media central
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 18. 6-Pack en la parte inferior central
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0}
        });

// 19. 6-Pack en la parte superior derecha
        patrones.add(new int[][]{
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 20. 6-Pack en la parte media derecha
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
        });

// 21. 6-Pack en la parte inferior derecha
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0}
        });

// 22. 6-Pack en la parte superior de la última columna
        patrones.add(new int[][]{
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 23. 6-Pack en la parte media de la última columna
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0}
        });

// 24. 6-Pack en la parte inferior de la última columna
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        });

// 25. Rectángulo 2x3 en la esquina superior izquierda
        patrones.add(new int[][]{
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 26. Rectángulo 2x3 en la parte superior central
        patrones.add(new int[][]{
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 27. Rectángulo 2x3 en la esquina superior derecha
        patrones.add(new int[][]{
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 28. Rectángulo 2x3 en la parte media izquierda
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 29. Rectángulo 2x3 en la parte media central
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 30. Rectángulo 2x3 en la parte media derecha
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 31. Rectángulo 2x3 en la esquina inferior izquierda
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        });

// 32. Rectángulo 2x3 en la parte inferior central
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        });

// 33. Rectángulo 2x3 en la esquina inferior derecha
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0}
        });

// 34. Rectángulo 2x3 en la parte superior de la última columna
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0}
        });

// 35. Rectángulo 2x3 en la parte media de la última columna
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0}
        });

// 36. Rectángulo 2x3 en la parte inferior de la última columna
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1}
        });

// 37. Patrón de diamante
        patrones.add(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0}
        });

// 38. Patrón de cuadro pequeño
        patrones.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        });

    }

    // **Método agregado**: Devuelve todos los patrones disponibles
    public List<int[][]> getPatrones() {
        return patrones; // Retorna la lista completa de patrones
    }

    // Obtiene el patrón seleccionado actualmente
    public int[][] getPatronSeleccionado() {
        if (indicePatronSeleccionado >= 0 && indicePatronSeleccionado < patrones.size()) {
            return patrones.get(indicePatronSeleccionado); // Retorna el patrón seleccionado
        }
        return null; // Retorna null si no hay patrón seleccionado
    }

    // Establece el índice del patrón seleccionado
    public void setPatronSeleccionado(int indice) {
        if (indice >= 0 && indice < patrones.size()) {
            indicePatronSeleccionado = indice;
        }
    }

    // Genera y retorna los nombres de los patrones
    public String[] getNombresPatrones() {
        String[] nombres = new String[patrones.size()];
        for (int i = 0; i < patrones.size(); i++) {
            nombres[i] = "Patrón " + (i + 1);
        }
        return nombres;
    }

    // Retorna el índice del patrón seleccionado
    public int getIndicePatronSeleccionado() {
        return indicePatronSeleccionado; // Retorna el índice seleccionado o -1 si no hay selección
    }
}