package androidx.databinding;

import java.util.List;

public interface j<T> extends List<T> {

    public static abstract class a<T extends j> {
    }

    void j(a<? extends j<T>> aVar);

    void p(a<? extends j<T>> aVar);
}
