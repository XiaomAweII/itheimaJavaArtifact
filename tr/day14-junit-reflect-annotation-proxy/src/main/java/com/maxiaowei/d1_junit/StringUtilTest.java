package com.maxiaowei.d1_junit;


import org.junit.*;

/**
 * 测试类
 */
public class StringUtilTest {

    @Before // 修饰实例方法，每个测试方法前都执行一次
    public void before() {
        System.out.println("===========before===========");
    }

    @After // 修饰实例方法，每个测试方法后都执行一次
    public void after() {
        System.out.println("===========after===========");
    }

    @BeforeClass // 修饰静态方法，全部测试方法前只执行一次
    public static void beforeClass() {
        System.out.println("===========beforeClass===========");
    }

    @AfterClass // 修饰静态方法，全部测试方法后只执行一次
    public static void afterClass() {
        System.out.println("===========afterClass===========");
    }


    @Test
    public void testPrintNumber() {
        StringUtil.printNumber(null);
        StringUtil.printNumber("");
        StringUtil.printNumber("admin");
    }

    @Test
    public void testGetMaxIndex() {
//        System.out.println(StringUtil.getMaxIndex(null));
//        System.out.println(StringUtil.getMaxIndex(""));
//        System.out.println(StringUtil.getMaxIndex("admin"));
        // 断言：预言。
        int i1 = StringUtil.getMaxIndex(null);
        Assert.assertEquals("null测试失败!", -1, i1);

        int i2 = StringUtil.getMaxIndex("");
        Assert.assertEquals("空字符串测试失败!", -1, i2);

        int i3 = StringUtil.getMaxIndex("admin");
        Assert.assertEquals("admin测试失败!", 4, i3);

        System.out.println("测试通过！");
    }
}
