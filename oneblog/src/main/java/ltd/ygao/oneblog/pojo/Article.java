package ltd.ygao.oneblog.pojo;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:20
 */
@Data
public class Article implements Serializable {
    private Integer id;
    @NotNull
    private String aritcleName;
    @NotNull
    private String htmlContent;
    @NotNull
    private String textContent;
    private Date createrOn;
    @NotNull
    private Integer creater;
    private String tagList;
    private Integer statue;
    private List<Tag> allTag;
}
