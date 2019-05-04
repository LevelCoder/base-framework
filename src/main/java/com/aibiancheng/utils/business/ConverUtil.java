package com.aibiancheng.utils.business;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 描述:
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/8/28
 */
public class ConverUtil {


    /**
     *
     * map转Bean
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> class1) {
        T bean = null;
        try {
            bean = class1.newInstance();
            BeanUtils.populate(bean, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
