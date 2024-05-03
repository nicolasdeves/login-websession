/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author nicolas.deves
 */
public class DaoLogin {
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login", "root", "");
             
        } catch (Exception e) {
            System.out.println(con);
            System.out.println(e);

        }
        System.out.println(con);
        System.out.println("Conexão com MYSQL realizada!");
        return con;
    }
    
    public String getUsuarioSenha(String usuarioLogin) throws SQLException {
        Usuario usuario = null;
        
        Connection conexao = getConnection();
        PreparedStatement sql = conexao.prepareStatement("select * from usuario where usuario=?");
        sql.setString(1, usuarioLogin);
        ResultSet resultado = sql.executeQuery();
        
        while(resultado.next()) {
            usuario = new Usuario();
            
            System.out.println(resultado);
            
            usuario.setId(resultado.getInt("id"));
            usuario.setUsuario(resultado.getString("usuario"));
            usuario.setSenha(resultado.getString("senha"));
            
        }
        
        if(usuario==null) {
            return null;
        } else {
          return usuario.getSenha();  
        }
        
        
    }
        
    
}
