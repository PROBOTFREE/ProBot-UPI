package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.u;
import androidx.core.view.x;
import androidx.core.view.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
public abstract class v {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2901a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f2902b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f2903c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f2904d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f2905e;

        a(v vVar, int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f2901a = i10;
            this.f2902b = arrayList;
            this.f2903c = arrayList2;
            this.f2904d = arrayList3;
            this.f2905e = arrayList4;
        }

        public void run() {
            for (int i10 = 0; i10 < this.f2901a; i10++) {
                x.K0((View) this.f2902b.get(i10), (String) this.f2903c.get(i10));
                x.K0((View) this.f2904d.get(i10), (String) this.f2905e.get(i10));
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2906a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f2907b;

        b(v vVar, ArrayList arrayList, Map map) {
            this.f2906a = arrayList;
            this.f2907b = map;
        }

        public void run() {
            int size = this.f2906a.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) this.f2906a.get(i10);
                String M = x.M(view);
                if (M != null) {
                    x.K0(view, v.i(this.f2907b, M));
                }
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2908a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f2909b;

        c(v vVar, ArrayList arrayList, Map map) {
            this.f2908a = arrayList;
            this.f2909b = map;
        }

        public void run() {
            int size = this.f2908a.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) this.f2908a.get(i10);
                x.K0(view, (String) this.f2909b.get(x.M(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (!h(list, view, size)) {
            if (x.M(view) != null) {
                list.add(view);
            }
            for (int i10 = size; i10 < list.size(); i10++) {
                View view2 = list.get(i10);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (!h(list, childAt, size) && x.M(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (list.get(i11) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            if (str.equals(next.getValue())) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    /* access modifiers changed from: package-private */
    public void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            boolean z10 = view instanceof ViewGroup;
            ViewGroup viewGroup = view;
            if (z10) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                boolean a10 = z.a(viewGroup2);
                viewGroup = viewGroup2;
                if (!a10) {
                    int childCount = viewGroup2.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        f(arrayList, viewGroup2.getChildAt(i10));
                    }
                    return;
                }
            }
            arrayList.add(viewGroup);
        }
    }

    public abstract Object g(Object obj);

    /* access modifiers changed from: package-private */
    public void j(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String M = x.M(view);
            if (M != null) {
                map.put(M, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    j(map, viewGroup.getChildAt(i10));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k(View view, Rect rect) {
        if (x.U(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset((float) view.getLeft(), (float) view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                view2.getMatrix().mapRect(rectF);
                rectF.offset((float) view2.getLeft(), (float) view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset((float) iArr[0], (float) iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    /* access modifiers changed from: package-private */
    public ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = arrayList.get(i10);
            arrayList2.add(x.M(view));
            x.K0(view, (String) null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    /* access modifiers changed from: package-private */
    public void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        u.a(viewGroup, new c(this, arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, t0.b bVar, Runnable runnable) {
        runnable.run();
    }

    /* access modifiers changed from: package-private */
    public void x(View view, ArrayList<View> arrayList, Map<String, String> map) {
        u.a(view, new b(this, arrayList, map));
    }

    /* access modifiers changed from: package-private */
    public void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = arrayList.get(i10);
            String M = x.M(view2);
            arrayList4.add(M);
            if (M != null) {
                x.K0(view2, (String) null);
                String str = map.get(M);
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i11))) {
                        x.K0(arrayList2.get(i11), M);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        u.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}
