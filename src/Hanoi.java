/*********************
CEINF - Centro de Estudos em Informática
http://www.ceinf.com.br
**********************/

class Hanoi{

	public static int torre(int disco, char de, char para, char aux){

	    if(disco == 1){
		System.out.println("Mover o disco "+disco+" da torre "+de+" para a torre "+para+"\n");
	    }else{
		torre(disco-1,de,aux,para);
		System.out.println("Mover o disco "+disco+" da torre "+de+" para a torre "+para+"\n");
		torre(disco-1,aux,para,de);
	    }
    
    	return 0;
	}

	public static void main(String args[]){

	    int numero_discos = 5;
    		torre(numero_discos,'A','B','C');
    
	}

}