package com.csgo.counter;

import com.csgo.entity.Event;

@FunctionalInterface
public interface ParameterizedCounter{

    int getCountValue(Event e);

}
