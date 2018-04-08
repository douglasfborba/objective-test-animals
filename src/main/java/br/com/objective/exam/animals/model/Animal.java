package br.com.objective.exam.animals.model;

/**
 * 
 * @author Douglas Borba
 * @version 2.0
 *
 */

public class Animal implements Content {

    private String name;

    public Animal(final String value) {
        setValue(value);
    }

    @Override
	public String getValue() {
		return name;
	}

	@Override
	public void setValue(String value) {
		name = value;
	}

}