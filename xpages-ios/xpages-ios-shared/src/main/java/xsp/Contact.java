/*
 * Generated file. 
 * 
 * Contact.java
 */
package xsp;

import com.ibm.xsp.page.compiled.AbstractCompiledPage;
import com.ibm.xsp.page.compiled.AbstractCompiledPageDispatcher;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import com.ibm.xsp.page.compiled.NoSuchComponentException;
import com.ibm.xsp.page.compiled.PageExpressionEvaluator;
import java.lang.String;
import com.ibm.xsp.application.NavigationRule;
import com.ibm.xsp.component.FacesPageProvider;
import com.ibm.xsp.resource.ScriptResource;
import com.ibm.xsp.model.domino.DominoDocumentData;
import com.ibm.xsp.component.FacesDataProvider;
import com.ibm.xsp.component.UIViewRootEx2;
import com.ibm.xsp.component.UIIncludeComposite;
import com.ibm.xsp.component.UIPassThroughTag;
import com.ibm.xsp.component.xp.XspOutputLink;
import com.ibm.xsp.component.xp.XspEventHandler;
import javax.faces.el.MethodBinding;
import com.ibm.xsp.component.xp.XspDiv;
import com.ibm.xsp.component.UIPassThroughText;
import com.ibm.xsp.component.xp.XspInputText;
import java.lang.Object;
import javax.faces.el.ValueBinding;
import com.ibm.xsp.component.xp.XspCommandButton;
import com.ibm.xsp.actions.DeleteDocumentAction;

@SuppressWarnings("all")
public class Contact extends AbstractCompiledPageDispatcher{
    
    public Contact() {
        super("8.5.3"); // version of xp:inputText type
    }

    protected AbstractCompiledPage createPage(int pageIndex) {
        return new ContactPage();
    }
    
    public static class ContactPage extends AbstractCompiledPage {
        
        private static final ComponentInfo[] s_infos = new ComponentInfo[]{
            ComponentInfo.EMPTY_NORMAL, // 0 eventHandler
            new ComponentInfo(false, new int[]{0}), // 1 "randomize"
            new ComponentInfo(true, new int[]{1}), // 2 div
            ComponentInfo.EMPTY_MARKUP, // 3 text
            new ComponentInfo(true, new int[]{3}), // 4 dt
            ComponentInfo.EMPTY_NORMAL, // 5 inputText
            new ComponentInfo(true, new int[]{5}), // 6 dd
            ComponentInfo.EMPTY_MARKUP, // 7 text2
            new ComponentInfo(true, new int[]{7}), // 8 dt2
            ComponentInfo.EMPTY_NORMAL, // 9 inputText2
            new ComponentInfo(true, new int[]{9}), // 10 dd2
            ComponentInfo.EMPTY_MARKUP, // 11 text3
            new ComponentInfo(true, new int[]{11}), // 12 dt3
            ComponentInfo.EMPTY_NORMAL, // 13 inputText3
            new ComponentInfo(true, new int[]{13}), // 14 dd3
            new ComponentInfo(true, new int[]{4, 6, 8, 10, 12, 14}), // 15 dl
            new ComponentInfo(false, new int[]{15}), // 16 "form"
            ComponentInfo.EMPTY_NORMAL, // 17 eventHandler2
            new ComponentInfo(false, new int[]{17}), // 18 "delete"
            new ComponentInfo(true, new int[]{18}), // 19 div3
            ComponentInfo.EMPTY_NORMAL, // 20 eventHandler3
            new ComponentInfo(false, new int[]{20}), // 21 "save"
            ComponentInfo.EMPTY_NORMAL, // 22 link
            new ComponentInfo(true, new int[]{19, 21, 22}), // 23 div2
            new ComponentInfo(false, new int[]{2, 16, 23}), // 24 layout
            new ComponentInfo(false, new int[]{24}), // 25 view
        };
        
        public ContactPage() {
            super(25, s_infos );
        }
        
        public int getComponentForId(String id) throws NoSuchComponentException { 
            if( "randomize".equals(id) )
                return 1;
            if( "form".equals(id) )
                return 16;
            if( "delete".equals(id) )
                return 18;
            if( "save".equals(id) )
                return 21;
            return -1;
        }
        
