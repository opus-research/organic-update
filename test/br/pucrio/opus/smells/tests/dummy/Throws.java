package br.pucrio.opus.smells.tests.dummy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Throws {
    public void m1(String a) throws Exception {

    }

    public void m2() throws IllegalArgumentException, RuntimeException {

    }

    public void m3() {

    }

    public void m4() throws IllegalArgumentException, RuntimeException,
            IOException, FileAlreadyExistsException,
            FileNotFoundException {
    }
}