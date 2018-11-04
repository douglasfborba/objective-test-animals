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

import br.com.objective.exam.animals.model.impl.Animal;
import br.com.objective.exam.animals.model.impl.Node;
import br.com.objective.exam.animals.model.impl.Question;
import br.com.objective.exam.animals.model.interfaces.INode;
import br.com.objective.exam.animals.util.Messages;
import br.com.objective.exam.animals.util.exception.NodeException.NotFoundNodeException;
import br.com.objective.exam.animals.view.View;

/**
 * 
 * @author Douglas Borba
 * @version 3.0
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
		try {
			verifyNode(searchNode(root));
		} catch (NotFoundNodeException ex) {
			insertNode(ex.getCurrentNode());
		}
	}

	private INode searchNode(INode currentNode) {
		INode node = currentNode;
		while (node != null && !node.isLeaf()) {
			final int selected = showConfirmQuestionDialog(node);
			if (selected == YES_OPTION)
				node = node.getLeft();
			else if (selected == NO_OPTION)
				node = node.getRight();
			else
				node = null;
		}
		return node;
	}

	private void verifyNode(INode currentNode) throws NotFoundNodeException {
		if (currentNode != null) {
			int selected = showConfirmAnimalDialog(currentNode);
			if (selected == YES_OPTION)
				showInfoDialog(currentNode);
			else if (selected == NO_OPTION)
				throw new NotFoundNodeException(currentNode);
		}
	}

	private void insertNode(INode currentNode) {
		final String name = showInputAnimalDialog();
		final String tip = showInputTipDialog(currentNode, name);

		final Animal animal = new Animal(name);
		final Question question = new Question(tip);

		currentNode.setRight(new Node(currentNode.getContent()));
		currentNode.setLeft(new Node(animal));
		currentNode.setContent(question);
	}

	private String showInputTipDialog(INode node, final String name) {
		return view.inputDialog(messages.getMessage(DIALOG_TITLE_COMPLETE),
				messages.getMessage(DIALOG_MESSAGE_INPUT_COMPLETE, name, node.getContent().getValue()));
	}

	private String showInputAnimalDialog() {
		return view.inputDialog(messages.getMessage(DIALOG_TITLE_FAIL),
				messages.getMessage(DIALOG_MESSAGE_INPUT_ANIMAL));
	}

	private void showInfoDialog(INode node) {
		view.messageDialog(messages.getMessage(APP_TITLE),
				messages.getMessage(DIALOG_MESSAGE_INFO_MATCH, node.getContent().getValue()));
	}

	private int showConfirmAnimalDialog(INode node) {
		return view.confirmDialog(messages.getMessage(DIALOG_TITLE_CONFIRM),
				messages.getMessage(DIALOG_MESSAGE_CONFIRM_ANIMAL, node.getContent().getValue()));
	}

	private int showConfirmQuestionDialog(INode node) {
		return view.confirmDialog(messages.getMessage(DIALOG_TITLE_CONFIRM),
				messages.getMessage(DIALOG_MESSAGE_CONFIRM_QUESTION, node.getContent().getValue()));
	}

}
