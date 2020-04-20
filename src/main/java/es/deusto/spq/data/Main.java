// package es.deusto.spq.data;

// import java.util.Iterator;
// import java.util.List;

// import javax.jdo.PersistenceManager;
// import javax.jdo.PersistenceManagerFactory;
// import javax.jdo.Extent;
// import javax.jdo.Query;
// import javax.jdo.JDOHelper;
// import javax.jdo.Transaction;

// import es.deusto.spq.server.PisoDAO;

// public class Main{
	
// 	public static PisoDAO db;


//     @SuppressWarnings("unchecked")
// 	public static void main(String args[])
//     {
//     	System.out.println("Starting ....");
//         // Create a PersistenceManagerFactory for this datastore
//         PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

//         System.out.println("DataNucleus AccessPlatform with JDO");
//         System.out.println("===================================");

//         // Persistence of a Product and a Book.
//         PersistenceManager pm = pmf.getPersistenceManager();
//         Transaction tx=pm.currentTransaction();
//         try
//         {
//             tx.begin();
//             System.out.println("Persisting pisos");
//             Piso piso = new Piso("Piso 1", 900.0);
//             pm.makePersistent(piso);

//             tx.commit();
//             System.out.println("Pisos have been persisted");
//         }
//         finally
//         {
//             if (tx.isActive())
//             {
//                 tx.rollback();
//             }
//             pm.close();
//         }
//         System.out.println("");

//         // Basic Extent of all Products
//         pm = pmf.getPersistenceManager();
//         tx = pm.currentTransaction();
//         try
//         {
//             tx.begin();
//             System.out.println("Retrieving Extent for Pisos");
//             Extent<Piso> e = pm.getExtent(Piso.class, true);
//             Iterator<Piso> iter = e.iterator();
//             while (iter.hasNext())
//             {
//                 Object obj = iter.next();
//                 System.out.println(">  " + obj);
//             }
//             tx.commit();
//         }
//         catch (Exception e)
//         {
//             System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
//         }
//         finally
//         {
//             if (tx.isActive())
//             {
//                 tx.rollback();
//             }
//             pm.close();
//         }
//         System.out.println("");

        
//         // Clean out the database
//         pm = pmf.getPersistenceManager();
//         tx = pm.currentTransaction();
//         try
//         {
//             tx.begin();
//             System.out.println("Deleting all pisos from persistence");
//             Query<Piso> q = pm.newQuery(Piso.class);
//             long numberInstancesDeleted = q.deletePersistentAll();
//             System.out.println("Deleted " + numberInstancesDeleted + " piso");

//             tx.commit();
//         }
//         finally
//         {
//             if (tx.isActive())
//             {
//                 tx.rollback();
//             }
//             pm.close();
//         }

//         System.out.println("");
//         System.out.println("End of Tutorial");
// 		pmf.close();
//     }

// }