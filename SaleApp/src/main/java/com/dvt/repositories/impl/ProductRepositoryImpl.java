/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvt.repositories.impl;

import com.dvt.pojo.Product;
import com.dvt.repositories.ProductRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    private static final int PAGE_SIZE = 6;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Product", Product.class);
        return q.getResultList();
//        CriteriaBuilder b = s.getCriteriaBuilder();
//        CriteriaQuery<Product> q = b.createQuery(Product.class);
//        Root root = q.from(Product.class);
//        q.select(root);
//
//        if (params != null) {
//            // filter data
//            List<Predicate> predicates = new ArrayList<>();
//
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
//            }
//
//            String fromPrice = params.get("fromPrice");
//            if (fromPrice != null && !fromPrice.isEmpty()) {
//                predicates.add(b.greaterThanOrEqualTo(root.get("price"), fromPrice));
//            }
//            
//            String toPrice = params.get("toPrice");
//            if (toPrice != null && !toPrice.isEmpty()) {
//                predicates.add(b.lessThanOrEqualTo(root.get("price"), toPrice));
//            }
//            
//            String cateId = params.get("cateId");
//            if (cateId != null && !cateId.isEmpty()) {
//                predicates.add(b.equal(root.get("category").as(Integer.class), cateId));
//            }
//            
//            q.where(predicates.toArray(Predicate[]::new));
//            
//            q.orderBy(b.desc(root.get(params.getOrDefault("sortBy", "id"))));
//        }
//        
//        Query query = s.createQuery(q);
//        
//        if (params != null) {
//            String page = params.get("page");
//            if (page != null) {
//                int start = (Integer.parseInt(page) -1 ) *  PAGE_SIZE;
//                query.setFirstResult(start);
//                query.setMaxResults(PAGE_SIZE);
//            }
//        }
//        return query.getResultList();
    }

}
