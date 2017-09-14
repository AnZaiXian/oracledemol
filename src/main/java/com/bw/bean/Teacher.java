package com.bw.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lenovo on 2017/8/1.
 */

@Entity
@Data
@Table(name="USERLOGIN")
public class Teacher implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String pwd;
}
