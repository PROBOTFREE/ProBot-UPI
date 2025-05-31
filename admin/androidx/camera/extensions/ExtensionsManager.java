package androidx.camera.extensions;

public final class ExtensionsManager {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1263a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ExtensionsManager f1264b;

    enum ExtensionsAvailability {
        LIBRARY_AVAILABLE,
        LIBRARY_UNAVAILABLE_ERROR_LOADING,
        LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION,
        NONE
    }

    private ExtensionsManager(ExtensionsAvailability extensionsAvailability) {
    }

    static ExtensionsManager a(ExtensionsAvailability extensionsAvailability) {
        synchronized (f1263a) {
            ExtensionsManager extensionsManager = f1264b;
            if (extensionsManager != null) {
                return extensionsManager;
            }
            ExtensionsManager extensionsManager2 = new ExtensionsManager(extensionsAvailability);
            f1264b = extensionsManager2;
            return extensionsManager2;
        }
    }
}
