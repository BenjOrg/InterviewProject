package pers.benjamin.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class StreamDemo {

    public List<User> userList = new ArrayList<>();

    public StreamDemo() {
        initialize();
    }

    private void initialize() {
        User user1 = new User();
        user1.setId(1L);
        user1.setAge(20);
        user1.setUserName("A");
        Certification certificationA1 = new Certification();
        certificationA1.setCertAuthority("AUTH-A");
        certificationA1.setCertName("CET-4");
        certificationA1.setGatherDate(LocalDate.of(2020, 1, 1));
        Certification certificationA2 = new Certification();
        certificationA2.setCertAuthority("AUTH-B");
        certificationA2.setCertName("CET-6");
        certificationA2.setGatherDate(LocalDate.of(2021, 1, 1));
        user1.setCertList(Arrays.asList(certificationA1, certificationA2));

        User user2 = new User();
        user2.setId(2L);
        user2.setAge(21);
        user2.setUserName("B");
        Certification certificationB1 = new Certification();
        certificationB1.setCertAuthority("AUTH-A");
        certificationB1.setCertName("CET-4");
        certificationB1.setGatherDate(LocalDate.of(2020, 1, 1));
        Certification certificationB2 = new Certification();
        certificationB2.setCertAuthority("AUTH-B");
        certificationB2.setCertName("CET-6");
        certificationB2.setGatherDate(LocalDate.of(2021, 1, 1));
        user2.setCertList(Arrays.asList(certificationB1, certificationB2));

        User user1x = new User();
        user1x.setId(1L);
        user1x.setAge(20);
        user1x.setUserName("A");
        Certification certificationA1x = new Certification();
        certificationA1x.setCertAuthority("AUTH-A");
        certificationA1x.setCertName("CET-4");
        certificationA1x.setGatherDate(LocalDate.of(2020, 1, 1));
        Certification certificationA2x = new Certification();
        certificationA2x.setCertAuthority("AUTH-C");
        certificationA2x.setCertName("CET-8");
        certificationA2x.setGatherDate(LocalDate.of(2021, 1, 1));
        user1x.setCertList(Arrays.asList(certificationA1x, certificationA2x));

        userList.add(user1);
        userList.add(user1x);
        userList.add(user2);
    }

    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();

        Map<Long, List<Certification>> map = streamDemo.userList.stream()
                        .collect(Collectors.groupingBy(User::getId,
                                        Collectors.mapping(User::getCertList,
                                                        Collectors.reducing(new ArrayList<>(), (t1, t2) -> Stream
                                                                        .concat(t1.stream(), t2.stream()).distinct()
                                                                        .collect(Collectors.toList())))));

        Map<Long, List<Certification>> map2 = streamDemo.userList.stream().collect(Collectors.toMap(User::getId,
                        User::getCertList,
                        (t1, t2) -> Stream.concat(t1.stream(), t2.stream()).distinct().collect(Collectors.toList())));

        System.out.println(JSONObject.toJSONString(map, SerializerFeature.PrettyFormat,
                        SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));

        System.out.println(JSONObject.toJSONString(map2, SerializerFeature.PrettyFormat,
                        SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));

    }
}
