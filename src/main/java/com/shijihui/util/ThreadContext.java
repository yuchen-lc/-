package com.shijihui.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangzhiyong on 15/12/12.
 */
public class ThreadContext {

    private static final ThreadLocal<Map<Object, Object>> resources = new InheritableThreadLocalMap<Map<Object, Object>>();

    public static void clear() {
        resources.get().clear();
    }

    public static Object get(Object key) {
        return resources.get().get(key);
    }

    public static void put(String key, Object value){
        resources.get().put(key, value);
    }

    public static Object remove(Object key) {
        Object value= null;
        try {
            value = resources.get().remove(key);
        }catch (NullPointerException e){
//            log.error("", e);
        }
        return value;
    }


    private static final class InheritableThreadLocalMap<T extends Map<Object, Object>> extends InheritableThreadLocal<Map<Object, Object>> {
        protected Map<Object, Object> initialValue() {
            return new HashMap<Object, Object>();
        }

        @SuppressWarnings("unchecked")
        protected Map<Object, Object> childValue(Map<Object, Object> parentValue) {
            if (parentValue != null) {
                return (Map<Object, Object>) ((HashMap<Object, Object>) parentValue).clone();
            } else {
                return null;
            }
        }
    }
}
