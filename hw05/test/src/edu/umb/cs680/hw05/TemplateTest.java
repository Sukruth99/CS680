package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.ModelABC.*;
import edu.umb.cs680.hw05.util.*;
import edu.umb.cs680.hw05.ModelXYZ.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @Test
    public void testModelABC() {

        ModelABC  printer = new ModelABC();
        printer.execute(null, new SecurityContext(new User()) ,new EncryptedString());
        assert(true);
    }

    @Test
    public void testModeXYZ() {

        ModelXYZ  printer = new ModelXYZ();
        printer.execute(null, null ,null);
        assert(true);
    }


}