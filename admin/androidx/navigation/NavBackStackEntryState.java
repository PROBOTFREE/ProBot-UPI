package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

@SuppressLint({"BanParcelableUsage"})
final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final UUID f3089a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3090b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f3091c;

    /* renamed from: d  reason: collision with root package name */
    private final Bundle f3092d;

    class a implements Parcelable.Creator<NavBackStackEntryState> {
        a() {
        }

        /* renamed from: a */
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        /* renamed from: b */
        public NavBackStackEntryState[] newArray(int i10) {
            return new NavBackStackEntryState[i10];
        }
    }

    NavBackStackEntryState(Parcel parcel) {
        this.f3089a = UUID.fromString(parcel.readString());
        this.f3090b = parcel.readInt();
        this.f3091c = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.f3092d = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }

    NavBackStackEntryState(e eVar) {
        this.f3089a = eVar.f3132f;
        this.f3090b = eVar.b().w();
        this.f3091c = eVar.a();
        Bundle bundle = new Bundle();
        this.f3092d = bundle;
        eVar.g(bundle);
    }

    /* access modifiers changed from: package-private */
    public Bundle a() {
        return this.f3091c;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f3090b;
    }

    /* access modifiers changed from: package-private */
    public Bundle c() {
        return this.f3092d;
    }

    /* access modifiers changed from: package-private */
    public UUID d() {
        return this.f3089a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f3089a.toString());
        parcel.writeInt(this.f3090b);
        parcel.writeBundle(this.f3091c);
        parcel.writeBundle(this.f3092d);
    }
}
