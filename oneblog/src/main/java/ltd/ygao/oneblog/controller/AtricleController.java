package ltd.ygao.oneblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ltd.ygao.oneblog.pojo.Article;
import ltd.ygao.oneblog.pojo.ArticleColumn;
import ltd.ygao.oneblog.service.ArtColumnService;
import ltd.ygao.oneblog.service.ArticleService;
import ltd.ygao.oneblog.service.TagService;
import ltd.ygao.oneblog.utils.PageRequest;
import ltd.ygao.oneblog.utils.PageResult;
import ltd.ygao.oneblog.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:10
 */
@RestController
@RequestMapping(value = "/article", produces = {"application/json;charset=UTF-8"})
@CrossOrigin
@ResponseBody
@Api(value = "文章管理接口")
public class AtricleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    TagService tagService;
    @Autowired
    ArtColumnService artColumnService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新建文章接口")
    public ResponseObject<Object> addart(@CookieValue("userid") String userId, String title, String htmlContent, String textContent, String tag) {
        Article at = new Article();
        at.setAritcleName(title);
        at.setCreater(Integer.parseInt(userId));
        at.setCreaterOn(new Date());
        at.setHtmlContent(htmlContent);
        at.setTextContent(textContent);
        System.out.println(at);
        Integer aa = articleService.addArticle(at);
        ResponseObject rs = new ResponseObject();
        if (aa != 0) {
            rs.setData("保存成功");
        }
        return rs;
    }

    @RequestMapping(value = "/findAllColumn", method = {RequestMethod.POST})
    @ApiOperation("查所有栏目接口")
    public ResponseObject findArtColumnAll() {
        ResponseObject ro = new ResponseObject();
        List<ArticleColumn> articleColumnsList = artColumnService.findAll();
        if (articleColumnsList.size() > 0) {
            ro.setData(articleColumnsList);
        } else {
            ro.setMoreInfo("没有数据");
        }
        return ro;
    }

    @RequestMapping(value = "/findAllArticle", method = {RequestMethod.POST})
    @ApiOperation("查所有文章接口")
    public ResponseObject findAllArticles() {
        List<Article> atlist = articleService.FindAllArticle();
        return new ResponseObject(atlist);
    }

    @PostMapping(value = "findArticleByPage")
    @ApiOperation("分页查询文章的接口")
    public ResponseObject findPage(@RequestBody PageRequest pageRequest) {
        System.out.println(articleService.findPage(pageRequest));
        PageResult pageInfo = articleService.findPage(pageRequest);
        return new ResponseObject<>(pageInfo);
    }
}
