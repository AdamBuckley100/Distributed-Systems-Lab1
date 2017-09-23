// This is the mySQL JDBC GUI connection.

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Retrieve{

	public static void main(String[] args){

		JFrame theFrame = new JFrame();

		JLabel label1 = new JLabel("ID: ");
		JLabel label2 = new JLabel("First Name: ");
		JLabel label3 = new JLabel("Last Name: ");
		JLabel label4 = new JLabel("Email: ");

		JTextField text1 = new JTextField(20);
		JTextField text2 = new JTextField(20);
		JTextField text3 = new JTextField(20);
		JTextField text4 = new JTextField(20);

		try{
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection theConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2_create_db", "root", "");
			// above: please note password is blank.

			System.out.println(theConnection); //you can take this out if you want

			Statement theStatement = theConnection.createStatement();

			ResultSet resultSet = theStatement.executeQuery("select * from web_members3 where id=11");
			// Note: above replaced Data with web_members3. You can change "where id=11" to any number value.

			String id = "", firstname = "", lastname = "", email = "";

			if( resultSet.next() )
			{
				id = resultSet.getString("id");
				firstname = resultSet.getString("firstname");
				lastname = resultSet.getString("lastname");
				email = resultSet.getString("email");
			}
			
			text1.setText(id);
			text2.setText(firstname);
			text3.setText(lastname);
			text4.setText(email);
		}
		
		catch(Exception e)
		{
			//empty
		}
		
		JPanel theJPanel = new JPanel ( new GridLayout(4,4) );

		theJPanel.add(label1);
		theJPanel.add(text1);
		
		theJPanel.add(label2);
		theJPanel.add(text2);
		
		theJPanel.add(label3);
		theJPanel.add(text3);
		
		theJPanel.add(label4);
		theJPanel.add(text4);

		theFrame.add(theJPanel);
		
		theFrame.setVisible(true);
		
		theFrame.pack();
	}
}