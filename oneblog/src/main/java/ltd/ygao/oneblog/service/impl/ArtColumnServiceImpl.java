package ltd.ygao.oneblog.service.impl;

import ltd.ygao.oneblog.mapper.ArtColumnMapper;
import ltd.ygao.oneblog.pojo.ArticleColumn;
import ltd.ygao.oneblog.service.ArtColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/20 17:31
 */
@Service
public class ArtColumnServiceImpl implements ArtColumnService {
    @Autowired
    ArtColumnMapper artColumnMapper;
    @Override
    public List<ArticleColumn> findAll() {
        return artColumnMapper.findAll();
    }
}
