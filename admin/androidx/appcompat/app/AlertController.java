package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.x;
import androidx.core.widget.NestedScrollView;
import j.j;
import java.lang.ref.WeakReference;

class AlertController {
    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final View.OnClickListener S = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f231a;

    /* renamed from: b  reason: collision with root package name */
    final e f232b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f233c;

    /* renamed from: d  reason: collision with root package name */
    private final int f234d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f235e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f236f;

    /* renamed from: g  reason: collision with root package name */
    ListView f237g;

    /* renamed from: h  reason: collision with root package name */
    private View f238h;

    /* renamed from: i  reason: collision with root package name */
    private int f239i;

    /* renamed from: j  reason: collision with root package name */
    private int f240j;

    /* renamed from: k  reason: collision with root package name */
    private int f241k;

    /* renamed from: l  reason: collision with root package name */
    private int f242l;

    /* renamed from: m  reason: collision with root package name */
    private int f243m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f244n = false;

    /* renamed from: o  reason: collision with root package name */
    Button f245o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f246p;

    /* renamed from: q  reason: collision with root package name */
    Message f247q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f248r;

    /* renamed from: s  reason: collision with root package name */
    Button f249s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f250t;

    /* renamed from: u  reason: collision with root package name */
    Message f251u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f252v;

    /* renamed from: w  reason: collision with root package name */
    Button f253w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f254x;

    /* renamed from: y  reason: collision with root package name */
    Message f255y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f256z;

    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f257a;

