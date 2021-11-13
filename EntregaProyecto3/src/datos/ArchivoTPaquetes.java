package datos;

import entidades.RegistroR;
import entidades.RegistroPaquetes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoTPaquetes {

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoTPaquetes() {
        this.archivo = new File("ArchivoPaquetes.dat");
    }

    public ArchivoTPaquetes(String name) {
        this.archivo = new File(name);
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the aEscritura
     */
    public FileWriter getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    /**
     * @return the aLectura
     */
    public Scanner getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }

    public RegistroPaquetes leerRegistroPaquetes(String linea[]) {
        RegistroPaquetes tp = new RegistroPaquetes();
        tp.setTipoPaquete(linea[0]);
        tp.setPesop(Integer.valueOf(linea[1]));
        tp.setLargo(Integer.valueOf(linea[2]));
        tp.setAncho(Integer.valueOf(linea[3]));
        tp.setAlto(Integer.valueOf(linea[4]));
        tp.setVolumen(linea[5]);
        tp.setTRepartidor(linea[6]);
        tp.setCodPostal(Double.valueOf(linea[7]));
        return tp;

    }

    public List<RegistroPaquetes> leer() {
        List<RegistroPaquetes> lista = null;
        try {
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while (this.aLectura.hasNext()) {
                String linea[] = this.aLectura.nextLine().split(";");
                RegistroPaquetes tp = this.leerRegistroPaquetes(linea);
                lista.add(tp);
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

    public boolean escribir(RegistroPaquetes tp) {

        PrintWriter escritor = null;
        boolean exito = false;
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(tp.getDatosArchivoPaquetes());
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
