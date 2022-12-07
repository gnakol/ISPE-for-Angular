package fr.kolie.ispe.catchup.methods;

import java.util.List;

public interface WebServices<T> {

    public List<T> listes();

    public void add(T e);

    public T update(int id_e, T e);

    public void remove(int id_e);

    public T getById(int id_e);

}
