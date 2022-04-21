package com.revature;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.daos.UserDAO;
import com.revature.daos.TransactionDAO;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;
import com.revature.models.Transaction;

public class App 
{
    public static void main( String[] args )
    {
    	
    	try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Connection Established");
		} catch (SQLException e) { //if creating this connection fails... catch the exception and print the stack trace
			System.out.println("connection failed... :(");
			e.printStackTrace();
		}
        // create scanner user can input
        Scanner sc = new Scanner(System.in);

        System.out.println( "***** Bank Application *****\n");

        boolean sessionEnd = false;
        // login status
        boolean isLogin = false;
        // store the login user's username
        String loginedUser = new String("");

        // create user and transaction daos
        UserDAO userDAO = new UserDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        while (!sessionEnd) {
            try {
                // if the user didn't login yet, enter username and password
                if (!isLogin) {
                    System.out.println("Enter your Username: ");
                    String username = sc.nextLine();
                    System.out.println("Enter your Password: ");
                    String password = sc.nextLine();

                    if (userDAO.login(username, password)) {
                        isLogin = true;
                        loginedUser = username;
                        System.out.println("Log in Successful.....");
                    }
                    else {
                        System.out.println("Username or Password incorrect.....");
                    }
                }
                // for logined user, select command number to execute CRUD query
                else {
                    System.out.println("********************************"
                                   + "\n 1 : Get all users." 
                                   + "\n 2 : Get user by username." 
                                   + "\n 3 : Create user." 
                                   + "\n 4 : Update user's password." 
                                   + "\n 5 : Delete user by username." 
                                   + "\n 6 : Get user's all transactions."
                                   + "\n 7 : Create transaction."
                                   + "\n 8 : Update transaction's amount by id"
                                   + "\n 9 : Delete transaction by id."
                                   + "\n 10 : Delete user's all transactions."
                                   + "\n 11 : Exit.");

                    System.out.println("Enter command Number.....");
                    int num = sc.nextInt();

                    if (num == 1) {
                        ArrayList allUsers = userDAO.getAllUsers();

                        if (allUsers != null) {
                            int length = allUsers.size();

                            if (length != 0) {
                                for (int index = 0; index < length; index++) {
                                    System.out.println(index + 1 + " - " + allUsers.get(index));
                                }
                            } else {
                                System.out.println("No users");
                            }
                        } else {
                            System.out.println("No users");
                        }
                    }
                    else if(num == 2) {
                        sc.nextLine();
                        System.out.println("Enter username:");
                        String username = sc.nextLine();
                        System.out.println(userDAO.getUser(username));
                    }
                    else if(num == 3) {
                        sc.nextLine();
                        System.out.println("Enter username:");
                        String username = sc.nextLine();
                        System.out.println("Enter password:");
                        String password = sc.nextLine();
                        System.out.println("Enter firstname:");
                        String firstname = sc.nextLine();
                        System.out.println("Enter lastname:");
                        String lastname = sc.nextLine();

                        User user = new User(username, password, firstname, lastname);
                        if (userDAO.createUser(user)) {
                            System.out.println("New user is created.");
                        }
                        else {
                            System.out.println("error, something is wrong");
                        }
                    }
                    else if(num == 4) {
                        sc.nextLine();
                        System.out.println("Enter username:");
                        String username = sc.nextLine();
                        System.out.println("Enter password:");
                        String password = sc.nextLine();

                        if (userDAO.updateUser(username, password)) {
                            System.out.println("password is updated.");
                        }
                        else {
                            System.out.println("error");
                        }
                    }
                    else if(num == 5) {
                        sc.nextLine();
                        System.out.println("Enter username:");
                        String username = sc.nextLine();

                        if (userDAO.deleteUser(username)) {
                            System.out.println("User: " + username + " is deleted.");
                        }
                        else {
                            System.out.println("error: no existing  user.");
                        }
                    }
                    else if(num == 6) {
                        ArrayList all = transactionDAO.getAllTransactions(loginedUser);

                        if (all != null) {
                            int length = all.size();

                            if (length != 0) {
                                for (int index = 0; index < length; index++) {
                                    System.out.println(index + 1 + " - " + all.get(index));
                                }
                            } else {
                                System.out.println("No transactions");
                            }
                        } else {
                            System.out.println("No transactions");
                        }
                    }
                    else if(num == 7) {
                        sc.nextLine();
                        System.out.println("Enter currency:");
                        String currency = sc.nextLine();
                        System.out.println("Enter amount:");
                        int amount = Integer.parseInt(sc.nextLine());

                        Transaction tx = new Transaction(loginedUser, currency, amount);
                        if (transactionDAO.createTransaction(tx) >= 0) {
                            System.out.println("New transaction is created.");
                        }
                        else {
                            System.out.println("error occured in creating new transaction");
                        }
                    }
                    else if(num == 8) {
                        sc.nextLine();
                        System.out.println("Enter transaction id:");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter amount:");
                        int amount = Integer.parseInt(sc.nextLine());

                        if (transactionDAO.updateTransaction(id, amount)) {
                            System.out.println("transaction is updated.");
                        }
                        else {
                            System.out.println("error");
                        }
                    }
                    else if(num == 9) {
                        sc.nextLine();
                        System.out.println("Enter transaction id:");
                        int id = Integer.parseInt(sc.nextLine());

                        if (transactionDAO.deleteTransaction(id)) {
                            System.out.println("transaction is deleted.");
                        }
                        else {
                            System.out.println("error: no exist transaction.");
                        }
                    }
                    else if(num == 10) {
                        if (transactionDAO.deleteAllTransactions(loginedUser)) {
                            System.out.println("user's all transactions are deleted.");
                        }
                        else {
                            System.out.println("error");
                        }
                    }
                    else if (num == 11) {                    
                        sc.close();
                        System.out.println("\n***** Have a good day, Thank you!! ******");
                        sessionEnd = true;
                    }
                    else {
                        System.out.println("Enter correct command number");
                    }
                }
            } catch(InputMismatchException e) {
                System.out.println("Input mismatch Error.");
                sc.next();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("");
                sc.next();
            }
        }
    }
}
