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

public class AddView extends JFrame{

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
		JButton add = new JButton("���");
	public AddView() {
		// TODO Auto-generated constructor stub
		this.setTitle("���ѧ����Ϣ");
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
		panel.add(add);
		
        add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=input_name.getText();
				String sno=input_sno.getText();
				String sex=input_sex.getText();
				String department=input_department.getText();
				String homeTown=input_homeTown.getText();
				String mark=input_mark.getText();
				String email=input_email.getText();
				String tel=input_tel.getText();
			    if(name.equals("")||sno.equals("")||sex.equals("")||department.equals("")||homeTown.equals("")||mark.equals("")||email.equals("")||tel.equals(""))
			    {
			    	JOptionPane.showMessageDialog(null, "��������д���е���Ϣ��","��ʾ",JOptionPane.WARNING_MESSAGE,null);	
			    	return ;			
			    }	
			    else {
			    	JOptionPane.showMessageDialog(null, "��ӳɹ���",null, JOptionPane.WARNING_MESSAGE);	
			    	dispose();
			    	new MainView();
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
			    ((StudentDAO)student).add(stud);
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
		new AddView();	
}
}
