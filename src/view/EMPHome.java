package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Employee;

public class EMPHome extends JFrame{
	
	 Container container=null;
	 JLabel LTitle;
	 JButton bViewProfile,bUpdateProfile,bUpdateSkill,bApplyJob,bLogout;
	 public EMPHome(Employee emp) {
		 container=getContentPane();
		 LTitle=new JLabel(emp.getFirstName());
		 
		 bViewProfile=new JButton("View Profile");
			bViewProfile.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
				}

			});
			
			bUpdateProfile=new JButton("Update Profile");
			bUpdateProfile.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
				}	
			});
			bUpdateSkill=new JButton("Update Skill");
			bUpdateSkill.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}	
			});
			bApplyJob=new JButton("Apply Job");
			bApplyJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}	
			});
			
			bLogout=new JButton("Sign out");
			bLogout.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}	
			});
			
			
		 
		 setLayoutManager();
		 setLocationAndSize();
		 addComponentsToContainer();
		 
		 this.setTitle("EMP Home Frame");
		 this.setVisible(true);
		 this.setBounds(10, 10, 500, 600);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
	 }
	 public void setLayoutManager() {
		 container.setLayout(null);
	 }
	 public void setLocationAndSize() {
		 LTitle.setBounds(50, 80, 300,30 );
		 bViewProfile.setBounds(50, 150, 300, 30);
		 bUpdateProfile.setBounds(50, 200, 300, 30);
		 bUpdateSkill.setBounds(50, 250, 300, 30);
		 bApplyJob.setBounds(50, 300, 300, 30);
		 bLogout.setBounds(50, 350, 300, 30);
	 }
	 public void addComponentsToContainer() {
		 container.add(LTitle);
		 container.add(bViewProfile);
		 container.add(bUpdateProfile);
		 container.add(bUpdateSkill);
	 	 container.add(bApplyJob);
		 container.add(bLogout);
	 }
}
