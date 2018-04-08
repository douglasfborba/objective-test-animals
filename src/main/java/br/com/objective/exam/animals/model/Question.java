package br.com.objective.exam.animals.model;

/**
 * 
 * @author Douglas Borba
 * @version 2.0
 *
 */

public class Question implements Content {

    private String question;

    public Question(String question) {
        setValue(question);
    }

    @Override
	public String getValue() {
		return question;
	}

	@Override
	public void setValue(String value) {
		question = value;
	}

}