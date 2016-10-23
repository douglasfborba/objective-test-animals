package br.com.objective.test.animals.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.objective.test.animals.model.Animal;
import br.com.objective.test.animals.model.Node;
import br.com.objective.test.animals.view.View;

/**
 * 
 * @author Douglas Borba
 * @version 1.0
 *
 */

public class Presenter implements ActionListener {
	private View view;
	private Node<Object> root;

	public Presenter(Node<Object> root) {
		this.root = root;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		Node<Object> current = root;
		while (!current.isLeaf()) {
			int input = view.showConfirmDialog("Confirm", "O Animal que você pensou " + current.getItem() + "?");
			if (input == 0) {
				current = current.getLeft();
			} else if (input == 1) {
				current = current.getRight();
			} else {
				break;
			}
		}
		checkAnimal(current);
	}

	private void checkAnimal(Node<Object> current) {
		int input = view.showConfirmDialog("Confirm", "O animal que você pensou é " + current.getItem() + "?");
		if (input == 0) {
			view.showMessageDialog("Jogo dos Animais", "Acertei de novo!");
		} else if (input == 1) {
			addNode(current);
		}
	}

	private void addNode(Node<Object> current) {
		String name = view.showInputDialog("Desisto", "Qual o animal que você pensou?");
		String tip = view.showInputDialog("Complete", "Um(a) " + name + "_____ mas um(a) Tubarão não.");

		Animal animal = new Animal(name);

		current.setRight(new Node<Object>(current.getItem()));
		current.setLeft(new Node<Object>(animal));
		current.setItem(tip);
	}
}
