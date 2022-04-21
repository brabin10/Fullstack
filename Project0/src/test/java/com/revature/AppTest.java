package com.revature;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;
import com.revature.daos.UserDAO;
import com.revature.daos.TransactionDAO;
import com.revature.models.User;
import com.revature.models.Transaction;

public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

	
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    // test database connection
    public void testConnectionUtil() {
        try {
            Connection conn = ConnectionUtil.getConnection();
            assertNotNull(conn);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // test create new user
    public void testCreateUser() {
        User user = new User("user", "mypass", "Steven", "Gerrard");

        UserDAO userDAO = new UserDAO();

        userDAO.createUser(user);       
        User userFromDB = userDAO.getUser("user");
        assertEquals("mypass", userFromDB.getPassword());
    }
    
 // test get user
    public void testGetUser() {
        User user = new User("user0", "mypass", "Steven", "Gerrard");

        UserDAO userDAO = new UserDAO();

        userDAO.createUser(user);       
        User userFromDB = userDAO.getUser("user0");
        assertEquals("Steven", userFromDB.getFirstname());
    }

    public void testUpdateUser() {
        User user = new User("user1", "mypass", "Steven", "Gerrard");

        UserDAO userDAO = new UserDAO();

        userDAO.createUser(user);
        userDAO.updateUser("user1", "verysecret");

        User userFromDB = userDAO.getUser("user1");

        assertEquals("verysecret", userFromDB.getPassword());
    }

    // test delete user by username
    public void testDeleteUser() {
        UserDAO userDAO = new UserDAO();

        userDAO.deleteUser("user");

        User userFromDB = userDAO.getUser("user");
        assertNull(userFromDB);
    }

    // test login with username and password
    public void testLoginUser() {
        User user = new User("user2", "mypass", "Steven", "Gerrard");

        UserDAO userDAO = new UserDAO();
        userDAO.createUser(user);

        assertTrue(userDAO.login("user2", "mypass"));
    }


    // test create a new transaction
    public void testCreateTransaction() {
        User user = new User("user3", "mypass", "Steven", "Gerrard");
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(user);

        Transaction tx = new Transaction("user3", "USD", 120);

        TransactionDAO transactionDAO = new TransactionDAO();

        int id = transactionDAO.createTransaction(tx);

        Transaction txFromDB = transactionDAO.getTransaction(id);
        assertEquals(120, txFromDB.getAmount());
    }

    // test update transaction by id
    public void testUpdateTransaction() {
        User user = new User("user4", "mypass", "Steven", "Gerrard");
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(user);

        Transaction tx = new Transaction("user4", "USD", 150);

        TransactionDAO transactionDAO = new TransactionDAO();

        int id = transactionDAO.createTransaction(tx);

        transactionDAO.updateTransaction(id, 100);

        Transaction txFromDB = transactionDAO.getTransaction(id);
        assertEquals(100, txFromDB.getAmount());
    }
    
    

    // test delete transaction by id
    public void testDeleteTransaction() {
        User user = new User("user5", "mypass", "Steven", "Gerrard");
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(user);

       Transaction tx = new Transaction("user5", "USD", 200);

        TransactionDAO transactionDAO = new TransactionDAO();

        int id = transactionDAO.createTransaction(tx);

        transactionDAO.deleteTransaction(id);

        Transaction txFromDB = transactionDAO.getTransaction(id);
        assertNull(txFromDB);
    }
    
 // test delete all transactions by username
    public void testDeleteAllTransactions() {
        TransactionDAO transactionDAO = new TransactionDAO();

        transactionDAO.deleteAllTransactions("user3");

        assertEquals(0, transactionDAO.getAllTransactions("user3").size());
    }
}
