package view;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.EmployeeController;
public class ChangePasswordFrame extends JFrame {

	Container container;
	JLabel lNewPassword,lEmployeeId,lConfirmPassword;
	JPasswordField tNewPassword,tConfirmPassword;
	JTextField tEmployeeId;
	JButton bChangePassword;
	EmployeeController empController=null;
	JFrame f;
	public ChangePasswordFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		empController=new EmployeeController();
		lNewPassword=new JLabel("New Password");
		lEmployeeId=new JLabel("Employee ID");
		lConfirmPassword=new JLabel("Confirm Password");
		tNewPassword=new JPasswordField();
		tEmployeeId=new JTextField();
		tConfirmPassword=new JPasswordField();
		
		bChangePassword=new JButton("CHANGE PASSWORD");
		bChangePassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int s1;
				String s2,s3;
				s3=new String(tNewPassword.getPassword());
				s1=Integer.parseInt(tEmployeeId.getText());
				s2=new String(tConfirmPassword.getPassword());
				empController.updateEmployee(s1, s2,s3);
			}
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Reset Password");
		this.setVisible(true);
		this.setBounds(10,10,500,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}


	private void setLayoutManager() {
		container.setLayout(null);
		
	}


	public void setLocationAndSize() {
		lEmployeeId.setBounds(50, 50, 100, 30);
		lConfirmPassword.setBounds(50, 100, 150, 30);
		lNewPassword.setBounds(50, 150, 100, 30);
		
		tEmployeeId.setBounds(200, 50, 150, 30);
		tConfirmPassword.setBounds(200, 100, 150, 30);
		tNewPassword.setBounds(200, 150, 150, 30);
		
		bChangePassword.setBounds(100, 200, 200, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(tConfirmPassword);
		container.add(lConfirmPassword);
		container.add(lNewPassword);
		container.add(lConfirmPassword);
		container.add(tNewPassword);
		container.add(bChangePassword);
		
	}
}
