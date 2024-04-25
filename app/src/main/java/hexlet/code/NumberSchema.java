package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    private Integer[] diapazon = new Integer[2];

    public NumberSchema() {
    }

    public NumberSchema required() {
        setRequired(true);
        addCheck("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", element -> {
            if (element == null) {
                return true;
            } else {
                return element >= 1;
            }
        });
        return this;
    }

    public NumberSchema range(int begin, int end) {
        this.diapazon[0] = begin;
        this.diapazon[1] = end;
        addCheck("range", element -> element != null && diapazon[0] != null && diapazon[1] != null
                && element >= diapazon[0] || element <= diapazon[1]);
        return this;
    }
}
