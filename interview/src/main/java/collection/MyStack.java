package collection;


public class MyStack {
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
	
	
	public static void main(String[] args) {
		
		MyStack set = new MyStack();
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
