#include <iostream>
#include <fstream>
using namespace std;

int main(){
	
	string myText;

	ifstream MyFile("que9.asm");
      //  MyFile.open("que9.asm");
	while (getline (MyFile, myText)) {
	
  			cout << myText << endl;
	}

	MyFile.close();

	return 0;
}
