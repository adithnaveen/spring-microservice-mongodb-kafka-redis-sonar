package com.naveen.product.service.exception.model;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExceptionMessage {
    private Date timeStamp;
    private String message;
    private String exceptionDetails;

}
