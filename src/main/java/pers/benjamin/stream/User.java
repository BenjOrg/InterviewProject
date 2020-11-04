package pers.benjamin.stream;

import java.util.List;

public class User {

    private Long id;

    private String userName;

    private Integer age;

    private List<Certification> certList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Certification> getCertList() {
        return certList;
    }

    public void setCertList(List<Certification> certList) {
        this.certList = certList;
    }
}
