package pers.benjamin.bloom;

import java.nio.charset.Charset;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterDemo {

    @SuppressWarnings("UnstableApiUsage")
    public static void main(String[] args) {
        BloomFilter<CharSequence> bloomFilter =
                        BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 100, 0.01D);
        bloomFilter.put("a");
        bloomFilter.put("b");

        System.out.println(bloomFilter.mightContain("a"));
    }
}
