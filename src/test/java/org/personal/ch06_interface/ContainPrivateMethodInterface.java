package org.personal.ch06_interface;

public interface ContainPrivateMethodInterface {

	// JDK 7 -
	String MONGO_DB_NAME = "ABC_Mongo_Datastore";
	void logInfo(String message);

	// JDK 8
	// default method and static method
	default void logWarn(String message){}
	static void isNull(String str) {}

	// JDK 9
	private int getPrivate() {
		return 5;
	}
	private static int getPrivate2() {
		return 6;
	}
}
