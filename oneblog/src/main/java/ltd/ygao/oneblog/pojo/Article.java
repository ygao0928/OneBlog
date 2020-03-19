package ltd.ygao.oneblog.pojo;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:20
 */
@Getter

@Setter
public class Article {
    private Integer id;
    private String aritcleName;
    private String htmlContent;
    private String textContent;
    private Date createrOn;
    private Integer creater;
    private String tagList;
    private Integer statue;
}
