package com.rcb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.Docter;

public class DocterDao {
DbConnection db=new DbConnection();


//public void deleteDocter(int userId) {
//    try {
//        PreparedStatement preparedStatement = connection
//                .prepareStatement("delete from users where userid=?");
//        // Parameters start with 1
//        preparedStatement.setInt(1, userId);
//        preparedStatement.executeUpdate();
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}

//public void updateUser(User user) {
//    try {
//        PreparedStatement preparedStatement = connection
//                .prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?" +
//                        "where userid=?");
//        // Parameters start with 1
//        preparedStatement.setString(1, user.getFirstName());
//        preparedStatement.setString(2, user.getLastName());
//        preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
//        preparedStatement.setString(4, user.getEmail());
//        preparedStatement.setInt(5, user.getUserid());
//        preparedStatement.executeUpdate();
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}

public List<Docter> getAllDocters() {
    List<Docter> docters = new ArrayList<Docter>();
    try {
        String sql="select * from tbl_docter";
        ResultSet rs =db.getData(sql) ;
        while (rs.next()) {
            Docter docter = new Docter();
            docter.setD_id(rs.getInt("d_id"));
            docter.setD_FName(rs.getString("d_fname"));
            docter.setD_LName(rs.getString("d_lname"));
            docter.setD_dob(rs.getDate("d_dob"));
            docter.setD_email(rs.getString("d_email"));
            docters.add(docter);
        }   
    } catch (Exception e) {
        e.printStackTrace();
    }

    return docters;

	}

}
//public User getUserById(int userId) {
//    User user = new User();
//    try {
//        PreparedStatement preparedStatement = connection.
//                prepareStatement("select * from users where userid=?");
//        preparedStatement.setInt(1, userId);
//        ResultSet rs = preparedStatement.executeQuery();
//
//        if (rs.next()) {
//            user.setUserid(rs.getInt("userid"));
//            user.setFirstName(rs.getString("firstname"));
//            user.setLastName(rs.getString("lastname"));
//            user.setDob(rs.getDate("dob"));
//            user.setEmail(rs.getString("email"));
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//
//    return user;
//}


