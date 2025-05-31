package a2;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.b;
import androidx.work.j;
import b2.i;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
public abstract class n {
    protected n() {
    }

    public static n c(Context context) {
        return i.j(context);
    }

    public static void d(Context context, b bVar) {
        i.d(context, bVar);
    }

    public final i a(j jVar) {
        return b(Collections.singletonList(jVar));
    }

    public abstract i b(List<? extends j> list);
}
