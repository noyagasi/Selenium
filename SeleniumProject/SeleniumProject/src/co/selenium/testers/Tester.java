package co.selenium.testers;

import co.selenium.common.Helper;

public abstract class Tester {
	protected Helper helper = new Helper(); // "Auxiliary functions" class
	abstract void setDriver();
}
