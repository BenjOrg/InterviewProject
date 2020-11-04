package pers.benjamin.spi;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * 使用SPI代替Class.forName加载驱动
 *
 * SPI缺点：在查找具体实现到时候，会遍历所有实现类并实例化
 * 
 * @author benjamin
 * @date 2020/9/16 9:27 AM
 */
public class SpiMain {
    public static void main(String[] args) {

        // ServiceLoader JDK查找实现类的工具类
        ServiceLoader<SpiCommon> commons = ServiceLoader.load(SpiCommon.class);

        // 根据META-INF中的文件，加载实现类
        StreamSupport.stream(commons.spliterator(), false).forEach(t -> System.out.println(t.getClass()));

        Optional<SpiCommon> spi = StreamSupport.stream(commons.spliterator(), false).findFirst();

        SpiCommon res = spi.orElseGet(TwoSpi::new);


        System.out.println(res.doSpi());

    }
}
