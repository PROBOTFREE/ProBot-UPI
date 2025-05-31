package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import n0.g;
import org.xmlpull.v1.XmlPullParser;

public class c extends h implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    private b f4193b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4194c;

    /* renamed from: d  reason: collision with root package name */
    private ArgbEvaluator f4195d;

    /* renamed from: e  reason: collision with root package name */
    final Drawable.Callback f4196e;

    class a implements Drawable.Callback {
        a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            c.this.scheduleSelf(runnable, j10);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    private static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f4198a;

        /* renamed from: b  reason: collision with root package name */
        i f4199b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f4200c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f4201d;

        /* renamed from: e  reason: collision with root package name */
        c0.a<Animator, String> f4202e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f4198a = bVar.f4198a;
                i iVar = bVar.f4199b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    this.f4199b = (i) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    i iVar2 = (i) this.f4199b.mutate();
                    this.f4199b = iVar2;
                    iVar2.setCallback(callback);
                    this.f4199b.setBounds(bVar.f4199b.getBounds());
                    this.f4199b.h(false);
                }
                ArrayList<Animator> arrayList = bVar.f4201d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f4201d = new ArrayList<>(size);
                    this.f4202e = new c0.a<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = bVar.f4201d.get(i10);
                        Animator clone = animator.clone();
                        String str = bVar.f4202e.get(animator);
                        clone.setTarget(this.f4199b.d(str));
                        this.f4201d.add(clone);
                        this.f4202e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f4200c == null) {
                this.f4200c = new AnimatorSet();
            }
            this.f4200c.playTogether(this.f4201d);
        }

        public int getChangingConfigurations() {
            return this.f4198a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.c$c  reason: collision with other inner class name */
    private static class C0047c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f4203a;

        public C0047c(Drawable.ConstantState constantState) {
            this.f4203a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f4203a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f4203a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            c cVar = new c();
            Drawable newDrawable = this.f4203a.newDrawable();
            cVar.f4208a = newDrawable;
            newDrawable.setCallback(cVar.f4196e);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable newDrawable = this.f4203a.newDrawable(resources);
            cVar.f4208a = newDrawable;
            newDrawable.setCallback(cVar.f4196e);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable newDrawable = this.f4203a.newDrawable(resources, theme);
            cVar.f4208a = newDrawable;
            newDrawable.setCallback(cVar.f4196e);
            return cVar;
        }
    }

    c() {
        this((Context) null, (b) null, (Resources) null);
    }

    private c(Context context) {
        this(context, (b) null, (Resources) null);
    }

    private c(Context context, b bVar, Resources resources) {
        this.f4195d = null;
        a aVar = new a();
        this.f4196e = aVar;
        this.f4194c = context;
        if (bVar != null) {
            this.f4193b = bVar;
        } else {
            this.f4193b = new b(context, bVar, aVar, resources);
        }
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f4193b.f4199b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        b bVar = this.f4193b;
        if (bVar.f4201d == null) {
            bVar.f4201d = new ArrayList<>();
            this.f4193b.f4202e = new c0.a<>();
        }
        this.f4193b.f4201d.add(animator);
        this.f4193b.f4202e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i10 = 0; i10 < childAnimations.size(); i10++) {
                c(childAnimations.get(i10));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f4195d == null) {
                    this.f4195d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f4195d);
            }
        }
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            return p0.a.b(drawable);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f4193b.f4199b.draw(canvas);
        if (this.f4193b.f4200c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f4208a;
        return drawable != null ? p0.a.d(drawable) : this.f4193b.f4199b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f4193b.f4198a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4208a;
        return drawable != null ? p0.a.e(drawable) : this.f4193b.f4199b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f4208a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0047c(this.f4208a.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f4193b.f4199b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f4193b.f4199b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.getOpacity() : this.f4193b.f4199b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = g.k(resources, theme, attributeSet, a.f4185e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i b10 = i.b(resources, resourceId, theme);
                        b10.h(false);
                        b10.setCallback(this.f4196e);
                        i iVar = this.f4193b.f4199b;
                        if (iVar != null) {
                            iVar.setCallback((Drawable.Callback) null);
                        }
                        this.f4193b.f4199b = b10;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.f4186f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f4194c;
                        if (context != null) {
                            b(string, e.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f4193b.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f4208a;
        return drawable != null ? p0.a.h(drawable) : this.f4193b.f4199b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f4208a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f4193b.f4200c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.isStateful() : this.f4193b.f4199b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4193b.f4199b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.setLevel(i10) : this.f4193b.f4199b.setLevel(i10);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.setState(iArr) : this.f4193b.f4199b.setState(iArr);
    }

    public void setAlpha(int i10) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f4193b.f4199b.setAlpha(i10);
        }
    }

    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.j(drawable, z10);
        } else {
            this.f4193b.f4199b.setAutoMirrored(z10);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4193b.f4199b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i10) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.n(drawable, i10);
        } else {
            this.f4193b.f4199b.setTint(i10);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.o(drawable, colorStateList);
        } else {
            this.f4193b.f4199b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.p(drawable, mode);
        } else {
            this.f4193b.f4199b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f4193b.f4199b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    public void start() {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f4193b.f4200c.isStarted()) {
            this.f4193b.f4200c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4193b.f4200c.end();
        }
    }
}
