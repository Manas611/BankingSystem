class Transaction
{
    private int transactionId;
    private String transactionType;
    private int amount;

    // constructor for the transaction which sets the value
    public Transaction(int transactionId, String transactionType, int amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }


    // Getter of the transaction class for the values to be used
    public int getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getAmount() {
        return amount;
    }   
}
