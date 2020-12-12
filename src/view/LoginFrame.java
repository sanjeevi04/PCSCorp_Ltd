package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmployeeController;
import model.Employee;

public class LoginFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Container container;
 JLabel lUserId,lPassword,lMessage;
 JTextField tUserId;
 JPasswordField tPassword;
 JButton bLogin,bRegister;
 JCheckBox cShowPassword;
 EmployeeController empController=null;
 
 public LoginFrame() throws ClassNotFoundException, SQLException {
	 container=getContentPane();
	 lUserId=new JLabel("USERNAME");
	 lPassword=new JLabel("PASSWORD");
	 lMessage=new JLabel();
	 tUserId=new JTextField();
	 tPassword=new JPasswordField();
	 bLogin=new JButton("LOGIN");
	 empController=new EmployeeController();
	
	 bLogin.addActionListener(new ActionListener() {
		 
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 String userId,password;
			 Employee emp=new Employee();
			 userId=tUserId.getText();
			 password=new String(tPassword.getPassword());
		
			emp=empController.checkLogin(userId, password);
			 if(emp==null) {
				 
				 lMessage.setText("You are not authorized user! Retry or Register!");			 
			       
			 }
			 else {
				 if(emp.getRole().equals("EMP"))
					{
					 new EMPHome(emp);
					}
					else if(emp.getRole().equals("HRA"))
					{
						
						try {
							new HRAHome();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else 
					{
						new PMEHome();
					}
			 }
		 }
	 });
	 bRegister=new JButton("REGISTER");
	 bRegister.addActionListener(new ActionListener() {
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 try {
				new RegistrationFrame();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		 }
	 });
	 cShowPassword=new JCheckBox("Show Password");
	 setLayoutManager();
	 setLocationAndSize();
	 addComponentsToContainer();
	 this.setTitle("User Login ");
	 this.setVisible(true);
	 this.setBounds(10, 10, 500, 500);
	 this.setResizable(false);
 }
 
 public void setLayoutManager() {
	 container.setLayout(null);
 }
 public void setLocationAndSize() {
	 lMessage.setBounds(50,80,300,30);
	 lUserId.setBounds(50, 100, 100, 30);
	 lPassword.setBounds(50, 200, 100, 30);
	 tUserId.setBounds(200, 100, 150, 30);
	 tPassword.setBounds(200, 200, 150, 30);
	 bLogin.setBounds(125, 300, 100, 30);
	 bRegister.setBounds(275, 300, 100, 30);
 }
 public void addComponentsToContainer() {
	 container.add(lUserId);
	 container.add(tUserId);
	 container.add(lPassword);
	 container.add(tPassword);
	 container.add(bLogin);
	 container.add(bRegister);
	 container.add(lMessage);
 }
}
