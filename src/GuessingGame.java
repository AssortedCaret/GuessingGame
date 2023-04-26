import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField textGuess;
	private JLabel lblOutput;
	private int theNumber;
	JButton btnPlayAgain;
	private int numberOfTries = 0;
	public void checkGuess() {
		String guessText = textGuess.getText();	
		String message = "";
		
		try {
			int guess= Integer.parseInt(guessText);
			
			if (guess < theNumber)
				message = guess + " is too low. Try again";
			else if (guess> theNumber)
				message = guess + " is too high. Try again";
			else {
				message = guess + " is correct. You win after " + numberOfTries + " tries." + " Let's play again.";
				btnPlayAgain.setVisible(true);
				//newGame();
				}
		} catch (Exception e) {
			message = "Please enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			textGuess.requestFocus();
			textGuess.selectAll();				
		}
		numberOfTries = numberOfTries + 1;
	}
	
	//Используем воид, потому что нам не надо возвращать число, которое получится
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		btnPlayAgain.setVisible(false);
	}
	
	//Дальше идет код интерфейса (кнопки, которые мы добаляли через Desigh
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Alexandr HILo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Alexandr HiLo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 40, 277, 19);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100: ");
		lblNewLabel_1.setBounds(113, 99, 212, 66);
		getContentPane().add(lblNewLabel_1);

		textGuess = new JTextField();
		textGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		textGuess.setBounds(335, 122, 45, 20);
		getContentPane().add(textGuess);
		textGuess.setColumns(10);
		// Позволит нам подтверждать ввод клавишей Интер
		textGuess.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				checkGuess();
			}
		});
		// Активирует кнопку, которая подтверждает ввод значения
		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess ();
			}
		});

		btnNewButton.setBounds(172, 166, 89, 23);
		getContentPane().add(btnNewButton);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(71, 200, 297, 14);
		getContentPane().add(lblOutput);
		
		//создает кнопку играть ещё раз
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			newGame ();
			}
		});
		btnPlayAgain.setBounds(172, 225, 89, 23);
		getContentPane().add(btnPlayAgain);
	}
	
	//Создает окно указанного размера
	public static void main(String[] args) {
		GuessingGame theGame= new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension (450, 300));
		theGame.setVisible(true);

	}
}
