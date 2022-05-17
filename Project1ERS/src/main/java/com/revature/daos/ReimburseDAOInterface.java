package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimburseDAOInterface {

	ArrayList<Reimbursement> getAllReimbursements();
	
	ArrayList<Reimbursement> getAllReimbursementByUserId(int userid);
	
	Reimbursement getOneReimbursement (int reimbid);
	
    Boolean createReimbursement (Reimbursement reimbursement);
    
    void updateReimbursement (int statusId, int userId, int reimbId);
    
    void deleteReimbursement (int id);
	
	
}
