package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final IntentSender f222a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f223b;

    /* renamed from: c  reason: collision with root package name */
    private final int f224c;

    /* renamed from: d  reason: collision with root package name */
    private final int f225d;

    class a implements Parcelable.Creator<IntentSenderRequest> {
        a() {
        }

        /* renamed from: a */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* renamed from: b */
        public IntentSenderRequest[] newArray(int i10) {
            return new IntentSenderRequest[i10];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private IntentSender f226a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f227b;

        /* renamed from: c  reason: collision with root package name */
        private int f228c;

        /* renamed from: d  reason: collision with root package name */
        private int f229d;

        public b(IntentSender intentSender) {
            this.f226a = intentSender;
        }

        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f226a, this.f227b, this.f228c, this.f229d);
        }

        public b b(Intent intent) {
            this.f227b = intent;
            return this;
        }

        public b c(int i10, int i11) {
            this.f229d = i10;
            this.f228c = i11;
            return this;
        }
    }

    IntentSenderRequest(IntentSender intentSender, Intent intent, int i10, int i11) {
        this.f222a = intentSender;
        this.f223b = intent;
        this.f224c = i10;
        this.f225d = i11;
    }

    IntentSenderRequest(Parcel parcel) {
        this.f222a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f223b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f224c = parcel.readInt();
        this.f225d = parcel.readInt();
    }

    public Intent a() {
        return this.f223b;
    }

    public int b() {
        return this.f224c;
    }

    public int c() {
        return this.f225d;
    }

    public IntentSender d() {
        return this.f222a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f222a, i10);
        parcel.writeParcelable(this.f223b, i10);
        parcel.writeInt(this.f224c);
        parcel.writeInt(this.f225d);
    }
}
