/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.de.estoque.sqlite;

import java.sql.SQLException;

/**
 *
 * @author vitorbrito
 */
public class ControleDeEstoqueSQLite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Conexao dbCon = new Conexao();
        dbCon.initDB();
        //new Cadastro().setVisible(true);
        
        new Janela().setVisible(true);
               
    }
}

//Cria um novo objeto da classe SQLite para executar os comandos SQL, assim pode-se usar o this na classe.
//
//SQLite dbCon = new SQLite("dados.sqlite");
//            dbCon.atualizaCliente();
//Conexao dbCon = new Conexao();




