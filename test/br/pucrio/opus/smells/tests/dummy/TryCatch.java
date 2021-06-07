package br.pucrio.opus.smells.tests.dummy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryCatch {

    public void m1() {

    }

    public void m21() {
        try {
            throw new IOException();
        } catch (IndexOutOfBoundsException e) {

        } catch (IOException e) {

        }
    }

    public void m22() {
        try {
            throw new IOException();
        } catch (IndexOutOfBoundsException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        }
    }

    // try with resources - no catch
    public String m23(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    public static int m24(boolean bVal) {
        try {
            if (bVal) {
                return 1;
            }
            return 0;
        } finally {
            System.out.println("Got old fashioned.");
        }
    }

    public void m31() {
        try {

            try {

            } catch(Exception e) {

            }

        } catch(Exception e) {

        }

        try {

        } catch(Exception e) {

        } finally {

        }
    }

    public void m41(){
        try {

            try {

            } catch(Exception e) {

            }

        } catch(Exception e) {

        }

        try {

        } catch(Exception e) {

        } finally {

        }
    }
    public void m51(boolean bVal) {
        try {
            if (bVal) {
                ;
            }
            ;
        } finally {
            System.out.println("Got old fashioned.");
        }

        try {
            if (bVal) {
                ;
            }
            ;
        } finally {
            System.out.println("Got old fashioned.");
        }
    }
    public void m61() {
        try {

            try {

            } catch(Exception e) {
                /**
                 *
                 */
            }

        } catch(Exception e) {
            var s = "";
            s.toString();
        }
    }

    public void m62() {
        try {

        } catch(Exception e) {
            e.printStackTrace();
            ;
            e.printStackTrace();
        }
    }

    public void m63() {
        try {

        } catch(Exception e) {
            System.out.println("Error here");
            System.err.println("Other message");
            System.out.print("TryCatch6.m3()");
        }
    }

    public void m64() {
        try {

        } catch(Exception e) {
            ;
            ;
            e.printStackTrace();
            System.out.println("Error here");
        }
    }

    public void m65() {
        try {

        } catch(Exception e) {
            ;
            ;
        }
    }

    public void m66() {
        try {

        } catch(Exception e) {
            ;
            System.out.println("");
            var s = "";
            s.toString();
        }
    }
}
