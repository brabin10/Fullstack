package com.revature.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Transaction;
import com.revature.utils.ConnectionUtil;
import com.revature.daos.UserDAOInterface;

public class TransactionDAO implements TransactionDAOInterface {
	// This method will take in an transaction object, and insert it into the database
	public int createTransaction(Transaction tx) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getConnection();
			// a string that will represent our SQL statement
			String sql = "INSERT INTO transactions" +
					" (username, currency, amount) VALUES " +
					" (?, ?, ?);";

			// a statement object to execute our query, generated keys when new row is inserted
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, tx.getUsername());
			pstmt.setString(2, tx.getCurrency());
			pstmt.setInt(3, tx.getAmount());

			// execute query
			pstmt.execute();

			// get inserted row id
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally {
			ConnectionUtil.close(con, pstmt);
		}

		return -1;
	}
	// update transaction amount by id
	public boolean updateTransaction(int id, int amount) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			con = ConnectionUtil.getConnection();

			// a statement object to execute our query
			String sql = "UPDATE transactions SET amount=? WHERE id=?";

			// a statement object to execute our query
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, id);

			int result = pstmt.executeUpdate();

			if(result == 1){
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally{
			ConnectionUtil.close(con, pstmt);
		}
		return false;
	}

	// This method will delete transaction by currency from the database
	public boolean deleteTransaction(int id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM transactions where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			int result = pstmt.executeUpdate();

			if(result == 1){
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally {
			ConnectionUtil.close(con, pstmt);
		}
		return false;
	}

	// delete user's all transactions by username
	public boolean deleteAllTransactions(String username) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM transactions where username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);

			int result = pstmt.executeUpdate();

			if(result == 1){
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally {
			ConnectionUtil.close(con, pstmt);
		}
		return false;
	}

	// get transaction by id
	public Transaction getTransaction(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Transaction tx = null;

		try{
			con = ConnectionUtil.getConnection();

			String sql = "SELECT username, currency, amount FROM transactions WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			if(rset.next()){
				tx = new Transaction(rset.getString(1), rset.getString(2), rset.getInt(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally{
			ConnectionUtil.close(con, pstmt, rset);
		}
		return tx;
	}

	// get all transactions of the user by username
	public ArrayList<Transaction> getAllTransactions(String username) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Transaction> list = null;

		try{
			con = ConnectionUtil.getConnection();

			String sql = "SELECT transactions.id, transactions.username, currency, amount, firstname, lastname FROM transactions INNER JOIN users ON transactions.username = users.username WHERE transactions.username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);

			rset = pstmt.executeQuery();
			list = new ArrayList<Transaction>();

			while(rset.next()) {
				Transaction tx = new Transaction(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5), rset.getString(6));
				list.add(tx);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally{
			ConnectionUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
