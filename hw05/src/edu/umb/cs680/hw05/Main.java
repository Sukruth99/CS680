package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.ModelABC.*;
import edu.umb.cs680.hw05.util.*;

public class Main{

    public static void main(String[] args) {
        ModelABC printer = new ModelABC();
        printer.execute(null, new SecurityContext(new User()) ,new EncryptedString());
        
    }
    
}
