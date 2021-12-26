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

/**
 *
 * @author Victor Rodriguez
 */
public class OpeArreglos {
    public void Escritura(String nomArchivo, arreglos al) {
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
        String cadena = "", datos="";
        FileReader fr;

        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            arreglos al = new arreglos();
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                al.setCodigo(Integer.parseInt(st.nextToken()));
                al.setNomArreglo(st.nextToken());
                al.setPrecio(Float.parseFloat(st.nextToken()));
                //System.out.println(al.toString());
               // datos+=al.toString()+"\n";
                datos+="El codigo del arreglo es: "+al.getCodigo()+"\nNombre: "+al.getNomArreglo()+"\nEl precio: "+al.getPrecio()+"\n-------------------------------------\n";
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
    
}
