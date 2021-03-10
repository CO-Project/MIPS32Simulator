package mips;

import java.io.File;
import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Simulator {
    
    private Processor processor;
    private Memory memory;
    private Register register;
    private Parser parser;
    private String instructionRegister;

    
    public Simulator (File inputFile) {
        processor = Processor.getInstance();
        memory    = Memory.getInstance();
        register  = Register.getInstance();
        parser    = new Parser(inputFile);

        instructionRegister = "";
    }
   

    public void print(String[] instruction) {
        System.out.println();

        System.out.println(instruction[1]);
        System.out.println(instruction[0]);
        System.out.println();

        System.out.println(register);
        System.out.println();

        System.out.println("------------------------------------------------------------------------------------");

        System.out.println();
        
        
    }
    
    public static void display(Register r,Parser p) {
    	GUI gui= new GUI(r.registers,p.getData(),32,1024);
        gui.display(r.registers,p.getData(),32,1024);
    }

    public void startSimulation () {
        
        String[] instruction;
        int[] registerInstruction;
        int[] previousInstruction = null;
        
        while ((instruction = parser.nextInstruction()) != null) {
           
            instructionRegister = memory.loadInstruction(instruction[0]);
            registerInstruction = parser.decodeInstruction(instructionRegister);
            final String[] instructionTemp = instruction;
            final int[] registerInstructionTemp = registerInstruction;

            if (registerInstruction[0] == 2) {
               
                parser.jumpTo(processor.executeInstruction(registerInstruction, parser.datasegment));
                previousInstruction = null;
                continue;
            }

  
                int address = processor.executeInstruction(registerInstructionTemp, parser.datasegment);
               
                if (address != -1) {
                    if(registerInstructionTemp[0]== 4||registerInstructionTemp[0]== 5){
                        parser.jumpTo(address);
                    }else{
                         parser.jumpTo(parser.getProgramCounter() + address);
                    } 
                    
                }

               
                print(instructionTemp);
  
    }
         display(register, parser);
    }
    
    public static void exit(String message) {
        System.out.println(message);
        System.exit(-1);
    }
    
}
