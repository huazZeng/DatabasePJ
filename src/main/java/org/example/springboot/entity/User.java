package org.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzz
 * @since 2024-05-20
 */
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Boolean isStudent;

    private String password;

    private String sId;

    private Integer age;

    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(Boolean isStudent) {
        this.isStudent = isStudent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
            "id = " + id +
            ", name = " + name +
            ", isStudent = " + isStudent +
            ", password = " + password +
            ", sId = " + sId +
            ", age = " + age +
            ", gender = " + gender +
        "}";
    }
}
