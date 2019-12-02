
package DBDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Base.BaseDAO;
import Model.Student;

/**
 * ģ��˵���� ѧ����ɾ�Ĳ�
 * 
 */
public class StudentDAO extends BaseDAO {
	private final int fieldNum = 9;
	private final int showNum = 15;
	private static StudentDAO sd = null;
    private StudentDAO() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static synchronized StudentDAO getInstance() {
		if (sd == null) {
			sd = new StudentDAO();
		}
		return sd;
	}

	// update
	public boolean update(Student stu) {
		boolean result = false;
		if (stu == null) {
			return result;
		}
		try {
			// check
			if (queryBySno(stu.getSno()) == 0) {
				return result;
			}
			// update
			String sql = "update student set sex=?,department=?,semail=?,stel=?,hometown=?,mark=? where sname=? and sno=?";
			String[] param = { stu.getSex(), stu.getDepartment(), stu.getEmail(), stu.getTel(), stu.getHomeTown(),
					stu.getMark(), stu.getName(), stu.getSno() };
			int rowCount = db.executeUpdate(sql, param);
			if (rowCount == 1) {
				result = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}

	// delete
	public boolean delete(Student stu) {
		boolean result = false;
		if (stu == null) {
			return result;
		}
		String sql = "delete from student where sname=? and sno=?";
		String[] param = { stu.getName(), stu.getSno() };
		int rowCount = db.executeUpdate(sql, param);
		if (rowCount == 1) {
			result = true;
		}
		destroy();
		return result;
	}

	// add
	public boolean add(Student stu) {
		boolean result = false;
		if (stu == null) {
			return result;
		}
		try {
			// check
			if (queryBySno(stu.getSno()) == 1) {
				return result;
			}
			// insert
			String sql = "insert into student(sname,sno,sex,department,hometown,mark,semail,stel) values(?,?,?,?,?,?,?,?)";
			String[] param = { stu.getName(), stu.getSno(), stu.getSex(), stu.getDepartment(), stu.getHomeTown(),
					stu.getMark(), stu.getEmail(), stu.getTel() };
			if (db.executeUpdate(sql, param) == 1) {
				result = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}

	// query by name
	public String[][] queryByName(String name) {
		String[][] result = null;
		if (name.length() < 0) {
			return result;
		}
		List<Student> stus = new ArrayList<Student>();
		int i = 0;
		String sql = "select * from student where sname like ?";
		String[] param = { "%" + name + "%" };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				buildList(rs, stus, i);
				i++;
			}
			if (stus.size() > 0) {
				result = new String[stus.size()][fieldNum];
				for (int j = 0; j < stus.size(); j++) {
					buildResult(result, stus, j);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return result;
	}
	
	// query by Sno
		public String[][] queryBySnumber(String sno) {
			String[][] result = null;
			if (sno.length() < 0) {
				return result;
			}
			List<Student> stus = new ArrayList<Student>();
			int i = 0;
			String sql = "select * from student where sno like ?";
			String[] param = { "%" + sno + "%" };
			rs = db.executeQuery(sql, param);
			try {
				while (rs.next()) {
					buildList(rs, stus, i);
					i++;
				}
				if (stus.size() > 0) {
					result = new String[stus.size()][fieldNum];
					for (int j = 0; j < stus.size(); j++) {
						buildResult(result, stus, j);
					}
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				destroy();
			}
			return result;
		}

	// query
	public String[][] list(int pageNum) {
		String[][] result = null;
		if (pageNum < 1) {
			return result;
		}
		List<Student> stus = new ArrayList<Student>();
		int i = 0;
		int beginNum = (pageNum - 1) * showNum;
		String sql = "select * from student limit ?,?";
		Integer[] param = { beginNum, showNum };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				buildList(rs, stus, i);
				i++;
			}
			if (stus.size() > 0) {
				result = new String[stus.size()][fieldNum];
				for (int j = 0; j < stus.size(); j++) {
					buildResult(result, stus, j);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return result;
	}

	// ��rs��¼��ӵ�list��
	private void buildList(ResultSet rs, List<Student> list, int i) throws SQLException {
		Student stu = new Student();
		stu.setId(i + 1);
		stu.setName(rs.getString("sname"));
		stu.setDepartment(rs.getString("department"));
		stu.setEmail(rs.getString("semail"));
		stu.setHomeTown(rs.getString("hometown"));
		stu.setMark(rs.getString("mark"));
		stu.setSex(rs.getString("sex"));
		stu.setSno(rs.getString("sno"));
		stu.setTel(rs.getString("stel"));
		list.add(stu);
	}

	// ��list�м�¼��ӵ���ά������
	private void buildResult(String[][] result, List<Student> stus, int j) {
		Student stu = stus.get(j);
		result[j][0] = String.valueOf(stu.getId());
		result[j][1] = stu.getName();
		result[j][2] = stu.getSno();
		result[j][3] = stu.getSex();
		result[j][4] = stu.getDepartment();
		result[j][5] = stu.getHomeTown();
		result[j][6] = stu.getMark();
		result[j][7] = stu.getEmail();
		result[j][8] = stu.getTel();
	}

	// query by sno
	private int queryBySno(String sno) throws SQLException {
		int result = 0;
		if ("".equals(sno) || sno == null) {
			return result;
		}
		String checkSql = "select * from student where sno=?";
		String[] checkParam = { sno };
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
	}

}
