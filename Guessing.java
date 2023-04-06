import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Guessing extends JFrame implements ActionListener {
	//global variables for constant
	static final int MIN_NUM = 1;
    static final int MAX_NUM = 100;
    static final int MAX_ATTEMPTS = 6;
	//global variables
	int randomNum;
    int attempsNum;
    int score;
	//swing elements
     JLabel guessLabel;
     JTextField guessField;
     JButton guessButton;
     JTextArea resultArea;

    Guessing() 
	{	
        super("Number Guessing Game");
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //logic for random number genrator
        randomNum = (int) (Math.random() * (MAX_NUM - MIN_NUM + 1)) + MIN_NUM;
        
        attempsNum = 0;
        score = 100;
        
		Container c = getContentPane();
        c.setLayout(new FlowLayout());
		
		setTitle("Number Guessing Game Presented By Anuj Bansal");
		
		guessLabel = new JLabel("YOU HAVE FIVE ATTEMPTS TO GUESS CORRECT THE NUMBER ");
		guessLabel.setBackground(Color.BLUE);
		guessLabel.setFont(new Font("Vendana",Font.PLAIN,20));
        c.add(guessLabel);
		
        guessLabel = new JLabel("Enter a number between " + MIN_NUM + " and " + MAX_NUM + ":");
        c.add(guessLabel);
		
		
		guessField = new JTextField(10);
        c.add(guessField);
		
		guessButton = new JButton("Submit");
		guessButton.addActionListener(this);
        c.add(guessButton);
		
		resultArea = new JTextArea(10, 30);
		resultArea.setEditable(false);
        c.add(resultArea);
        
		setSize(700,400);
        setVisible(true);
		setLocation(100,200);
    }
    
    public void actionPerformed(ActionEvent e) {
		
        if (e.getSource() == guessButton)//getting user input
			{            
            int guess = Integer.parseInt(guessField.getText());
         
            attempsNum++;//counting attempts
            score -= 0;
            
           
            if (guess == randomNum)
				{
                resultArea.setText("Congratulations! You guessed the number in " + attempsNum + " attempts. Your score is " + score + ".");
                guessButton.setEnabled(false);
				}
			else if (guess < randomNum)
				{
                resultArea.append("\n" + guess + " is Lower than Guessed Number. Guess again.");    
				} 
			else 
				{
                resultArea.append("\n" + guess + " is Higher than Guessed Number. Guess again.");
				}
           
            if (attempsNum == MAX_ATTEMPTS)//checking numbers of attempts
				{
                resultArea.setText("Sorry, you have used all " + MAX_ATTEMPTS + " attempts. The number was " + randomNum + ". Your score is " + score + ".");
                guessButton.setEnabled(false);
				}
				
            guessField.setText("");//reset test field
        }
    }
    
    public static void main(String[] args) {
        new Guessing();
    }
}
