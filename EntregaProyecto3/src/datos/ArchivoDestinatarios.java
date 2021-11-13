
package datos;

import entidades.RegistroD;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoDestinatarios {

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoDestinatarios() {
        this.archivo = new File("ArchivoDestinatario.dat");
    }

    public ArchivoDestinatarios(String name) {
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

    public RegistroD leerRegistroD(String linea[]) {
        RegistroD rd = new RegistroD();
        rd.setNumPaquete(Integer.valueOf(linea[0]));
        rd.setDia(Integer.valueOf(linea[1]));
        rd.setMes(Integer.valueOf(linea[2]));
        rd.setAno(Integer.valueOf(linea[3]));
        rd.setNombre(linea[4]);
        rd.setCalleYCarrera(linea[5]);
        rd.setTelefono(linea[6]);
        rd.setCodPostal(Integer.valueOf(linea[7]));
        rd.setNumVivienda(Double.valueOf(linea[8]));
        return rd;

    }

    public List<RegistroD> leer() {
        List<RegistroD> lista = null;
        try {
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while (this.aLectura.hasNext()) {
                String linea[] = this.aLectura.nextLine().split(";");
                RegistroD rd = this.leerRegistroD(linea);
                lista.add(rd);
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
    public boolean escribir(RegistroD rd) {

        PrintWriter escritor = null;
        boolean exito = false;
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(rd.getDatosArchivoDestinatario());
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
