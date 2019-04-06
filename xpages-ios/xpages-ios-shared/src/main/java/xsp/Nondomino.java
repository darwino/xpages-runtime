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
import com.ibm.xsp.resource.ScriptResource;
import com.ibm.xsp.component.FacesPageProvider;
import com.ibm.xsp.component.UIViewRootEx2;
import com.ibm.xsp.component.UIIncludeComposite;
import com.ibm.xsp.component.UIPassThroughTag;
import com.ibm.xsp.component.xp.XspOutputText;
import com.ibm.xsp.component.xp.XspDiv;
import java.lang.Object;
import javax.faces.el.ValueBinding;
import com.ibm.xsp.component.xp.XspCommandButton;
import com.ibm.xsp.component.xp.XspEventHandler;
import com.ibm.xsp.component.UIPassThroughText;
import java.lang.Boolean;

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
            ComponentInfo.EMPTY_NORMAL, // 0 text
            new ComponentInfo(true, new int[]{0}), // 1 p
            ComponentInfo.EMPTY_NORMAL, // 2 text2
            new ComponentInfo(true, new int[]{2}), // 3 p2
            ComponentInfo.EMPTY_NORMAL, // 4 text3
            new ComponentInfo(true, new int[]{4}), // 5 p3
            ComponentInfo.EMPTY_NORMAL, // 6 text4
            new ComponentInfo(true, new int[]{6}), // 7 p4
            new ComponentInfo(false, new int[]{3, 5, 7}), // 8 "refresher"
            ComponentInfo.EMPTY_NORMAL, // 9 eventHandler
            new ComponentInfo(false, new int[]{9}), // 10 "refresh"
            ComponentInfo.EMPTY_MARKUP, // 11 text5
            new ComponentInfo(true, new int[]{11}), // 12 legend
            ComponentInfo.EMPTY_MARKUP, // 13 text6
            new ComponentInfo(true, new int[]{13}), // 14 dt
            ComponentInfo.EMPTY_NORMAL, // 15 text7
            new ComponentInfo(true, new int[]{15}), // 16 dd
            ComponentInfo.EMPTY_MARKUP, // 17 text8
            new ComponentInfo(true, new int[]{17}), // 18 dt2
            ComponentInfo.EMPTY_NORMAL, // 19 text9
            new ComponentInfo(true, new int[]{19}), // 20 dd2
            ComponentInfo.EMPTY_MARKUP, // 21 text10
            new ComponentInfo(true, new int[]{21}), // 22 dt3
            ComponentInfo.EMPTY_NORMAL, // 23 text11
            new ComponentInfo(true, new int[]{23}), // 24 dd3
            ComponentInfo.EMPTY_MARKUP, // 25 text12
            new ComponentInfo(true, new int[]{25}), // 26 dt4
            ComponentInfo.EMPTY_NORMAL, // 27 text13
            new ComponentInfo(true, new int[]{27}), // 28 dd4
            new ComponentInfo(true, new int[]{14, 16, 18, 20, 22, 24, 26, 28}), // 29 dl
            new ComponentInfo(true, new int[]{12, 29}), // 30 fieldset
            new ComponentInfo(false, new int[]{1, 8, 10, 30}), // 31 "layout"
            new ComponentInfo(false, new int[]{31}), // 32 view
        };
        
        public NondominoPage() {
            super(32, s_infos );
        }
        
        public int getComponentForId(String id) throws NoSuchComponentException { 
            if( "layout".equals(id) )
                return 31;
            if( "refresher".equals(id) )
                return 8;
            if( "refresh".equals(id) )
                return 10;
            return -1;
        }
        
        public UIComponent createComponent(int id, FacesContext context,
                UIComponent parent, PageExpressionEvaluator evaluator)
                throws NoSuchComponentException { 
            switch (id) {
            case 32:
                return createView(context, parent, evaluator);
            case 31:
                return createLayout(context, parent, evaluator);
            case 1:
                return createP(context, parent, evaluator);
            case 0:
                return createText(context, parent, evaluator);
            case 8:
                return createRefresher(context, parent, evaluator);
            case 3:
                return createP2(context, parent, evaluator);
            case 2:
                return createText2(context, parent, evaluator);
            case 5:
                return createP3(context, parent, evaluator);
            case 4:
                return createText3(context, parent, evaluator);
            case 7:
                return createP4(context, parent, evaluator);
            case 6:
                return createText4(context, parent, evaluator);
            case 10:
                return createRefresh(context, parent, evaluator);
            case 9:
                return createEventHandler(context, parent, evaluator);
            case 30:
                return createFieldset(context, parent, evaluator);
            case 12:
                return createLegend(context, parent, evaluator);
            case 11:
                return createText5(context, parent, evaluator);
            case 29:
                return createDl(context, parent, evaluator);
            case 14:
                return createDt(context, parent, evaluator);
            case 13:
                return createText6(context, parent, evaluator);
            case 16:
                return createDd(context, parent, evaluator);
            case 15:
                return createText7(context, parent, evaluator);
            case 18:
                return createDt2(context, parent, evaluator);
            case 17:
                return createText8(context, parent, evaluator);
            case 20:
                return createDd2(context, parent, evaluator);
            case 19:
                return createText9(context, parent, evaluator);
            case 22:
                return createDt3(context, parent, evaluator);
            case 21:
                return createText10(context, parent, evaluator);
            case 24:
                return createDd3(context, parent, evaluator);
            case 23:
                return createText11(context, parent, evaluator);
            case 26:
                return createDt4(context, parent, evaluator);
            case 25:
                return createText12(context, parent, evaluator);
            case 28:
                return createDd4(context, parent, evaluator);
            case 27:
                return createText13(context, parent, evaluator);
            }
            throw new NoSuchComponentException(id);
        }
        
        protected void initIncluderAsRoot(FacesContext context,
                PageExpressionEvaluator evaluator, UIComponent root) {
            ScriptResource resources = new ScriptResource();
            resources.setComponent(root);
            resources.setClientSide(false);
            resources.setSrc("/contactForm.jss");
            FacesPageProvider asPageProvider = root instanceof FacesPageProvider ?
                    (FacesPageProvider) root : null;
            if( null != asPageProvider ){
                asPageProvider.addResource(resources);
            }
        }

        private UIComponent createView(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIViewRootEx2 result = new UIViewRootEx2();
            initViewRoot(result);
            ScriptResource resources = new ScriptResource();
            resources.setComponent(result);
            resources.setClientSide(false);
            resources.setSrc("/contactForm.jss");
            result.addResource(resources);
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

        private UIComponent createP(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("p");
            return component;
        }

        private UIComponent createText(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            result.setValue("Page loaded!");
            return result;
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
            String valueBnd = "Loaded at #{javascript: java.lang.System.currentTimeMillis().toString()}";
            String sourceId = "refresher/p[1]/xp:text[1]/@value";
            Object value = evaluator.getBindingValue(result, valueBnd, sourceId, Object.class);
            evaluator.setValue(result, "value", value, false, false);
            return result;
        }

        private UIComponent createP3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("p");
            return component;
        }

        private UIComponent createText3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "refresher/p[2]/xp:text[1]/@value";
            String valueExpr = "Refresher refreshed at #{javascript: java.lang.System.currentTimeMillis().toString()}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createP4(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("p");
            return component;
        }

        private UIComponent createText4(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "refresher/p[3]/xp:text[1]/@value";
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

        private UIComponent createFieldset(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("fieldset");
            return component;
        }

        private UIComponent createLegend(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("legend");
            return component;
        }

        private UIComponent createText5(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("Diag");
            return textComp;
        }

        private UIComponent createDl(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dl");
            return component;
        }

        private UIComponent createDt(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dt");
            return component;
        }

        private UIComponent createText6(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("View root renderer");
            return textComp;
        }

        private UIComponent createDd(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dd");
            return component;
        }

        private UIComponent createText7(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "layout/fieldset[1]/dl[1]/dd[1]/xp:text[1]/@value";
            String valueExpr = "#{javascript: view.getRenderer(facesContext).getWrapped()}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createDt2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dt");
            return component;
        }

        private UIComponent createText8(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("xc:layout renderer");
            return textComp;
        }

        private UIComponent createDd2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dd");
            return component;
        }

        private UIComponent createText9(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "layout/fieldset[1]/dl[1]/dd[2]/xp:text[1]/@value";
            String valueExpr = "#{javascript: getComponent(\'layout\').getRenderer(facesContext).getWrapped()}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createDt3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dt");
            return component;
        }

        private UIComponent createText10(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("styleKit");
            return textComp;
        }

        private UIComponent createDd3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dd");
            return component;
        }

        private UIComponent createText11(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputText result = new XspOutputText();
            String sourceId = "layout/fieldset[1]/dl[1]/dd[3]/xp:text[1]/@value";
            String valueExpr = "#{facesContext.styleKit}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

        private UIComponent createDt4(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dt");
            return component;
        }

        private UIComponent createText12(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("styleKit name");
            return textComp;
        }

        private UIComponent createDd4(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dd");
            return component;
        }

        private UIComponent createText13(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            // loaded=??
            String loadedBnd = "#{not empty facesContext.styleKit}";
            String sourceId = "layout/fieldset[1]/dl[1]/dd[4]/xp:text[1]/@loaded";
            String loaded = evaluator.evaluateAsString(null, loadedBnd, sourceId, boolean.class);
            if ( null != loaded && loaded.length() > 0 &&
                    ! Boolean.parseBoolean(loaded) ) {
                return null;
            } // else loaded was true
            XspOutputText result = new XspOutputText();
            String sourceId2 = "layout/fieldset[1]/dl[1]/dd[4]/xp:text[1]/@value";
            String valueExpr = "#{facesContext.styleKit.name}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId2,Object.class);
            result.setValueBinding("value", value);
            return result;
        }

    }
}
