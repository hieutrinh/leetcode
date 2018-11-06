package leetcode.common;

import java.util.List;

public class NestedIntegerImpl implements NestedInteger {
	private boolean isInteger = false;
	private Integer intValue;
	private List<NestedInteger> list;
	
	public NestedIntegerImpl(final Integer value) {
		isInteger = true;
		intValue = value;
	}
	
	public NestedIntegerImpl(final List<NestedInteger> list) {
		this.list = list;
	}
	
	@Override
	public boolean isInteger() {
		return isInteger;
	}

	@Override
	public Integer getInteger() {
		return intValue;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}
	
	public String toString() {
		if (isInteger()) {
			return intValue.toString();
		} else {
			return list.toString();
		}
	}
}
