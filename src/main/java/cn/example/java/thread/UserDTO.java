package cn.example.java.thread;

import lombok.Data;

import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/24 14:56
 */
@Data
public class UserDTO {
    private int id;
    private String name;

    public UserDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
