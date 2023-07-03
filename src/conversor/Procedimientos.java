package conversor;

import javax.swing.JOptionPane;

public class Procedimientos {
	public static void main(String[] args) {
		menu();
	}
	//hola
	public static void menu() {
	    Object op = JOptionPane.showInputDialog(null, "Elija una de las opciones a utilizar", "Conversor",
	            JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Conversor de moneda", "Conversor de temperatura" },
	            "Aceptar");
	    if (op != null) {
	        if (op.equals("Conversor de moneda")) {
	            conversorDeMonedas();
	        } else if (op.equals("Conversor de temperatura")) {
	            conversorDeTemperatura();
	        }
	    } else {
	        System.exit(0);
	    }
	}
	private static void conversorDeTemperatura() {
		FrameConversorTemperatura miConversorTemperatura = new FrameConversorTemperatura();
		miConversorTemperatura.setVisible(true);
	}
	private static void conversorDeMonedas() {
		FrameConversorMoneda miConversorMoneda = new FrameConversorMoneda();
		miConversorMoneda.setVisible(true);
	}	
	public double obtenerTasa(String moneda1, String moneda2) {
		// COP Peso COlombiano
		// USD Dólar
		// EUR Euro
		// GPB Libra Esterlina
		// JPY Yen Japonés
		// KRW Won Surcoreano
		String llave = moneda1 + "-" + moneda2;		
		double tasa = 0;
		switch (llave) {
		// Mi moneda local a monedas extranjeras
		case "COP-USD":
			tasa = 0.00024;
			break;
		case "COP-EUR":
			tasa = 0.00022;
			break;
		case "COP-GPB":
			tasa = 0.00019;
			break;
		case "COP-JPY":
			tasa = 0.035;
			break;
		case "COP-KRW":
			tasa = 0.32;
			break;
		case "USD-COP":
			tasa = 4168.00;
			break;
		case "EUR-COP":
			tasa = 4552.08;
			break;
		case "GPB-COP":
			tasa = 5296.07;
			break;
		case "JPY-COP":
			tasa = 28.88;
			break;
		case "KRW-COP":
			tasa = 3.17;
			break;
		case "USD-EUR":
			tasa = 0.92;
			break;
		case "USD-GBP":
			tasa= 0.79;
			break;
		case "USD-JPY":
			tasa= 144.65;
			break;
		case "USD-KRW":
			tasa= 1305.89;
			break;
		case "EUR-GBP":
			tasa=0.86;
			break;
		case "EUR-JPY":
			tasa = 157.91;
			break;
		case "EUR-KRW":
			tasa= 1425.60;
			break;
		case "GBP-JPY":
			tasa = 183.69;
			break;
		case "GBP-KRW":
			tasa = 1658.13;
			break;
		case "JPY-KRW":
			tasa = 0.11;
			break;
		case "EUR-USD":
			tasa = 0.92;
			break;
		case "GBP-USD":
			tasa = 1.27;
			break;
		case "JPY-USD":
			tasa = 0.0069;
			break;
		case "KRW-USD":
			tasa = 0.00077;
			break;
		case "GBP-EUR":
			tasa = 1.16;
			break;
		case "JPY-EUR":
			tasa = 157.93;
			break;
		case "KRW-EUR":
			tasa = 0.00070;
			break;
		case "JPY-GBP":
			tasa = 183.71;
			break;
		case "KRW-GBP":
			tasa = 1658.15;
			break;
		case "KRW-JPY":
			tasa = 0.11;
			break;
		}
		return tasa;
	}
}