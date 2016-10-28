package br.com.objective.test.animals;

import br.com.objective.test.animals.model.Node;
import br.com.objective.test.animals.presenter.Presenter;
import br.com.objective.test.animals.view.View;

/**
 * 
 * @author Douglas Borba
 * @version 1.0
 *
 */

public class App {

	public static void main(String[] args) {
		Node<String> root = new Node<String>("vive na água");

		root.setLeft(new Node<String>("Tubarão"));
		root.setRight(new Node<String>("Macaco"));

		Presenter presenter = new Presenter(root);

		View view = new View(presenter);
		view.setVisible(true);
	}
}
