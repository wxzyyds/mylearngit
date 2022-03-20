package com.itranswarp.learnjava;

import java.util.Objects;

public final class Point {
//	假设我们希望定义一个Point类，有x、y两个变量，同时它是一个不变类，可以这么写
	  private final int x;
	    private final int y;

	    public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    public int x() {
	        return this.x;
	    }

	    public int y() {
	        return this.y;
	    }
//	    为了保证不变类的比较，还需要正确覆写equals()和hashCode()方法，这样才能在集合类中正常使用。

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
}
