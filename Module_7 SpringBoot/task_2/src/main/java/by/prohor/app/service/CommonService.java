package by.prohor.app.service;

import java.util.List;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */


public interface CommonService<T> {

    T create(T entity);

    List<T> getAll();

    T findById(long id);

    void update(T entity);

    void delete(long id);

}
