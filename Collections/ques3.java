package ASSNMT3;

/*
 * 3) Design a Data Structure SpecialStack that supports all the stack operations like push(), 
pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum 
element from the SpecialStack. (Expected complexity ­ O(1))

4) Create class Employee with attributes name,age,designation and use instances of these 
class as keys in a Map and their salary as value
 */

class Stack{
	
	class Pair {
		private int data;
		private int localMin;

		public int getData() {
			return this.data;
		}

		public int getLocalMin() {
			return this.localMin;
		}

		public void setData(int d) {
			this.data = d;
		}

		public void setLocalMin(int l) {
			this.localMin = l;
		}
	}
	
	private Pair[] dataArray;
	private int top;

	public static final int DEFAULT_CAPACITY = 10;

	public Stack() throws Exception {
		this(DEFAULT_CAPACITY);
	}

	public Stack(int capacity) throws Exception {
		if (capacity < 1)
			throw new Exception("Invalid Capacity");

		this.dataArray = new Pair[capacity];
		this.top = -1;
	}

	public int size() {
		return this.top + 1;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void push(int data) throws Exception {
		if (this.size() == dataArray.length)
			throw new Exception("Stack is full");

		Pair p = new Pair();
		p.setData(data);

		if (this.size() == 0) {
			p.setLocalMin(data);
		} else {
			int lastLocalMin = this.peek().getLocalMin();
			if (lastLocalMin > data)
				p.setLocalMin(data);
			else
				p.setLocalMin(lastLocalMin);
		}
		this.top++;
		this.dataArray[this.top] = p;
	}

	public Pair pop() throws Exception {
		if (this.size() == 0)
			throw new Exception("Stack is Empty");

		Pair rp = this.dataArray[this.top];
		this.dataArray[this.top] = null;
		this.top--;
		return rp;
	}

	public Pair peek() throws Exception {
		if (this.size() == 0)
			throw new Exception("Stack is Empty");

		Pair rp = this.dataArray[this.top];
		return rp;
	}

	public int getMin() throws Exception {
		return this.peek().getLocalMin();
	}

	public void display() {
		for (int i = this.top; i >= 0; i--) {
			System.out.print(this.dataArray[i].getData() + "=> " + this.dataArray[i].getLocalMin() + ", ");
		}
		System.out.println("END");
	}
}

public class ques3 {

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack();
		stack.push(5);
		stack.push(10);
		stack.push(15);
		stack.push(9);
		stack.push(2);
		stack.push(11);
		stack.push(20);

		stack.display();
		System.out.println(stack.getMin());
		System.out.println(stack.peek().getData() + " and " + stack.peek().getLocalMin());

		stack.pop();
		stack.pop();
		stack.display();
		System.out.println(stack.getMin());
		System.out.println(stack.peek().getData() + " and " + stack.peek().getLocalMin());
	}

}
