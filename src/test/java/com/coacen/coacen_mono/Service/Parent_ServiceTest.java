package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.Parent;
import com.coacen.coacen_mono.Error_Control.Exceptions.parentNotFoundException;
import com.coacen.coacen_mono.Repository.Parent_Repository;
import jakarta.validation.constraints.Max;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Parent_ServiceTest
{
    @Autowired
    Parent_Service parentService;

    @MockBean
    Parent_Repository parentRepository;

    Parent parent;
    @BeforeEach
    public void setup()
    {
        parent=Parent.builder()
                .parent_first_name("Ramesh")
                .parent_email("ramesh@gmail.com")
                .parent_last_name("Aravind")
                .parent_mobile("1234567890")
                .parent_id(1)
                .build();
        Mockito.when(parentRepository.findById(parent.getParent_id())).thenReturn(Optional.ofNullable(parent));
        Mockito.when(parentRepository.save(parent)).thenReturn(parent);
    }

    @Test @DisplayName("Save Parent")
    void  whenValidPArentIdReturnParent() throws parentNotFoundException
    {
        Parent created_parent=parentService.create_parent(parent);
        assertEquals(parent,parent);
    }
    @Test @DisplayName("Update Parent by id")
    void  updateParentByParentIdTest() throws parentNotFoundException
    {
        String firstName="DIvakar";
        parent.setParent_first_name(firstName);
        Parent update_parent=parentRepository.save(parent);
        assertEquals(parent,update_parent);
    }
    @Test() @DisplayName("Failure to get Parent by id")
    void  failureToGetParentByParentIdTest() throws parentNotFoundException
    {
        parentNotFoundException exception = assertThrows(parentNotFoundException.class, () ->
                parentService.get_parent_byId(2));
        assertEquals("The said parentId is not available",exception.getMessage());
    }
    @Test() @DisplayName("Failure to Update Parent by id")
    void  failureToUpdateParentByParentIdTest() throws parentNotFoundException
    {
        parent.setParent_id(2);
        parentNotFoundException exception = assertThrows(parentNotFoundException.class, () ->
                parentService.update_parent_by_id(2,parent));
        assertEquals("Parent id is not found",exception.getMessage());
    }

}