package br.com.objective.exam.animals.model.impl;

import br.com.objective.exam.animals.model.interfaces.IContent;
import br.com.objective.exam.animals.model.interfaces.INode;

/**
 * 
 * @author Douglas Borba
 * @version 3.0
 *
 */

 public class Node implements INode {

	private INode left;
	private INode right;
	private IContent content;

	public Node(IContent content) {
		setContent(content);
	}

	@Override
	public IContent getContent() {
		return content;
	}

	@Override
	public void setContent(IContent content) {
		this.content = content;
	}

	@Override
	public INode getLeft() {
		return left;
	}
	
	@Override
	public void setLeft(INode node) {
		left = node;
	}

	@Override
	public INode getRight() {
		return right;
	}

	@Override
	public void setRight(INode node) {
		right = node;
	}

	@Override
	public boolean isLeaf() {
		return !hasLeft() && !hasRight();
	}   

	private boolean hasRight() {
		return right != null;
	}

	private boolean hasLeft() {
		return left != null;
	}

 }