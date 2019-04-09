// Warning: No line numbers available in class file
package java.beans;

public interface Visibility {
    boolean needsGui();

    void dontUseGui();

    void okToUseGui();

    boolean avoidingGui();
}