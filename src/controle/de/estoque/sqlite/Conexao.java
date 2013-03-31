/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.de.estoque.sqlite;

import controle.de.estoque.sqlite.Conexao;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.misc.Cleaner;

/**
 *
 * @author vitorbrito
 */
public class Conexao {

    private Connection conn;
    private Statement stm;
    public static String ClienteAntesEditar;
    public static int total;
    

    public void SQLite() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + "estoque.sqlite");
        this.stm = conn.createStatement();
    }

    public void initDB() throws SQLException, ClassNotFoundException {

        this.SQLite();
        //Remove e cria a tabela a cada execução. Mero exemplo			
        this.stm.executeUpdate("CREATE TABLE IF NOT EXISTS produtos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome varchar(40),"
                + "quant integer,"
                + "descricao varchar(300))");

        //JOptionPane.showMessageDialog(null, "Banco Iniciado");
    }

    public String getConnection() throws SQLException, ClassNotFoundException {
        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos";
        ResultSet rs = stm.executeQuery(sql);

        Vector objeto = new Vector();
        while (rs.next()) {
            objeto.add(rs.getString("nome"));

        }
        
        System.out.println(objeto.size());
        
        
        System.out.println(objeto.toString());
        
        return objeto.toString();
    }

    public void cadastrarProduto(String NomeProduto, String QuantProduto, String DescProduto) throws SQLException, ClassNotFoundException {

        this.SQLite();
        this.stm = this.conn.createStatement();
        this.stm.executeUpdate("INSERT INTO produtos VALUES ("
                + "null"
                + ",'" + NomeProduto
                + "','" + QuantProduto
                + "','" + DescProduto + "');");

        JOptionPane.showMessageDialog(null, "Valores inseridos com sucesso.");

    }
}
//public static String getConnection(String comand) throws SQLException {
//    
//        try {
//            //Class.forName(DRIVER_POSTGRE); // Carrega driver do banco de dados
//            //conexao = DriverManager.getConnection(URL_POSTGRE);
//            //Statement stm = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//            //Nesta linha deve ser confeccionado o comando SQL.
//            //comand = "SELECT * FROM alunos";
//            comand = "SELECT * FROM alunos";
//        String sql = "" + comand; //query para selecionar o tipo de produto digitado pelo usuário
//
//        ResultSet rs = stm.executeQuery(sql);
//
//        Vector objeto = new Vector();
//        while (rs.next()) {
//            objeto.add(rs.getArray("cidade"));
//
//        }
//
//        resultado = objeto.toString();
//        System.out.println("Resultado: " + resultado);
//
//        return objeto.toString();
//    }
//    catch (ClassNotFoundException ex
//
//    
//        ) {
//            System.out.println("Não Conectou" + ex.getMessage());
//        ex.printStackTrace();
//        return ex.getMessage();
//    }
//}
//}
//
//    
//    
//    final static String DRIVER_POSTGRE = "org.postgresql.Driver";
//    final static String URL_POSTGRE = "jdbc:postgresql://localhost:5432/vitorbrito?user=vitorbrito&password=vitor";
//    private static Connection conexao = null;
//    public static String comand = null;
//    public static String resultado;
//    public static Vector objeto = new Vector();
//
//    public static String getConnection(String comand) throws SQLException {
//        try {
//            Class.forName(DRIVER_POSTGRE); // Carrega driver do banco de dados
//            conexao = DriverManager.getConnection(URL_POSTGRE);
//            Statement stm = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//            //Nesta linha deve ser confeccionado o comando SQL.
//            //comand = "SELECT * FROM alunos";
//            comand = "SELECT * FROM alunos";
//            String sql = "" + comand; //query para selecionar o tipo de produto digitado pelo usuário
//
//            ResultSet rs = stm.executeQuery(sql);
//
//            Vector objeto = new Vector();
//            while (rs.next()) {
//                objeto.add(rs.getArray("cidade"));
//
//            }
//
//            resultado = objeto.toString();
//            System.out.println("Resultado: " + resultado);
//
//            return objeto.toString();
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Não Conectou" + ex.getMessage());
//            ex.printStackTrace();
//            return ex.getMessage();
//        }
//    }
//
//    public static String getSenha(String usuario) throws SQLException {
//        try {
//            Class.forName(DRIVER_POSTGRE); // Carrega driver do banco de dados
//            conexao = DriverManager.getConnection(URL_POSTGRE);
//            Statement stm = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//
//            String sql = "SELECT senha FROM logins WHERE login = '" + usuario + "'";
//
//            ResultSet rs = stm.executeQuery(sql);
//
//            Vector objeto = new Vector();
//            while (rs.next()) {
//                objeto.add(rs.getArray("senha"));
//
//            }
//
//            resultado = objeto.toString();
//            return resultado;
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Não Conectou" + ex.getMessage());
//            ex.printStackTrace();
//            return ex.getMessage();
//        }
//    }
//
//    public static String cadastrar(String comand) throws SQLException {
//        try {
//            Class.forName(DRIVER_POSTGRE); // Carrega driver do banco de dados
//            conexao = DriverManager.getConnection(URL_POSTGRE);
//            Statement stm = conexao.createStatement();
//
//            stm.execute(comand);
//            
//            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
//
//            return null;
//
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Não Conectou" + ex.getMessage());
//            ex.printStackTrace();
//            return ex.getMessage();
//        }
//    }
//}
//
//
///*
// 
//
//package sistemavendas;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.postgresql.*;
//
//public class Conexao {
//
//    final static String DRIVER_POSTGRE = "org.postgresql.Driver";
//    final static String URL_POSTGRE = "jdbc:postgresql://localhost:5432/vitorbrito?user=vitorbrito&password=vitor";
//    private static Connection conexao = null;
//    public static String comand = null;
//    public static String resultado;
//    public static Vector objeto = new Vector();
//
//    public static String getConnection(String comand) throws SQLException {
//        try {
//            Class.forName(DRIVER_POSTGRE); // Carrega driver do banco de dados
//            conexao = DriverManager.getConnection(URL_POSTGRE);
//            System.out.println("oioioi");
//            comand = Buscar.comandoSQL;
//
//            Statement stm = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//            String sql = "" + comand; //query para selecionar o tipo de produto digitado pelo usuário
//            ResultSet rs = stm.executeQuery(sql);
//
//            Vector objeto = new Vector();
//            while (rs.next()) {
//                objeto.add(rs.getArray("nome_produto"));
//
//            }
//
//            resultado = objeto.toString();
//            System.out.println("Resultado: " + resultado);
//
//            return objeto.toString();
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Não Conectou" + ex.getMessage());
//            ex.printStackTrace();
//            return ex.getMessage();
//        }
//    }
//}
////    @SuppressWarnings("static-access")
////    public static void main(String args[]) {
////        try {
////            new Conexao().getConnection();
////        } catch (SQLException ex) {
////            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
////            System.out.println("mensagem: " + ex.getMessage());
////
////        }
////    }
// 
// 
// */