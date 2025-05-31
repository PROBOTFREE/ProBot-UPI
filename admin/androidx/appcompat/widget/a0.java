package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import j.f;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;
import z0.c;

class a0 extends c implements View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    private final SearchView f1025l;

    /* renamed from: m  reason: collision with root package name */
    private final SearchableInfo f1026m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f1027n;

    /* renamed from: o  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1028o;

    /* renamed from: p  reason: collision with root package name */
    private final int f1029p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1030q = false;

    /* renamed from: r  reason: collision with root package name */
    private int f1031r = 1;

    /* renamed from: s  reason: collision with root package name */
    private ColorStateList f1032s;

    /* renamed from: t  reason: collision with root package name */
    private int f1033t = -1;

    /* renamed from: u  reason: collision with root package name */
    private int f1034u = -1;

    /* renamed from: v  reason: collision with root package name */
    private int f1035v = -1;

    /* renamed from: w  reason: collision with root package name */
    private int f1036w = -1;

    /* renamed from: x  reason: collision with root package name */
    private int f1037x = -1;

    /* renamed from: y  reason: collision with root package name */
    private int f1038y = -1;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1039a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1040b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1041c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1042d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1043e;

        public a(View view) {
            this.f1039a = (TextView) view.findViewById(16908308);
            this.f1040b = (TextView) view.findViewById(16908309);
            this.f1041c = (ImageView) view.findViewById(16908295);
            this.f1042d = (ImageView) view.findViewById(16908296);
            this.f1043e = (ImageView) view.findViewById(f.edit_query);
        }
    }

    public a0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1025l = searchView;
        this.f1026m = searchableInfo;
        this.f1029p = searchView.getSuggestionCommitIconResId();
        this.f1027n = context;
        this.f1028o = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1028o.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = this.f1028o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f1032s == null) {
            TypedValue typedValue = new TypedValue();
            this.f1027n.getTheme().resolveAttribute(j.a.textColorSearchUrl, typedValue, true);
            this.f1032s = this.f1027n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1032s, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        String nameNotFoundException;
        PackageManager packageManager = this.f1027n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            nameNotFoundException = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
            Log.w("SuggestionsAdapter", nameNotFoundException);
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            nameNotFoundException = e10.toString();
        }
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1028o.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f1028o.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1027n.getResources());
        }
        Drawable m10 = m(componentName);
        if (m10 != null) {
            constantState = m10.getConstantState();
        }
        this.f1028o.put(flattenToShortString, constantState);
        return m10;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable n10 = n(this.f1026m.getSearchActivity());
        return n10 != null ? n10 : this.f1027n.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable q(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r7 = r6.r(r7)     // Catch:{ NotFoundException -> 0x0016 }
            return r7
        L_0x0016:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x002d:
            android.content.Context r3 = r6.f1027n     // Catch:{ FileNotFoundException -> 0x0085 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x006e
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0055 }
            r3.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0054
        L_0x0041:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0054:
            return r4
        L_0x0055:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x006d
        L_0x005a:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006d:
            throw r4     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006e:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.a0.q(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1027n.getPackageName() + "/" + parseInt;
            Drawable k10 = k(str2);
            if (k10 != null) {
                return k10;
            }
            Drawable f10 = androidx.core.content.a.f(this.f1027n, parseInt);
            A(str2, f10);
            return f10;
        } catch (NumberFormatException unused) {
            Drawable k11 = k(str);
            if (k11 != null) {
                return k11;
            }
            Drawable q10 = q(Uri.parse(str));
            A(str, q10);
            return q10;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable t(Cursor cursor) {
        int i10 = this.f1036w;
        if (i10 == -1) {
            return null;
        }
        Drawable s10 = s(cursor.getString(i10));
        return s10 != null ? s10 : p();
    }

    private Drawable u(Cursor cursor) {
        int i10 = this.f1037x;
        if (i10 == -1) {
            return null;
        }
        return s(cursor.getString(i10));
    }

    private static String w(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void a(Cursor cursor) {
        if (this.f1030q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1033t = cursor.getColumnIndex("suggest_text_1");
                this.f1034u = cursor.getColumnIndex("suggest_text_2");
                this.f1035v = cursor.getColumnIndex("suggest_text_2_url");
                this.f1036w = cursor.getColumnIndex("suggest_icon_1");
                this.f1037x = cursor.getColumnIndex("suggest_icon_2");
                this.f1038y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    public CharSequence c(Cursor cursor) {
        String o10;
        String o11;
        if (cursor == null) {
            return null;
        }
        String o12 = o(cursor, "suggest_intent_query");
        if (o12 != null) {
            return o12;
        }
        if (this.f1026m.shouldRewriteQueryFromData() && (o11 = o(cursor, "suggest_intent_data")) != null) {
            return o11;
        }
        if (!this.f1026m.shouldRewriteQueryFromText() || (o10 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o10;
    }

    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1025l.getVisibility() == 0 && this.f1025l.getWindowVisibility() == 0) {
            try {
                Cursor v10 = v(this.f1026m, charSequence2, 50);
                if (v10 != null) {
                    v10.getCount();
                    return v10;
                }
            } catch (RuntimeException e10) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e10);
            }
        }
        return null;
    }

    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i10 = this.f1038y;
        int i11 = i10 != -1 ? cursor.getInt(i10) : 0;
        if (aVar.f1039a != null) {
            z(aVar.f1039a, w(cursor, this.f1033t));
        }
        if (aVar.f1040b != null) {
            String w10 = w(cursor, this.f1035v);
            CharSequence l10 = w10 != null ? l(w10) : w(cursor, this.f1034u);
            if (TextUtils.isEmpty(l10)) {
                TextView textView = aVar.f1039a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1039a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1039a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1039a.setMaxLines(1);
                }
            }
            z(aVar.f1040b, l10);
        }
        ImageView imageView = aVar.f1041c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f1042d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i12 = this.f1031r;
        if (i12 == 2 || (i12 == 1 && (i11 & 1) != 0)) {
            aVar.f1043e.setVisibility(0);
            aVar.f1043e.setTag(aVar.f1039a.getText());
            aVar.f1043e.setOnClickListener(this);
            return;
        }
        aVar.f1043e.setVisibility(8);
    }

    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View g10 = g(this.f1027n, b(), viewGroup);
            if (g10 != null) {
                ((a) g10.getTag()).f1039a.setText(e10.toString());
            }
            return g10;
        }
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View h10 = h(this.f1027n, b(), viewGroup);
            if (h10 != null) {
                ((a) h10.getTag()).f1039a.setText(e10.toString());
            }
            return h10;
        }
    }

    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h10 = super.h(context, cursor, viewGroup);
        h10.setTag(new a(h10));
        ((ImageView) h10.findViewById(f.edit_query)).setImageResource(this.f1029p);
        return h10;
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1025l.U((CharSequence) tag);
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable r(Uri uri) {
        int i10;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1027n.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i10 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i10 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i10 != 0) {
                        return resourcesForApplication.getDrawable(i10);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* access modifiers changed from: package-private */
    public Cursor v(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f1027n.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public void x(int i10) {
        this.f1031r = i10;
    }
}
