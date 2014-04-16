package com.zzfutilities.patter.singleton;

public class SimpleSingleton {
	private static SimpleSingleton	singleInstance	= new SimpleSingleton();

	private SimpleSingleton() {
	}

	public static SimpleSingleton getInstance() {

		return singleInstance;
	}
}