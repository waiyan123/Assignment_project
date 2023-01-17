package com.tunity.assignment.data.database.room.entity;

import java.io.Serializable;

public class SourceLocal implements Serializable {
    public String id;
    public String name;

    public SourceLocal(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
