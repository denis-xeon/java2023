package lab5;

import java.util.ArrayList;
import java.util.List;

class Sentence {
    private List < Word > words;

    public Sentence ( ) {
        this.words = new ArrayList <> ( );
    }

    public void addWord ( Word word ) {
        words.add ( word );
    }

    public List < Word > getWords ( ) {
        return words;
    }

    public void swapFirstAndLastWords ( ) {
        if (words.size ( ) >= 2) {
            Word firstWord = words.get(0);
            Word lastWord = words.get( words.size()-1);
            Punctuation firstWordPunctuation = firstWord.getPunctuation ();
            Punctuation lastWordPunctuation = lastWord.getPunctuation ();
            firstWord.setPunctuation ( lastWordPunctuation );
            lastWord.setPunctuation ( firstWordPunctuation );
            words.set ( 0, lastWord );
            words.set ( words.size ( ) - 1, firstWord );
        }
    }

    public String toString ( ) {
        StringBuilder sentenceBuilder = new StringBuilder ( );
        for ( Word word : words ) {
            sentenceBuilder.append ( word.toString ( ).trim ( ) );
            sentenceBuilder.append ( " " );
        }
        return sentenceBuilder.toString ( ).trim ( );
    }
}
