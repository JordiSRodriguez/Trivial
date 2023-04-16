package juego;

import ficheros.GestionaFicheros;
import users.Admin;
import users.Player;
import users.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrivialMain {
    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Registro player");
            System.out.println("2.Registro admin");
            System.out.println("3.Inicio de sesión");
            System.out.println("4.Salir");
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        registroPlayer();
                        break;
                    case 2:
                        registroAdmin();
                        break;
                    case 3:
                        inicioSesion();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void registroPlayer() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        users = GestionaFicheros.cargaUsers();
        System.out.println("Introduce nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce contraseña");
        String pass = sc.nextLine();
        System.out.println("Repite contraseña");
        String pass2 = sc.nextLine();
        if (pass.equals(pass2)) {
            if (pass.length() >= 8) {
                User user = new Player(nombre, pass);
                if (!users.contains(user)) {
                    users.add(user);
                    GestionaFicheros.guardaUsers(users);
                } else {
                    System.out.println("El usuario ya existe");
                }
            } else {
                System.out.println("La contraseña debe tener al menos 8 caracteres");
            }
        } else {
            System.out.println("Las contraseñas no coinciden");
        }
    }

    private static void registroAdmin() throws IOException {
        Scanner sc = new Scanner(System.in);
        users = GestionaFicheros.cargaUsers();
        System.out.println("Introduce nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce contraseña");
        String pass = sc.nextLine();
        System.out.println("Repite contraseña");
        String pass2 = sc.nextLine();
        if (pass.equals(pass2) && pass.length() >= 8) {
            User user = new Admin(nombre, pass);
            if (!users.contains(user)) {
                users.add(user);
                GestionaFicheros.guardaUsers(users);
            } else {
                System.out.println("El usuario ya existe");
            }
        } else {
            System.out.println("La contraseña debe tener al menos 8 caracteres");
        }
    }

    private static void inicioSesion() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        users = GestionaFicheros.cargaUsers();
        System.out.println("Introduce nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce contraseña");
        String pass = sc.nextLine();
        if (pass.length() < 8) {
            System.out.println("La contraseña no es correcta");
            return;
        }
        if (users.contains(new Player(nombre, pass))) {
            int i = users.indexOf(new Player(nombre, pass));
            TrivialJuego trivialJuego = new TrivialJuego((Player) users.get(i));
            trivialJuego.jugar();
        } else if (users.contains(new Admin(nombre, pass))) {
            int i = users.indexOf(new Admin(nombre, pass));
            TrivialAdmin trivialAdmin = new TrivialAdmin(users.get(i));
            trivialAdmin.administrar();
        } else {
            System.out.println("El usuario no existe");
        }
    }
}
