import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame extends JFrame{

	private BorderLayout bl;
	private final CreateTextFile c = new CreateTextFile();

	private JButton save;
	private JButton delete;
	private JButton historic;
	private JTextArea textArea;

	public Frame(){
		super("Escreva!");



		bl = new BorderLayout(5, 5);
		setLayout(bl);
		JPanel centerP = new JPanel();
		JPanel eastP = new JPanel();
		Box alignButtons = Box.createVerticalBox();

		textArea = new JTextArea(10, 25);
		centerP.add(textArea);

		save = new JButton("Save");
		save.setMaximumSize(new Dimension(88, 25));
		delete = new JButton("Delete");
		delete.setMaximumSize(new Dimension(88, 25));
		historic = new JButton("Historic");
		historic.setMaximumSize(new Dimension(88, 25));
		
		alignButtons.add(Box.createVerticalStrut(25));
		alignButtons.add(save);
		alignButtons.add(Box.createVerticalStrut(10));
		alignButtons.add(delete);
		alignButtons.add(Box.createVerticalStrut(10));
		alignButtons.add(historic);
		eastP.add(alignButtons);

		add(centerP, BorderLayout.CENTER);
		add(eastP, BorderLayout.EAST);

		ButtonHandler bHandler = new ButtonHandler();
		save.addActionListener(bHandler);
		delete.addActionListener(bHandler);
		historic.addActionListener(bHandler);
	}

	public class ButtonHandler implements ActionListener{
		@Override // trata os eventos de botão
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == save){
				c.openFile();
				//c.addTexts("supposed to be working");
				
				c.addTexts(textArea.getText());
				c.closeFile();
			}
			if (event.getSource() == delete){
				System.out.println("Entrou");
				
			}
			if (event.getSource() == historic){
				System.out.println("Entrou");
				
			}
		}
	}
}