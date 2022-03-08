package dataStructure;

import java.util.Stack;

import javax.swing.JOptionPane;

import utils.DataStructureUtil;

public class StackStructure {

	final Stack<Integer> stack = new Stack<>();

	// Value of the top of the stack.
	private int top;

	/**
	 * Constructor.
	 */
	public StackStructure() {

		top = 0;

	}

	/**
	 * Private methods.
	 */

	/**
	 * Validate if the stack is empty.
	 *
	 * @return true if the stack is empty.
	 */
	private boolean isEmpty() {

		return stack.isEmpty();

	}

	/**
	 * Validate the top of the stack.
	 * 
	 * @return Integer number between [0,n] where n is the total of elements in the
	 *         stack.
	 */
	private int getTop() {

		return top;

	}

	/**
	 * Fill the stack.
	 * 
	 * @param value Value to insert.
	 */
	private void heapUp(int value) {

		if (value > -1 && value < 100) {

			if (getTop() < 6) {

				stack.push(value);

				top++;

			} else {

				JOptionPane.showMessageDialog(null, "Pila llena.");

			}

		} else {

			JOptionPane.showMessageDialog(null,
					"El número ingresado está fuera del rango permitido. " + "Ingrese un número de 1 - 99.");

		}

		reversedStack();

	}

	/**
	 * Remove stack element.
	 */
	private void removeElement() {

		if (!isEmpty()) {

			stack.pop();

			top--;

			JOptionPane.showMessageDialog(null, "Elemento eliminado.");

		} else {

			JOptionPane.showMessageDialog(null, "Pila vacia.");

		}

	}

	/**
	 * Shows the current state of the stack.
	 */
	private void showStackState() {

		JOptionPane.showMessageDialog(null, "La cima de la pila es:\n" + getTop());

		reversedStack();

	}

	/**
	 * Reverse the full stack.
	 */
	private void reversedStack() {

		StringBuilder stringBuilder = new StringBuilder();

		if (!isEmpty()) {

			for (Integer entry : stack) {

				stringBuilder.insert(0, entry + ", ");

			}

			stringBuilder.insert(0, "[").replace(stringBuilder.length() - 2, stringBuilder.length() - 1, "]");

		} else {

			stringBuilder.append(stack);

		}

		JOptionPane.showMessageDialog(null, "Estado actual de la pila:\n" + stringBuilder);

	}

	/**
	 * Stack available option menu.
	 * 
	 * @param option Selected option.
	 */
	private void stackMenuOpt(int option) {

		Integer opt = null;
		String optStr = null;

		final DataStructureUtil util = new DataStructureUtil();

		switch (option) {

		case 1:

			optStr = JOptionPane.showInputDialog(null, "Insertar el elemento en la pila.");
			opt = Integer.parseInt(optStr);

			heapUp(opt);

			break;

		case 2:

			removeElement();

			break;

		case 3:

			showStackState();

			break;

		case 4:

			util.mainMenuInputHandler();

			break;

		case 5:

			util.exitOption();

			break;

		default:

			JOptionPane.showMessageDialog(null, "Opción inexistente.");

		}

	}

	/**
	 * Public methods.
	 */

	/**
	 * Stack option input handler.
	 * 
	 */
	public void stackOptionsInputHandler() {

		Integer option = null;
		boolean isValidOpt = false;
		boolean isNumeric;
		String optStr;

		do {

			optStr = JOptionPane.showInputDialog(null, "Ingrese la opción deseada: \n\n1) Insertar" + "\n2) "
					+ "Eliminar \n3) Mostrar estado de la pila" + "\n4) Regresar al menú principal" + "\n5) Salir");

			if (null == optStr) {

				System.exit(0);

			}

			final DataStructureUtil utilValidator = new DataStructureUtil();

			isNumeric = utilValidator.isNumericValue(optStr);

			if (isNumeric == true) {

				option = Integer.parseInt(optStr);

				if (option < 1 || option > 5) {

					JOptionPane.showMessageDialog(null, "Opción inexistente. Intentelo de nuevo.");

				} else {

					stackMenuOpt(option);

				}

			}

		} while (!isNumeric || !isValidOpt);

	}

}
