/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package livrarianavegador;

import java.sql.*;
import javax.swing.*;

public class LivrariaNavegador {
    
    public static void main(String[] args) throws Exception {
        // carregar driver JDBC
        Class.forName("com.mysql.jdbc.Driver");
        
        // obter conexao
        String url = "jdbc:mysql://localhost/Livraria";
        String user = "root";
        String passwd = "NOBELnobel1493*";
        Connection con = DriverManager.getConnection(url, user, passwd);
        
        // criar Statement
        Statement stmt = con.createStatement();
        
        // enviar query
        ResultSet rs = stmt.executeQuery("SELECT titulo,livro_id,autor, editora, ano, preco, estoque, reserva, "
                                        +   "livros.descricao, generos.descricao, capa "
                                        + "FROM livros "
                                        + "JOIN generos "
                                        + "USING(genero_ID);");
        
        // tratar os dados da query
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        
        JanelaPrincipal janelaLivraria = new JanelaPrincipal();
        //janelaLivraria.set;
        janelaLivraria.setResultQuery(rs);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });       
    }   
}
