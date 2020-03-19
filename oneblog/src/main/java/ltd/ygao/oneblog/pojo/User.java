package ltd.ygao.oneblog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/15 21:05
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String  passWord;
    }
