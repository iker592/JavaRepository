package restaurant;

import java.util.ArrayList;

public class Table {
	private ArrayList <Client> clients;
	private int count;
	private final int max=4;
	Table(int count) {
		super();
		this.count = count;
		clients=new ArrayList<Client>();
	}
	
	Table() {
		count=0;
		clients=new ArrayList<Client>();
	}
	boolean containsTshirt(int Tshirt){
		boolean found=false;
		for(int i=0;i<count && !found;i++){
			if(clients.get(i).getTshirt()==Tshirt)
				found=true;
		}
		return found;
	}
	int getCount() {
		return count;
	}
	void setCount(int count) {
		this.count = count;
	}
	boolean isFull(){
		return count==max;
	}
	void addClient(Client client){
		if(!this.containsTshirt(client.getTshirt())&& !isFull())
			clients.add(client);
			count++;
	}
	
	void print(){
		System.out.println("TABLE");
		System.out.println("--------------------------------");
		for(int i=0;i<count;i++){
			System.out.println("TaxNum: "+clients.get(i).getTin()+" Tshirt num: "+clients.get(i).getTshirt());
		}
		System.out.println("--------------------------------");
	}
}
