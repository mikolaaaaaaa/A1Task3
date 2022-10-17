package com.mikola.a1task3.repository;

import com.mikola.a1task3.entity.Logins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoginsRepository extends JpaRepository<Logins, UUID> {

    <S extends Logins> S save(S entity);

    <S extends Logins> List<S> saveAll(Iterable<S> entities);

    Optional<Logins> findById(UUID uuid);

    List<Logins> findByAppAccountName(String name);



}
