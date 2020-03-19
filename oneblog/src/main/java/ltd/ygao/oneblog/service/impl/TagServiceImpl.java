package ltd.ygao.oneblog.service.impl;

import ltd.ygao.oneblog.mapper.TagMapper;
import ltd.ygao.oneblog.pojo.Tag;
import ltd.ygao.oneblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/19 11:05
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> findAll() {

        return tagMapper.findAll();
    }
}
