package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.Parent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Parent_Service
{

    Parent create_parent(Parent parent);

    List<Parent> get_all_parents();

    Optional<Parent> get_parent_byId(int parent_id);

    Parent update_parent_by_id(int parentId,Parent parent) throws Exception;

    Boolean delete_parent_by_id(int parentId);
}
