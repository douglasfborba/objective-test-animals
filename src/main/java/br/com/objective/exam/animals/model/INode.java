package br.com.objective.exam.animals.model;

/**
 * 
 * @author Douglas Borba
 * @version 2.0
 *
 */

public interface INode {

	public abstract Content getContent();
	public abstract void setContent(Content content);

	public abstract INode getLeft() ;
	public abstract void setLeft(INode node);

	public abstract INode getRight();
	public abstract void setRight(INode node);

	public abstract boolean isLeaf();

}
