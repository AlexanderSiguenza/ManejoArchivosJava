/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ujmd.manejoarchivos;

import java.io.*;

/**
 *
 * @author Alexander-Siguenza
 */
public class EscribeFichero {
    
    static String [] lista = new String[10]; // split
    static String rutaabsoluta = "\\archivos\\bitacora.txt"; 

    public static void main(String[] args) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String path = System.getProperty("user.dir"); // ruta relativa
            System.out.println("path :" + path);
            
            fichero = new FileWriter(path + rutaabsoluta , true);
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
