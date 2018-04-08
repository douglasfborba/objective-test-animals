package br.com.objective.exam.animals.model;

/**
 * 
 * @author Douglas Borba
 * @version 2.0
 *
 */

 public class Node implements INode {

	private INode left;
	private INode right;
	private Content content;

	public Node(Content content) {
		setContent(content);
	}

	@Override
	public Content getContent() {
		return content;
	}

	@Override
	public void setContent(Content content) {
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