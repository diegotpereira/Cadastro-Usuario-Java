package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.java.factory.ConnectionFactory;
import br.com.java.modelo.Usuario;

public class UsuarioDao {
    
    private Connection connection;

    Usuario usuario = new Usuario();

    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // Método adicionar usuário
    public void adicionar(Usuario usuario) {
        String SQL = "INSERT INTO usuario(nome, cpf, email, telefone) VALUE (?, ?, ?, ?)";

        try {
            PreparedStatement add = connection.prepareStatement(SQL);
            add.setString(1, usuario.getNome());
            add.setString(2, usuario.getCpf());
            add.setString(3, usuario.getEmail());
            add.setString(4, usuario.getTelefone());
            add.execute();
            add.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
