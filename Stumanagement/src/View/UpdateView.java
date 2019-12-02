package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.BaseDAO;
import Base.DAO;
import DBDao.StudentDAO;
import Model.Student;

public class UpdateView extends JFrame{

	    JPanel panel = new JPanel();
	    JLabel name = new JLabel("        ��        ��  :");
	    JLabel sno = new JLabel("        ѧ       ��   :");
		JLabel sex = new JLabel("        ��        ��  :");
		JLabel department = new JLabel("        Ժ        ϵ  :");
		JLabel homeTown = new JLabel("        ��        ��  :");
		JLabel mark = new JLabel("        ѧ        ��  :");
		JLabel email = new JLabel("        ��        ��  :");
		JLabel tel = new JLabel("       ��ϵ��ʽ   :");
		JTextField input_name = new JTextField();
		JTextField input_sno = new JTextField();
		JTextField input_sex = new JTextField();
		JTextField input_department = new JTextField();
		JTextField input_homeTown = new JTextField();
		JTextField input_mark = new JTextField();
		JTextField input_email = new JTextField();
		JTextField input_tel = new JTextField();
		JButton back = new JButton("����");
		JButton change = new JButton("����");
	public UpdateView() {
		// TODO Auto-generated constructor stub
		this.setTitle("����ѧ����Ϣ");
		panel.setLayout(new GridLayout(10, 2));
		panel.add(name);
		panel.add(input_name);
		panel.add(sno);
		panel.add(input_sno);
		panel.add(sex);
		panel.add(input_sex);
		panel.add(department);
		panel.add(input_department);
		panel.add(homeTown);
		panel.add(input_homeTown);
		panel.add(mark);
		panel.add(input_mark);
		panel.add(email);
		panel.add(input_email);
		panel.add(tel);
		panel.add(input_tel);
		
		panel.add(new JLabel("****************************"));
		panel.add(new JLabel("****************************"));
		panel.add(back);
		panel.add(change);
        change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=input_name.getText();
				//BaseDAO name1=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				String sno=input_sno.getText();
				//BaseDAO sno1=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				String sex=input_sex.getText();
				//BaseDAO sex1=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				String department=input_department.getText();
				//BaseDAO department1=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				String homeTown=input_homeTown.getText();
				//BaseDAO homeTown1=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				String mark=input_mark.getText();
				//BaseDAO mark1=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				String email=input_email.getText();
				//BaseDAO email1=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				String tel=input_tel.getText();
				//BaseDAO tel1=BaseDAO.getAbilityDAO(DAO.StudentDAO);
			    if(name.equals("")||sno.equals("")||sex.equals("")||department.equals("")||homeTown.equals("")||mark.equals("")||email.equals("")||tel.equals(""))
			    {
			    	JOptionPane.showMessageDialog(null, "��������д���е���Ϣ��","��ʾ",JOptionPane.WARNING_MESSAGE,null);	
			    	return ;			
			    }	
			    else {
			    	JOptionPane.showMessageDialog(null, "���³ɹ���",null, JOptionPane.WARNING_MESSAGE);	
			    	dispose();
			    	//new MainView();
			    }
			    Student stud =new Student();
		
			    stud.setName(input_name.getText());
			    stud.setSno(input_sno.getText());
			    stud.setSex(input_sex.getText());
			    stud.setDepartment(input_department.getText());
			    stud.setHomeTown(input_homeTown.getText());
			    stud.setMark(input_mark.getText());
			    stud.setEmail(input_email.getText());
			    stud.setTel(input_tel.getText());
			    
			    BaseDAO student=BaseDAO.getAbilityDAO(DAO.StudentDAO);
			    ((StudentDAO)student).update(stud);
			    new MainView();
			    dispose();
			    
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainView();
			}
		});

		this.add(panel);
		this.setVisible(true);
		this.setBounds(700, 300, 300, 400);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateView();	
}
}
