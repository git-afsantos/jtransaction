package com.github.undo4j.transactions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * SyncTransactionFuture
 * 
 * @author afs
 * @version 2013
 */

final class SyncTransactionFuture<T> implements Future<T> {
	// instance variables
	private final T result;
	private final Throwable exception;

	/**************************************************************************
	 * Constructors
	 **************************************************************************/

	/** Parameter constructor of objects of class SyncTransactionFuture. */
	SyncTransactionFuture(T res, Throwable ex) {
		result = res;
		exception = ex;
	}

	/**************************************************************************
	 * Getters
	 **************************************************************************/

	/** */
	T getResult() {
		return result;
	}

	/** */
	Throwable getThrowable() {
		return exception;
	}

	/**************************************************************************
	 * Public Methods
	 **************************************************************************/

	/** */
	@Override
	public boolean cancel(boolean mayInterrupt) {
		return false;
	}

	/** */
	@Override
	public boolean isCancelled() {
		return false;
	}

	/** */
	@Override
	public boolean isDone() {
		return true;
	}

	/** */
	@Override
	public T get() throws ExecutionException {
		if (exception == null) {
			return result;
		}
		throw new ExecutionException(exception);
	}

	/** */
	@Override
	public T get(long time, TimeUnit unit) throws ExecutionException {
		if (exception == null) {
			return result;
		}
		throw new ExecutionException(exception);
	}

	/**************************************************************************
	 * Equals, HashCode, ToString & Clone
	 **************************************************************************/

	/**
	 * Equivalence relation. Contract (for any non-null reference values x, y,
	 * and z): Reflexive: x.equals(x). Symmetric: x.equals(y) iff y.equals(x).
	 * Transitive: if x.equals(y) and y.equals(z), then x.equals(z).
	 * Consistency: successive calls (with no modification of the equality
	 * fields) return the same result. x.equals(null) should return false.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		SyncTransactionFuture<?> n = (SyncTransactionFuture<?>) o;
		return result.equals(n.getResult());
	}

	/**
	 * Contract: Consistency: successive calls (with no modification of the
	 * equality fields) return the same code. Function: two equal objects have
	 * the same (unique) hash code. (Optional) Injection: unequal objects have
	 * different hash codes. Common practices: boolean: calculate (f ? 0 : 1);
	 * byte, char, short or int: calculate (int) f; long: calculate (int) (f ^
	 * (f >>> 32)); float: calculate Float.floatToIntBits(f); double: calculate
	 * Double.doubleToLongBits(f) and handle the return value like every long
	 * value; Object: use (f == null ? 0 : f.hashCode()); Array: recursion and
	 * combine the values. Formula: hash = prime * hash + codeForField
	 */
	@Override
	public int hashCode() {
		return 37 + (result == null ? 0 : result.hashCode());
	}

	/** Returns a string representation of the object. */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(result);
		return sb.toString();
	}
}
