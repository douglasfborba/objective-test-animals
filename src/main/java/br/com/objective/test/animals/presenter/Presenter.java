package br.com.objective.test.animals.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
	private Node<String> root;

	public Presenter(Node<String> root) {
		this.root = root;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		Node<String> current = root;
		while (!current.isLeaf()) {
			int input = view.showConfirmDialog("Confirm", "O Animal que você pensou " + current.getItem() + "?");
			if (input == JOptionPane.YES_OPTION) {
				current = current.getLeft();
			} else if (input == JOptionPane.NO_OPTION) {
				current = current.getRight();
			} else {
				break;
			}
		}
		checkAnimal(current);
	}

	private void checkAnimal(Node<String> current) {
		int input = view.showConfirmDialog("Confirm", "O animal que você pensou é " + current.getItem() + "?");
		if (input == JOptionPane.YES_OPTION) {
			view.showMessageDialog("Jogo dos Animais", "Acertei de novo!");
		} else if (input == JOptionPane.NO_OPTION) {
			addNode(current);
		}
	}

	private void addNode(Node<String> current) {
		String name = view.showInputDialog("Desisto", "Qual o animal que você pensou?");
		String tip = view.showInputDialog("Complete",
				"Um(a) " + name + "_____ mas um(a) " + current.getItem() + " não.");

		current.setRight(new Node<String>(current.getItem()));
		current.setLeft(new Node<String>(name));
		current.setItem(tip);
	}
}
