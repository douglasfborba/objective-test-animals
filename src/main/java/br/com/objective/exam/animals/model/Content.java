package br.com.objective.exam.animals.model;

/**
 * 
 * @author Douglas Borba
 * @version 3.0
 *
 */

public abstract class Content {

	private String content;

	public Content(final String content) {
		setContent(content);
	}

	public String getValue() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}