package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.f;
import androidx.constraintlayout.widget.h;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.zbar.Config;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class p {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final MotionLayout f1649a;

    /* renamed from: b  reason: collision with root package name */
    h f1650b = null;

    /* renamed from: c  reason: collision with root package name */
    b f1651c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1652d = false;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<b> f1653e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private b f1654f = null;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<b> f1655g = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<c> f1656h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, Integer> f1657i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private SparseIntArray f1658j = new SparseIntArray();

    /* renamed from: k  reason: collision with root package name */
    private boolean f1659k = false;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f1660l = 400;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f1661m = 0;

    /* renamed from: n  reason: collision with root package name */
    private MotionEvent f1662n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1663o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1664p = false;

    /* renamed from: q  reason: collision with root package name */
    private MotionLayout.g f1665q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1666r;

    /* renamed from: s  reason: collision with root package name */
    final t f1667s;

    /* renamed from: t  reason: collision with root package name */
    float f1668t;

    /* renamed from: u  reason: collision with root package name */
    float f1669u;

    class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f0.c f1670a;

        a(p pVar, f0.c cVar) {
            this.f1670a = cVar;
        }

        public float getInterpolation(float f10) {
            return (float) this.f1670a.a((double) f10);
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f1671a = -1;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f1672b = false;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f1673c = -1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f1674d = -1;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f1675e = 0;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f1676f = null;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f1677g = -1;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f1678h = 400;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public float f1679i = 0.0f;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public final p f1680j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public ArrayList<g> f1681k = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public q f1682l = null;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public ArrayList<a> f1683m = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public int f1684n = 0;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public boolean f1685o = false;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public int f1686p = -1;

        /* renamed from: q  reason: collision with root package name */
        private int f1687q = 0;

        /* renamed from: r  reason: collision with root package name */
        private int f1688r = 0;

        public static class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            private final b f1689a;

            /* renamed from: b  reason: collision with root package name */
            int f1690b = -1;

            /* renamed from: c  reason: collision with root package name */
            int f1691c = 17;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f1689a = bVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i10 = 0; i10 < indexCount; i10++) {
                    int index = obtainStyledAttributes.getIndex(i10);
                    if (index == f.OnClick_targetId) {
                        this.f1690b = obtainStyledAttributes.getResourceId(index, this.f1690b);
                    } else if (index == f.OnClick_clickAction) {
                        this.f1691c = obtainStyledAttributes.getInt(index, this.f1691c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i10, b bVar) {
                int i11 = this.f1690b;
                View view = motionLayout;
                if (i11 != -1) {
                    view = motionLayout.findViewById(i11);
                }
                if (view == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.f1690b);
                    return;
                }
                int c10 = bVar.f1674d;
                int a10 = bVar.f1673c;
                if (c10 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i12 = this.f1691c;
                boolean z10 = false;
                boolean z11 = ((i12 & 1) != 0 && i10 == c10) | ((i12 & 1) != 0 && i10 == c10) | ((i12 & Config.X_DENSITY) != 0 && i10 == c10) | ((i12 & 16) != 0 && i10 == a10);
                if ((i12 & RecyclerView.m.FLAG_APPEARED_IN_PRE_LAYOUT) != 0 && i10 == a10) {
                    z10 = true;
                }
                if (z11 || z10) {
                    view.setOnClickListener(this);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.f1689a;
                if (bVar2 == bVar) {
                    return true;
                }
                int a10 = bVar2.f1673c;
                int c10 = this.f1689a.f1674d;
                int i10 = motionLayout.f1439z;
                return c10 == -1 ? i10 != a10 : i10 == c10 || i10 == a10;
            }

            public void c(MotionLayout motionLayout) {
                int i10 = this.f1690b;
                if (i10 != -1) {
                    View findViewById = motionLayout.findViewById(i10);
                    if (findViewById == null) {
                        Log.e("MotionScene", " (*)  could not find id " + this.f1690b);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
            /* JADX WARNING: Removed duplicated region for block: B:56:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r8) {
                /*
                    r7 = this;
                    androidx.constraintlayout.motion.widget.p$b r8 = r7.f1689a
                    androidx.constraintlayout.motion.widget.p r8 = r8.f1680j
                    androidx.constraintlayout.motion.widget.MotionLayout r8 = r8.f1649a
                    boolean r0 = r8.s0()
                    if (r0 != 0) goto L_0x0011
                    return
                L_0x0011:
                    androidx.constraintlayout.motion.widget.p$b r0 = r7.f1689a
                    int r0 = r0.f1674d
                    r1 = -1
                    if (r0 != r1) goto L_0x004a
                    int r0 = r8.getCurrentState()
                    if (r0 != r1) goto L_0x002a
                    androidx.constraintlayout.motion.widget.p$b r0 = r7.f1689a
                    int r0 = r0.f1673c
                    r8.G0(r0)
                    return
                L_0x002a:
                    androidx.constraintlayout.motion.widget.p$b r1 = new androidx.constraintlayout.motion.widget.p$b
                    androidx.constraintlayout.motion.widget.p$b r2 = r7.f1689a
                    androidx.constraintlayout.motion.widget.p r2 = r2.f1680j
                    androidx.constraintlayout.motion.widget.p$b r3 = r7.f1689a
                    r1.<init>(r2, r3)
                    int unused = r1.f1674d = r0
                    androidx.constraintlayout.motion.widget.p$b r0 = r7.f1689a
                    int r0 = r0.f1673c
                    int unused = r1.f1673c = r0
                    r8.setTransition((androidx.constraintlayout.motion.widget.p.b) r1)
                    r8.D0()
                    return
                L_0x004a:
                    androidx.constraintlayout.motion.widget.p$b r0 = r7.f1689a
                    androidx.constraintlayout.motion.widget.p r0 = r0.f1680j
                    androidx.constraintlayout.motion.widget.p$b r0 = r0.f1651c
                    int r1 = r7.f1691c
                    r2 = r1 & 1
                    r3 = 0
                    r4 = 1
                    if (r2 != 0) goto L_0x0061
                    r2 = r1 & 256(0x100, float:3.59E-43)
                    if (r2 == 0) goto L_0x005f
                    goto L_0x0061
                L_0x005f:
                    r2 = r3
                    goto L_0x0062
                L_0x0061:
                    r2 = r4
                L_0x0062:
                    r5 = r1 & 16
                    if (r5 != 0) goto L_0x006d
                    r1 = r1 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x006b
                    goto L_0x006d
                L_0x006b:
                    r1 = r3
                    goto L_0x006e
                L_0x006d:
                    r1 = r4
                L_0x006e:
                    if (r2 == 0) goto L_0x0074
                    if (r1 == 0) goto L_0x0074
                    r5 = r4
                    goto L_0x0075
                L_0x0074:
                    r5 = r3
                L_0x0075:
                    if (r5 == 0) goto L_0x009c
                    androidx.constraintlayout.motion.widget.p$b r5 = r7.f1689a
                    androidx.constraintlayout.motion.widget.p r5 = r5.f1680j
                    androidx.constraintlayout.motion.widget.p$b r5 = r5.f1651c
                    androidx.constraintlayout.motion.widget.p$b r6 = r7.f1689a
                    if (r5 == r6) goto L_0x0086
                    r8.setTransition((androidx.constraintlayout.motion.widget.p.b) r6)
                L_0x0086:
                    int r5 = r8.getCurrentState()
                    int r6 = r8.getEndState()
                    if (r5 == r6) goto L_0x009d
                    float r5 = r8.getProgress()
                    r6 = 1056964608(0x3f000000, float:0.5)
                    int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                    if (r5 <= 0) goto L_0x009b
                    goto L_0x009d
                L_0x009b:
                    r1 = r3
                L_0x009c:
                    r3 = r2
                L_0x009d:
                    boolean r0 = r7.b(r0, r8)
                    if (r0 == 0) goto L_0x00e6
                    if (r3 == 0) goto L_0x00b3
                    int r0 = r7.f1691c
                    r0 = r0 & r4
                    if (r0 == 0) goto L_0x00b3
                    androidx.constraintlayout.motion.widget.p$b r0 = r7.f1689a
                    r8.setTransition((androidx.constraintlayout.motion.widget.p.b) r0)
                    r8.D0()
                    goto L_0x00e6
                L_0x00b3:
                    if (r1 == 0) goto L_0x00c4
                    int r0 = r7.f1691c
                    r0 = r0 & 16
                    if (r0 == 0) goto L_0x00c4
                    androidx.constraintlayout.motion.widget.p$b r0 = r7.f1689a
                    r8.setTransition((androidx.constraintlayout.motion.widget.p.b) r0)
                    r8.F0()
                    goto L_0x00e6
                L_0x00c4:
                    if (r3 == 0) goto L_0x00d7
                    int r0 = r7.f1691c
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x00d7
                    androidx.constraintlayout.motion.widget.p$b r0 = r7.f1689a
                    r8.setTransition((androidx.constraintlayout.motion.widget.p.b) r0)
                    r0 = 1065353216(0x3f800000, float:1.0)
                L_0x00d3:
                    r8.setProgress(r0)
                    goto L_0x00e6
                L_0x00d7:
                    if (r1 == 0) goto L_0x00e6
                    int r0 = r7.f1691c
                    r0 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r0 == 0) goto L_0x00e6
                    androidx.constraintlayout.motion.widget.p$b r0 = r7.f1689a
                    r8.setTransition((androidx.constraintlayout.motion.widget.p.b) r0)
                    r0 = 0
                    goto L_0x00d3
                L_0x00e6:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.p.b.a.onClick(android.view.View):void");
            }
        }

        public b(int i10, p pVar, int i11, int i12) {
            this.f1671a = i10;
            this.f1680j = pVar;
            this.f1674d = i11;
            this.f1673c = i12;
            this.f1678h = pVar.f1660l;
            this.f1687q = pVar.f1661m;
        }

        b(p pVar, Context context, XmlPullParser xmlPullParser) {
            this.f1678h = pVar.f1660l;
            this.f1687q = pVar.f1661m;
            this.f1680j = pVar;
            w(pVar, context, Xml.asAttributeSet(xmlPullParser));
        }

        b(p pVar, b bVar) {
            this.f1680j = pVar;
            this.f1678h = pVar.f1660l;
            if (bVar != null) {
                this.f1686p = bVar.f1686p;
                this.f1675e = bVar.f1675e;
                this.f1676f = bVar.f1676f;
                this.f1677g = bVar.f1677g;
                this.f1678h = bVar.f1678h;
                this.f1681k = bVar.f1681k;
                this.f1679i = bVar.f1679i;
                this.f1687q = bVar.f1687q;
            }
        }

        private void v(p pVar, Context context, TypedArray typedArray) {
            c cVar;
            SparseArray b10;
            int i10;
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                if (index == f.Transition_constraintSetEnd) {
                    this.f1673c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1673c);
                    if ("layout".equals(resourceTypeName)) {
                        cVar = new c();
                        cVar.D(context, this.f1673c);
                        b10 = pVar.f1656h;
                        i10 = this.f1673c;
                    } else {
                        if ("xml".equals(resourceTypeName)) {
                            this.f1673c = pVar.M(context, this.f1673c);
                        }
                    }
                } else {
                    if (index == f.Transition_constraintSetStart) {
                        this.f1674d = typedArray.getResourceId(index, this.f1674d);
                        String resourceTypeName2 = context.getResources().getResourceTypeName(this.f1674d);
                        if ("layout".equals(resourceTypeName2)) {
                            cVar = new c();
                            cVar.D(context, this.f1674d);
                            b10 = pVar.f1656h;
                            i10 = this.f1674d;
                        } else if ("xml".equals(resourceTypeName2)) {
                            this.f1674d = pVar.M(context, this.f1674d);
                        }
                    } else if (index == f.Transition_motionInterpolator) {
                        int i12 = typedArray.peekValue(index).type;
                        if (i12 == 1) {
                            int resourceId = typedArray.getResourceId(index, -1);
                            this.f1677g = resourceId;
                            if (resourceId == -1) {
                            }
                        } else if (i12 == 3) {
                            String string = typedArray.getString(index);
                            this.f1676f = string;
                            if (string != null) {
                                if (string.indexOf("/") > 0) {
                                    this.f1677g = typedArray.getResourceId(index, -1);
                                } else {
                                    this.f1675e = -1;
                                }
                            }
                        } else {
                            this.f1675e = typedArray.getInteger(index, this.f1675e);
                        }
                        this.f1675e = -2;
                    } else if (index == f.Transition_duration) {
                        int i13 = typedArray.getInt(index, this.f1678h);
                        this.f1678h = i13;
                        if (i13 < 8) {
                            this.f1678h = 8;
                        }
                    } else if (index == f.Transition_staggered) {
                        this.f1679i = typedArray.getFloat(index, this.f1679i);
                    } else if (index == f.Transition_autoTransition) {
                        this.f1684n = typedArray.getInteger(index, this.f1684n);
                    } else if (index == f.Transition_android_id) {
                        this.f1671a = typedArray.getResourceId(index, this.f1671a);
                    } else if (index == f.Transition_transitionDisable) {
                        this.f1685o = typedArray.getBoolean(index, this.f1685o);
                    } else if (index == f.Transition_pathMotionArc) {
                        this.f1686p = typedArray.getInteger(index, -1);
                    } else if (index == f.Transition_layoutDuringTransition) {
                        this.f1687q = typedArray.getInteger(index, 0);
                    } else if (index == f.Transition_transitionFlags) {
                        this.f1688r = typedArray.getInteger(index, 0);
                    }
                }
                b10.append(i10, cVar);
            }
            if (this.f1674d == -1) {
                this.f1672b = true;
            }
        }

        private void w(p pVar, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.Transition);
            v(pVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int A() {
            return this.f1674d;
        }

        public q B() {
            return this.f1682l;
        }

        public boolean C() {
            return !this.f1685o;
        }

        public boolean D(int i10) {
            return (i10 & this.f1688r) != 0;
        }

        public void E(int i10) {
            this.f1678h = Math.max(i10, 8);
        }

        public void F(boolean z10) {
            this.f1685o = !z10;
        }

        public void G(int i10, String str, int i11) {
            this.f1675e = i10;
            this.f1676f = str;
            this.f1677g = i11;
        }

        public void H(int i10) {
            q B = B();
            if (B != null) {
                B.y(i10);
            }
        }

        public void I(int i10) {
            this.f1686p = i10;
        }

        public void t(g gVar) {
            this.f1681k.add(gVar);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.f1683m.add(new a(context, this, xmlPullParser));
        }

        public int x() {
            return this.f1684n;
        }

        public int y() {
            return this.f1673c;
        }

        public int z() {
            return this.f1687q;
        }
    }

    p(Context context, MotionLayout motionLayout, int i10) {
        this.f1649a = motionLayout;
        this.f1667s = new t(motionLayout);
        K(context, i10);
        SparseArray<c> sparseArray = this.f1656h;
        int i11 = e.motion_base;
        sparseArray.put(i11, new c());
        this.f1657i.put("motion_base", Integer.valueOf(i11));
    }

    private boolean I(int i10) {
        int i11 = this.f1658j.get(i10);
        int size = this.f1658j.size();
        while (i11 > 0) {
            if (i11 == i10) {
                return true;
            }
            int i12 = size - 1;
            if (size < 0) {
                return true;
            }
            i11 = this.f1658j.get(i11);
            size = i12;
        }
        return false;
    }

    private boolean J() {
        return this.f1665q != null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void K(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r10)
            r1 = 0
            int r2 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x000d:
            r3 = 1
            if (r2 == r3) goto L_0x0174
            if (r2 == 0) goto L_0x0162
            r4 = 2
            if (r2 == r4) goto L_0x0017
            goto L_0x0165
        L_0x0017:
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            boolean r5 = r8.f1659k     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r5 == 0) goto L_0x0035
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r7 = "parsing = "
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r6.append(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r6 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r5.println(r6)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x0035:
            int r5 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r6 = "MotionScene"
            r7 = -1
            switch(r5) {
                case -1349929691: goto L_0x009a;
                case -1239391468: goto L_0x008f;
                case -687739768: goto L_0x0085;
                case 61998586: goto L_0x007a;
                case 269306229: goto L_0x0071;
                case 312750793: goto L_0x0067;
                case 327855227: goto L_0x005d;
                case 793277014: goto L_0x0055;
                case 1382829617: goto L_0x004b;
                case 1942574248: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x00a4
        L_0x0041:
            java.lang.String r3 = "include"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 6
            goto L_0x00a5
        L_0x004b:
            java.lang.String r3 = "StateSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 4
            goto L_0x00a5
        L_0x0055:
            boolean r2 = r2.equals(r6)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 0
            goto L_0x00a5
        L_0x005d:
            java.lang.String r3 = "OnSwipe"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = r4
            goto L_0x00a5
        L_0x0067:
            java.lang.String r3 = "OnClick"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 3
            goto L_0x00a5
        L_0x0071:
            java.lang.String r4 = "Transition"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x007a:
            java.lang.String r3 = "ViewTransition"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 9
            goto L_0x00a5
        L_0x0085:
            java.lang.String r3 = "Include"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 7
            goto L_0x00a5
        L_0x008f:
            java.lang.String r3 = "KeyFrameSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 8
            goto L_0x00a5
        L_0x009a:
            java.lang.String r3 = "ConstraintSet"
            boolean r2 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r2 == 0) goto L_0x00a4
            r3 = 5
            goto L_0x00a5
        L_0x00a4:
            r3 = r7
        L_0x00a5:
            switch(r3) {
                case 0: goto L_0x015e;
                case 1: goto L_0x011c;
                case 2: goto L_0x00e0;
                case 3: goto L_0x00d9;
                case 4: goto L_0x00d0;
                case 5: goto L_0x00cb;
                case 6: goto L_0x00c6;
                case 7: goto L_0x00c6;
                case 8: goto L_0x00b6;
                case 9: goto L_0x00aa;
                default: goto L_0x00a8;
            }     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x00a8:
            goto L_0x0165
        L_0x00aa:
            androidx.constraintlayout.motion.widget.s r2 = new androidx.constraintlayout.motion.widget.s     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.t r3 = r8.f1667s     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r3.a(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00b6:
            androidx.constraintlayout.motion.widget.g r2 = new androidx.constraintlayout.motion.widget.g     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 == 0) goto L_0x0165
            java.util.ArrayList r3 = r1.f1681k     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r3.add(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00c6:
            r8.N(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00cb:
            r8.L(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00d0:
            androidx.constraintlayout.widget.h r2 = new androidx.constraintlayout.widget.h     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r8.f1650b = r2     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00d9:
            if (r1 == 0) goto L_0x0165
            r1.u(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x00e0:
            if (r1 != 0) goto L_0x010f
            android.content.res.Resources r2 = r9.getResources()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r2 = r2.getResourceEntryName(r10)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            int r3 = r0.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r5 = " OnSwipe ("
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r2 = ".xml:"
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r2 = ")"
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            java.lang.String r2 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            android.util.Log.v(r6, r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x010f:
            if (r1 == 0) goto L_0x0165
            androidx.constraintlayout.motion.widget.q r2 = new androidx.constraintlayout.motion.widget.q     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r8.f1649a     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r9, r3, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.q unused = r1.f1682l = r2     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x011c:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p$b> r1 = r8.f1653e     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.p$b r2 = new androidx.constraintlayout.motion.widget.p$b     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r2.<init>(r8, r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.p$b r1 = r8.f1651c     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 != 0) goto L_0x0143
            boolean r1 = r2.f1672b     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 != 0) goto L_0x0143
            r8.f1651c = r2     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.q r1 = r2.f1682l     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 == 0) goto L_0x0143
            androidx.constraintlayout.motion.widget.p$b r1 = r8.f1651c     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            androidx.constraintlayout.motion.widget.q r1 = r1.f1682l     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            boolean r3 = r8.f1666r     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r1.x(r3)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x0143:
            boolean r1 = r2.f1672b     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 == 0) goto L_0x015c
            int r1 = r2.f1673c     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            if (r1 != r7) goto L_0x0152
            r8.f1654f = r2     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0157
        L_0x0152:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p$b> r1 = r8.f1655g     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x0157:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p$b> r1 = r8.f1653e     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            r1.remove(r2)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x015c:
            r1 = r2
            goto L_0x0165
        L_0x015e:
            r8.O(r9, r0)     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x0165
        L_0x0162:
            r0.getName()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
        L_0x0165:
            int r2 = r0.next()     // Catch:{ XmlPullParserException -> 0x0170, IOException -> 0x016b }
            goto L_0x000d
        L_0x016b:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0174
        L_0x0170:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0174:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.p.K(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int L(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.c r0 = new androidx.constraintlayout.widget.c
            r0.<init>()
            r1 = 0
            r0.R(r1)
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = r1
            r5 = r3
            r6 = r5
        L_0x0011:
            r7 = 1
            if (r4 >= r2) goto L_0x00e8
            java.lang.String r8 = r15.getAttributeName(r4)
            java.lang.String r9 = r15.getAttributeValue(r4)
            boolean r10 = r13.f1659k
            if (r10 == 0) goto L_0x0036
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "id string = "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
        L_0x0036:
            r8.hashCode()
            int r10 = r8.hashCode()
            r11 = 2
            switch(r10) {
                case -1496482599: goto L_0x0059;
                case -1153153640: goto L_0x004e;
                case 3355: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            r8 = r3
            goto L_0x0063
        L_0x0043:
            java.lang.String r10 = "id"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x004c
            goto L_0x0041
        L_0x004c:
            r8 = r11
            goto L_0x0063
        L_0x004e:
            java.lang.String r10 = "constraintRotate"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0057
            goto L_0x0041
        L_0x0057:
            r8 = r7
            goto L_0x0063
        L_0x0059:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0062
            goto L_0x0041
        L_0x0062:
            r8 = r1
        L_0x0063:
            switch(r8) {
                case 0: goto L_0x00e0;
                case 1: goto L_0x0081;
                case 2: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x00e4
        L_0x0068:
            int r5 = r13.r(r14, r9)
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r13.f1657i
            java.lang.String r8 = a0(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r7.put(r8, r9)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.a.c(r14, r5)
            r0.f2001a = r7
            goto L_0x00e4
        L_0x0081:
            int r8 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0089 }
            r0.f2003c = r8     // Catch:{ NumberFormatException -> 0x0089 }
            goto L_0x00e4
        L_0x0089:
            r9.hashCode()
            int r8 = r9.hashCode()
            r10 = 4
            r12 = 3
            switch(r8) {
                case -768416914: goto L_0x00c3;
                case 3317767: goto L_0x00b8;
                case 3387192: goto L_0x00ad;
                case 108511772: goto L_0x00a2;
                case 1954540437: goto L_0x0097;
                default: goto L_0x0095;
            }
        L_0x0095:
            r8 = r3
            goto L_0x00cd
        L_0x0097:
            java.lang.String r8 = "x_right"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00a0
            goto L_0x0095
        L_0x00a0:
            r8 = r10
            goto L_0x00cd
        L_0x00a2:
            java.lang.String r8 = "right"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00ab
            goto L_0x0095
        L_0x00ab:
            r8 = r12
            goto L_0x00cd
        L_0x00ad:
            java.lang.String r8 = "none"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00b6
            goto L_0x0095
        L_0x00b6:
            r8 = r11
            goto L_0x00cd
        L_0x00b8:
            java.lang.String r8 = "left"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00c1
            goto L_0x0095
        L_0x00c1:
            r8 = r7
            goto L_0x00cd
        L_0x00c3:
            java.lang.String r8 = "x_left"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00cc
            goto L_0x0095
        L_0x00cc:
            r8 = r1
        L_0x00cd:
            switch(r8) {
                case 0: goto L_0x00dd;
                case 1: goto L_0x00da;
                case 2: goto L_0x00d7;
                case 3: goto L_0x00d4;
                case 4: goto L_0x00d1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            goto L_0x00e4
        L_0x00d1:
            r0.f2003c = r12
            goto L_0x00e4
        L_0x00d4:
            r0.f2003c = r7
            goto L_0x00e4
        L_0x00d7:
            r0.f2003c = r1
            goto L_0x00e4
        L_0x00da:
            r0.f2003c = r11
            goto L_0x00e4
        L_0x00dd:
            r0.f2003c = r10
            goto L_0x00e4
        L_0x00e0:
            int r6 = r13.r(r14, r9)
        L_0x00e4:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x00e8:
            if (r5 == r3) goto L_0x0102
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.f1649a
            int r1 = r1.Q
            if (r1 == 0) goto L_0x00f3
            r0.S(r7)
        L_0x00f3:
            r0.E(r14, r15)
            if (r6 == r3) goto L_0x00fd
            android.util.SparseIntArray r14 = r13.f1658j
            r14.put(r5, r6)
        L_0x00fd:
            android.util.SparseArray<androidx.constraintlayout.widget.c> r14 = r13.f1656h
            r14.put(r5, r0)
        L_0x0102:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.p.L(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    /* access modifiers changed from: private */
    public int M(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return L(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
            return -1;
        } catch (IOException e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    private void N(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == f.include_constraintSet) {
                M(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void O(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == f.MotionScene_defaultDuration) {
                int i11 = obtainStyledAttributes.getInt(index, this.f1660l);
                this.f1660l = i11;
                if (i11 < 8) {
                    this.f1660l = 8;
                }
            } else if (index == f.MotionScene_layoutDuringTransition) {
                this.f1661m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void S(int i10, MotionLayout motionLayout) {
        c cVar = this.f1656h.get(i10);
        cVar.f2002b = cVar.f2001a;
        int i11 = this.f1658j.get(i10);
        if (i11 > 0) {
            S(i11, motionLayout);
            c cVar2 = this.f1656h.get(i11);
            if (cVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + a.c(this.f1649a.getContext(), i11));
                return;
            }
            cVar.f2002b += "/" + cVar2.f2002b;
            cVar.M(cVar2);
        } else {
            cVar.f2002b += "  layout";
            cVar.L(motionLayout);
        }
        cVar.h(cVar);
    }

    public static String a0(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    private int r(Context context, String str) {
        int i10;
        if (str.contains("/")) {
            i10 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f1659k) {
                System.out.println("id getMap res = " + i10);
            }
        } else {
            i10 = -1;
        }
        if (i10 != -1) {
            return i10;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.c(r3, -1, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int y(int r3) {
        /*
            r2 = this;
            androidx.constraintlayout.widget.h r0 = r2.f1650b
            if (r0 == 0) goto L_0x000c
            r1 = -1
            int r0 = r0.c(r3, r1, r1)
            if (r0 == r1) goto L_0x000c
            return r0
        L_0x000c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.p.y(int):int");
    }

    /* access modifiers changed from: package-private */
    public float A() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0.0f;
        }
        return this.f1651c.f1682l.l();
    }

    /* access modifiers changed from: package-private */
    public float B() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0.0f;
        }
        return this.f1651c.f1682l.m();
    }

    /* access modifiers changed from: package-private */
    public float C() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0.0f;
        }
        return this.f1651c.f1682l.n();
    }

    /* access modifiers changed from: package-private */
    public float D() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0.0f;
        }
        return this.f1651c.f1682l.o();
    }

    public float E() {
        b bVar = this.f1651c;
        if (bVar != null) {
            return bVar.f1679i;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int F() {
        b bVar = this.f1651c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f1674d;
    }

    public b G(int i10) {
        Iterator<b> it = this.f1653e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f1671a == i10) {
                return next;
            }
        }
        return null;
    }

    public List<b> H(int i10) {
        int y10 = y(i10);
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = this.f1653e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f1674d == y10 || next.f1673c == y10) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void P(float f10, float f11) {
        b bVar = this.f1651c;
        if (bVar != null && bVar.f1682l != null) {
            this.f1651c.f1682l.u(f10, f11);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(float f10, float f11) {
        b bVar = this.f1651c;
        if (bVar != null && bVar.f1682l != null) {
            this.f1651c.f1682l.v(f10, f11);
        }
    }

    /* access modifiers changed from: package-private */
    public void R(MotionEvent motionEvent, int i10, MotionLayout motionLayout) {
        MotionLayout.g gVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f1665q == null) {
            this.f1665q = this.f1649a.t0();
        }
        this.f1665q.c(motionEvent);
        if (i10 != -1) {
            int action = motionEvent.getAction();
            boolean z10 = false;
            if (action == 0) {
                this.f1668t = motionEvent.getRawX();
                this.f1669u = motionEvent.getRawY();
                this.f1662n = motionEvent;
                this.f1663o = false;
                if (this.f1651c.f1682l != null) {
                    RectF f10 = this.f1651c.f1682l.f(this.f1649a, rectF);
                    if (f10 == null || f10.contains(this.f1662n.getX(), this.f1662n.getY())) {
                        RectF p10 = this.f1651c.f1682l.p(this.f1649a, rectF);
                        if (p10 == null || p10.contains(this.f1662n.getX(), this.f1662n.getY())) {
                            this.f1664p = false;
                        } else {
                            this.f1664p = true;
                        }
                        this.f1651c.f1682l.w(this.f1668t, this.f1669u);
                        return;
                    }
                    this.f1662n = null;
                    this.f1663o = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.f1663o) {
                float rawY = motionEvent.getRawY() - this.f1669u;
                float rawX = motionEvent.getRawX() - this.f1668t;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.f1662n) != null) {
                    b i11 = i(i10, rawX, rawY, motionEvent2);
                    if (i11 != null) {
                        motionLayout.setTransition(i11);
                        RectF p11 = this.f1651c.f1682l.p(this.f1649a, rectF);
                        if (p11 != null && !p11.contains(this.f1662n.getX(), this.f1662n.getY())) {
                            z10 = true;
                        }
                        this.f1664p = z10;
                        this.f1651c.f1682l.z(this.f1668t, this.f1669u);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.f1663o) {
            b bVar = this.f1651c;
            if (!(bVar == null || bVar.f1682l == null || this.f1664p)) {
                this.f1651c.f1682l.s(motionEvent, this.f1665q, i10, this);
            }
            this.f1668t = motionEvent.getRawX();
            this.f1669u = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (gVar = this.f1665q) != null) {
                gVar.b();
                this.f1665q = null;
                int i12 = motionLayout.f1439z;
                if (i12 != -1) {
                    h(motionLayout, i12);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void T(MotionLayout motionLayout) {
        int i10 = 0;
        while (i10 < this.f1656h.size()) {
            int keyAt = this.f1656h.keyAt(i10);
            if (I(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            } else {
                S(keyAt, motionLayout);
                i10++;
            }
        }
    }

    public void U(int i10, c cVar) {
        this.f1656h.put(i10, cVar);
    }

    public void V(int i10) {
        b bVar = this.f1651c;
        if (bVar != null) {
            bVar.E(i10);
        } else {
            this.f1660l = i10;
        }
    }

    public void W(boolean z10) {
        this.f1666r = z10;
        b bVar = this.f1651c;
        if (bVar != null && bVar.f1682l != null) {
            this.f1651c.f1682l.x(this.f1666r);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.h r0 = r6.f1650b
            r1 = -1
            if (r0 == 0) goto L_0x0016
            int r0 = r0.c(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.h r2 = r6.f1650b
            int r2 = r2.c(r8, r1, r1)
            if (r2 == r1) goto L_0x0017
            goto L_0x0018
        L_0x0016:
            r0 = r7
        L_0x0017:
            r2 = r8
        L_0x0018:
            androidx.constraintlayout.motion.widget.p$b r3 = r6.f1651c
            if (r3 == 0) goto L_0x002b
            int r3 = r3.f1673c
            if (r3 != r8) goto L_0x002b
            androidx.constraintlayout.motion.widget.p$b r3 = r6.f1651c
            int r3 = r3.f1674d
            if (r3 != r7) goto L_0x002b
            return
        L_0x002b:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p$b> r3 = r6.f1653e
            java.util.Iterator r3 = r3.iterator()
        L_0x0031:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x006b
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.p$b r4 = (androidx.constraintlayout.motion.widget.p.b) r4
            int r5 = r4.f1673c
            if (r5 != r2) goto L_0x0049
            int r5 = r4.f1674d
            if (r5 == r0) goto L_0x0055
        L_0x0049:
            int r5 = r4.f1673c
            if (r5 != r8) goto L_0x0031
            int r5 = r4.f1674d
            if (r5 != r7) goto L_0x0031
        L_0x0055:
            r6.f1651c = r4
            if (r4 == 0) goto L_0x006a
            androidx.constraintlayout.motion.widget.q r7 = r4.f1682l
            if (r7 == 0) goto L_0x006a
            androidx.constraintlayout.motion.widget.p$b r7 = r6.f1651c
            androidx.constraintlayout.motion.widget.q r7 = r7.f1682l
            boolean r8 = r6.f1666r
            r7.x(r8)
        L_0x006a:
            return
        L_0x006b:
            androidx.constraintlayout.motion.widget.p$b r7 = r6.f1654f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p$b> r3 = r6.f1655g
            java.util.Iterator r3 = r3.iterator()
        L_0x0073:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0087
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.p$b r4 = (androidx.constraintlayout.motion.widget.p.b) r4
            int r5 = r4.f1673c
            if (r5 != r8) goto L_0x0073
            r7 = r4
            goto L_0x0073
        L_0x0087:
            androidx.constraintlayout.motion.widget.p$b r8 = new androidx.constraintlayout.motion.widget.p$b
            r8.<init>(r6, r7)
            int unused = r8.f1674d = r0
            int unused = r8.f1673c = r2
            if (r0 == r1) goto L_0x0099
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p$b> r7 = r6.f1653e
            r7.add(r8)
        L_0x0099:
            r6.f1651c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.p.X(int, int):void");
    }

    public void Y(b bVar) {
        this.f1651c = bVar;
        if (bVar != null && bVar.f1682l != null) {
            this.f1651c.f1682l.x(this.f1666r);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        b bVar = this.f1651c;
        if (bVar != null && bVar.f1682l != null) {
            this.f1651c.f1682l.A();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b0() {
        Iterator<b> it = this.f1653e.iterator();
        while (it.hasNext()) {
            if (it.next().f1682l != null) {
                return true;
            }
        }
        b bVar = this.f1651c;
        return (bVar == null || bVar.f1682l == null) ? false : true;
    }

    public void c0(int i10, View... viewArr) {
        this.f1667s.i(i10, viewArr);
    }

    public void f(MotionLayout motionLayout, int i10) {
        Iterator<b> it = this.f1653e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f1683m.size() > 0) {
                Iterator it2 = next.f1683m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it3 = this.f1655g.iterator();
        while (it3.hasNext()) {
            b next2 = it3.next();
            if (next2.f1683m.size() > 0) {
                Iterator it4 = next2.f1683m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it5 = this.f1653e.iterator();
        while (it5.hasNext()) {
            b next3 = it5.next();
            if (next3.f1683m.size() > 0) {
                Iterator it6 = next3.f1683m.iterator();
                while (it6.hasNext()) {
                    ((b.a) it6.next()).a(motionLayout, i10, next3);
                }
            }
        }
        Iterator<b> it7 = this.f1655g.iterator();
        while (it7.hasNext()) {
            b next4 = it7.next();
            if (next4.f1683m.size() > 0) {
                Iterator it8 = next4.f1683m.iterator();
                while (it8.hasNext()) {
                    ((b.a) it8.next()).a(motionLayout, i10, next4);
                }
            }
        }
    }

    public boolean g(int i10, m mVar) {
        return this.f1667s.d(i10, mVar);
    }

    /* access modifiers changed from: package-private */
    public boolean h(MotionLayout motionLayout, int i10) {
        b bVar;
        if (J() || this.f1652d) {
            return false;
        }
        Iterator<b> it = this.f1653e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f1684n != 0 && ((bVar = this.f1651c) != next || !bVar.D(2))) {
                if (i10 == next.f1674d && (next.f1684n == 4 || next.f1684n == 2)) {
                    MotionLayout.k kVar = MotionLayout.k.FINISHED;
                    motionLayout.setState(kVar);
                    motionLayout.setTransition(next);
                    if (next.f1684n == 4) {
                        motionLayout.D0();
                        motionLayout.setState(MotionLayout.k.SETUP);
                        motionLayout.setState(MotionLayout.k.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.g0(true);
                        motionLayout.setState(MotionLayout.k.SETUP);
                        motionLayout.setState(MotionLayout.k.MOVING);
                        motionLayout.setState(kVar);
                        motionLayout.u0();
                    }
                    return true;
                } else if (i10 == next.f1673c && (next.f1684n == 3 || next.f1684n == 1)) {
                    MotionLayout.k kVar2 = MotionLayout.k.FINISHED;
                    motionLayout.setState(kVar2);
                    motionLayout.setTransition(next);
                    if (next.f1684n == 3) {
                        motionLayout.F0();
                        motionLayout.setState(MotionLayout.k.SETUP);
                        motionLayout.setState(MotionLayout.k.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.g0(true);
                        motionLayout.setState(MotionLayout.k.SETUP);
                        motionLayout.setState(MotionLayout.k.MOVING);
                        motionLayout.setState(kVar2);
                        motionLayout.u0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b i(int i10, float f10, float f11, MotionEvent motionEvent) {
        RectF f12;
        int i11 = i10;
        float f13 = f10;
        float f14 = f11;
        if (i11 == -1) {
            return this.f1651c;
        }
        List<b> H = H(i10);
        float f15 = 0.0f;
        b bVar = null;
        RectF rectF = new RectF();
        for (b next : H) {
            if (!next.f1685o && next.f1682l != null) {
                next.f1682l.x(this.f1666r);
                RectF p10 = next.f1682l.p(this.f1649a, rectF);
                if ((p10 == null || motionEvent == null || p10.contains(motionEvent.getX(), motionEvent.getY())) && ((f12 = next.f1682l.f(this.f1649a, rectF)) == null || motionEvent == null || f12.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float a10 = next.f1682l.a(f13, f14);
                    if (next.f1682l.f1703l && motionEvent != null) {
                        float x10 = motionEvent.getX() - next.f1682l.f1700i;
                        float y10 = motionEvent.getY() - next.f1682l.f1701j;
                        a10 = ((float) (Math.atan2((double) (f14 + y10), (double) (f13 + x10)) - Math.atan2((double) x10, (double) y10))) * 10.0f;
                    }
                    float f16 = a10 * (next.f1673c == i11 ? -1.0f : 1.1f);
                    if (f16 > f15) {
                        bVar = next;
                        f15 = f16;
                    }
                }
            }
        }
        return bVar;
    }

    public int j() {
        b bVar = this.f1651c;
        if (bVar != null) {
            return bVar.f1686p;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0;
        }
        return this.f1651c.f1682l.d();
    }

    /* access modifiers changed from: package-private */
    public c l(int i10) {
        return m(i10, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public c m(int i10, int i11, int i12) {
        Object obj;
        int c10;
        if (this.f1659k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i10);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.f1656h.size());
        }
        h hVar = this.f1650b;
        if (!(hVar == null || (c10 = hVar.c(i10, i11, i12)) == -1)) {
            i10 = c10;
        }
        if (this.f1656h.get(i10) == null) {
            Log.e("MotionScene", "Warning could not find ConstraintSet id/" + a.c(this.f1649a.getContext(), i10) + " In MotionScene");
            SparseArray sparseArray = this.f1656h;
            obj = sparseArray.get(sparseArray.keyAt(0));
        } else {
            obj = this.f1656h.get(i10);
        }
        return (c) obj;
    }

    public int[] n() {
        int size = this.f1656h.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f1656h.keyAt(i10);
        }
        return iArr;
    }

    public ArrayList<b> o() {
        return this.f1653e;
    }

    public int p() {
        b bVar = this.f1651c;
        return bVar != null ? bVar.f1678h : this.f1660l;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        b bVar = this.f1651c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f1673c;
    }

    public Interpolator s() {
        int g10 = this.f1651c.f1675e;
        if (g10 == -2) {
            return AnimationUtils.loadInterpolator(this.f1649a.getContext(), this.f1651c.f1677g);
        }
        if (g10 == -1) {
            return new a(this, f0.c.c(this.f1651c.f1676f));
        }
        if (g10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (g10 == 1) {
            return new AccelerateInterpolator();
        }
        if (g10 == 2) {
            return new DecelerateInterpolator();
        }
        if (g10 == 4) {
            return new BounceInterpolator();
        }
        if (g10 == 5) {
            return new OvershootInterpolator();
        }
        if (g10 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public void t(m mVar) {
        b bVar = this.f1651c;
        if (bVar == null) {
            b bVar2 = this.f1654f;
            if (bVar2 != null) {
                Iterator it = bVar2.f1681k.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).b(mVar);
                }
                return;
            }
            return;
        }
        Iterator it2 = bVar.f1681k.iterator();
        while (it2.hasNext()) {
            ((g) it2.next()).b(mVar);
        }
    }

    /* access modifiers changed from: package-private */
    public float u() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0.0f;
        }
        return this.f1651c.f1682l.g();
    }

    /* access modifiers changed from: package-private */
    public float v() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0.0f;
        }
        return this.f1651c.f1682l.h();
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return false;
        }
        return this.f1651c.f1682l.i();
    }

    /* access modifiers changed from: package-private */
    public float x(float f10, float f11) {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0.0f;
        }
        return this.f1651c.f1682l.j(f10, f11);
    }

    /* access modifiers changed from: package-private */
    public int z() {
        b bVar = this.f1651c;
        if (bVar == null || bVar.f1682l == null) {
            return 0;
        }
        return this.f1651c.f1682l.k();
    }
}
