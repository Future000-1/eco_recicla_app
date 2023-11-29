package olave.hans.ecoreciclagroup.modelos;

public class Usuario {


    private String edNombre, edcorreo,edContrasena;


    public Usuario(String edNombre, String edcorreo, String edContrasena) {
        this.edNombre = edNombre;
        this.edcorreo = edcorreo;
        this.edContrasena = edContrasena;
    }

    public String getEdNombre() {
        return edNombre;
    }

    public void setEdNombre(String edNombre) {
        this.edNombre = edNombre;
    }

    public String getEdcorreo() {
        return edcorreo;
    }

    public void setEdcorreo(String edcorreo) {
        this.edcorreo = edcorreo;
    }

    public String getEdContrasena() {
        return edContrasena;
    }

    public void setEdContrasena(String edContrasena) {
        this.edContrasena = edContrasena;
    }
}
