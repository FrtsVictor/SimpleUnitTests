package com.test.controller.Country;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StateRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StateRepository stateRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void testCreateState() {
        Country country = entityManager.persist(new Country("Brazil"));

        State state = stateRepository.save(new State("Rio de Janeiro", country));

        Assertions.assertThat(state).isNotNull();
        Assertions.assertThat(state.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void testInsertStateToRealDatabase() {
        Integer countryId = 1;
        Country country = entityManager.find(Country.class, countryId);

        State state = stateRepository.save(new State("Rio de Janeiro", country));

        Assertions.assertThat(state).isNotNull();
        Assertions.assertThat(state.getId()).isGreaterThan(0);


    }


}
