package preguntas;

public class Pregunta {
    private String pregunta;
    private Opcion[] opciones;

    public Pregunta(String pregunta, Opcion[] opciones){
        this.pregunta = pregunta;
        this.opciones = opciones;
    }

    public String getPregunta(){
        return this.pregunta;
    }

    public Opcion[] getOpciones(){
        return this.opciones;
    }

    public String getOpcionCorrecta(){
        for (Opcion opcion : opciones) {
            if (opcion.getCorrecta()){
                return opcion.getEnunciado();
            }
        }
        return null;
    }

    public boolean esCorrecta(int indice){
        return opciones[indice].getCorrecta();
    }

    public String toString() {
        String texto = "Pregunta: " + this.pregunta + " Opciones: ";
        for (Opcion opcion : opciones) {
            texto += opcion.toString();
        }
        return texto;
    }

    public boolean equals(Object o){
        if(o instanceof Pregunta){
            Pregunta p = (Pregunta) o;
            if(this.pregunta.equals(p.getPregunta())){
                return true;
            }
        }
        return false;
    }

}
