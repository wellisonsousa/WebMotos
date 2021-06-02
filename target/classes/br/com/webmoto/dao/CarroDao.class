package br.com.webmoto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.webmoto.model.Carro;
import br.com.webmoto.util.DBUtil;

public class CarroDao {

    private Connection connection;

    public CarroDao() {
        connection = DBUtil.getConnection();
    }

    public void addCarro(Carro carro) {
        
    	try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO CARRO (NAME, BRAND, COLOR) VALUES (?, ?, ?)");
          
            preparedStatement.setString(1, carro.getName());
            preparedStatement.setString(2, carro.getBrand());
            preparedStatement.setString(3, carro.getColor());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCarro(Long id) {
    	
    	Carro carro = new Carro();
    	carro.setId(id);
    	
    	deleteCarro(carro);
    	
    }

    public void deleteMoto(Moto moto) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM CARRO WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setLong(1, moto.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    public void updateCarro(Carro moto) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE CARRO SET NAME=?, " 
                    		                          + "BRAND=?, " 
                    		                          + "COLOR=? " 
                                               + "WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, carro.getName());
            preparedStatement.setString(2, carro.getBrand());
            preparedStatement.setString(3, carro.getColor());
            
            preparedStatement.setLong(4, carro.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    public List<Carro> getAllCarros() {
        
    	List<Carro> carroList = new ArrayList<Carro>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM CARRO");
            while (rs.next()) {
                
            	Moto moto = new Moto();
                
            	moto.setId(rs.getLong("ID"));
            	moto.setName(rs.getString("NAME"));
            	moto.setBrand(rs.getString("BRAND"));
            	moto.setColor(rs.getString("COLOR"));

            	carroList.add(moto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motoList;
    } 

    public Carro getMotoById(Long id) {
    	
    	Carro carro = new Carro();
    	carro.setId(id);
    	
    	return getCarroById(carro);
    	
    } 
    	
    public Carro getCarroById(Carro carro) {

    	Carro carroOutput = new Carro();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from CARRO WHERE ID=?");
            
            preparedStatement.setLong(1, moto.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	carroOutput.setId(rs.getLong("ID"));
            	carroOutput.setName(rs.getString("NAME"));
            	carroOutput.setBrand(rs.getString("BRAND"));
            	carroOutput.setColor(rs.getString("COLOR"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motoOutput;
    }
    
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
    } 
    
} 