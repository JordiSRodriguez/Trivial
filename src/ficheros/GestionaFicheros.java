package ficheros;

import preguntas.Opcion;
import preguntas.Pregunta;
import users.Partida;
import users.User;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que gestiona los ficheros de preguntas, usuarios y partidas de la aplicación
 * @author Jordi Sumba
 */
public class GestionaFicheros {
    private static final File filePreguntas = new File("files/preguntas.txt");
    private static final File fileUser = new File("files/user.dat");
    private static final File filePartidas = new File("files/partidas.txt");

    /**
     * Guarda los usuarios en un fichero binario con ObjectOutputStream y un ArrayList de usuarios
     * @param users ArrayList de usuarios a guardar
     */
    public static void guardaUsers(ArrayList<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileUser))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los usuarios de un fichero binario gracias a ObjectInputStream y devuelve un ArrayList de usuarios
     * @return ArrayList de usuarios cargados
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<User> cargaUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileUser))) {
            return (ArrayList<User>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Guarda las preguntas en un fichero de texto con BufferedWriter
     * @throws IOException
     */
    public static ArrayList<Pregunta> cargaPreguntas() throws IOException {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        if (!filePreguntas.exists()) {
            filePreguntas.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(filePreguntas));
        String pregunta = br.readLine();
        while (pregunta != null) {
            Opcion[] respuestas = new Opcion[4];
            respuestas[0] = new Opcion(br.readLine(), true);
            for (int i = 1; i < 4; i++) {
                respuestas[i] = new Opcion(br.readLine(), false);
            }
            preguntas.add(new Pregunta(pregunta, respuestas));
            pregunta = br.readLine();
        }
        return preguntas;
    }

    /**
     * Guarda las partidas en un fichero de texto con BufferedWriter
     * @param partida Partida a guardar
     * @throws IOException
     */
    public static void guardaPartida(Partida partida) throws IOException {
        if (!filePartidas.exists()) {
            filePartidas.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePartidas, true));
        bw.write(partida.toString());
        bw.newLine();
        bw.close();
    }

    /**
     * Carga las partidas de un fichero de texto con BufferedReader
     * @return ArrayList de partidas cargadas
     * @throws IOException
     */
    public static ArrayList<String> leePartidas() throws IOException {
        ArrayList<String> partidas = new ArrayList<>();
        if (!filePartidas.exists()) {
            filePartidas.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(filePartidas));
        String partida = br.readLine();
        while (partida != null) {
            partidas.add(partida);
            partida = br.readLine();
        }
        return partidas;
    }
}
