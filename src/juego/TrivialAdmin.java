package juego;

import ficheros.GestionaFicheros;
import users.User;

import java.io.IOException;

/**
 * Clase que administra el juego trivial
 * @author Jordi Sumba
 */
public class TrivialAdmin implements Comparable<User> {
    public TrivialAdmin(User user) {
    }

    /**
     * Método que muestra las partidas jugadas y los usuarios registrados
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void administrar() throws IOException, ClassNotFoundException {
        System.out.println("Bienvenido administrador");
        System.out.println("Partidas jugadas: ");
        for (String partida : GestionaFicheros.leePartidas()) {
            System.out.println(partida);
        }
        System.out.println("Usuarios registrados: ");
        for (User user : GestionaFicheros.cargaUsers()) {
            System.out.println("-" + user.getNombre());
        }
    }

    /**
     * Método que muestra las estadísticas de un usuario
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public int compareTo(User o) {
        return 0;
    }
}
