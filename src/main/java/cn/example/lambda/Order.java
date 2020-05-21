package cn.example.lambda;

import com.sun.tools.corba.se.idl.constExpr.Or;
import lombok.Data;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/21 22:55
 */
@Data
public class Order {
    String name;

    public String getOrderName(Order order) {
        return Optional.ofNullable(order).map(o -> o.getName()).orElse(null);
    }
}