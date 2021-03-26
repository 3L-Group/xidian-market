package com.saturn.common.utils.component;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qyl
 * @Date: 2021/3/20 16:34
 * @Description: bean 与 map 之间的转换工具类
 */
public class BeanUtil {

    /**
     * bean 封装到 map 中
     * @param bean
     * @return
     */
    public static Map<String, Object> bean2map(Object bean) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 获取对象字节码信息，不要 Object 属性
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(), Object.class);
            // 获取 bean 对象中的所有属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : propertyDescriptors) {
                String key = pd.getName();  // 获取属性名
                Object value = pd.getReadMethod().invoke(key);  // 调用 getter() 获取内容
                map.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * map 转换为 bean
     * @param map
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T map2bean(Map<String, Object> map, Class<T> cls) {
        T obj = null;
        try {
            // 通过动态反射创建对象
            obj = cls.getDeclaredConstructor().newInstance();
            // 获取对象字节码信息，不要 Object 属性
            BeanInfo beanInfo = Introspector.getBeanInfo(cls, Object.class);
            // 获取 bean 对象中的所有属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : propertyDescriptors) {
                String key = pd.getName();  // 获取属性名
                Object value = map.get(key);// 获取属性值
                pd.getWriteMethod().invoke(obj, value);  // 调用属性 setter() 方法，设置到 bean 对象中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
