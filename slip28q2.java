class ThreadName extends Thread {
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Currently executing thread: " + t.getName());
	}
	
	public static void main(String[] args) {
		ThreadName t1 = new ThreadName();
		ThreadName t2 = new ThreadName();

		t1.start();
		t2.start();

		System.out.println("Currently executing thread: " + Thread.currentThread().getName());
	}
}

