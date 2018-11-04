package br.com.objective.exam.animals.model.impl;

import br.com.objective.exam.animals.model.interfaces.IContent;

/**
 * 
 * @author Douglas Borba
 * @version 3.0
 *
 */

public class Question implements IContent {

	private String tip;

	public Question(String tip) {
		setValue(tip);
	}

	public String getValue() {
		return tip;
	}

	public void setValue(String tip) {
		this.tip = tip;
	}

}