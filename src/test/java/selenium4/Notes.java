package selenium4;

public class Notes {
/* Instead of specifying particular tag, we can use * to search for any tag that contains the following attribute: By.xpath("//*[.='Hello']")
 * In case there are multiple elements with the same property, Selenium will choose the first one and it will not tell you which one it took. UFT explicitly asks you which one you want, for example.
 * Whenever Selenium can't find the element, it will throw NoSuchElement Exception.
 * Preference order: id --> name --> class --> linkText --> partialLinkText --> relative xpath --> absolute xpath (total 8 ways to find path: plus CSS)
 * (//div)[1] - find a specific element
 * 
 * TestNG - Test Next Generation.
 * It is a testing framework for java
 * It is widely used in both test automation and in development for Unit tests(more popular with testers)
 * 
 * Popular combinations:
 * Selenium + TestNG(does not work with Cucumber)
 * Selenium + Junit + Cucumber
 * 
 * @Test @BeforeTest @AfterTest
 * 
 * Assertions in TestNG: they are used to perform verifications
 * Assert.assertTrue(boolean);
 * Assert.assertEquals(byte, byte);
 * Assert.assertFalse(boolean);
 * Checks the condition inside and passes it to result field. The whole point to use Assert. is to generate the report.
 * To generate a report - right click on project folder, "Show in" - "System explorer", find emailable report.
 * You can have only one assertion field per @Test annotation.
 * 
 */
}
