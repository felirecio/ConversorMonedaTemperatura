package conversor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrameConversorTemperatura extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textCelsius;
	private JTextField textFahrenheit;
	JButton btnConvertir;
	JButton btnLimpiar;
	JButton btnCerrar;

	public FrameConversorTemperatura() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 196);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
		setTitle("Conversor de Temperatura");
		setLocationRelativeTo(null);
        
        JLabel lblCelsius = new JLabel("Grados Celsius:");
        lblCelsius.setBounds(72, 49, 100, 14);
        contentPane.add(lblCelsius);
        
        textCelsius = new JTextField();
        textCelsius.setBounds(72, 65, 100, 20);
        contentPane.add(textCelsius);
        textCelsius.setColumns(10);
        
        JLabel lblFahrenheit = new JLabel("Grados Fahrenheit:");
        lblFahrenheit.setBounds(202, 49, 120, 14);
        contentPane.add(lblFahrenheit);
        
        textFahrenheit = new JTextField();
        textFahrenheit.setBounds(202, 65, 100, 20);
        contentPane.add(textFahrenheit);
        textFahrenheit.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Calcule la equivalencia escribiendo únicamente el dato de origen");
        lblNewLabel.setBounds(10, 11, 384, 14);
        contentPane.add(lblNewLabel);
        
        btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(38, 123, 100, 23);
        contentPane.add(btnConvertir);
        btnConvertir.addActionListener(this);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(148, 123, 100, 23);
        contentPane.add(btnLimpiar);
        btnLimpiar.setEnabled(false);
        btnLimpiar.addActionListener(this);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(258, 123, 100, 23);
        contentPane.add(btnCerrar);
        btnCerrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (btnConvertir == e.getSource()) {
            if (!textCelsius.getText().isEmpty()) {
                double celsius = Double.parseDouble(textCelsius.getText());
                double fahrenheit = (celsius * 9 / 5) + 32;
                fahrenheit = Math.round(fahrenheit * 100.0) / 100.0;
                textFahrenheit.setText(String.valueOf(fahrenheit));
            } else if (!textFahrenheit.getText().isEmpty()) {
                double fahrenheit = Double.parseDouble(textFahrenheit.getText());
                double celsius = (fahrenheit - 32) * 5 / 9;
                celsius = Math.round(celsius * 100.0) / 100.0;
                textCelsius.setText(String.valueOf(celsius));
            }
            btnLimpiar.setEnabled(true);
            btnConvertir.setEnabled(false);
        }
        if (btnLimpiar == e.getSource()) {
            textCelsius.setText("");
            textFahrenheit.setText("");
            btnLimpiar.setEnabled(false);
            btnConvertir.setEnabled(true);
        }
        if (btnCerrar == e.getSource()) {
	        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas cerrar la aplicación?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);
	        if (opcion == JOptionPane.YES_OPTION) {
	            dispose(); // Cierra el JFrame actual
	            System.exit(0); // Cierra la aplicación
	        }
        }
    }
}
