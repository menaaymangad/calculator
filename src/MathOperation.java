public enum MathOperation {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');
    private final char symbol;

    public char getSymbol() {

        return symbol;
    }

    MathOperation(char symbol) {
        this.symbol = symbol;
    }


}


