#include <iostream>
#include <fstream>
using namespace std;

int main(){
	
	string myText;

	ifstream MyFile("que9.asm");
        MyFile.open();
	while (getline (MyFile, myText)) {
	
  			cout << myText << endl;
	}

	MyFile.close();

	return 0;
}
