/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import utils.DBHelper;

/**
 *
 * @author ADMIN
 */
public class GuessDao {
    
    public static boolean insertApplicant(int id, String name, String phone, String email, boolean gender, String deparmentID, String interviewDate, String address, String dob) throws SQLException{
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String sql = "  INSERT INTO Applicant (Applicant_id, name, phoneNumer, email, gender, department_id, interviewDate, dob, address) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

                stm = conn.prepareStatement(sql);
                stm.setInt(1, id);
                stm.setString(2, name);
                stm.setString(3, phone);
                stm.setString(4, email);
                stm.setBoolean(5, gender);
                stm.setString(6, deparmentID);
                stm.setString(7, interviewDate);
                stm.setString(8, dob);
                stm.setString(9, address);
//                java.sql.Date sqlDate = new java.sql.Date(interviewDate.getTime());
//                stm.setDate(7, sqlDate);
                int effectRow = stm.executeUpdate();

                if (effectRow > 0) {
                    result = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stm!=null) stm.close();
            if(conn!=null) conn.close();
        }
        
        return result;
    }
}
