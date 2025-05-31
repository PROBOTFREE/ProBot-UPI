package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.s;
import androidx.lifecycle.h;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int[] f2582a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f2583b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f2584c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f2585d;

    /* renamed from: e  reason: collision with root package name */
    final int f2586e;

    /* renamed from: f  reason: collision with root package name */
    final String f2587f;

    /* renamed from: g  reason: collision with root package name */
    final int f2588g;

    /* renamed from: h  reason: collision with root package name */
    final int f2589h;

    /* renamed from: i  reason: collision with root package name */
    final CharSequence f2590i;

    /* renamed from: j  reason: collision with root package name */
    final int f2591j;

    /* renamed from: k  reason: collision with root package name */
    final CharSequence f2592k;

    /* renamed from: l  reason: collision with root package name */
    final ArrayList<String> f2593l;

    /* renamed from: m  reason: collision with root package name */
    final ArrayList<String> f2594m;

    /* renamed from: n  reason: collision with root package name */
    final boolean f2595n;

    class a implements Parcelable.Creator<BackStackState> {
        a() {
        }

        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: b */
        public BackStackState[] newArray(int i10) {
            return new BackStackState[i10];
        }
    }

    public BackStackState(Parcel parcel) {
        this.f2582a = parcel.createIntArray();
        this.f2583b = parcel.createStringArrayList();
        this.f2584c = parcel.createIntArray();
        this.f2585d = parcel.createIntArray();
        this.f2586e = parcel.readInt();
        this.f2587f = parcel.readString();
        this.f2588g = parcel.readInt();
        this.f2589h = parcel.readInt();
        this.f2590i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2591j = parcel.readInt();
        this.f2592k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2593l = parcel.createStringArrayList();
        this.f2594m = parcel.createStringArrayList();
        this.f2595n = parcel.readInt() != 0;
    }

    public BackStackState(a aVar) {
        int size = aVar.f2821a.size();
        this.f2582a = new int[(size * 5)];
        if (aVar.f2827g) {
            this.f2583b = new ArrayList<>(size);
            this.f2584c = new int[size];
            this.f2585d = new int[size];
            int i10 = 0;
            int i11 = 0;
            while (i10 < size) {
                s.a aVar2 = aVar.f2821a.get(i10);
                int i12 = i11 + 1;
                this.f2582a[i11] = aVar2.f2838a;
                ArrayList<String> arrayList = this.f2583b;
                Fragment fragment = aVar2.f2839b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f2582a;
                int i13 = i12 + 1;
                iArr[i12] = aVar2.f2840c;
                int i14 = i13 + 1;
                iArr[i13] = aVar2.f2841d;
                int i15 = i14 + 1;
                iArr[i14] = aVar2.f2842e;
                iArr[i15] = aVar2.f2843f;
                this.f2584c[i10] = aVar2.f2844g.ordinal();
                this.f2585d[i10] = aVar2.f2845h.ordinal();
                i10++;
                i11 = i15 + 1;
            }
            this.f2586e = aVar.f2826f;
            this.f2587f = aVar.f2829i;
            this.f2588g = aVar.f2727t;
            this.f2589h = aVar.f2830j;
            this.f2590i = aVar.f2831k;
            this.f2591j = aVar.f2832l;
            this.f2592k = aVar.f2833m;
            this.f2593l = aVar.f2834n;
            this.f2594m = aVar.f2835o;
            this.f2595n = aVar.f2836p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public a a(FragmentManager fragmentManager) {
        a aVar = new a(fragmentManager);
        int i10 = 0;
        int i11 = 0;
        while (i10 < this.f2582a.length) {
            s.a aVar2 = new s.a();
            int i12 = i10 + 1;
            aVar2.f2838a = this.f2582a[i10];
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i11 + " base fragment #" + this.f2582a[i12]);
            }
            String str = this.f2583b.get(i11);
            aVar2.f2839b = str != null ? fragmentManager.h0(str) : null;
            aVar2.f2844g = h.c.values()[this.f2584c[i11]];
            aVar2.f2845h = h.c.values()[this.f2585d[i11]];
            int[] iArr = this.f2582a;
            int i13 = i12 + 1;
            int i14 = iArr[i12];
            aVar2.f2840c = i14;
            int i15 = i13 + 1;
            int i16 = iArr[i13];
            aVar2.f2841d = i16;
            int i17 = i15 + 1;
            int i18 = iArr[i15];
            aVar2.f2842e = i18;
            int i19 = iArr[i17];
            aVar2.f2843f = i19;
            aVar.f2822b = i14;
            aVar.f2823c = i16;
            aVar.f2824d = i18;
            aVar.f2825e = i19;
            aVar.f(aVar2);
            i11++;
            i10 = i17 + 1;
        }
        aVar.f2826f = this.f2586e;
        aVar.f2829i = this.f2587f;
        aVar.f2727t = this.f2588g;
        aVar.f2827g = true;
        aVar.f2830j = this.f2589h;
        aVar.f2831k = this.f2590i;
        aVar.f2832l = this.f2591j;
        aVar.f2833m = this.f2592k;
        aVar.f2834n = this.f2593l;
        aVar.f2835o = this.f2594m;
        aVar.f2836p = this.f2595n;
        aVar.x(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f2582a);
        parcel.writeStringList(this.f2583b);
        parcel.writeIntArray(this.f2584c);
        parcel.writeIntArray(this.f2585d);
        parcel.writeInt(this.f2586e);
        parcel.writeString(this.f2587f);
        parcel.writeInt(this.f2588g);
        parcel.writeInt(this.f2589h);
        TextUtils.writeToParcel(this.f2590i, parcel, 0);
        parcel.writeInt(this.f2591j);
        TextUtils.writeToParcel(this.f2592k, parcel, 0);
        parcel.writeStringList(this.f2593l);
        parcel.writeStringList(this.f2594m);
        parcel.writeInt(this.f2595n ? 1 : 0);
    }
}
