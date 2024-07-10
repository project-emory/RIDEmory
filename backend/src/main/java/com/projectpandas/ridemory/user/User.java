package com.projectpandas.ridemory.user;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projectpandas.ridemory.util.ObjectIdSerializer;

import lombok.Data;

@Document("users")
@Data
public class User {
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    // TODO: Implement verification for phone and groupme before setting them
    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private String firstName;
    /** Must be first.last#@emory.edu */
    private String email;
    /** If user's email has been verified. */
    private boolean verified;
    private String phone;
    private String groupMeId;
    private List<ObjectId> rides;

    /** Default constructor for MongoDB */
    public User() {
        super();
    }

    /**
     * Creates a new user with the given email. Intended for use with user sign-up.
     * sign-up.
     *
     * @param email user's Emory email
     */
    public User(String email) {
        email = email.toLowerCase();
        if (!isEmoryEmail(email))
            logger.error("Invalid email", new IllegalArgumentException());

        this.firstName = email.split("[.]")[0];
        this.email = email;
        this.verified = false;
        this.phone = null;
        this.groupMeId = null;
        this.rides = new ArrayList<>();
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public void verifyEmail() {
        this.verified = true;
    }

    public List<ObjectId> getRides() {
        return rides;
    }

    public static boolean isEmoryEmail(String email) {
        return email != null && email.matches("^([a-z\\-]+)[.]([a-z\\-]+)[0-9]*@emory[.]edu$");
    }
}
