package juego;

import ficheros.GestionaFicheros;
import preguntas.Pregunta;
import users.Partida;
import users.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Collections.shuffle;

public class TrivialJuego {

    private ArrayList<Pregunta> preguntas;
    private Player player;
    private Partida partida;

    public TrivialJuego(Player player) {
        this.player = player;
        partida = new Partida(player);
    }

    public void jugar() throws IOException {
        partida = new Partida(player);
        preguntas = GestionaFicheros.cargaPreguntas();
        shuffle(preguntas);
        for (int i = 0; i < 5; i++) {
            Pregunta pregunta = preguntas.get(i);
            shuffle(Arrays.asList(pregunta.getOpciones()));
            System.out.println(preguntas.get(i).getPregunta());
            for (int j = 0; j < preguntas.get(i).getOpciones().length; j++) {
                char letra = (char) (j + 65);
                System.out.println(letra + ". " + preguntas.get(i).getOpciones()[j]);
            }

            System.out.print("Elige una opción: ");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.nextLine();
            char letraop = opcion.toUpperCase().charAt(0);
            letraop = (char) (letraop - 65);

            if (pregunta.esCorrecta(letraop)) {
                partida.sumarPunto();
                System.out.println("¡Has acertado!");
            } else {
                System.out.println("La respuesta correcta es: " + preguntas.get(i).getOpcionCorrecta());
            }
        }
        System.out.println("Tu puntuación final es: " + partida.getPuntuacion());
        GestionaFicheros.guardaPartida(partida);
    }

}
