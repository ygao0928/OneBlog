package ltd.ygao.oneblog.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:22
 */
@Data
public class Tag implements Serializable {
    private Integer id;
    private String tag;
    private Integer creater;
    private Date createrOn;
    private Integer statue;
}
