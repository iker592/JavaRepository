package restaurant;

import java.util.ArrayList;

public class ManageRestaurantQueue {
	


	public static void main(String[] args) {
		CustomerQueue  openbuffet = new CustomerQueue();
		CustomerQueue group9 = new CustomerQueue();
		ArrayList <Table> tables=new ArrayList<Table>();
		Client client1 = new Client(11,"BF",10);
		Client client2 = new Client(5,"AF",20);
		Client client3 = new Client(5,"AD",30);
		Client client4 = new Client(7,"XF",40);
		Client client5 = new Client(5,"AE",50);
		Client client6 = new Client(5,"AB",60);
		Client client7 = new Client(9,"MB",70);
		Client client8 = new Client(8,"TL",80);
		Client client9 = new Client(9,"RB",90);
		Client client10 = new Client(11,"BB",100);
		Client client11 = new Client(8,"TB",110);
		Client client12 = new Client(13,"SB",120);
		
		group9.insertClient(client7);
		group9.insertClient(client9);
		
		openbuffet.insertClient(client1);
		openbuffet.insertGroup(group9);
		openbuffet.insertClient(client2);
		openbuffet.insertClient(client3);
		openbuffet.insertClient(client4);
		openbuffet.insertClient(client5);
		openbuffet.insertClient(client6);
		openbuffet.insertClient(client8);
		openbuffet.insertClient(client10);
		openbuffet.insertClient(client11);
		openbuffet.insertClient(client12);
		processTable(openbuffet, tables);
		printTables(tables);




	}
	public static void processTable(CustomerQueue clients, ArrayList <Table> tables){
		while(!clients.isEmpty()){
			Client client=clients.removeFirstinLine();
			Table table=avaliableTable(tables,client.getTshirt());
			if(table !=null){
				table.addClient(client);
			}else{
				table=new Table();
				table.addClient(client);
				tables.add(table);
			}
		}
	}
	public static void printTables(ArrayList <Table> tables){
		for(int i=0; i<tables.size();i++){
			tables.get(i).print();
		}
	}
	public static Table avaliableTable(ArrayList <Table> tables,int tShirt){
		for(int i=0; i<tables.size();i++){
			if(!tables.get(i).containsTshirt(tShirt)&&!tables.get(i).isFull()){
				return tables.get(i);
			}
		}
		
		return null;
	}

}

