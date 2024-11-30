import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaHistorial extends JFrame {
    private List<Integer> bolasExtraidas;  // Lista para almacenar las bolas extraídas
    private JPanel panelHistorial;        // Panel principal para los números
    private final int NUMERO_MAX = 75;    // Número máximo de bolas posibles (1 a 75)

    public VentanaHistorial() {
        bolasExtraidas = new ArrayList<>();
        setTitle("Historial de Bingo");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        // Crear el panel principal con GridLayout para filas compactas
        panelHistorial = new JPanel();
        panelHistorial.setLayout(new GridLayout(5, 1, 0, 0));  // 5 filas sin espacio entre ellas
        panelHistorial.setBackground(Color.WHITE);

        // Crear las filas para "B", "I", "N", "G", "O"
        String[] letras = {"B", "I", "N", "G", "O"};
        Color[] colores = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.PINK};
        int inicio = 1;
        int fin = 15;

        for (int i = 0; i < letras.length; i++) {
            JPanel fila = new JPanel();
            fila.setLayout(new GridLayout(1, 16, 0, 0));  // Sin espacio entre columnas
            fila.setBackground(Color.WHITE);

            // Crear un cuadro para la letra correspondiente (B, I, N, G, O)
            JPanel cuadroLetra = new JPanel();
            cuadroLetra.setBackground(colores[i]);
            cuadroLetra.setPreferredSize(new Dimension(50, 50));  // Tamaño del cuadro de la letra
            cuadroLetra.setLayout(new BorderLayout());
            cuadroLetra.setBorder(BorderFactory.createLineBorder(Color.BLACK));  // Agregar borde negro

            JLabel letra = new JLabel(letras[i], SwingConstants.CENTER);
            letra.setFont(new Font("Arial", Font.BOLD, 20));
            letra.setForeground(Color.WHITE);  // Texto blanco para destacar sobre los colores
            cuadroLetra.add(letra, BorderLayout.CENTER);
            fila.add(cuadroLetra);

            // Agregar los números correspondientes al rango de la letra
            for (int numero = inicio; numero <= fin; numero++) {
                fila.add(crearCuadroNumero(numero));
            }

            // Ajustar el rango para la siguiente letra
            inicio += 15;
            fin += 15;

            // Añadir la fila al panel principal
            panelHistorial.add(fila);
        }

        // Añadir el panel principal a la ventana
        add(panelHistorial, BorderLayout.CENTER);
    }

    private JPanel crearCuadroNumero(int numero) {
        JPanel cuadro = new JPanel();
        cuadro.setBackground(new Color(211, 211, 211));  // Color gris claro
        cuadro.setLayout(new BorderLayout());
        cuadro.setPreferredSize(new Dimension(50, 50));  // Tamaño del cuadro
        cuadro.setBorder(BorderFactory.createLineBorder(Color.BLACK));  // Agregar borde negro

        JLabel labelNumero = new JLabel(String.valueOf(numero), SwingConstants.CENTER);
        labelNumero.setFont(new Font("Arial", Font.BOLD, 18));  // Tamaño de fuente ajustado
        labelNumero.setForeground(Color.BLACK);  // Texto negro
        cuadro.add(labelNumero, BorderLayout.CENTER);

        return cuadro;
    }

    public void agregarBolaAlHistorial(int bola) {
        bolasExtraidas.add(bola);

        // Determinar el rango de la bola extraída y actualizar el color
        int index = (bola - 1) / 15; // Calcular la fila a la que pertenece
        JPanel fila = (JPanel) panelHistorial.getComponent(index); // Obtener la fila correspondiente
        Component[] componentes = fila.getComponents();

        for (Component comp : componentes) {
            if (comp instanceof JPanel) {
                JPanel cuadro = (JPanel) comp;
                JLabel label = (JLabel) cuadro.getComponent(0);

                // Validar si el texto es un número
                try {
                    int numero = Integer.parseInt(label.getText());
                    if (numero == bola) {
                        cuadro.setBackground(Color.YELLOW); // Cambiar el color a amarillo
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Ignorar los cuadros que no contienen números (como las letras "B", "I", etc.)
                }
            }
        }

        // Refrescar la vista para reflejar los cambios
        revalidate();
        repaint();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaHistorial::new);
    }
}
