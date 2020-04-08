package ltd.ygao.oneblog.service;

import ltd.ygao.oneblog.pojo.Article;
import ltd.ygao.oneblog.utils.PageRequest;
import ltd.ygao.oneblog.utils.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:16
 */
public interface ArticleService {
    /**
     * 增
     *
     * @param article
     * @return
     */
    Integer addArticle(Article article);

    /**
     * 删除
     *
     * @param artId
     * @return
     */
    Integer deleteArticleById(@Param("artId") int artId);

    /**
     * 更新
     *
     * @param article
     * @return
     */
    Integer updateArticle(Article article);

    /**
     * 查依据id查文章
     *
     * @param artId
     * @return
     */
    List<Article> selectArticleById(@Param("artId") int artId);

    /**
     * 依据当前登录者查出所有的文案
     *
     * @param userId
     * @return
     */
    List<Article> selectArticleByfromer(@Param("userId") int userId);

    /**
     * 查所有的文章
     *
     * @return
     */
    List<Article> FindAllArticle();

    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);
}
