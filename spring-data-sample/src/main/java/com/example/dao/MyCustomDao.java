package com.example.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface MyCustomDao<CLASS,ID> extends Repository<CLASS,ID> {

    void save(CLASS entity);
}
