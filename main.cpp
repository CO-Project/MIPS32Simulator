#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	int *R=new int[32];
	int *Mem=new int[1024];
	int PC=0;
	enum INST_TYPE
       {
		ADD, SUB, DIV, MUL,BNE,JUMP,LD,ST
	};
	string INSTLIB[] =
       {
	".data", ".align", ".ascii", ".asciiz", ".byte", ".half", ".space", ".word", ".text",
	"add", "addu", "div", "mul", "neg", "rem", "sub", "subu", "xor",
	"li",
	"seq", "sge", "sgt", "sle", "slt", "sne",
	"b", "beq", "beqz", "bge", "bgez", "bgt", "bgtz", "ble", "blez", "blt", "bltz", "bne", "bnez",
	"j", "jal", "jalr", "jr",
	"la", "lb", "lw", "sb", "sw",
	"move", "mfhi", "mflo", "nop", "syscall",
	"LABEL",
	"EMPTY"
      };
       
	string myText;
	ifstream MyFile("que9.asm");
	while (getline (MyFile, myText)) {
	
  			cout << myText << endl;
	}

	MyFile.close();

	return 0;
}
