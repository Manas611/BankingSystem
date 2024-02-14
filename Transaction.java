class Transaction
{
    private int transactionId;
    private String transactionType;
    private int amount;
    
    public Transaction(int transactionId, String transactionType, int amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

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
