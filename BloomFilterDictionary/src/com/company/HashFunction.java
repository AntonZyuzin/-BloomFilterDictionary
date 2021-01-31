package com.company;

import java.security.NoSuchAlgorithmException;

public interface HashFunction {
    String hash(String password) throws NoSuchAlgorithmException;
}
