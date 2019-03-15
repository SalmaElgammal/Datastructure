package eg.edu.alexu.csd.datastructure.hangman.cs31;

import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

public class Functions implements IHangman {

	static String secretWord;
	static String userWord;
	static String words[];
	static int wrongGuess;
	static int correctGuess;
	int maxInstance;
	static int arraySize;
	public Functions(){
		userWord="-";
		words=null;
		wrongGuess=0;
		correctGuess=0;
		arraySize=0;
	}

	public void setDictionary(String[] words){
		this.words=words;
	}
	public String selectRandomSecretWord() {
		if(words==null){
			return null;
		}
		int idx = new Random().nextInt(words.length);
		secretWord = (words[idx]);
		return secretWord;
	}
	public String guess(Character c) {
		StringBuilder sb = new StringBuilder(userWord);
		sb.setLength(0);
    	for(int i=0;i<secretWord.length();i++) {
            sb.append('-');
    	}
	    /*if (secretWord.length() > userWord.length()) {
	        int j = 0; 
	        sb.setLength(0);
	        for(int i=0;i<secretWord.length()-1;i++) {
	        	
	                sb.append(userWord.charAt(j));
	                j++;
	                j %= userWord.length();
	        }
	    }else{
	    	sb.setLength(0);
	    	for(int i=0;i<secretWord.length()-1;i++) {
                sb.append('-');
	    	}
	    	
	    }*/
	    userWord=sb.toString();
	    String str=new String();
	    str=secretWord.toLowerCase();
	    
		int index = str.indexOf(Character.toLowerCase(c));
		
		if(c=='\0'){
			return userWord;
		}
		char[] myNameChars = userWord.toCharArray();
		if(index==-1){
			wrongGuess++;
		}else{
		char a_char=userWord.charAt(index);
		while(index >= 0 && a_char=='-') {
			myNameChars[index] = Character.toUpperCase(c);
			correctGuess++;
		   index = str.indexOf(c, index+1);
		}
		}
			if(correctGuess==secretWord.length() || wrongGuess==maxInstance){
				return null;
			}
			
		userWord = String.valueOf(myNameChars);
		return userWord;
	}
	public void setMaxWrongGuesses(Integer max) {
		this.maxInstance=(int)max;

	}
}

