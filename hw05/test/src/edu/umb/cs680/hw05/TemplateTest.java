package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.ModelABC.*;
import edu.umb.cs680.hw05.util.*;
import edu.umb.cs680.hw05.ModelXYZ.*;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

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

    @Test
    public void testModeXYZ() {

        ModelXYZ  printer = new ModelXYZ();
        try {
           printer.execute(new PrintJob(), new SecurityContext(new User()) ,new EncryptedString());
            assert(true); 
        } catch (RuntimeException e) {
            fail();
        }
        
    }


}