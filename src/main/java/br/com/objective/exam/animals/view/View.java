package br.com.objective.exam.animals.view;

import static br.com.objective.exam.animals.util.GlobalConstants.DEFAULT_ICON;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_BUTTON_LABEL_OK;
import static br.com.objective.exam.animals.util.GlobalConstants.DIALOG_MESSAGE_INFO_ANIMAL;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.FlowLayout.CENTER;
import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.objective.exam.animals.App;
import br.com.objective.exam.animals.util.Messages;

/**
 * 
 * @author Douglas Borba
 * @version 1.0
 *
 */

public class View extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton button;
	private Messages messages;

	public View() {
		loadResources();
		constructGUI();
	}

	private void loadResources() {
		messages = Messages.getInstance();

		final URL url = App.class.getClassLoader().getResource(DEFAULT_ICON);
		setAppIcon(url);
	}

	private void setAppIcon(URL url) {
		if (url != null)
			setIconImage(new ImageIcon(url).getImage());
	}

	private void constructGUI() {
		JLabel label = new JLabel(messages.getMessage(DIALOG_MESSAGE_INFO_ANIMAL));

		JPanel header = new JPanel();
		header.setLayout(new FlowLayout(CENTER));
		header.add(label);

		button = new JButton(messages.getMessage(DIALOG_BUTTON_LABEL_OK));

		JPanel footer = new JPanel();
		footer.setLayout(new FlowLayout(CENTER));
		footer.add(button);

		setTitle("Animais");
		setLayout(new BorderLayout());
		pack();

		setLocationRelativeTo(null);
		setSize(235, 110);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(header, NORTH);
		add(footer, SOUTH);

		setVisible(true);
	}

	public void setListener(ActionListener listener) {
		button.addActionListener(listener);
	}

	public void messageDialog(String title, String message) {
		showConfirmDialog(this, message, title, DEFAULT_OPTION, PLAIN_MESSAGE);
	}

	public int confirmDialog(String title, String message) {
		return showConfirmDialog(this, message, title, YES_NO_OPTION);
	}

	public String inputDialog(String title, String message) {
		return showInputDialog(this, message, title, PLAIN_MESSAGE);
	}

}
