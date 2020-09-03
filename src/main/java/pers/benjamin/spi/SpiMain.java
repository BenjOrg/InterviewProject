package pers.benjamin.spi;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

public class SpiMain {
    public static void main(String[] args) {

        ServiceLoader<SpiCommon> commons = ServiceLoader.load(SpiCommon.class);

        Optional<SpiCommon> spi = StreamSupport.stream(commons.spliterator(), false).findFirst();

        SpiCommon res = spi.isPresent() ? spi.get() : new TwoSpi();


        System.out.println(res.doSpi());

    }
}
