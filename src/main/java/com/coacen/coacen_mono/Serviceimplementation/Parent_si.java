package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Parent;
import com.coacen.coacen_mono.Error_Control.Exceptions.parentNotFoundException;
import com.coacen.coacen_mono.Repository.Parent_Repository;
import com.coacen.coacen_mono.Schemas.parent_return;
import com.coacen.coacen_mono.Service.Parent_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Parent_si implements Parent_Service
{
    @Autowired
    Parent_Repository parentRepository;

    @CacheEvict(value = {"getAllParents","GetParentById"},allEntries = true)
    @Override
    public Parent create_parent(Parent parent)
    {
        return parentRepository.save(parent);
    }

    @Cacheable(value = "getAllParents")
    @Override
    public List<Parent> get_all_parents()
    {
        return parentRepository.findAll();
    }

    @Cacheable(value = "GetParentById")
    @Transactional
    @Override
    public Optional<Parent> get_parent_byId(int parent_id) throws parentNotFoundException {
        if(parentRepository.findById(parent_id).isPresent())
        {
            Parent x=parentRepository.findById(parent_id).get();
            return Optional.of(x);
        }
        else
        {
            throw new parentNotFoundException("The said parentId is not available");
        }
    }

    @CachePut(value = {"getAllParents","GetParentById"})
    @Transactional
    @Override
    public Parent update_parent_by_id(int parentId,Parent parent) throws Exception
    {
        if(parentRepository.findById(parentId).isPresent())
        {
            Parent x=parentRepository.getReferenceById(parentId);
            x.setParent_email(parent.getParent_email());
            x.setParent_mobile(parent.getParent_mobile());
            x.setParent_first_name(parent.getParent_first_name());
            x.setParent_last_name(parent.getParent_last_name());
            return parentRepository.save(x);
        }
        throw new parentNotFoundException("Parent id is not found");
    }

    @CacheEvict(value = {"getAllParents","GetParentById"},allEntries = true)
    @Transactional
    @Override
    public Boolean delete_parent_by_id(int parentId)
    {
        if (parentRepository.findById(parentId).isPresent())
        {
            parentRepository.deleteById(parentId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }

    public List<parent_return> return_all_parents()
    {
        return parentRepository.returnAllParents();
    }
}
