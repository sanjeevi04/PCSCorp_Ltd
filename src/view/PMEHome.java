package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class PMEHome extends JFrame {
	 Container container=null;
	 
	 JLabel lTitle;
	 JButton bViewAllSkill,bAddJob,bViewAllJobs,bViewEmpbySkill,bViewJobsbySkill,bSetDeactiveJob,bLogout;
		
		
	 public PMEHome() {
		 container=getContentPane();
		 lTitle=new JLabel("Welcome to PME Portal");
		 
		 
		 bViewAllSkill=new JButton("View All Skills");
			bViewAllSkill.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new AllSkillsFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			});
			
			
			bAddJob=new JButton("Add an Job");
			bAddJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						new AddJobFrame();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			});
			
			
			bViewAllJobs=new JButton("View All Jobs");
			bViewAllJobs.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new AllJobsFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			});
			
			
			bSetDeactiveJob=new JButton("Deactivate Job");
			bSetDeactiveJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new DeactivateJobFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			bLogout=new JButton("Logout");
			bLogout.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Logout();	
				}	
			});
		 
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		 this.setTitle("PME Frame");
		 this.setVisible(true);
		 this.setBounds(10, 10, 500, 600);
		 this.setResizable(true);
	 }


	private void addComponentsToContainer() {
		// TODO Auto-generated method stub
		container.add(lTitle);
		container.add(bViewAllSkill);	
		container.add(bAddJob);	
		container.add(bViewAllJobs);		
		container.add(bSetDeactiveJob);	
		container.add(bLogout);
		
	}


	private void setLocationAndSize() {
		// TODO Auto-generated method stub
		lTitle.setBounds(100, 30, 300, 30);
		bViewAllSkill.setBounds(100,100,300,30);
		bAddJob.setBounds(100,150,300,30);
		bViewAllJobs.setBounds(100,200,300,30);
		bSetDeactiveJob.setBounds(100,300,300,30);
		bLogout.setBounds(150,400,100,30);
	}


	private void setLayoutManager() {
		// TODO Auto-generated method stub
		container.setLayout(null);
		
	}


	protected void Logout() {
		// TODO Auto-generated method stub
		
	}
}
