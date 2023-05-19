package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.ModelABC.*;
import edu.umb.cs680.hw09.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelABCTest {

    @Test
    public void testPrinterSingletonClass() {
        Printer printer1 = Printer.getPrinter();
        Printer printer2 = Printer.getPrinter();
        assertSame(printer2, printer1);
    }

    @Test
    public void testPrinterNotNullClass() {
        Printer printer1 = Printer.getPrinter();
        assertNotNull(printer1);
    }

    @Test
    public void testPrintJobExecute() {
        PrintJob job = new PrintJob();
        job.execute();
    }

    @Test
    public void testModelABCForCorrectLogin() {

        ModelABC  printer = new ModelABC();

        try {
           printer.execute(new PrintJob(), new SecurityContext(new User()) ,new EncryptedString());
            assert(true); 
        } catch (RuntimeException e) {
            fail();
        }
        
    }

    @Test
    public void testModelABCForWrongLogin() {

        ModelABC  printer = new ModelABC();
        SecurityContext context = new SecurityContext(new User());

        try {
          printer.execute(new PrintJob(), context, null);
          assert(true);
        } catch ( RuntimeException e) {
            assertEquals("wrong password", e.getMessage()); 
        }
    }

}