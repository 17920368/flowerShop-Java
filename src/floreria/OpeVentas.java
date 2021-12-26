/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floreria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Rodriguez
 */
public class OpeVentas {
    String consulta1="";
    String consulta2="";
  public void Escritura(String nomArchivo, ventas al) {
        try {
            FileWriter fw = new FileWriter(nomArchivo, true);
            BufferedWriter archivoEscritura = new BufferedWriter(fw);
            String guardar = al.toString();
            archivoEscritura.write(guardar);
            archivoEscritura.newLine();//como salto de linea
            archivoEscritura.flush();//para borrar el bufferedWrite
            archivoEscritura.close();//cierra el archivo
        } catch (IOException e) {
            System.out.println(e);

        }

    }
  public String Lectura(String nomArchivo) {
        String cadena = "", datos = "";
        FileReader fr;

        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            ventas al = new ventas();
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                al.setNomCliente(st.nextToken());
                datos += "El nombre del cliente es: "+al.getNomCliente() + "\n";
                cadena = archivoLectura.readLine();

            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();

        }
        return datos;
    }
    public ventas buscarObj(String nomArchivo, String f) {
        String datos="";
            ventas al = new ventas();
            String cadena = "";
            FileReader fr;
            try {
                fr = new FileReader(nomArchivo);
                BufferedReader archivoLectura = new BufferedReader(fr);
                cadena = archivoLectura.readLine();
                while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                String cliente = st.nextToken();
                String fe = st.nextToken();
                String tipopago = st.nextToken();
                float importe = Float.parseFloat(st.nextToken());
                int arreglo = Integer.parseInt(st.nextToken());
                int pedido = Integer.parseInt(st.nextToken());
                if (f.equals(fe)) {
                    al.setNomCliente(cliente);
                    al.setFecha(fe);
                    al.setTipoPago(tipopago);
                    al.setImporte(importe);
                    al.setArreglo(arreglo);
                    al.setNumPedido(pedido);
                    this.consulta1+=al.toString();
                    return al;
                    }

                    cadena = archivoLectura.readLine();
                }
                archivoLectura.close();

            } catch (FileNotFoundException e) {
                System.out.println("No se encuentra el archivo");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("No se puede leer el archivo");
                e.printStackTrace();

            }
            return al;
        }
    public ventas consulta3(String nomArchivo, String nom) {
            ventas al = new ventas();
            String cadena = "";
            FileReader fr;
            try {
                fr = new FileReader(nomArchivo);
                BufferedReader archivoLectura = new BufferedReader(fr);
                cadena = archivoLectura.readLine();
                while (cadena != null) {
                    StringTokenizer st = new StringTokenizer(cadena, ",");
                    String cliente = st.nextToken();
                    if (nom.equals(cliente)) {
                        al.setNomCliente(cliente);
                        al.setFecha(st.nextToken());
                        al.setTipoPago(st.nextToken());
                        al.setImporte(Float.parseFloat(st.nextToken()));
                        al.setArreglo(Integer.parseInt(st.nextToken()));
                        al.setNumPedido(Integer.parseInt(st.nextToken()));
                        this.consulta2+=al.toString();
                        return al;
                    }

                    cadena = archivoLectura.readLine();
                }
                archivoLectura.close();

            } catch (FileNotFoundException e) {
                System.out.println("No se encuentra el archivo");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("No se puede leer el archivo");
                e.printStackTrace();

            }
            return al;
        }
public float verificarcliente(String nomArchivo, String nomCliente, float imp) {
        String cadena = "", datos = "";
        float pagoFinal = 0;
        FileReader fr;

        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            ventas al = new ventas();
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                String cliente = st.nextToken();
                if (nomCliente.equals(cliente)) {
                    String fe = st.nextToken();
                    String tipopago = st.nextToken();
                    float importe = Float.parseFloat(st.nextToken());
                    int arreglo = Integer.parseInt(st.nextToken());
                    int pedido = Integer.parseInt(st.nextToken());
                    arreglos a = new arreglos();
                    // if(pedido==codigo){
                    if (tipopago.equals("efectivo")) {
                        float descuento = (imp * 10) / 100;
                        pagoFinal = imp - descuento;
                        JOptionPane.showMessageDialog(null, "El cliente: " + cliente + " ya habia registrado una venta anterior."
                                + "\nPor lo que se le hizo un descuento del 10% " + "\nYa que realizo un tipo de pago efectivo"
                                + "\nEl pago sin descuento es: " + imp + "\nEl pago final con descuesto es: " + pagoFinal);
                    } else if (tipopago.equals("tarjeta de credito") || tipopago.equals("tarjeta")) {
                        float descuento = (imp * 15) / 100;
                        pagoFinal = imp - descuento;
                        JOptionPane.showMessageDialog(null, "El cliente: " + cliente + " ya habia registrado una venta anterior."
                                + "\nPor lo que se le hizo un descuento del 15% " + "\nYa que realizo un tipo de pago con tarjeta."
                                + "\nEl pago sin descuento es: " + imp + "\nEl pago final con descuesto es: " + pagoFinal);
                        // }
                    }
                    //datos+=al.toString()+"\n";
                }
                cadena = archivoLectura.readLine();

            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();

        }
        return pagoFinal;
    }
    
    public String getConsulta1() {
        return consulta1;
    }

    public String getConsulta2() {
        return consulta2;
    }
    
    
    
    
    
    
   
    
    
}
