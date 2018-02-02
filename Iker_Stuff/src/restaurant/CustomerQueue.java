package restaurant;

public class CustomerQueue {
	/*
	 * This is a queue of groups of customers
	 */

	private NodeQ first;
	private NodeQ last;
	private int count=0;

	public CustomerQueue() {
		first = null;
		last = null;
		count=0;
	}

	public NodeQ getFirst() {
		return first;
	}

	public void setFirst(NodeQ first) {
		this.first = first;
	}

	public NodeQ getLast() {
		return last;
	}

	public void setLast(NodeQ last) {
		this.last = last;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isEmpty() {return count==0;
		
	} 

	
	/*
	 * Precondition: none Description: This method prints out, in the standard
	 * output, a line for each person in the queue, with tax number, group
	 * number and amount to pay, separated by “ “
	 */
	public void print() {
		if (!isEmpty()) {
			NodeQ current = first;
			for (int i = 0; i < this.getCount()-1; i++) {
				System.out.println(current.getAclient().getTin() + " "
						+ current.getAclient().getTshirt() + " "
						+ current.getAclient().getBill() + "€");
				current = current.getNext();
			}
		}
	}

	/*
	 * Precondition: there isn't any person in the queue with the same T-shirt
	 * or Tax number. Description: This method inserts a client at the end of
	 * the queue
	 */
	public void addClient2rear(Client clientdata) {
		NodeQ node = new NodeQ(clientdata);
		if(isEmpty()){
			first=last=node;
		}else{
		last.setNext(node);
		node.setPrevious(last);
		last = node;}
		count++;
	}

	public void addClient2front(Client clientdata) {
		NodeQ node = new NodeQ(clientdata);
		if(isEmpty()){
			first=last=node;
		}else{
		first.setPrevious(node);
		node.setNext(first);
		first = node;}
		count++;
	}
	/* Precondition: none
	This method prints out a line for each client who has the number of Tshirt
	specified in the parameter of the method. The line must contain
	the Tax identification number and the number of T-shirt, separated by “ “
	*/ 
	public void print(int tshirt) {
		if (!isEmpty()) {
			NodeQ current = first;
			for (int i = 0; i < this.getCount()-1; i++) {
				if (current.getAclient().getTshirt() == tshirt) {
					System.out.println(current.getAclient().getTin() + " "
							+ current.getAclient().getTshirt() + " "
							+ current.getAclient().getBill() + "€");
				}
				current = current.getNext();
			}
		}
	}
	/* Precondition: there isn't any person in the queue with the same T-shirt
	or Tax number as those of any other person in the new group of clients.
	This method inserts at the end of the queue all clients that are in the
	queue that is passed as the parameter. This operation must be executed
	in constant time, i.e., O(1) */ 
	public void insertGroup(CustomerQueue groupclients) {
		this.count+=groupclients.count;
		
		last.setNext(groupclients.getFirst());
		groupclients.getFirst().setPrevious(last);
		
		last=groupclients.getLast();
	}
	/* Precondition: none
	 This method prints out in standard output a line for each group in the
	queue. The line states the sum of the bills of every person in the group */
	public void invoiceGroups() {
		if (!isEmpty()) {
			NodeQ current = first;
			int currentTshirt=current.getAclient().getTshirt();
			double currentBill=0;
			for (int i = 0; i < this.getCount()-1; i++) {
				if (current.getAclient().getTshirt() == currentTshirt) {
					currentBill += current.getAclient().getBill();
				}else{
					System.out.println("Group: " + currentTshirt
							+ " Bill: " + currentBill + "€");
					currentTshirt=current.getAclient().getTshirt();
					currentBill=current.getAclient().getBill();
					
				}
				if(current==last)
						System.out.println("Group: " + currentTshirt
								+ " Bill: " + currentBill + "€");
				current = current.getNext();
			}
		}
	}
	/* Precondition: there isn't any person in the queue with the same Tax
	number.
	This method inserts a Client in the queue, according to the rules of the
	restaurant */ 
	public void insertClient(Client clientdata) {
		boolean found=false;
		boolean exit =false;
		NodeQ current = first;
		
		for (int i = 0; i < this.getCount()-1 && !exit; i++) {
			if (current.getAclient().getTshirt() == clientdata.getTshirt()) {
				found=true;
			}else if(found && current.getAclient().getTshirt() != clientdata.getTshirt())
			{NodeQ middle = new NodeQ(clientdata);
			NodeQ lastInGroup=current.getPrevious();
			lastInGroup.setNext(middle);
			middle.setPrevious(lastInGroup);
			current.setPrevious(middle);
			middle.setNext(current);
			count++;
			exit=true;
				
			}
				current = current.getNext();
		}if(!found || !exit){
			this.addClient2rear(clientdata);
		}

	}

	public double removeGroup(int tshirt) {
		int cnt=0;
		if (!isEmpty()) {
			NodeQ after = null;
			NodeQ current=first;
			NodeQ before= null;
			
			boolean found=false;
			boolean exit=false;
			for (int i = 0; i < this.getCount()-1 && !exit; i++) {
				if (current.getAclient().getTshirt() == tshirt&&!found) {
					after=current.getPrevious();
					cnt++;
					found=true;
				}else if(current.getAclient().getTshirt() != tshirt&&found){
					before=current;
					exit=true;
				}else if(current.getAclient().getTshirt() == tshirt){
					cnt++;
				}
				
				current = current.getNext();
			}
			if(found&&before!=null){
			after.setNext(before);
			before.setPrevious(after);
			count-=cnt;}else{
				last=after;
				count-=cnt;
			}
			
		}
		return cnt;
	}

	public Client removeFirstinLine() {
		NodeQ node =first;
		first=first.getNext();
		count--;
		return node.getAclient();
	}
}
