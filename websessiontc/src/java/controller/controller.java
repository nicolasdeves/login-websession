/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package controller;
import dao.DaoLogin;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import static java.lang.System.console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nicolas.deves
 */
@WebServlet(name="Controller", urlPatterns = {"/login"})
public class controller extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url = request.getServletPath(); //retorna o "action", a rota
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        
        if(url.equals("/login")) {
            String user = request.getParameter("user"); //retorna um parametro do corpo, neste caso onde o "name" é user
            String senhaBanco = null;
            DaoLogin dao = new DaoLogin();
            
            try {
                senhaBanco = dao.getUsuarioSenha(user);
            } catch (SQLException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String senhaDigitada = request.getParameter("password");

           if(criptografarSenha(senhaDigitada).equals(senhaBanco)) {
               HttpSession session = request.getSession(false); //tenta recuperar a sessão atual, mas não cria uma nova sessão se ela não existir. Se não houver uma sessão atual associada à solicitação, o método retornará null
               session.setMaxInactiveInterval(30);
               
               //Esses atributos são armazenados na sessão e podem ser acessados em outras partes da aplicação enquanto a sessão do usuário estiver ativa
               session.setAttribute("user", user);
               //session.setAttribute("password", password);
               
               RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
               dispatcher.forward(request, response);
           } else {
               RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
               PrintWriter print = response.getWriter();
               print.println("<font color=red>Login inválido!</font>");
               
               System.out.println("<font color=red>Login inválido!</font>");
               
               dispatcher.include(request, response);
           }
        }
    }
    
    public static String criptografarSenha(String senha) {
        try {
            // Criando uma instância do algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Aplicando o algoritmo de hash na senha
            byte[] hash = digest.digest(senha.getBytes());
            // Convertendo o resultado para uma representação hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Tratamento de exceção para o caso de o algoritmo não ser suportado
            e.printStackTrace();
            return null;
        }
    }
    
}
