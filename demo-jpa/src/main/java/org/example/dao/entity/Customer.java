package org.example.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author puppet
 * @since 2022/3/28 15:07
 */
@Data
@Entity  // 声明实体类
@Table(name = "demo_customer")  // 建立实体类与表的映射关系
public class Customer implements Serializable {
    @Id  // 声明该属性为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 配置主键自动生成策略
    @Column(name = "cust_id")  // 对应数据表中的字段
    private Long custId;
    
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_source")
    private String custSource;
    @Column(name = "cust_industry")
    private String custIndustry;
    @Column(name = "cust_level")
    private String custLevel;
    @Column(name = "cust_address")
    private String custAddress;
    @Column(name = "cust_phone")
    private String custPhone;
}
