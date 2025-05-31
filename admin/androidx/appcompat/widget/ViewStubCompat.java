package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import j.j;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f1009a;

    /* renamed from: b  reason: collision with root package name */
    private int f1010b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<View> f1011c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f1012d;

    /* renamed from: e  reason: collision with root package name */
    private a f1013e;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1009a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ViewStubCompat, i10, 0);
        this.f1010b = obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_inflatedId, -1);
        this.f1009a = obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(j.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1009a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f1012d;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1009a, viewGroup, false);
            int i10 = this.f1010b;
            if (i10 != -1) {
                inflate.setId(i10);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1011c = new WeakReference<>(inflate);
            a aVar = this.f1013e;
            if (aVar != null) {
                aVar.a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1010b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1012d;
    }

    public int getLayoutResource() {
        return this.f1009a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i10) {
        this.f1010b = i10;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1012d = layoutInflater;
    }

    public void setLayoutResource(int i10) {
        this.f1009a = i10;
    }

    public void setOnInflateListener(a aVar) {
        this.f1013e = aVar;
    }

    public void setVisibility(int i10) {
        WeakReference<View> weakReference = this.f1011c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(i10);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i10);
        if (i10 == 0 || i10 == 4) {
            a();
        }
    }
}
