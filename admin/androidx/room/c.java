package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.room.b;

public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: androidx.room.c$a$a  reason: collision with other inner class name */
        private static class C0039a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f3737a;

            C0039a(IBinder iBinder) {
                this.f3737a = iBinder;
            }

            public int D(b bVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f3737a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void S(int i10, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(i10);
                    obtain.writeStringArray(strArr);
                    this.f3737a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void X(b bVar, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i10);
                    this.f3737a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3737a;
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static c b0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0039a(iBinder) : (c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int D = D(b.a.b0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(D);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                X(b.a.b0(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                S(parcel.readInt(), parcel.createStringArray());
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
        }
    }

    int D(b bVar, String str);

    void S(int i10, String[] strArr);

    void X(b bVar, int i10);
}
