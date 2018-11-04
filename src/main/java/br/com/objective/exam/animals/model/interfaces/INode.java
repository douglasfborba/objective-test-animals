package br.com.objective.exam.animals.model.interfaces;

/**
 * 
 * @author Douglas Borba
 * @version 3.0
 *
 */

public interface INode {

	IContent getContent();
	void setContent(IContent content);

	INode getLeft() ;
	void setLeft(INode node);

	INode getRight();
	void setRight(INode node);

	boolean isLeaf();

}
