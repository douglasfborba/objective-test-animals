package br.com.objective.exam.animals.presenter;

import static br.com.objective.exam.animals.util.GlobalConstants.APP_TITLE;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_MESSAGE_CONFIRM_ANIMAL;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_MESSAGE_CONFIRM_QUESTION;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_MESSAGE_INFO_MATCH;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_MESSAGE_INPUT_ANIMAL;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_MESSAGE_INPUT_COMPLETE;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_TITLE_COMPLETE;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_TITLE_CONFIRM;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_TITLE_FAIL;
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

	private final View view;
	private final INode root;
	private final Messages messages;

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
				messages.getMessage(DIALOG_TITLE_CONFIRM),
				messages.getMessage(DIALOG_MESSAGE_CONFIRM_QUESTION, node.getContent().getValue()));
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
			messages.getMessage(DIALOG_TITLE_CONFIRM),
			messages.getMessage(DIALOG_MESSAGE_CONFIRM_ANIMAL, node.getContent().getValue()));
		if (selected == YES_OPTION)
			view.messageDialog(
				messages.getMessage(APP_TITLE),
				messages.getMessage(DIALOG_MESSAGE_INFO_MATCH, node.getContent().getValue()));
		else 
			if (selected == NO_OPTION)
				addNode(node);
	}

	private void addNode(INode node) {
		final String name = view.inputDialog(
			messages.getMessage(DIALOG_TITLE_FAIL),
			messages.getMessage(DIALOG_MESSAGE_INPUT_ANIMAL));

		final String tip = view.inputDialog(
			messages.getMessage(DIALOG_TITLE_COMPLETE),
			messages.getMessage(DIALOG_MESSAGE_INPUT_COMPLETE, name, node.getContent().getValue()));

		final Animal animal = new Animal(name);
		final Question question = new Question(tip);

		node.setRight(new Node(node.getContent()));
		node.setLeft(new Node(animal));
		node.setContent(question);
	}
}
