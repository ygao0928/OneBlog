package ltd.ygao.oneblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ltd.ygao.oneblog.mapper.ArticleMapper;
import ltd.ygao.oneblog.pojo.Article;
import ltd.ygao.oneblog.service.ArticleService;
import ltd.ygao.oneblog.utils.PageRequest;
import ltd.ygao.oneblog.utils.PageResult;
import ltd.ygao.oneblog.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:28
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    //@Transactional(rollbackFor = BizException.class)
    public Integer addArticle(Article article) {

        return articleMapper.addArticle(article);
    }

    @Override
    public Integer deleteArticleById(int artId) {
        return articleMapper.deleteArticleById(artId);
    }

    @Override
    public Integer updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public List<Article> selectArticleById(int artId) {
        return articleMapper.selectArticleById(artId);
    }

    @Override
    public List<Article> selectArticleByfromer(int userId) {
        return articleMapper.selectArticleByfromer(userId);
    }

    @Override
    public List<Article> FindAllArticle() {

        return articleMapper.FindAllArticle();

    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(pageRequest));
    }
    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Article> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> sysMenus = articleMapper.selectPage();
        return new PageInfo<>(sysMenus);
    }

}

