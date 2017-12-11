package com.hujianbin.manage.action;

import com.hujianbin.basis.bean.Blog;
import com.hujianbin.basis.bean.BlogCategory;
import com.hujianbin.basis.service.BlogCategoryService;
import com.hujianbin.basis.service.BlogService;
import com.hujianbin.common.spring.BaseAction;
import com.hujianbin.common.util.DateUtil;
import com.hujianbin.common.util.StringUtil;
import com.hujianbin.manage.bean.form.BlogForm;
import com.hujianbin.manage.constant.BlogEnum;
import com.hujianbin.manage.constant.ManageReturnConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hujb4 on 2016/12/8.
 */

@Controller
@Slf4j
@RequestMapping(value = "/manage")
public class BlogManageAction extends BaseAction{

    private static final String UPLOAD_BLOG_IMG_PREFIX_PATH = "upload/blog/";

    @Resource(name = "blogService")
    private BlogService blogService;

    @Resource(name = "blogCategoryService")
    private BlogCategoryService blogCategoryService;

    @RequestMapping("/addBlog")
    public String goAddBlog() {
        return ManageReturnConstant.ADD_BLOG;
    }

    @RequestMapping("/saveBlog")
    public void addBlog(ModelMap result, BlogForm blogForm){
        Blog blog = new Blog();
        blog.setUserId(1);
        blog.setContent(blogForm.getContent());
        blog.setCreateTime(new Date());
        blog.setImg(blogForm.getImg());
        blog.setIsPublish((Integer) BlogEnum.PUBLISHED.getCode());
        blog.setModifiedTime(new Date());
        blog.setStatus((Integer) BlogEnum.NORMAL.getCode());
        blog.setSummary(blogForm.getSummary());
        blog.setTag(blogForm.getTag());
        blog.setTitle(blogForm.getTitle());
        blog.setCategoryId(Integer.valueOf(blogForm.getCategoryId()));

        try {
            blogService.addBlog(blog);
            result.put("msg", "发布成功");
            result.put("success", true);
        } catch (Exception e) {
            result.put("msg", "发布失败");
            result.put("success", false);
            log.error(e.getMessage());
        }
    }

    @RequestMapping("/getCategoryList")
    public void getCategoryList(ModelMap result , Integer userId){
        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setUserId(userId);
        List<BlogCategory> blogCategoryList = blogCategoryService.queryBlogCategoryListByExample(blogCategory);

        result.put("blogCategoryList", blogCategoryList);
    }

    @RequestMapping(value="/uploadImg")
    public void uploadBlogImg(ModelMap result, HttpServletRequest request){
        String baseDir=request.getSession().getServletContext().getRealPath("/");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile mf = entity.getValue();
            String fileName = mf.getOriginalFilename();
            String uuid= StringUtil.getUUID();
            String newFileName=uuid+fileName.substring(fileName.lastIndexOf("."));
            String relativeDir = UPLOAD_BLOG_IMG_PREFIX_PATH + DateUtil.date2str(new Date()) + "/";//生成相对目录
            //在web服务器tomcat本地目录上传一份
            String dir=baseDir + relativeDir;
            File fileDir=new File(dir);
            if(!fileDir.exists()){
                fileDir.mkdirs();
            }

            String file=dir+newFileName;
            File uploadFile = new File(file);
//            //在图片服务器mount目录上传一份
//            String copyDir = imgPath + relativeDir;
//            File copyFileDir = new File(copyDir);
//            if(!copyFileDir.exists()){
//                copyFileDir.mkdirs();
//            }
//            String copyFileName = copyDir + newFileName;
//            File copyFile = new File(copyFileName);

            //存储路径以及文件名
            String savePathFileName = relativeDir + newFileName;
            try {
                FileCopyUtils.copy(mf.getBytes(), uploadFile);
//                FileCopyUtils.copy(mf.getBytes(), copyFile);
                result.put("success", true);
                result.put("url", savePathFileName);
             } catch (Exception e) {
                log.error("upload blog image error", e);
            }
        }

    }
}
