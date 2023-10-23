package com.projectpandas.ridemory.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Ride {
    private final String id;
    private final String messageID;
    private String to;
    private String from;
    private String departTime;

    public Ride() {
        id = "NULL";
        messageID = "NULL";
        to = "NULL";
        from = "NULL";
        departTime = "NULL";
    }

    public Ride(String id,
            String messageID,
            String to,
            String from,
            String departTime) {
        this.id = id;
        this.messageID = messageID;
        this.to = to;
        this.from = from;
        this.departTime = departTime;
    }

    public Ride(String id, String messageID) {
        this.id = id;
        this.messageID = messageID;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nmessageID: " + messageID +
                "\nto: " + to +
                "\nfrom: " + from +
                "departTime: " + departTime;
    }
}
