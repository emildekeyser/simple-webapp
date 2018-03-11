package domain.model;

public class LetterCounter
{
	public int countLetters(String word, String letter)
	{
		int ret = 0;
		for (char c : word.toCharArray())
		{
			if (c == letter.charAt(0)) ret++;
		}
		return ret;
	}
}
