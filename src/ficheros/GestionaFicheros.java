package ficheros;

import preguntas.Opcion;
import preguntas.Pregunta;
import users.Partida;
import users.User;
import java.io.*;
import java.util.ArrayList;

public class GestionaFicheros {
    private static final File filePreguntas = new File("files/preguntas.txt");
    private static final File fileUser = new File("files/user.dat");
    private static final File filePartidas = new File("files/partidas.txt");

    public static void guardaUsers(ArrayList<User> users) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileUser);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList<User> cargaUsers() {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        ArrayList<User> userArrayList = new ArrayList<>();
        try {
            fis = new FileInputStream(fileUser);
            ois = new ObjectInputStream(fis);
            userArrayList = (ArrayList<User>) ois.readObject();
        } catch (EOFException e){

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return userArrayList;
    }

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

    public static void guardaPartida(Partida partida) throws IOException {
        if (!filePartidas.exists()) {
            filePartidas.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePartidas, true));
        bw.write(partida.toString());
        bw.newLine();
        bw.close();
    }

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
