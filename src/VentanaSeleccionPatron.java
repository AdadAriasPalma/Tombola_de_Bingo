import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class VentanaSeleccionPatron extends JDialog {
    private final PatronManager patronManager;

    public VentanaSeleccionPatron(Frame owner, PatronManager patronManager) {
        super(owner, "Seleccionar Patrón de Victoria", true); // El tercer parámetro 'true' hace que sea modal
        this.patronManager = patronManager;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(owner);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Crear un panel con diseño de cuadrícula para mostrar los patrones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 6, 5, 5)); // 7 filas, 6 columnas, espacio de 5px

        String[] nombresPatrones = patronManager.getNombresPatrones();
        for (int i = 0; i < nombresPatrones.length; i++) {
            final int indice = i; // Variable necesaria para acceder dentro de las lambdas

            // Crear un botón para cada patrón
            JButton boton = new JButton();

            // Intentar cargar la imagen del patrón
            String nombreImagen = "/imagenes/patron" + (i + 1) + ".png";
            URL urlImagen = getClass().getResource(nombreImagen);
            if (urlImagen != null) {
                // Si se encuentra la imagen, cargarla y escalarla
                ImageIcon icono = new ImageIcon(urlImagen);
                Image imagenEscalada = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                icono = new ImageIcon(imagenEscalada);
                boton.setIcon(icono); // Establecer la imagen como ícono del botón
            } else {
                // Si no se encuentra la imagen, mostrar el número del patrón como texto
                boton.setText(String.valueOf(i + 1));
            }

            // Establecer el comportamiento al hacer clic en el botón
            boton.addActionListener(e -> {
                patronManager.setPatronSeleccionado(indice); // Guardar el índice del patrón seleccionado
                JOptionPane.showMessageDialog(this, "Patrón seleccionado: " + (indice + 1)); // Mostrar confirmación
                dispose(); // Cerrar la ventana después de la selección
            });

            panel.add(boton); // Añadir el botón al panel
        }

        // Añadir un JScrollPane para que los botones puedan desplazarse si no caben en la ventana
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane); // Añadir el panel con scroll a la ventana
    }

    // Método para obtener el índice del patrón seleccionado
    public int getPatronSeleccionado() {
        return patronManager.getIndicePatronSeleccionado();
    }
}