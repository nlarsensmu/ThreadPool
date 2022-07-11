public class Task implements Runnable
{
    private int a;
    private int b;

    public Task(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
    	System.out.println(Thread.currentThread().getName() + 
    			" is starting to wait");
    	
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        System.out.println(Thread.currentThread().getName() + 
        		"  task result = " + (a + b));
    }
}
