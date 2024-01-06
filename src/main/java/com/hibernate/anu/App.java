package com.hibernate.anu;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        User user1=new User();
        user1.setUsername("Manami");
        user1.setAddress("Hyderabad");
        user1.setSalary(45000);
        
        User user2=new User();
        user2.setUsername("Shruti");
        user2.setAddress("Kolkata");
        user2.setSalary(35000);
        
    	SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	Session s = session.openSession();
        Transaction tran = s.beginTransaction();
        
        s.save(user1);
        s.save(user2);
        
        tran.commit();//committing transaction
        s.close();//closing the session
        
        Session s1=session.openSession();//creating same session second object 
        Transaction tran1=s1.beginTransaction();
        
        User user3=s1.get(User.class,1);
        System.out.println(user3);//performing query to fetch object
        User user4=s1.get(User.class,1);//same obejct accessing multiple times but one time query is performed another time it fetch from cache
        System.out.println(user4);//not performing query to fetch object
        s1.close();
        
        session.close();
        
        
        
        
    }
}
