class SequentialGopher extends Thread{

	public static int totalBooks = 25;
	public static int cart = 0;
	public static int requiredTime = 0;
	public static int stock = 0;
	

	public static void loadBooks(){
		System.out.println("Books are loading into cart.....");
		cart+=5;
		System.out.println("Books in the cart:" + cart);

		totalBooks-=5;
		System.out.println("Books remaining: " + totalBooks);
		requiredTime += 10;
		System.out.println("Current time:" + requiredTime + "seconds");
		//return requiredTime;
	}
	public static void goToIncenerator(){
		System.out.println("Going to incenerator");
		requiredTime += 30;
		System.out.println("Current time:" + requiredTime);
		//return requiredTime;
	}
	public static void unloadBooks(){
		System.out.println("Unloading and burning 3 books.....");
		requiredTime+=10;
		cart-=5;
		System.out.println("Books in cart:" + cart);
		System.out.println("Burning 3 books and stocking up 2 books");
		stock+=2;
		System.out.println("Books piled up:" + stock);
		System.out.println("Current time:" + requiredTime);
		//return requiredTime;
	}
	public static void burnBooks(){
		System.out.println("Burning books.....");
		requiredTime+=20;
		System.out.println("Current time:" + requiredTime);
		//return requiredTime;
	}
	public static void goToPile(){
		System.out.println("Heading back to pile.....");
		requiredTime+=30;
		System.out.println("Current time:" + requiredTime);
		//return requiredTime;
	}
	public void run(){
		System.out.println("Thread is running.....");
		while(totalBooks>0){
			loadBooks();
			goToIncenerator();
			unloadBooks();
			goToPile();
			//totalBooks = totalBooks-5;
		}
		requiredTime = requiredTime-30;
		System.out.println("Current time:" + requiredTime);
		while(stock>0){
			burnBooks();
			stock = stock-3;
			//requiredTime+=10;
		}
		System.out.println("Current time:" + requiredTime);
	}
	public static void main(String args[]){
		SequentialGopher gopher1 = new SequentialGopher();
		//ConcurrentGopher gopher2 = new ConcurrentGopher();
		gopher1.start();
		//gopher2.start();

	}
		
}
