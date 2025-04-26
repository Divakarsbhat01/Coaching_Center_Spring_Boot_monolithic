package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Parent;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class Parent_RepositoryTest
{
    @Autowired
    Parent_Repository parentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    Parent parent;

    @BeforeEach
    void setup()
    {
        parent= Parent.builder()
                .parent_first_name("Ramesh")
                .parent_email("ramesh@gmail.com")
                .parent_last_name("Aravind")
                .parent_mobile("1234567890")
                .parent_id(1)
                .build();
        testEntityManager.persist(parent);
    }

    @Test()
    public void when_findById_returnParent()
    {
        Parent fetched_parent=parentRepository.findById(1).get();
        assertEquals(parent,fetched_parent);
    }
}