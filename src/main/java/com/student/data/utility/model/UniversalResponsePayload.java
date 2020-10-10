package com.student.data.utility.model;

import lombok.Data;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 10/10/20 12:33 PM
 */
@Data
public class UniversalResponsePayload {

    private int status;
    private String message;
    private Object data;
}
