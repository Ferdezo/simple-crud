package com.arkadiusz.migala.simplecrud.output;

import java.util.Collection;
import java.util.List;

public interface OutputProducer<T> {
    T transform(T input);
    Collection<T> transformAll(Collection<T> inputs);
}
