package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g {

    /* renamed from: b  reason: collision with root package name */
    static HashMap<String, Constructor<? extends d>> f1530b;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, ArrayList<d>> f1531a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends d>> hashMap = new HashMap<>();
        f1530b = hashMap;
        try {
            hashMap.put("KeyAttribute", e.class.getConstructor(new Class[0]));
            f1530b.put("KeyPosition", h.class.getConstructor(new Class[0]));
            f1530b.put("KeyCycle", f.class.getConstructor(new Class[0]));
            f1530b.put("KeyTimeCycle", j.class.getConstructor(new Class[0]));
            f1530b.put("KeyTrigger", k.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e10) {
            Log.e("KeyFrames", "unable to load", e10);
        }
    }

    public g() {
    }

    public g(Context context, XmlPullParser xmlPullParser) {
        HashMap<String, a> hashMap;
        d dVar;
        Exception e10;
        d dVar2 = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (f1530b.containsKey(name)) {
                        try {
                            Constructor constructor = f1530b.get(name);
                            if (constructor != null) {
                                dVar = (d) constructor.newInstance(new Object[0]);
                                try {
                                    dVar.e(context, Xml.asAttributeSet(xmlPullParser));
                                    c(dVar);
                                } catch (Exception e11) {
                                    e10 = e11;
                                }
                                dVar2 = dVar;
                            } else {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                        } catch (Exception e12) {
                            Exception exc = e12;
                            dVar = dVar2;
                            e10 = exc;
                            Log.e("KeyFrames", "unable to create ", e10);
                            dVar2 = dVar;
                            eventType = xmlPullParser.next();
                        }
                    } else {
                        if (name.equalsIgnoreCase("CustomAttribute")) {
                            if (dVar2 != null) {
                                hashMap = dVar2.f1490e;
                                if (hashMap == null) {
                                }
                            }
                        } else if (!(!name.equalsIgnoreCase("CustomMethod") || dVar2 == null || (hashMap = dVar2.f1490e) == null)) {
                        }
                        a.i(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3) {
                    if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e13) {
            e13.printStackTrace();
        } catch (IOException e14) {
            e14.printStackTrace();
        }
    }

    public void a(m mVar) {
        ArrayList arrayList = this.f1531a.get(-1);
        if (arrayList != null) {
            mVar.b(arrayList);
        }
    }

    public void b(m mVar) {
        ArrayList arrayList = this.f1531a.get(Integer.valueOf(mVar.f1606c));
        if (arrayList != null) {
            mVar.b(arrayList);
        }
        ArrayList arrayList2 = this.f1531a.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f(((ConstraintLayout.LayoutParams) mVar.f1605b.getLayoutParams()).Y)) {
                    mVar.a(dVar);
                }
            }
        }
    }

    public void c(d dVar) {
        if (!this.f1531a.containsKey(Integer.valueOf(dVar.f1487b))) {
            this.f1531a.put(Integer.valueOf(dVar.f1487b), new ArrayList());
        }
        ArrayList arrayList = this.f1531a.get(Integer.valueOf(dVar.f1487b));
        if (arrayList != null) {
            arrayList.add(dVar);
        }
    }

    public ArrayList<d> d(int i10) {
        return this.f1531a.get(Integer.valueOf(i10));
    }
}
