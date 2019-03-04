package com.wsh.springcloud.punishmentservice.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyBeanUtils {

    /**
     * PO对象转换成VO对象
     *
     * @param po
     * @param voClass
     * @return
     */
    public static <T> T clonePoToVo(Object po, Class<T> voClass) {
        if (po == null) {
            return null;
        }
        T vo = null;
        try {
            vo = voClass.newInstance();
            Method[] poMethods = po.getClass().getDeclaredMethods();
            Map<String, Object> map = new HashMap<String, Object>();
            //先把值取出来存放到一个Map对象中
            for (Method method : poMethods) {
                if (method.getName().startsWith("get")) {
                    Object value = method.invoke(po);
                    if (value != null) {
                        map.put(makeFirstCharToLowerCase(method.getName().substring(3)), value);
                    }
                }
            }
            Field[] voFields = vo.getClass().getDeclaredFields();
            for (Field field : voFields) {
                String fieldName = field.getName();
                Object value = map.get(fieldName);
                if (value != null) {
                    PropertyDescriptor pd = new PropertyDescriptor(fieldName, vo.getClass());
                    Method e = pd.getWriteMethod();
                    e.invoke(vo, value);
                }
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            e.printStackTrace();
        }
        return vo;
    }

    /**
     * 首字母小写
     *
     * @return
     */
    public static String makeFirstCharToLowerCase(String str) {
        if (str == null || "".equals(str)) {
            return str;
        } else {
            return str.substring(0, 1).toLowerCase() + str.substring(1);
        }
    }

}
