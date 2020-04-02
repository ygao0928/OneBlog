package ltd.ygao.oneblog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/20 17:25
 */
@Data
public class ArticleColumn implements Serializable {
    private Integer id;
    private String columnname;
}
