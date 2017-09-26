package monster.view;

import javax.swing.JOptionPane;

public class MonsterDisplay
{
	//Opens a JOptionPane
	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	//Opens a JOptionPane with a text box 
	public String getResponse(String questionToDisplay)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, questionToDisplay);
		
		return answer;
	}
}
