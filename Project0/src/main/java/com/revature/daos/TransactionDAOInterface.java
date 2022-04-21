package com.revature.daos;

import com.revature.models.Transaction;

import java.util.ArrayList;


// Recall that interfaces contain abstract methods. They are meant to be implemented by concrete classes
// We want to UserDAO to implement this interface, for the sake of organizing what we want our UserDAO to do
public interface TransactionDAOInterface {

	// This method will take in an transaction object, and insert it into the database
	int createTransaction(Transaction transaction);

	// update transaction amount by id
	boolean updateTransaction(int id, int amount);

	// This method will delete transaction by currency from the database
	boolean deleteTransaction(int id);

	// delete user's all transactions by username
	boolean deleteAllTransactions(String username);

	// get transaction by id
	Transaction getTransaction(int id);

	// get all transactions of the user by username
	ArrayList<Transaction> getAllTransactions(String username);
}