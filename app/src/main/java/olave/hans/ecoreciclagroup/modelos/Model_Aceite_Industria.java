package olave.hans.ecoreciclagroup.modelos;

public class Model_Aceite_Industria {

    private String acumAceite, acumagua, acumJabon;
    int  valorcantidadlitros;


    public Model_Aceite_Industria(String acumAceite, String acumagua, String acumJabon, int valorcantidadlitros) {
        this.acumAceite = acumAceite;
        this.acumagua = acumagua;
        this.acumJabon = acumJabon;
        this.valorcantidadlitros = valorcantidadlitros;
    }

    public String getAcumAceite() {
        return acumAceite;
    }

    public void setAcumAceite(String acumAceite) {
        this.acumAceite = acumAceite;
    }

    public String getAcumagua() {
        return acumagua;
    }

    public void setAcumagua(String acumagua) {
        this.acumagua = acumagua;
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
