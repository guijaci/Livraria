/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package livrarianavegador;

import java.sql.*;
import java.io.*;

public class LivrariaNavegador {
    
    public static void main(String[] args) throws SQLException {

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException cnf) {
		System.out.println("Driver nao carregado");
		System.exit(0);
	}

	try {
		// estabelecimento da conexao
		/*String url = "jdbc:postgresql://localhost/livraria";
		String usuario = "postgres";
		String senha = "1234";*/
		String url = "jdbc:mysql://localhost/Livraria";
		String usuario = "root";
		String senha = "NOBELnobel1493*";

		Connection con = DriverManager.getConnection(url, usuario, senha);

		PreparedStatement pstmt = con.prepareStatement("update LIVROS set capa = ? where livro_id = ?");

		for (int cont = 1; cont <= 16; cont++) {
			File file = new File(cont+".gif");
			FileInputStream inputImage = new FileInputStream(file);
			pstmt.setBinaryStream(1, inputImage, (int)(file.length()));
			pstmt.setInt(2,cont);
			pstmt.executeUpdate();
			System.out.println("Atualizado livro "+cont);
		}

		con.close();

	} catch (Exception sql2) {
		System.out.println(sql2);
		sql2.printStackTrace();
	}

}
}
