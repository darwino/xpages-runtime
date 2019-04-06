/*
 * Generated file. 
 * 
 * Extlib.java
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
import com.ibm.xsp.extlib.component.dojo.layout.UIDojoTabContainer;
import com.ibm.xsp.extlib.component.dojo.layout.UIDojoTabPane;
import com.ibm.xsp.component.UIPassThroughText;

@SuppressWarnings("all")
public class Extlib extends AbstractCompiledPageDispatcher{
    
    public Extlib() {
        super("3.0");
    }

    protected AbstractCompiledPage createPage(int pageIndex) {
        return new ExtlibPage();
    }
    
    public static class ExtlibPage extends AbstractCompiledPage {
        
        private static final ComponentInfo[] s_infos = new ComponentInfo[]{
            ComponentInfo.EMPTY_MARKUP, // 0 text
            new ComponentInfo(false, new int[]{0}), // 1 djTabPane
            ComponentInfo.EMPTY_MARKUP, // 2 text2
            new ComponentInfo(false, new int[]{2}), // 3 djTabPane2
            new ComponentInfo(false, new int[]{1, 3}), // 4 "djtabcontainer1"
            new ComponentInfo(false, new int[]{4}), // 5 "layout"
            new ComponentInfo(false, new int[]{5}), // 6 view
        };
        
        public ExtlibPage() {
            super(6, s_infos );
        }
        
        public int getComponentForId(String id) throws NoSuchComponentException { 
            if( "layout".equals(id) )
                return 5;
            if( "djtabcontainer1".equals(id) )
                return 4;
            return -1;
        }
        
        public UIComponent createComponent(int id, FacesContext context,
                UIComponent parent, PageExpressionEvaluator evaluator)
                throws NoSuchComponentException { 
            switch (id) {
            case 6:
                return createView(context, parent, evaluator);
            case 5:
                return createLayout(context, parent, evaluator);
            case 4:
                return createDjtabcontainer1(context, parent, evaluator);
            case 1:
                return createDjTabPane(context, parent, evaluator);
            case 0:
                return createText(context, parent, evaluator);
            case 3:
                return createDjTabPane2(context, parent, evaluator);
            case 2:
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

        private UIComponent createLayout(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            String resultPage = "/layout.xsp";
            UIIncludeComposite result = new UIIncludeComposite();
            result.setPageDriver(getPageParam().getPageDriver());
            result.setPageName(resultPage);
            setId(result, "layout");
            return result;
        }

        private UIComponent createDjtabcontainer1(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIDojoTabContainer result = new UIDojoTabContainer();
            result.setDoLayout(false);
            setId(result, "djTabContainer1");
            return result;
        }

        private UIComponent createDjTabPane(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIDojoTabPane result = new UIDojoTabPane();
            result.setTitle("Dojo Tab Pane");
            result.setPartialRefresh(true);
            return result;
        }

        private UIComponent createText(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            String text = "I\'m partial-refresh-loaded Dojo tab pane content";
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText(text);
            return textComp;
        }

        private UIComponent createDjTabPane2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIDojoTabPane result = new UIDojoTabPane();
            result.setTitle("Dojo Tab Pane 2");
            result.setPartialRefresh(true);
            return result;
        }

        private UIComponent createText2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            String text = "I\'m partial-refresh-loaded Dojo tab pane content #2";
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText(text);
            return textComp;
        }

    }
}
