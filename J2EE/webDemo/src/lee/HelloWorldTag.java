package lee;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Date;

/**
 * User: jennie
 * Date: 2016/8/31
 * Time: 20:43
 */
public class HelloWorldTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("Hello World "+new Date());
    }
}
