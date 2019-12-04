package com.stays.hotelmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@NoRepositoryBean
public interface GenericRepository<T,K> extends JpaRepository<T, K> {

    @Override
    List<T> findAllById(Iterable<K> iterable);

    @Override
    Optional<T> findById(K id);

    @Override
    <S extends T> S save(S s);

    @Override
    void delete(T t);

    @Override
    void deleteById(K id);

}
