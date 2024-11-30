import javax.swing.*;
import java.awt.*;

public class VentanaJuego extends JFrame {
    private final CartaBingo cartaBingo;
    private final VentanaHistorial ventanaHistorial;
    private final PatronManager patronManager;
    private final Tombola tombola;
    private final int indicePatronSeleccionado;
    private JButton botonExtraer; // Mover a variable de instancia para controlarla después
    private VentanaMenu ventanaMenu; // Referencia al menú principal

    public VentanaJuego(String titulo, int indicePatronSeleccionado, PatronManager patronManager, VentanaMenu ventanaMenu) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Asignar el patrón seleccionado, el PatronManager y la referencia al menú
        this.indicePatronSeleccionado = indicePatronSeleccionado;
        this.patronManager = patronManager;
        this.ventanaMenu = ventanaMenu;

        // Inicializar componentes principales
        tombola = new Tombola();
        cartaBingo = new CartaBingo();
        ventanaHistorial = new VentanaHistorial();

        // Verificar si se seleccionó un patrón válido
        if (indicePatronSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "No se seleccionó ningún patrón. El juego se cerrará.");
            dispose();
            return;
        }

        inicializarComponentes();
        ventanaHistorial.setVisible(true); // Mostrar el historial
    }

    private void inicializarComponentes() {
        // Panel central con la carta de Bingo
        add(cartaBingo.mostrarCarta(), BorderLayout.CENTER);

        // Panel inferior con el botón para extraer bolas
        JPanel panelInferior = new JPanel(new FlowLayout());

        botonExtraer = new JButton("Extraer Bola");
        botonExtraer.addActionListener(e -> extraerBola());
        panelInferior.add(botonExtraer);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void extraerBola() {
        int bola = tombola.sacarBola(); // Extraer una bola
        if (bola == -1) {
            JOptionPane.showMessageDialog(this, "No quedan más bolas.", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Actualizar el estado de la carta
        cartaBingo.marcarNumero(bola); // Marca el número en la lógica
        cartaBingo.actualizarCarton(); // Refresca la vista gráfica

        // Actualizar el historial
        ventanaHistorial.agregarBolaAlHistorial(bola);

        // Obtener el patrón seleccionado utilizando getPatrones()
        int[][] patronSeleccionado = patronManager.getPatrones().get(indicePatronSeleccionado);
        if (cartaBingo.verificarVictoria(patronSeleccionado)) {
            JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado con el patrón seleccionado.");

            // Deshabilitar el botón de extraer bolas para finalizar el juego
            botonExtraer.setEnabled(false);

            // Mostrar opciones al jugador
            mostrarOpcionesFinJuego();
        }
    }

    private void mostrarOpcionesFinJuego() {
        String[] opciones = { "Jugar de Nuevo", "Salir" };
        int opcionSeleccionada = JOptionPane.showOptionDialog(this,
                "¿Qué deseas hacer?",
                "Fin del Juego",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (opcionSeleccionada == 0) {
            // Jugar de nuevo: Volver al menú principal
            ventanaMenu.setVisible(true); // Mostrar el menú principal
            ventanaHistorial.dispose(); // Cerrar la ventana del historial
            dispose(); // Cerrar la ventana del juego actual
        } else if (opcionSeleccionada == 1) {
            // Salir: Cerrar la aplicación
            ventanaHistorial.dispose(); // Cerrar la ventana del historial
            dispose(); // Cerrar la ventana del juego actual
            ventanaMenu.dispose(); // Cerrar el menú principal
            System.exit(0); // Salir de la aplicación
        } else {
            // Si el usuario cierra el diálogo o selecciona una opción no válida
            // Puedes decidir qué hacer en este caso. Por ahora, no haremos nada.
        }
    }
}
