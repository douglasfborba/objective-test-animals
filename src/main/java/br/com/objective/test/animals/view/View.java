package br.com.objective.test.animals.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.objective.test.animals.App;
import br.com.objective.test.animals.presenter.Presenter;

/**
 * 
 * @author Douglas Borba
 * @version 1.0
 *
 */

public class View extends JFrame {
	private static final long serialVersionUID = 1L;

	private Presenter presenter;
	private JPanel header;
	private JPanel footer;

	public View(Presenter presenter) {
		this.presenter = presenter;
		this.presenter.setView(this);

		URL iconURL = App.class.getClassLoader().getResource("images/icon.png");

		ImageIcon icon = new ImageIcon(iconURL);
		this.setIconImage(icon.getImage());

		JLabel label = new JLabel("Pense em um animal");

		this.header = new JPanel();
		this.header.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.header.add(label);

		JButton button = new JButton("OK");
		button.addActionListener(presenter);

		this.footer = new JPanel();
		this.footer.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.footer.add(button);

		this.setTitle("Animais");
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setSize(235, 110);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.footer, BorderLayout.SOUTH);
		this.add(this.header, BorderLayout.NORTH);
	}

	public Presenter getPresenter() {
		return presenter;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public int showMessageDialog(String title, String message) {
		return JOptionPane.showConfirmDialog(this, message, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE);
	}

	public int showConfirmDialog(String title, String message) {
		return JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION);
	}

	public String showInputDialog(String title, String message) {
		return JOptionPane.showInputDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
	}
}