        public UIComponent createComponent(int id, FacesContext context,
                UIComponent parent, PageExpressionEvaluator evaluator)
                throws NoSuchComponentException { 
            switch (id) {
            case 25:
                return createView(context, parent, evaluator);
            case 24:
                return createLayout(context, parent, evaluator);
            case 2:
                return createDiv(context, parent, evaluator);
            case 1:
                return createRandomize(context, parent, evaluator);
            case 0:
                return createEventHandler(context, parent, evaluator);
            case 16:
                return createForm(context, parent, evaluator);
            case 15:
                return createDl(context, parent, evaluator);
            case 4:
                return createDt(context, parent, evaluator);
            case 3:
                return createText(context, parent, evaluator);
            case 6:
                return createDd(context, parent, evaluator);
            case 5:
                return createInputText(context, parent, evaluator);
            case 8:
                return createDt2(context, parent, evaluator);
            case 7:
                return createText2(context, parent, evaluator);
            case 10:
                return createDd2(context, parent, evaluator);
            case 9:
                return createInputText2(context, parent, evaluator);
            case 12:
                return createDt3(context, parent, evaluator);
            case 11:
                return createText3(context, parent, evaluator);
            case 14:
                return createDd3(context, parent, evaluator);
            case 13:
                return createInputText3(context, parent, evaluator);
            case 23:
                return createDiv2(context, parent, evaluator);
            case 19:
                return createDiv3(context, parent, evaluator);
            case 18:
                return createDelete(context, parent, evaluator);
            case 17:
                return createEventHandler2(context, parent, evaluator);
            case 21:
                return createSave(context, parent, evaluator);
            case 20:
                return createEventHandler3(context, parent, evaluator);
            case 22:
                return createLink(context, parent, evaluator);
            }
            throw new NoSuchComponentException(id);
        }
        
        protected void initIncluderAsRoot(FacesContext context,
                PageExpressionEvaluator evaluator, UIComponent root) {
            NavigationRule navigationRules = new NavigationRule();
            navigationRules.setViewId("/home.xsp");
            navigationRules.setOutcome("xsp-success");
            FacesPageProvider asPageProvider = root instanceof FacesPageProvider ?
                    (FacesPageProvider) root : null;
            if( null != asPageProvider ){
                asPageProvider.addNavigationRule(navigationRules);
            }
            ScriptResource resources = new ScriptResource();
            resources.setComponent(root);
            resources.setClientSide(false);
            resources.setSrc("/contactForm.jss");
            if( null != asPageProvider ){
                asPageProvider.addResource(resources);
            }
            DominoDocumentData data = new DominoDocumentData();
            data.setComponent(root);
            data.setVar("doc");
            data.setFormName("Contact");
            FacesDataProvider asDataProvider = root instanceof FacesDataProvider ?
                    (FacesDataProvider) root : null;
            if( null != asDataProvider ){
                asDataProvider.addData(data);
            }
        }

