package com.hujianbin.manage.action;

import com.hujianbin.basis.bean.GirlCategory;
import com.hujianbin.basis.service.GirlCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hujb4 on 2016/7/20.
 */
@Controller
@RequestMapping(value = "/admin")
public class GirlManageAction {

    @Autowired
    private GirlCategoryService girlCategoryService;


    @RequestMapping(value = "/addCategory" , method = RequestMethod.POST)
    public String addGirlCategory(HttpServletRequest request , ModelMap result){
        GirlCategory girlCategory = new GirlCategory();
        girlCategory.setCategoryName(request.getParameter("categoryName"));

        girlCategoryService.addGirlCategory(girlCategory);

        result.put("success", "ok");

        return "SUCCESS";
    }
}
