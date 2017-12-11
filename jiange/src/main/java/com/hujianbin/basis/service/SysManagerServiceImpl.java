package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hujianbin.basis.bean.SysManager;
import com.hujianbin.basis.dao.SysManagerDao;
import com.hujianbin.basis.search.SysManagerSearchBean;
import com.hujianbin.common.util.PageModel;

@Component(value="sysManagerService")
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class SysManagerServiceImpl implements SysManagerService{

	@Autowired
	@Setter
	private SysManagerDao sysManagerDao;
		
	public void addSysManager(SysManager sysManager){
		sysManagerDao.insertSysManager(sysManager);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchAddSysManager(List<SysManager> list){
		sysManagerDao.batchInsertSysManager(list);
	}
	
	public SysManager getSysManagerByExample(SysManager sysManager){
		return sysManagerDao.getSysManagerByExample(sysManager);
	}
	
	public void modifySysManagerByExample(SysManager sysManager){
		sysManagerDao.updateSysManagerByExample(sysManager);
	}
	
	public void removeSysManagerByExample(SysManager sysManager){
		sysManagerDao.deleteSysManagerByExample(sysManager);
	}
	
	public void removeSysManagerByCondition(SysManagerSearchBean condition){
		sysManagerDao.deleteSysManagerByCondition(condition);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchRemoveSysManagerByExample(List<SysManager> list){
		sysManagerDao.batchDeleteSysManagerByExample(list);
	}
	
	public PageModel querySysManagerBySql(String where,int offset,int limit){
		//condition.buildSql();//只用orderSql
		PageModel pm=new PageModel();
		pm.setOffset(offset);
		pm.setPageSize(limit);
		pm.setCount(sysManagerDao.getSysManagerCountByWhere(where));
		pm.setData(sysManagerDao.getSysManagerListByWhere(where,offset,limit));
		return pm;
	}
	
	public PageModel querySysManagerByCondition(SysManagerSearchBean condition){
		PageModel pm=new PageModel();
		pm.setOffset(condition.getStart());
		pm.setPageSize(condition.getCount());
		pm.setCount(sysManagerDao.getSysManagerCountByCondition(condition));
		pm.setData(sysManagerDao.getSysManagerListByCondition(condition));
		return pm;
	}
	
	public List<SysManager> querySysManagerListByWhere(String where){
		return sysManagerDao.getSysManagerListBySql(where);
	}
	
	public List<SysManager> querySysManagerListByExample(SysManager sysManager){
		return sysManagerDao.getSysManagerListByExample(sysManager);
	}
	
	public List<SysManager> getSysManagerByCondition(SysManagerSearchBean condition){
		return sysManagerDao.getSysManagerByCondition(condition);
	}
	
	public List<SysManager> querySysManagerListByCondition(SysManagerSearchBean condition){
		return sysManagerDao.getSysManagerListByCondition(condition);
	}
	
	public void modifySysManagerBySql(String sql){
		sysManagerDao.updateSysManagerByWhere(sql);
	}
	
	public void modifySysManagerByCondition(SysManagerSearchBean condition){
		sysManagerDao.updateSysManager(condition);
	}
	
	public void removeSysManagerBySql(String sql){
		sysManagerDao.deleteSysManagerByWhere(sql);
	}
	
	public int getSysManagerCountBySql(String sql){
		return sysManagerDao.getSysManagerCountByWhere(sql);
	}
	
	public int getSysManagerCountByExample(SysManager sysManager){
		return sysManagerDao.getSysManagerCountByExample(sysManager);
	}
	
	public int getSysManagerCountByCondition(SysManagerSearchBean condition){
		return sysManagerDao.getSysManagerCountByCondition(condition);
	}
	
	public Map<String,Object> getSysManagerColumnByCondition(SysManagerSearchBean condition){
		return sysManagerDao.getSysManagerColumnByCondition(condition);
	}
	
	public void updateSysManagerByExample(SysManager sysManager){
		sysManagerDao.updateSysManagerByExample(sysManager);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchModifySysManagerByExample(List<SysManager> list){
		sysManagerDao. batchModifySysManagerByExample(list);
	}
}
