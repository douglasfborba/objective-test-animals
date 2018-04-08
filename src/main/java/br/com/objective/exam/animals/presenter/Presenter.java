package br.com.objective.exam.animals.presenter;

import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.objective.exam.animals.model.Animal;
import br.com.objective.exam.animals.model.INode;
import br.com.objective.exam.animals.model.Node;
import br.com.objective.exam.animals.model.Question;
import br.com.objective.exam.animals.util.Messages;
import br.com.objective.exam.animals.view.View;

/**
 * 
 * @author Douglas Borba
 * @version 2.0
 *
 */

public class Presenter implements ActionListener {

	private View view;
	private INode root;
	private Messages messages;

	public Presenter(View view, INode node) {
		view.setListener(this);
		this.view = view;	
		root = node;
		messages = Messages.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkNode(findNode(root));
	}
	
	private INode findNode(INode node) {
		while (!node.isLeaf()) {
			final int selected = view.confirmDialog(
				messages.getMessage("dialog.title.confirm"), 
				messages.getMessage("dialog.message.confirm.question", node.getContent().getValue()));
			if (selected == YES_OPTION)
				node = node.getLeft();
			else 
				if (selected == NO_OPTION)
					node = node.getRight();
			else
				break;
		}
		return node;
	}

	private void checkNode(INode node) {	
		int selected = view.confirmDialog(
			messages.getMessage("dialog.title.confirm"), 
			messages.getMessage("dialog.message.confirm.animal", node.getContent().getValue()));
		if (selected == YES_OPTION)
			view.messageDialog(
				messages.getMessage("app.title"),
				messages.getMessage("dialog.message.info.match", node.getContent().getValue()));
		else 
			if (selected == NO_OPTION)
				addNode(node);
	}

	private void addNode(INode node) {
		final String name = view.inputDialog(
			messages.getMessage("dialog.title.fail"),
			messages.getMessage("dialog.message.input.animal"));

		final String tip = view.inputDialog(
			messages.getMessage("dialog.title.complete"), 
			messages.getMessage("dialog.message.input.complete", name, node.getContent().getValue()));

		final Animal animal = new Animal(name);
		final Question question = new Question(tip);

		node.setRight(new Node(node.getContent()));
		node.setLeft(new Node(animal));
		node.setContent(question);
	}
}
