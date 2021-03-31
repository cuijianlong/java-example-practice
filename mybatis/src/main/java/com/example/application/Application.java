package com.example.application;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.ibatis.annotations.Select;

import com.google.common.collect.Maps;

public class Application {

  public static void main(String[] args) {

    UserMapper userMapper = (UserMapper) Proxy
        .newProxyInstance(Application.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println(Arrays.asList(args));
            Select annotation = method.getAnnotation(Select.class);
            Map<String, Object> stringObjectMap = buildArgMap(method, args);
            System.out.println(stringObjectMap);
            if (Objects.nonNull(annotation)) {
              String[] value = annotation.value();
              System.out.println(Arrays.toString(value));
            }
            return null;
          }
        });
    userMapper.selectUserlIst(1, "name");

  }

  public String parseSql(String sql, Map<String, Object> nameArgMap) {

    return null;

  }

  public static Map<String, Object> buildArgMap(Method method, Object[] args) {

    HashMap<String, Object> nameArgMap = Maps.newHashMap();
    // 根据方法，获取参数名称
    // 根据args获取真实传的参数
    Parameter[] parameters = method.getParameters();
    //AtomicInteger index = new AtomicInteger();
    int index[] = {0};
    Arrays.asList(parameters).forEach(parameter -> {
      //nameArgMap.put(parameter.getName(), args[index.get()]);
      nameArgMap.put(parameter.getName(), args[index[0]]);
      index[0]++;
    });
    return nameArgMap;
  }

}

interface UserMapper {

  @Select("SELECT * FROM user where id=#{id}")
  List<Object> selectUserlIst(Integer id, String name);

}