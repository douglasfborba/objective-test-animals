package br.com.objective.test.animals.model;

/**
 * 
 * @author Douglas Borba
 * @version 1.0
 *
 */

public class Node<E> {
	private E item;
	private Node<E> left;
	private Node<E> right;

	public Node(E item) {
		this.item = item;
	}

	public Node(E item, Node<E> left, Node<E> right) {
		this(item);
		this.left = left;
		this.right = right;
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return (left == null) && (right == null);
	}
}
