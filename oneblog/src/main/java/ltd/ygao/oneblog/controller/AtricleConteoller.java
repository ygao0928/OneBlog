package ltd.ygao.oneblog.controller;

import io.swagger.annotations.Api;
import ltd.ygao.oneblog.pojo.Article;
import ltd.ygao.oneblog.pojo.ArticleColumn;
import ltd.ygao.oneblog.pojo.Tag;
import ltd.ygao.oneblog.service.ArtColumnService;
import ltd.ygao.oneblog.service.ArticleService;
import ltd.ygao.oneblog.service.TagService;
import ltd.ygao.oneblog.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:10
 */
@Controller
@RequestMapping(value = "/article", produces = {"application/json;charset=UTF-8"})
@CrossOrigin
@Api(value = "文章", tags = "")
public class AtricleConteoller {

    @Autowired
    ArticleService articleService;
    @Autowired
    TagService tagService;
    @Autowired
    ArtColumnService artColumnService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
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

    @ResponseBody
    @RequestMapping(value = "/findAllColumn", method = {RequestMethod.POST})
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
}
