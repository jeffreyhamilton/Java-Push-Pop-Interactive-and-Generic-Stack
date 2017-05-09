import java.util.ArrayList;

class Stack<E> {
	 public String mode = "Stack";
	public ArrayList<E> list = new ArrayList<>();
	
		public void push(E o){
				list.add(o);
			}
			
			public void queue(E o){			
				list.add(0, o);
			}
			
			public void deQueue(){	
			    list.remove(0);
			}
					
			public void pop(){	
			    list.remove(list.size() - 1);
			}
			
			public void cutFromBack(){	
			    list.remove(0);
			}
			
			public void clear(){
					list.clear();	
			}
			@Override
			public String toString(){
				return list.toString();
			}
	}
	


