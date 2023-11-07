package lab5;

class Punctuation {
    private Character value;

    public Punctuation ( Character value ) {
        this.value = value;
    }

    public Character getValue ( ) {
        return value;
    }

    public void setValue ( Character value ) {
        this.value = value;
    }

    @Override
    public String toString ( ) {
        return value.toString ();
    }
}
