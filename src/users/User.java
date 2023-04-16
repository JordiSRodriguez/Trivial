package users;

import java.io.Serializable;

public abstract class User implements Comparable<User>, Serializable {
    protected String nombre;
    protected String pass;

    public User(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPass() {
        return this.pass;
    }


    public boolean cambiarPass(String pass) {
        if (pass.length() >= 8) {
            this.pass = pass;
            return true;
        }
        return false;
    }

    public boolean compruebaPass(String pass) {
        if (this.pass.equals(pass)) {
            return true;
        } else {
            return false;
        }
    }

    public abstract boolean permisosAdmin();

    public String toString() {
        return "Nombre: " + this.nombre + " Pass: " + this.pass + "\n";
    }

    public boolean equals(Object o) {
        if (o instanceof User) {
            User u = (User) o;
            if (this.nombre.equals(u.getNombre()) && this.pass.equals(u.getPass())) {
                return true;
            }
        }
        return false;
    }

    public int compareTo(User u) {
        return this.nombre.compareTo(u.getNombre());
    }


}
