package vista;

import datos.ArchivoDestinatarios;
import datos.ArchivoRemitentes;
import datos.ArchivoTPaquetes;
import entidades.RegistroD;
import entidades.RegistroR;
import entidades.RegistroPaquetes;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);
        ArchivoRemitentes archivo = new ArchivoRemitentes();
        RegistroR remitente = new RegistroR();
        System.out.println("Numero de paquete:");
        remitente.setNumPaquete(entrada.nextInt());
        System.out.println("Fecha Ingreso a Bodega(Dia/Mes/Ano)");
        remitente.setDia(entrada.nextInt());
        remitente.setMes(entrada.nextInt());
        remitente.setAno(entrada.nextInt());
        System.out.println("Nombre:");
        remitente.setNombre(datos.nextLine());
        System.out.println("Direccion(Calle/Carrera)");
        remitente.setCalleYCarrera(datos.nextLine());
        System.out.println("Telefono:");
        remitente.setTelefono(datos.nextLine());
        System.out.println("Pais:");
        remitente.setPais(datos.nextLine());
        System.out.println("Ciudad:");
        remitente.setCiudad(datos.nextLine());
        System.out.println("Numero de vivienda:");
        remitente.setNumVivienda(entrada.nextDouble());

        archivo.escribir(remitente);

        List<RegistroR> registrado = archivo.leer();
        imprimirLista(registrado);
    }

    public static void imprimirRegistroR(RegistroR r) {
        System.out.printf("%10d %10d %10d %10d %20s %20s %20s %15s %15s %15.2f%n", r.getNumPaquete(), r.getDia(), r.getMes(),
                r.getAno(), r.getNombre(), r.getCalleYCarrera(), r.getTelefono(), r.getPais(), r.getCiudad(), r.getNumVivienda());
    }

    public static void imprimirLista(List<RegistroR> lista) {
        for (RegistroR r : lista) {
            imprimirRegistroR(r);
        }
        
        System.out.println("\n");
        System.out.println("Datos del Destinatario");
        System.out.println("--------------------------------");
        Scanner entradad = new Scanner(System.in);
        Scanner datosd = new Scanner(System.in);
        ArchivoDestinatarios archivod = new ArchivoDestinatarios();
        
        RegistroD destinatario = new RegistroD();
        System.out.println("Numero de paquete Asignado:");
        destinatario.setNumPaquete(entradad.nextInt());
        System.out.println("Fecha aproximada de entrega(Dia/Mes/Ano)");
        destinatario.setDia(entradad.nextInt());
        destinatario.setMes(entradad.nextInt());
        destinatario.setAno(entradad.nextInt());
        System.out.println("Nombre:");
        destinatario.setNombre(datosd.nextLine());
        System.out.println("Direccion(Calle/Carrera)");
        destinatario.setCalleYCarrera(datosd.nextLine());
        System.out.println("Telefono:");
        destinatario.setTelefono(datosd.nextLine());
        System.out.println("Codigo Postal:");
        destinatario.setCodPostal(entradad.nextInt());
        System.out.println("Numero de vivienda:");
        destinatario.setNumVivienda(entradad.nextDouble());
        
        archivod.escribir(destinatario);

        List<RegistroD> registradod = archivod.leer();
        imprimirLista1(registradod);
    }
    
        public static void imprimirRegistroD(RegistroD rd) {
        System.out.printf("%10d %10d %10d %10d %20s %20s %15s %15d %15.0f%n", rd.getNumPaquete(), rd.getDia(), rd.getMes(),
                rd.getAno(), rd.getNombre(), rd.getCalleYCarrera(), rd.getTelefono(), rd.getCodPostal(), rd.getNumVivienda());
    }

    public static void imprimirLista1(List<RegistroD> lista) {
        for (RegistroD rd : lista) {
            imprimirRegistroD(rd);
        }
        
        
        
        Scanner valor = new Scanner(System.in);
        Scanner envio = new Scanner(System.in);
        ArchivoTPaquetes bodega = new ArchivoTPaquetes();
        RegistroPaquetes enviar = new RegistroPaquetes();
        System.out.println("Tipo de Paquete(Caja/Sobre)");
        enviar.setTipoPaquete(valor.nextLine());
        System.out.println("Peso:");
        enviar.setPesop(valor.nextInt());
        System.out.println("Largo:");
        enviar.setLargo(valor.nextInt());
        System.out.println("Acho:");
        enviar.setAncho(envio.nextInt());
        System.out.println("Alto:");
        enviar.setAlto(envio.nextInt());
        System.out.println("Volumen / No aplica");
        enviar.setVolumen(envio.nextLine());
        System.out.println("Tipo de repartidor:");
        enviar.setTRepartidor(envio.nextLine());
        System.out.println("Codigo Postal Asignado");
        enviar.setCodPostal(envio.nextDouble());
        
         bodega.escribir(enviar);

         List<RegistroPaquetes> registrado = bodega.leer();
        imprimirLista2(registrado);
        }
        public static void imprimirRegistroPaquetes(RegistroPaquetes tp) {
        System.out.printf("%10s %10d %10d %10d %10d %10s %10s %20.1f%n", tp.getTipoPaquete(), tp.getPesop(), tp.getLargo(), tp.getAncho(),
                tp.getAlto(), tp.getVolumen(), tp.getTRepartidor(), tp.getCodPostal());
    }

    public static void imprimirLista2(List<RegistroPaquetes> lista) {
        for (RegistroPaquetes tp : lista) {
            imprimirRegistroPaquetes(tp);
        

    }
       
}
}
