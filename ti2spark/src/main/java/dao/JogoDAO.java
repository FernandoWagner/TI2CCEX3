package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Jogo;

public class JogoDAO extends DAO {
	
	public JogoDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Jogo jogo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO jogo (id, nome, downloads, estudio) "
				       + "VALUES ("+jogo.getId()+ ", '" + jogo.getNome() + "', '"  
				       + jogo.getDownloads() + "', '" + jogo.getEstudio() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Jogo get(int id) {
		Jogo jogo = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM jogo WHERE id=" + id;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 jogo = new Jogo(rs.getInt("id"), rs.getString("nome"), rs.getInt("downloads"), rs.getString("estudio"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return jogo;
	}
	
	public List<Jogo> get() {
		return get("");
	}

	
	public List<Jogo> getOrderById() {
		return get("id");		
	}
	
	
	public List<Jogo> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Jogo> getOrderByDownloads() {
		return get("downloads");		
	}
	
	public List<Jogo> getOrderByEstudio() {
		return get("estudio");		
	}
	
	private List<Jogo> get(String orderBy) {	
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM jogo" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Jogo j = new Jogo(rs.getInt("id"), rs.getString("nome"), rs.getInt("downloads"), rs.getString("estudio"));
	            jogos.add(j);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return jogos;
	}
	
	public List<Jogo> getEstudioValve() {
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM jogo WHERE jogo.estudio LIKE 'Valve'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Jogo j = new Jogo(rs.getInt("id"), rs.getString("nome"), rs.getInt("downloads"), rs.getString("estudio"));
	            jogos.add(j);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return jogos;
	}
	
	public boolean update(Jogo jogo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE jogo SET nome = '" + jogo.getNome() + "', downloads = '"  
				       + jogo.getDownloads() + "', estudio = '" + jogo.getEstudio() + "'"
					   + " WHERE id = " + jogo.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM jogo WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	


}
