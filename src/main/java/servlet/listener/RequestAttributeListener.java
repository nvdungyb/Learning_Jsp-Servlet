package servlet.listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Attribute method has been called in " + this.getClass().getName());
        System.out.println("Attribute name: " + srae.getName() + " Attribute value: " + srae.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("Removed attribute " + srae.getName() + " in " + this.getClass().getName());
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Replaced attribute " + srae.getName() + " Attribute value " + srae.getValue());
    }

}
