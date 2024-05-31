package model;

import java.sql.ResultSet;

import util.Connect_db;

public class CRUD extends Connect_db {
    public void insertData(String name, String path, float writing, float coding, float interview, float score, String status){
        try{
            String query = "INSERT INTO recruitment VALUES ('"+name+"', '"+path+"', "+writing+", "+coding+", "+interview+", "+score+", '"+status+"')";
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("Input Success");
        }catch(Exception ex){
            System.out.println("Input Failed " + ex.getMessage());
        }
    }

    public String[][] readData() {
        try {
            String[][] data = new String[100][7];
            String query = "SELECT * FROM recruitment";
            
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int index = 0;
            while (resultSet.next()) {
                data[index][0] = resultSet.getString("name");
                data[index][1] = resultSet.getString("path");
                data[index][2] = resultSet.getString("writing");
                data[index][3] = resultSet.getString("coding");
                data[index][4] = resultSet.getString("interview");
                data[index][5] = resultSet.getString("score");
                data[index][6] = resultSet.getString("status");
                index++;
            }

            String[][] newData = new String[index][7];

            for (int i = 0; i < index; i++)
                newData[i] = data[i];

            statement.close();
            return newData;
        } catch (Exception e) {
            System.out.println("SQL Error" + e.getMessage());
            return null;
        }
    }
    
    public void updateData(String name, String path, float writing, float coding, float interview, float score, String status) {
        try {
            String query = "UPDATE `recruitment` SET "
                + "`path`= '" + path + "', "
                + "`writing`= " + writing + ", "
                + "`coding`= " + coding + ", "
                + "`interview`= " + interview + ", "
                + "`score`= " + score + ", "
                + "`status`= '" + status + "' "
                + "WHERE `name`= '" + name + "'";
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
    
            System.out.println("update success");
        } catch (Exception e) {
            System.out.println("SQL Error" + e.getMessage());
        }
    }

    public void deleteData(String name){
        try{
            String query = "DELETE FROM `recruitment` WHERE name='" + name + "'";
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("Delete Success");
        }catch(Exception ex){
            System.out.println("Delete Failed : " + ex.getMessage());
        }
    }
}
