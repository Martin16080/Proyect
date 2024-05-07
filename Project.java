package P;
import javax.swing.*;

public class Project {
    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        String[] opciones = {"Compra", "Información de Productos", "Salir"};
        Integer seleccion = JOptionPane.showOptionDialog(null, "Bienvenidos a GAMARRA & ROSELL\n \nSelecciona lo que deseas hacer ",
                "Proyecto final", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        if (seleccion == null || seleccion == JOptionPane.CLOSED_OPTION) {
            // Si se presiona "Cancelar" o se cierra la ventana, salir del programa
            return;
        }

        switch (seleccion) {
            case 0:
                comprarSemillas();
                mostrarMenu(); // Volver al menú principal
                break;
            case 1:
                do {
                    mostrarProductos();
                    seleccion = JOptionPane.showConfirmDialog(null, "¿Quieres ver otro producto?", "Volver al Menú", JOptionPane.YES_NO_OPTION);
                } while (seleccion == JOptionPane.YES_OPTION);
                mostrarMenu(); // Volver al menú principal
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Hasta luego!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                mostrarMenu(); // Volver al menú principal
                break;
        }
    }

    public static void comprarSemillas() {
        String[] semillas = {
                "Semilla de arveja china",
                "Semilla de tomate",
                "Semilla de col",
                "Semilla de pimenton",
                "Semilla de lechuga"
        };

        // Mostrar lista de semillas
        Integer seleccionSemilla = JOptionPane.showOptionDialog(null, "Selecciona una semilla:", "Compra de Semillas",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, semillas, semillas[0]);

        if (seleccionSemilla == null || seleccionSemilla == JOptionPane.CLOSED_OPTION) {
            // Si se presiona "Cancelar" o se cierra la ventana, volver al menú principal
            return;
        }

        Double cantidad = null;
        try {
            String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad en kilogramos que desea comprar:");
            if (input == null) {
                // Si se presiona "Cancelar", volver al menú principal
                return;
            }
            cantidad = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad válida.");
            comprarSemillas(); // Volver a intentar comprar semillas
            return;
        }

        // Solicitar información adicional dependiendo de si es persona natural o empresa
        int tipoCliente = JOptionPane.showOptionDialog(null, "¿Eres persona natural o empresa?", "Tipo de Cliente",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Persona Natural", "Empresa"}, "Persona Natural");

        if (tipoCliente == 0) {
            // Persona Natural
            cotizacionPersonaNatural(cantidad, semillas[seleccionSemilla]);
        } else if (tipoCliente == 1) {
            // Empresa
            cotizacionEmpresa(cantidad, semillas[seleccionSemilla]);
        } else {
            // Si se cierra la ventana de selección, volver al menú principal
            return;
        }
    }

    public static void cotizacionPersonaNatural(Double cantidad, String semilla) {
        // Solicitar información para cotización de persona natural
        String dni = JOptionPane.showInputDialog(null, "Ingrese su DNI:");
        String nombreApellido = JOptionPane.showInputDialog(null, "Ingrese su Nombre y Apellidos:");

        // Calcular precio total
        double precioTotal;
        double precioPorMayor;
        double precioPorMenor;
        switch (semilla) {
            case "Semilla de arveja china":
                precioPorMayor = 30.0;
                precioPorMenor = 40.0;
                break;
            case "Semilla de tomate":
                precioPorMayor = 25.0;
                precioPorMenor = 30.0;
                break;
            case "Semilla de col":
                precioPorMayor = 15.0;
                precioPorMenor = 23.0;
                break;
            case "Semilla de pimenton":
                precioPorMayor = 8.0;
                precioPorMenor = 12.50;
                break;
            case "Semilla de lechuga":
                precioPorMayor = 14.0;
                precioPorMenor = 19.30;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Selección inválida.");
                return;
        }
        if (cantidad >= 2.5) {
            precioTotal = cantidad * precioPorMayor;
        } else {
            precioTotal = cantidad * precioPorMenor;
        }

        // Mostrar cotización para persona natural
        JOptionPane.showMessageDialog(null, String.format("Cotización para Persona Natural:\n\n" +
                "DNI: %s\n" +
                "Nombre y Apellidos: %s\n" +
                "Cantidad de Kg que desea: %.2f\n" +
                "Semilla escogida: %s\n" +
                "Total a pagar: %.2f soles", dni, nombreApellido, cantidad, semilla, precioTotal)+
                "Comunicate con este numero para\n" +
                "culminar la compra: 987654321");

    }

    public static void cotizacionEmpresa(Double cantidad, String semilla) {
        // Solicitar información para cotización de empresa
        String ruc = JOptionPane.showInputDialog(null, "Ingrese el RUC de la empresa:");
        String razonSocial = JOptionPane.showInputDialog(null, "Ingrese la Razón Social de la empresa:");
        String contacto = JOptionPane.showInputDialog(null, "Ingrese el número de contacto de la empresa:");

        // Calcular precio total (mismo cálculo que en cotizacionPersonaNatural)
        double precioTotal;
        double precioPorMayor;
        double precioPorMenor;
        switch (semilla) {
            case "Semilla de arveja china":
                precioPorMayor = 30.0;
                precioPorMenor = 40.0;
                break;
            case "Semilla de tomate":
                precioPorMayor = 25.0;
                precioPorMenor = 30.0;
                break;
            case "Semilla de col":
                precioPorMayor = 15.0;
                precioPorMenor = 23.0;
                break;
            case "Semilla de pimenton":
                precioPorMayor = 8.0;
                precioPorMenor = 12.50;
                break;
            case "Semilla de lechuga":
                precioPorMayor = 14.0;
                precioPorMenor = 19.30;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Selección inválida.");
                return;
        }
        if (cantidad >= 2.5) {
            precioTotal = cantidad * precioPorMayor;
        } else {
            precioTotal = cantidad * precioPorMenor;
        }

        // Mostrar cotización para empresa
        JOptionPane.showMessageDialog(null, String.format("Cotización para Empresa:\n\n" +
                "RUC: %s\n" +
                "Razón Social: %s\n" +
                "Contacto: %s\n" +
                "Cantidad de Kg que desea: %.2f\n" +
                "Semilla escogida: %s\n" +
                "Total a pagar: %.2f soles", ruc, razonSocial, contacto, cantidad, semilla, precioTotal)+
                "Comunicate con este numero para\n" +
                "culminar la compra: 987654321");
    }


    public static void mostrarProductos() {
        String[] productos = {
                "Semillas de arvejas china",
                "Semilla de tomate",
                "Semilla de col",
                "Semilla de pimenton",
                "Semilla de lechuga"
        };

        StringBuilder mensaje = new StringBuilder("Lista de Productos y Composición:\n");
        for (int i = 0; i < productos.length; i++) {
            mensaje.append(i + 1).append(". ").append(productos[i]).append("\n");
        }

        int opcionProducto;
        try {
            opcionProducto = Integer.parseInt(JOptionPane.showInputDialog(null,
                    mensaje + "\n\nElige un producto para ver su descripción (1-5):"));
        } catch (NumberFormatException e) {
            // En caso de que se presione "Cancelar" o se cierre la ventana
            mostrarMenu();
            return;
        }

        if (opcionProducto >= 1 && opcionProducto <= 5) {
            String descripcion = obtenerDescripcion(opcionProducto);
            JOptionPane.showMessageDialog(null, "Descripción del Producto:\n\n" + descripcion);
        } else {
            JOptionPane.showMessageDialog(null, "Opción inválida.");
        }
    }

    public static String obtenerDescripcion(int opcion) {
        switch (opcion) {
            case 1:
                return "La averja chino pertnece a la familia de la leguminosas, y se indentifica\n" +
                        "internacionalmente baso la subpartida arancelaria 070810.\n" +
                        "Es una planta cuyo origen se situa en el Medio Orinete y en el mediterraneo,\n" +
                        "y que desde hace muchos años esta amplieamnete distribuida por todo el mundo,\n" +
                        "Gamarra & Rosell, ofrece las arvejas chinas de mejor calidad del mercado\n" +
                        "peruano  y a los mejores precion, contandon con presentaciones que van de\n" +
                        "bolsas de kilo hasta costales de 10 KG. Brindando como facilidad, no solo\n" +
                        "comprar por mayoreo si no también al por menor, para que las personas no se\n" +
                        "se queden con solo las presentaciones en paquete.\n" +
                        "Adicional, las arvejas chinas que ofrecemos son de alta calidad como tambien\n" +
                        "certificadas por el ministerio  de Agricultura y Riesgo a traves del Servicio\n" +
                        "Nacional de Sanidad Agraria - SENASA";
            case 2:
                return "La semilla de tomate(Solanum lycopersicum) es originaria de la zona andina\n" +
                        "del Perú.\n" +
                        "La planta es cultivada por todo el mundo para el consumo de su frutom, el\n" +
                        "tomate se puede consumir tanto fresco como procesado de diferentes maneras;\n" +
                        "salsa, puré, zumo, deshidratado, enlatado, etc\n\n" +
                        "Gamarra & Rosell, ofrece las semillas de tomate de mejor calidad del mercado\n" +
                        "peruano  y a los mejores precios, contandon con presentaciones que van de\n" +
                        "bolsas de kilo hasta costales de 10 KG. Brindando como facilidad, no solo\n" +
                        "comprar por mayoreo si no también al por menor, para que las personas no se\n" +
                        "se queden con solo las presentaciones en paquete.\n\n" +
                        "Adicional, las semillas de tomate que ofrecemos son de la más alta calidad como\n" +
                        "tambien certificadas por el ministerio  de Agricultura y Riesgo a traves del\n" +
                        "Servicio Nacional de Sanidad Agraria - SENASA";
            case 3:
                return "Las semillas de col se diferencia de la Col Lombarda únicamente en que en este\n" +
                        "caso el color de la hoja es verde y el repollo blanco. La hoja es más tierna.\n" +
                        "Se clasifica en tres tipos, según la forma de la pella: aplanada, puntiaguda y\n" +
                        "redonda. Además en este grupo se incluyen la col crespa y la col berza, que\n" +
                        "no forman repollo.\n\n"+
                        "Gamarra & Rosell, ofrece las semillas de tomate de mejor calidad del mercado\n" +
                        "peruano  y a los mejores precios, contandon con presentaciones que van de\n" +
                        "bolsas de kilo hasta costales de 10 KG. Brindando como facilidad, no solo\n" +
                        "comprar por mayoreo si no también al por menor, para que las personas no se\n" +
                        "se queden con solo las presentaciones en paquete.\n\n" +
                        "Adicional, las semillas de tomate que ofrecemos son de la más alta calidad como\n" +
                        "tambien certificadas por el ministerio  de Agricultura y Riesgo a traves del\n" +
                        "Servicio Nacional de Sanidad Agraria - SENASA";
            case 4:
                return "Las semillas de pimentón son pequeñas y redondeadas, de color marrón oscuro \n" +
                        "a negro. Son las semillas de la planta Capsicum annuum, que se utiliza para\n" +
                        "producir pimentón, también conocido como paprika en algunas partes del mundo.\n" +
                        "Estas semillas son la parte de la planta que se puede sembrarpara cultivar\n" +
                        "nuevas plantas de pimiento.\n" +
                        "Gamarra & Rosell, ofrece las semillas de pimenton de mejor calidad del mercado\n" +
                        "peruano  y a los mejores precios, contandon con presentaciones que van de\n" +
                        "bolsas de kilo hasta costales de 10 KG. Brindando como facilidad, no solo\n" +
                        "comprar por mayoreo si no también al por menor, para que las personas no se\n" +
                        "se queden con solo las presentaciones en paquete.\n\n" +
                        "Adicional, las semillas de pimenton que ofrecemos son de la más alta calidad como\n" +
                        "tambien certificadas por el ministerio  de Agricultura y Riesgo a traves del\n" +
                        "Servicio Nacional de Sanidad Agraria - SENASA";
            case 5:
                return "Las semillas de lechuga son perfectas para cultivar lechugas frescas y crujientes.\n" +
                        "Las semillas de lechuga son pequeñas y ovaladas, generalmente de color marrón\n" +
                        "claro. Son las semillas de la planta de lechuga (Lactuca sativa), una planta\n" +
                        "de la familia de las Asteráceas. Las semillas de lechuga son utilizadas para\n" +
                        "sembrar nuevas plantas de lechuga en jardines o cultivos agrícolas. Tienen \n" +
                        "un tamaño relativamente pequeño en comparación con otras semillas de hortalizas.\n\n" +
                        "Gamarra & Rosell, ofrece las semillas de lechuga de mejor calidad del mercado\n" +
                        "peruano  y a los mejores precios, contandon con presentaciones que van de\n" +
                        "bolsas de kilo hasta costales de 10 KG. Brindando como facilidad, no solo\n" +
                        "comprar por mayoreo si no también al por menor, para que las personas no se\n" +
                        "se queden con solo las presentaciones en paquete.\n\n" +
                        "Adicional, las semillas de lechuga que ofrecemos son de la más alta calidad como\n" +
                        "tambien certificadas por el ministerio  de Agricultura y Riesgo a traves del\n" +
                        "Servicio Nacional de Sanidad Agraria - SENASA";
            default:
                return "Descripción no disponible.";
        }
    }
}

