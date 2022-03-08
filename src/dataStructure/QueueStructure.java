package dataStructure;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import utils.DataStructureUtil;

public class QueueStructure {

	final LinkedList<Integer> queue = new LinkedList<>();

	// Value of the top of the stack.
	private int top;

	/**
	 * Constructor.
	 */
	public QueueStructure() {

		top = 0;

	}

	/**
	 * Metodos privados.
	 */

	/**
	 * Validate if the stack is empty.
	 *
	 * @return true if the stack is empty.
	 */
	private boolean isEmpty() {

		return queue.isEmpty();

	}

	/**
	 * Validate the top of the stack.
	 * 
	 * @return Integer number between [0,n] where n is the total of elements in the
	 *         stack.
	 */
	private Integer getTop() {

		return top;

	}

	/**
	 * Stack available option menu.
	 * 
	 * @param option Selected option.
	 */
	private void queueMenuOpt(int option) {

		Integer opt = null;
		String optStr = null;

		final DataStructureUtil util = new DataStructureUtil();

		switch (option) {

		case 1:

			optStr = JOptionPane.showInputDialog(null, "Insertar el elemento en la cola.");
			opt = Integer.parseInt(optStr);

			heapUp(opt);

			break;

		case 2:

			removeElement();

			break;

		case 3:

			showQueueState();

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
	 * Fill the queue.
	 * 
	 * @param value Value to insert.
	 */
	private void heapUp(int value) {

		if (value > -1 && value < 100) {

			if (getTop() < 6) {

				queue.add(value);

				top++;

			} else {

				JOptionPane.showMessageDialog(null, "Cola llena.");

			}

		} else {

			JOptionPane.showMessageDialog(null,
					"El número ingresado está fuera del rango permitido. " + "Ingrese un número de 1 - 99.");

		}

	}

	/**
	 * Remove stack element.
	 */
	private void removeElement() {

		if (!isEmpty()) {

			queue.poll();

			top--;

			JOptionPane.showMessageDialog(null, "Elemento eliminado.");

		} else {

			JOptionPane.showMessageDialog(null, "Cola vacia.");

		}

	}

	/**
	 * Shows the current state of the stack.
	 */
	private void showQueueState() {

		if (!isEmpty() && null != queue) {

			JOptionPane.showMessageDialog(null, "El valor de Frente de la cola es:\n" + queue.peek());
			JOptionPane.showMessageDialog(null, "El valor de Final de la cola es:\n" + queue.getLast());
			JOptionPane.showMessageDialog(null, "Estado actual de la cola:\n" + showQueue());

		} else {

			JOptionPane.showMessageDialog(null, "No hay elementos en la cola.");

		}

	}

	private String showQueue() {

		StringBuilder stringBuilder = new StringBuilder();

		if (!isEmpty()) {

			for (Integer entry : queue) {

				stringBuilder.append(entry).append(",");

			}

		}

		return stringBuilder.toString();

	}

	/**
	 * Metodos publicos.
	 */

	/**
	 * Stack option input handler.
	 * 
	 */
	public void queueOptionsInputHandler() {

		String optStr;
		Integer option = null;
		boolean isValidOpt = false;
		boolean isNumeric;

		do {

			optStr = JOptionPane.showInputDialog(null, "Ingrese la opción deseada: \n\n1) Insertar" + "\n2) "
					+ "Eliminar \n3) Mostrar estado de la cola" + "\n4) Regresar al menú principal" + "\n5) Salir");

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

					queueMenuOpt(option);

				}

			}

		} while (!isNumeric || !isValidOpt);

	}

}
