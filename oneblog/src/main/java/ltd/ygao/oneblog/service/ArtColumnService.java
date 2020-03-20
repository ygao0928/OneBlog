package ltd.ygao.oneblog.service;

import ltd.ygao.oneblog.pojo.ArticleColumn;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/20 17:28
 */
public interface ArtColumnService {
    /**
     * 找到所有的栏目
     * @return
     */
    List<ArticleColumn> findAll();
}
