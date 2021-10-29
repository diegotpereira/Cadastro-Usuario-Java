package br.com.java;

import java.sql.Connection;

import br.com.java.factory.ConnectionFactory;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Connection conexao = new ConnectionFactory().getConnection();
        System.out.println("Conexão com banco de dados realizada com sucesso!");
        conexao.close();
        
    }
}
