package cn.kgc.tangcco.tcbd1017.on.buyer.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1017.on.buyer.BuyerInfoDao;
import cn.kgc.tangcco.tcbd1017.on.pojo.BuyerInfo;

public class BuyerInfoDaoImple implements BuyerInfoDao  {
	/**
	 * 根据buyer_id查询所有
	 * @param map  传入查询参数buyer_id
	 * @return newlist  返回BuyerInfo所有信息
	 */
	QueryRunner qr=new QueryRunner();
	public List<BuyerInfo> selectAllBuyerInfosByBuyer_id(Map<String, Object> map){
		
		
			StringBuilder sql = new StringBuilder("SELECT * FROM  010101_buyer_info  ");
			sql.append(" where 1 = 1  ");
	
			
			
			
			
			List<BuyerInfo> newslist = new ArrayList<BuyerInfo>();
	
			// 动态sql开始
			List list = new ArrayList();
			if (map != null && map.size() > 0) {
	
				if (map.containsKey("buyer_id")) {
	
					sql.append(" and buyer_id = ? ");
					list.add(map.get("buyer_id"));
				}
	
			
	
			Object[] param = list.toArray();
			// 动态sql结束
	
			Connection conn;
			PreparedStatement pst;
			ResultSet rs;
			try {
	
				conn = BaseDBUtils.getConnection();
				pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
				rs = BaseDBUtils.executeQuery(pst, param);
				while (rs.next()) {
	
					newslist.add(new BuyerInfo(rs.getInt("buyer_info_id"), rs.getInt("buyer_id"),
											   rs.getInt("buyer_info_gender"), rs.getString("buyer_info_idcard"),
											   rs.getString("buyer_info_idcard_name"), rs.getDate("buyer_info_birthday"),
											   rs.getString("buyer_info_address"), rs.getString("buyer_info_icon_url"),
											   rs.getDate("buyer_info_create_time"), rs.getDate("buyer_info_update_time"),
											   rs.getInt("buyer_info_status")));
	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
						
		}
		return newslist;
	}
	/**
	 * 添加数据
	 * @param map 传入查询参数
	 * @return 返回int execute  大于0添加成功  等于0添加失败
	 */
	public  int  insertBuyerInfo(Map<String, Object>map) {
		
		StringBuilder sql = new StringBuilder(" insert into 010101_buyer_info " );
//		sql.append(" (buyer_info_id,buyer_id,buyer_info_gender,buyer_info_idcard,");
//		sql.append(" buyer_info_idcard_name,buyer_info_birthday,buyer_info_address,");
//		sql.append(" buyer_info_icon_url,buyer_info_create_time,buyer_info_update_time,buyer_info_status)");
		sql.append(" SELECT ?,?,?,?,?,?,?,?,?,?,? FROM dual WHERE NOT EXISTS");
		sql.append(" (SELECT buyer_info_id FROM 010101_buyer_info WHERE buyer_info_id = ? ) ");
		System.out.println(sql.toString());
		
		List<Object> paramList = new ArrayList<Object>();
//		map.get("buyer_info_id");
//		map.get("buyer_id");
//		map.get("buyer_info_gender");
//		map.get("buyer_info_idcard");
//		map.get("buyer_info_idcard_name");
//		map.get("buyer_info_birthday");
//		map.get("buyer_info_address");
//		map.get("buyer_info_icon_url");
//		map.get("buyer_info_create_time");
//		map.get("buyer_info_update_time");
//		map.get("buyer_info_status");
//		map.get("buyer_info_id");
		paramList.add(map.get("buyer_info_id"));
		paramList.add(map.get("buyer_id"));
		paramList.add(map.get("buyer_info_gender"));
		paramList.add(map.get("buyer_info_idcard"));
		paramList.add(map.get("buyer_info_idcard_name"));
		paramList.add(map.get("buyer_info_birthday"));
		paramList.add(map.get("buyer_info_address"));
		paramList.add(map.get("buyer_info_icon_url"));
		paramList.add(map.get("buyer_info_create_time"));
		paramList.add(map.get("buyer_info_update_time"));
		paramList.add(map.get("buyer_info_status"));
		paramList.add(map.get("buyer_info_id"));
		
		

		int execute=0;
		try {
			execute = qr.update(BaseDBUtils.getConnection(), sql.toString(), paramList.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return execute;
		
		
	}
	//修改
	public  int  update(Map<String, Object> map) {
		StringBuilder sql=new StringBuilder(" update 010101_buyer_info");
		sql.append(" where buyer_info_id=?" );
		if (map != null && map.size() > 0) {

			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ?, ");
				
			}
			
			if (map.containsKey("buyer_info_gender")) {
				sql.append("  buyer_id = ? ");
				
			}
			
			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ? ");
				
			}
			
			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ? ");
				
			}
			
			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ? ");
				
			}
			
			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ? ");
				
			}
			
			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ? ");
				
			}
			
			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ? ");
				
			}
			
			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ? ");
				
			}
			
			if (map.containsKey("buyer_id")) {
				sql.append(" set buyer_id = ? ");
				
			}
		}
		return 0;
	}
	
	
	
	
//	//测试查询
//	public void test() {
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("buyer_id", 313 );
//		List<BuyerInfo> list=selectAllBuyerInfosByBuyer_id(map);
//		
//		System.out.println(list);
//		
//	}
//	//测试添加
//	public void test01() {
//		Map<String, Object> map=new HashMap<String, Object>();
//		
//		map.put("buyer_info_id", 5);
//		map.put("buyer_id", 5);
//		map.put("buyer_info_gender", 2);
//		map.put("buyer_info_idcard", "5");
//		map.put("buyer_info_idcard_name", "小潘");
//		map.put("buyer_info_birthday", new  Date());
//		map.put("buyer_info_address", "硅谷");
//		map.put("buyer_info_icon_url","16516" );
//		map.put("buyer_info_create_time", new Date() );
//		map.put("buyer_info_update_time", new Date());
//		map.put("buyer_info_status", 2);
//	
//		int insertBuyerInfo = insertBuyerInfo(map);
//		
//		
//		if(insertBuyerInfo==0) {
//			System.out.println("shibai");
//		}else if(insertBuyerInfo> 0) {
//			System.out.println("成功");
//		}
//	}
}

	


			
