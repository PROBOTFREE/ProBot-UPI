package a2;

import androidx.work.c;
import java.util.List;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f81a = h.f("InputMerger");

    public static f a(String str) {
        try {
            return (f) Class.forName(str).newInstance();
        } catch (Exception e10) {
            h c10 = h.c();
            String str2 = f81a;
            c10.b(str2, "Trouble instantiating + " + str, e10);
            return null;
        }
    }

    public abstract c b(List<c> list);
}