        private UIComponent createView(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIViewRootEx2 result = new UIViewRootEx2();
            initViewRoot(result);
            NavigationRule navigationRules = new NavigationRule();
            navigationRules.setViewId("/home.xsp");
            navigationRules.setOutcome("xsp-success");
            result.addNavigationRule(navigationRules);
            ScriptResource resources = new ScriptResource();
            resources.setComponent(result);
            resources.setClientSide(false);
            resources.setSrc("/contactForm.jss");
            result.addResource(resources);
            DominoDocumentData data = new DominoDocumentData();
            data.setComponent(result);
            data.setVar("doc");
            data.setFormName("Contact");
            result.addData(data);
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

        private UIComponent createRandomize(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputLink result = new XspOutputLink();
            setId(result, "randomize");
            result.setText("Randomize Name");
            return result;
        }

        private UIComponent createEventHandler(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspEventHandler result = new XspEventHandler();
            String sourceId = "randomize/xp:eventHandler[1]/xp:this.action[1]/text()";
            MethodBinding action = evaluator.createMethodBinding(result,
                    "#{javascript:\n\t\t\t\t\t\tdoc.replaceItemValue(\"FirstName\", generateRandomString());\n\t\t\t\t\t\tdoc.replaceItemValue(\"LastName\", generateRandomString());\n\t\t\t\t\t}",
                    null,null, sourceId);
            result.setAction(action);
            result.setRefreshId("form");
            result.setSubmit(true);
            result.setDisableValidators(true);
            result.setEvent("onclick");
            result.setRefreshMode("partial");
            return result;
        }

        private UIComponent createForm(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspDiv result = new XspDiv();
            result.setStyleClass("contact-form");
            setId(result, "form");
            return result;
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

        private UIComponent createText(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("First Name");
            return textComp;
        }

        private UIComponent createDd(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dd");
            return component;
        }

        private UIComponent createInputText(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspInputText result = new XspInputText();
            String sourceId = "form/dl[1]/dd[1]/xp:inputText[1]/@value";
            String valueExpr = "#{doc.FirstName}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            result.setRequired(true);
            return result;
        }

        private UIComponent createDt2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dt");
            return component;
        }

        private UIComponent createText2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("Last Name");
            return textComp;
        }

        private UIComponent createDd2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dd");
            return component;
        }

        private UIComponent createInputText2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspInputText result = new XspInputText();
            String sourceId = "form/dl[1]/dd[2]/xp:inputText[1]/@value";
            String valueExpr = "#{doc.LastName}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            result.setRequired(true);
            return result;
        }

        private UIComponent createDt3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dt");
            return component;
        }

        private UIComponent createText3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughText textComp = new UIPassThroughText();
            textComp.setText("Email Address");
            return textComp;
        }

        private UIComponent createDd3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("dd");
            return component;
        }

        private UIComponent createInputText3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspInputText result = new XspInputText();
            String sourceId = "form/dl[1]/dd[3]/xp:inputText[1]/@value";
            String valueExpr = "#{doc.EmailAddress}";
            ValueBinding value = evaluator.createValueBinding(result, valueExpr, sourceId,Object.class);
            result.setValueBinding("value", value);
            result.setType("email");
            result.setRequired(true);
            return result;
        }

        private UIComponent createDiv2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("div");
            component.addAttribute("class", "actions");
            return component;
        }

        private UIComponent createDiv3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            UIPassThroughTag component = new UIPassThroughTag();
            component.setTag("div");
            component.addAttribute("style", "float: right");
            return component;
        }

        private UIComponent createDelete(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspCommandButton result = new XspCommandButton();
            result.setValue("Delete");
            String sourceId = "delete/@rendered";
            String renderedExpr = "#{javascript:!doc.isNewNote()}";
            ValueBinding rendered = evaluator.createValueBinding(result, renderedExpr, sourceId,boolean.class);
            result.setValueBinding("rendered", rendered);
            setId(result, "delete");
            return result;
        }

        private UIComponent createEventHandler2(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspEventHandler result = new XspEventHandler();
            DeleteDocumentAction action = new DeleteDocumentAction();
            action.setComponent(result);
            action.setVar("doc");
            action.setMessage("Delete this document?");
            action.setName("/home.xsp");
            action.setSourceReferenceId("delete/xp:eventHandler[1]/xp:this.action[1]/xp:deleteDocument[1]");
            result.setAction(action);
            result.setSubmit(true);
            result.setEvent("onclick");
            result.setRefreshMode("complete");
            return result;
        }

        private UIComponent createSave(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspCommandButton result = new XspCommandButton();
            result.setValue("Save");
            setId(result, "save");
            return result;
        }

        private UIComponent createEventHandler3(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspEventHandler result = new XspEventHandler();
            result.setImmediate(false);
            result.setSubmit(true);
            result.setEvent("onclick");
            result.setSave(true);
            result.setRefreshMode("complete");
            return result;
        }

        private UIComponent createLink(FacesContext context, 
                UIComponent parent, PageExpressionEvaluator evaluator) {
            XspOutputLink result = new XspOutputLink();
            result.setValue("/home.xsp");
            result.setText("Cancel");
            return result;
        }

    }
}
