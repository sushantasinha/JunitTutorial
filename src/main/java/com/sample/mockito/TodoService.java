package com.sample.mockito;

import java.util.List;

// External Service - Lets say this comes from WunderList
public interface TodoService {
    List<String> retrieveTodos(String user);
}