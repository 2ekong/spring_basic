package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private MyDataSource dataSource;
	
	public JikwonDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<JikwonDto> getJikwonData(String jikwonjik){
		ArrayList<JikwonDto> list = new ArrayList<>();
		 String sql = "";
	        if( jikwonjik == null || jikwonjik.isEmpty() ) {
	            sql = "select * from jikwon";
	        } else {
	            sql = "select * from jikwon where jikwonjik = ?";
	        }
	        try {
	            conn = dataSource.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, jikwonjik);
	            rs = pstmt.executeQuery();

	            while (rs.next()) {
	            	JikwonDto dto = new JikwonDto();
	                dto.setJikwonno(rs.getString("jikwonno"));
	                dto.setJikwonname(rs.getString("jikwonname"));
	                dto.setJikwongen(rs.getString("jikwongen"));
	                dto.setJikwonpay(rs.getString("jikwonpay"));
	                list.add(dto);
	            }
	        } catch (Exception e) {
	            System.out.println("getDataAll err : " + e.getMessage());
	        } finally {
	            try {
	                if(rs != null) rs.close();
	                if(pstmt != null) pstmt.close();
	                if(conn != null) conn.close();
	            } catch (Exception e2) {
	                System.out.println("closing connection err : " + e2.getMessage());
	            }
	        }

	        return list;

	}
}
