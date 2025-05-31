package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.navigation.i;
import c0.h;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class j extends i implements Iterable<i> {

    /* renamed from: i  reason: collision with root package name */
    final h<i> f3189i = new h<>();

    /* renamed from: j  reason: collision with root package name */
    private int f3190j;

    /* renamed from: k  reason: collision with root package name */
    private String f3191k;

    class a implements Iterator<i> {

        /* renamed from: a  reason: collision with root package name */
        private int f3192a = -1;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3193b = false;

        a() {
        }

        /* renamed from: a */
        public i next() {
            if (hasNext()) {
                this.f3193b = true;
                h<i> hVar = j.this.f3189i;
                int i10 = this.f3192a + 1;
                this.f3192a = i10;
                return hVar.q(i10);
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f3192a + 1 < j.this.f3189i.p();
        }

        public void remove() {
            if (this.f3193b) {
                j.this.f3189i.q(this.f3192a).E((j) null);
                j.this.f3189i.o(this.f3192a);
                this.f3192a--;
                this.f3193b = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
    }

    public j(q<? extends j> qVar) {
        super((q<? extends i>) qVar);
    }

    public void A(Context context, AttributeSet attributeSet) {
        super.A(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, o1.a.NavGraphNavigator);
        L(obtainAttributes.getResourceId(o1.a.NavGraphNavigator_startDestination, 0));
        this.f3191k = i.v(context, this.f3190j);
        obtainAttributes.recycle();
    }

    public final void G(i iVar) {
        int w10 = iVar.w();
        if (w10 == 0) {
            throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        } else if (w10 != w()) {
            i i10 = this.f3189i.i(w10);
            if (i10 != iVar) {
                if (iVar.y() == null) {
                    if (i10 != null) {
                        i10.E((j) null);
                    }
                    iVar.E(this);
                    this.f3189i.n(iVar.w(), iVar);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
        } else {
            throw new IllegalArgumentException("Destination " + iVar + " cannot have the same id as graph " + this);
        }
    }

    public final i H(int i10) {
        return I(i10, true);
    }

    /* access modifiers changed from: package-private */
    public final i I(int i10, boolean z10) {
        i i11 = this.f3189i.i(i10);
        if (i11 != null) {
            return i11;
        }
        if (!z10 || y() == null) {
            return null;
        }
        return y().H(i10);
    }

    /* access modifiers changed from: package-private */
    public String J() {
        if (this.f3191k == null) {
            this.f3191k = Integer.toString(this.f3190j);
        }
        return this.f3191k;
    }

    public final int K() {
        return this.f3190j;
    }

    public final void L(int i10) {
        if (i10 != w()) {
            this.f3190j = i10;
            this.f3191k = null;
            return;
        }
        throw new IllegalArgumentException("Start destination " + i10 + " cannot use the same id as the graph " + this);
    }

    public final Iterator<i> iterator() {
        return new a();
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" startDestination=");
        i H = H(K());
        if (H == null) {
            str = this.f3191k;
            if (str == null) {
                sb2.append("0x");
                str = Integer.toHexString(this.f3190j);
            }
        } else {
            sb2.append("{");
            sb2.append(H.toString());
            str = "}";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public String u() {
        return w() != 0 ? super.u() : "the root navigation";
    }

    /* access modifiers changed from: package-private */
    public i.a z(h hVar) {
        i.a z10 = super.z(hVar);
        Iterator<i> it = iterator();
        while (it.hasNext()) {
            i.a z11 = it.next().z(hVar);
            if (z11 != null && (z10 == null || z11.compareTo(z10) > 0)) {
                z10 = z11;
            }
        }
        return z10;
    }
}
