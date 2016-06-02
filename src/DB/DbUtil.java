package DB;



import java.sql.*;

public class DbUtil {
	private String DBDriver = "org.sqlite.JDBC";
	private String database = "jdbc:sqlite://e:/Guitars.s3db";
	public Connection conn = null;
	public ResultSet rs = null;
		
	public ResultSet query(String mySql) throws Exception {
		try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection(database);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(mySql);
			/*stmt.close();
			conn.close();*/
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ��ѯ�쳣��"+e.getMessage());
		}
		return null;
	}

	public void update(String mySql) throws Exception {
		try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection(database);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(mySql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����쳣��"+e.getMessage());
		}
	}
	
	public void setDBDriver(String DBDriver) {
		this.DBDriver = DBDriver;
	}

	public String getDBDriver() {
		return DBDriver;
	}
	
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
}