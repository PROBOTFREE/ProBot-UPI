package androidx.room;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import s1.a;
import s1.d;
import t1.b;
import t1.c;

class j implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3818a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3819b;

    /* renamed from: c  reason: collision with root package name */
    private final File f3820c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3821d;

    /* renamed from: e  reason: collision with root package name */
    private final c f3822e;

    /* renamed from: f  reason: collision with root package name */
    private a f3823f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3824g;

    j(Context context, String str, File file, int i10, c cVar) {
        this.f3818a = context;
        this.f3819b = str;
        this.f3820c = file;
        this.f3821d = i10;
        this.f3822e = cVar;
    }

    private void c(File file) {
        ReadableByteChannel readableByteChannel;
        if (this.f3819b != null) {
            readableByteChannel = Channels.newChannel(this.f3818a.getAssets().open(this.f3819b));
        } else if (this.f3820c != null) {
            readableByteChannel = new FileInputStream(this.f3820c).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f3818a.getCacheDir());
        createTempFile.deleteOnExit();
        d.a(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (!createTempFile.renameTo(file)) {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }

    private void f() {
        String databaseName = getDatabaseName();
        File databasePath = this.f3818a.getDatabasePath(databaseName);
        a aVar = this.f3823f;
        a aVar2 = new a(databaseName, this.f3818a.getFilesDir(), aVar == null || aVar.f3732j);
        try {
            aVar2.b();
            if (!databasePath.exists()) {
                c(databasePath);
                aVar2.c();
            } else if (this.f3823f == null) {
                aVar2.c();
            } else {
                try {
                    int c10 = s1.c.c(databasePath);
                    int i10 = this.f3821d;
                    if (c10 == i10) {
                        aVar2.c();
                    } else if (this.f3823f.a(c10, i10)) {
                        aVar2.c();
                    } else {
                        if (this.f3818a.deleteDatabase(databaseName)) {
                            try {
                                c(databasePath);
                            } catch (IOException e10) {
                                Log.w("ROOM", "Unable to copy database file.", e10);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        aVar2.c();
                    }
                } catch (IOException e11) {
                    Log.w("ROOM", "Unable to read database version.", e11);
                    aVar2.c();
                }
            }
        } catch (IOException e12) {
            throw new RuntimeException("Unable to copy database file.", e12);
        } catch (Throwable th) {
            aVar2.c();
            throw th;
        }
    }

    public synchronized void close() {
        this.f3822e.close();
        this.f3824g = false;
    }

    /* access modifiers changed from: package-private */
    public void d(a aVar) {
        this.f3823f = aVar;
    }

    public String getDatabaseName() {
        return this.f3822e.getDatabaseName();
    }

    public synchronized b getWritableDatabase() {
        if (!this.f3824g) {
            f();
            this.f3824g = true;
        }
        return this.f3822e.getWritableDatabase();
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f3822e.setWriteAheadLoggingEnabled(z10);
    }
}
