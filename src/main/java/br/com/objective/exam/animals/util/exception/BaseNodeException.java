package br.com.objective.exam.animals.util.exception;

import br.com.objective.exam.animals.model.interfaces.INode;

@SuppressWarnings("serial")
public abstract class BaseNodeException extends Exception {

	private INode currentNode;

	public BaseNodeException(INode currentNode) {
		this.currentNode = currentNode;
	}

	public INode getCurrentNode() {
		return currentNode;
	}
	
}
