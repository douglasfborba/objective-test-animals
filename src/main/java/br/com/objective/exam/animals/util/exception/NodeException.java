package br.com.objective.exam.animals.util.exception;

import br.com.objective.exam.animals.model.interfaces.INode;

public class NodeException {

	@SuppressWarnings("serial")
	public static class NotFoundNodeException extends BaseNodeException {

		public NotFoundNodeException(INode lastNode) {
			super(lastNode);
		}

	}

}
