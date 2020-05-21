package cn.example.serial;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: https://mp.weixin.qq.com/s?__biz=MzIyNDU2ODA4OQ==&mid=2247484384&idx=1&sn=08034cd5b10b135cd7ac6946d415ce13&chksm=e80db596df7a3c8069183899d486c4bb48d201daf35c69b8c6d05b2cf211cc8bab4617eb22c6&mpshare=1&scene=1&srcid=&sharer_sharetime=1589429395211&sharer_shareid=64f5f7221128b0a14883ecf277481276&rd2werd=1#wechat_redirect
 * @Author: 义云
 * @Created: 2020-05-14 12:41
 */
public class SerializableTest {

    private static void serialize(User user) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("test.txt")));
        oos.writeObject(user);
        oos.close();
    }

    private static User deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("test.txt")));
        return (User) ois.readObject();
    }

    /**
     * 显示指定serialVersionUID后就解决了序列化与反序列化产生的serialVersionUID不一致的问题
     * 实现Serializable接口就算了, 为什么还要显示指定serialVersionUID的值?
     *
     * 如果不显示指定serialVersionUID, JVM在序列化时会根据属性自动生成一个serialVersionUID,
     * 然后与属性一起序列化, 再进行持久化或网络传输. 在反序列化时, JVM会再根据属性自动生成一个新版serialVersionUID,
     * 然后将这个新版serialVersionUID与序列化时生成的旧版serialVersionUID进行比较, 如果相同则反序列化成功, 否则报错.
     *
     * 如果显示指定了serialVersionUID, JVM在序列化和反序列化时仍然都会生成一个serialVersionUID, 但值为我们显示指定的值, 这样在反序列化时新旧版本的serialVersionUID就一致了.
     *
     * 在实际开发中, 不显示指定serialVersionUID的情况会导致什么问题? 如果我们的类写完后不再修改, 那当然不会有问题,
     * 但这在实际开发中是不可能的, 我们的类会不断迭代, 一旦类被修改了, 那旧对象反序列化就会报错. 所以在实际开发中, 我们都会显示指定一个serialVersionUID, 值是多少无所谓, 只要不变就行.
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setAge(23);
        user.setName("jack ma");
        System.out.println("序列化前的结果: " + user);
//        serialize(user);

        User dUser = deserialize();
        System.out.println("反序列化后的结果: "+ dUser);
    }

}
