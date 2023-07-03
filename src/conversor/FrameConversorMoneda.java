package conversor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import conversor.Procedimientos;
import java.text.DecimalFormat;

public class FrameConversorMoneda extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textMontoOriginal;
	JButton btnConvertir;
	JButton btnLimpiar;
	JButton btnCerrar;
	JComboBox comboBoxMonedaOriginal;
	JComboBox comboBoxMonedaObjetivo;
	JLabel lblResultado;


	Procedimientos miProcedimiento = new Procedimientos();

	public FrameConversorMoneda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTitle("Conversor de moneda");
		setLocationRelativeTo(null);

		JLabel lblMonedaOrigen = new JLabel("Moneda origen:");
		lblMonedaOrigen.setBounds(31, 139, 140, 14);
		contentPane.add(lblMonedaOrigen);

		JLabel lblMonedaObjetivo = new JLabel("Moneda objetivo:");
		lblMonedaObjetivo.setBounds(193, 139, 140, 14);
		contentPane.add(lblMonedaObjetivo);

		comboBoxMonedaOriginal = new JComboBox(); // lo creo arriba para poderlo usar en el metodo de acciones
		comboBoxMonedaOriginal.setBounds(31, 155, 140, 22);
		comboBoxMonedaOriginal.addItem("COP");
		comboBoxMonedaOriginal.addItem("USD");
		comboBoxMonedaOriginal.addItem("EUR");
		comboBoxMonedaOriginal.addItem("GPB");
		comboBoxMonedaOriginal.addItem("JPY");
		comboBoxMonedaOriginal.addItem("KRW");
		contentPane.add(comboBoxMonedaOriginal);

		comboBoxMonedaObjetivo = new JComboBox(); // lo creo arriba para poderlo usar en el metodo de acciones
		comboBoxMonedaObjetivo.setBounds(193, 155, 140, 22);
		comboBoxMonedaObjetivo.addItem("COP");
		comboBoxMonedaObjetivo.addItem("USD");
		comboBoxMonedaObjetivo.addItem("EUR");
		comboBoxMonedaObjetivo.addItem("GPB");
		comboBoxMonedaObjetivo.addItem("JPY");
		comboBoxMonedaObjetivo.addItem("KRW");
		contentPane.add(comboBoxMonedaObjetivo);

		JLabel lblNewLabel = new JLabel("Por favor tenga en cuenta las siguientes convenciones ISO:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(31, 11, 393, 22);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("COP: Peso colombiano");
		lblNewLabel_1.setBounds(31, 44, 154, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("USD: Dólar americano");
		lblNewLabel_1_1.setBounds(31, 58, 154, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("EUR: Euro");
		lblNewLabel_1_2.setBounds(31, 72, 154, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("GPB: Libra esterlina");
		lblNewLabel_1_3.setBounds(31, 86, 154, 14);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("JPY: Yen japonés");
		lblNewLabel_1_3_1.setBounds(31, 100, 154, 14);
		contentPane.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("KRW: Won surcoreano");
		lblNewLabel_1_3_1_1.setBounds(31, 114, 154, 14);
		contentPane.add(lblNewLabel_1_3_1_1);

		textMontoOriginal = new JTextField();
		textMontoOriginal.setBounds(31, 211, 140, 20);
		textMontoOriginal.setText("0");
		contentPane.add(textMontoOriginal);
		textMontoOriginal.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Monto a convertir:");
		lblNewLabel_2.setBounds(31, 196, 140, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Resultado:");
		lblNewLabel_3.setBounds(193, 196, 140, 14);
		contentPane.add(lblNewLabel_3);

		lblResultado = new JLabel("0");
		lblResultado.setBounds(193, 214, 140, 14);
		contentPane.add(lblResultado);

		// estos tres botones los declaro por fuera del metodo para que puedan ser
		// accedidos desde la clase de acciones

		btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(31, 261, 89, 23);
		btnConvertir.addActionListener(this); // incluir esto para activar la clase de acciones
		contentPane.add(btnConvertir);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(130, 261, 89, 23);
		btnLimpiar.addActionListener(this); // incluir esto para activar la clase de acciones
		contentPane.add(btnLimpiar);
		btnLimpiar.setEnabled(false);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(229, 261, 89, 23);
		btnCerrar.addActionListener(this); // incluir esto para activar la clase de acciones
		contentPane.add(btnCerrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnConvertir == e.getSource()) {
			String monedaOriginal = (String) comboBoxMonedaOriginal.getSelectedItem();
			String monedaObjetivo = (String) comboBoxMonedaObjetivo.getSelectedItem();

			if (monedaOriginal != monedaObjetivo) {
				if (textMontoOriginal.getText() != "") {
					try {
						double montoOriginal = Double.parseDouble(textMontoOriginal.getText());
						if (montoOriginal > 0) {
							double tasa = miProcedimiento.obtenerTasa(monedaOriginal, monedaObjetivo);
							double resultado = montoOriginal * tasa;
							resultado = Math.round(resultado * 100.0) / 100.0;
							lblResultado.setText(String.valueOf(resultado) + " " + monedaObjetivo);
							btnLimpiar.setEnabled(true);
							btnConvertir.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(null, "Debe escribir un monto superior a cero", "Error",JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "El monto ingresado no es válido", "Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar monedas diferentes", "Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (btnLimpiar == e.getSource()) {
			comboBoxMonedaOriginal.setSelectedIndex(0);
            comboBoxMonedaObjetivo.setSelectedIndex(0);
            textMontoOriginal.setText("0");
            lblResultado.setText("0");
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
