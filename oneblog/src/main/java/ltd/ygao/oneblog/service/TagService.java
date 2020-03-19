package ltd.ygao.oneblog.service;

import ltd.ygao.oneblog.pojo.Tag;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/19 11:03
 */
public interface TagService {
    /**
     * 查出所有的tag
     * @return
     */
    List<Tag> findAll();
}
