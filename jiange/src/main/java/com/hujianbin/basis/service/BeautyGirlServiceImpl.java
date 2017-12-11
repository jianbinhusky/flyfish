package com.hujianbin.basis.service;

import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hujianbin.basis.bean.BeautyGirl;
import com.hujianbin.basis.dao.BeautyGirlDao;
import com.hujianbin.basis.search.BeautyGirlSearchBean;
import com.hujianbin.common.util.PageModel;

@Component(value="beautyGirlService")
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class BeautyGirlServiceImpl implements BeautyGirlService{

	@Autowired
	@Setter
	private BeautyGirlDao beautyGirlDao;
		
	@Override
	public void addBeautyGirl(BeautyGirl beautyGirl){
		beautyGirlDao.insertBeautyGirl(beautyGirl);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchAddBeautyGirl(List<BeautyGirl> list){
		beautyGirlDao.batchInsertBeautyGirl(list);
	}
	
	@Override
	public BeautyGirl getBeautyGirlByExample(BeautyGirl beautyGirl){
		return beautyGirlDao.getBeautyGirlByExample(beautyGirl);
	}
	
	@Override
	public void modifyBeautyGirlByExample(BeautyGirl beautyGirl){
		beautyGirlDao.updateBeautyGirlByExample(beautyGirl);
	}
	
	@Override
	public void removeBeautyGirlByExample(BeautyGirl beautyGirl){
		beautyGirlDao.deleteBeautyGirlByExample(beautyGirl);
	}
	
	@Override
	public void removeBeautyGirlByCondition(BeautyGirlSearchBean condition){
		beautyGirlDao.deleteBeautyGirlByCondition(condition);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchRemoveBeautyGirlByExample(List<BeautyGirl> list){
		beautyGirlDao.batchDeleteBeautyGirlByExample(list);
	}
	
	@Override
	public PageModel queryBeautyGirlBySql(String where,int offset,int limit){
		//condition.buildSql();//只用orderSql
		PageModel pm=new PageModel();
		pm.setOffset(offset);
		pm.setPageSize(limit);
		pm.setCount(beautyGirlDao.getBeautyGirlCountByWhere(where));
		pm.setData(beautyGirlDao.getBeautyGirlListByWhere(where,offset,limit));
		return pm;
	}
	
	@Override
	public PageModel queryBeautyGirlByCondition(BeautyGirlSearchBean condition){
		PageModel pm=new PageModel();
		pm.setOffset(condition.getStart());
		pm.setPageSize(condition.getCount());
		pm.setCount(beautyGirlDao.getBeautyGirlCountByCondition(condition));
		pm.setData(beautyGirlDao.getBeautyGirlListByCondition(condition));
		return pm;
	}
	
	@Override
	public List<BeautyGirl> queryBeautyGirlListByWhere(String where){
		return beautyGirlDao.getBeautyGirlListBySql(where);
	}
	
	@Override
	public List<BeautyGirl> queryBeautyGirlListByExample(BeautyGirl beautyGirl){
		return beautyGirlDao.getBeautyGirlListByExample(beautyGirl);
	}
	
	@Override
	public List<BeautyGirl> getBeautyGirlByCondition(BeautyGirlSearchBean condition){
		return beautyGirlDao.getBeautyGirlByCondition(condition);
	}
	
	@Override
	public List<BeautyGirl> queryBeautyGirlListByCondition(BeautyGirlSearchBean condition){
		return beautyGirlDao.getBeautyGirlListByCondition(condition);
	}
	
	@Override
	public void modifyBeautyGirlBySql(String sql){
		beautyGirlDao.updateBeautyGirlByWhere(sql);
	}
	
	@Override
	public void modifyBeautyGirlByCondition(BeautyGirlSearchBean condition){
		beautyGirlDao.updateBeautyGirl(condition);
	}
	
	@Override
	public void removeBeautyGirlBySql(String sql){
		beautyGirlDao.deleteBeautyGirlByWhere(sql);
	}
	
	@Override
	public int getBeautyGirlCountBySql(String sql){
		return beautyGirlDao.getBeautyGirlCountByWhere(sql);
	}
	
	@Override
	public int getBeautyGirlCountByExample(BeautyGirl beautyGirl){
		return beautyGirlDao.getBeautyGirlCountByExample(beautyGirl);
	}
	
	@Override
	public int getBeautyGirlCountByCondition(BeautyGirlSearchBean condition){
		return beautyGirlDao.getBeautyGirlCountByCondition(condition);
	}
	
	@Override
	public Map<String,Object> getBeautyGirlColumnByCondition(BeautyGirlSearchBean condition){
		return beautyGirlDao.getBeautyGirlColumnByCondition(condition);
	}
	
	@Override
	public void updateBeautyGirlByExample(BeautyGirl beautyGirl){
		beautyGirlDao.updateBeautyGirlByExample(beautyGirl);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void batchModifyBeautyGirlByExample(List<BeautyGirl> list){
		beautyGirlDao. batchModifyBeautyGirlByExample(list);
	}
}
