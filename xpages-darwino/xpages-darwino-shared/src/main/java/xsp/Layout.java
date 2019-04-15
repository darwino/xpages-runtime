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
import com.ibm.xsp.component.xp.XspGraphicImage;
import javax.faces.el.ValueBinding;
import com.ibm.xsp.component.xp.XspOutputText;
import java.lang.Object;
import com.ibm.xsp.component.xp.XspCallback;
import com.ibm.xsp.component.xp.XspOutputLink;

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
            ComponentInfo.EMPTY_NORMAL, // 0 image
            ComponentInfo.EMPTY_NORMAL, // 1 text
            new ComponentInfo(true, new int[]{0, 1}), // 2 h1
            new ComponentInfo(true, new int[]{2}), // 3 div2
            ComponentInfo.EMPTY_NORMAL, // 4 callback
            new ComponentInfo(true, new int[]{4}), // 5 div3
            ComponentInfo.EMPTY_NORMAL, // 6 text2
            ComponentInfo.EMPTY_MARKUP, // 7 br
            ComponentInfo.EMPTY_NORMAL, // 8 text3
            ComponentInfo.EMPTY_MARKUP, // 9 br2
            ComponentInfo.EMPTY_NORMAL, // 10 text4
            new ComponentInfo(true, new int[]{6, 7, 8, 9, 10}), // 11 p
            ComponentInfo.EMPTY_NORMAL, // 12 link
            new ComponentInfo(true, new int[]{12}), // 13 li
            ComponentInfo.EMPTY_NORMAL, // 14 link2
            new ComponentInfo(true, new int[]{14}), // 15 li2
            ComponentInfo.EMPTY_NORMAL, // 16 link3
            new ComponentInfo(true, new int[]{16}), // 17 li3
            new ComponentInfo(true, new int[]{13, 15, 17}), // 18 ul
            new ComponentInfo(true, new int[]{11, 18}), // 19 div4
            new ComponentInfo(true, new int[]{3, 5, 19}), // 20 div
            new ComponentInfo(false, new int[]{20}), // 21 view
        };
        
        public LayoutPage() {
            super(21, s_infos );
        }
        
        public int getComponentForId(String id) throws NoSuchComponentException { 
            return -1;
        }
        
        public UIComponent createComponent(int id, FacesContext context,
                UIComponent parent, PageExpressionEvaluator evaluator)
                throws NoSuchComponentException { 
            switch (id) {
            case 21:
                return createView(context, parent, evaluator);
            case 20:
                return createDiv(context, parent, evaluator);
            case 3:
                return createDiv2(context, parent, evaluator);
            case 2:
                return createH1(context, parent, evaluator);
            case 0:
                return createImage(context, parent, evaluator);
            case 1:
                return createText(context, parent, evaluator);
            case 5:
                return createDiv3(context, parent, evaluator);
            case 4:
                return createCallback(context, parent, evaluator);
            case 19:
                return createDiv4(context, parent, evaluator);
            case 11:
                return createP(context, parent, evaluator);
            case 6:
                return createText2(context, parent, evaluator);
            case 7:
                return createBr(context, parent, evaluator);
            case 8:
                return createText3(context, parent, evaluator);
            case 9:
                return createBr2(context, parent, evaluator);
            case 10:
                return createText4(context, parent, evaluator);
            case 18:
                return createUl(context, parent, evaluator);
            case 13:
                return createLi(context, parent, evaluator);
            case 12:
                return createLink(context, parent, evaluator);
            case 15:
                return createLi2(context, parent, evaluator);
            case 14:
                return createLink2(context, parent, evaluator);
            case 17:
                return createLi3(context, parent, evaluator);
            case 16:
                return createLink3(context, parent, evaluator);
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

        private UIComponent createImage(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspGraphicImage result = new XspGraphicImage();
            String sourceId = "header/h1[1]/xp:image[1]/@url";
            String urlExpr = "#{env.iconPath}";
            ValueBinding url = evaluator.createValueBinding(result, urlExpr, sourceId,String.class);
            result.setValueBinding("url", url);
            return result;
        }

        private UIComponent createText(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "header/h1[1]/xp:text[1]/@value";
            String valueExpr = "#{database.title} on #{env.platformName}";
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

        private UIComponent createP(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("p");
            return component;
        }

        private UIComponent createText2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "footer/p[1]/xp:text[1]/@value";
            String valueExpr = "Server: #{facesContext.externalContext.request.session.servletContext.serverInfo}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createBr(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("br");
            return component;
        }

        private UIComponent createText3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "footer/p[1]/xp:text[2]/@value";
            String valueExpr = "Database: #{javascript: database ? database.getClass().getSimpleName() : \'\'}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createBr2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("br");
            return component;
        }

        private UIComponent createText4(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "footer/p[1]/xp:text[3]/@value";
            String valueExpr = "Environment: #{javascript: java.lang.System.getProperty(\'os.name\')} (Java via #{javascript: java.lang.System.getProperty(\'java.vendor\')})";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createUl(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("ul");
            component.addAttribute("class", "links");
            return component;
        }

        private UIComponent createLi(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("li");
            return component;
        }

        private UIComponent createLink(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputLink result = new XspOutputLink();
            result.setValue("/nondomino.xsp");
            result.setText("Non-Domino Test");
            return result;
        }

        private UIComponent createLi2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("li");
            return component;
        }

        private UIComponent createLink2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputLink result = new XspOutputLink();
            result.setValue("/extlib.xsp");
            result.setText("ExtLib Test");
            return result;
        }

        private UIComponent createLi3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("li");
            return component;
        }

        private UIComponent createLink3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputLink result = new XspOutputLink();
            result.setValue("/home.xsp");
            result.setText("Domino Data");
            return result;
        }

    }
}
