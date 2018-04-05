package test.java.net.codejava.javaee;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLink;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertFormPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertFormElementPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextFieldEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTextField;
import static net.sourceforge.jwebunit.junit.JWebUnit.submit;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextPresent;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;


public class HelloServletTest {
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
        setBaseUrl("http://localhost:9006/helloworld");
    }

    @Test
    public void testLoginPage() {
        beginAt("index.jsp"); 
        assertTitleEquals("Hello World");
		assertFormPresent();
		assertFormElementPresent("yourName");
		//assertTextFieldEquals("yourName", "Enter your name here");
        //assertLinkPresent("home");
        //clickLink("home");
        //assertTitleEquals("Home");
    }
    
    @Test
    public void testEnterNamePage() {
        beginAt("index.jsp"); 
        assertTitleEquals("Hello World");
		setTextField("callServlet", "Badari");
        // submit the form (either generically call submit or click on a particular button
        submit();
		assertTextPresent("Hello Badari");
    }
}