package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.p implements RecyclerView.y.b {
    boolean A = false;
    private BitSet B;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private int[] O;
    private final Runnable P = new a();

    /* renamed from: s  reason: collision with root package name */
    private int f3421s = -1;

    /* renamed from: t  reason: collision with root package name */
    c[] f3422t;

    /* renamed from: u  reason: collision with root package name */
    s f3423u;

    /* renamed from: v  reason: collision with root package name */
    s f3424v;

    /* renamed from: w  reason: collision with root package name */
    private int f3425w;

    /* renamed from: x  reason: collision with root package name */
    private int f3426x;

    /* renamed from: y  reason: collision with root package name */
    private final n f3427y;

    /* renamed from: z  reason: collision with root package name */
    boolean f3428z = false;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e  reason: collision with root package name */
        c f3429e;

        /* renamed from: f  reason: collision with root package name */
        boolean f3430f;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean e() {
            return this.f3430f;
        }
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f3431a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f3432b;

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            int f3433a;

            /* renamed from: b  reason: collision with root package name */
            int f3434b;

            /* renamed from: c  reason: collision with root package name */
            int[] f3435c;

            /* renamed from: d  reason: collision with root package name */
            boolean f3436d;

            class a implements Parcelable.Creator<FullSpanItem> {
                a() {
                }

                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: b */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            FullSpanItem() {
            }

            FullSpanItem(Parcel parcel) {
                this.f3433a = parcel.readInt();
                this.f3434b = parcel.readInt();
                this.f3436d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f3435c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            /* access modifiers changed from: package-private */
            public int a(int i10) {
                int[] iArr = this.f3435c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3433a + ", mGapDir=" + this.f3434b + ", mHasUnwantedGapAfter=" + this.f3436d + ", mGapPerSpan=" + Arrays.toString(this.f3435c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f3433a);
                parcel.writeInt(this.f3434b);
                parcel.writeInt(this.f3436d ? 1 : 0);
                int[] iArr = this.f3435c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f3435c);
            }
        }

        LazySpanLookup() {
        }

        private int i(int i10) {
            if (this.f3432b == null) {
                return -1;
            }
            FullSpanItem f10 = f(i10);
            if (f10 != null) {
                this.f3432b.remove(f10);
            }
            int size = this.f3432b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (this.f3432b.get(i11).f3433a >= i10) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 == -1) {
                return -1;
            }
            this.f3432b.remove(i11);
            return this.f3432b.get(i11).f3433a;
        }

        private void l(int i10, int i11) {
            List<FullSpanItem> list = this.f3432b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f3432b.get(size);
                    int i12 = fullSpanItem.f3433a;
                    if (i12 >= i10) {
                        fullSpanItem.f3433a = i12 + i11;
                    }
                }
            }
        }

        private void m(int i10, int i11) {
            List<FullSpanItem> list = this.f3432b;
            if (list != null) {
                int i12 = i10 + i11;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f3432b.get(size);
                    int i13 = fullSpanItem.f3433a;
                    if (i13 >= i10) {
                        if (i13 < i12) {
                            this.f3432b.remove(size);
                        } else {
                            fullSpanItem.f3433a = i13 - i11;
                        }
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f3432b == null) {
                this.f3432b = new ArrayList();
            }
            int size = this.f3432b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = this.f3432b.get(i10);
                if (fullSpanItem2.f3433a == fullSpanItem.f3433a) {
                    this.f3432b.remove(i10);
                }
                if (fullSpanItem2.f3433a >= fullSpanItem.f3433a) {
                    this.f3432b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f3432b.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f3431a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3432b = null;
        }

        /* access modifiers changed from: package-private */
        public void c(int i10) {
            int[] iArr = this.f3431a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i10, 10) + 1)];
                this.f3431a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f3431a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f3431a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public int d(int i10) {
            List<FullSpanItem> list = this.f3432b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f3432b.get(size).f3433a >= i10) {
                        this.f3432b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public FullSpanItem e(int i10, int i11, int i12, boolean z10) {
            List<FullSpanItem> list = this.f3432b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = this.f3432b.get(i13);
                int i14 = fullSpanItem.f3433a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f3434b == i12 || (z10 && fullSpanItem.f3436d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i10) {
            List<FullSpanItem> list = this.f3432b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3432b.get(size);
                if (fullSpanItem.f3433a == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int g(int i10) {
            int[] iArr = this.f3431a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        /* access modifiers changed from: package-private */
        public int h(int i10) {
            int[] iArr = this.f3431a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f3431a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f3431a.length;
            }
            int min = Math.min(i11 + 1, this.f3431a.length);
            Arrays.fill(this.f3431a, i10, min, -1);
            return min;
        }

        /* access modifiers changed from: package-private */
        public void j(int i10, int i11) {
            int[] iArr = this.f3431a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f3431a;
                System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
                Arrays.fill(this.f3431a, i10, i12, -1);
                l(i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i10, int i11) {
            int[] iArr = this.f3431a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f3431a;
                System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
                int[] iArr3 = this.f3431a;
                Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
                m(i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void n(int i10, c cVar) {
            c(i10);
            this.f3431a[i10] = cVar.f3459e;
        }

        /* access modifiers changed from: package-private */
        public int o(int i10) {
            int length = this.f3431a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f3437a;

        /* renamed from: b  reason: collision with root package name */
        int f3438b;

        /* renamed from: c  reason: collision with root package name */
        int f3439c;

        /* renamed from: d  reason: collision with root package name */
        int[] f3440d;

        /* renamed from: e  reason: collision with root package name */
        int f3441e;

        /* renamed from: f  reason: collision with root package name */
        int[] f3442f;

        /* renamed from: g  reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f3443g;

        /* renamed from: h  reason: collision with root package name */
        boolean f3444h;

        /* renamed from: i  reason: collision with root package name */
        boolean f3445i;

        /* renamed from: j  reason: collision with root package name */
        boolean f3446j;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3437a = parcel.readInt();
            this.f3438b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f3439c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f3440d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f3441e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f3442f = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z10 = false;
            this.f3444h = parcel.readInt() == 1;
            this.f3445i = parcel.readInt() == 1;
            this.f3446j = parcel.readInt() == 1 ? true : z10;
            this.f3443g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3439c = savedState.f3439c;
            this.f3437a = savedState.f3437a;
            this.f3438b = savedState.f3438b;
            this.f3440d = savedState.f3440d;
            this.f3441e = savedState.f3441e;
            this.f3442f = savedState.f3442f;
            this.f3444h = savedState.f3444h;
            this.f3445i = savedState.f3445i;
            this.f3446j = savedState.f3446j;
            this.f3443g = savedState.f3443g;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3440d = null;
            this.f3439c = 0;
            this.f3437a = -1;
            this.f3438b = -1;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3440d = null;
            this.f3439c = 0;
            this.f3441e = 0;
            this.f3442f = null;
            this.f3443g = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3437a);
            parcel.writeInt(this.f3438b);
            parcel.writeInt(this.f3439c);
            if (this.f3439c > 0) {
                parcel.writeIntArray(this.f3440d);
            }
            parcel.writeInt(this.f3441e);
            if (this.f3441e > 0) {
                parcel.writeIntArray(this.f3442f);
            }
            parcel.writeInt(this.f3444h ? 1 : 0);
            parcel.writeInt(this.f3445i ? 1 : 0);
            parcel.writeInt(this.f3446j ? 1 : 0);
            parcel.writeList(this.f3443g);
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.e2();
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        int f3448a;

        /* renamed from: b  reason: collision with root package name */
        int f3449b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3450c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3451d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3452e;

        /* renamed from: f  reason: collision with root package name */
        int[] f3453f;

        b() {
            c();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3449b = this.f3450c ? StaggeredGridLayoutManager.this.f3423u.i() : StaggeredGridLayoutManager.this.f3423u.m();
        }

        /* access modifiers changed from: package-private */
        public void b(int i10) {
            this.f3449b = this.f3450c ? StaggeredGridLayoutManager.this.f3423u.i() - i10 : StaggeredGridLayoutManager.this.f3423u.m() + i10;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f3448a = -1;
            this.f3449b = Integer.MIN_VALUE;
            this.f3450c = false;
            this.f3451d = false;
            this.f3452e = false;
            int[] iArr = this.f3453f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f3453f;
            if (iArr == null || iArr.length < length) {
                this.f3453f = new int[StaggeredGridLayoutManager.this.f3422t.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f3453f[i10] = cVarArr[i10].p(Integer.MIN_VALUE);
            }
        }
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f3455a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f3456b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f3457c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f3458d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f3459e;

        c(int i10) {
            this.f3459e = i10;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            LayoutParams n10 = n(view);
            n10.f3429e = this;
            this.f3455a.add(view);
            this.f3457c = Integer.MIN_VALUE;
            if (this.f3455a.size() == 1) {
                this.f3456b = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f3458d += StaggeredGridLayoutManager.this.f3423u.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z10, int i10) {
            int l10 = z10 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (l10 != Integer.MIN_VALUE) {
                if (z10 && l10 < StaggeredGridLayoutManager.this.f3423u.i()) {
                    return;
                }
                if (z10 || l10 <= StaggeredGridLayoutManager.this.f3423u.m()) {
                    if (i10 != Integer.MIN_VALUE) {
                        l10 += i10;
                    }
                    this.f3457c = l10;
                    this.f3456b = l10;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            LazySpanLookup.FullSpanItem f10;
            ArrayList<View> arrayList = this.f3455a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams n10 = n(view);
            this.f3457c = StaggeredGridLayoutManager.this.f3423u.d(view);
            if (n10.f3430f && (f10 = StaggeredGridLayoutManager.this.E.f(n10.a())) != null && f10.f3434b == 1) {
                this.f3457c += f10.a(this.f3459e);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            LazySpanLookup.FullSpanItem f10;
            View view = this.f3455a.get(0);
            LayoutParams n10 = n(view);
            this.f3456b = StaggeredGridLayoutManager.this.f3423u.g(view);
            if (n10.f3430f && (f10 = StaggeredGridLayoutManager.this.E.f(n10.a())) != null && f10.f3434b == -1) {
                this.f3456b -= f10.a(this.f3459e);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f3455a.clear();
            q();
            this.f3458d = 0;
        }

        public int f() {
            int i10;
            int i11;
            if (StaggeredGridLayoutManager.this.f3428z) {
                i11 = this.f3455a.size() - 1;
                i10 = -1;
            } else {
                i11 = 0;
                i10 = this.f3455a.size();
            }
            return i(i11, i10, true);
        }

        public int g() {
            int i10;
            int i11;
            if (StaggeredGridLayoutManager.this.f3428z) {
                i11 = 0;
                i10 = this.f3455a.size();
            } else {
                i11 = this.f3455a.size() - 1;
                i10 = -1;
            }
            return i(i11, i10, true);
        }

        /* access modifiers changed from: package-private */
        public int h(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int m10 = StaggeredGridLayoutManager.this.f3423u.m();
            int i12 = StaggeredGridLayoutManager.this.f3423u.i();
            int i13 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = this.f3455a.get(i10);
                int g10 = StaggeredGridLayoutManager.this.f3423u.g(view);
                int d10 = StaggeredGridLayoutManager.this.f3423u.d(view);
                boolean z13 = false;
                boolean z14 = !z12 ? g10 < i12 : g10 <= i12;
                if (!z12 ? d10 > m10 : d10 >= m10) {
                    z13 = true;
                }
                if (z14 && z13) {
                    if (!z10 || !z11) {
                        if (!z11 && g10 >= m10 && d10 <= i12) {
                        }
                    } else if (g10 >= m10 && d10 <= i12) {
                    }
                    return StaggeredGridLayoutManager.this.r0(view);
                }
                i10 += i13;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int i(int i10, int i11, boolean z10) {
            return h(i10, i11, false, false, z10);
        }

        public int j() {
            return this.f3458d;
        }

        /* access modifiers changed from: package-private */
        public int k() {
            int i10 = this.f3457c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f3457c;
        }

        /* access modifiers changed from: package-private */
        public int l(int i10) {
            int i11 = this.f3457c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f3455a.size() == 0) {
                return i10;
            }
            c();
            return this.f3457c;
        }

        public View m(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f3455a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f3455a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f3428z && staggeredGridLayoutManager.r0(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f3428z && staggeredGridLayoutManager2.r0(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f3455a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = this.f3455a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f3428z && staggeredGridLayoutManager3.r0(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f3428z && staggeredGridLayoutManager4.r0(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public LayoutParams n(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public int o() {
            int i10 = this.f3456b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f3456b;
        }

        /* access modifiers changed from: package-private */
        public int p(int i10) {
            int i11 = this.f3456b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f3455a.size() == 0) {
                return i10;
            }
            d();
            return this.f3456b;
        }

        /* access modifiers changed from: package-private */
        public void q() {
            this.f3456b = Integer.MIN_VALUE;
            this.f3457c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void r(int i10) {
            int i11 = this.f3456b;
            if (i11 != Integer.MIN_VALUE) {
                this.f3456b = i11 + i10;
            }
            int i12 = this.f3457c;
            if (i12 != Integer.MIN_VALUE) {
                this.f3457c = i12 + i10;
            }
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int size = this.f3455a.size();
            View remove = this.f3455a.remove(size - 1);
            LayoutParams n10 = n(remove);
            n10.f3429e = null;
            if (n10.c() || n10.b()) {
                this.f3458d -= StaggeredGridLayoutManager.this.f3423u.e(remove);
            }
            if (size == 1) {
                this.f3456b = Integer.MIN_VALUE;
            }
            this.f3457c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void t() {
            View remove = this.f3455a.remove(0);
            LayoutParams n10 = n(remove);
            n10.f3429e = null;
            if (this.f3455a.size() == 0) {
                this.f3457c = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f3458d -= StaggeredGridLayoutManager.this.f3423u.e(remove);
            }
            this.f3456b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void u(View view) {
            LayoutParams n10 = n(view);
            n10.f3429e = this;
            this.f3455a.add(0, view);
            this.f3456b = Integer.MIN_VALUE;
            if (this.f3455a.size() == 1) {
                this.f3457c = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f3458d += StaggeredGridLayoutManager.this.f3423u.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i10) {
            this.f3456b = i10;
            this.f3457c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.p.d s02 = RecyclerView.p.s0(context, attributeSet, i10, i11);
        T2(s02.f3371a);
        V2(s02.f3372b);
        U2(s02.f3373c);
        this.f3427y = new n();
        m2();
    }

    private int A2(int i10) {
        int p10 = this.f3422t[0].p(i10);
        for (int i11 = 1; i11 < this.f3421s; i11++) {
            int p11 = this.f3422t[i11].p(i10);
            if (p11 < p10) {
                p10 = p11;
            }
        }
        return p10;
    }

    private c B2(n nVar) {
        int i10;
        int i11;
        int i12 = -1;
        if (J2(nVar.f3675e)) {
            i11 = this.f3421s - 1;
            i10 = -1;
        } else {
            i11 = 0;
            i12 = this.f3421s;
            i10 = 1;
        }
        c cVar = null;
        if (nVar.f3675e == 1) {
            int i13 = Integer.MAX_VALUE;
            int m10 = this.f3423u.m();
            while (i11 != i12) {
                c cVar2 = this.f3422t[i11];
                int l10 = cVar2.l(m10);
                if (l10 < i13) {
                    cVar = cVar2;
                    i13 = l10;
                }
                i11 += i10;
            }
            return cVar;
        }
        int i14 = Integer.MIN_VALUE;
        int i15 = this.f3423u.i();
        while (i11 != i12) {
            c cVar3 = this.f3422t[i11];
            int p10 = cVar3.p(i15);
            if (p10 > i14) {
                cVar = cVar3;
                i14 = p10;
            }
            i11 += i10;
        }
        return cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void C2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.w2()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.v2()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.E
            r7.j(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.j(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.A
            if (r7 == 0) goto L_0x004d
            int r7 = r6.v2()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.w2()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.F1()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.C2(int, int, int):void");
    }

    private void G2(View view, int i10, int i11, boolean z10) {
        v(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = layoutParams.leftMargin;
        Rect rect = this.K;
        int d32 = d3(i10, i12 + rect.left, layoutParams.rightMargin + rect.right);
        int i13 = layoutParams.topMargin;
        Rect rect2 = this.K;
        int d33 = d3(i11, i13 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z10 ? T1(view, d32, d33, layoutParams) : R1(view, d32, d33, layoutParams)) {
            view.measure(d32, d33);
        }
    }

    private void H2(View view, LayoutParams layoutParams, boolean z10) {
        int i10;
        int i11;
        if (layoutParams.f3430f) {
            if (this.f3425w == 1) {
                i11 = this.J;
            } else {
                G2(view, RecyclerView.p.Y(y0(), z0(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.J, z10);
                return;
            }
        } else if (this.f3425w == 1) {
            i11 = RecyclerView.p.Y(this.f3426x, z0(), 0, layoutParams.width, false);
        } else {
            i11 = RecyclerView.p.Y(y0(), z0(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true);
            i10 = RecyclerView.p.Y(this.f3426x, l0(), 0, layoutParams.height, false);
            G2(view, i11, i10, z10);
        }
        i10 = RecyclerView.p.Y(k0(), l0(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true);
        G2(view, i11, i10, z10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014b, code lost:
        if (e2() != false) goto L_0x014f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void I2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.z r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r0 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.I
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.C
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.b()
            if (r1 != 0) goto L_0x0018
            r8.w1(r9)
            r0.c()
            return
        L_0x0018:
            boolean r1 = r0.f3452e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.C
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.I
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r4
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 == 0) goto L_0x0037
            r8.Z1(r0)
            goto L_0x003e
        L_0x0037:
            r8.Q2()
            boolean r5 = r8.A
            r0.f3450c = r5
        L_0x003e:
            r8.Z2(r10, r0)
            r0.f3452e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 != 0) goto L_0x0060
            int r5 = r8.C
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f3450c
            boolean r6 = r8.G
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.F2()
            boolean r6 = r8.H
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.E
            r5.b()
            r0.f3451d = r4
        L_0x0060:
            int r5 = r8.X()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f3439c
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f3451d
            if (r5 == 0) goto L_0x008e
            r1 = r3
        L_0x0073:
            int r5 = r8.f3421s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f3422t
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f3449b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r6 = r8.f3422t
            r6 = r6[r1]
            r6.v(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.L
            int[] r1 = r1.f3453f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = r3
        L_0x0098:
            int r5 = r8.f3421s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f3422t
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r6 = r8.L
            int[] r6 = r6.f3453f
            r6 = r6[r1]
            r5.v(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = r3
        L_0x00b0:
            int r5 = r8.f3421s
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f3422t
            r5 = r5[r1]
            boolean r6 = r8.A
            int r7 = r0.f3449b
            r5.b(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f3422t
            r1.d(r5)
        L_0x00c9:
            r8.I(r9)
            androidx.recyclerview.widget.n r1 = r8.f3427y
            r1.f3671a = r3
            r8.M = r3
            androidx.recyclerview.widget.s r1 = r8.f3424v
            int r1 = r1.n()
            r8.b3(r1)
            int r1 = r0.f3448a
            r8.a3(r1, r10)
            boolean r1 = r0.f3450c
            if (r1 == 0) goto L_0x00f0
            r8.S2(r2)
            androidx.recyclerview.widget.n r1 = r8.f3427y
            r8.n2(r9, r1, r10)
            r8.S2(r4)
            goto L_0x00fb
        L_0x00f0:
            r8.S2(r4)
            androidx.recyclerview.widget.n r1 = r8.f3427y
            r8.n2(r9, r1, r10)
            r8.S2(r2)
        L_0x00fb:
            androidx.recyclerview.widget.n r1 = r8.f3427y
            int r2 = r0.f3448a
            int r5 = r1.f3674d
            int r2 = r2 + r5
            r1.f3673c = r2
            r8.n2(r9, r1, r10)
            r8.P2()
            int r1 = r8.X()
            if (r1 <= 0) goto L_0x0121
            boolean r1 = r8.A
            if (r1 == 0) goto L_0x011b
            r8.t2(r9, r10, r4)
            r8.u2(r9, r10, r3)
            goto L_0x0121
        L_0x011b:
            r8.u2(r9, r10, r4)
            r8.t2(r9, r10, r3)
        L_0x0121:
            if (r11 == 0) goto L_0x014e
            boolean r11 = r10.f()
            if (r11 != 0) goto L_0x014e
            int r11 = r8.F
            if (r11 == 0) goto L_0x013f
            int r11 = r8.X()
            if (r11 <= 0) goto L_0x013f
            boolean r11 = r8.M
            if (r11 != 0) goto L_0x013d
            android.view.View r11 = r8.D2()
            if (r11 == 0) goto L_0x013f
        L_0x013d:
            r11 = r4
            goto L_0x0140
        L_0x013f:
            r11 = r3
        L_0x0140:
            if (r11 == 0) goto L_0x014e
            java.lang.Runnable r11 = r8.P
            r8.A1(r11)
            boolean r11 = r8.e2()
            if (r11 == 0) goto L_0x014e
            goto L_0x014f
        L_0x014e:
            r4 = r3
        L_0x014f:
            boolean r11 = r10.f()
            if (r11 == 0) goto L_0x015a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.L
            r11.c()
        L_0x015a:
            boolean r11 = r0.f3450c
            r8.G = r11
            boolean r11 = r8.F2()
            r8.H = r11
            if (r4 == 0) goto L_0x016e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.L
            r11.c()
            r8.I2(r9, r10, r3)
        L_0x016e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.I2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean):void");
    }

    private boolean J2(int i10) {
        if (this.f3425w == 0) {
            return (i10 == -1) != this.A;
        }
        return ((i10 == -1) == this.A) == F2();
    }

    private void L2(View view) {
        for (int i10 = this.f3421s - 1; i10 >= 0; i10--) {
            this.f3422t[i10].u(view);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r4.f3675e == -1) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M2(androidx.recyclerview.widget.RecyclerView.v r3, androidx.recyclerview.widget.n r4) {
        /*
            r2 = this;
            boolean r0 = r4.f3671a
            if (r0 == 0) goto L_0x004d
            boolean r0 = r4.f3679i
            if (r0 == 0) goto L_0x0009
            goto L_0x004d
        L_0x0009:
            int r0 = r4.f3672b
            r1 = -1
            if (r0 != 0) goto L_0x001e
            int r0 = r4.f3675e
            if (r0 != r1) goto L_0x0018
        L_0x0012:
            int r4 = r4.f3677g
        L_0x0014:
            r2.N2(r3, r4)
            goto L_0x004d
        L_0x0018:
            int r4 = r4.f3676f
        L_0x001a:
            r2.O2(r3, r4)
            goto L_0x004d
        L_0x001e:
            int r0 = r4.f3675e
            if (r0 != r1) goto L_0x0037
            int r0 = r4.f3676f
            int r1 = r2.y2(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x002c
            goto L_0x0012
        L_0x002c:
            int r1 = r4.f3677g
            int r4 = r4.f3672b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L_0x0014
        L_0x0037:
            int r0 = r4.f3677g
            int r0 = r2.z2(r0)
            int r1 = r4.f3677g
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x0043
            goto L_0x0018
        L_0x0043:
            int r1 = r4.f3676f
            int r4 = r4.f3672b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L_0x001a
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.M2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.n):void");
    }

    private void N2(RecyclerView.v vVar, int i10) {
        int X = X() - 1;
        while (X >= 0) {
            View W = W(X);
            if (this.f3423u.g(W) >= i10 && this.f3423u.q(W) >= i10) {
                LayoutParams layoutParams = (LayoutParams) W.getLayoutParams();
                if (layoutParams.f3430f) {
                    int i11 = 0;
                    while (i11 < this.f3421s) {
                        if (this.f3422t[i11].f3455a.size() != 1) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f3421s; i12++) {
                        this.f3422t[i12].s();
                    }
                } else if (layoutParams.f3429e.f3455a.size() != 1) {
                    layoutParams.f3429e.s();
                } else {
                    return;
                }
                y1(W, vVar);
                X--;
            } else {
                return;
            }
        }
    }

    private void O2(RecyclerView.v vVar, int i10) {
        while (X() > 0) {
            View W = W(0);
            if (this.f3423u.d(W) <= i10 && this.f3423u.p(W) <= i10) {
                LayoutParams layoutParams = (LayoutParams) W.getLayoutParams();
                if (layoutParams.f3430f) {
                    int i11 = 0;
                    while (i11 < this.f3421s) {
                        if (this.f3422t[i11].f3455a.size() != 1) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f3421s; i12++) {
                        this.f3422t[i12].t();
                    }
                } else if (layoutParams.f3429e.f3455a.size() != 1) {
                    layoutParams.f3429e.t();
                } else {
                    return;
                }
                y1(W, vVar);
            } else {
                return;
            }
        }
    }

    private void P2() {
        if (this.f3424v.k() != 1073741824) {
            float f10 = 0.0f;
            int X = X();
            for (int i10 = 0; i10 < X; i10++) {
                View W = W(i10);
                float e10 = (float) this.f3424v.e(W);
                if (e10 >= f10) {
                    if (((LayoutParams) W.getLayoutParams()).e()) {
                        e10 = (e10 * 1.0f) / ((float) this.f3421s);
                    }
                    f10 = Math.max(f10, e10);
                }
            }
            int i11 = this.f3426x;
            int round = Math.round(f10 * ((float) this.f3421s));
            if (this.f3424v.k() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f3424v.n());
            }
            b3(round);
            if (this.f3426x != i11) {
                for (int i12 = 0; i12 < X; i12++) {
                    View W2 = W(i12);
                    LayoutParams layoutParams = (LayoutParams) W2.getLayoutParams();
                    if (!layoutParams.f3430f) {
                        if (!F2() || this.f3425w != 1) {
                            int i13 = layoutParams.f3429e.f3459e;
                            int i14 = this.f3425w;
                            int i15 = (this.f3426x * i13) - (i13 * i11);
                            if (i14 == 1) {
                                W2.offsetLeftAndRight(i15);
                            } else {
                                W2.offsetTopAndBottom(i15);
                            }
                        } else {
                            int i16 = this.f3421s;
                            int i17 = layoutParams.f3429e.f3459e;
                            W2.offsetLeftAndRight(((-((i16 - 1) - i17)) * this.f3426x) - ((-((i16 - 1) - i17)) * i11));
                        }
                    }
                }
            }
        }
    }

    private void Q2() {
        this.A = (this.f3425w == 1 || !F2()) ? this.f3428z : !this.f3428z;
    }

    private void S2(int i10) {
        n nVar = this.f3427y;
        nVar.f3675e = i10;
        int i11 = 1;
        if (this.A != (i10 == -1)) {
            i11 = -1;
        }
        nVar.f3674d = i11;
    }

    private void W2(int i10, int i11) {
        for (int i12 = 0; i12 < this.f3421s; i12++) {
            if (!this.f3422t[i12].f3455a.isEmpty()) {
                c3(this.f3422t[i12], i10, i11);
            }
        }
    }

    private boolean X2(RecyclerView.z zVar, b bVar) {
        boolean z10 = this.G;
        int b10 = zVar.b();
        bVar.f3448a = z10 ? s2(b10) : o2(b10);
        bVar.f3449b = Integer.MIN_VALUE;
        return true;
    }

    private void Y1(View view) {
        for (int i10 = this.f3421s - 1; i10 >= 0; i10--) {
            this.f3422t[i10].a(view);
        }
    }

    private void Z1(b bVar) {
        boolean z10;
        SavedState savedState = this.I;
        int i10 = savedState.f3439c;
        if (i10 > 0) {
            if (i10 == this.f3421s) {
                for (int i11 = 0; i11 < this.f3421s; i11++) {
                    this.f3422t[i11].e();
                    SavedState savedState2 = this.I;
                    int i12 = savedState2.f3440d[i11];
                    if (i12 != Integer.MIN_VALUE) {
                        i12 += savedState2.f3445i ? this.f3423u.i() : this.f3423u.m();
                    }
                    this.f3422t[i11].v(i12);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.I;
                savedState3.f3437a = savedState3.f3438b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.f3446j;
        U2(savedState4.f3444h);
        Q2();
        SavedState savedState5 = this.I;
        int i13 = savedState5.f3437a;
        if (i13 != -1) {
            this.C = i13;
            z10 = savedState5.f3445i;
        } else {
            z10 = this.A;
        }
        bVar.f3450c = z10;
        if (savedState5.f3441e > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f3431a = savedState5.f3442f;
            lazySpanLookup.f3432b = savedState5.f3443g;
        }
    }

    private void a3(int i10, RecyclerView.z zVar) {
        int i11;
        int i12;
        int c10;
        n nVar = this.f3427y;
        boolean z10 = false;
        nVar.f3672b = 0;
        nVar.f3673c = i10;
        if (!I0() || (c10 = zVar.c()) == -1) {
            i12 = 0;
            i11 = 0;
        } else {
            if (this.A == (c10 < i10)) {
                i12 = this.f3423u.n();
                i11 = 0;
            } else {
                i11 = this.f3423u.n();
                i12 = 0;
            }
        }
        if (a0()) {
            this.f3427y.f3676f = this.f3423u.m() - i11;
            this.f3427y.f3677g = this.f3423u.i() + i12;
        } else {
            this.f3427y.f3677g = this.f3423u.h() + i12;
            this.f3427y.f3676f = -i11;
        }
        n nVar2 = this.f3427y;
        nVar2.f3678h = false;
        nVar2.f3671a = true;
        if (this.f3423u.k() == 0 && this.f3423u.h() == 0) {
            z10 = true;
        }
        nVar2.f3679i = z10;
    }

    private void c2(View view, LayoutParams layoutParams, n nVar) {
        if (nVar.f3675e == 1) {
            if (layoutParams.f3430f) {
                Y1(view);
            } else {
                layoutParams.f3429e.a(view);
            }
        } else if (layoutParams.f3430f) {
            L2(view);
        } else {
            layoutParams.f3429e.u(view);
        }
    }

    private void c3(c cVar, int i10, int i11) {
        int j10 = cVar.j();
        if (i10 == -1) {
            if (cVar.o() + j10 > i11) {
                return;
            }
        } else if (cVar.k() - j10 < i11) {
            return;
        }
        this.B.set(cVar.f3459e, false);
    }

    private int d2(int i10) {
        if (X() == 0) {
            return this.A ? 1 : -1;
        }
        return (i10 < v2()) != this.A ? -1 : 1;
    }

    private int d3(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    private boolean f2(c cVar) {
        if (this.A) {
            if (cVar.k() < this.f3423u.i()) {
                ArrayList<View> arrayList = cVar.f3455a;
                return !cVar.n(arrayList.get(arrayList.size() - 1)).f3430f;
            }
        } else if (cVar.o() > this.f3423u.m()) {
            return !cVar.n(cVar.f3455a.get(0)).f3430f;
        }
        return false;
    }

    private int g2(RecyclerView.z zVar) {
        if (X() == 0) {
            return 0;
        }
        return v.a(zVar, this.f3423u, q2(!this.N), p2(!this.N), this, this.N);
    }

    private int h2(RecyclerView.z zVar) {
        if (X() == 0) {
            return 0;
        }
        return v.b(zVar, this.f3423u, q2(!this.N), p2(!this.N), this, this.N, this.A);
    }

    private int i2(RecyclerView.z zVar) {
        if (X() == 0) {
            return 0;
        }
        return v.c(zVar, this.f3423u, q2(!this.N), p2(!this.N), this, this.N);
    }

    private int j2(int i10) {
        if (i10 == 1) {
            return (this.f3425w != 1 && F2()) ? 1 : -1;
        }
        if (i10 == 2) {
            return (this.f3425w != 1 && F2()) ? -1 : 1;
        }
        if (i10 == 17) {
            return this.f3425w == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 == 33) {
            return this.f3425w == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 == 66) {
            return this.f3425w == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i10 != 130) {
            return Integer.MIN_VALUE;
        }
        return this.f3425w == 1 ? 1 : Integer.MIN_VALUE;
    }

    private LazySpanLookup.FullSpanItem k2(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3435c = new int[this.f3421s];
        for (int i11 = 0; i11 < this.f3421s; i11++) {
            fullSpanItem.f3435c[i11] = i10 - this.f3422t[i11].l(i10);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem l2(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3435c = new int[this.f3421s];
        for (int i11 = 0; i11 < this.f3421s; i11++) {
            fullSpanItem.f3435c[i11] = this.f3422t[i11].p(i10) - i10;
        }
        return fullSpanItem;
    }

    private void m2() {
        this.f3423u = s.b(this, this.f3425w);
        this.f3424v = s.b(this, 1 - this.f3425w);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v5 */
    private int n2(RecyclerView.v vVar, n nVar, RecyclerView.z zVar) {
        c cVar;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View view;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        boolean z10;
        RecyclerView.v vVar2 = vVar;
        n nVar2 = nVar;
        ? r92 = 0;
        this.B.set(0, this.f3421s, true);
        int i16 = this.f3427y.f3679i ? nVar2.f3675e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : nVar2.f3675e == 1 ? nVar2.f3677g + nVar2.f3672b : nVar2.f3676f - nVar2.f3672b;
        W2(nVar2.f3675e, i16);
        int i17 = this.A ? this.f3423u.i() : this.f3423u.m();
        boolean z11 = false;
        while (nVar.a(zVar) && (this.f3427y.f3679i || !this.B.isEmpty())) {
            View b10 = nVar2.b(vVar2);
            LayoutParams layoutParams = (LayoutParams) b10.getLayoutParams();
            int a10 = layoutParams.a();
            int g10 = this.E.g(a10);
            boolean z12 = g10 == -1 ? true : r92;
            if (z12) {
                cVar = layoutParams.f3430f ? this.f3422t[r92] : B2(nVar2);
                this.E.n(a10, cVar);
            } else {
                cVar = this.f3422t[g10];
            }
            c cVar2 = cVar;
            layoutParams.f3429e = cVar2;
            if (nVar2.f3675e == 1) {
                o(b10);
            } else {
                p(b10, r92);
            }
            H2(b10, layoutParams, r92);
            if (nVar2.f3675e == 1) {
                int x22 = layoutParams.f3430f ? x2(i17) : cVar2.l(i17);
                int e10 = this.f3423u.e(b10) + x22;
                if (z12 && layoutParams.f3430f) {
                    LazySpanLookup.FullSpanItem k22 = k2(x22);
                    k22.f3434b = -1;
                    k22.f3433a = a10;
                    this.E.a(k22);
                }
                i10 = e10;
                i11 = x22;
            } else {
                int A2 = layoutParams.f3430f ? A2(i17) : cVar2.p(i17);
                i11 = A2 - this.f3423u.e(b10);
                if (z12 && layoutParams.f3430f) {
                    LazySpanLookup.FullSpanItem l22 = l2(A2);
                    l22.f3434b = 1;
                    l22.f3433a = a10;
                    this.E.a(l22);
                }
                i10 = A2;
            }
            if (layoutParams.f3430f && nVar2.f3674d == -1) {
                if (!z12) {
                    if (!(nVar2.f3675e == 1 ? a2() : b2())) {
                        LazySpanLookup.FullSpanItem f10 = this.E.f(a10);
                        if (f10 != null) {
                            f10.f3436d = true;
                        }
                    }
                }
                this.M = true;
            }
            c2(b10, layoutParams, nVar2);
            if (!F2() || this.f3425w != 1) {
                int m10 = layoutParams.f3430f ? this.f3424v.m() : (cVar2.f3459e * this.f3426x) + this.f3424v.m();
                i13 = m10;
                i12 = this.f3424v.e(b10) + m10;
            } else {
                int i18 = layoutParams.f3430f ? this.f3424v.i() : this.f3424v.i() - (((this.f3421s - 1) - cVar2.f3459e) * this.f3426x);
                i12 = i18;
                i13 = i18 - this.f3424v.e(b10);
            }
            if (this.f3425w == 1) {
                staggeredGridLayoutManager = this;
                view = b10;
                i15 = i13;
                i13 = i11;
                i14 = i12;
            } else {
                staggeredGridLayoutManager = this;
                view = b10;
                i15 = i11;
                i14 = i10;
                i10 = i12;
            }
            staggeredGridLayoutManager.K0(view, i15, i13, i14, i10);
            if (layoutParams.f3430f) {
                W2(this.f3427y.f3675e, i16);
            } else {
                c3(cVar2, this.f3427y.f3675e, i16);
            }
            M2(vVar2, this.f3427y);
            if (this.f3427y.f3678h && b10.hasFocusable()) {
                if (layoutParams.f3430f) {
                    this.B.clear();
                } else {
                    z10 = false;
                    this.B.set(cVar2.f3459e, false);
                    r92 = z10;
                    z11 = true;
                }
            }
            z10 = false;
            r92 = z10;
            z11 = true;
        }
        int i19 = r92;
        if (!z11) {
            M2(vVar2, this.f3427y);
        }
        int m11 = this.f3427y.f3675e == -1 ? this.f3423u.m() - A2(this.f3423u.m()) : x2(this.f3423u.i()) - this.f3423u.i();
        return m11 > 0 ? Math.min(nVar2.f3672b, m11) : i19;
    }

    private int o2(int i10) {
        int X = X();
        for (int i11 = 0; i11 < X; i11++) {
            int r02 = r0(W(i11));
            if (r02 >= 0 && r02 < i10) {
                return r02;
            }
        }
        return 0;
    }

    private int s2(int i10) {
        for (int X = X() - 1; X >= 0; X--) {
            int r02 = r0(W(X));
            if (r02 >= 0 && r02 < i10) {
                return r02;
            }
        }
        return 0;
    }

    private void t2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int i10;
        int x22 = x2(Integer.MIN_VALUE);
        if (x22 != Integer.MIN_VALUE && (i10 = this.f3423u.i() - x22) > 0) {
            int i11 = i10 - (-R2(-i10, vVar, zVar));
            if (z10 && i11 > 0) {
                this.f3423u.r(i11);
            }
        }
    }

    private void u2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int m10;
        int A2 = A2(Integer.MAX_VALUE);
        if (A2 != Integer.MAX_VALUE && (m10 = A2 - this.f3423u.m()) > 0) {
            int R2 = m10 - R2(m10, vVar, zVar);
            if (z10 && R2 > 0) {
                this.f3423u.r(-R2);
            }
        }
    }

    private int x2(int i10) {
        int l10 = this.f3422t[0].l(i10);
        for (int i11 = 1; i11 < this.f3421s; i11++) {
            int l11 = this.f3422t[i11].l(i10);
            if (l11 > l10) {
                l10 = l11;
            }
        }
        return l10;
    }

    private int y2(int i10) {
        int p10 = this.f3422t[0].p(i10);
        for (int i11 = 1; i11 < this.f3421s; i11++) {
            int p11 = this.f3422t[i11].p(i10);
            if (p11 > p10) {
                p10 = p11;
            }
        }
        return p10;
    }

    private int z2(int i10) {
        int l10 = this.f3422t[0].l(i10);
        for (int i11 = 1; i11 < this.f3421s; i11++) {
            int l11 = this.f3422t[i11].l(i10);
            if (l11 < l10) {
                l10 = l11;
            }
        }
        return l10;
    }

    public void A(int i10, int i11, RecyclerView.z zVar, RecyclerView.p.c cVar) {
        int i12;
        int i13;
        if (this.f3425w != 0) {
            i10 = i11;
        }
        if (X() != 0 && i10 != 0) {
            K2(i10, zVar);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.f3421s) {
                this.O = new int[this.f3421s];
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.f3421s; i15++) {
                n nVar = this.f3427y;
                if (nVar.f3674d == -1) {
                    i13 = nVar.f3676f;
                    i12 = this.f3422t[i15].p(i13);
                } else {
                    i13 = this.f3422t[i15].l(nVar.f3677g);
                    i12 = this.f3427y.f3677g;
                }
                int i16 = i13 - i12;
                if (i16 >= 0) {
                    this.O[i14] = i16;
                    i14++;
                }
            }
            Arrays.sort(this.O, 0, i14);
            for (int i17 = 0; i17 < i14 && this.f3427y.a(zVar); i17++) {
                cVar.a(this.f3427y.f3673c, this.O[i17]);
                n nVar2 = this.f3427y;
                nVar2.f3673c += nVar2.f3674d;
            }
        }
    }

    public int C(RecyclerView.z zVar) {
        return g2(zVar);
    }

    public boolean C0() {
        return this.F != 0;
    }

    public int D(RecyclerView.z zVar) {
        return h2(zVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View D2() {
        /*
            r12 = this;
            int r0 = r12.X()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f3421s
            r2.<init>(r3)
            int r3 = r12.f3421s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f3425w
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.F2()
            if (r3 == 0) goto L_0x0020
            r3 = r1
            goto L_0x0021
        L_0x0020:
            r3 = r5
        L_0x0021:
            boolean r6 = r12.A
            if (r6 == 0) goto L_0x0027
            r6 = r5
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = r1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.W(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f3429e
            int r9 = r9.f3459e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f3429e
            boolean r9 = r12.f2(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f3429e
            int r9 = r9.f3459e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f3430f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.W(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.s r10 = r12.f3423u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.s r11 = r12.f3423u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.s r10 = r12.f3423u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.s r11 = r12.f3423u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = r1
            goto L_0x008b
        L_0x008a:
            r10 = r4
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.f3429e
            int r8 = r8.f3459e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.f3429e
            int r9 = r9.f3459e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = r1
            goto L_0x00a1
        L_0x00a0:
            r8 = r4
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = r1
            goto L_0x00a6
        L_0x00a5:
            r9 = r4
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.D2():android.view.View");
    }

    public int E(RecyclerView.z zVar) {
        return i2(zVar);
    }

    public void E2() {
        this.E.b();
        F1();
    }

    public int F(RecyclerView.z zVar) {
        return g2(zVar);
    }

    /* access modifiers changed from: package-private */
    public boolean F2() {
        return n0() == 1;
    }

    public int G(RecyclerView.z zVar) {
        return h2(zVar);
    }

    public int H(RecyclerView.z zVar) {
        return i2(zVar);
    }

    public int I1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        return R2(i10, vVar, zVar);
    }

    public void J1(int i10) {
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.f3437a == i10)) {
            savedState.a();
        }
        this.C = i10;
        this.D = Integer.MIN_VALUE;
        F1();
    }

    public int K1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        return R2(i10, vVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public void K2(int i10, RecyclerView.z zVar) {
        int i11;
        int i12;
        if (i10 > 0) {
            i12 = w2();
            i11 = 1;
        } else {
            i11 = -1;
            i12 = v2();
        }
        this.f3427y.f3671a = true;
        a3(i12, zVar);
        S2(i11);
        n nVar = this.f3427y;
        nVar.f3673c = i12 + nVar.f3674d;
        nVar.f3672b = Math.abs(i10);
    }

    public void N0(int i10) {
        super.N0(i10);
        for (int i11 = 0; i11 < this.f3421s; i11++) {
            this.f3422t[i11].r(i10);
        }
    }

    public void O0(int i10) {
        super.O0(i10);
        for (int i11 = 0; i11 < this.f3421s; i11++) {
            this.f3422t[i11].r(i10);
        }
    }

    public void O1(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f3425w == 1) {
            i13 = RecyclerView.p.z(i11, rect.height() + paddingTop, p0());
            i12 = RecyclerView.p.z(i10, (this.f3426x * this.f3421s) + paddingLeft, q0());
        } else {
            i12 = RecyclerView.p.z(i10, rect.width() + paddingLeft, q0());
            i13 = RecyclerView.p.z(i11, (this.f3426x * this.f3421s) + paddingTop, p0());
        }
        N1(i12, i13);
    }

    public void P0(RecyclerView.h hVar, RecyclerView.h hVar2) {
        this.E.b();
        for (int i10 = 0; i10 < this.f3421s; i10++) {
            this.f3422t[i10].e();
        }
    }

    public RecyclerView.LayoutParams R() {
        return this.f3425w == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    /* access modifiers changed from: package-private */
    public int R2(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (X() == 0 || i10 == 0) {
            return 0;
        }
        K2(i10, zVar);
        int n22 = n2(vVar, this.f3427y, zVar);
        if (this.f3427y.f3672b >= n22) {
            i10 = i10 < 0 ? -n22 : n22;
        }
        this.f3423u.r(-i10);
        this.G = this.A;
        n nVar = this.f3427y;
        nVar.f3672b = 0;
        M2(vVar, nVar);
        return i10;
    }

    public RecyclerView.LayoutParams S(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams T(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void T0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.T0(recyclerView, vVar);
        A1(this.P);
        for (int i10 = 0; i10 < this.f3421s; i10++) {
            this.f3422t[i10].e();
        }
        recyclerView.requestLayout();
    }

    public void T2(int i10) {
        if (i10 == 0 || i10 == 1) {
            r((String) null);
            if (i10 != this.f3425w) {
                this.f3425w = i10;
                s sVar = this.f3423u;
                this.f3423u = this.f3424v;
                this.f3424v = sVar;
                F1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public View U0(View view, int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        View P2;
        View m10;
        if (X() == 0 || (P2 = P(view)) == null) {
            return null;
        }
        Q2();
        int j22 = j2(i10);
        if (j22 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) P2.getLayoutParams();
        boolean z10 = layoutParams.f3430f;
        c cVar = layoutParams.f3429e;
        int w22 = j22 == 1 ? w2() : v2();
        a3(w22, zVar);
        S2(j22);
        n nVar = this.f3427y;
        nVar.f3673c = nVar.f3674d + w22;
        nVar.f3672b = (int) (((float) this.f3423u.n()) * 0.33333334f);
        n nVar2 = this.f3427y;
        nVar2.f3678h = true;
        nVar2.f3671a = false;
        n2(vVar, nVar2, zVar);
        this.G = this.A;
        if (!z10 && (m10 = cVar.m(w22, j22)) != null && m10 != P2) {
            return m10;
        }
        if (J2(j22)) {
            for (int i11 = this.f3421s - 1; i11 >= 0; i11--) {
                View m11 = this.f3422t[i11].m(w22, j22);
                if (m11 != null && m11 != P2) {
                    return m11;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f3421s; i12++) {
                View m12 = this.f3422t[i12].m(w22, j22);
                if (m12 != null && m12 != P2) {
                    return m12;
                }
            }
        }
        boolean z11 = (this.f3428z ^ true) == (j22 == -1);
        if (!z10) {
            View Q = Q(z11 ? cVar.f() : cVar.g());
            if (!(Q == null || Q == P2)) {
                return Q;
            }
        }
        if (J2(j22)) {
            for (int i13 = this.f3421s - 1; i13 >= 0; i13--) {
                if (i13 != cVar.f3459e) {
                    c[] cVarArr = this.f3422t;
                    View Q2 = Q(z11 ? cVarArr[i13].f() : cVarArr[i13].g());
                    if (!(Q2 == null || Q2 == P2)) {
                        return Q2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f3421s; i14++) {
                c[] cVarArr2 = this.f3422t;
                View Q3 = Q(z11 ? cVarArr2[i14].f() : cVarArr2[i14].g());
                if (Q3 != null && Q3 != P2) {
                    return Q3;
                }
            }
        }
        return null;
    }

    public void U1(RecyclerView recyclerView, RecyclerView.z zVar, int i10) {
        o oVar = new o(recyclerView.getContext());
        oVar.p(i10);
        V1(oVar);
    }

    public void U2(boolean z10) {
        r((String) null);
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.f3444h == z10)) {
            savedState.f3444h = z10;
        }
        this.f3428z = z10;
        F1();
    }

    public void V0(AccessibilityEvent accessibilityEvent) {
        super.V0(accessibilityEvent);
        if (X() > 0) {
            View q22 = q2(false);
            View p22 = p2(false);
            if (q22 != null && p22 != null) {
                int r02 = r0(q22);
                int r03 = r0(p22);
                if (r02 < r03) {
                    accessibilityEvent.setFromIndex(r02);
                    accessibilityEvent.setToIndex(r03);
                    return;
                }
                accessibilityEvent.setFromIndex(r03);
                accessibilityEvent.setToIndex(r02);
            }
        }
    }

    public void V2(int i10) {
        r((String) null);
        if (i10 != this.f3421s) {
            E2();
            this.f3421s = i10;
            this.B = new BitSet(this.f3421s);
            this.f3422t = new c[this.f3421s];
            for (int i11 = 0; i11 < this.f3421s; i11++) {
                this.f3422t[i11] = new c(i11);
            }
            F1();
        }
    }

    public boolean X1() {
        return this.I == null;
    }

    /* access modifiers changed from: package-private */
    public boolean Y2(RecyclerView.z zVar, b bVar) {
        int i10;
        int i11;
        int i12;
        boolean z10 = false;
        if (!zVar.f() && (i10 = this.C) != -1) {
            if (i10 < 0 || i10 >= zVar.b()) {
                this.C = -1;
                this.D = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.I;
                if (savedState == null || savedState.f3437a == -1 || savedState.f3439c < 1) {
                    View Q = Q(this.C);
                    if (Q != null) {
                        bVar.f3448a = this.A ? w2() : v2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f3450c) {
                                i12 = this.f3423u.i() - this.D;
                                i11 = this.f3423u.d(Q);
                            } else {
                                i12 = this.f3423u.m() + this.D;
                                i11 = this.f3423u.g(Q);
                            }
                            bVar.f3449b = i12 - i11;
                            return true;
                        } else if (this.f3423u.e(Q) > this.f3423u.n()) {
                            bVar.f3449b = bVar.f3450c ? this.f3423u.i() : this.f3423u.m();
                            return true;
                        } else {
                            int g10 = this.f3423u.g(Q) - this.f3423u.m();
                            if (g10 < 0) {
                                bVar.f3449b = -g10;
                                return true;
                            }
                            int i13 = this.f3423u.i() - this.f3423u.d(Q);
                            if (i13 < 0) {
                                bVar.f3449b = i13;
                                return true;
                            }
                            bVar.f3449b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i14 = this.C;
                        bVar.f3448a = i14;
                        int i15 = this.D;
                        if (i15 == Integer.MIN_VALUE) {
                            if (d2(i14) == 1) {
                                z10 = true;
                            }
                            bVar.f3450c = z10;
                            bVar.a();
                        } else {
                            bVar.b(i15);
                        }
                        bVar.f3451d = true;
                    }
                } else {
                    bVar.f3449b = Integer.MIN_VALUE;
                    bVar.f3448a = this.C;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void Z2(RecyclerView.z zVar, b bVar) {
        if (!Y2(zVar, bVar) && !X2(zVar, bVar)) {
            bVar.a();
            bVar.f3448a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a2() {
        int l10 = this.f3422t[0].l(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f3421s; i10++) {
            if (this.f3422t[i10].l(Integer.MIN_VALUE) != l10) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b2() {
        int p10 = this.f3422t[0].p(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f3421s; i10++) {
            if (this.f3422t[i10].p(Integer.MIN_VALUE) != p10) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b3(int i10) {
        this.f3426x = i10 / this.f3421s;
        this.J = View.MeasureSpec.makeMeasureSpec(i10, this.f3424v.k());
    }

    public void c1(RecyclerView recyclerView, int i10, int i11) {
        C2(i10, i11, 1);
    }

    public PointF d(int i10) {
        int d22 = d2(i10);
        PointF pointF = new PointF();
        if (d22 == 0) {
            return null;
        }
        if (this.f3425w == 0) {
            pointF.x = (float) d22;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) d22;
        }
        return pointF;
    }

    public void d1(RecyclerView recyclerView) {
        this.E.b();
        F1();
    }

    public void e1(RecyclerView recyclerView, int i10, int i11, int i12) {
        C2(i10, i11, 8);
    }

    /* access modifiers changed from: package-private */
    public boolean e2() {
        int i10;
        int i11;
        if (X() == 0 || this.F == 0 || !B0()) {
            return false;
        }
        if (this.A) {
            i11 = w2();
            i10 = v2();
        } else {
            i11 = v2();
            i10 = w2();
        }
        if (i11 == 0 && D2() != null) {
            this.E.b();
        } else if (!this.M) {
            return false;
        } else {
            int i12 = this.A ? -1 : 1;
            int i13 = i10 + 1;
            LazySpanLookup.FullSpanItem e10 = this.E.e(i11, i13, i12, true);
            if (e10 == null) {
                this.M = false;
                this.E.d(i13);
                return false;
            }
            LazySpanLookup.FullSpanItem e11 = this.E.e(i11, e10.f3433a, i12 * -1, true);
            if (e11 == null) {
                this.E.d(e10.f3433a);
            } else {
                this.E.d(e11.f3433a + 1);
            }
        }
        G1();
        F1();
        return true;
    }

    public void f1(RecyclerView recyclerView, int i10, int i11) {
        C2(i10, i11, 2);
    }

    public void h1(RecyclerView recyclerView, int i10, int i11, Object obj) {
        C2(i10, i11, 4);
    }

    public void i1(RecyclerView.v vVar, RecyclerView.z zVar) {
        I2(vVar, zVar, true);
    }

    public void j1(RecyclerView.z zVar) {
        super.j1(zVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public void n1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.I = savedState;
            if (this.C != -1) {
                savedState.a();
                this.I.b();
            }
            F1();
        }
    }

    public Parcelable o1() {
        int i10;
        int i11;
        int[] iArr;
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        savedState.f3444h = this.f3428z;
        savedState.f3445i = this.G;
        savedState.f3446j = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f3431a) == null) {
            savedState.f3441e = 0;
        } else {
            savedState.f3442f = iArr;
            savedState.f3441e = iArr.length;
            savedState.f3443g = lazySpanLookup.f3432b;
        }
        if (X() > 0) {
            savedState.f3437a = this.G ? w2() : v2();
            savedState.f3438b = r2();
            int i12 = this.f3421s;
            savedState.f3439c = i12;
            savedState.f3440d = new int[i12];
            for (int i13 = 0; i13 < this.f3421s; i13++) {
                if (this.G) {
                    i10 = this.f3422t[i13].l(Integer.MIN_VALUE);
                    if (i10 != Integer.MIN_VALUE) {
                        i11 = this.f3423u.i();
                    } else {
                        savedState.f3440d[i13] = i10;
                    }
                } else {
                    i10 = this.f3422t[i13].p(Integer.MIN_VALUE);
                    if (i10 != Integer.MIN_VALUE) {
                        i11 = this.f3423u.m();
                    } else {
                        savedState.f3440d[i13] = i10;
                    }
                }
                i10 -= i11;
                savedState.f3440d[i13] = i10;
            }
        } else {
            savedState.f3437a = -1;
            savedState.f3438b = -1;
            savedState.f3439c = 0;
        }
        return savedState;
    }

    public void p1(int i10) {
        if (i10 == 0) {
            e2();
        }
    }

    /* access modifiers changed from: package-private */
    public View p2(boolean z10) {
        int m10 = this.f3423u.m();
        int i10 = this.f3423u.i();
        View view = null;
        for (int X = X() - 1; X >= 0; X--) {
            View W = W(X);
            int g10 = this.f3423u.g(W);
            int d10 = this.f3423u.d(W);
            if (d10 > m10 && g10 < i10) {
                if (d10 <= i10 || !z10) {
                    return W;
                }
                if (view == null) {
                    view = W;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View q2(boolean z10) {
        int m10 = this.f3423u.m();
        int i10 = this.f3423u.i();
        int X = X();
        View view = null;
        for (int i11 = 0; i11 < X; i11++) {
            View W = W(i11);
            int g10 = this.f3423u.g(W);
            if (this.f3423u.d(W) > m10 && g10 < i10) {
                if (g10 >= m10 || !z10) {
                    return W;
                }
                if (view == null) {
                    view = W;
                }
            }
        }
        return view;
    }

    public void r(String str) {
        if (this.I == null) {
            super.r(str);
        }
    }

    /* access modifiers changed from: package-private */
    public int r2() {
        View p22 = this.A ? p2(true) : q2(true);
        if (p22 == null) {
            return -1;
        }
        return r0(p22);
    }

    /* access modifiers changed from: package-private */
    public int v2() {
        if (X() == 0) {
            return 0;
        }
        return r0(W(0));
    }

    public boolean w() {
        return this.f3425w == 0;
    }

    /* access modifiers changed from: package-private */
    public int w2() {
        int X = X();
        if (X == 0) {
            return 0;
        }
        return r0(W(X - 1));
    }

    public boolean x() {
        return this.f3425w == 1;
    }

    public boolean y(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }
}
