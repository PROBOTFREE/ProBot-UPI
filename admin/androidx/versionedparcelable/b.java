package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import c0.a;
import java.lang.reflect.Method;

class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f4281d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f4282e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4283f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4284g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4285h;

    /* renamed from: i  reason: collision with root package name */
    private int f4286i;

    /* renamed from: j  reason: collision with root package name */
    private int f4287j;

    /* renamed from: k  reason: collision with root package name */
    private int f4288k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    private b(Parcel parcel, int i10, int i11, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f4281d = new SparseIntArray();
        this.f4286i = -1;
        this.f4287j = 0;
        this.f4288k = -1;
        this.f4282e = parcel;
        this.f4283f = i10;
        this.f4284g = i11;
        this.f4287j = i10;
        this.f4285h = str;
    }

    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f4282e.writeInt(bArr.length);
            this.f4282e.writeByteArray(bArr);
            return;
        }
        this.f4282e.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f4282e, 0);
    }

    public void E(int i10) {
        this.f4282e.writeInt(i10);
    }

    public void G(Parcelable parcelable) {
        this.f4282e.writeParcelable(parcelable, 0);
    }

    public void I(String str) {
        this.f4282e.writeString(str);
    }

    public void a() {
        int i10 = this.f4286i;
        if (i10 >= 0) {
            int i11 = this.f4281d.get(i10);
            int dataPosition = this.f4282e.dataPosition();
            this.f4282e.setDataPosition(i11);
            this.f4282e.writeInt(dataPosition - i11);
            this.f4282e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public a b() {
        Parcel parcel = this.f4282e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f4287j;
        if (i10 == this.f4283f) {
            i10 = this.f4284g;
        }
        int i11 = i10;
        return new b(parcel, dataPosition, i11, this.f4285h + "  ", this.f4278a, this.f4279b, this.f4280c);
    }

    public boolean g() {
        return this.f4282e.readInt() != 0;
    }

    public byte[] i() {
        int readInt = this.f4282e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f4282e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f4282e);
    }

    public boolean m(int i10) {
        while (this.f4287j < this.f4284g) {
            int i11 = this.f4288k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f4282e.setDataPosition(this.f4287j);
            int readInt = this.f4282e.readInt();
            this.f4288k = this.f4282e.readInt();
            this.f4287j += readInt;
        }
        return this.f4288k == i10;
    }

    public int o() {
        return this.f4282e.readInt();
    }

    public <T extends Parcelable> T q() {
        return this.f4282e.readParcelable(b.class.getClassLoader());
    }

    public String s() {
        return this.f4282e.readString();
    }

    public void w(int i10) {
        a();
        this.f4286i = i10;
        this.f4281d.put(i10, this.f4282e.dataPosition());
        E(0);
        E(i10);
    }

    public void y(boolean z10) {
        this.f4282e.writeInt(z10 ? 1 : 0);
    }
}
