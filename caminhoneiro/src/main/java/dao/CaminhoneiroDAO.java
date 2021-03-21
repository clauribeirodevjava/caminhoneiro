package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.ConnectionFactory;
import model.Caminhoneiro;

public class CaminhoneiroDAO {
	
	private static final String sqlInserir = "INSERT INTO caminhoneiro (nome,rg) VALUES (?,?)";
	private static final String sqlDelete = "DELETE FROM table_name WHERE ID = ?";
	private static final String sqlUpdate = "UPDATE caminhoneiro set nome= ?,rg= ? where id = ?";
	private static final String sqlListarTodos = "SELECT nome,rg from caminhoneiro";
	
	public static void inserir(Caminhoneiro caminhoneiro) throws SQLException {
		
		Connection con = ConnectionFactory.createConnection();
		con.setAutoCommit(false);
		con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		PreparedStatement st = con.prepareStatement(sqlInserir);
		st.setLong(1, caminhoneiro.getId());
		st.setString(2, caminhoneiro.getRg());
		st.execute();
		con.commit();
		con.close();
	}
	
	public static void deletar(Caminhoneiro caminhoneiro) throws SQLException {
		
		Connection con = ConnectionFactory.createConnection();
		con.setAutoCommit(false);
		con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		PreparedStatement st = con.prepareStatement(sqlDelete);
		st.setString(1, caminhoneiro.getNome());
		st.executeUpdate();
		con.commit();
		con.close();
	}
	
	public static void atualizar(Caminhoneiro caminhoneiro) throws SQLException {
		
		Connection con = ConnectionFactory.createConnection();
		
		
		PreparedStatement st = con.prepareStatement(sqlUpdate);
		st.setString(1, caminhoneiro.getNome());
		st.setString(2, caminhoneiro.getRg());
		st.setLong(3, caminhoneiro.getId());
		st.executeUpdate();
	
		con.close();
	}
	
	public static List<Caminhoneiro> listarTodosCaminhoneiros() throws SQLException {
		
		List<Caminhoneiro> listAll = new ArrayList<Caminhoneiro>();
		Caminhoneiro caminhoneiro;
		Connection con = ConnectionFactory.createConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sqlListarTodos);
		
		while (rs.next()) {
			caminhoneiro = new Caminhoneiro();
			caminhoneiro.setNome(rs.getString("nome"));
			caminhoneiro.setRg(rs.getString("rg"));
			listAll.add(caminhoneiro);
			
		}
		
		con.close();
		rs.close();
		stm.close();
		
		return listAll;
		
	}
}
