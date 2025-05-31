package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.navigation.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sqlcipher.database.SQLiteDatabase;

@q.b("activity")
public class a extends q<C0031a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f3110a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f3111b;

    /* renamed from: androidx.navigation.a$a  reason: collision with other inner class name */
    public static class C0031a extends i {

        /* renamed from: i  reason: collision with root package name */
        private Intent f3112i;

        /* renamed from: j  reason: collision with root package name */
        private String f3113j;

        public C0031a(q<? extends C0031a> qVar) {
            super((q<? extends i>) qVar);
        }

        public void A(Context context, AttributeSet attributeSet) {
            super.A(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, t.ActivityNavigator);
            String string = obtainAttributes.getString(t.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            O(string);
            String string2 = obtainAttributes.getString(t.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                L(new ComponentName(context, string2));
            }
            K(obtainAttributes.getString(t.ActivityNavigator_action));
            String string3 = obtainAttributes.getString(t.ActivityNavigator_data);
            if (string3 != null) {
                M(Uri.parse(string3));
            }
            N(obtainAttributes.getString(t.ActivityNavigator_dataPattern));
            obtainAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean F() {
            return false;
        }

        public final String G() {
            Intent intent = this.f3112i;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        public final ComponentName H() {
            Intent intent = this.f3112i;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        public final String I() {
            return this.f3113j;
        }

        public final Intent J() {
            return this.f3112i;
        }

        public final C0031a K(String str) {
            if (this.f3112i == null) {
                this.f3112i = new Intent();
            }
            this.f3112i.setAction(str);
            return this;
        }

        public final C0031a L(ComponentName componentName) {
            if (this.f3112i == null) {
                this.f3112i = new Intent();
            }
            this.f3112i.setComponent(componentName);
            return this;
        }

        public final C0031a M(Uri uri) {
            if (this.f3112i == null) {
                this.f3112i = new Intent();
            }
            this.f3112i.setData(uri);
            return this;
        }

        public final C0031a N(String str) {
            this.f3113j = str;
            return this;
        }

        public final C0031a O(String str) {
            if (this.f3112i == null) {
                this.f3112i = new Intent();
            }
            this.f3112i.setPackage(str);
            return this;
        }

        public String toString() {
            String G;
            ComponentName H = H();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            if (H != null) {
                sb2.append(" class=");
                G = H.getClassName();
            } else {
                G = G();
                if (G != null) {
                    sb2.append(" action=");
                }
                return sb2.toString();
            }
            sb2.append(G);
            return sb2.toString();
        }
    }

    public static final class b implements q.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f3114a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.app.b f3115b;

        public androidx.core.app.b a() {
            return this.f3115b;
        }

        public int b() {
            return this.f3114a;
        }
    }

    public a(Context context) {
        this.f3110a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f3111b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    public boolean e() {
        Activity activity = this.f3111b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    /* renamed from: f */
    public C0031a a() {
        return new C0031a(this);
    }

    /* access modifiers changed from: package-private */
    public final Context g() {
        return this.f3110a;
    }

    /* renamed from: h */
    public i b(C0031a aVar, Bundle bundle, n nVar, q.a aVar2) {
        Intent intent;
        int intExtra;
        if (aVar.J() != null) {
            Intent intent2 = new Intent(aVar.J());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String I = aVar.I();
                if (!TextUtils.isEmpty(I)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(I);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + I);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z10 = aVar2 instanceof b;
            if (z10) {
                intent2.addFlags(((b) aVar2).b());
            }
            if (!(this.f3110a instanceof Activity)) {
                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            if (nVar != null && nVar.g()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.f3111b;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", aVar.w());
            Resources resources = g().getResources();
            if (nVar != null) {
                int c10 = nVar.c();
                int d10 = nVar.d();
                if ((c10 <= 0 || !resources.getResourceTypeName(c10).equals("animator")) && (d10 <= 0 || !resources.getResourceTypeName(d10).equals("animator"))) {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", c10);
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", d10);
                } else {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(c10) + " and popExit resource " + resources.getResourceName(d10) + "when launching " + aVar);
                }
            }
            if (z10) {
                ((b) aVar2).a();
            }
            this.f3110a.startActivity(intent2);
            if (nVar == null || this.f3111b == null) {
                return null;
            }
            int a10 = nVar.a();
            int b10 = nVar.b();
            if ((a10 > 0 && resources.getResourceTypeName(a10).equals("animator")) || (b10 > 0 && resources.getResourceTypeName(b10).equals("animator"))) {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(a10) + " and exit resource " + resources.getResourceName(b10) + "when launching " + aVar);
                return null;
            } else if (a10 < 0 && b10 < 0) {
                return null;
            } else {
                this.f3111b.overridePendingTransition(Math.max(a10, 0), Math.max(b10, 0));
                return null;
            }
        } else {
            throw new IllegalStateException("Destination " + aVar.w() + " does not have an Intent set.");
        }
    }
}
