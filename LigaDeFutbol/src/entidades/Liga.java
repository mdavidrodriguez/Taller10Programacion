package entidades;

public class Liga {

    private String nombreEquipo;
    private int parJugados;
    private int parGanados;
    private int parEmpatadados;
    private int parPerdidos;
    private double puntosAcum;

    public Liga() {
    }

    public Liga(String nombreEquipo, int parJugados, int parGanados, int parEmpatadados, int parPerdidos, int puntosAcum) {
        this.nombreEquipo = nombreEquipo;
        this.parJugados = parJugados;
        this.parGanados = parGanados;
        this.parEmpatadados = parEmpatadados;
        this.parPerdidos = parPerdidos;
        this.puntosAcum = puntosAcum;
    }


    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getParJugados() {
        return parJugados;
    }

    public void setParJugados(int parJugados) {
        this.parJugados = parJugados;
    }

    public int getParGanados() {
        return parGanados;
    }

    public void setParGanados(int parGanados) {
        this.parGanados = parGanados;
    }

    public int getParEmpatadados() {
        return parEmpatadados;
    }

    public void setParEmpatadados(int parEmpatadados) {
        this.parEmpatadados = parEmpatadados;
    }

    public int getParPerdidos() {
        return parPerdidos;
    }

    public void setParPerdidos(int parPerdidos) {
        this.parPerdidos = parPerdidos;
    }

    public double getPuntosAcum() {
        return puntosAcum;
    }

    public void setPuntosAcum(double puntosAcum) {
        this.puntosAcum = puntosAcum;
    }

    public String getDatosArchivoTexto() {
        return this.nombreEquipo + ";"
                + this.parJugados + ";"
                + this.parGanados + ";"
                + this.parEmpatadados + ";"
                + this.parPerdidos + ";"
                + this.puntosAcum;
    }
}
