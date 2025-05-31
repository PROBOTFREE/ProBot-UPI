package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import v1.c;

public final class InitializationProvider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    public String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            a.c(context).a();
            return true;
        }
        throw new c("Context cannot be null");
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
