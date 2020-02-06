package cn.kahun.sa.framework.spring.test.spel;

import cn.kahun.sa.framework.spring.beans.Inventor;
import cn.kahun.sa.framework.spring.beans.ParseConfigurationBean;
import cn.kahun.sa.framework.spring.beans.Simple;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import javax.annotation.Resource;
import java.util.*;

public class EvaluationTest {

    private static ExpressionParser expressionParser = new SpelExpressionParser();
    private static EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    @Test
    public void testLiteralString(){

        Expression expression1 = expressionParser.parseExpression("'Hello World!'");
        Expression expression2 = expressionParser.parseExpression("'Hello World!'.concat('!!')");
        Expression expression3 = expressionParser.parseExpression("'Hello World!'.bytes");
        Expression expression4 = expressionParser.parseExpression("'Hello World!'.bytes.length");
        Expression expression5 = expressionParser.parseExpression("new String('Hello World!').toUpperCase()");

        System.out.println(expression1.getValue());
        System.out.println(expression2.getValue());
        System.out.println(Objects.requireNonNull(expression3.getValue()).getClass().getSimpleName());
        System.out.println(expression4.getValue());
        System.out.println(expression5.getValue());

    }

    @Test
    public void testGetValue(){

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(2020, Calendar.FEBRUARY,23);

        Inventor inventor = new Inventor("Nikola Tesla",gregorianCalendar.getTime(),"Serbian");

        Expression expression = expressionParser.parseExpression("name");

        String name = expression.getValue(inventor,String.class);

        System.out.println(name);

        expression = expressionParser.parseExpression("name == 'Nikola Tesla'");

        Boolean result = expression.getValue(inventor,Boolean.class);

        System.out.println(result);

    }

    @Test
    public void testEvaluationContext(){

        Simple simple = new Simple();

        simple.getBooleanList().add(Boolean.TRUE);

        expressionParser.parseExpression("booleanList[0]").setValue(simpleEvaluationContext,simple,Boolean.FALSE);

        Boolean b = simple.getBooleanList().get(0);

        Assert.assertTrue(b);

    }

    @Test
    public void testParseConfiguration(){

        /*
         * - auto null reference initialization
         *  - auto collection growing
         */
        SpelParserConfiguration spelParserConfiguration = new SpelParserConfiguration(true,true);

        ExpressionParser expressionParser = new SpelExpressionParser(spelParserConfiguration);

        Expression expression = expressionParser.parseExpression("stringList[3]");

        ParseConfigurationBean parseConfigurationBean = new ParseConfigurationBean();

//        NullPointerException not initialization
//        System.out.println(parseConfigurationBean.getStringList().size());

        Object o = expression.getValue(parseConfigurationBean);

        Assert.assertEquals(o,"");

        System.out.println(parseConfigurationBean.getStringList().size());
    }

}
