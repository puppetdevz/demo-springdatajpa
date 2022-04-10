package org.example;

import org.example.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * 测试 JPA 的复杂查询（JPQL）
 * @author puppet
 * @since 2022/3/31 14:11
 */
public class JPQLTest {
    /**
     * 查询全部
     */
    @Test
    public void testFindAll() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 根据 JPQL 语句创建 Query 对象
        String jpql = "from Customer";
        Query query = entityManager.createQuery(jpql);
        // 获取结果集列表
        List resultList = query.getResultList();
        for (Object customer : resultList) {
            System.out.println(customer);
        }
        transaction.commit();
        entityManager.close();
    }
    
    /**
     * 排序查询：根据 id 倒序查询出所有客户对象
     */
    @Test
    public void testFindAllOrdered() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 根据 JPQL 语句创建 Query 对象
        String jpql = "from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);
        // 获取结果集列表
        List resultList = query.getResultList();
        for (Object customer : resultList) {
            System.out.println(customer);
        }
        transaction.commit();
        entityManager.close();
    }
}
