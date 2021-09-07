/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ujmd.manejoarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Alexander-Siguenza
 */
public class Archivos {

    public String[] LeeFichero(String rutaabsoluta) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String[] lista = new String[10]; // split 

        try {
            String path = System.getProperty("user.dir"); // ruta relativa
            System.out.println("path :" + path);

            // Apertura del fichero y creacion de BufferedReader para poder 
            // hacer una lectura comoda (disponer del metodo readLine()). 
            archivo = new File(path + rutaabsoluta); // ruta absoluta
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero 
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lista[i] = linea;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos 
            // que se cierra tanto si todo va bien como si salta
            // una excepcion. 
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lista;
    }

    public void EscribeFichero(String rutaabsoluta, String valor) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String path = System.getProperty("user.dir"); // ruta relativa
            System.out.println("path :" + path);

            fichero = new FileWriter(path + rutaabsoluta, true);
            pw = new PrintWriter(fichero);
            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero. 
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
