package mips;
import java.io.File;

public class Simulator {
    
    private Processor processor;
    private Memory memory;
    private Register register;
    private Parser parser;
    private String instructionRegister;
    private String str=" ";
    private String stallInsEnabled = "";
    private String stallInsDisabled = "";
    int stallsEnabled = 0;
    int clocksEnabled= 4;
    int stallsDisabled=0;
    int clocksDisabled=4;
    boolean enable = true;
    boolean disable=true;
    int instr = 0;
    public Simulator (File inputFile) {
        processor = Processor.getInstance();
        memory    = Memory.getInstance();
        register  = Register.getInstance();
        parser    = new Parser(inputFile);
        instructionRegister = "";
    }
    
    public static void display(Register r,Parser p,String str,int instr,int stallsEnabled,int stallsDisabled, int clocksEnabled,int clocksDisabled,String stallInsEnabled, String stallInsDisabled) {
    	GUI gui= new GUI(r.registers,p.getData(),32,1024,str,instr,stallsEnabled,stallsDisabled, clocksEnabled,clocksDisabled,stallInsEnabled, stallInsDisabled);
        gui.display(r.registers,p.getData(),32,1024,str,instr,stallsEnabled,stallsDisabled, clocksEnabled,clocksDisabled,stallInsEnabled, stallInsDisabled);
    }

    @SuppressWarnings("unused")
	public void startSimulation () {
            
        String[] instruction;
        int[] registerInstruction;
        int[] previousInstruction = null;
        int[] prevprevInstruction = null;
        boolean isStallDisabled = false;
      boolean isStallEnabled=false;
        while ((instruction = parser.nextInstruction()) != null) {
        	isStallDisabled = false;
        	isStallEnabled=false;
            instr++;
            instructionRegister = memory.loadInstruction(instruction[0]);
            registerInstruction = parser.decodeInstruction(instructionRegister);
            final String[] instructionTemp = instruction;
            final int[] registerInstructionTemp = registerInstruction;

            
            if (registerInstruction[0] == 2) {
               
                parser.jumpTo(processor.executeInstruction(registerInstruction, parser.datasegment));
                previousInstruction = null;
                prevprevInstruction = null;
                continue;
            }
            
            if (registerInstruction[0] == 4 || registerInstruction[0] == 5)
            {
                 isStallDisabled = true;
                 isStallEnabled = true;
            	 stallsEnabled++;
            	 stallsDisabled++;
            }else{
                // Check if Previous and Current Instructions
            // Are Independent, If not, Stall Pipeline
            if(disable == true)
            {
                if (previousInstruction != null && parser.disableCountStalls(registerInstruction, previousInstruction))
                {
                    isStallDisabled= true;
                    stallsDisabled+= 2;
                }
                if (prevprevInstruction != null && parser.disableCountStalls(registerInstruction, prevprevInstruction))
                {
                    isStallDisabled = true;
                    stallsDisabled++;
                }               
            }else{
                if (previousInstruction != null && parser.enableCountStalls(registerInstruction, previousInstruction)){
                    isStallEnabled= true;
                    stallsEnabled++;
                }
            }
            }

            prevprevInstruction = previousInstruction;
            previousInstruction = registerInstruction;
            
                int address = processor.executeInstruction(registerInstructionTemp, parser.datasegment);
               
                if (address != -1) {
                    if(registerInstructionTemp[0]== 4||registerInstructionTemp[0]== 5){
                        parser.jumpTo(address);
                    }else{
                         parser.jumpTo(parser.getProgramCounter() + address);
                    } 
                    
                }
                if(isStallEnabled == true)
                {
                    stallInsEnabled =  stallInsEnabled + instruction[1]+"\n";
                }
                if(isStallDisabled == true)
                {
                    stallInsDisabled = stallInsDisabled  + instruction[1]+"\n";
                }
               str=str+ "\n"+instruction[1]+"\n"+instruction[0]+"\n"+register+"\n"+"-----------------------------------------------------------\n";
          
    }
         clocksEnabled =clocksEnabled+ instr  + stallsEnabled ;
         clocksDisabled = clocksDisabled+instr  + stallsDisabled ;
         display(register, parser, str,instr,stallsEnabled,stallsDisabled, clocksEnabled,clocksDisabled,stallInsEnabled, stallInsDisabled);
        
    }
    
    public static void exit(String message) {
        System.out.println(message);
        System.exit(-1);
    }    
}
