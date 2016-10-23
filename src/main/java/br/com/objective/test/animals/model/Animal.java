package br.com.objective.test.animals.model;

/**
 * 
 * @author Douglas Borba
 * @version 1.0
 *
 */

public class Animal {
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}