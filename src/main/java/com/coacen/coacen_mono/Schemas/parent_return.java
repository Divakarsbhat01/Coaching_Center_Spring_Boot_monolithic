package com.coacen.coacen_mono.Schemas;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class parent_return
{
    String parent_first_name;
    String parent_last_name;

    public parent_return(String parent_first_name,String parent_last_name )
    {
        this.parent_first_name=parent_first_name;
        this.parent_last_name=parent_last_name;
    }

    public String getParent_first_name() {
        return parent_first_name;
    }

    public void setParent_first_name(String parent_first_name) {
        this.parent_first_name = parent_first_name;
    }

    public String getParent_last_name() {
        return parent_last_name;
    }

    public void setParent_last_name(String parent_last_name) {
        this.parent_last_name = parent_last_name;
    }
}
