package com.hujianbin.portal.action;

import com.hujianbin.common.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hujb4 on 2016/5/19.
 */
@Controller
@RequestMapping(value = "/operate/ajax")
public class SurveySecurityCheckAction extends BaseAction {

    @RequestMapping(value = "/get_validate_status")
    public void getValidateStatus(@RequestParam(value = "key" , required = false) String key ,
                                  @RequestParam(value = "_xsrf" , required = false) String _xsrf,
                                  ModelMap result){
        //TODO
        result.put("status",200);
        result.put("is_validate", 0);
        result.put("is_gt_l_p_num", 0);
    }
}
