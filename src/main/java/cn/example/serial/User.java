package cn.example.serial;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-14 12:40
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private String sex;

}
