package lee;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 * User: jennie
 * Date: 2016/9/1
 * Time: 20:49
 */
public class IteratorTag extends SimpleTagSupport {

    private String collection;

    private String item;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public void doTag() throws JspException, IOException {
        Collection itemList=(Collection) getJspContext().getAttribute(collection);

        for (Object s : itemList) {
            getJspContext().setAttribute(item,s);
            getJspBody().invoke(null);
        }
    }
}
