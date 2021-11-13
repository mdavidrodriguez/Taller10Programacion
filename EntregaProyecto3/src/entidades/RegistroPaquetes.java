package entidades;

public class RegistroPaquetes {

    private String TipoPaquete;
    private int pesop;
    private int Largo;
    private int Ancho;
    private int Alto;
    private String volumen;
    private String TRepartidor;
    private double CodPostal;

    public RegistroPaquetes() {
    }

    public RegistroPaquetes(String TipoPaquete, int pesop, int Largo, int Ancho, int Alto, String volumen, String TRepartidor, double CodPostal) {
        this.TipoPaquete = TipoPaquete;
        this.pesop = pesop;
        this.Largo = Largo;
        this.Ancho = Ancho;
        this.Alto = Alto;
        this.volumen = volumen;
        this.TRepartidor = TRepartidor;
        this.CodPostal = CodPostal;
    }

    public String getTipoPaquete() {
        return TipoPaquete;
    }

    public void setTipoPaquete(String TipoPaquete) {
        this.TipoPaquete = TipoPaquete;
    }

    public int getPesop() {
        return pesop;
    }

    public void setPesop(int pesop) {
        this.pesop = pesop;
    }

    public int getLargo() {
        return Largo;
    }

    public void setLargo(int Largo) {
        this.Largo = Largo;
    }

    public int getAncho() {
        return Ancho;
    }

    public void setAncho(int Ancho) {
        this.Ancho = Ancho;
    }

    public int getAlto() {
        return Alto;
    }

    public void setAlto(int Alto) {
        this.Alto = Alto;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getTRepartidor() {
        return TRepartidor;
    }

    public void setTRepartidor(String TRepartidor) {
        this.TRepartidor = TRepartidor;
    }

    public double getCodPostal() {
        return CodPostal;
    }

    public void setCodPostal(double CodPostal) {
        this.CodPostal = CodPostal;
    }

    public String getDatosArchivoPaquetes() {
        return this.TipoPaquete + ";" + this.pesop + ";" + this.Largo + ";" + this.Ancho + ";" + this.Alto + ";" + this.volumen + ";" + this.TRepartidor + ";" + this.CodPostal;
    }
}
