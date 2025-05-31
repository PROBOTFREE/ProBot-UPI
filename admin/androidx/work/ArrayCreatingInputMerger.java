package androidx.work;

import a2.f;
import androidx.work.c;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ArrayCreatingInputMerger extends f {
    private Object c(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(obj2.getClass(), length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        return newInstance;
    }

    private Object d(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    private Object e(Object obj, Object obj2) {
        Object newInstance = Array.newInstance(obj.getClass(), 2);
        Array.set(newInstance, 0, obj);
        Array.set(newInstance, 1, obj2);
        return newInstance;
    }

    private Object f(Object obj) {
        Object newInstance = Array.newInstance(obj.getClass(), 1);
        Array.set(newInstance, 0, obj);
        return newInstance;
    }

    public c b(List<c> list) {
        c.a aVar = new c.a();
        HashMap hashMap = new HashMap();
        loop0:
        for (c h10 : list) {
            Iterator<Map.Entry<String, Object>> it = h10.h().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    Class<?> cls = value.getClass();
                    Object obj = hashMap.get(str);
                    if (obj != null) {
                        Class<?> cls2 = obj.getClass();
                        if (cls2.equals(cls)) {
                            value = cls2.isArray() ? d(obj, value) : e(obj, value);
                        } else if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                            value = c(obj, value);
                        } else if (cls.isArray() && cls.getComponentType().equals(cls2)) {
                            value = c(value, obj);
                        }
                    } else if (!cls.isArray()) {
                        value = f(value);
                    }
                    hashMap.put(str, value);
                }
            }
            throw new IllegalArgumentException();
        }
        aVar.d(hashMap);
        return aVar.a();
    }
}