        /* renamed from: b  reason: collision with root package name */
        private final int f258b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.f258b = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.f257a = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z10, boolean z11) {
            if (!z11 || !z10) {
                setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f257a, getPaddingRight(), z11 ? getPaddingBottom() : this.f258b);
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            r3 = r0.f255y;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r1 = r0.f245o
                if (r3 != r1) goto L_0x000f
                android.os.Message r1 = r0.f247q
                if (r1 == 0) goto L_0x000f
            L_0x000a:
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x0026
            L_0x000f:
                android.widget.Button r1 = r0.f249s
                if (r3 != r1) goto L_0x0018
                android.os.Message r1 = r0.f251u
                if (r1 == 0) goto L_0x0018
                goto L_0x000a
            L_0x0018:
                android.widget.Button r1 = r0.f253w
                if (r3 != r1) goto L_0x0025
                android.os.Message r3 = r0.f255y
                if (r3 == 0) goto L_0x0025
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x0026
            L_0x0025:
                r3 = 0
            L_0x0026:
                if (r3 == 0) goto L_0x002b
                r3.sendToTarget()
            L_0x002b:
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Handler r0 = r3.R
                r1 = 1
                androidx.appcompat.app.e r3 = r3.f232b
                android.os.Message r3 = r0.obtainMessage(r1, r3)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.a.onClick(android.view.View):void");
        }
    }

    class b implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f260a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f261b;

        b(AlertController alertController, View view, View view2) {
            this.f260a = view;
            this.f261b = view2;
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            AlertController.f(nestedScrollView, this.f260a, this.f261b);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f263b;

        c(View view, View view2) {
            this.f262a = view;
            this.f263b = view2;
        }

        public void run() {
            AlertController.f(AlertController.this.A, this.f262a, this.f263b);
        }
    }

    class d implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f265a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f266b;

        d(AlertController alertController, View view, View view2) {
            this.f265a = view;
            this.f266b = view2;
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            AlertController.f(absListView, this.f265a, this.f266b);
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f268b;

        e(View view, View view2) {
            this.f267a = view;
            this.f268b = view2;
        }

        public void run() {
            AlertController.f(AlertController.this.f237g, this.f267a, this.f268b);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* renamed from: a  reason: collision with root package name */
        public final Context f270a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f271b;

        /* renamed from: c  reason: collision with root package name */
        public int f272c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f273d;

        /* renamed from: e  reason: collision with root package name */
        public int f274e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f275f;

        /* renamed from: g  reason: collision with root package name */
        public View f276g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f277h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f278i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f279j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f280k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f281l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f282m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f283n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f284o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f285p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f286q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f287r;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f288s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f289t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f290u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f291v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f292w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f293x;

        /* renamed from: y  reason: collision with root package name */
        public int f294y;

        /* renamed from: z  reason: collision with root package name */
        public View f295z;

        class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecycleListView f296a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f296a = recycleListView;
            }

            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i10]) {
                    this.f296a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* renamed from: a  reason: collision with root package name */
            private final int f298a;

            /* renamed from: b  reason: collision with root package name */
            private final int f299b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ RecycleListView f300c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AlertController f301d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f300c = recycleListView;
                this.f301d = alertController;
                Cursor cursor2 = getCursor();
                this.f298a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f299b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f298a));
                RecycleListView recycleListView = this.f300c;
                int position = cursor.getPosition();
                boolean z10 = true;
                if (cursor.getInt(this.f299b) != 1) {
                    z10 = false;
                }
                recycleListView.setItemChecked(position, z10);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f271b.inflate(this.f301d.M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AlertController f303a;

            c(AlertController alertController) {
                this.f303a = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                f.this.f293x.onClick(this.f303a.f232b, i10);
                if (!f.this.H) {
                    this.f303a.f232b.dismiss();
                }
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecycleListView f305a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AlertController f306b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f305a = recycleListView;
                this.f306b = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i10] = this.f305a.isItemChecked(i10);
                }
                f.this.J.onClick(this.f306b.f232b, i10, this.f305a.isItemChecked(i10));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f270a = context;
            this.f287r = true;
            this.f271b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$f$b] */
        /* JADX WARNING: type inference failed for: r1v25, types: [androidx.appcompat.app.AlertController$f$a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f271b
                int r1 = r11.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$f$a r9 = new androidx.appcompat.app.AlertController$f$a
                android.content.Context r3 = r10.f270a
                int r4 = r11.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f291v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$f$b r9 = new androidx.appcompat.app.AlertController$f$b
                android.content.Context r3 = r10.f270a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x003c
                int r1 = r11.N
                goto L_0x003e
            L_0x003c:
                int r1 = r11.O
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f270a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.f292w
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$h r9 = new androidx.appcompat.app.AlertController$h
                android.content.Context r1 = r10.f270a
                java.lang.CharSequence[] r3 = r10.f291v
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                androidx.appcompat.app.AlertController$f$e r1 = r10.O
                if (r1 == 0) goto L_0x0072
                r1.a(r0)
            L_0x0072:
                r11.H = r9
                int r1 = r10.I
                r11.I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f293x
                if (r1 == 0) goto L_0x0085
                androidx.appcompat.app.AlertController$f$c r1 = new androidx.appcompat.app.AlertController$f$c
                r1.<init>(r11)
            L_0x0081:
                r0.setOnItemClickListener(r1)
                goto L_0x008f
            L_0x0085:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L_0x008f
                androidx.appcompat.app.AlertController$f$d r1 = new androidx.appcompat.app.AlertController$f$d
                r1.<init>(r0, r11)
                goto L_0x0081
            L_0x008f:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                if (r1 == 0) goto L_0x0096
                r0.setOnItemSelectedListener(r1)
            L_0x0096:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x009e
                r0.setChoiceMode(r8)
                goto L_0x00a6
            L_0x009e:
                boolean r1 = r10.G
                if (r1 == 0) goto L_0x00a6
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a6:
                r11.f237g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.f.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f276g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f275f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f273d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i10 = this.f272c;
                if (i10 != 0) {
                    alertController.m(i10);
                }
                int i11 = this.f274e;
                if (i11 != 0) {
                    alertController.m(alertController.c(i11));
                }
            }
            CharSequence charSequence2 = this.f277h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f278i;
            if (!(charSequence3 == null && this.f279j == null)) {
                alertController.k(-1, charSequence3, this.f280k, (Message) null, this.f279j);
            }
            CharSequence charSequence4 = this.f281l;
            if (!(charSequence4 == null && this.f282m == null)) {
                alertController.k(-2, charSequence4, this.f283n, (Message) null, this.f282m);
            }
            CharSequence charSequence5 = this.f284o;
            if (!(charSequence5 == null && this.f285p == null)) {
                alertController.k(-3, charSequence5, this.f286q, (Message) null, this.f285p);
            }
            if (!(this.f291v == null && this.K == null && this.f292w == null)) {
                b(alertController);
            }
            View view2 = this.f295z;
            if (view2 == null) {
                int i12 = this.f294y;
                if (i12 != 0) {
                    alertController.r(i12);
                }
            } else if (this.E) {
                alertController.t(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.s(view2);
            }
        }
    }

    private static final class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f308a;

        public g(DialogInterface dialogInterface) {
            this.f308a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f308a.get(), message.what);
            } else if (i10 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, e eVar, Window window) {
        this.f231a = context;
        this.f232b = eVar;
        this.f233c = window;
        this.R = new g(eVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, j.AlertDialog, j.a.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        this.f234d = obtainStyledAttributes.getDimensionPixelSize(j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        eVar.d(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        int i10 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i10 = 4;
            }
            view3.setVisibility(i10);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i10 = this.K;
        return i10 == 0 ? this.J : this.Q == 1 ? i10 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f233c.findViewById(j.f.scrollIndicatorUp);
        View findViewById2 = this.f233c.findViewById(j.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            x.I0(view, i10, i11);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 == null) {
                return;
            }
        } else {
            if (findViewById != null && (i10 & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i10 & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById != null || findViewById2 != null) {
                if (this.f236f != null) {
                    this.A.setOnScrollChangeListener(new b(this, findViewById, findViewById2));
                    this.A.post(new c(findViewById, findViewById2));
                    return;
                }
                ListView listView = this.f237g;
                if (listView != null) {
                    listView.setOnScrollListener(new d(this, findViewById, findViewById2));
                    this.f237g.post(new e(findViewById, findViewById2));
                    return;
                }
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (findViewById2 == null) {
                    return;
                }
            } else {
                return;
            }
        }
        viewGroup.removeView(findViewById2);
    }

    private void u(ViewGroup viewGroup) {
        boolean z10;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(16908313);
        this.f245o = button2;
        button2.setOnClickListener(this.S);
        boolean z11 = true;
        if (!TextUtils.isEmpty(this.f246p) || this.f248r != null) {
            this.f245o.setText(this.f246p);
            Drawable drawable = this.f248r;
            if (drawable != null) {
                int i10 = this.f234d;
                drawable.setBounds(0, 0, i10, i10);
                this.f245o.setCompoundDrawables(this.f248r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f245o.setVisibility(0);
            z10 = true;
        } else {
            this.f245o.setVisibility(8);
            z10 = false;
        }
        Button button3 = (Button) viewGroup.findViewById(16908314);
        this.f249s = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f250t) || this.f252v != null) {
            this.f249s.setText(this.f250t);
            Drawable drawable2 = this.f252v;
            if (drawable2 != null) {
                int i11 = this.f234d;
                drawable2.setBounds(0, 0, i11, i11);
                this.f249s.setCompoundDrawables(this.f252v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f249s.setVisibility(0);
            z10 |= true;
        } else {
            this.f249s.setVisibility(8);
        }
        Button button4 = (Button) viewGroup.findViewById(16908315);
        this.f253w = button4;
        button4.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f254x) || this.f256z != null) {
            this.f253w.setText(this.f254x);
            Drawable drawable3 = this.f256z;
            if (drawable3 != null) {
                int i12 = this.f234d;
                drawable3.setBounds(0, 0, i12, i12);
                this.f253w.setCompoundDrawables(this.f256z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f253w.setVisibility(0);
            z10 |= true;
        } else {
            this.f253w.setVisibility(8);
        }
        if (z(this.f231a)) {
            if (z10) {
                button = this.f245o;
            } else if (z10) {
                button = this.f249s;
            } else if (z10) {
                button = this.f253w;
            }
            b(button);
        }
        if (!z10) {
            z11 = false;
        }
        if (!z11) {
            viewGroup.setVisibility(8);
        }
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f233c.findViewById(j.f.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f236f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f237g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f237g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f238h;
        boolean z10 = false;
        if (view == null) {
            view = this.f239i != 0 ? LayoutInflater.from(this.f231a).inflate(this.f239i, viewGroup, false) : null;
        }
        if (view != null) {
            z10 = true;
        }
        if (!z10 || !a(view)) {
            this.f233c.setFlags(131072, 131072);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) this.f233c.findViewById(j.f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f244n) {
                frameLayout.setPadding(this.f240j, this.f241k, this.f242l, this.f243m);
            }
            if (this.f237g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f233c.findViewById(j.f.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f233c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f235e)) || !this.P) {
            this.f233c.findViewById(j.f.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f233c.findViewById(j.f.alertTitle);
        this.E = textView;
        textView.setText(this.f235e);
        int i10 = this.B;
        if (i10 != 0) {
            this.D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }

    private void y() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f233c.findViewById(j.f.parentPanel);
        int i10 = j.f.topPanel;
        View findViewById4 = findViewById3.findViewById(i10);
        int i11 = j.f.contentPanel;
        View findViewById5 = findViewById3.findViewById(i11);
        int i12 = j.f.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(j.f.customPanel);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i10);
        View findViewById8 = viewGroup.findViewById(i11);
        View findViewById9 = viewGroup.findViewById(i12);
        ViewGroup i13 = i(findViewById7, findViewById4);
        ViewGroup i14 = i(findViewById8, findViewById5);
        ViewGroup i15 = i(findViewById9, findViewById6);
        v(i14);
        u(i15);
        x(i13);
        char c10 = 0;
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (i13 == null || i13.getVisibility() == 8) ? false : true;
        boolean z12 = (i15 == null || i15.getVisibility() == 8) ? false : true;
        if (!(z12 || i14 == null || (findViewById2 = i14.findViewById(j.f.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z11) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f236f == null && this.f237g == null)) {
                view = i13.findViewById(j.f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(i14 == null || (findViewById = i14.findViewById(j.f.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f237g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view2 = this.f237g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z12) {
                    c10 = 2;
                }
                p(i14, view2, z11 | c10 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f237g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i16 = this.I;
            if (i16 > -1) {
                listView2.setItemChecked(i16, true);
                listView2.setSelection(i16);
            }
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(j.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f231a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f237g;
    }

    public void e() {
        this.f232b.setContentView(j());
        y();
    }

    public boolean g(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public void k(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f254x = charSequence;
            this.f255y = message;
            this.f256z = drawable;
        } else if (i10 == -2) {
            this.f250t = charSequence;
            this.f251u = message;
            this.f252v = drawable;
        } else if (i10 == -1) {
            this.f246p = charSequence;
            this.f247q = message;
            this.f248r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i10) {
        this.C = null;
        this.B = i10;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i10 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void o(CharSequence charSequence) {
        this.f236f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f235e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i10) {
        this.f238h = null;
        this.f239i = i10;
        this.f244n = false;
    }

    public void s(View view) {
        this.f238h = view;
        this.f239i = 0;
        this.f244n = false;
    }

    public void t(View view, int i10, int i11, int i12, int i13) {
        this.f238h = view;
        this.f239i = 0;
        this.f244n = true;
        this.f240j = i10;
        this.f241k = i11;
        this.f242l = i12;
        this.f243m = i13;
    }
}
