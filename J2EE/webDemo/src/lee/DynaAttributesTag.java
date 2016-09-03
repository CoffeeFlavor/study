package lee;

import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaClientTube;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

/**
 * User: jennie
 * Date: 2016/9/1
 * Time: 21:42
 */
public class DynaAttributesTag extends SimpleTagSupport implements DynamicAttributes {

    private ArrayList<String> keys= new ArrayList<String>();

    private ArrayList<Object> values=new ArrayList<Object>();

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out=getJspContext().getOut();

        out.println("<ol>");
        for (int i = 0; i < keys.size(); i++) {
            String key=keys.get(i);
            Object value=values.get(i);
            out.println("<li>"+key+"="+value+"</li>");
        }
        out.println("</ol>");
    }
    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        keys.add(localName);
        values.add(value);
    }
}
