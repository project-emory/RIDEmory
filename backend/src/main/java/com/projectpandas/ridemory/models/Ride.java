package com.projectpandas.ridemory.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("rides")
public class Ride {

    @Id
    private final String id;

    private final String messageID;
    private Location to;
    private Location from;
    private int people = 1;
    private long departTime;

    public Ride() {
        id = "test";
        messageID = "test";
        to = new Location("Hartsfield Jackson");
        from = new Location("Emory University ATL");
        people = 1;
        departTime = now();
    }

    public Ride(String id, String messageID) {
        this.id = id;
        this.messageID = messageID;
        to = new Location();
        from = new Location();
        people = 1;
        departTime = now();
    }

    public Ride(String id,
            String messageID,
            String to,
            String from) {
        this.id = id;
        this.messageID = messageID;
        this.to = new Location(to);
        this.from = new Location(from);
        this.departTime = now();
    }

    public Ride(String id,
            String messageID,
            String to,
            String from,
            long departTime) {
        this.id = id;
        this.messageID = messageID;
        this.to = new Location(to);
        this.from = new Location(from);
        this.departTime = departTime;
    }

    public Ride(String id,
            String messageID,
            Location to,
            Location from) {
        this.id = id;
        this.messageID = messageID;
        this.to = to;
        this.from = from;
        this.departTime = now();
    }

    public Ride(String id,
            String messageID,
            Location to,
            Location from,
            long departTime) {
        this.id = id;
        this.messageID = messageID;
        this.to = to;
        this.from = from;
        this.departTime = departTime;
    }

    /**
     * @return current unix epoch time
     */
    public static long now() {
        return System.currentTimeMillis() / 1000L; // get current unix epoch time
    }

    @Override
    public String toString() {
        return String.format(
                "{\"id\": \"%s\", \"messageId\": \"%s\", \"to\": %s, \"from\": %s, \"people\": %s, \"departTime\": %s}",
                id, messageID, to, from, people, departTime);
    }

}
