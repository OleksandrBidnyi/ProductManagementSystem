package com.management.product.service;

import com.management.product.entity.Model;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by Aleksandr on 08.09.2017.
 */
public abstract class DataServiceImplTest<T extends Model> {

    private DataService<T> dataService;

    @Before
    public void initialize() {
        dataService = getService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAndGetTest() throws Exception {
        T object = getObject();
        object = dataService.add(object);
        assertEquals(object, dataService.get(object.getId()));
        assertFalse(dataService.get(1L).equals(null));
        dataService.add(null);
    }

    @Test
    public void updateTest() throws Exception {
        Long idOfUpdateObject = 1L;
        T objectBeforeUpdate = dataService.get(idOfUpdateObject);
        T changedObject = getObject();
        changedObject.setId(idOfUpdateObject);
        dataService.update(changedObject);
        assertFalse(objectBeforeUpdate.equals(changedObject));
        assertEquals(dataService.get(idOfUpdateObject), changedObject);
    }

    @Test
    public void AddAllTest() throws Exception {
        Collection<T> collection = getObjects();
        collection = dataService.addAll(collection);
        for (T object : collection) {
            assertEquals(object, dataService.get(object.getId()));
        }
        assertTrue(dataService.addAll(null).size() == 0);
    }

    @Test
    public void updateAllTest() throws Exception {
        Collection<T> collection = new HashSet<T>();
        for (int i = 1; i < 3; i++) {
            T object = getObject();
            object.setId(i);
            collection.add(object);
        }
        dataService.updateAll(collection);
        for (T object : collection) {
            assertEquals(object, dataService.get(object.getId()));
        }
    }

    @Test
    public void removeTest() throws Exception {
        Long id = 1L;
        T object = dataService.get(id);
        dataService.remove(id);
        assertFalse(object.equals(dataService.get(id)));

        dataService.add(object);
        assertEquals(object, equals(dataService.get(id)));

        dataService.remove(object);
        assertFalse(object.equals(dataService.get(id)));

        Collection<T> collection = dataService.getAll();
        dataService.removeAll();
        assertTrue(dataService.getAll().isEmpty());

        dataService.addAll(collection);
    }

    @Test
    public void existTest() throws Exception {
        T object = getObject();
        assertFalse(dataService.exist(object));
        object = dataService.get(1L);
        assertTrue(dataService.exist(object));
        assertFalse(dataService.exist(99999999L));
        assertTrue(dataService.exist(1L));
    }

    protected abstract DataService<T> getService();

    protected abstract T getObject();

    protected abstract Collection<T> getObjects();
}