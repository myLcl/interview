package Singleton;

/**
 * 线程安全的单例 
 */
public class ThreadSingle {
	private static ThreadSingle single = null;
	
	private ThreadSingle(){
	}
	
	/**
	 * 双重检查创建单例对象
	 */
	public static ThreadSingle getSingle() {
		if(single == null) {
			synchronized (ThreadSingle.class) {
				if(single == null) {
					return single = new ThreadSingle();
				}
			}
		}
		
		return single;
	}
	
	public static void main(String[] args) {
		thread();
	}
	
	static  void thread() {
		//启动5个线程: 如果hash值都一样的话说明是线程安全的
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable(){
				public void run() {
					//输出对象的hash值
					System.out.println(ThreadSingle.getSingle().hashCode());
					
				}
				
			}).start();
		}
	}
}

