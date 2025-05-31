package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.f;
import f0.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class s {

    /* renamed from: v  reason: collision with root package name */
    private static String f1720v = "ViewTransition";

    /* renamed from: a  reason: collision with root package name */
    private int f1721a;

    /* renamed from: b  reason: collision with root package name */
    private int f1722b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1723c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f1724d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f1725e;

    /* renamed from: f  reason: collision with root package name */
    g f1726f;

    /* renamed from: g  reason: collision with root package name */
    c.a f1727g;

    /* renamed from: h  reason: collision with root package name */
    private int f1728h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f1729i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f1730j;

    /* renamed from: k  reason: collision with root package name */
    private String f1731k;

    /* renamed from: l  reason: collision with root package name */
    private int f1732l = 0;

    /* renamed from: m  reason: collision with root package name */
    private String f1733m = null;

    /* renamed from: n  reason: collision with root package name */
    private int f1734n = -1;

    /* renamed from: o  reason: collision with root package name */
    Context f1735o;

    /* renamed from: p  reason: collision with root package name */
    private int f1736p = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f1737q = -1;

    /* renamed from: r  reason: collision with root package name */
    private int f1738r = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f1739s = -1;

    /* renamed from: t  reason: collision with root package name */
    private int f1740t = -1;

    /* renamed from: u  reason: collision with root package name */
    private int f1741u = -1;

    class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f0.c f1742a;

        a(s sVar, f0.c cVar) {
            this.f1742a = cVar;
        }

        public float getInterpolation(float f10) {
            return (float) this.f1742a.a((double) f10);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f1743a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1744b;

        /* renamed from: c  reason: collision with root package name */
        long f1745c;

        /* renamed from: d  reason: collision with root package name */
        m f1746d;

        /* renamed from: e  reason: collision with root package name */
        int f1747e;

        /* renamed from: f  reason: collision with root package name */
        d f1748f = new d();

        /* renamed from: g  reason: collision with root package name */
        t f1749g;

        /* renamed from: h  reason: collision with root package name */
        Interpolator f1750h;

        /* renamed from: i  reason: collision with root package name */
        boolean f1751i = false;

        /* renamed from: j  reason: collision with root package name */
        float f1752j;

        /* renamed from: k  reason: collision with root package name */
        float f1753k;

        /* renamed from: l  reason: collision with root package name */
        long f1754l;

        /* renamed from: m  reason: collision with root package name */
        Rect f1755m = new Rect();

        /* renamed from: n  reason: collision with root package name */
        boolean f1756n = false;

        b(t tVar, m mVar, int i10, int i11, int i12, Interpolator interpolator, int i13, int i14) {
            this.f1749g = tVar;
            this.f1746d = mVar;
            this.f1747e = i11;
            long nanoTime = System.nanoTime();
            this.f1745c = nanoTime;
            this.f1754l = nanoTime;
            this.f1749g.b(this);
            this.f1750h = interpolator;
            this.f1743a = i13;
            this.f1744b = i14;
            if (i12 == 3) {
                this.f1756n = true;
            }
            this.f1753k = i10 == 0 ? Float.MAX_VALUE : 1.0f / ((float) i10);
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f1751i) {
                c();
            } else {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            long nanoTime = System.nanoTime();
            this.f1754l = nanoTime;
            float f10 = this.f1752j + (((float) (((double) (nanoTime - this.f1754l)) * 1.0E-6d)) * this.f1753k);
            this.f1752j = f10;
            if (f10 >= 1.0f) {
                this.f1752j = 1.0f;
            }
            Interpolator interpolator = this.f1750h;
            float interpolation = interpolator == null ? this.f1752j : interpolator.getInterpolation(this.f1752j);
            m mVar = this.f1746d;
            boolean x10 = mVar.x(mVar.f1605b, interpolation, nanoTime, this.f1748f);
            if (this.f1752j >= 1.0f) {
                if (this.f1743a != -1) {
                    this.f1746d.v().setTag(this.f1743a, Long.valueOf(System.nanoTime()));
                }
                if (this.f1744b != -1) {
                    this.f1746d.v().setTag(this.f1744b, (Object) null);
                }
                if (!this.f1756n) {
                    this.f1749g.g(this);
                }
            }
            if (this.f1752j < 1.0f || x10) {
                this.f1749g.e();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            long nanoTime = System.nanoTime();
            this.f1754l = nanoTime;
            float f10 = this.f1752j - (((float) (((double) (nanoTime - this.f1754l)) * 1.0E-6d)) * this.f1753k);
            this.f1752j = f10;
            if (f10 < 0.0f) {
                this.f1752j = 0.0f;
            }
            Interpolator interpolator = this.f1750h;
            float interpolation = interpolator == null ? this.f1752j : interpolator.getInterpolation(this.f1752j);
            m mVar = this.f1746d;
            boolean x10 = mVar.x(mVar.f1605b, interpolation, nanoTime, this.f1748f);
            if (this.f1752j <= 0.0f) {
                if (this.f1743a != -1) {
                    this.f1746d.v().setTag(this.f1743a, Long.valueOf(System.nanoTime()));
                }
                if (this.f1744b != -1) {
                    this.f1746d.v().setTag(this.f1744b, (Object) null);
                }
                this.f1749g.g(this);
            }
            if (this.f1752j > 0.0f || x10) {
                this.f1749g.e();
            }
        }

        public void d(int i10, float f10, float f11) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.f1746d.v().getHitRect(this.f1755m);
                    if (!this.f1755m.contains((int) f10, (int) f11) && !this.f1751i) {
                        e(true);
                    }
                }
            } else if (!this.f1751i) {
                e(true);
            }
        }

        /* access modifiers changed from: package-private */
        public void e(boolean z10) {
            int i10;
            this.f1751i = z10;
            if (z10 && (i10 = this.f1747e) != -1) {
                this.f1753k = i10 == 0 ? Float.MAX_VALUE : 1.0f / ((float) i10);
            }
            this.f1749g.e();
            this.f1754l = System.nanoTime();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    s(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.f1722b = r0
            r1 = 0
            r9.f1723c = r1
            r9.f1724d = r1
            r9.f1728h = r0
            r9.f1729i = r0
            r9.f1732l = r1
            r2 = 0
            r9.f1733m = r2
            r9.f1734n = r0
            r9.f1736p = r0
            r9.f1737q = r0
            r9.f1738r = r0
            r9.f1739s = r0
            r9.f1740t = r0
            r9.f1741u = r0
            r9.f1735o = r10
            int r2 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
        L_0x0028:
            r3 = 1
            if (r2 == r3) goto L_0x00e9
            java.lang.String r4 = "ViewTransition"
            r5 = 3
            r6 = 2
            if (r2 == r6) goto L_0x0040
            if (r2 == r5) goto L_0x0035
            goto L_0x00da
        L_0x0035:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            boolean r2 = r4.equals(r2)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            if (r2 == 0) goto L_0x00da
            return
        L_0x0040:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            int r7 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r8 = 4
            switch(r7) {
                case -1962203927: goto L_0x0073;
                case -1239391468: goto L_0x0069;
                case 61998586: goto L_0x0061;
                case 366511058: goto L_0x0057;
                case 1791837707: goto L_0x004d;
                default: goto L_0x004c;
            }     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
        L_0x004c:
            goto L_0x007d
        L_0x004d:
            java.lang.String r4 = "CustomAttribute"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            if (r4 == 0) goto L_0x007d
            r4 = r5
            goto L_0x007e
        L_0x0057:
            java.lang.String r4 = "CustomMethod"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            if (r4 == 0) goto L_0x007d
            r4 = r8
            goto L_0x007e
        L_0x0061:
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            if (r4 == 0) goto L_0x007d
            r4 = r1
            goto L_0x007e
        L_0x0069:
            java.lang.String r4 = "KeyFrameSet"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            if (r4 == 0) goto L_0x007d
            r4 = r3
            goto L_0x007e
        L_0x0073:
            java.lang.String r4 = "ConstraintOverride"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            if (r4 == 0) goto L_0x007d
            r4 = r6
            goto L_0x007e
        L_0x007d:
            r4 = r0
        L_0x007e:
            if (r4 == 0) goto L_0x00d7
            if (r4 == r3) goto L_0x00cf
            if (r4 == r6) goto L_0x00c8
            if (r4 == r5) goto L_0x00c0
            if (r4 == r8) goto L_0x00c0
            java.lang.String r3 = f1720v     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.lang.String r5 = androidx.constraintlayout.motion.widget.a.a()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.lang.String r5 = " unknown tag "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.lang.String r2 = r4.toString()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            android.util.Log.e(r3, r2)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.lang.String r2 = f1720v     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.lang.String r4 = ".xml:"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            int r4 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.lang.String r3 = r3.toString()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            android.util.Log.e(r2, r3)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            goto L_0x00da
        L_0x00c0:
            androidx.constraintlayout.widget.c$a r2 = r9.f1727g     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r2 = r2.f2013g     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            androidx.constraintlayout.widget.a.i(r10, r11, r2)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            goto L_0x00da
        L_0x00c8:
            androidx.constraintlayout.widget.c$a r2 = androidx.constraintlayout.widget.c.m(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r9.f1727g = r2     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            goto L_0x00da
        L_0x00cf:
            androidx.constraintlayout.motion.widget.g r2 = new androidx.constraintlayout.motion.widget.g     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r2.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            r9.f1726f = r2     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            goto L_0x00da
        L_0x00d7:
            r9.l(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
        L_0x00da:
            int r2 = r11.next()     // Catch:{ XmlPullParserException -> 0x00e5, IOException -> 0x00e0 }
            goto L_0x0028
        L_0x00e0:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00e9
        L_0x00e5:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.s.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View[] viewArr) {
        if (this.f1736p != -1) {
            for (View tag : viewArr) {
                tag.setTag(this.f1736p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f1737q != -1) {
            for (View tag2 : viewArr) {
                tag2.setTag(this.f1737q, (Object) null);
            }
        }
    }

    private void l(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == f.ViewTransition_android_id) {
                this.f1721a = obtainStyledAttributes.getResourceId(index, this.f1721a);
            } else if (index == f.ViewTransition_motionTarget) {
                if (MotionLayout.O1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f1730j);
                    this.f1730j = resourceId;
                    if (resourceId != -1) {
                    }
                } else if (obtainStyledAttributes.peekValue(index).type != 3) {
                    this.f1730j = obtainStyledAttributes.getResourceId(index, this.f1730j);
                }
                this.f1731k = obtainStyledAttributes.getString(index);
            } else if (index == f.ViewTransition_onStateTransition) {
                this.f1722b = obtainStyledAttributes.getInt(index, this.f1722b);
            } else if (index == f.ViewTransition_transitionDisable) {
                this.f1723c = obtainStyledAttributes.getBoolean(index, this.f1723c);
            } else if (index == f.ViewTransition_pathMotionArc) {
                this.f1724d = obtainStyledAttributes.getInt(index, this.f1724d);
            } else if (index == f.ViewTransition_duration) {
                this.f1728h = obtainStyledAttributes.getInt(index, this.f1728h);
            } else if (index == f.ViewTransition_upDuration) {
                this.f1729i = obtainStyledAttributes.getInt(index, this.f1729i);
            } else if (index == f.ViewTransition_viewTransitionMode) {
                this.f1725e = obtainStyledAttributes.getInt(index, this.f1725e);
            } else if (index == f.ViewTransition_motionInterpolator) {
                int i11 = obtainStyledAttributes.peekValue(index).type;
                if (i11 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.f1734n = resourceId2;
                    if (resourceId2 == -1) {
                    }
                } else if (i11 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1733m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f1732l = -1;
                    } else {
                        this.f1734n = obtainStyledAttributes.getResourceId(index, -1);
                    }
                } else {
                    this.f1732l = obtainStyledAttributes.getInteger(index, this.f1732l);
                }
                this.f1732l = -2;
            } else if (index == f.ViewTransition_setsTag) {
                this.f1736p = obtainStyledAttributes.getResourceId(index, this.f1736p);
            } else if (index == f.ViewTransition_clearsTag) {
                this.f1737q = obtainStyledAttributes.getResourceId(index, this.f1737q);
            } else if (index == f.ViewTransition_ifTagSet) {
                this.f1738r = obtainStyledAttributes.getResourceId(index, this.f1738r);
            } else if (index == f.ViewTransition_ifTagNotSet) {
                this.f1739s = obtainStyledAttributes.getResourceId(index, this.f1739s);
            } else if (index == f.ViewTransition_SharedValueId) {
                this.f1741u = obtainStyledAttributes.getResourceId(index, this.f1741u);
            } else if (index == f.ViewTransition_SharedValue) {
                this.f1740t = obtainStyledAttributes.getInteger(index, this.f1740t);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void n(p.b bVar, View view) {
        int i10 = this.f1728h;
        if (i10 != -1) {
            bVar.E(i10);
        }
        bVar.I(this.f1724d);
        bVar.G(this.f1732l, this.f1733m, this.f1734n);
        int id2 = view.getId();
        g gVar = this.f1726f;
        if (gVar != null) {
            ArrayList<d> d10 = gVar.d(-1);
            g gVar2 = new g();
            Iterator<d> it = d10.iterator();
            while (it.hasNext()) {
                gVar2.c(it.next().clone().i(id2));
            }
            bVar.t(gVar2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(t tVar, MotionLayout motionLayout, View view) {
        m mVar = new m(view);
        mVar.B(view);
        this.f1726f.a(mVar);
        mVar.I(motionLayout.getWidth(), motionLayout.getHeight(), (float) this.f1728h, System.nanoTime());
        t tVar2 = tVar;
        m mVar2 = mVar;
        new b(tVar2, mVar2, this.f1728h, this.f1729i, this.f1722b, f(motionLayout.getContext()), this.f1736p, this.f1737q);
    }

    /* access modifiers changed from: package-private */
    public void c(t tVar, MotionLayout motionLayout, int i10, c cVar, View... viewArr) {
        if (!this.f1723c) {
            int i11 = this.f1725e;
            if (i11 == 2) {
                b(tVar, motionLayout, viewArr[0]);
                return;
            }
            if (i11 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i12 : constraintSetIds) {
                    if (i12 != i10) {
                        c m02 = motionLayout.m0(i12);
                        for (View id2 : viewArr) {
                            c.a w10 = m02.w(id2.getId());
                            c.a aVar = this.f1727g;
                            if (aVar != null) {
                                aVar.d(w10);
                                w10.f2013g.putAll(this.f1727g.f2013g);
                            }
                        }
                    }
                }
            }
            c cVar2 = new c();
            cVar2.q(cVar);
            for (View id3 : viewArr) {
                c.a w11 = cVar2.w(id3.getId());
                c.a aVar2 = this.f1727g;
                if (aVar2 != null) {
                    aVar2.d(w11);
                    w11.f2013g.putAll(this.f1727g.f2013g);
                }
            }
            motionLayout.L0(i10, cVar2);
            int i13 = e.view_transition;
            motionLayout.L0(i13, cVar);
            motionLayout.y0(i13, -1, -1);
            p.b bVar = new p.b(-1, motionLayout.f1429u, i13, i10);
            for (View n10 : viewArr) {
                n(bVar, n10);
            }
            motionLayout.setTransition(bVar);
            motionLayout.E0(new r(this, viewArr));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d(View view) {
        int i10 = this.f1738r;
        boolean z10 = i10 == -1 || view.getTag(i10) != null;
        int i11 = this.f1739s;
        return z10 && (i11 == -1 || view.getTag(i11) == null);
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1721a;
    }

    /* access modifiers changed from: package-private */
    public Interpolator f(Context context) {
        int i10 = this.f1732l;
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f1734n);
        }
        if (i10 == -1) {
            return new a(this, f0.c.c(this.f1733m));
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 == 5) {
            return new OvershootInterpolator();
        }
        if (i10 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.f1740t;
    }

    public int h() {
        return this.f1741u;
    }

    public int i() {
        return this.f1722b;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        r5 = ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r5.getLayoutParams()).Y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean k(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.f1730j
            r2 = -1
            if (r1 != r2) goto L_0x000e
            java.lang.String r1 = r4.f1731k
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            boolean r1 = r4.d(r5)
            if (r1 != 0) goto L_0x0015
            return r0
        L_0x0015:
            int r1 = r5.getId()
            int r2 = r4.f1730j
            r3 = 1
            if (r1 != r2) goto L_0x001f
            return r3
        L_0x001f:
            java.lang.String r1 = r4.f1731k
            if (r1 != 0) goto L_0x0024
            return r0
        L_0x0024:
            android.view.ViewGroup$LayoutParams r1 = r5.getLayoutParams()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r1 == 0) goto L_0x003f
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r5 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r5
            java.lang.String r5 = r5.Y
            if (r5 == 0) goto L_0x003f
            java.lang.String r1 = r4.f1731k
            boolean r5 = r5.matches(r1)
            if (r5 == 0) goto L_0x003f
            return r3
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.s.k(android.view.View):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean m(int i10) {
        int i11 = this.f1722b;
        return i11 == 1 ? i10 == 0 : i11 == 2 ? i10 == 1 : i11 == 3 && i10 == 0;
    }

    public String toString() {
        return "ViewTransition(" + a.c(this.f1735o, this.f1721a) + ")";
    }
}
