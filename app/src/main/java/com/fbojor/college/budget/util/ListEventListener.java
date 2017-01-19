package com.fbojor.college.budget.util;

import java.util.List;


public interface ListEventListener<T> {
    void onSuccess(List<T> elements);
}
