package com.example.springboot;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Greeting {
    private String to;
    private String message;
    @Min(value = 10L)
    private int count;

    @AssertTrue(message = "message must not be empty if to is not empty.")
    public boolean getMessageNotEmptyIfToPresents() {

	if (to == null) {
	    return true;
	}

	return message != null;
    }
}
