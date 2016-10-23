package br.com.objective.test.animals;

import br.com.objective.test.animals.model.Animal;
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
		Node<Object> root = new Node<Object>("vive na água");

		Animal tubarao = new Animal("Tubarão");
		root.setLeft(new Node<Object>(tubarao));

		Animal macaco = new Animal("Macaco");
		root.setRight(new Node<Object>(macaco));

		Presenter presenter = new Presenter(root);

		View view = new View(presenter);
		view.setVisible(true);
	}
}
