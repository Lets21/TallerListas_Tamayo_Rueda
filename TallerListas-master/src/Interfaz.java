import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    private JTextField textFieldIngresoNombre;
    private JTextField textFieldEliminarID;
    private JTextField textFieldBuscarID;
    private JButton BtnIngresar;
    private JButton BtnEliminarxID;
    private JButton BtnBuscarxID;
    private JButton BtnCalcular;
    private JTextArea textArea1;
    private JPanel JPanelPrincipal;
    private JTextField textFieldNumPag;
    private JButton BtnEliminarxNombre;
    private JButton BtnBuscarxNombre;
    private JTextField textFieldBuscarNombre;
    private JTextField textFieldEliminarNombre;

    Biblioteca b = new Biblioteca();

    public Interfaz() {

        setContentPane(JPanelPrincipal);

        BtnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.agregarLibro(textFieldIngresoNombre.getText(), Integer.parseInt(textFieldNumPag.getText()));
            }
        });
        BtnBuscarxID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BtnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.calcularTotalPaginas();
            }
        });
        BtnEliminarxID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BtnBuscarxNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.buscarLibroPorNombre(textFieldBuscarNombre.getText());
            }
        });
        BtnEliminarxNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.buscarLibroPorNombre(textFieldEliminarNombre.getText());
            }
        });

    }
}



