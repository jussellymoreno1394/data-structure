package utils;

import javax.swing.JOptionPane;

import dataStructure.QueueStructure;
import dataStructure.StackStructure;

public class DataStructureUtil {

	/**
	 * Private methods.
	 */

	/**
	 * Data structure options.
	 * 
	 * @param option Data structure option.
	 * 
	 */
	private void dataStructureOpt(int option) {

		switch (option) {

		case 1:

			final StackStructure stack = new StackStructure();

			stack.stackOptionsInputHandler();

			break;

		case 2:

			final QueueStructure queue = new QueueStructure();

			queue.queueOptionsInputHandler();

			break;

		default:

			JOptionPane.showMessageDialog(null, "Opción inexistent.");

		}

	}

	/**
	 * Public methods.
	 */

	/**
	 * Main menu input handler.
	 *
	 */
	public void mainMenuInputHandler() {

		Integer option = null;

		String optStr;

		boolean isNumeric;
		boolean isValidOpt = false;

		do {

			optStr = JOptionPane.showInputDialog(null, "Ingrese la opción deseada: \n\n1) Pila \n\n2) Cola");

			if (null == optStr) {

				System.exit(0);

			}

			isNumeric = isNumericValue(optStr);

			if (isNumeric == true) {

				option = Integer.parseInt(optStr);

				if (option > 0 && option < 3) {

					isValidOpt = true;

					dataStructureOpt(option);

				} else {

					JOptionPane.showMessageDialog(null, "Opción inexistente. Intentelo de nuevo.");

				}

			}

		} while (!isNumeric || !isValidOpt);

	}

	/**
	 * Valid if it is a numeric entry.
	 * 
	 * @param input Option to validate.
	 * 
	 * @return boolean.
	 */
	public boolean isNumericValue(String input) {

		try {

			Integer.parseInt(input);

			return true;

		} catch (NumberFormatException e) {

			return false;

		}

	}

	/**
	 * Let the user exit from the app.
	 */
	public void exitOption() {

		int anws = JOptionPane.showConfirmDialog(null, "¿Desea salir?", null, JOptionPane.YES_NO_OPTION,
				JOptionPane.OK_CANCEL_OPTION);

		if (anws == 0) {

			System.exit(0);

		}

	}

}
