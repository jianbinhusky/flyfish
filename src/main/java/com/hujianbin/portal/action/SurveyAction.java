package com.hujianbin.portal.action;

import com.alibaba.fastjson.JSON;
import com.hujianbin.common.spring.BaseAction;
import com.hujianbin.portal.UUIDUtils;
import com.hujianbin.portal.bean.form.CreateQuestionForm;
import com.hujianbin.portal.bean.form.PlaceSurveyForm;
import com.hujianbin.portal.bean.pojo.Custom_attr;
import com.hujianbin.portal.bean.pojo.Page;
import com.hujianbin.portal.bean.pojo.Project;
import com.hujianbin.portal.bean.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hujb4 on 2016/5/19.
 */
@Controller
public class SurveyAction extends BaseAction {

    public static void main(String[] args) {
        SurveyAction surveyAction = new SurveyAction();
        surveyAction.edit("sss", new ModelMap());
    }

    private static final String PREFIX = "survey";
    private static final String SUFFIX = ".htm";

    @Autowired
    private MongoOperations mongoOperations;

    @RequestMapping(value = "/list")
    public String listSurveys(){
        //TODO
        return PREFIX + "/list";
    }

    @RequestMapping(value = "/create")
    public String createSurvey(){
        //TODO
        return PREFIX + "/create";
    }

    @RequestMapping(value = "/place")
    public String placeSurvey(PlaceSurveyForm placeSurveyForm){
        //TODO
        String creator_id = UUIDUtils.getUUID();
        String project_id = UUIDUtils.getUUID();
        String page_id = UUIDUtils.getUUID();

        Project project = new Project();
        project.setId(project_id);
        project.setStatus(0);
        project.set_hdgc(false);
        project.setUpdated(new Date());
        project.setPage_count(0);
        project.setCreated(new Date());
        Page page = new Page();
        page.setId(page_id);
        page.setUpdated(new Date());
        page.setProject_id(project_id);
        page.setQuestion_list(new ArrayList<Question>());
        page.setQuestion_id_list(new ArrayList<String>());
        page.setCustom_attr(new Custom_attr());
        List<Page> pageList = new ArrayList<Page>();
        pageList.add(page);
        project.setQuestionpage_list(pageList);
        List<String> questionPageIdList = new ArrayList<String>();
        questionPageIdList.add(page_id);
        project.setQuestionpage_id_list(questionPageIdList);
        project.setCreator_id(creator_id);
        project.setVersion(1);
        project.setFirst_create_for_member(false);
        project.setCustom_attr(new Custom_attr());
        project.setTitle(placeSurveyForm.getTitle());
        project.setProject_func_id(placeSurveyForm.getProject_func());
        project.setQuestion_count(0);
        project.setIs_struct_change(0);
        project.setOfficial_status(0);
        project.setEnd_desc("您已完成本次问卷，感谢您的帮助与支持");
        project.setBegin_desc("欢迎参加本次答题");

        mongoOperations.insert(project);

        return "redirect:/edit/survey/" + project_id + SUFFIX;
    }

    @RequestMapping(value = "/edit/survey/{id}")
        public String edit(@PathVariable(value = "id") String id , ModelMap result){

        Project project = mongoOperations.findById(id, Project.class);

        result.put("project", JSON.toJSONString(project));

        return PREFIX + "/index";
    }

    @RequestMapping(value = "/edit/ajax/question_create/{id}")
    public void createQuestion(@PathVariable(value = "id") String id , CreateQuestionForm createQuestionForm, ModelMap result , HttpServletRequest request){

        mongoOperations.insert(createQuestionForm.getQuestion_struct(),"question");
        result.put("status", 220);
    }
}
