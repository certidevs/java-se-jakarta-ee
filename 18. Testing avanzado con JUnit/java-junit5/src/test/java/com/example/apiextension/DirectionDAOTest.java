package com.example.apiextension;

import com.example.demo.extensions.Direction;
import com.example.demo.extensions.DirectionDAO;
import com.example.demo.extensions.DirectionDAOImpl;
import com.example.demo.extensions.DirectionExistsException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(LifeCycleExtension.class)
@ExtendWith({DatabaseExtension.class})
@ExtendWith(DirectionDIExtension.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class DirectionDAOTest {


    DirectionDAO directionDAO;

    public DirectionDAOTest(DirectionDAO directionDAO) {
        this.directionDAO = directionDAO;
    }

    @Tag("controller")
    @Test
    @Order(2)
    @DisplayName("Insert direction OK")
    void test1() throws DirectionExistsException {

        Direction direction = new Direction(null, "calle falsa", "50001", "Madrid", "Spain");
        directionDAO.insert(direction);

        Direction directionDB = directionDAO.getById(1L);
        assertNotNull(directionDB);
        assertEquals(1L, directionDB.getId());
//        org.assertj.core.api.Assertions.assertThat()

    }

    @Tag("database")
    @Test
    @Order(1)
    @DisplayName("Insert direction without exception")
    void test2() throws DirectionExistsException {

        Direction direction = new Direction(null, "calle falsa", "50001", "Madrid", "Spain");

        assertDoesNotThrow(() -> directionDAO.insert(direction));

        Direction directionDB = directionDAO.getById(1L);
        assertNotNull(directionDB);
        assertEquals(1L, directionDB.getId());
    }
}
