package logic;

import model.Tenista;

public class Validaciones {

    public static boolean validarTenista(Tenista nuevo) {
        String error = validarYObtenerError(nuevo);
        if (error != null) {
            System.out.println("❌ " + error);
            return false;
        }
        return true;
    }

    public static String validarYObtenerError(Tenista nuevo) {
        if (nuevo == null)
            return "El objeto Tenista no puede ser nulo.";

        if (nuevo.getNombre() == null || nuevo.getNombre().trim().isEmpty())
            return "El nombre no puede estar vacío.";

        if (nuevo.getPais() == null || nuevo.getPais().trim().isEmpty())
            return "El país no puede estar vacío.";

        if (nuevo.getEdad() < 15 || nuevo.getEdad() > 45)
            return "La edad debe estar entre 15 y 45 años.";

        if (nuevo.getPuntaje() < 0)
            return "El puntaje no puede ser negativo.";

        return null;
    }
}
