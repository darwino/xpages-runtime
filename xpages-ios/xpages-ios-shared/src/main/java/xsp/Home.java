/*
 * Generated file. 
 * 
 * Home.java
 */
package xsp;

import com.ibm.xsp.page.compiled.AbstractCompiledPage;
import com.ibm.xsp.page.compiled.AbstractCompiledPageDispatcher;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import com.ibm.xsp.page.compiled.NoSuchComponentException;
import com.ibm.xsp.page.compiled.PageExpressionEvaluator;
import java.lang.String;
import java.lang.Object;
import java.lang.Integer;
import com.ibm.xsp.component.UIViewRootEx2;
import com.ibm.xsp.component.UIIncludeComposite;
import com.ibm.xsp.component.UIPassThroughTag;
import com.ibm.xsp.component.xp.XspOutputLink;
import com.ibm.xsp.component.xp.XspViewPanel;
import com.ibm.xsp.model.domino.DominoViewData;
import com.ibm.xsp.component.xp.XspViewColumn;
import com.ibm.xsp.component.xp.XspViewColumnHeader;
import com.ibm.xsp.component.xp.XspPager;

@SuppressWarnings("all")
public class Home extends AbstractCompiledPageDispatcher{
    
    public Home() {
        super("3.0");
    }

    protected AbstractCompiledPage createPage(int pageIndex) {
        return new HomePage();
    }
    
    public static class HomePage extends AbstractCompiledPage {
        
        private static final ComponentInfo[] s_infos = new ComponentInfo[]{
            ComponentInfo.EMPTY_NORMAL, // 0 link
            new ComponentInfo(true, new int[]{0}), // 1 div
            ComponentInfo.EMPTY_NORMAL, // 2 "viewcolumnheader1"
            new ComponentInfo(false, new int[]{2}), // 3 "viewcolumn1"
            ComponentInfo.EMPTY_NORMAL, // 4 "viewcolumnheader2"
            new ComponentInfo(false, new int[]{4}), // 5 "viewcolumn2"
            ComponentInfo.EMPTY_NORMAL, // 6 "viewcolumnheader3"
            new ComponentInfo(false, new int[]{6}), // 7 "viewcolumn3"
            ComponentInfo.EMPTY_NORMAL, // 8 "pager1"
            new ComponentInfo(false, new int[]{3, 5, 7}, // 9 "viewpanel1"
              new Object[][]{
                new Object[]{"headerPager", Integer.valueOf(8)},
              } ),
            new ComponentInfo(false, new int[]{1, 9}), // 10 layout
            new ComponentInfo(false, new int[]{10}), // 11 view
        };
        
        public HomePage() {
            super(11, s_infos );
        }
        
        public int getComponentForId(String id) throws NoSuchComponentException { 
            if( "viewpanel1".equals(id) )
                return 9;
            if( "viewcolumn1".equals(id) )
                return 3;
            if( "viewcolumnheader1".equals(id) )
                return 2;
            if( "viewcolumn2".equals(id) )
                return 5;
            if( "viewcolumnheader2".equals(id) )
                return 4;
            if( "viewcolumn3".equals(id) )
                return 7;
            if( "viewcolumnheader3".equals(id) )
                return 6;
            if( "pager1".equals(id) )
                return 8;
            return -1;
        }
        
        public UIComponent createComponent(int id, FacesContext context,
                UIComponent parent, PageExpressionEvaluator evaluator)
                throws NoSuchComponentException { 
            switch (id) {
            case 11:
                return createView(context, parent, evaluator);
            case 10:
                return createLayout(context, parent, evaluator);
            case 1:
                return createDiv(context, parent, evaluator);
            case 0:
                return createLink(context, parent, evaluator);
            case 9:
                return createViewpanel1(context, parent, evaluator);
            case 3:
                return createViewcolumn1(context, parent, evaluator);
            case 2:
                return createViewcolumnheader1(context, parent, evaluator);
            case 5:
                return createViewcolumn2(context, parent, evaluator);
            case 4:
                return createViewcolumnheader2(context, parent, evaluator);
            case 7:
                return createViewcolumn3(context, parent, evaluator);
            case 6:
                return createViewcolumnheader3(context, parent, evaluator);
            case 8:
                return createPager1(context, parent, evaluator);
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

        private UIComponent createDiv(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("div");
            component.addAttribute("class", "actions");
            return component;
        }

        private UIComponent createLink(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputLink result = new XspOutputLink();
            result.setValue("/contact.xsp?action=NewDocument");
            result.setText("New Contact");
            return result;
        }

        private UIComponent createViewpanel1(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspViewPanel result = new XspViewPanel();
            result.setRows(30);
            DominoViewData data = new DominoViewData();
            data.setComponent(result);
            data.setViewName("Contacts");
            data.setVar("view1");
            result.setData(data);
            result.setPageName("/contact.xsp");
            setId(result, "viewPanel1");
            return result;
        }

        private UIComponent createViewcolumn1(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspViewColumn result = new XspViewColumn();
            result.setColumnName("LastName");
            result.setDisplayAs("link");
            setId(result, "viewColumn1");
            return result;
        }

        private UIComponent createViewcolumnheader1(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspViewColumnHeader result = new XspViewColumnHeader();
            result.setValue("Last Name");
            setId(result, "viewColumnHeader1");
            return result;
        }

        private UIComponent createViewcolumn2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspViewColumn result = new XspViewColumn();
            result.setColumnName("FirstName");
            setId(result, "viewColumn2");
            return result;
        }

        private UIComponent createViewcolumnheader2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspViewColumnHeader result = new XspViewColumnHeader();
            result.setValue("First Name");
            setId(result, "viewColumnHeader2");
            return result;
        }

        private UIComponent createViewcolumn3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspViewColumn result = new XspViewColumn();
            result.setColumnName("EmailAddress");
            setId(result, "viewColumn3");
            return result;
        }

        private UIComponent createViewcolumnheader3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspViewColumnHeader result = new XspViewColumnHeader();
            result.setValue("Email Address");
            setId(result, "viewColumnHeader3");
            return result;
        }

        private UIComponent createPager1(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspPager result = new XspPager();
            result.setPartialRefresh(true);
            result.setLayout("Previous Group Next");
            setId(result, "pager1");
            return result;
        }

    }
}
