package olave.hans.ecoreciclagroup.modelos;

public class Model_Aceite_Hidraulico {

    private  String acumaceite, acumagua, acumjabon;
    int valorcantidadlitros;

    public Model_Aceite_Hidraulico(String acumaceite, String acumagua, String acumjabon, int valorcantidadlitros) {
        this.acumaceite = acumaceite;
        this.acumagua = acumagua;
        this.acumjabon = acumjabon;
        this.valorcantidadlitros = valorcantidadlitros;
    }


    public String getAcumaceite() {
        return acumaceite;
    }

    public void setAcumaceite(String acumaceite) {
        this.acumaceite = acumaceite;
    }

    public String getAcumagua() {
        return acumagua;
    }

    public void setAcumagua(String acumagua) {
        this.acumagua = acumagua;
    }

    public String getAcumjabon() {
        return acumjabon;
    }

    public void setAcumjabon(String acumjabon) {
        this.acumjabon = acumjabon;
    }

    public int getValorcantidadlitros() {
        return valorcantidadlitros;
    }

    public void setValorcantidadlitros(int valorcantidadlitros) {
        this.valorcantidadlitros = valorcantidadlitros;
    }
}
