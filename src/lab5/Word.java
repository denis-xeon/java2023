package lab5;

import java.util.ArrayList;
import java.util.List;

class Word {
    private List < Letter > letters;
    private Punctuation punctuation;

    public Word ( ) {
        this.letters = new ArrayList <> ( );
        this.punctuation = new Punctuation ( ' ' );
    }

    public void addLetter ( Letter letter ) {
        letters.add ( letter );
    }

    public Punctuation getPunctuation ( ) {
        return punctuation;
    }

    public void setPunctuation ( Punctuation punctuation ) {
        this.punctuation = punctuation;
    }

    public String toString ( ) {
        StringBuilder wordBuilder = new StringBuilder ( );
        for ( Letter letter : letters ) {
            wordBuilder.append ( letter.getValue ( ) );
        }
        wordBuilder.append ( punctuation.getValue ( ) );
        return wordBuilder.toString ( );
    }
}
