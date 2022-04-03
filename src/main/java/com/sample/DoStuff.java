package com.sample;

public class DoStuff {

    public int getResult(final int a, final int b) throws ServiceException {
        if(b == 0) {
            throw new ServiceException("This is an exception....");
        }
        return a/b;
    }
}
