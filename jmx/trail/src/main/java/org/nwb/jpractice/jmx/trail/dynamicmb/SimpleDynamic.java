/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.dynamicmb;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Attribute;
import javax.management.AttributeChangeNotification;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;

/**
 * Dynamic MBean:
 *
 *
 *
 *
 * @author wangbo
 */
public class SimpleDynamic extends NotificationBroadcasterSupport implements DynamicMBean {
    
    private static final Logger LOGGER = Logger.getLogger(SimpleDynamic.class.getName());

    private String dClassName = this.getClass().getName();

    private String dDescription = "Simple Dynamic MBean";

    private MBeanInfo dMBeanInfo = null;

    private MBeanAttributeInfo[] dAttributes = new MBeanAttributeInfo[2];

    private MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];

    private MBeanOperationInfo[] dOperations = new MBeanOperationInfo[1];

    private MBeanNotificationInfo[] dNotifications = new MBeanNotificationInfo[1];

    // internal variables representing attributes 
    private String state = "initial state";

    private int nbChanges = 0;
    
    // internal variable
    private int nbResets = 0;

    public SimpleDynamic(){
        buildDynamicMBeanInfo();
    }
    
    private void buildDynamicMBeanInfo() {
        // attributes
        dAttributes[0] = new MBeanAttributeInfo("State", "java.lang.String", "State", true, true, false);
        dAttributes[1] = new MBeanAttributeInfo("NbChanges", "java.lang.Integer", "Number of State changed times", true, false, false);

        // constructors
        Constructor[] constructors = this.getClass().getConstructors();
        dConstructors[0] = new MBeanConstructorInfo("Constructs a SimpleDynamic object", constructors[0]);

        MBeanParameterInfo[] params = null;

        // operations
        dOperations[0] = new MBeanOperationInfo("reset", "reset State and NbChanges attributes to their initial values", params, "void", MBeanOperationInfo.ACTION);

        // notifications
        dNotifications[0] = new MBeanNotificationInfo(
            new String[]{AttributeChangeNotification.ATTRIBUTE_CHANGE}, 
            AttributeChangeNotification.class.getName(), 
            "This notification is emitted when the reset() method is called.");

        dMBeanInfo = new MBeanInfo(dClassName, dDescription, dAttributes, dConstructors, dOperations, dNotifications);
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        return dMBeanInfo;
    }

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        // Check attribute_name to avoid NullPointerException later on
        if (attribute == null) {
            throw new RuntimeOperationsException(
                new IllegalArgumentException("Attribute name cannot be null"),
                "Cannot invoke a getter of " + dClassName
                + " with null attribute name");
        }
        // Call the corresponding getter for a recognized attribute_name
        if (attribute.equals("State")) {
            return getState();
        }
        if (attribute.equals("NbChanges")) {
            return getNbChanges();
        }
        // If attribute_name has not been recognized
        throw (new AttributeNotFoundException("Cannot find " + attribute + " attribute in " + dClassName));

    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        // Check attribute to avoid NullPointerException later on
        if (attribute == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute cannot be null"), "Cannot invoke a setter of " + dClassName + " with null attribute");
        }

        String name = attribute.getName();
        Object value = attribute.getValue();

        switch (name) {
            case "State":
                // if null value, try and see if the setter returns any exception
                if (value == null) {
                    try {
                        setState(null);
                    } catch (Exception e) {
                        throw (new InvalidAttributeValueException("Cannot set attribute " + name + " to null"));
                    }
                }
                // if non null value, make sure it is assignable to the attribute
                else if(String.class.isAssignableFrom(value.getClass())){
                    this.setState((String)value);
                }
                else{
                    throw new InvalidAttributeValueException("Cannot set attribute "+ name + " to a " + value.getClass().getName() + " object, String expected");
                }   break;
            case "NbChanges":
                throw new AttributeNotFoundException("Cannot set attribute " + name + " because it is read-only");
            default:
                throw new AttributeNotFoundException("Attribute " + name + " not found in " + dClassName);
        }
        
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        // Check attributeNames to avoid NullPointerException later on
        if (attributes == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("attributeNames[] cannot be null"), "Cannot invoke a getter of " + dClassName);
        }
        
        AttributeList resultList = new AttributeList();
        // if attributeNames is empty, return an empty result list
        if (attributes.length == 0) {
            return resultList;
        }
        
        // build the result attribute list
        for (String attributeName : attributes) {
            try {
                Object value = getAttribute((String) attributeName);
                resultList.add(new Attribute(attributeName, value));
            }catch (AttributeNotFoundException | MBeanException | ReflectionException e) {
                // print debug info but continue processing list
                LOGGER.log(Level.SEVERE, "Error!", e);
            }
        }
        return (resultList);
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        // Check attributes to avoid NullPointerException later on
        if (attributes == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("AttributeList attributes cannot be null"), "Cannot invoke a setter of " + dClassName);
        }
        
        AttributeList resultList = new AttributeList();
        // if attributeNames is empty, nothing more to do
        if (attributes.isEmpty()) {
            return resultList;
        }
        
        // try to set each attribute and add to result list if successful
        for (Iterator i = attributes.iterator(); i.hasNext();) {
            Attribute attr = (Attribute) i.next();
            try {
                setAttribute(attr);
                String name = attr.getName();
                Object value = getAttribute(name);
                resultList.add(new Attribute(name, value));
            } catch (AttributeNotFoundException | InvalidAttributeValueException | MBeanException | ReflectionException e) {
                // print debug info but keep processing list
                LOGGER.log(Level.SEVERE, "Error!", e);
            }
        }
        return (resultList);
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        // Check operationName to avoid NullPointerException later on
        if (actionName == null) {
            throw new RuntimeOperationsException(
                new IllegalArgumentException(
                    "Operation name cannot be null"),
                "Cannot invoke a null operation in " + dClassName);
        }
        // Call the corresponding operation for a recognized name
        if (actionName.equals("reset")) {
            // this code is specific to the internal "reset" method:
            reset();     // no parameters to check
            return null; // and no return value
        } else {
            // unrecognized operation name:
            throw new ReflectionException(new NoSuchMethodException(actionName), "Cannot find the operation " + actionName + " in " + dClassName);
        }
    }

    // internal methods for getting attributes 
    public String getState() {
        return state;
    }

    public Integer getNbChanges() {
        return nbChanges;
    }

    // internal method for setting attribute 
    public void setState(String s) {
        state = s;
        nbChanges++;
    }
    
    public void reset() {
        AttributeChangeNotification acn = new AttributeChangeNotification(this, 0, 0, "NbChanges reset", "NbChanges", "Integer", nbChanges, 0);
        state = "initial state";
        nbChanges = 0;
        nbResets++;
        sendNotification(acn);
    }

}
