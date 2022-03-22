package com.xoriant.xorbankonline.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import com.xoriant.xorbankonline.enums.TransactionType;

@Entity
public class Transactions {
	
	@Id
	@TableGenerator(name = "Transaction_Gen", table = "Transaction_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Transaction_Gen", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Transaction_Gen")
	private long transactionId;
	private long receiverAccountNumber;
	private double transactionAmount;
	private LocalDateTime transactionDate;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber")
	private Account account;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", receiverAccountNumber=" + receiverAccountNumber
				+ ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + "]";
	}
}
