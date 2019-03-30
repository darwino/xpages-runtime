/*
 * Generated file. 
 * 
 * Layout.java
 */
package xsp;

import com.ibm.xsp.page.compiled.AbstractCompiledPage;
import com.ibm.xsp.page.compiled.AbstractCompiledPageDispatcher;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import com.ibm.xsp.page.compiled.NoSuchComponentException;
import com.ibm.xsp.page.compiled.PageExpressionEvaluator;
import java.lang.String;
import com.ibm.xsp.component.UIViewRootEx2;
import com.ibm.xsp.component.UIPassThroughTag;
import com.ibm.xsp.component.xp.XspOutputText;
import java.lang.Object;
import javax.faces.el.ValueBinding;
import com.ibm.xsp.component.xp.XspCallback;
import com.ibm.xsp.component.xp.XspGraphicImage;

@SuppressWarnings("all")
public class Layout extends AbstractCompiledPageDispatcher{
    
    public Layout() {
        super("3.0");
    }

    protected AbstractCompiledPage createPage(int pageIndex) {
        return new LayoutPage();
    }
    
    protected boolean isCustomControl() {
        return true;
    }

    public static class LayoutPage extends AbstractCompiledPage {
        
        private static final ComponentInfo[] s_infos = new ComponentInfo[]{
            ComponentInfo.EMPTY_NORMAL, // 0 text
            new ComponentInfo(true, new int[]{0}), // 1 h1
            new ComponentInfo(true, new int[]{1}), // 2 div2
            ComponentInfo.EMPTY_NORMAL, // 3 callback
            new ComponentInfo(true, new int[]{3}), // 4 div3
            ComponentInfo.EMPTY_NORMAL, // 5 image
            ComponentInfo.EMPTY_NORMAL, // 6 text2
            new ComponentInfo(true, new int[]{5, 6}), // 7 div4
            new ComponentInfo(true, new int[]{2, 4, 7}), // 8 div
            new ComponentInfo(false, new int[]{8}), // 9 view
        };
        
        public LayoutPage() {
            super(9, s_infos );
        }
        
        public int getComponentForId(String id) throws NoSuchComponentException { 
            return -1;
        }
        
        public UIComponent createComponent(int id, FacesContext context,
                UIComponent parent, PageExpressionEvaluator evaluator)
                throws NoSuchComponentException { 
            switch (id) {
            case 9:
                return createView(context, parent, evaluator);
            case 8:
                return createDiv(context, parent, evaluator);
            case 2:
                return createDiv2(context, parent, evaluator);
            case 1:
                return createH1(context, parent, evaluator);
            case 0:
                return createText(context, parent, evaluator);
            case 4:
                return createDiv3(context, parent, evaluator);
            case 3:
                return createCallback(context, parent, evaluator);
            case 7:
                return createDiv4(context, parent, evaluator);
            case 5:
                return createImage(context, parent, evaluator);
            case 6:
                return createText2(context, parent, evaluator);
            }
            throw new NoSuchComponentException(id);
        }
        
        private UIComponent createView(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIViewRootEx2 result = new UIViewRootEx2();
            initViewRoot(result);
            return result;
        }

        private UIComponent createDiv(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("div");
            component.addAttribute("id", "entirety");
            return component;
        }

        private UIComponent createDiv2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("div");
            component.addAttribute("id", "header");
            return component;
        }

        private UIComponent createH1(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("h1");
            return component;
        }

        private UIComponent createText(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "header/h1[1]/xp:text[1]/@value";
            String valueExpr = "#{database.title}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createDiv3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("div");
            component.addAttribute("id", "content");
            return component;
        }

        private UIComponent createCallback(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspCallback result = new XspCallback();
            return result;
        }

        private UIComponent createDiv4(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("div");
            component.addAttribute("id", "footer");
            return component;
        }

        private UIComponent createImage(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspGraphicImage result = new XspGraphicImage();
            result.setUrl("/turtle.png");
            return result;
        }

        private UIComponent createText2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "footer/xp:text[1]/@value";
            String valueExpr = "Server: #{facesContext.externalContext.request.session.servletContext.serverInfo}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

    }
}
