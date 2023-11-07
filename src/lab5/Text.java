package lab5;

import java.util.ArrayList;
import java.util.List;

class Text {
    private List < Sentence > sentences;

    public Text ( ) {
        this.sentences = new ArrayList <> ( );
    }

    public void addSentence ( Sentence sentence ) {
        sentences.add ( sentence );
    }

    public List < Sentence > getSentences ( ) {
        return sentences;
    }

    public String toString ( ) {
        StringBuilder textBuilder = new StringBuilder ( );
        for ( Sentence sentence : sentences ) {
            textBuilder.append ( sentence.toString ( ) );
            textBuilder.append ( " " );
        }
        return textBuilder.toString ( ).trim ( );
    }
}
