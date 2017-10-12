package collection;



public class MySet {
	int capacity = 3;
	Object[] elementDate = new Object[capacity];
	int top = -1;
	
	 void push(Object obj) {
		if(size() == capacity) {
			System.out.println(capacity);
			throw new ArrayIndexOutOfBoundsException("stack is full");
		}
		elementDate[++top] = obj; 
	}
	
	//弹出并删除
	Object pop() {
		Object obj = peek();
		elementDate[top--] = null;
		return obj;
	}
	
	//查找不删除
	Object peek() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("stack is empty");
		}
		return elementDate[top];
	}
	
	int size() {
		if(isEmpty()) {
			return 0;
		}
		return top+1;
	}
	
	boolean isEmpty() {
		return top == -1 ? true : false;
	}
	
	/**
	 * 相邻的两个元素比: 每次选择一个最小的放在前面
	 */
	void sort() {
		int[] array = {2,3,1,4};
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	/**
	 * 选择排序: 第一个和剩下的所有比, 每次选择一个最大的放在首位
	 */
	void selsort() {
		int[] array = {2,3,1,4};
		for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		
		MySet  set = new MySet();
		set.selsort();
//		
//		set.push(1);
//		set.push(2);
//		set.push(3);
////		set.push(4);
//		System.out.println(set.peek());
//		System.out.println(set.pop());
//		System.out.println(set.peek());
	}
}
