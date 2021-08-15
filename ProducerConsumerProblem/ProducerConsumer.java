package ProducerConsumerProblem;

class Q{
	
	int num;
	boolean valueset=false;
	
	public synchronized void put(int num){
		while(valueset){
			try{
				wait();
			}catch(Exception e){};
		}
		this.num=num;
		System.out.println("PUT: "+num);
		valueset=true;
		//System.out.println("PUT: "+num);
		notify();
	}
	
	public synchronized void get(){
		while(!valueset){
			try{
				wait();
			}catch(Exception e){};
		}
		System.out.println("GET: "+num);
		valueset=false;
		notify();
	}
}

class Producer implements Runnable{
	
	Q q;
	
	public Producer(Q q){
		this.q=q;
		Thread t1=new Thread(this,"Producer");
		t1.start();
	}
	
	public void run(){
		int i=0;
		while(true){
			q.put(i++);
			try{
				Thread.sleep(500);
			}catch(Exception e){
				
			};
		}
	}

}

class Consumer implements Runnable{
	
	Q q;
	
	public Consumer(Q q){
		this.q=q;
		Thread t2=new Thread(this,"Consumer");
		t2.start();
		
		
	}
	
	public void run(){
		
		while(true){
			q.get();
			try{
				Thread.sleep(500);
			}catch(Exception e){
				
			};
		}
	}
}

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Q q = new Q();
		new Producer(q);
		new Consumer(q);

	}
}
