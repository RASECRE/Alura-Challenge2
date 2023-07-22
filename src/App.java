import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        Object[] options = {"Convertidor de Divisas", "Convertidor de Temperatura", "Salir"};
        int elige = JOptionPane.showOptionDialog(null, "¿Que acción desea realizar?", "Conversor", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (elige == 2) {
            JOptionPane.showMessageDialog(null, "Programa Terminado");
            System.exit(0);
        }
        if (elige == 0) {
            convertidorMonedas();
        } else if (elige == 1) {
            convertidorTemperatura();
        }
    }
    private static void convertidorMonedas() {
        DecimalFormat formatearDivisas = new DecimalFormat("#.##");
        boolean continuaPrograma = true;

        while (continuaPrograma) {
            String[] opciones = {"Pesos Mexicanos a Dólares", "Pesos Mexicanos a Euros", "Pesos Mexicanos a Libras Esterlinas", "Pesos Mexicanos a Yen Japonés", "Pesos Mexicanos a Won sur-coreano",
                    "Dólares a Pesos Mexicanos", "Euros a Pesos Mexicanos", "Yen Japonés a Pesos Mexicanos", "Won sur-coreano a Pesos Mexicanos"};
            String cambio = (String) JOptionPane.showInputDialog(null, "Elige la opción deseada", "Convertidor de moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (cambio == null) {
                JOptionPane.showMessageDialog(null, "Programa Finalizado.");
                break;
            }

            String input = JOptionPane.showInputDialog(null, "Ingresa cantidad:");

            try {
                double cantidad = Double.parseDouble(input);
                double resultado = 0.0;

                switch (cambio) {
                    case "Pesos Mexicanos a Dólares":
                        resultado = cantidad / 16.85;
                        JOptionPane.showMessageDialog(null, cantidad + " Pesos Mexicanos son: " + formatearDivisas.format(resultado) + " Dólares.");
                        break;
                    case "Pesos Mexicanos a Euros":
                        resultado = cantidad / 18.77;
                        JOptionPane.showMessageDialog(null, cantidad + " Pesos Mexicanos son: " + formatearDivisas.format(resultado) + " Euros.");
                        break;
                    case "Pesos Mexicanos a Libras Esterlinas":
                        resultado = cantidad / 0.046;
                        JOptionPane.showMessageDialog(null, cantidad + " Pesos Mexicanos son: " + formatearDivisas.format(resultado) + " Libras Esterlinas.");
                        break;
                    case "Pesos Mexicanos a Yen Japonés":
                        resultado = cantidad / 8.30;
                        JOptionPane.showMessageDialog(null, cantidad + " Pesos Mexicanos son: " + formatearDivisas.format(resultado) + " Yen Japonés.");
                        break;
                    case "Pesos Mexicanos a Won sur-coreano":
                        resultado = cantidad / 75.62;
                        JOptionPane.showMessageDialog(null, cantidad + " Pesos Mexicanos son: " + formatearDivisas.format(resultado) + " Won.");
                        break;
                    case "Dólares a Pesos Mexicanos":
                        resultado = cantidad * 16.85;
                        JOptionPane.showMessageDialog(null, cantidad + " Dólares son: " + formatearDivisas.format(resultado) + " Pesos Mexicanos.");
                        break;
                    case "Euros a Pesos Mexicanos":
                        resultado = cantidad * 18.77;
                        JOptionPane.showMessageDialog(null, cantidad + " Euros son: " + formatearDivisas.format(resultado) + " Pesos Mexicanos.");
                        break;
                    case "Yen Japonés a Pesos Mexicanos":
                        resultado = cantidad * 8.30;
                        JOptionPane.showMessageDialog(null, cantidad + " Yen Japonés son: " + formatearDivisas.format(resultado) + " Pesos Mexicanos.");
                        break;
                    case "Won sur-coreano a Pesos Mexicanos":
                        resultado = cantidad * 75.62;
                        JOptionPane.showMessageDialog(null, cantidad + " Won son: " + formatearDivisas.format(resultado) + " Pesos Mexicanos.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor ingresado no es válido.");
                continue;
            }

            int confirma = JOptionPane.showConfirmDialog(null, "¿Desea Continuar?", "Continuar", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirma == JOptionPane.NO_OPTION || confirma == JOptionPane.CANCEL_OPTION) {
                continuaPrograma = false;
                JOptionPane.showMessageDialog(null, "Programa Finalizado.");
            }
        }
    }

    private static void convertidorTemperatura() {
        boolean seguirPrograma = true;

        while (seguirPrograma) {
            String[] opciones = {"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
            int opcion = JOptionPane.showOptionDialog(null, "Elige la opción deseada", "Convertidor de Temperatura", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (opcion == -1) {
                JOptionPane.showMessageDialog(null, "Programa Finalizado.");
                break;
            }

            String valorNominal = JOptionPane.showInputDialog(null, "Ingrese la temperatura que quiere convertir:");
            double valor = 0.0;

            try {
                valor = Double.parseDouble(valorNominal);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor ingresado no es válido.");
                continue;
            }

            double resultado = 0;

            if (opcion == 0) {
                resultado = (valor * 9 / 5) + 32;
                JOptionPane.showMessageDialog(null, valor + " Grados Celsius son: " + resultado + " Grados Fahrenheit.");
            } else if (opcion == 1) {
                resultado = (valor - 32) * 5 / 9;
                JOptionPane.showMessageDialog(null, valor + " Grados Fahrenheit son: " + resultado + " Grados Celsius.");
            }

            int continuar = JOptionPane.showConfirmDialog(null, "¿Quiere seguir ocupando el programa?", "", JOptionPane.YES_NO_OPTION);

            if (continuar == JOptionPane.NO_OPTION) {
                seguirPrograma = false;
                JOptionPane.showMessageDialog(null, "Programa Finalizado.");
            }
        }
    }
}
