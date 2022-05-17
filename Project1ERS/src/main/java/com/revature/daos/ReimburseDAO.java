package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimburseDAO implements ReimburseDAOInterface{

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_reimbursement;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Reimbursement> reimb = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);

				reimb.add(r);
			}
			
			return reimb;
			
		}catch (SQLException e) {
			System.out.println("Something went wrong contacting the database!");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursementByUserId(int userid) {
		ArrayList<Reimbursement> reimbList = new ArrayList<>();

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from ers_reimbursement where reimb_author_fk = ? order by reimb_id;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbList.add(
						new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbList;
	}

	@Override
	public Reimbursement getOneReimbursement(int reimb_id) {
		Reimbursement reimbursement = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_reimbursement where reimb_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimb_id);
			ResultSet rs = ps.executeQuery();

			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
						
							
			}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return reimbursement;
	}

	@Override
	public Boolean createReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ers_reimbursement (reimb_amount, reimb_description, reimb_author_fk, reimb_status_id_fk, reimb_type_id_fk,)"
					+ " VALUES(?, ?, ?, ?, ?);";
			//gets the Reimbursement object and inserts the values into the database
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimbursement.getReimb_amount());
            ps.setString(2, reimbursement.getReimb_description());
            ps.setInt(3, reimbursement.getReimb_author());
            ps.setInt(4, reimbursement.getReimb_status_id());
            ps.setInt(5, reimbursement.getReimb_type_id());
			
            return ps.executeUpdate() !=0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return false;
	}

	@Override
	public void updateReimbursement(int statusId, int userId, int reimbId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql =  "update ers_reimbursement set reimb_resolver_fk = ?, reimb_status_fk = ?, reimb_resolved = now() where reimb_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, statusId);
			ps.setInt(3, reimbId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		
	}

	
	
}
