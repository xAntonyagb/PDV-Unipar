/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app.pdvutils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gabri
 */
public class GlobalVariables {
   public static String acessToken;
   
   private static final String USUARIO = "postgres";
   private static final String SENHA = "oitoletras8";
   private static final String ENDERECO = "jdbc:postgresql://localhost:5432/PDV-Unipar";
   private static Connection conn = null;
   
   public static Connection getConexao() {
        try{
            if(conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(ENDERECO, USUARIO, SENHA);
                return conn;
            }
            
            return conn;
        } catch(Exception ex) {
            conn = null;
            System.out.println("Erro ao abrir conexão");
        }
        
        return null;
    }
   
}
