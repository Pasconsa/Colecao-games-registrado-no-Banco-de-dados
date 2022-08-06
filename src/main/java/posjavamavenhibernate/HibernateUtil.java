package posjavamavenhibernate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory= null;
	
	static{
		init();
	}
	
	private static void init() {
		try {
			
			if(factory == null ) {
				factory = Persistence.createEntityManagerFactory("colection-games-hibernate");
			}
		}catch (Exception e)  {
			e.printStackTrace();
		}
		
	}
	
	public static EntityManager geEntityManager() {
		return factory.createEntityManager(); //prove parte da peresistencia
	}
	
	public static Object getPrimaryKey(Object entity){ // Retorna a primay key  fazer carregamento de dados automaticamente
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}


}
