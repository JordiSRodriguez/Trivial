package users;

import java.util.Date;

public class Partida {
    private Date date;
    private int puntuacion;
    private Player player;

    public Partida(Player player){
        this.date = new Date();
        this.puntuacion = 0;
        this.player = player;
    }

    public void sumarPunto(){
        this.puntuacion++;
    }

    public int getPuntuacion(){
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }

    public Date getDate(){
        return this.date;
    }

    public Player getPlayer(){
        return this.player;
    }

    public String toString(){
        return "Fecha: " + this.date + " Puntuación: " + this.puntuacion + " Jugador: " + this.player.getNombre();
    }

    public boolean equals(Object o){
        if(o instanceof Partida){
            Partida p = (Partida) o;
            if(this.date.equals(p.getDate()) && this.puntuacion == p.getPuntuacion() && this.player.equals(p.getPlayer())){
                return true;
            }
        }
        return false;
    }

}
