package com.study.domain;


import lombok.Data;
import org.junit.jupiter.api.Tag;

import java.io.Serializable;



/**
* 
* @TableName User
*/
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String hobby;

}
