package restaurant;

public class NodeQ {
	private Client aclient;
	private NodeQ previous;
	private NodeQ next;
	
	
	
	NodeQ() {
		aclient=null;
		previous=null;
		next=null;
	}
	
	
	NodeQ(Client aclient) {
		this.aclient = aclient;
		previous=null;
		next=null;
	}


	Client getAclient() {
		return aclient;
	}
	void setAclient(Client aclient) {
		this.aclient = aclient;
	}
	NodeQ getPrevious() {
		return previous;
	}
	void setPrevious(NodeQ previous) {
		this.previous = previous;
	}
	NodeQ getNext() {
		return next;
	}
	void setNext(NodeQ next) {
		this.next = next;
	}
}
