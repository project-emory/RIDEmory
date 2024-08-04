package com.projectpandas.ridemory.util.dto;

import lombok.Data;

/**
 * An object used to store user updates during transfer/serialization. The
 * ObjectId of the user should be passed in as a path variable.
 */
@Data
public class UserUpdateDto {
    private String firstName;
}
