package java.beans;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class PropertyChangeSupport
        implements Serializable
{
    private static final long serialVersionUID = 6401253773779951803L;
    private transient List<PropertyChangeListener> globalListeners = new ArrayList();
    private Hashtable<String, PropertyChangeSupport> children = new Hashtable();
    private Object source;
    private int propertyChangeSupportSerializedDataVersion = 1;

    public PropertyChangeSupport(Object paramObject)
    {
        if (paramObject == null) {
            throw new NullPointerException();
        }
        this.source = paramObject;
    }

    public void firePropertyChange(String paramString, Object paramObject1, Object paramObject2)
    {
        PropertyChangeEvent localPropertyChangeEvent = createPropertyChangeEvent(paramString, paramObject1, paramObject2);
        doFirePropertyChange(localPropertyChangeEvent);
    }

    public void fireIndexedPropertyChange(String paramString, int paramInt, Object paramObject1, Object paramObject2)
    {
        doFirePropertyChange(new IndexedPropertyChangeEvent(this.source, paramString, paramObject1, paramObject2, paramInt));
    }

    public synchronized void removePropertyChangeListener(String paramString, PropertyChangeListener paramPropertyChangeListener)
    {
        if ((paramString != null) && (paramPropertyChangeListener != null))
        {
            PropertyChangeSupport localPropertyChangeSupport = (PropertyChangeSupport)this.children.get(paramString);
            if (localPropertyChangeSupport != null) {
                localPropertyChangeSupport.removePropertyChangeListener(paramPropertyChangeListener);
            }
        }
    }

    public synchronized void addPropertyChangeListener(String paramString, PropertyChangeListener paramPropertyChangeListener)
    {
        if ((paramPropertyChangeListener != null) && (paramString != null))
        {
            PropertyChangeSupport localPropertyChangeSupport = (PropertyChangeSupport)this.children.get(paramString);
            if (localPropertyChangeSupport == null)
            {
                localPropertyChangeSupport = new PropertyChangeSupport(this.source);
                this.children.put(paramString, localPropertyChangeSupport);
            }
            if ((paramPropertyChangeListener instanceof PropertyChangeListenerProxy))
            {
                PropertyChangeListenerProxy localPropertyChangeListenerProxy = (PropertyChangeListenerProxy)paramPropertyChangeListener;
                localPropertyChangeSupport.addPropertyChangeListener(new PropertyChangeListenerProxy(localPropertyChangeListenerProxy.getPropertyName(), (PropertyChangeListener)localPropertyChangeListenerProxy.getListener()));
            }
            else
            {
                localPropertyChangeSupport.addPropertyChangeListener(paramPropertyChangeListener);
            }
        }
    }

    public synchronized PropertyChangeListener[] getPropertyChangeListeners(String paramString)
    {
        PropertyChangeSupport localPropertyChangeSupport = null;
        if (paramString != null) {
            localPropertyChangeSupport = (PropertyChangeSupport)this.children.get(paramString);
        }
        return localPropertyChangeSupport == null ? new PropertyChangeListener[0] : localPropertyChangeSupport.getPropertyChangeListeners();
    }

    public void firePropertyChange(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
        PropertyChangeEvent localPropertyChangeEvent = createPropertyChangeEvent(paramString, paramBoolean1, paramBoolean2);
        doFirePropertyChange(localPropertyChangeEvent);
    }

    public void fireIndexedPropertyChange(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
        if (paramBoolean1 != paramBoolean2) {
            fireIndexedPropertyChange(paramString, paramInt, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2));
        }
    }

    public void firePropertyChange(String paramString, int paramInt1, int paramInt2)
    {
        PropertyChangeEvent localPropertyChangeEvent = createPropertyChangeEvent(paramString, paramInt1, paramInt2);
        doFirePropertyChange(localPropertyChangeEvent);
    }

    public void fireIndexedPropertyChange(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
        if (paramInt2 != paramInt3) {
            fireIndexedPropertyChange(paramString, paramInt1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        }
    }

    public synchronized boolean hasListeners(String paramString)
    {
        if (this.globalListeners.size() > 0) {
            return true;
        }
        boolean bool = false;
        if (paramString != null)
        {
            PropertyChangeSupport localPropertyChangeSupport = (PropertyChangeSupport)this.children.get(paramString);
            bool = (localPropertyChangeSupport != null) && (localPropertyChangeSupport.hasListeners(paramString));
        }
        return bool;
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
    {
        if ((paramPropertyChangeListener instanceof PropertyChangeListenerProxy))
        {
            String str = ((PropertyChangeListenerProxy)paramPropertyChangeListener).getPropertyName();
            PropertyChangeListener localPropertyChangeListener = (PropertyChangeListener)((PropertyChangeListenerProxy)paramPropertyChangeListener).getListener();
            removePropertyChangeListener(str, localPropertyChangeListener);
        }
        else
        {
            this.globalListeners.remove(paramPropertyChangeListener);
        }
    }

    public synchronized void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
    {
        if ((paramPropertyChangeListener instanceof PropertyChangeListenerProxy))
        {
            String str = ((PropertyChangeListenerProxy)paramPropertyChangeListener).getPropertyName();
            PropertyChangeListener localPropertyChangeListener = (PropertyChangeListener)((PropertyChangeListenerProxy)paramPropertyChangeListener).getListener();
            addPropertyChangeListener(str, localPropertyChangeListener);
        }
        else if (paramPropertyChangeListener != null)
        {
            this.globalListeners.add(paramPropertyChangeListener);
        }
    }

    public synchronized PropertyChangeListener[] getPropertyChangeListeners()
    {
        ArrayList localArrayList = new ArrayList(this.globalListeners);
        Iterator localIterator = this.children.keySet().iterator();
        while (localIterator.hasNext())
        {
            String str = (String)localIterator.next();
            PropertyChangeSupport localPropertyChangeSupport = (PropertyChangeSupport)this.children.get(str);
            PropertyChangeListener[] arrayOfPropertyChangeListener = localPropertyChangeSupport.getPropertyChangeListeners();
            for (int i = 0; i < arrayOfPropertyChangeListener.length; i++) {
                localArrayList.add(new PropertyChangeListenerProxy(str, arrayOfPropertyChangeListener[i]));
            }
        }
        return (PropertyChangeListener[])localArrayList.toArray(new PropertyChangeListener[0]);
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
            throws IOException
    {
        paramObjectOutputStream.defaultWriteObject();
        PropertyChangeListener[] arrayOfPropertyChangeListener = (PropertyChangeListener[])this.globalListeners.toArray(new PropertyChangeListener[0]);
        for (int i = 0; i < arrayOfPropertyChangeListener.length; i++) {
            if ((arrayOfPropertyChangeListener[i] instanceof Serializable)) {
                paramObjectOutputStream.writeObject(arrayOfPropertyChangeListener[i]);
            }
        }
        paramObjectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException
    {
        paramObjectInputStream.defaultReadObject();
        this.globalListeners = new LinkedList();
        if (null == this.children) {
            this.children = new Hashtable();
        }
        Object localObject = null;
        do
        {
            localObject = paramObjectInputStream.readObject();
            if (localObject != null) {
                addPropertyChangeListener((PropertyChangeListener)localObject);
            }
        } while (localObject != null);
    }

    public void firePropertyChange(PropertyChangeEvent paramPropertyChangeEvent)
    {
        doFirePropertyChange(paramPropertyChangeEvent);
    }

    private PropertyChangeEvent createPropertyChangeEvent(String paramString, Object paramObject1, Object paramObject2)
    {
        return new PropertyChangeEvent(this.source, paramString, paramObject1, paramObject2);
    }

    private PropertyChangeEvent createPropertyChangeEvent(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
        return new PropertyChangeEvent(this.source, paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2));
    }

    private PropertyChangeEvent createPropertyChangeEvent(String paramString, int paramInt1, int paramInt2)
    {
        return new PropertyChangeEvent(this.source, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }

    private void doFirePropertyChange(PropertyChangeEvent paramPropertyChangeEvent)
    {
        Object localObject1 = paramPropertyChangeEvent.getOldValue();
        Object localObject2 = paramPropertyChangeEvent.getNewValue();
        if ((localObject1 != null) && (localObject2 != null) && (localObject1.equals(localObject2))) {
            return;
        }
        PropertyChangeListener[] arrayOfPropertyChangeListener;
        synchronized (this)
        {
            arrayOfPropertyChangeListener = (PropertyChangeListener[])this.globalListeners.toArray(new PropertyChangeListener[0]);
        }
        for (int i = 0; i < arrayOfPropertyChangeListener.length; i++) {
            arrayOfPropertyChangeListener[i].propertyChange(paramPropertyChangeEvent);
        }
        if (paramPropertyChangeEvent.getPropertyName() != null)
        {
            PropertyChangeSupport localPropertyChangeSupport = (PropertyChangeSupport)this.children.get(paramPropertyChangeEvent.getPropertyName());
            if (localPropertyChangeSupport != null) {
                localPropertyChangeSupport.firePropertyChange(paramPropertyChangeEvent);
            }
        }
    }

    // Here to avoid trouble during MOE compilation
    static {

    }
    private boolean equals(String a, EventListener b, EventListener c) {
        return false;
    }
}
