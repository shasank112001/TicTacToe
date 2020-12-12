package TicTac;

public enum Mark {
    X("X"),O("O"),EMPTY("empty");
    private String symbol;


    Mark(String symbol) {
        this.symbol = symbol;
    }

    public Mark getOther(){
        if(this.equals(X)){
            return O;
        }
        else if (this.equals(O)){
            return X;
        }
        else return EMPTY;
    }

    public String toString(){
        return this.symbol;
    }
}
