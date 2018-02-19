package com.ubs.tiagoportela.messenger_ubs.validators;

import java.util.List;

public abstract class PatternValidator {

    public boolean validatePattern(String pattern, List<String> params) {
        return params.stream().allMatch(p -> p.matches(pattern));
    }
}
