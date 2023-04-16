package users;

import java.io.Serializable;

public class Admin extends User implements Serializable {

    public Admin(String nombre, String pass) {
        super(nombre, pass);
    }

    @Override
    public boolean permisosAdmin() {
        return true;
    }

    public String toString(){
        return "Nombre: " + this.nombre + " Pass: " + this.pass;
    }

    public boolean equals(Object o){
        if(o instanceof Admin){
            Admin a = (Admin) o;
            if(this.nombre.equals(a.getNombre()) && this.pass.equals(a.getPass())){
                return true;
            }
        }
        return false;
    }

}
