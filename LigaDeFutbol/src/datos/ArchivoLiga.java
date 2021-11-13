package datos;

import entidades.Liga;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoLiga {

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoLiga() {
        this.archivo = new File("Ligas de futbol.dat");
    }

    public ArchivoLiga(String name) {
        this.archivo = new File(name);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileWriter getaEscritura() {
        return aEscritura;
    }

    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    public Scanner getaLectura() {
        return aLectura;
    }

    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }

    public Liga leerLiga(String linea[]) {
        Liga l = new Liga();
        l.setNombreEquipo(linea[0]);
        l.setParJugados(Integer.valueOf(linea[1]));
        l.setParGanados(Integer.valueOf(linea[2]));
        l.setParPerdidos(Integer.valueOf(linea[3]));
        l.setParEmpatadados(Integer.valueOf(linea[4]));
        l.setPuntosAcum(Double.valueOf(linea[5]));
        return l;

    }

    public List<Liga> leer() {
        List<Liga> lista = null;

        try {
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while (this.aLectura.hasNext()) {
                String linea[] = this.aLectura.nextLine().split(";");
                Liga l = this.leerLiga(linea);
                lista.add(l);
            }
            return lista;

        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer el archivo");
            return null;
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();

            }
        }

    }

    public boolean escribir(Liga l) {

        PrintWriter escritor = null;
        boolean exito = false;
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(l.getDatosArchivoTexto());
            exito = true;

        } catch (IOException ioe) {
            System.out.println("Error al abrir el archvio en modo escritura");
            exito = false;
        } finally {
            if (escritor != null) {
                escritor.close();
            }

            if (this.aEscritura != null) {
                try {
                    this.aEscritura.close();
                } catch (IOException io) {
                    System.out.println(io);
                }
            }

            return exito;
        }

    }
}
