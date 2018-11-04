package br.com.objective.exam.animals;

import br.com.objective.exam.animals.model.impl.Animal;
import br.com.objective.exam.animals.model.impl.Node;
import br.com.objective.exam.animals.model.impl.Question;
import br.com.objective.exam.animals.model.interfaces.INode;
import br.com.objective.exam.animals.presenter.Presenter;
import br.com.objective.exam.animals.view.View;

/**
 * 
 * @author Douglas Borba
 * @version 2.0
 *
 */

public class App {

	public static void main(String[] args) {		
		INode root = new Node(new Question("vive na água"));
		root.setLeft(new Node(new Animal("Tubarão")));
		root.setRight(new Node(new Animal("Macaco")));

		final View view = new View();
		new Presenter(view, root);
	}
	
}
