package org.example;

import org.example.dao.entity.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author puppet
 * @since 2022/3/28 16:17
 */
public class JPASimpleTest {
    
    @Test
    public void testSave() {
        // 加载配置文件，创建实体类管理器工厂，借助 Persistence 的静态方法获取
        // 入参为"持久化单元"名称，该名称在 JPA 核心配置文件中指定
        EntityManagerFactory demoJpa = Persistence.createEntityManagerFactory("demoJpa");
        // 通过工厂，创建实体管理类
        EntityManager entityManager = demoJpa.createEntityManager();
        // 获取事务对象
        EntityTransaction tx = entityManager.getTransaction();
        // 使用事务对象，保存实体对象数据
        tx.begin();
        Customer customer = new Customer();
        customer.setCustName("test");
        // 调用 persist() 方法，执行保存操作
        entityManager.persist(customer);
        tx.commit();
        // 释放资源
        entityManager.close();
        demoJpa.close();
    }
}
