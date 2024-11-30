import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends JFrame {
    private JButton botonJugar;
    private JButton botonEscogerPatron;
    private JButton botonCreditos;
    private JButton botonSalir;
    private int indicePatronSeleccionado = -1;
    private PatronManager patronManager;

    public VentanaMenu() {
        setTitle("Bingo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas con un espacio entre botones

        patronManager = new PatronManager(); // Inicializar PatronManager
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Título BINGO
        JLabel titulo = new JLabel("BINGO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(Color.BLUE);
        add(titulo);

        // Botón "Jugar"
        botonJugar = new JButton("Jugar");
        botonJugar.addActionListener(e -> abrirVentanaJuego());
        add(botonJugar);

        // Botón "Escoger Patrón"
        botonEscogerPatron = new JButton("Escoger Patrón");
        botonEscogerPatron.addActionListener(e -> abrirVentanaPatron());
        add(botonEscogerPatron);

        // Botón "Créditos"
        botonCreditos = new JButton("Créditos");
        botonCreditos.addActionListener(e -> mostrarCreditos());
        add(botonCreditos);

        // Botón "Salir"
        botonSalir = new JButton("Salir");
        botonSalir.addActionListener(e -> System.exit(0)); // Cierra la aplicación
        add(botonSalir);
    }

    public void setIndicePatronSeleccionado(int indice) {
        this.indicePatronSeleccionado = indice;

        String mensaje = (indice == -1)
                ? "No hay patrón seleccionado. Por favor selecciona un patrón antes de jugar."
                : "Patrón seleccionado: " + patronManager.getNombresPatrones()[indice];

        JOptionPane.showMessageDialog(this, mensaje,
                "Patrón Seleccionado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void abrirVentanaJuego() {
        if (indicePatronSeleccionado == -1) {
            JOptionPane.showMessageDialog(this,
                    "No has seleccionado un patrón de victoria. Por favor selecciona uno antes de iniciar el juego.",
                    "Información", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VentanaJuego ventanaJuego = new VentanaJuego("Juego de Bingo", indicePatronSeleccionado, patronManager, this);
        ventanaJuego.setVisible(true);
        this.setVisible(false); // Ocultar el menú
    }

    private void abrirVentanaPatron() {
        VentanaSeleccionPatron seleccionPatron = new VentanaSeleccionPatron(this, patronManager);
        seleccionPatron.setVisible(true);

        // Obtener el índice del patrón seleccionado después de cerrar la ventana
        int indiceSeleccionado = seleccionPatron.getPatronSeleccionado();
        if (indiceSeleccionado != -1) {
            setIndicePatronSeleccionado(indiceSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this,
                    "No seleccionaste ningún patrón. Por favor selecciona un patrón antes de jugar.",
                    "Información", JOptionPane.WARNING_MESSAGE);
        }
    }


    private void mostrarCreditos() {
        JOptionPane.showMessageDialog(this,
                "Desarrollado por: Adad Arias Palma\nBingo Version 1.0",
                "Créditos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaMenu().setVisible(true)); // Mostrar ventana del menú
    }
}
