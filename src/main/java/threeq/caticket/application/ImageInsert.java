package threeq.caticket.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageInsert {
	public static FileInputStream getImageByte(String infile) {
        FileInputStream imageByte = null;
        File file = new File(infile);
        try {
            imageByte = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return imageByte;
    }
    public static void main(String[] args) throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String user = "root";
        String password = "miaoxingren.233";
        String url = "jdbc:mysql://localhost:3306/caticket?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        InputStream inputStream = null;
        try {
	        for (int i = 0; i < 20; i++) {
	        	String path = "D:\\saveimg\\img" + Integer.toString(i) + ".jpg";
		        inputStream = getImageByte(path);
	            String sql = "insert into images(name,source) values(?,?)";
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, "img" + Integer.toString(i));
	            preparedStatement.setBinaryStream(2, inputStream, inputStream.available());
	            preparedStatement.execute();
		    }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null)
                        preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
