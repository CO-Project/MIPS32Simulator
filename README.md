# MIPS32 Simulator
## How it works?
Our MIPS32 Simulator when run, displays a graphical user interface to upload an assembly file present anywhere in your computer and executes it. It displays the values stored in the registers and in the data segment after the execution of the file on a GUI. Also it displays the values of the registers after executing each step on the console.

The file bubblesort.asm is an assembly file which performs bubblesort on the given data and it is written based on our architecture.

## Instructions Implemented :
Our simulator can run the following instructions:
1. add
2. sub
3. mul
4. slt
5. and
6. or
7. addi
8. subi
9. bne
10. beq
11. lw
12. sw
13. j 

#### Note :
The branch instructions bne, beq and the jump instruction(j) jump to an instruction number rather than a label.

## Classes implemented in the Java program :
There are 8 Java classes in our program. The class GuiSimulator is the main class.

### GUI Class :
The GUI class holds the code to create a graphical user interface to upload a file and display the registers and the data segment after the execution of the program.

### GuiSimulator Class :
The GuiSimulator class creates an object of the GUI class and invokes the functions on this object to display the graphical user interface. 

### Register Class :
The Register class deals with all the registers. It changes the values of the registers and reads them. It also returns the number of the register depending on the name used, such as $s7.

### DataSegment Class :
The DataSegment class deals with the data to be manipulated. The data in the DataSement can be loaded to the registers and the data in the registers can be stored in the DataSegment.

### Memory Class :
The Memory class stores the input file in a txt file and accesses it directly from this file. There will be a file reader and a file writer in this class; the file reader will save the last read line that way, if we need to continue reading, we don't have to read again from the start, but we'll continue from where we last left

### Parser Class :
The Parser class takes the input file and decodes the instructions line by line.

### Processor Class :
The Processor class takes the decoded instructions and executes them line by line.

### Simulator Class :
The Simulator class creates objects of Register, DataSegment, Memory, Pareser and Processor classes. It invokes the functions on these objects and executes the program.
