package gr.Pfizer.bootcamp3.team6.restapi.repository.lib;


import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public abstract class Repository<T, K> implements IRepository<T, K> {

    private EntityManager entityManager;

    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findById(K id){
        try {
            entityManager.getTransaction().begin();
            T t = entityManager.find(getEntityClass(), id);
            entityManager.getTransaction().commit();

            if(checkIfDeleted(t))
                throw new DeletedEntityException("This entity has been deleted.");

            return Optional.of(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    /**
     * The same method is used for insert and update
     *
     * @param t entity to be saved
     * @return the saved entity
     */
    @Override
    public Optional<T> save(T t) throws DeletedEntityException {
        if(checkIfDeleted(t))
            throw new DeletedEntityException("This entity has been deleted.");

        try {
            entityManager.getTransaction().begin(); //to transaction to xrisimopoioume otan kanoume allages
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery("from " + getEntityClassName(), getEntityClass());
        return query.getResultList();
    }


    public abstract Class<T> getEntityClass();

    public abstract String getEntityClassName();

    protected abstract boolean checkIfDeleted(T t);
    protected abstract void deleteEntity(T t);

    /**
     * Deleting a persistent instance
     *
     * @param id  primary key
     * @return success
     */
    @Override
    public boolean deleteById(K id) {
        T persistentInstance = entityManager.find(getEntityClass(), id);
        if (persistentInstance != null && !checkIfDeleted(persistentInstance)) {

            /*try {
                entityManager.getTransaction().begin();
                entityManager.remove(persistentInstance);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                //e.printStackTrace();
                return false;
            }*/
            deleteEntity(persistentInstance);

            return true;
        }
        return false;
    }
}
