package com.testing.piggybank.transaction;

import com.testing.piggybank.model.Currency;

import java.math.BigDecimal;

public class CreateTransactionRequest {
    private long senderAccountId;
    private long recieverAccountId;
    private String description;
    private BigDecimal amount;
    private Currency currency;

    public long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public long getRecieverAccountId() {
        return recieverAccountId;
    }

    public void setRecieverAccountId(long recieverAccountId) {
        this.recieverAccountId = recieverAccountId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
