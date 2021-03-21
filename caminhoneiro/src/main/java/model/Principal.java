package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.CaminhoneiroDAO;

public class Principal {

	public static void main(String[] args) {

		try {

			/*
			 * Caminhoneiro c = new Caminhoneiro(); c.setNome("Roverval do Carmo");
			 * c.setRg("1234"); CaminhoneiroDAO.inserir(c);
			 */

			// CaminhoneiroDAO.listarTodosCaminhoneiros();

			
			  Caminhoneiro c = new Caminhoneiro();
			  c.setNome("alterado Roverval para Robson xxxx"); c.setRg("777"); c.setId(9l);
			  CaminhoneiroDAO.atualizar(c);
			 

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao inserir dados");
			e.printStackTrace();
		}
	}

}
