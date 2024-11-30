import javax.swing.*;
import java.awt.*;

// Clase que representa la carta gráfica de Bingo del jugador
public class CartaBingo extends JPanel {
    private CartonBingo cartonBingo; // Objeto que maneja la lógica del cartón
    private JButton[][] botones;    // Botones para la representación gráfica

    // Constructor que inicializa la carta con su lógica y visualización
    public CartaBingo() {
        this.cartonBingo = new CartonBingo75(); // Crear un nuevo cartón lógico
        this.botones = new JButton[5][5];      // Matriz de botones para la interfaz
        inicializarInterfaz();                // Configurar la vista gráfica
    }

    // Método para configurar los botones en la carta
    private void inicializarInterfaz() {
        setLayout(new GridLayout(5, 5)); // Configuración de cuadrícula 5x5

        // Obtener los números generados en el cartón
        int[][] numeros = cartonBingo.getNumeros();
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                // Convertir números en texto y marcar la casilla central como "FREE"
                String texto = (numeros[fila][columna] == 0) ? "FREE" : String.valueOf(numeros[fila][columna]);
                JButton boton = new JButton(texto); // Crear botón
                boton.setEnabled(false);           // Desactivar interacción
                boton.setBackground(Color.LIGHT_GRAY); // Color inicial
                botones[fila][columna] = boton;    // Guardar botón en la matriz
                add(boton);                        // Añadir botón al panel
            }
        }
    }

    // Método para actualizar los colores del cartón gráfico basado en los números marcados
    public void actualizarCarton() {
        boolean[][] marcados = cartonBingo.getMarcados(); // Obtener el estado de marcación
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                // Cambiar color a amarillo si está marcado, gris claro si no
                botones[fila][columna].setBackground(marcados[fila][columna] ? Color.YELLOW : Color.LIGHT_GRAY);
            }
        }
        revalidate(); // Actualizar el diseño
        repaint();    // Redibujar el panel
    }

    // Método para marcar un número y actualizar la vista
    public void marcarNumero(int numero) {
        cartonBingo.marcarNumero(numero); // Marcar el número en la lógica del cartón
        actualizarCarton();               // Reflejar los cambios en la vista gráfica
    }

    // Método para obtener el objeto lógico del cartón
    public CartonBingo getCartonBingo() {
        return cartonBingo;
    }

    // Método para mostrar el cartón como un panel (para integración con otras ventanas)
    public JPanel mostrarCarta() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5)); // Crear una cuadrícula 5x5

        // Obtener los números y el estado de marcación
        int[][] numeros = cartonBingo.getNumeros();
        boolean[][] marcados = cartonBingo.getMarcados();

        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                // Crear un botón para cada celda
                String texto = (numeros[fila][columna] == 0) ? "FREE" : String.valueOf(numeros[fila][columna]);
                JButton boton = new JButton(texto);
                boton.setEnabled(false); // No interactivo
                boton.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente más visible
                boton.setBackground(marcados[fila][columna] ? Color.YELLOW : Color.LIGHT_GRAY);
                botones[fila][columna] = boton; // Guardar el botón
                panel.add(boton);               // Añadir al panel
            }
        }

        return panel;
    }

    // Método para verificar si el cartón cumple con un patrón de victoria
    public boolean verificarVictoria(int[][] patron) {
        return cartonBingo.verificarVictoria(patron);
    }
}
