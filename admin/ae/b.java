package ae;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import mb.h;
import org.jetbrains.annotations.NotNull;
import vd.l;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f19123a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19124b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19125c;

    /* renamed from: d  reason: collision with root package name */
    private final List<l> f19126d;

    public b(@NotNull List<l> list) {
        h.e(list, "connectionSpecs");
        this.f19126d = list;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int size = this.f19126d.size();
        for (int i10 = this.f19123a; i10 < size; i10++) {
            if (this.f19126d.get(i10).e(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final l a(@NotNull SSLSocket sSLSocket) {
        l lVar;
        h.e(sSLSocket, "sslSocket");
        int i10 = this.f19123a;
        int size = this.f19126d.size();
        while (true) {
            if (i10 >= size) {
                lVar = null;
                break;
            }
            lVar = this.f19126d.get(i10);
            i10++;
            if (lVar.e(sSLSocket)) {
                this.f19123a = i10;
                break;
            }
        }
        if (lVar != null) {
            this.f19124b = c(sSLSocket);
            lVar.c(sSLSocket, this.f19125c);
            return lVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.f19125c);
        sb2.append(',');
        sb2.append(" modes=");
        sb2.append(this.f19126d);
        sb2.append(',');
        sb2.append(" supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        h.c(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        h.d(arrays, "java.util.Arrays.toString(this)");
        sb2.append(arrays);
        throw new UnknownServiceException(sb2.toString());
    }

    public final boolean b(@NotNull IOException iOException) {
        h.e(iOException, "e");
        this.f19125c = true;
        return this.f19124b && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException) && (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) && (iOException instanceof SSLException);
    }
}
