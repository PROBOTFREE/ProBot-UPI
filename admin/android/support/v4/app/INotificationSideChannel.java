package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface INotificationSideChannel extends IInterface {

    public static class Default implements INotificationSideChannel {
        public IBinder asBinder() {
            return null;
        }

        public void cancel(String str, int i10, String str2) {
        }

        public void cancelAll(String str) {
        }

        public void notify(String str, int i10, String str2, Notification notification) {
        }
    }

    public static abstract class Stub extends Binder implements INotificationSideChannel {
        private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        private static class Proxy implements INotificationSideChannel {
            public static INotificationSideChannel sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancel(String str, int i10, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().cancel(str, i10, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void cancelAll(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().cancelAll(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void notify(String str, int i10, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().notify(str, i10, str2, notification);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INotificationSideChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof INotificationSideChannel)) ? new Proxy(iBinder) : (INotificationSideChannel) queryLocalInterface;
        }

        public static INotificationSideChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(INotificationSideChannel iNotificationSideChannel) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iNotificationSideChannel == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iNotificationSideChannel;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                notify(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                cancelAll(parcel.readString());
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void cancel(String str, int i10, String str2);

    void cancelAll(String str);

    void notify(String str, int i10, String str2, Notification notification);
}
