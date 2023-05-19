package edu.umb.cs680.hw09.ModelABC;

public class Printer {

    public static Printer printer;

    private Printer() {
    }

    public static Printer getPrinter() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public void print() {
        System.out.println("Printer printing .............");
    }
}
