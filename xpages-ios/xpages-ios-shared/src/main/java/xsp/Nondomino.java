/*
 * Generated file. 
 * 
 * Nondomino.java
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
import com.ibm.xsp.component.UIIncludeComposite;
import com.ibm.xsp.component.UIPassThroughTag;
import com.ibm.xsp.component.UIPassThroughText;
import com.ibm.xsp.component.xp.XspDiv;
import com.ibm.xsp.component.xp.XspOutputText;
import java.lang.Object;
import javax.faces.el.ValueBinding;
import com.ibm.xsp.component.xp.XspCommandButton;
import com.ibm.xsp.component.xp.XspEventHandler;

@SuppressWarnings("all")
public class Nondomino extends AbstractCompiledPageDispatcher{
    
    public Nondomino() {
        super("3.0");
    }

    protected AbstractCompiledPage createPage(int pageIndex) {
        return new NondominoPage();
    }
    
    public static class NondominoPage extends AbstractCompiledPage {
        
        private static final ComponentInfo[] s_infos = new ComponentInfo[]{
            ComponentInfo.EMPTY_MARKUP, // 0 text
            new ComponentInfo(true, new int[]{0}), // 1 p
            ComponentInfo.EMPTY_NORMAL, // 2 text2
            new ComponentInfo(true, new int[]{2}), // 3 p2
            new ComponentInfo(false, new int[]{3}), // 4 "refresher"
            ComponentInfo.EMPTY_NORMAL, // 5 eventHandler
            new ComponentInfo(false, new int[]{5}), // 6 "refresh"
            new ComponentInfo(false, new int[]{1, 4, 6}), // 7 layout
            new ComponentInfo(false, new int[]{7}), // 8 view
        };
        
        public NondominoPage() {
            super(8, s_infos );
        }
        
        public int getComponentForId(String id) throws NoSuchComponentException { 
            if( "refresher".equals(id) )
                return 4;
            if( "refresh".equals(id) )
                return 6;
            return -1;
        }
        
        public UIComponent createComponent(int id, FacesContext context,
                UIComponent parent, PageExpressionEvaluator evaluator)
                throws NoSuchComponentException { 
            switch (id) {
            case 8:
                return createView(context, parent, evaluator);
            case 7:
                return createLayout(context, parent, evaluator);
            case 1:
                return createP(context, parent, evaluator);
            case 0:
                return createText(context, parent, evaluator);
            case 4:
                return createRefresher(context, parent, evaluator);
            case 3:
                return createP2(context, parent, evaluator);
            case 2:
                return createText2(context, parent, evaluator);
            case 6:
                return createRefresh(context, parent, evaluator);
            case 5:
                return createEventHandler(context, parent, evaluator);
            }
            throw new NoSuchComponentException(id);
        }
        
        private UIComponent createView(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIViewRootEx2 result = new UIViewRootEx2();
            initViewRoot(result);
            return result;
        }

        private UIComponent createLayout(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            String resultPage = "/layout.xsp";
            UIIncludeComposite result = new UIIncludeComposite();
            result.setPageDriver(getPageParam().getPageDriver());
            result.setPageName(resultPage);
            return result;
        }

        private UIComponent createP(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("p");
            return component;
        }

        private UIComponent createText(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("Page loaded!");
            return textComp;
        }

        private UIComponent createRefresher(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspDiv result = new XspDiv();
            setId(result, "refresher");
            return result;
        }

        private UIComponent createP2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("p");
            return component;
        }

        private UIComponent createText2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "refresher/p[1]/xp:text[1]/@value";
            String valueExpr = "Random string: #{randomString.randomString}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createRefresh(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspCommandButton result = new XspCommandButton();
            result.setValue("Refresh");
            setId(result, "refresh");
            return result;
        }

        private UIComponent createEventHandler(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspEventHandler result = new XspEventHandler();
            result.setRefreshId("refresher");
            result.setSubmit(true);
            result.setEvent("onclick");
            result.setRefreshMode("partial");
            return result;
        }

    }
}
