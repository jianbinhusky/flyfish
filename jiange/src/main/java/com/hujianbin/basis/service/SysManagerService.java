package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;
import com.hujianbin.basis.bean.SysManager;
import com.hujianbin.basis.search.SysManagerSearchBean;
import com.hujianbin.common.util.PageModel;

public interface SysManagerService {

	/**
	 * 新增SysManager记录
	 * @param SysManager
	 */
	public void addSysManager(SysManager sysManager);
	
	/**
	 * 批量新增SysManager记录
	 * @param List
	 */
	public void batchAddSysManager(List<SysManager> list);
	
	/**
	 * 按照实例查找SysManager记录,主要为根据主键查找
	 * @param sysManager
	 * @return SysManager
	 */
	public SysManager getSysManagerByExample(SysManager sysManager);
	
	/**
	 * 修改SysManager记录
	 * @param SysManager
	 */
	public void modifySysManagerByExample(SysManager sysManager);
	
	/**
	 * 根据SysManager实例删除记录
	 * @param SysManager
	 */
	public void removeSysManagerByExample(SysManager sysManager);
	
	/**
	 * 根据条件删除记录
	 * @param SysManagerSearchBean
	 */
	public void removeSysManagerByCondition(SysManagerSearchBean condition);
	
	public void batchRemoveSysManagerByExample(List<SysManager> list);
	
	public void batchModifySysManagerByExample(List<SysManager> list);
	
	public PageModel querySysManagerByCondition(SysManagerSearchBean condition);
	
	public PageModel querySysManagerBySql(String sql,int offset,int limit);
	
	public List<SysManager> querySysManagerListByWhere(String where);
	
	public List<SysManager> querySysManagerListByExample(SysManager sysManager);
	
	public List<SysManager> getSysManagerByCondition(SysManagerSearchBean condition);
	
	public List<SysManager> querySysManagerListByCondition(SysManagerSearchBean condition);
	
	public void modifySysManagerBySql(String sql);
	
	public void modifySysManagerByCondition(SysManagerSearchBean condition);
	
	public void removeSysManagerBySql(String sql);
	
	public int getSysManagerCountBySql(String sql);
	
	public int getSysManagerCountByExample(SysManager sysManager);
	
	public int getSysManagerCountByCondition(SysManagerSearchBean condition);
	
	public Map<String,Object> getSysManagerColumnByCondition(SysManagerSearchBean condition);
	
	public void updateSysManagerByExample(SysManager sysManager);
}
