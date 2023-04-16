package users;

import java.io.Serializable;

public class Player extends User implements Serializable {

    public Player(String nombre, String pass) {
        super(nombre, pass);
    }

    @Override
    public boolean permisosAdmin() {
        return false;
    }

    public String toString(){
        return "Nombre: " + this.nombre + " Pass: " + this.pass;
    }

    public boolean equals(Object o){
        if(o instanceof Player){
            Player p = (Player) o;
            if(this.nombre.equals(p.getNombre()) && this.pass.equals(p.getPass())){
                return true;
            }
        }
        return false;
    }

    public int compareTo(Player p){
        return this.nombre.compareTo(p.getNombre());
    }

}
