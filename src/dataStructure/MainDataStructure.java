package dataStructure;

import javax.swing.JOptionPane;

import utils.DataStructureUtil;

public class MainDataStructure {

	/**
	 * Personalized presentation of the project.
	 */
	private void proyectInitialPresentation() {

		JOptionPane.showMessageDialog(null,
				"Proyecto N.2" + "\n" + "\n" + "Pilas y Colas" + "\n" + "\n" + "Por: \n  Jusselly Moreno");

	}

	/**
	 * Main method that execute the whole program.
	 * 
	 * @param args arguments.
	 */
	public static void main(String[] args) {

		final MainDataStructure DataStructure = new MainDataStructure();

		DataStructure.proyectInitialPresentation();

		final DataStructureUtil util = new DataStructureUtil();

		util.mainMenuInputHandler();

	}

}
