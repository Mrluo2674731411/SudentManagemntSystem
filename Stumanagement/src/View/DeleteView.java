package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.BaseDAO;
import Base.DAO;
import DBDao.StudentDAO;
import Model.Student;

public class DeleteView extends JFrame{
	JPanel panel =new JPanel();//��һ��������
	
	JLabel sno=new JLabel("ѧ��");
	JLabel name=new JLabel("����");
	
	JTextField input_sno=new JTextField(20);
	JTextField input_name=new JTextField(20);
	
	JButton tijiao=new JButton("�ύ");
	JButton back=new JButton("����");
	public DeleteView() {
		
		this.setTitle("ɾ��ѧ����Ϣ");
		panel.setPreferredSize(new Dimension(100, 100));
		//panel.setLayout(new GridLayout(4,2));//���ô������񲼾�
		panel.add(sno);
		panel.add(input_sno);
		panel.add(name);
		panel.add(input_name);
		panel.add(new JLabel("**********************************************"));
		panel.add(tijiao);
		panel.add(back);
		
		tijiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				String sno=input_sno.getText();
				String name=input_name.getText();
				Student stu=new Student();
				stu.setName(name);
				stu.setSno(sno);
				BaseDAO bd=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				
				((StudentDAO)bd).delete(stu);	
			}	
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
		      new MainView();
			}	
		});
		
		this.add(panel);//ָ��ǰ����󣬰������ڼ��صĿ����
		this.setVisible(true);//���ô���ɼ�
		this.setBounds(800,500,280,180);//���ú��������͸�
		//���õ�����ر�ʱ��Ĭ�Ϲر������������С��رյ�ʱ���������
	}
}
