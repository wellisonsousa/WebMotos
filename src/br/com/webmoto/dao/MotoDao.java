package br.com.webmoto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.webmoto.model.Moto;
import br.com.webmoto.util.DBUtil;

public class MotoDao {

    private Connection connection;

    public MotoDao() {
        connection = DBUtil.getConnection();
    }

    public void addMoto(Moto moto) {
        
    	try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO MOTO (NAME, BRAND, COLOR) VALUES (?, ?, ?)");
          
            preparedStatement.setString(1, moto.getName());
            preparedStatement.setString(2, moto.getBrand());
            preparedStatement.setString(3, moto.getColor());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //addUser
    
    public void deleteMoto(Long id) {
    	
    	Moto moto = new Moto();
    	moto.setId(id);
    	
    	deleteMoto(moto);
    	
    } // deleteUser long

    public void deleteMoto(Moto user) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM MOTO WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteUser

    public void updateMoto(Moto moto) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE MOTO SET NAME=?, " 
                    		                          + "BRAND=?, " 
                    		                          + "COLOR=? " 
                                               + "WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, moto.getName());
            preparedStatement.setString(2, moto.getBrand());
            preparedStatement.setString(3, moto.getColor());
            
            preparedStatement.setLong(4, moto.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateUser

    public List<Moto> getAllMotos() {
        
    	List<Moto> motoList = new ArrayList<Moto>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM MOTO");
            while (rs.next()) {
                
            	Moto moto = new Moto();
                
            	moto.setId(rs.getLong("ID"));
            	moto.setName(rs.getString("NAME"));
            	moto.setBrand(rs.getString("BRAND"));
            	moto.setColor(rs.getString("COLOR"));

            	motoList.add(moto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motoList;
    } //getAllUser

    public Moto getMotoById(Long id) {
    	
    	Moto moto = new Moto();
    	moto.setId(id);
    	
    	return getMotoById(moto);
    	
    } // getUserById long
    
    
    	
    public Moto getMotoById(Moto moto) {

    	Moto motoOutput = new Moto();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from MOTO WHERE ID=?");
            
            preparedStatement.setLong(1, moto.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	motoOutput.setId(rs.getLong("ID"));
            	motoOutput.setName(rs.getString("NAME"));
            	motoOutput.setBrand(rs.getString("BRAND"));
            	motoOutput.setColor(rs.getString("COLOR"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motoOutput;
    } //getUserById
    
    public String getDbDate() {

    	String output="";
    	
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT now() NOW");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	output = rs.getString("NOW");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    } //getDbDate
    
} 