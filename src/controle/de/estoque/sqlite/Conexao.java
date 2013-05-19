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
import java.text.SimpleDateFormat;
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
    public static int total;

    public void SQLite() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + "estoque.sqlite");
        this.stm = conn.createStatement();
    }

    public void initDB() throws SQLException, ClassNotFoundException {

        this.SQLite();
        //Se não existe, cria as tabelas a cada execução.		
        this.stm.executeUpdate("CREATE TABLE IF NOT EXISTS produtos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome varchar(40),"
                + "quant integer,"
                + "descricao varchar(300))");

        this.stm.executeUpdate("CREATE TABLE IF NOT EXISTS login ("
                + "usuario varchar(30) PRIMARY KEY,"
                + "senha varchar(30))");

        this.stm.executeUpdate("CREATE TABLE IF NOT EXISTS historico ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "idproduto INTEGER,"
                + "nome varchar(40),"
                + "quant_anterior INTEGER,"
                + "quant_alterada INTEGER,"
                + "quant_atual INTEGER,"
                + "data timestamp)");

//        this.stm.executeUpdate("INSERT INTO login VALUES('vitor','mateus')");

//        this.stm.execute("DROP TABLE produtos");
//        this.stm.execute("DROP TABLE login");
//       this.stm.execute("DROP TABLE historico");

        //JOptionPane.showMessageDialog(null, "Banco Iniciado");

        this.stm.close();

    }

    public void cadastrarProduto(String NomeProduto, String QuantProduto, String DescProduto) throws SQLException, ClassNotFoundException {

        this.SQLite();
        this.stm = this.conn.createStatement();
        this.stm.executeUpdate("INSERT INTO produtos VALUES ("
                + "null"
                + ",'" + NomeProduto
                + "','" + QuantProduto
                + "','" + DescProduto + "');");

        //JOptionPane.showMessageDialog(null, "Valores inseridos com sucesso.");

        this.stm.close();
    }

    public String getTabelaEstoque() throws SQLException, ClassNotFoundException {

        Vector id = new Vector();
        Vector nome = new Vector();
        Vector quant = new Vector();
        Vector descri = new Vector();

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos";
        ResultSet rs = stm.executeQuery(sql);


        while (rs.next()) {
            id.add(rs.getString("id"));
            nome.add(rs.getString("nome"));
            quant.add(rs.getString("quant"));
            descri.add(rs.getString("descricao"));
        }

        rs.close();

        Janela.fieldFiltro.setText(""); //Apenas para limpar o campo do Filtro.

        int rows = Janela.tabelaEstoque.getRowCount();

        for (int i = 0; i < rows; i++) {
            ((DefaultTableModel) Janela.tabelaEstoque.getModel()).removeRow(0);
        }

        int tamanhoVetor = nome.size();

        for (int i = 0; i < tamanhoVetor; i++) {
            ((DefaultTableModel) Janela.tabelaEstoque.getModel()).addRow(new String[]{id.get(i).toString(), nome.get(i).toString(), quant.get(i).toString(), descri.get(i).toString()});
        }
        return null;
    }

    public String getListaProdutos() throws SQLException, ClassNotFoundException {

        Vector id = new Vector();
        Vector nome = new Vector();
        Vector quant = new Vector();
        Vector descri = new Vector();

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos";
        ResultSet rs = stm.executeQuery(sql);


        while (rs.next()) {
            id.add(rs.getString("id"));
            nome.add(rs.getString("nome"));
            quant.add(rs.getString("quant"));
            descri.add(rs.getString("descricao"));
        }

        rs.close();

        int rows = ListaProdutos.tabelaListaProdutos.getRowCount();

        for (int i = 0; i < rows; i++) {
            ((DefaultTableModel) ListaProdutos.tabelaListaProdutos.getModel()).removeRow(0);
        }

        int tamanhoVetor = nome.size();

        for (int i = 0; i < tamanhoVetor; i++) {
            ((DefaultTableModel) ListaProdutos.tabelaListaProdutos.getModel()).addRow(new String[]{id.get(i).toString(), nome.get(i).toString(), quant.get(i).toString(), descri.get(i).toString()});
        }
        return null;
    }

    public String filtrarListaProdutos(String filtro) throws SQLException, ClassNotFoundException {

        Vector id = new Vector();
        Vector nome = new Vector();
        Vector quant = new Vector();
        Vector descri = new Vector();

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos WHERE nome LIKE '" + filtro + "%'";
        ResultSet rs = stm.executeQuery(sql);


        while (rs.next()) {
            id.add(rs.getString("id"));
            nome.add(rs.getString("nome"));
            quant.add(rs.getString("quant"));
            descri.add(rs.getString("descricao"));
        }

        rs.close();

        int rows = ListaProdutos.tabelaListaProdutos.getRowCount();

        for (int i = 0; i < rows; i++) {
            ((DefaultTableModel) ListaProdutos.tabelaListaProdutos.getModel()).removeRow(0);
        }

        int tamanhoVetor = nome.size();

        for (int i = 0; i < tamanhoVetor; i++) {
            ((DefaultTableModel) ListaProdutos.tabelaListaProdutos.getModel()).addRow(new String[]{id.get(i).toString(), nome.get(i).toString(), quant.get(i).toString(), descri.get(i).toString()});
        }
        return null;
    }

    public String filtrarTabelaEstoque(String filtro) throws SQLException, ClassNotFoundException {

        Vector id = new Vector();
        Vector nome = new Vector();
        Vector quant = new Vector();
        Vector descri = new Vector();

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos WHERE nome LIKE '" + filtro + "%'";
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            id.add(rs.getString("id"));
            nome.add(rs.getString("nome"));
            quant.add(rs.getString("quant"));
            descri.add(rs.getString("descricao"));
        }

        rs.close();

        int rows = Janela.tabelaEstoque.getRowCount();

        for (int i = 0; i < rows; i++) {
            ((DefaultTableModel) Janela.tabelaEstoque.getModel()).removeRow(0);
        }

        int tamanhoVetor = nome.size();

        for (int i = 0; i < tamanhoVetor; i++) {
            ((DefaultTableModel) Janela.tabelaEstoque.getModel()).addRow(new String[]{id.get(i).toString(), nome.get(i).toString(), quant.get(i).toString(), descri.get(i).toString()});
        }
        return null;
    }

    public String getTabelaCadastro() throws SQLException, ClassNotFoundException {

        Vector id = new Vector();
        Vector nome = new Vector();
        Vector descri = new Vector();

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos";
        ResultSet rs = stm.executeQuery(sql);


        while (rs.next()) {
            id.add(rs.getString("id"));
            nome.add(rs.getString("nome"));
            descri.add(rs.getString("descricao"));
        }

        Janela.fieldFiltroCadastro.setText(""); //Apenas para limpar o filtro da aba de Cadastro.
        
        rs.close();

        int rows = Janela.tabelaCadastro.getRowCount();

        for (int i = 0; i < rows; i++) {
            ((DefaultTableModel) Janela.tabelaCadastro.getModel()).removeRow(0);
        }

        int tamanhoVetor = nome.size();

        for (int i = 0; i < tamanhoVetor; i++) {
            ((DefaultTableModel) Janela.tabelaCadastro.getModel()).addRow(new String[]{id.get(i).toString(), nome.get(i).toString(), descri.get(i).toString()});
        }
        return null;
    }

    public String filtrarTabelaCadastro(String filtro) throws SQLException, ClassNotFoundException {

        Vector id = new Vector();
        Vector nome = new Vector();
        Vector descri = new Vector();

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos WHERE nome LIKE '" + filtro + "%'";
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            id.add(rs.getString("id"));
            nome.add(rs.getString("nome"));
            descri.add(rs.getString("descricao"));
        }

        rs.close();

        int rows = Janela.tabelaCadastro.getRowCount();

        for (int i = 0; i < rows; i++) {
            ((DefaultTableModel) Janela.tabelaCadastro.getModel()).removeRow(0);
        }

        int tamanhoVetor = nome.size();

        for (int i = 0; i < tamanhoVetor; i++) {
            ((DefaultTableModel) Janela.tabelaCadastro.getModel()).addRow(new String[]{id.get(i).toString(), nome.get(i).toString(), descri.get(i).toString()});
        }
        return null;
    }

    public String getSenha(String usuario) throws SQLException, ClassNotFoundException {
        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT senha FROM login WHERE usuario = '" + usuario + "'";
        //String sql = "SELECT senha FROM login";

        ResultSet rs = stm.executeQuery(sql);

        Vector objeto = new Vector();

        while (rs.next()) {
            objeto.add(rs.getString("senha"));
        }

        rs.close();

        String resultado = objeto.toString();
        return resultado;
    }

    public String getProduto(String id) throws SQLException, ClassNotFoundException {

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos WHERE id = '" + id + "'";
        //String sql = "SELECT senha FROM login";

        ResultSet rs = stm.executeQuery(sql);

        String nome = rs.getString("nome");
        String quantAtual = rs.getString("quant");
        String descricao = rs.getString("descricao");

        Janela.labelNomeProduto.setText(nome);
        Janela.labelQuantProduto.setText(quantAtual);
        Janela.labelIDProduto.setText(id);

        this.stm.close();

        return null;
    }

    public String getProdutoAtualizar(String id) throws SQLException, ClassNotFoundException {

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM produtos WHERE id = '" + id + "'";
        //String sql = "SELECT senha FROM login";

        ResultSet rs = stm.executeQuery(sql);

        String nome = rs.getString("nome");
        String descricao = rs.getString("descricao");

        EditarProduto.labelIDProduto.setText(id);
        EditarProduto.fieldNomeAtualizar.setText(nome);
        EditarProduto.areaDescAtualizar.setText(descricao);

        this.stm.close();

        return null;
    }

    public void atualizarProduto(String id, String nome, String descricao) throws SQLException, ClassNotFoundException {
        this.SQLite();

        String comandSQL = ("UPDATE produtos SET nome = '" + nome + "'"
                + ",descricao = '" + descricao + "'"
                + " WHERE id = " + id + ";");

        this.stm.execute(comandSQL);

        this.stm.close();

    }

    public void excluirProduto(String id) throws SQLException, ClassNotFoundException {
        this.SQLite();

        String comandSQL = ("DELETE FROM produtos WHERE id = " + id);
        this.stm.execute(comandSQL); //Exclui o prduto da tabela de estoque (produtos).
        this.stm.close();

//        comandSQL = ("DELETE FROM produtos WHERE id = " + id);
//        this.stm.execute(comandSQL); //Exclui da tabe de historico.
//        this.stm.close();

    }

    public void modificarEstoque(String id, Integer quant) throws SQLException, ClassNotFoundException {
        this.SQLite();

        String comandSQL = ("UPDATE produtos SET quant = " + quant.toString() + " WHERE id = " + id + ";");

        this.stm.execute(comandSQL);

        this.stm.close();

    }

    public void registrarHistorico(String idProduto, String nomeProduto, String quantAnterior, String quantAlterada, String quantAtual) throws SQLException, ClassNotFoundException {

        Date dataHoje = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String data = (formatarDate.format(dataHoje)).toString();

        this.SQLite();
        this.stm = this.conn.createStatement();
        this.stm.executeUpdate("INSERT INTO historico VALUES ("
                + "null"
                + "," + idProduto
                + ",'" + nomeProduto
                + "','" + quantAnterior
                + "','" + quantAlterada
                + "','" + quantAtual
                + "','" + data
                + "');");

        //JOptionPane.showMessageDialog(null, "Valores inseridos com sucesso.");

        this.stm.close();
    }
    
    public String getTabelaHistorico() throws SQLException, ClassNotFoundException {

        Vector idproduto = new Vector();
        Vector nome = new Vector();
        Vector quantAnterior = new Vector();
        Vector quantAlterada = new Vector();
        Vector quantAtual = new Vector();
        Vector data = new Vector();

        this.SQLite();
        this.stm = this.conn.createStatement();

        String sql = "SELECT * FROM historico";
        ResultSet rs = stm.executeQuery(sql);


        while (rs.next()) {
            idproduto.add(rs.getString("id"));
            nome.add(rs.getString("nome"));
            quantAnterior.add(rs.getString("quant_anterior"));
            quantAlterada.add(rs.getString("quant_alterada"));
            quantAtual.add(rs.getString("quant_atual"));
            data.add(rs.getString("data"));
        }

        rs.close();

        int rows = Janela.tabelaHistorico.getRowCount();

        for (int i = 0; i < rows; i++) {
            ((DefaultTableModel) Janela.tabelaHistorico.getModel()).removeRow(0);
        }

        int tamanhoVetor = nome.size();

        for (int i = 0; i < tamanhoVetor; i++) {
            ((DefaultTableModel) Janela.tabelaHistorico.getModel()).addRow(new String[]{
                        idproduto.get(i).toString(),
                        nome.get(i).toString(),
                        quantAnterior.get(i).toString(),
                        quantAlterada.get(i).toString(),
                        quantAtual.get(i).toString(),
                        data.get(i).toString()});
        }
        return null;
    }
    
}
