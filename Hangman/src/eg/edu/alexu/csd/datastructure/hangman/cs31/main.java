package eg.edu.alexu.csd.datastructure.hangman.cs31;

public class main {

	public static void main(String[] args) {
		Functions hangman = new Functions();
		String dictionary[] = new String[] { "EGYPT" };
		hangman.setDictionary(dictionary);
		hangman.selectRandomSecretWord();
		hangman.setMaxWrongGuesses(2);
		System.out.print(hangman.guess('T'));

	}

}
