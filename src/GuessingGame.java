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
	private JTextField txtGuess;
	private JLabel lblOutput;
	JButton btnNewGame;
	private int theNumber;
	private int tries;
	public void checkGuess(){
		String guessText = txtGuess.getText();
		String message = "";
		try{
			int guess = Integer.parseInt(guessText);
			tries ++;
			if (guess < theNumber)
				message = guess +" is too low, guess again!";	
			else if (guess > theNumber)
				message = guess + " is too high, guess again!";
			else {
				message = guess + " is correct. You got it in " + tries +  " guesses. Let's play again!";
				btnNewGame.setVisible(true);
				//newGame();
				}	
		} catch (Exception e){
			message = "please enter a whole number between 1 and 100.";
		}
			
		finally{
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random()*100 +1);
		tries = 0;
		btnNewGame.setVisible(false);
	}
	public GuessingGame() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Noah's HiLo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Noah's Hi-Lo Guessing Game");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 31, 434, 28);
		getContentPane().add(lblTitle);
		
		JLabel lblEnterANumber = new JLabel("Enter a number between 1 and 100: ");
		lblEnterANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterANumber.setBounds(0, 90, 264, 34);
		getContentPane().add(lblEnterANumber);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(274, 97, 67, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(175, 155, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 194, 434, 20);
		getContentPane().add(lblOutput);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnNewGame.setBounds(175, 230, 89, 23);
		getContentPane().add(btnNewGame);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
		
	}
}
