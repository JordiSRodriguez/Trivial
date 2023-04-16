package preguntas;

public class Opcion {
    private String enunciado;
    private boolean correcta;

    public Opcion(String enunciado, boolean correcta){
        this.enunciado = enunciado;
        this.correcta = correcta;
    }

    public String getEnunciado(){
        return this.enunciado;
    }

    public boolean getCorrecta(){
        return this.correcta;
    }

    public void setEnunciado(String enunciado){
        this.enunciado = enunciado;
    }

    public void setCorrecta(boolean correcta){
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return enunciado;
    }

    public boolean equals(Object o){
        if(o instanceof Opcion){
            Opcion op = (Opcion) o;
            if(this.enunciado.equals(op.getEnunciado()) && this.correcta == op.getCorrecta()){
                return true;
            }
        }
        return false;
    }

}
