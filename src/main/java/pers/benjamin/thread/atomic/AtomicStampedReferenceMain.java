package pers.benjamin.thread.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceMain {

    public static void main(String[] args) {
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("sss", 1);

        int stamp = reference.getStamp();
        reference.compareAndSet("sss", "sss1", reference.getStamp(), reference.getStamp() + 1);

        System.out.println(reference.getReference() + "-" + reference.getStamp());

        reference.compareAndSet("sss1", "sss2", reference.getStamp(), reference.getStamp() + 1);

        System.out.println(reference.getReference() + "-" + reference.getStamp());

    }
}
