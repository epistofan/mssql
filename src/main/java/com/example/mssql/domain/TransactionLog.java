package com.example.mssql.domain;



import java.util.Date;
import java.util.Objects;


public class TransactionLog {

    public TransactionLog() {

    }

    public TransactionLog(int transactionId, int userId, int transactionTypeCode, Date transactionDate, Date transactionTime, String note) {
        TransactionId = transactionId;
        UserId = userId;
        TransactionTypeCode = transactionTypeCode;
        TransactionDate = transactionDate;
        TransactionTime = transactionTime;
        Note = note;
    }


    private int TransactionId;


    private int UserId;

    private int TransactionTypeCode;

    private java.util.Date TransactionDate;

    private java.util.Date TransactionTime;

    private String Note;

    public int getTransactionId() {
        return TransactionId;
    }

    public int getUserId() {
        return UserId;
    }

    public int getTransactionTypeCode() {
        return TransactionTypeCode;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public Date getTransactionTime() {
        return TransactionTime;
    }

    public String getNote() {
        return Note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionLog that = (TransactionLog) o;
        return TransactionId == that.TransactionId &&
                UserId == that.UserId &&
                TransactionTypeCode == that.TransactionTypeCode &&
                Objects.equals(TransactionDate, that.TransactionDate) &&
                Objects.equals(TransactionTime, that.TransactionTime) &&
                Objects.equals(Note, that.Note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TransactionId, UserId, TransactionTypeCode, TransactionDate, TransactionTime, Note);
    }
}
