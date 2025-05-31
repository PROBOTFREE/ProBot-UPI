package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.f;
import java.util.Arrays;

public class CircularFlow extends VirtualLayout {

    /* renamed from: v  reason: collision with root package name */
    private static int f1363v;

    /* renamed from: w  reason: collision with root package name */
    private static float f1364w;

    /* renamed from: l  reason: collision with root package name */
    ConstraintLayout f1365l;

    /* renamed from: m  reason: collision with root package name */
    int f1366m;

    /* renamed from: n  reason: collision with root package name */
    private float[] f1367n;

    /* renamed from: o  reason: collision with root package name */
    private int[] f1368o;

    /* renamed from: p  reason: collision with root package name */
    private int f1369p;

    /* renamed from: q  reason: collision with root package name */
    private int f1370q;

    /* renamed from: r  reason: collision with root package name */
    private String f1371r;

    /* renamed from: s  reason: collision with root package name */
    private String f1372s;

    /* renamed from: t  reason: collision with root package name */
    private Float f1373t;

    /* renamed from: u  reason: collision with root package name */
    private Integer f1374u;

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private void A() {
        this.f1365l = (ConstraintLayout) getParent();
        for (int i10 = 0; i10 < this.f1863b; i10++) {
            View l10 = this.f1365l.l(this.f1862a[i10]);
            if (l10 != null) {
                int i11 = f1363v;
                float f10 = f1364w;
                int[] iArr = this.f1368o;
                if (iArr == null || i10 >= iArr.length) {
                    Integer num = this.f1374u;
                    if (num == null || num.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + this.f1870i.get(Integer.valueOf(l10.getId())));
                    } else {
                        this.f1369p++;
                        if (this.f1368o == null) {
                            this.f1368o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f1368o = radius;
                        radius[this.f1369p - 1] = i11;
                    }
                } else {
                    i11 = iArr[i10];
                }
                float[] fArr = this.f1367n;
                if (fArr == null || i10 >= fArr.length) {
                    Float f11 = this.f1373t;
                    if (f11 == null || f11.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + this.f1870i.get(Integer.valueOf(l10.getId())));
                    } else {
                        this.f1370q++;
                        if (this.f1367n == null) {
                            this.f1367n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f1367n = angles;
                        angles[this.f1370q - 1] = f10;
                    }
                } else {
                    f10 = fArr[i10];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) l10.getLayoutParams();
                layoutParams.f1925r = f10;
                layoutParams.f1921p = this.f1366m;
                layoutParams.f1923q = i11;
                l10.setLayoutParams(layoutParams);
            }
        }
        h();
    }

    private void setAngles(String str) {
        if (str != null) {
            int i10 = 0;
            this.f1370q = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    y(str.substring(i10).trim());
                    return;
                } else {
                    y(str.substring(i10, indexOf).trim());
                    i10 = indexOf + 1;
                }
            }
        }
    }

    private void setRadius(String str) {
        if (str != null) {
            int i10 = 0;
            this.f1369p = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    z(str.substring(i10).trim());
                    return;
                } else {
                    z(str.substring(i10, indexOf).trim());
                    i10 = indexOf + 1;
                }
            }
        }
    }

    private void y(String str) {
        float[] fArr;
        if (str != null && str.length() != 0 && this.f1864c != null && (fArr = this.f1367n) != null) {
            if (this.f1370q + 1 > fArr.length) {
                this.f1367n = Arrays.copyOf(fArr, fArr.length + 1);
            }
            this.f1367n[this.f1370q] = (float) Integer.parseInt(str);
            this.f1370q++;
        }
    }

    private void z(String str) {
        int[] iArr;
        if (str != null && str.length() != 0 && this.f1864c != null && (iArr = this.f1368o) != null) {
            if (this.f1369p + 1 > iArr.length) {
                this.f1368o = Arrays.copyOf(iArr, iArr.length + 1);
            }
            this.f1368o[this.f1369p] = (int) (((float) Integer.parseInt(str)) * this.f1864c.getResources().getDisplayMetrics().density);
            this.f1369p++;
        }
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f1367n, this.f1370q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f1368o, this.f1369p);
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f1366m = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == f.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1371r = string;
                    setAngles(string);
                } else if (index == f.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1372s = string2;
                    setRadius(string2);
                } else if (index == f.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, f1364w));
                    this.f1373t = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == f.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, f1363v));
                    this.f1374u = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1371r;
        if (str != null) {
            this.f1367n = new float[1];
            setAngles(str);
        }
        String str2 = this.f1372s;
        if (str2 != null) {
            this.f1368o = new int[1];
            setRadius(str2);
        }
        Float f10 = this.f1373t;
        if (f10 != null) {
            setDefaultAngle(f10.floatValue());
        }
        Integer num = this.f1374u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        A();
    }

    public void setDefaultAngle(float f10) {
        f1364w = f10;
    }

    public void setDefaultRadius(int i10) {
        f1363v = i10;
    }
}
