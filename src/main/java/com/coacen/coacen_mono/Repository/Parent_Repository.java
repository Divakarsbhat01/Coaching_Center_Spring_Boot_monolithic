package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Parent;
import com.coacen.coacen_mono.Schemas.parent_return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Parent_Repository extends JpaRepository<Parent,Integer>
{
    @Query("select new com.coacen.coacen_mono.Schemas.parent_return(a.parent_first_name,a.parent_last_name) from Parent a ")
    public List<parent_return> returnAllParents();
}
