package com.stays.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface GenericRepository<T,Id> extends JpaRepository<T, Id> {

    @Override
    List<T> findAllById(Iterable<Id> iterable);

    @Override
    Optional<T> findById(Id id);

    @Override
    <S extends T> S save(S s);

    @Override
    void delete(T t);

    @Override
    void deleteById(Id id);

}
