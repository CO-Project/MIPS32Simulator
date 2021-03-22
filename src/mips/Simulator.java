package mips;

import java.io.File;

public class Simulator {
    
    private Processor processor;
    private Memory memory;
    private Register register;
    private Parser parser;
    private String instructionRegister;

    private String str=" ";
    public Simulator (File inputFile) {
        processor = Processor.getInstance();
        memory    = Memory.getInstance();
        register  = Register.getInstance();
        parser    = new Parser(inputFile);

        instructionRegister = "";
    }
    
    public static void display(Register r,Parser p,String str) {
    	GUI gui= new GUI(r.registers,p.getData(),32,1024,str);
        gui.display(r.registers,p.getData(),32,1024,str);
    }

    @SuppressWarnings("unused")
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
               str=str+ "\n"+instruction[1]+"\n"+instruction[0]+"\n"+register+"\n"+"-----------------------------------------------------------\n";
                
             //   display(register, parser, instruction,register);
  
    }
         display(register, parser, str);
    }
    
    public static void exit(String message) {
        System.out.println(message);
        System.exit(-1);
    }
    
}
