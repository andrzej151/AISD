package Stos;

import java.util.EmptyStackException;

public class Stostab implements Stack{
	
	private Object [] tab;
	private int _sizemax;
	private int size;
	

	public Stostab(int size)
	{
		_sizemax=size;
		tab=new Object[_sizemax];
		clear();
	}
	@Override
	public void push(Object value) {
		// TODO Auto-generated method stub
		if(size>=_sizemax)
		{
			System.out.println("Stack overflow");
		}
		else
		{
			tab[size]=value;
			size++;
		}
	}

	@Override
	public Object pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(size<=0)
		{
			throw new EmptyStackException();
		}
		else
		{
			size--;
			return tab[size];
		}
	}

	@Override
	public Object peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		size=0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
