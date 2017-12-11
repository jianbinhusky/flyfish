package com.hujianbin.basis.dao;

import org.apache.ibatis.executor.BatchResult;

import java.util.List;
import java.util.Map;
import com.hujianbin.basis.search.SysManagerSearchBean;
import com.hujianbin.basis.bean.SysManager;
/**
 * <p>Title: </p>
 *
 * <p>Description:SysManager</p>
 *
 * <p>Copyright: Copyright (c) 2011</p>
 *
 * <p>Author: Guodang Zuo</p>
 *
 * @author AutoCreate
 * @version 1.0
 */

public interface SysManagerDao {

	public int insertSysManager(SysManager sysManager);

  	public int updateSysManager(SysManager sysManager);

  	public SysManager getSysManagerByWhere(String where);
  
  	public List<SysManager> getSysManagerListByWhere(String where,int offset,int limit);
  	
  	public List<SysManager> getSysManagerListByCondition(SysManagerSearchBean condition);
  
  	public List<SysManager> getSysManagerListBySql(String sql);
  
  	public int getSysManagerCountByWhere(String where);
  	
  	public int getSysManagerCountByExample(SysManager sysManager);
  	
  	public int getSysManagerCountByCondition(SysManagerSearchBean condition);
  
  	public int updateSysManagerByWhere(String where);
  
  	public int deleteSysManagerByWhere(String where);
  	
  	public List<BatchResult> batchInsertSysManager(List<SysManager> list);
  	
  	public SysManager getSysManagerByExample(SysManager sysManager);
  	
  	public List<SysManager> getSysManagerListByExample(SysManager sysManager);
  	
  	public int deleteSysManagerByExample(SysManager sysManager);
  	
  	public int deleteSysManagerByCondition(SysManagerSearchBean condition);
  	
  	public List<BatchResult> batchDeleteSysManagerByExample(List<SysManager> list);
  	
  	public List<SysManager> getSysManagerByCondition(SysManagerSearchBean condition);
  	
  	public int updateSysManager(SysManagerSearchBean condition);
  	
  	public Map<String,Object> getSysManagerColumnByCondition(SysManagerSearchBean condition);
  	
  	public List<Map<String,Object>> getSysManagerColumnListByCondition(SysManagerSearchBean condition);
  	
  	public int updateSysManagerByExample(SysManager sysManager);
  	
  	public List<BatchResult> batchModifySysManagerByExample(List<SysManager> list);
}
