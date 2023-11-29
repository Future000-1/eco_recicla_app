package olave.hans.ecoreciclagroup.modelos;

public class Model_Aceite_Domestico {

    private String acumAceite, acumAgua, acumJabon;
    int valorcantidadlitros;

    public Model_Aceite_Domestico(String acumAceite, String acumAgua, String acumJabon, int valorcantidadlitros) {
        this.acumAceite = acumAceite;
        this.acumAgua = acumAgua;
        this.acumJabon = acumJabon;
        this.valorcantidadlitros = valorcantidadlitros;
    }

    public String getAcumAceite() {
        return acumAceite;
    }

    public void setAcumAceite(String acumAceite) {
        this.acumAceite = acumAceite;
    }

    public String getAcumAgua() {
        return acumAgua;
    }

    public void setAcumAgua(String acumAgua) {
        this.acumAgua = acumAgua;
    }

    public String getAcumJabon() {
        return acumJabon;
    }

    public void setAcumJabon(String acumJabon) {
        this.acumJabon = acumJabon;
    }

    public int getValorcantidadlitros() {
        return valorcantidadlitros;
    }

    public void setValorcantidadlitros(int valorcantidadlitros) {
        this.valorcantidadlitros = valorcantidadlitros;
    }
}