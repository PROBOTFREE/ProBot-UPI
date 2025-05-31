package androidx.databinding;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.h;
import androidx.databinding.j;
import androidx.databinding.k;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.h;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public abstract class ViewDataBinding extends a {
    private static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final i CREATE_LIST_LISTENER = new b();
    private static final i CREATE_LIVE_DATA_LISTENER = new d();
    private static final i CREATE_MAP_LISTENER = new c();
    private static final i CREATE_PROPERTY_LISTENER = new a();
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final c.a<l, ViewDataBinding, Void> REBIND_NOTIFIER = new e();
    private static final int REBOUND = 3;
    /* access modifiers changed from: private */
    public static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER;
    static int SDK_INT;
    private static final boolean USE_CHOREOGRAPHER;
    /* access modifiers changed from: private */
    public static final ReferenceQueue<ViewDataBinding> sReferenceQueue = new ReferenceQueue<>();
    protected final e mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private androidx.lifecycle.o mLifecycleOwner;
    private o[] mLocalFieldObservers;
    private OnStartListener mOnStartListener;
    /* access modifiers changed from: private */
    public boolean mPendingRebind;
    private c<l, ViewDataBinding, Void> mRebindCallbacks;
    /* access modifiers changed from: private */
    public boolean mRebindHalted;
    /* access modifiers changed from: private */
    public final Runnable mRebindRunnable;
    /* access modifiers changed from: private */
    public final View mRoot;
    private Handler mUIThreadHandler;

    static class OnStartListener implements androidx.lifecycle.n {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<ViewDataBinding> f2512a;

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.f2512a = new WeakReference<>(viewDataBinding);
        }

        /* synthetic */ OnStartListener(ViewDataBinding viewDataBinding, a aVar) {
            this(viewDataBinding);
        }

        @w(h.b.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) this.f2512a.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }
    }

    static class a implements i {
        a() {
        }

        public o a(ViewDataBinding viewDataBinding, int i10) {
            return new q(viewDataBinding, i10).g();
        }
    }

    static class b implements i {
        b() {
        }

        public o a(ViewDataBinding viewDataBinding, int i10) {
            return new n(viewDataBinding, i10).e();
        }
    }

    static class c implements i {
        c() {
        }

        public o a(ViewDataBinding viewDataBinding, int i10) {
            return new p(viewDataBinding, i10).e();
        }
    }

    static class d implements i {
        d() {
        }

        public o a(ViewDataBinding viewDataBinding, int i10) {
            return new k(viewDataBinding, i10).e();
        }
    }

    static class e extends c.a<l, ViewDataBinding, Void> {
        e() {
        }

        /* renamed from: b */
        public void a(l lVar, ViewDataBinding viewDataBinding, int i10, Void voidR) {
            if (i10 != 1) {
                if (i10 == 2) {
                    lVar.b(viewDataBinding);
                } else if (i10 == 3) {
                    lVar.a(viewDataBinding);
                }
            } else if (!lVar.c(viewDataBinding)) {
                boolean unused = viewDataBinding.mRebindHalted = true;
            }
        }
    }

    static class f implements View.OnAttachStateChangeListener {
        f() {
        }

        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.getBinding(view).mRebindRunnable.run();
            view.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            synchronized (this) {
                boolean unused = ViewDataBinding.this.mPendingRebind = false;
            }
            ViewDataBinding.processReferenceQueue();
            if (Build.VERSION.SDK_INT < 19 || ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                ViewDataBinding.this.executePendingBindings();
                return;
            }
            ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
            ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
        }
    }

    class h implements Choreographer.FrameCallback {
        h() {
        }

        public void doFrame(long j10) {
            ViewDataBinding.this.mRebindRunnable.run();
        }
    }

    private interface i {
        o a(ViewDataBinding viewDataBinding, int i10);
    }

    protected static class j {

        /* renamed from: a  reason: collision with root package name */
        public final String[][] f2515a;

        /* renamed from: b  reason: collision with root package name */
        public final int[][] f2516b;

        /* renamed from: c  reason: collision with root package name */
        public final int[][] f2517c;

        public j(int i10) {
            this.f2515a = new String[i10][];
            this.f2516b = new int[i10][];
            this.f2517c = new int[i10][];
        }

        public void a(int i10, String[] strArr, int[] iArr, int[] iArr2) {
            this.f2515a[i10] = strArr;
            this.f2516b[i10] = iArr;
            this.f2517c[i10] = iArr2;
        }
    }

    private static class k implements v, l<LiveData<?>> {

        /* renamed from: a  reason: collision with root package name */
        final o<LiveData<?>> f2518a;

        /* renamed from: b  reason: collision with root package name */
        androidx.lifecycle.o f2519b;

        public k(ViewDataBinding viewDataBinding, int i10) {
            this.f2518a = new o<>(viewDataBinding, i10, this);
        }

        /* renamed from: c */
        public void b(LiveData<?> liveData) {
            androidx.lifecycle.o oVar = this.f2519b;
            if (oVar != null) {
                liveData.f(oVar, this);
            }
        }

        public void d(androidx.lifecycle.o oVar) {
            LiveData b10 = this.f2518a.b();
            if (b10 != null) {
                if (this.f2519b != null) {
                    b10.k(this);
                }
                if (oVar != null) {
                    b10.f(oVar, this);
                }
            }
            this.f2519b = oVar;
        }

        public o<LiveData<?>> e() {
            return this.f2518a;
        }

        /* renamed from: f */
        public void a(LiveData<?> liveData) {
            liveData.k(this);
        }

        public void onChanged(Object obj) {
            ViewDataBinding a10 = this.f2518a.a();
            if (a10 != null) {
                o<LiveData<?>> oVar = this.f2518a;
                a10.handleFieldChange(oVar.f2523b, oVar.b(), 0);
            }
        }
    }

    private interface l<T> {
        void a(T t10);

        void b(T t10);

        void d(androidx.lifecycle.o oVar);
    }

    protected static abstract class m extends h.a implements g {

        /* renamed from: a  reason: collision with root package name */
        final int f2520a;

        public void e(h hVar, int i10) {
            if (i10 == this.f2520a || i10 == 0) {
                c();
            }
        }
    }

    private static class n extends j.a implements l<j> {

        /* renamed from: a  reason: collision with root package name */
        final o<j> f2521a;

        public n(ViewDataBinding viewDataBinding, int i10) {
            this.f2521a = new o<>(viewDataBinding, i10, this);
        }

        /* renamed from: c */
        public void b(j jVar) {
            jVar.p(this);
        }

        public void d(androidx.lifecycle.o oVar) {
        }

        public o<j> e() {
            return this.f2521a;
        }

        /* renamed from: f */
        public void a(j jVar) {
            jVar.j(this);
        }
    }

    private static class o<T> extends WeakReference<ViewDataBinding> {

        /* renamed from: a  reason: collision with root package name */
        private final l<T> f2522a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f2523b;

        /* renamed from: c  reason: collision with root package name */
        private T f2524c;

        public o(ViewDataBinding viewDataBinding, int i10, l<T> lVar) {
            super(viewDataBinding, ViewDataBinding.sReferenceQueue);
            this.f2523b = i10;
            this.f2522a = lVar;
        }

        /* access modifiers changed from: protected */
        public ViewDataBinding a() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) get();
            if (viewDataBinding == null) {
                e();
            }
            return viewDataBinding;
        }

        public T b() {
            return this.f2524c;
        }

        public void c(androidx.lifecycle.o oVar) {
            this.f2522a.d(oVar);
        }

        public void d(T t10) {
            e();
            this.f2524c = t10;
            if (t10 != null) {
                this.f2522a.b(t10);
            }
        }

        public boolean e() {
            boolean z10;
            T t10 = this.f2524c;
            if (t10 != null) {
                this.f2522a.a(t10);
                z10 = true;
            } else {
                z10 = false;
            }
            this.f2524c = null;
            return z10;
        }
    }

    private static class p extends k.a implements l<k> {

        /* renamed from: a  reason: collision with root package name */
        final o<k> f2525a;

        public p(ViewDataBinding viewDataBinding, int i10) {
            this.f2525a = new o<>(viewDataBinding, i10, this);
        }

        /* renamed from: c */
        public void b(k kVar) {
            kVar.a(this);
        }

        public void d(androidx.lifecycle.o oVar) {
        }

        public o<k> e() {
            return this.f2525a;
        }

        /* renamed from: f */
        public void a(k kVar) {
            kVar.b(this);
        }
    }

    private static class q extends h.a implements l<h> {

        /* renamed from: a  reason: collision with root package name */
        final o<h> f2526a;

        public q(ViewDataBinding viewDataBinding, int i10) {
            this.f2526a = new o<>(viewDataBinding, i10, this);
        }

        public void d(androidx.lifecycle.o oVar) {
        }

        public void e(h hVar, int i10) {
            ViewDataBinding a10 = this.f2526a.a();
            if (a10 != null && this.f2526a.b() == hVar) {
                a10.handleFieldChange(this.f2526a.f2523b, hVar, i10);
            }
        }

        /* renamed from: f */
        public void b(h hVar) {
            hVar.addOnPropertyChangedCallback(this);
        }

        public o<h> g() {
            return this.f2526a;
        }

        /* renamed from: h */
        public void a(h hVar) {
            hVar.removeOnPropertyChangedCallback(this);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        SDK_INT = i10;
        USE_CHOREOGRAPHER = i10 >= 16;
        ROOT_REATTACHED_LISTENER = i10 < 19 ? null : new f();
    }

    protected ViewDataBinding(e eVar, View view, int i10) {
        this.mRebindRunnable = new g();
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = eVar;
        this.mLocalFieldObservers = new o[i10];
        this.mRoot = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        } else if (USE_CHOREOGRAPHER) {
            this.mChoreographer = Choreographer.getInstance();
            this.mFrameCallback = new h();
        } else {
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
        }
    }

    protected ViewDataBinding(Object obj, View view, int i10) {
        this(checkAndCastToBindingComponent(obj), view, i10);
    }

    protected static ViewDataBinding bind(Object obj, View view, int i10) {
        return f.a(checkAndCastToBindingComponent(obj), view, i10);
    }

    private static e checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof e) {
            return (e) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
        } else if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            c<l, ViewDataBinding, Void> cVar = this.mRebindCallbacks;
            if (cVar != null) {
                cVar.g(this, 1, null);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.g(this, 2, null);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                c<l, ViewDataBinding, Void> cVar2 = this.mRebindCallbacks;
                if (cVar2 != null) {
                    cVar2.g(this, 3, null);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    protected static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findIncludeIndex(String str, int i10, j jVar, int i11) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = jVar.f2515a[i11];
        int length = strArr.length;
        while (i10 < length) {
            if (TextUtils.equals(subSequence, strArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private static int findLastMatching(ViewGroup viewGroup, int i10) {
        String str = (String) viewGroup.getChildAt(i10).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i11 = i10 + 1; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i10;
                }
                if (isNumeric(str2, length)) {
                    i10 = i11;
                }
            }
        }
        return i10;
    }

    static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(c1.a.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    protected static int getColorFromResource(View view, int i10) {
        return Build.VERSION.SDK_INT >= 23 ? view.getContext().getColor(i10) : view.getResources().getColor(i10);
    }

    protected static ColorStateList getColorStateListFromResource(View view, int i10) {
        return Build.VERSION.SDK_INT >= 23 ? view.getContext().getColorStateList(i10) : view.getResources().getColorStateList(i10);
    }

    protected static Drawable getDrawableFromResource(View view, int i10) {
        return Build.VERSION.SDK_INT >= 21 ? view.getContext().getDrawable(i10) : view.getResources().getDrawable(i10);
    }

    protected static <K, T> T getFrom(Map<K, T> map, K k10) {
        if (map == null) {
            return null;
        }
        return map.get(k10);
    }

    protected static byte getFromArray(byte[] bArr, int i10) {
        if (bArr == null || i10 < 0 || i10 >= bArr.length) {
            return 0;
        }
        return bArr[i10];
    }

    protected static char getFromArray(char[] cArr, int i10) {
        if (cArr == null || i10 < 0 || i10 >= cArr.length) {
            return 0;
        }
        return cArr[i10];
    }

    protected static double getFromArray(double[] dArr, int i10) {
        if (dArr == null || i10 < 0 || i10 >= dArr.length) {
            return 0.0d;
        }
        return dArr[i10];
    }

    protected static float getFromArray(float[] fArr, int i10) {
        if (fArr == null || i10 < 0 || i10 >= fArr.length) {
            return 0.0f;
        }
        return fArr[i10];
    }

    protected static int getFromArray(int[] iArr, int i10) {
        if (iArr == null || i10 < 0 || i10 >= iArr.length) {
            return 0;
        }
        return iArr[i10];
    }

    protected static long getFromArray(long[] jArr, int i10) {
        if (jArr == null || i10 < 0 || i10 >= jArr.length) {
            return 0;
        }
        return jArr[i10];
    }

    protected static <T> T getFromArray(T[] tArr, int i10) {
        if (tArr == null || i10 < 0 || i10 >= tArr.length) {
            return null;
        }
        return tArr[i10];
    }

    protected static short getFromArray(short[] sArr, int i10) {
        if (sArr == null || i10 < 0 || i10 >= sArr.length) {
            return 0;
        }
        return sArr[i10];
    }

    protected static boolean getFromArray(boolean[] zArr, int i10) {
        if (zArr == null || i10 < 0 || i10 >= zArr.length) {
            return false;
        }
        return zArr[i10];
    }

    protected static int getFromList(SparseIntArray sparseIntArray, int i10) {
        if (sparseIntArray == null || i10 < 0) {
            return 0;
        }
        return sparseIntArray.get(i10);
    }

    @TargetApi(18)
    protected static long getFromList(SparseLongArray sparseLongArray, int i10) {
        if (sparseLongArray == null || i10 < 0) {
            return 0;
        }
        return sparseLongArray.get(i10);
    }

    @TargetApi(16)
    protected static <T> T getFromList(LongSparseArray<T> longSparseArray, int i10) {
        if (longSparseArray == null || i10 < 0) {
            return null;
        }
        return longSparseArray.get((long) i10);
    }

    protected static <T> T getFromList(SparseArray<T> sparseArray, int i10) {
        if (sparseArray == null || i10 < 0) {
            return null;
        }
        return sparseArray.get(i10);
    }

    protected static <T> T getFromList(c0.d<T> dVar, int i10) {
        if (dVar == null || i10 < 0) {
            return null;
        }
        return dVar.i((long) i10);
    }

    protected static <T> T getFromList(List<T> list, int i10) {
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }

    protected static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i10) {
        if (sparseBooleanArray == null || i10 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i10);
    }

    /* access modifiers changed from: private */
    public void handleFieldChange(int i10, Object obj, int i11) {
        if (!this.mInLiveDataRegisterObserver && onFieldChange(i10, obj, i11)) {
            requestRebind();
        }
    }

    protected static <T extends ViewDataBinding> T inflateInternal(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10, Object obj) {
        return f.f(layoutInflater, i10, viewGroup, z10, checkAndCastToBindingComponent(obj));
    }

    private static boolean isNumeric(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return false;
        }
        while (i10 < length) {
            if (!Character.isDigit(str.charAt(i10))) {
                return false;
            }
            i10++;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void mapBindings(androidx.databinding.e r17, android.view.View r18, java.lang.Object[] r19, androidx.databinding.ViewDataBinding.j r20, android.util.SparseIntArray r21, boolean r22) {
        /*
            r6 = r17
            r0 = r18
            r7 = r20
            r8 = r21
            androidx.databinding.ViewDataBinding r1 = getBinding(r18)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r1 = r18.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x001a
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            java.lang.String r9 = "layout"
            r2 = -1
            r11 = 1
            if (r22 == 0) goto L_0x004b
            if (r1 == 0) goto L_0x004b
            boolean r3 = r1.startsWith(r9)
            if (r3 == 0) goto L_0x004b
            r3 = 95
            int r3 = r1.lastIndexOf(r3)
            if (r3 <= 0) goto L_0x0047
            int r3 = r3 + r11
            boolean r4 = isNumeric(r1, r3)
            if (r4 == 0) goto L_0x0047
            int r1 = parseTagInt(r1, r3)
            r3 = r19[r1]
            if (r3 != 0) goto L_0x0042
            r19[r1] = r0
        L_0x0042:
            if (r7 != 0) goto L_0x0045
            r1 = r2
        L_0x0045:
            r3 = r11
            goto L_0x0049
        L_0x0047:
            r1 = r2
            r3 = 0
        L_0x0049:
            r12 = r1
            goto L_0x0069
        L_0x004b:
            if (r1 == 0) goto L_0x0067
            java.lang.String r3 = "binding_"
            boolean r3 = r1.startsWith(r3)
            if (r3 == 0) goto L_0x0067
            int r3 = BINDING_NUMBER_START
            int r1 = parseTagInt(r1, r3)
            r3 = r19[r1]
            if (r3 != 0) goto L_0x0061
            r19[r1] = r0
        L_0x0061:
            if (r7 != 0) goto L_0x0064
            r1 = r2
        L_0x0064:
            r12 = r1
            r3 = r11
            goto L_0x0069
        L_0x0067:
            r12 = r2
            r3 = 0
        L_0x0069:
            if (r3 != 0) goto L_0x007f
            int r1 = r18.getId()
            if (r1 <= 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            int r1 = r8.get(r1, r2)
            if (r1 < 0) goto L_0x007f
            r2 = r19[r1]
            if (r2 != 0) goto L_0x007f
            r19[r1] = r0
        L_0x007f:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0119
            r13 = r0
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
            int r14 = r13.getChildCount()
            r0 = 0
            r1 = 0
        L_0x008c:
            if (r0 >= r14) goto L_0x0119
            android.view.View r2 = r13.getChildAt(r0)
            if (r12 < 0) goto L_0x00fc
            java.lang.Object r3 = r2.getTag()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x00fc
            java.lang.Object r3 = r2.getTag()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "_0"
            boolean r4 = r3.endsWith(r4)
            if (r4 == 0) goto L_0x00fc
            boolean r4 = r3.startsWith(r9)
            if (r4 == 0) goto L_0x00fc
            r4 = 47
            int r4 = r3.indexOf(r4)
            if (r4 <= 0) goto L_0x00fc
            int r3 = findIncludeIndex(r3, r1, r7, r12)
            if (r3 < 0) goto L_0x00fc
            int r1 = r3 + 1
            int[][] r4 = r7.f2516b
            r4 = r4[r12]
            r4 = r4[r3]
            int[][] r5 = r7.f2517c
            r5 = r5[r12]
            r3 = r5[r3]
            int r5 = findLastMatching(r13, r0)
            if (r5 != r0) goto L_0x00dc
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.f.a(r6, r2, r3)
            r19[r4] = r3
            r10 = r0
            r0 = r11
            r11 = r1
            goto L_0x00ff
        L_0x00dc:
            int r5 = r5 - r0
            int r5 = r5 + r11
            android.view.View[] r15 = new android.view.View[r5]
            r10 = 0
        L_0x00e1:
            if (r10 >= r5) goto L_0x00ef
            int r11 = r0 + r10
            android.view.View r11 = r13.getChildAt(r11)
            r15[r10] = r11
            int r10 = r10 + 1
            r11 = 1
            goto L_0x00e1
        L_0x00ef:
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.f.b(r6, r15, r3)
            r19[r4] = r3
            int r5 = r5 + -1
            int r0 = r0 + r5
            r10 = r0
            r11 = r1
            r0 = 1
            goto L_0x00ff
        L_0x00fc:
            r10 = r0
            r11 = r1
            r0 = 0
        L_0x00ff:
            if (r0 != 0) goto L_0x010e
            r5 = 0
            r0 = r17
            r1 = r2
            r2 = r19
            r3 = r20
            r4 = r21
            mapBindings(r0, r1, r2, r3, r4, r5)
        L_0x010e:
            r0 = 1
            int r1 = r10 + 1
            r16 = r11
            r11 = r0
            r0 = r1
            r1 = r16
            goto L_0x008c
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mapBindings(androidx.databinding.e, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$j, android.util.SparseIntArray, boolean):void");
    }

    protected static Object[] mapBindings(e eVar, View view, int i10, j jVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i10];
        mapBindings(eVar, view, objArr, jVar, sparseIntArray, true);
        return objArr;
    }

    protected static Object[] mapBindings(e eVar, View[] viewArr, int i10, j jVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i10];
        for (View mapBindings : viewArr) {
            mapBindings(eVar, mapBindings, objArr, jVar, sparseIntArray, true);
        }
        return objArr;
    }

    protected static byte parse(String str, byte b10) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b10;
        }
    }

    protected static char parse(String str, char c10) {
        return (str == null || str.isEmpty()) ? c10 : str.charAt(0);
    }

    protected static double parse(String str, double d10) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d10;
        }
    }

    protected static float parse(String str, float f10) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f10;
        }
    }

    protected static int parse(String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    protected static long parse(String str, long j10) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    protected static short parse(String str, short s10) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s10;
        }
    }

    protected static boolean parse(String str, boolean z10) {
        return str == null ? z10 : Boolean.parseBoolean(str);
    }

    private static int parseTagInt(String str, int i10) {
        int length = str.length();
        int i11 = 0;
        while (i10 < length) {
            i11 = (i11 * 10) + (str.charAt(i10) - '0');
            i10++;
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = sReferenceQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof o) {
                ((o) poll).e();
            }
        }
    }

    protected static byte safeUnbox(Byte b10) {
        if (b10 == null) {
            return 0;
        }
        return b10.byteValue();
    }

    protected static char safeUnbox(Character ch) {
        if (ch == null) {
            return 0;
        }
        return ch.charValue();
    }

    protected static double safeUnbox(Double d10) {
        if (d10 == null) {
            return 0.0d;
        }
        return d10.doubleValue();
    }

    protected static float safeUnbox(Float f10) {
        if (f10 == null) {
            return 0.0f;
        }
        return f10.floatValue();
    }

    protected static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    protected static long safeUnbox(Long l10) {
        if (l10 == null) {
            return 0;
        }
        return l10.longValue();
    }

    protected static short safeUnbox(Short sh) {
        if (sh == null) {
            return 0;
        }
        return sh.shortValue();
    }

    protected static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    protected static void setBindingInverseListener(ViewDataBinding viewDataBinding, g gVar, m mVar) {
        if (gVar != mVar) {
            if (gVar != null) {
                viewDataBinding.removeOnPropertyChangedCallback((m) gVar);
            }
            if (mVar != null) {
                viewDataBinding.addOnPropertyChangedCallback(mVar);
            }
        }
    }

    @TargetApi(16)
    protected static <T> void setTo(LongSparseArray<T> longSparseArray, int i10, T t10) {
        if (longSparseArray != null && i10 >= 0 && i10 < longSparseArray.size()) {
            longSparseArray.put((long) i10, t10);
        }
    }

    protected static <T> void setTo(SparseArray<T> sparseArray, int i10, T t10) {
        if (sparseArray != null && i10 >= 0 && i10 < sparseArray.size()) {
            sparseArray.put(i10, t10);
        }
    }

    protected static void setTo(SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        if (sparseBooleanArray != null && i10 >= 0 && i10 < sparseBooleanArray.size()) {
            sparseBooleanArray.put(i10, z10);
        }
    }

    protected static void setTo(SparseIntArray sparseIntArray, int i10, int i11) {
        if (sparseIntArray != null && i10 >= 0 && i10 < sparseIntArray.size()) {
            sparseIntArray.put(i10, i11);
        }
    }

    @TargetApi(18)
    protected static void setTo(SparseLongArray sparseLongArray, int i10, long j10) {
        if (sparseLongArray != null && i10 >= 0 && i10 < sparseLongArray.size()) {
            sparseLongArray.put(i10, j10);
        }
    }

    protected static <T> void setTo(c0.d<T> dVar, int i10, T t10) {
        if (dVar != null && i10 >= 0 && i10 < dVar.q()) {
            dVar.n((long) i10, t10);
        }
    }

    protected static <T> void setTo(List<T> list, int i10, T t10) {
        if (list != null && i10 >= 0 && i10 < list.size()) {
            list.set(i10, t10);
        }
    }

    protected static <K, T> void setTo(Map<K, T> map, K k10, T t10) {
        if (map != null) {
            map.put(k10, t10);
        }
    }

    protected static void setTo(byte[] bArr, int i10, byte b10) {
        if (bArr != null && i10 >= 0 && i10 < bArr.length) {
            bArr[i10] = b10;
        }
    }

    protected static void setTo(char[] cArr, int i10, char c10) {
        if (cArr != null && i10 >= 0 && i10 < cArr.length) {
            cArr[i10] = c10;
        }
    }

    protected static void setTo(double[] dArr, int i10, double d10) {
        if (dArr != null && i10 >= 0 && i10 < dArr.length) {
            dArr[i10] = d10;
        }
    }

    protected static void setTo(float[] fArr, int i10, float f10) {
        if (fArr != null && i10 >= 0 && i10 < fArr.length) {
            fArr[i10] = f10;
        }
    }

    protected static void setTo(int[] iArr, int i10, int i11) {
        if (iArr != null && i10 >= 0 && i10 < iArr.length) {
            iArr[i10] = i11;
        }
    }

    protected static void setTo(long[] jArr, int i10, long j10) {
        if (jArr != null && i10 >= 0 && i10 < jArr.length) {
            jArr[i10] = j10;
        }
    }

    protected static <T> void setTo(T[] tArr, int i10, T t10) {
        if (tArr != null && i10 >= 0 && i10 < tArr.length) {
            tArr[i10] = t10;
        }
    }

    protected static void setTo(short[] sArr, int i10, short s10) {
        if (sArr != null && i10 >= 0 && i10 < sArr.length) {
            sArr[i10] = s10;
        }
    }

    protected static void setTo(boolean[] zArr, int i10, boolean z10) {
        if (zArr != null && i10 >= 0 && i10 < zArr.length) {
            zArr[i10] = z10;
        }
    }

    private boolean updateRegistration(int i10, Object obj, i iVar) {
        if (obj == null) {
            return unregisterFrom(i10);
        }
        o oVar = this.mLocalFieldObservers[i10];
        if (oVar == null) {
            registerTo(i10, obj, iVar);
            return true;
        } else if (oVar.b() == obj) {
            return false;
        } else {
            unregisterFrom(i10);
            registerTo(i10, obj, iVar);
            return true;
        }
    }

    public void addOnRebindCallback(l lVar) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new c<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.a(lVar);
    }

    /* access modifiers changed from: protected */
    public void ensureBindingComponentIsNotNull(Class<?> cls) {
        if (this.mBindingComponent == null) {
            throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void executeBindings();

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    /* access modifiers changed from: package-private */
    public void forceExecuteBindings() {
        executeBindings();
    }

    public androidx.lifecycle.o getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    /* access modifiers changed from: protected */
    public Object getObservedField(int i10) {
        o oVar = this.mLocalFieldObservers[i10];
        if (oVar == null) {
            return null;
        }
        return oVar.b();
    }

    public View getRoot() {
        return this.mRoot;
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    /* access modifiers changed from: protected */
    public abstract boolean onFieldChange(int i10, Object obj, int i11);

    /* access modifiers changed from: protected */
    public void registerTo(int i10, Object obj, i iVar) {
        if (obj != null) {
            o oVar = this.mLocalFieldObservers[i10];
            if (oVar == null) {
                oVar = iVar.a(this, i10);
                this.mLocalFieldObservers[i10] = oVar;
                androidx.lifecycle.o oVar2 = this.mLifecycleOwner;
                if (oVar2 != null) {
                    oVar.c(oVar2);
                }
            }
            oVar.d(obj);
        }
    }

    public void removeOnRebindCallback(l lVar) {
        c<l, ViewDataBinding, Void> cVar = this.mRebindCallbacks;
        if (cVar != null) {
            cVar.n(lVar);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (USE_CHOREOGRAPHER == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r2.mChoreographer.postFrameCallback(r2.mFrameCallback);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r2.mUIThreadHandler.post(r2.mRebindRunnable);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void requestRebind() {
        /*
            r2 = this;
            androidx.databinding.ViewDataBinding r0 = r2.mContainingBinding
            if (r0 == 0) goto L_0x0008
            r0.requestRebind()
            goto L_0x003b
        L_0x0008:
            androidx.lifecycle.o r0 = r2.mLifecycleOwner
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.h r0 = r0.getLifecycle()
            androidx.lifecycle.h$c r0 = r0.b()
            androidx.lifecycle.h$c r1 = androidx.lifecycle.h.c.STARTED
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r2)
            boolean r0 = r2.mPendingRebind     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            return
        L_0x0024:
            r0 = 1
            r2.mPendingRebind = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            boolean r0 = USE_CHOREOGRAPHER
            if (r0 == 0) goto L_0x0034
            android.view.Choreographer r0 = r2.mChoreographer
            android.view.Choreographer$FrameCallback r1 = r2.mFrameCallback
            r0.postFrameCallback(r1)
            goto L_0x003b
        L_0x0034:
            android.os.Handler r0 = r2.mUIThreadHandler
            java.lang.Runnable r1 = r2.mRebindRunnable
            r0.post(r1)
        L_0x003b:
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.requestRebind():void");
    }

    /* access modifiers changed from: protected */
    public void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    public void setLifecycleOwner(androidx.lifecycle.o oVar) {
        androidx.lifecycle.o oVar2 = this.mLifecycleOwner;
        if (oVar2 != oVar) {
            if (oVar2 != null) {
                oVar2.getLifecycle().c(this.mOnStartListener);
            }
            this.mLifecycleOwner = oVar;
            if (oVar != null) {
                if (this.mOnStartListener == null) {
                    this.mOnStartListener = new OnStartListener(this, (a) null);
                }
                oVar.getLifecycle().a(this.mOnStartListener);
            }
            for (o oVar3 : this.mLocalFieldObservers) {
                if (oVar3 != null) {
                    oVar3.c(oVar);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setRootTag(View view) {
        view.setTag(c1.a.dataBinding, this);
    }

    /* access modifiers changed from: protected */
    public void setRootTag(View[] viewArr) {
        for (View tag : viewArr) {
            tag.setTag(c1.a.dataBinding, this);
        }
    }

    public abstract boolean setVariable(int i10, Object obj);

    public void unbind() {
        for (o oVar : this.mLocalFieldObservers) {
            if (oVar != null) {
                oVar.e();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean unregisterFrom(int i10) {
        o oVar = this.mLocalFieldObservers[i10];
        if (oVar != null) {
            return oVar.e();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean updateLiveDataRegistration(int i10, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i10, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean updateRegistration(int i10, h hVar) {
        return updateRegistration(i10, hVar, CREATE_PROPERTY_LISTENER);
    }

    /* access modifiers changed from: protected */
    public boolean updateRegistration(int i10, j jVar) {
        return updateRegistration(i10, jVar, CREATE_LIST_LISTENER);
    }

    /* access modifiers changed from: protected */
    public boolean updateRegistration(int i10, k kVar) {
        return updateRegistration(i10, kVar, CREATE_MAP_LISTENER);
    }
}
