package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f4164a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f4165b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Transition> f4166c = new ArrayList<>();

    @Deprecated
    public u() {
    }

    public u(View view) {
        this.f4165b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f4165b == uVar.f4165b && this.f4164a.equals(uVar.f4164a);
    }

    public int hashCode() {
        return (this.f4165b.hashCode() * 31) + this.f4164a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f4165b + "\n") + "    values:";
        for (String next : this.f4164a.keySet()) {
            str = str + "    " + next + ": " + this.f4164a.get(next) + "\n";
        }
        return str;
    }
}
