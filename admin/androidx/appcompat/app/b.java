package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

public class b extends e {

    /* renamed from: c  reason: collision with root package name */
    final AlertController f384c = new AlertController(getContext(), this, getWindow());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.f f385a;

        /* renamed from: b  reason: collision with root package name */
        private final int f386b;

        public a(Context context) {
            this(context, b.f(context, 0));
        }

        public a(Context context, int i10) {
            this.f385a = new AlertController.f(new ContextThemeWrapper(context, b.f(context, i10)));
            this.f386b = i10;
        }

        public b a() {
            b bVar = new b(this.f385a.f270a, this.f386b);
            this.f385a.a(bVar.f384c);
            bVar.setCancelable(this.f385a.f287r);
            if (this.f385a.f287r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f385a.f288s);
            bVar.setOnDismissListener(this.f385a.f289t);
            DialogInterface.OnKeyListener onKeyListener = this.f385a.f290u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public Context b() {
            return this.f385a.f270a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f385a;
            fVar.f292w = listAdapter;
            fVar.f293x = onClickListener;
            return this;
        }

        public a d(boolean z10) {
            this.f385a.f287r = z10;
            return this;
        }

        public a e(View view) {
            this.f385a.f276g = view;
            return this;
        }

        public a f(Drawable drawable) {
            this.f385a.f273d = drawable;
            return this;
        }

        public a g(CharSequence charSequence) {
            this.f385a.f277h = charSequence;
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f385a;
            fVar.f281l = charSequence;
            fVar.f283n = onClickListener;
            return this;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f385a;
            fVar.f284o = charSequence;
            fVar.f286q = onClickListener;
            return this;
        }

        public a j(DialogInterface.OnKeyListener onKeyListener) {
            this.f385a.f290u = onKeyListener;
            return this;
        }

        public a k(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f385a;
            fVar.f278i = charSequence;
            fVar.f280k = onClickListener;
            return this;
        }

        public a l(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f385a;
            fVar.f292w = listAdapter;
            fVar.f293x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }

        public a m(CharSequence charSequence) {
            this.f385a.f275f = charSequence;
            return this;
        }

        public b n() {
            b a10 = a();
            a10.show();
            return a10;
        }
    }

    protected b(Context context, int i10) {
        super(context, f(context, i10));
    }

    static int f(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(j.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f384c.d();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f384c.e();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f384c.g(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f384c.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f384c.q(charSequence);
    }
}
