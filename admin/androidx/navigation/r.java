package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.navigation.q;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"TypeParameterUnusedInFormals"})
public class r {

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Class<?>, String> f3230b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, q<? extends i>> f3231a = new HashMap<>();

    static String c(Class<? extends q> cls) {
        HashMap<Class<?>, String> hashMap = f3230b;
        String str = hashMap.get(cls);
        if (str == null) {
            q.b bVar = (q.b) cls.getAnnotation(q.b.class);
            str = bVar != null ? bVar.value() : null;
            if (g(str)) {
                hashMap.put(cls, str);
            } else {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
        }
        return str;
    }

    private static boolean g(String str) {
        return str != null && !str.isEmpty();
    }

    public final q<? extends i> a(q<? extends i> qVar) {
        return b(c(qVar.getClass()), qVar);
    }

    public q<? extends i> b(String str, q<? extends i> qVar) {
        if (g(str)) {
            return this.f3231a.put(str, qVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public final <T extends q<?>> T d(Class<T> cls) {
        return e(c(cls));
    }

    public <T extends q<?>> T e(String str) {
        if (g(str)) {
            T t10 = (q) this.f3231a.get(str);
            if (t10 != null) {
                return t10;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    /* access modifiers changed from: package-private */
    public Map<String, q<? extends i>> f() {
        return this.f3231a;
    }
}
