package br.com.objective.exam.animals.model.impl;

import br.com.objective.exam.animals.model.interfaces.IContent;

/**
 * 
 * @author Douglas Borba
 * @version 3.0
 *
 */

public class Animal implements IContent {

	private String animal;

	public Animal(String animal) {
		setValue(animal);
	}

	public String getValue() {
		return animal;
	}

	public void setValue(String animal) {
		this.animal = animal;
	}

}