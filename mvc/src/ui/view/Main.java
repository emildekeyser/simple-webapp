package ui.view;

import javax.swing.JOptionPane;

import domain.model.LetterCounter;

public class Main
{
	public static void main(String[] args)
	{
		String word = JOptionPane.showInputDialog("woord");
		String letter = JOptionPane.showInputDialog("letter");
		int letterCount = new LetterCounter().countLetters(word, letter);
		JOptionPane.showMessageDialog(null, letterCount);
	}
}
