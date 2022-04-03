package com;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages({"com.sample"})
//@IncludeTags("production")
@Suite
@SuiteDisplayName("A demo Test Suite")
public class JUnit5TestSuite {

}