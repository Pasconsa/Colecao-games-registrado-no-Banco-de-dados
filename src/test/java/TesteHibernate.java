
import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.Console;
import model.Games;


public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {

		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		Console console = new Console();

		console.setaConsole("Dreamcast");
		console.setFabricante("Sega");
		console.setAnoLancamento("1998");
		console.setTipoMidia("Gd");
		console.setGeracao("6º");

		daoGeneric.salvar(console);

	}

	// Metodo Buscar uma informação
	@Test
	public void testeBuscar() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		Console videogame = daoGeneric.pesquisar(2L, Console.class);

		System.out.println(videogame);

	}

	// Metodo atualizar e salvar
	@Test
	public void testeUpdate() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		Console videogame = daoGeneric.pesquisar(2L, Console.class);

		videogame.setaConsole("Super Nintendo");
		videogame.setFabricante("Nintendo");
		videogame.setAnoLancamento("1990");
		videogame.setTipoMidia("Cartucho");
		videogame.setGeracao("4º");


		videogame = daoGeneric.updateMerge(videogame);

		System.out.println(videogame);

	}

	@Test
	public void testeDelete() {
		DaoGeneric<Games> daoGeneric = new DaoGeneric<Games>();

		Games videogame = daoGeneric.pesquisar(11L, Games.class);

		daoGeneric.deletarPoId(videogame);

	}

	// consultar todos os dados do banco e imprimir no java
	@Test
	public void testeConsultar() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		List<Console> list = daoGeneric.listar(Console.class);

		for (Console console : list) {
			System.out.println(console);
			System.out.println("--------------------------------------------------");
		}
	}

	// ---------------------------------------------------------------------------------------

	@Test
	public void testeQueryList() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();
		List<Console> list = daoGeneric.getEntityManager().createQuery("from Console").getResultList();

		for (Console console : list) {
			System.out.println(console);
		}
	}

	@Test
	public void testeQueryListMaxResult() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();
		List<Console> list = daoGeneric.getEntityManager().createQuery("from Console order by anoLancamento") // ordenar
																												// por
																												// idade
				.setMaxResults(2).getResultList();

		for (Console console : list) {
			System.out.println(console);
		}

	}

	@Test // Parametros de Querry condicionais or , and dois tem que ser verdadeiro
	public void testeQueryListParameter() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();

		List<Console> list = daoGeneric.getEntityManager()
				.createQuery("from Console where aConsole = :aConsole and fabricante = :fabricante")
				.setParameter("aConsole", "Super Nintendo").setParameter("fabricante", "Nintendo").getResultList();

		for (Console console : list) {
			System.out.println(console);
		}
	}
	/*
	 * Operação matematica
	 * 
	 * @Test public void testeQuerySomaIdade() { DaoGeneric<Console> daoGeneric =
	 * new DaoGeneric<Console>();
	 * 
	 * Long somaIdade = (Long) daoGeneric.getEntityManager().
	 * createQuery("select sum(u.idade) from UsuarioPessoa u") .getSingleResult();
	 * 
	 * System.out.println("Soma de todas as idades é  -->" + somaIdade); }
	 */

	// ----------------------NamedQuerry-----------------------

	@Test
	public void testeNameQuery1() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();
		List<Console> list = daoGeneric.getEntityManager().createNamedQuery("Console.todos").getResultList();

		for (Console console : list) {
			System.out.println(console);
		}
	}

	@Test
	public void testeNameQuery2() {
		DaoGeneric<Console> daoGeneric = new DaoGeneric<Console>();
		List<Console> list = daoGeneric.getEntityManager().createNamedQuery("Console.buscaPorConsole")
				.setParameter("aConsole", "Nintendo 64").getResultList();

		for (Console console : list) {
			System.out.println(console);
		}
	}

//--------------------Gravar a consultar classe Games------------------------------
	@Test
	public void testeGravaGames() {
		DaoGeneric daoGeneric = new DaoGeneric();

		Console console = (Console) daoGeneric.pesquisar(17L, Console.class);

		Games games = new Games();

		games.setAno("1991");
		games.setGenero("Aventura");
		games.setAjogo("Sonic");
		games.setProdutora("Sega");
		games.setConsole(console);

		daoGeneric.salvar(games);

	}

	@Test
	public void testeConsultaGames() {
		DaoGeneric daoGeneric = new DaoGeneric();

		Console console = (Console) daoGeneric.pesquisar(17L, Console.class);

		for (Games game : console.getGames()) {
			System.out.println(game.getAjogo());
			System.out.println(game.getGenero());
			System.out.println(game.getProdutora());
			System.out.println(game.getAno());
			System.out.println(game.getConsole().getaConsole());
			System.out.println("----------------------------");
		}
	}



}

