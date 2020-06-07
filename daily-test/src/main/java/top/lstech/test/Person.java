package top.lstech.test;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-21 16:15
 */
@Data
public class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 创建一个persion进行回调
     *
     * @param id
     * @param name
     * @param callback
     */
    public static void create(Integer id, String name, PersonCallback callback) {
        Person person = new Person(id, name);
        callback.callback(person);
    }

    public static void main(String[] args) {
        Person.create(1, "张三", new PersonCallback() {
            @Override
            public void callback(Person person) {
                System.out.println(person.name + " login success");
            }
        });

        Person.create(2, "李四", new PersonCallback() {
            @Override
            public void callback(Person person) {
                System.out.println(person.name + " regist success");
            }
        });

        Person.create(3, "王大锤", (Person person) -> {
            System.out.println(person.name + " 该上班了");
        });

        Person.create(4, "王大锤", person -> System.out.println(person.name + " 该上班了"));
    }

}
