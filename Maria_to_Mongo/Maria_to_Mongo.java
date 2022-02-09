import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Maria_to_Mongo {

	public static String insert_data(String Data_name) {
		String Target_DB = "project_data";
		String Target_Collection = "data_collection";
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase db = mongoClient.getDatabase(Target_DB);
		//db.createCollection(Target_Collection);
		MongoCollection<Document> data = db.getCollection(Target_Collection);
		ArrayList<Document> doc = new ArrayList<Document>();
		
		String sql = "select * from "+Data_name;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String[] key_values = rs.getString(1).split(" ");
				switch(key_values[2].charAt(0)) {
					case 'A':
						key_values[2]="골목상권";
						break;
					case 'R':
						key_values[2]="전통시장";
						break;
					case 'U':
						key_values[2]="관광특구";
						break;
					case 'D':
						key_values[2]="발달상권";
						break;
				}
				String tmp = key_values[3];
				char t;
				 if (tmp.matches("CS1*")) {
		                t='a';
		                
		            }
		            else if(tmp.matches("CS2*")) {
		            	t='b';
		            }
		            else {
		            	t='c';
		            	
		            }
				
				
				switch(t) {
					case 'a':
						key_values[3]="외식업";
						break;
					case 'b':
						key_values[3]="서비스업";
						break;
					case 'c':
						key_values[3]="소매업";
						break;
				
				}
				String[] data_values = rs.getString(2).split("_");
				doc.add(new Document("year",key_values[0]).append(
						"quarter", key_values[1]).append(
						"commercial",key_values[2]).append(
						"service",key_values[3]).append(
						"quarter_sales",Integer.parseInt(data_values[0])).append(
						"weekday_sales",Integer.parseInt(data_values[1])).append(
						"weekend_sales",Integer.parseInt(data_values[2])).append(
						"mon_sales",Integer.parseInt(data_values[3])).append(
						"tue_sales",Integer.parseInt(data_values[4])).append(
						"wed_sales",Integer.parseInt(data_values[5])).append(
						"thu_sales",Integer.parseInt(data_values[6])).append(
						"fri_sales",Integer.parseInt(data_values[7])).append(
						"sat_sales",Integer.parseInt(data_values[8])).append(
						"sun_sales",Integer.parseInt(data_values[9])).append(
						"sales_0006",Integer.parseInt(data_values[10])).append(
						"sales_0611",Integer.parseInt(data_values[11])).append(
						"sales_1114",Integer.parseInt(data_values[12])).append(
						"sales_1417",Integer.parseInt(data_values[13])).append(
						"sales_1721",Integer.parseInt(data_values[14])).append(
						"sales_2124",Integer.parseInt(data_values[15])).append(
						"store_count",Integer.parseInt(data_values[16]))
				
						);
				
				
//				doc.add(new Document("key",rs.getString(1)).append(
//						"ename",rs.getString(2)));
			}
			data.insertMany(doc);
			
			mongoClient.close();
			conn.close();
			return Data_name+"데이터 전송 완료";
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(rs != null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		//System.out.println(insert_data("data2019"));
		for(int i=2014;i<=2020;i++) {
			System.out.println(insert_data("data"+ Integer.toString(i) ));
		}
		
		
		
	}
}
