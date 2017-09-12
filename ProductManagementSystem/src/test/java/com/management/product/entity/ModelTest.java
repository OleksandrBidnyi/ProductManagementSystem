package com.management.product.entity;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

/**
 * Created by Aleksandr on 07.09.2017.
 */
public class ModelTest {

    public class ModelWithImplementation extends Model{
        @Override
        public int hashCode() {
            return 0;
        }
    }

    @Test
    public void equals() throws Exception{
        Model model = new ModelWithImplementation();
        Model model1 = new ModelWithImplementation();
        Model model2 = new ModelWithImplementation();
        assertEquals(model, model);
        assertEquals(model, model1);
        assertEquals(model1, model);
        assertEquals(model1, model2);
        assertEquals(model, model2);
        assertFalse(model.equals(null));
        assertFalse(model.equals(new String()));
    }

    @Test
    public void toStringTest() throws Exception{
        Model model = mock(Model.class, CALLS_REAL_METHODS);
        model.setId(543);
        assertTrue(model.toString().contains("543"));
    }

    @Test
    public void setIdAndGetId() throws Exception{
        Model model = mock(Model.class, CALLS_REAL_METHODS);
        model.setId(345);
        assertEquals(345, model.getId());
    }
}