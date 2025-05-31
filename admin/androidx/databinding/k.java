package androidx.databinding;

import java.util.Map;

public interface k<K, V> extends Map<K, V> {

    public static abstract class a<T extends k<K, V>, K, V> {
    }

    void a(a<? extends k<K, V>, K, V> aVar);

    void b(a<? extends k<K, V>, K, V> aVar);
}
