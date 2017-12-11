package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hujianbin.basis.bean.GirlCategory;
import com.hujianbin.basis.dao.GirlCategoryDao;
import com.hujianbin.basis.search.GirlCategorySearchBean;
import com.hujianbin.common.util.PageModel;

@Component(value="girlCategoryService")
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class GirlCategoryServiceImpl implements GirlCategoryService{

	@Autowired
	@Setter
	private GirlCategoryDao girlCategoryDao;
		
	@Override
	public void addGirlCategory(GirlCategory girlCategory){
		girlCategoryDao.insertGirlCategory(girlCategory);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchAddGirlCategory(List<GirlCategory> list){
		girlCategoryDao.batchInsertGirlCategory(list);
	}
	
	@Override
	public GirlCategory getGirlCategoryByExample(GirlCategory girlCategory){
		return girlCategoryDao.getGirlCategoryByExample(girlCategory);
	}
	
	@Override
	public void modifyGirlCategoryByExample(GirlCategory girlCategory){
		girlCategoryDao.updateGirlCategoryByExample(girlCategory);
	}
	
	@Override
	public void removeGirlCategoryByExample(GirlCategory girlCategory){
		girlCategoryDao.deleteGirlCategoryByExample(girlCategory);
	}
	
	@Override
	public void removeGirlCategoryByCondition(GirlCategorySearchBean condition){
		girlCategoryDao.deleteGirlCategoryByCondition(condition);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchRemoveGirlCategoryByExample(List<GirlCategory> list){
		girlCategoryDao.batchDeleteGirlCategoryByExample(list);
	}
	
	@Override
	public PageModel queryGirlCategoryBySql(String where,int offset,int limit){
		//condition.buildSql();//只用orderSql
		PageModel pm=new PageModel();
		pm.setOffset(offset);
		pm.setPageSize(limit);
		pm.setCount(girlCategoryDao.getGirlCategoryCountByWhere(where));
		pm.setData(girlCategoryDao.getGirlCategoryListByWhere(where,offset,limit));
		return pm;
	}
	
	@Override
	public PageModel queryGirlCategoryByCondition(GirlCategorySearchBean condition){
		PageModel pm=new PageModel();
		pm.setOffset(condition.getStart());
		pm.setPageSize(condition.getCount());
		pm.setCount(girlCategoryDao.getGirlCategoryCountByCondition(condition));
		pm.setData(girlCategoryDao.getGirlCategoryListByCondition(condition));
		return pm;
	}
	
	@Override
	public List<GirlCategory> queryGirlCategoryListByWhere(String where){
		return girlCategoryDao.getGirlCategoryListBySql(where);
	}
	
	@Override
	public List<GirlCategory> queryGirlCategoryListByExample(GirlCategory girlCategory){
		return girlCategoryDao.getGirlCategoryListByExample(girlCategory);
	}
	
	@Override
	public List<GirlCategory> getGirlCategoryByCondition(GirlCategorySearchBean condition){
		return girlCategoryDao.getGirlCategoryByCondition(condition);
	}
	
	@Override
	public List<GirlCategory> queryGirlCategoryListByCondition(GirlCategorySearchBean condition){
		return girlCategoryDao.getGirlCategoryListByCondition(condition);
	}
	
	@Override
	public void modifyGirlCategoryBySql(String sql){
		girlCategoryDao.updateGirlCategoryByWhere(sql);
	}
	
	@Override
	public void modifyGirlCategoryByCondition(GirlCategorySearchBean condition){
		girlCategoryDao.updateGirlCategory(condition);
	}
	
	@Override
	public void removeGirlCategoryBySql(String sql){
		girlCategoryDao.deleteGirlCategoryByWhere(sql);
	}
	
	@Override
	public int getGirlCategoryCountBySql(String sql){
		return girlCategoryDao.getGirlCategoryCountByWhere(sql);
	}
	
	@Override
	public int getGirlCategoryCountByExample(GirlCategory girlCategory){
		return girlCategoryDao.getGirlCategoryCountByExample(girlCategory);
	}
	
	@Override
	public int getGirlCategoryCountByCondition(GirlCategorySearchBean condition){
		return girlCategoryDao.getGirlCategoryCountByCondition(condition);
	}
	
	@Override
	public Map<String,Object> getGirlCategoryColumnByCondition(GirlCategorySearchBean condition){
		return girlCategoryDao.getGirlCategoryColumnByCondition(condition);
	}
	
	@Override
	public void updateGirlCategoryByExample(GirlCategory girlCategory){
		girlCategoryDao.updateGirlCategoryByExample(girlCategory);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchModifyGirlCategoryByExample(List<GirlCategory> list){
		girlCategoryDao. batchModifyGirlCategoryByExample(list);
	}
}
