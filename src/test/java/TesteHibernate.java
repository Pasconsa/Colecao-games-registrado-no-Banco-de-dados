
import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.Console;


public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {

		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();
		
		Console console = new Console ();
		
		console.setAConsole("Super Nintendo");
		console.setFabricante("Nintendo");
		console.setAnoLancamento("1991");
		console.setTipoMidia("Cartucho");
	
		daoGeneric.salvar(console);

	}

	//Metodo Buscar uma informação
	@Test
	public void testeBuscar() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		Console videogame = daoGeneric.pesquisar(1L, Console.class);

		System.out.println(videogame);

	}
	
	//Metodo atualizar e salvar
	@Test
	public void testeUpdate() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		Console videogame = daoGeneric.pesquisar(1L, Console.class);

		videogame.setAConsole("Super Nintendo");
		videogame.setFabricante("Nintendo");
		videogame.setAnoLancamento("1990");
		videogame.setTipoMidia("Cartucho");

		videogame = daoGeneric.updateMerge(videogame);

		System.out.println(videogame);

	}

	
	@Test
	public void testeDelete() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		Console videogame = daoGeneric.pesquisar(1L, Console.class);

		daoGeneric.deletarPoId(videogame);

	}

	//consultar todos os dados do banco e imprimir no java
	@Test
	public void testeConsultar() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		List<Console> list = daoGeneric.listar(Console.class);

		for (Console console : list) {
			System.out.println(console);
			System.out.println("--------------------------------------------------");
		}
	}

	/*
	@Test
	public void testeQueryList() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa").getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}

	@Test
	public void testeQueryListMaxResult() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa order by idade") // ordenar
																													// por
																													// idade
				.setMaxResults(3).getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}

	}

	@Test // Parametros de Querry condicionais or , and dois tem que ser verdadeiro
	public void testeQueryListParameter() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		List<UsuarioPessoa> list = daoGeneric.getEntityManager()
				.createQuery("from UsuarioPessoa where nome = :nome and sobrenome = :sobrenome")
				.setParameter("nome", "Saulo").setParameter("sobrenome", "Pascon").getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}

	@Test
	public void testeQuerySomaIdade() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		Long somaIdade = (Long) daoGeneric.getEntityManager().createQuery("select sum(u.idade) from UsuarioPessoa u")
				.getSingleResult();

		System.out.println("Soma de todas as idades é  -->" + somaIdade);
	}

	// ----------------------NamedQuerry-----------------------

	@Test
	public void testeNameQuery1() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.todos")
				.getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}

	@Test
	public void testeNameQuery2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.buscaPorNome")
				.setParameter("nome", "Saulo").getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}

	@Test
	public void testeGravaTelefone() {
		DaoGeneric daoGeneric = new DaoGeneric();

		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(2L, UsuarioPessoa.class);

		TelefoneUser telefoneUser = new TelefoneUser();

		telefoneUser.setTipo("casa");
		telefoneUser.setNumero("19 34058888 ");
		telefoneUser.setUsuarioPessoa(pessoa);

		daoGeneric.salvar(telefoneUser);

	}

	@Test
	public void testeConsultaTelefone() {
		DaoGeneric daoGeneric = new DaoGeneric();

		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(2L, UsuarioPessoa.class);

		for (TelefoneUser fone : pessoa.getTelefoneUsers()) {
			System.out.println(fone.getNumero());
			System.out.println(fone.getTipo());
			System.out.println(fone.getUsuarioPessoa().getNome());
			System.out.println("----------------------------");

		}

	}
*/
}

