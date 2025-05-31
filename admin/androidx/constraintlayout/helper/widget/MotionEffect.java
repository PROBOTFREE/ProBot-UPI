package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.f;

public class MotionEffect extends MotionHelper {

    /* renamed from: n  reason: collision with root package name */
    private float f1393n = 0.1f;

    /* renamed from: o  reason: collision with root package name */
    private int f1394o = 49;

    /* renamed from: p  reason: collision with root package name */
    private int f1395p = 50;

    /* renamed from: q  reason: collision with root package name */
    private int f1396q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f1397r = 0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1398s = true;

    /* renamed from: t  reason: collision with root package name */
    private int f1399t = -1;

    /* renamed from: u  reason: collision with root package name */
    private int f1400u = -1;

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        F(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        F(context, attributeSet);
    }

    private void F(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.MotionEffect_motionEffect_start) {
                    int i11 = obtainStyledAttributes.getInt(index, this.f1394o);
                    this.f1394o = i11;
                    this.f1394o = Math.max(Math.min(i11, 99), 0);
                } else if (index == f.MotionEffect_motionEffect_end) {
                    int i12 = obtainStyledAttributes.getInt(index, this.f1395p);
                    this.f1395p = i12;
                    this.f1395p = Math.max(Math.min(i12, 99), 0);
                } else if (index == f.MotionEffect_motionEffect_translationX) {
                    this.f1396q = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1396q);
                } else if (index == f.MotionEffect_motionEffect_translationY) {
                    this.f1397r = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1397r);
                } else if (index == f.MotionEffect_motionEffect_alpha) {
                    this.f1393n = obtainStyledAttributes.getFloat(index, this.f1393n);
                } else if (index == f.MotionEffect_motionEffect_move) {
                    this.f1400u = obtainStyledAttributes.getInt(index, this.f1400u);
                } else if (index == f.MotionEffect_motionEffect_strict) {
                    this.f1398s = obtainStyledAttributes.getBoolean(index, this.f1398s);
                } else if (index == f.MotionEffect_motionEffect_viewTransition) {
                    this.f1399t = obtainStyledAttributes.getResourceId(index, this.f1399t);
                }
            }
            int i13 = this.f1394o;
            int i14 = this.f1395p;
            if (i13 == i14) {
                if (i13 > 0) {
                    this.f1394o = i13 - 1;
                } else {
                    this.f1395p = i14 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0188, code lost:
        if (r14 == 0.0f) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019c, code lost:
        if (r14 == 0.0f) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ac, code lost:
        if (r15 == 0.0f) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01bc, code lost:
        if (r15 == 0.0f) goto L_0x018b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(androidx.constraintlayout.motion.widget.MotionLayout r22, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            android.view.ViewParent r2 = r21.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.n(r2)
            if (r2 != 0) goto L_0x002b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = androidx.constraintlayout.motion.widget.a.a()
            r1.append(r2)
            java.lang.String r2 = " views = null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FadeMove"
            android.util.Log.v(r2, r1)
            return
        L_0x002b:
            androidx.constraintlayout.motion.widget.e r3 = new androidx.constraintlayout.motion.widget.e
            r3.<init>()
            androidx.constraintlayout.motion.widget.e r4 = new androidx.constraintlayout.motion.widget.e
            r4.<init>()
            float r5 = r0.f1393n
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.R(r6, r5)
            float r5 = r0.f1393n
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.R(r6, r5)
            int r5 = r0.f1394o
            r3.g(r5)
            int r5 = r0.f1395p
            r4.g(r5)
            androidx.constraintlayout.motion.widget.h r5 = new androidx.constraintlayout.motion.widget.h
            r5.<init>()
            int r6 = r0.f1394o
            r5.g(r6)
            r6 = 0
            r5.m(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.n(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.n(r9, r7)
            androidx.constraintlayout.motion.widget.h r7 = new androidx.constraintlayout.motion.widget.h
            r7.<init>()
            int r10 = r0.f1395p
            r7.g(r10)
            r7.m(r6)
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.n(r8, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.n(r9, r8)
            int r8 = r0.f1396q
            r9 = 0
            if (r8 <= 0) goto L_0x00bc
            androidx.constraintlayout.motion.widget.e r8 = new androidx.constraintlayout.motion.widget.e
            r8.<init>()
            androidx.constraintlayout.motion.widget.e r11 = new androidx.constraintlayout.motion.widget.e
            r11.<init>()
            int r12 = r0.f1396q
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.R(r13, r12)
            int r12 = r0.f1395p
            r8.g(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.R(r13, r12)
            int r12 = r0.f1395p
            int r12 = r12 - r10
            r11.g(r12)
            goto L_0x00be
        L_0x00bc:
            r8 = r9
            r11 = r8
        L_0x00be:
            int r12 = r0.f1397r
            if (r12 <= 0) goto L_0x00ea
            androidx.constraintlayout.motion.widget.e r9 = new androidx.constraintlayout.motion.widget.e
            r9.<init>()
            androidx.constraintlayout.motion.widget.e r12 = new androidx.constraintlayout.motion.widget.e
            r12.<init>()
            int r13 = r0.f1397r
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.R(r14, r13)
            int r13 = r0.f1395p
            r9.g(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.R(r14, r13)
            int r13 = r0.f1395p
            int r13 = r13 - r10
            r12.g(r13)
            goto L_0x00eb
        L_0x00ea:
            r12 = r9
        L_0x00eb:
            int r13 = r0.f1400u
            r15 = -1
            r17 = 0
            if (r13 != r15) goto L_0x0156
            r13 = 4
            int[] r15 = new int[r13]
            r13 = r6
        L_0x00f6:
            int r14 = r2.length
            if (r13 >= r14) goto L_0x0143
            r14 = r2[r13]
            java.lang.Object r14 = r1.get(r14)
            androidx.constraintlayout.motion.widget.m r14 = (androidx.constraintlayout.motion.widget.m) r14
            if (r14 != 0) goto L_0x0104
            goto L_0x0140
        L_0x0104:
            float r19 = r14.n()
            float r20 = r14.t()
            float r19 = r19 - r20
            float r20 = r14.o()
            float r14 = r14.u()
            float r20 = r20 - r14
            int r14 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0121
            r14 = r15[r10]
            int r14 = r14 + r10
            r15[r10] = r14
        L_0x0121:
            int r14 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x012a
            r14 = r15[r6]
            int r14 = r14 + r10
            r15[r6] = r14
        L_0x012a:
            int r14 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x0135
            r14 = 3
            r18 = r15[r14]
            int r18 = r18 + 1
            r15[r14] = r18
        L_0x0135:
            int r14 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0140
            r14 = 2
            r16 = r15[r14]
            int r16 = r16 + 1
            r15[r14] = r16
        L_0x0140:
            int r13 = r13 + 1
            goto L_0x00f6
        L_0x0143:
            r13 = r15[r6]
            r14 = r13
            r13 = r6
            r6 = r10
        L_0x0148:
            r10 = 4
            if (r6 >= r10) goto L_0x0156
            r10 = r15[r6]
            if (r14 >= r10) goto L_0x0153
            r10 = r15[r6]
            r13 = r6
            r14 = r10
        L_0x0153:
            int r6 = r6 + 1
            goto L_0x0148
        L_0x0156:
            r6 = 0
        L_0x0157:
            int r10 = r2.length
            if (r6 >= r10) goto L_0x01f5
            r10 = r2[r6]
            java.lang.Object r10 = r1.get(r10)
            androidx.constraintlayout.motion.widget.m r10 = (androidx.constraintlayout.motion.widget.m) r10
            if (r10 != 0) goto L_0x0169
        L_0x0164:
            r1 = r22
            r15 = -1
            goto L_0x01ef
        L_0x0169:
            float r14 = r10.n()
            float r15 = r10.t()
            float r14 = r14 - r15
            float r15 = r10.o()
            float r20 = r10.u()
            float r15 = r15 - r20
            if (r13 != 0) goto L_0x018f
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x018d
            boolean r15 = r0.f1398s
            if (r15 == 0) goto L_0x018a
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x018d
        L_0x018a:
            r1 = 3
        L_0x018b:
            r14 = 0
            goto L_0x01c0
        L_0x018d:
            r1 = 3
            goto L_0x01bf
        L_0x018f:
            r1 = 1
            if (r13 != r1) goto L_0x019f
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x018d
            boolean r15 = r0.f1398s
            if (r15 == 0) goto L_0x018a
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x018d
            goto L_0x018a
        L_0x019f:
            r1 = 2
            if (r13 != r1) goto L_0x01af
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x018d
            boolean r14 = r0.f1398s
            if (r14 == 0) goto L_0x018a
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x018d
            goto L_0x018a
        L_0x01af:
            r1 = 3
            if (r13 != r1) goto L_0x01bf
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x01bf
            boolean r14 = r0.f1398s
            if (r14 == 0) goto L_0x018b
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x01bf
            goto L_0x018b
        L_0x01bf:
            r14 = 1
        L_0x01c0:
            if (r14 == 0) goto L_0x0164
            int r14 = r0.f1399t
            r15 = -1
            if (r14 != r15) goto L_0x01ea
            r10.a(r3)
            r10.a(r4)
            r10.a(r5)
            r10.a(r7)
            int r14 = r0.f1396q
            if (r14 <= 0) goto L_0x01dd
            r10.a(r8)
            r10.a(r11)
        L_0x01dd:
            int r14 = r0.f1397r
            if (r14 <= 0) goto L_0x01e7
            r10.a(r9)
            r10.a(r12)
        L_0x01e7:
            r1 = r22
            goto L_0x01ef
        L_0x01ea:
            r1 = r22
            r1.Z(r14, r10)
        L_0x01ef:
            int r6 = r6 + 1
            r1 = r23
            goto L_0x0157
        L_0x01f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.D(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public boolean x() {
        return true;
    }
}
