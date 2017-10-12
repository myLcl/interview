package Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 序列化安全的单例 :内部类 + readResolve()
 */
public class SequenceSingle implements Serializable{

	private static final long serialVersionUID = 1L;  
	  
    /**  
     *内部类的方式创建单例对象
     */
    private static class MySingletonHandler{  
        private static SequenceSingle instance = new SequenceSingle();  
    }   
      
    private SequenceSingle(){}  
     
    /**
     *对外的方法 
     */
    public static SequenceSingle getInstance() {   
        return MySingletonHandler.instance;  
    }  
     
    /**
     * 保重反序列化单例
     * 该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉  
     */
    protected Object readResolve() throws ObjectStreamException {  
        System.out.println("调用了readResolve方法！");  
        return MySingletonHandler.instance;   
    }  
    
    public static void main(String[] args) {
    	 SequenceSingle singleton = SequenceSingle.getInstance();  
         
         File file = new File("MySingleton.txt");  
         try {  
        	 //序列化
             FileOutputStream fos = new FileOutputStream(file);  
             ObjectOutputStream oos = new ObjectOutputStream(fos);  
             oos.writeObject(singleton);
             fos.close();  
             oos.close();  
             
             System.out.println(singleton.hashCode()); 
             
             //反序列化
             FileInputStream fis = new FileInputStream(file);  
             ObjectInputStream ois = new ObjectInputStream(fis); 
             
             SequenceSingle rSingleton = (SequenceSingle) ois.readObject();  
            
             fis.close();  
             ois.close();  
             System.out.println(rSingleton.hashCode());
         } catch (Exception e) {   
             e.printStackTrace();  
         }  
           
	}
}
