package com.aibiancheng.utils.basic;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Object 对象判断
 */
public class ObjectUtil {


	/**
	 * 判断所传对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj){
		//如果所传对象本身为空
		if(obj == null){
			return true;
		}
		//如果是字符序列 包含 String,StringBuilder,StringBuffer
		if(obj instanceof CharSequence){
			return ((CharSequence) obj).length() == 0;
		}
		//如果是集合
		if(obj instanceof Collection){
			return ((Collection) obj).isEmpty();
		}
		//如果是map
		if(obj instanceof Map){
			return ((Map) obj).isEmpty();
		}
		//如果是Array
		if(obj.getClass().isArray()){
			return Array.getLength(obj) == 0;
		}
		//如果是数组
		if(obj instanceof Object[]){
			Object[] object = (Object[]) obj;
			if(((Object[]) obj).length == 0){
				return true;
			}
			boolean empty = true;
			for(int i = 0 ; i < object.length ; i++){
				if(!isNullOrEmpty(object[i])){
					empty = false;
					break;
				}
			}
			return empty;
		}
		//如果是实体对象
		return false;
	}


	/**
	 * 可以用于判断 Map,Collection,String,Array是否为空
	 * @param o
	 * @return
	 */
	@SuppressWarnings("all")
    public static boolean isEmpty(Object o)  {
        if(o == null) return true;

        if(o instanceof String) {
            if(((String)o).length() == 0){
                return true;
            }
        } else if(o instanceof Collection) {
            if(((Collection)o).isEmpty()){
                return true;
            }
        } else if(o.getClass().isArray()) {
            if(Array.getLength(o) == 0){
                return true;
            }
        } else if(o instanceof Map) {
            if(((Map)o).isEmpty()){
                return true;
            }
        }
		else {
            return false;
        }

        return false;
    }




	/**
	 * 可以用于判断 Map,Collection,String,Array是否不为空
	 * @param c
	 * @return
	 */
	public static boolean isNotEmpty(Object c) throws IllegalArgumentException{
		return !isEmpty(c);
	}

}
