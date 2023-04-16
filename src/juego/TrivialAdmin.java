package juego;

import ficheros.GestionaFicheros;
import users.User;

import java.io.IOException;

public class TrivialAdmin implements Comparable<User> {
    public TrivialAdmin(User user) {
    }

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

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
