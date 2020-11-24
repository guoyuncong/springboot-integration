package com.hibernate.validator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ValidErrorData implements Serializable {
    private static final long serialVersionUID = 1835739336543582775L;

    private String field;
    private Object rejectValue;
    private String message;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ValidErrorData) {
            return ((ValidErrorData) obj).field.equalsIgnoreCase(field);
        }
        return false;
    }
}
