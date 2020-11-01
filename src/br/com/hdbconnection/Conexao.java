package br.com.hdbconnection;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    
    Conexao ConnectarCliente;
        final private String VarDriver = "org.gjt.mm.mysql.Driver";
    final private String VarUrl = "jdbc:mysql://localhost/db_hdb";
    final private String VarUsuario = "root";
    final private String VarSenha = ""; 
    private Connection VarConexaoOdbc;
    public Statement VarStatement;
    public ResultSet VarResultset;

    public boolean Conectar() {
        boolean VarResult = true;

        try {

            Class.forName(VarDriver);
            VarConexaoOdbc = DriverManager.getConnection(VarUrl, VarUsuario, VarSenha);
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");

        } catch (ClassNotFoundException VarErroDriver) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado: " + VarErroDriver);
            VarResult = false;

        } catch (SQLException VarFonte) {

            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + VarFonte);
            VarResult = false;

        }
        return VarResult;

    }

    //Criar o método para DESCONECTAR o BancoEstoque
    public void Desconectar() {
        boolean VarResult = true;
        try {
            VarConexaoOdbc.close();
            JOptionPane.showMessageDialog(null, "Banco desconectado com sucesso!");

        } catch (SQLException VarErroSQL) {
            JOptionPane.showMessageDialog(null, "Não foi possível se conectar ao banco: " + VarErroSQL);
            VarResult = false;

        }


    }

    //Comando para executar os comandos SQL
    public void ExecutarSQL(String VarSql) {

        try {
            //Adaptando o Statement para que ele possa exibir vários resultados de uma pesquisa.
            VarStatement = VarConexaoOdbc.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            VarResultset = VarStatement.executeQuery(VarSql);
        } catch (SQLException VarErroSQL2) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar executar o comando SQL: " + VarErroSQL2 + " , por favor, verifique a sintaxe da cláusula: " + VarSql);
        }

    }
}