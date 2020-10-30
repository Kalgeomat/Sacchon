package gr.Pfizer.bootcamp3.team6.restapi.repository.lib;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;

import java.util.List;
import java.util.Optional;

public interface IRepository<T,K> {
    Optional<T> findById(K id) throws DeletedEntityException;
    List<T> findAll() ;
    Optional<T> save(T t) throws DeletedEntityException;
    boolean deleteById(K id) throws DeletedEntityException;
}
