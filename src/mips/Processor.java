package mips;

public class Processor {
    private static Processor processor;

    private Memory memory;
    private Register register;
    private DataSegment datasegment = new DataSegment();

   
    public Processor () {
        memory   = Memory.getInstance();
        register = Register.getInstance();
    }
   
    public static synchronized Processor getInstance() {
        if (processor == null)
            processor = new Processor();
        return processor;
    }
    
    public int executeInstruction(int[] instruction, DataSegment data) {
        
        datasegment = data;

        int opCode = instruction[0];
        if (opCode == 0) {
            int rs = instruction[1];
            int rt = instruction[2];
            int rd = instruction[3];

            int func = instruction[5];

            switch (func) {
                case 32:
                    processor.add(rd, rs, rt);
                    break;
                case 34:
                    processor.sub(rd, rs, rt);
                    break;
                case 36:
                    processor.and(rd, rs, rt);
                    break;
                case 37:
                    processor.or(rd, rs, rt);
                    break;
                case 39:
                    processor.mul(rd, rs, rt);
                    break;
                case 42:
                    processor.slt(rd, rs, rt);
                    break;
            }

            return -1;
        } else if (opCode == 2) {
            return instruction[1];
        } else {
            int rs = instruction[1];
            int rd = instruction[2];

            int address = instruction[3];

            switch (opCode) {
                case 4:
                    return processor.beq(rd, rs, address);
                case 5:
                    return processor.bne(rd, rs, address);
                case 8:
                	processor.addi(rd, rs, address);
                    break;
                case 9:
                	processor.subi(rd, rs, address);
                    break;    
                case 35:
                	processor.lw(rd, rs, address);
                    break;
                case 43:
                	processor.sw(rd, rs, address);
                    break;
            }

            return -1;
        }
    }
   
    private void add(int rd, int rs, int rt) {
        register.write(rd, register.read(rs) + register.read(rt));
    }

    private void sub(int rd, int rs, int rt) {
        register.write(rd, register.read(rs) - register.read(rt));
    }
    
    private void mul(int rd, int rs, int rt) {
        register.write(rd, register.read(rs) * register.read(rt));
    }

    private void and(int rd, int rs, int rt) {
        register.write(rd, register.read(rs) & register.read(rt));
    }

    private void or(int rd, int rs, int rt) {
        register.write(rd, register.read(rs) | register.read(rt));
    }

    private void slt(int rd, int rs, int rt) {
        boolean isSlt = register.read(rs) < register.read(rt);

        register.write(rd, (isSlt) ? 1 : 0);
    }
  
    private int beq(int rs, int rt, int address) {
        if (register.read(rs) == register.read(rt))
            return address;
        else return -1;
    }

    private int bne(int rs, int rt, int address) {
        if (register.read(rs) != register.read(rt))
            return address;
        else return -1;
    }

    private void addi(int rd, int rs, int constant) {
        register.write(rd, register.read(rs) + constant);
    }
    
    private void subi(int rd, int rs, int constant) {
        register.write(rd, register.read(rs) - constant);
    }
    
    private void lw(int rd, int rs, int address) {
        register.write(rd, datasegment.read((register.read(rs)) + address));
    }

    private void sw(int rd, int rs, int address) {
       
        datasegment.write(register.read(rs) + address, register.read(rd));
    }
   
}
