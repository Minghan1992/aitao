package  cn.kgc.tangcco.tcbd1017.on.buyer.impl;
import java.sql.SQLException;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1017.on.buyer.BuyerInfoDao;
import cn.kgc.tangcco.tcbd1017.on.buyer.BuyerInfoService;
import cn.kgc.tangcco.tcbd1017.on.pojo.BuyerInfo;

public class BuyerInfoServiceImple implements BuyerInfoService{
	private static BuyerInfoDao buyerInfoDao;
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"ApplicationContext_on.xml");
	static {
		try {
			buyerInfoDao= (BuyerInfoDao) context.getBean(BuyerInfoDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	BuyerInfoDao buyerInfoDao=new BuyerInfoDaoImple();
	
	/**
	 * 通过买家id   Buyer_id 查询所有个人信息
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> queryBuyerInfoByBuyer_id(Map<String, Object>  map) throws SQLException {
		// 声明一个map存储个人资料信息
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		/**
		 * 默认值为0 0 非法查询<br>
		 * 1 未分配<br>
		 * 2 人事部<br>
		 * 3 只显示自己所在部门
		 * int code = 0;
		 * map.put("code", code);
		 */
		
		// 查询状态 默认是为failed
		map1.put("status", "failed");
		
		try {
			// 调用持久层方法返回查询结果
			List<BuyerInfo> buyerInfoList = buyerInfoDao.selectAllBuyerInfosByBuyer_id(map);
			if (buyerInfoList.size() > 0) {
				// 如果查询结果返回的集合的元素的数量大于0则代表有返回结果
            map1.put("date",buyerInfoList);
            map1.put("status", "success");
			}
			
		}
		finally {
			try {
				// 将连接归还给连接池
				BaseDBUtils.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 将查询结果返回
		return map1;
	}
	
	/**
	 * 根据买家详细id  修改删除
	 * @param map
	 * @return
	 */
	public Map<String, Object> removeAndModify_BuyerInfoBybuyer_id(Map<String, Object> map){
		Map<String, Object> map2=new  HashMap<String, Object>();
		map2.put("status", "failed");
		try {
			//开启事务
			BaseDBUtils.startTransaction();
			int i=buyerInfoDao.update(map);
			
			if (i>0) {
				map2.put("date", i);
				map2.put("status", "success");
			}
			
			BaseDBUtils.commitAndClose();
		} catch (Exception e) {
			try {
				//关闭事务事务回滚
				BaseDBUtils.rollbackAndClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return map2;
		
	}
	/**
	 * 增加
	 * @param map
	 * @return
	 */
	public Map<String, Object> addBuyerInfo(Map<String, Object> map){
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("status", "failed");
		try {
			//开启事务
			BaseDBUtils.startTransaction();
			int i=buyerInfoDao.insertBuyerInfo(map);
			if (i>0) {
				map3.put("date", i);
				map3.put("status", "success");
			}
			//关闭事务
			BaseDBUtils.commitAndClose();;
		} catch (Exception e) {
			try {
				//异常时关闭事务并回滚
				BaseDBUtils.rollbackAndClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO: handle exception
		}
		return map3;
		
	}
	
	
	
}

	
	


