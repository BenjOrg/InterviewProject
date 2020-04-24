package pers.benjamin.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceMain {
    public static void main(String[] args) {
        softFun();
        weakFun();
        phantomFun();
    }

    public static void softFun() {
        String s = new String("s");
        SoftReference<String> r = new SoftReference<>(s);
        s = null;
        System.gc();
        System.out.println(r.get());
    }

    public static void weakFun() {
        String s = new String("s");
        WeakReference<String> r = new WeakReference<>(s);
        s = null;
        System.gc();
        System.out.println(r.get());
    }

    public static void phantomFun() {
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        String s = new String("s");
        PhantomReference<String> r = new PhantomReference<>(s, queue);
        s = null;
        System.out.println(r.get());
    }
}
