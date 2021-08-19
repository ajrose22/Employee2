import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDAO {

    //crud operations(creation of data, retrieving of data, updation of data,deletion of data)
    //insert select, update, delete in SQL

    int insert(EmpBean emp) throws ClassNotFoundException, SQLException {
        Connection con=DBUtil.getConnection();
        String sql="insert into emptab values(?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, emp.getEmpname());
        ps.setString(2, emp.getEmpemail());
        ps.setInt(3,emp.getEmpphone());

        return ps.executeUpdate(); //1 row is inserted


    }
    
    int delete(EmpBean emp)throws ClassNotFoundException, SQLException{
    	Connection con=DBUtil.getConnection();
        String sql="DELETE FROM emptab WHERE id = 1;(?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, emp.getID());
       

        return ps.executeUpdate(); //1 row is inserted
    }

 
}