package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Parent_Repository extends JpaRepository<Parent,Integer>
{

}
