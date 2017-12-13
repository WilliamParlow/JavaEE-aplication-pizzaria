/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.tests;

import br.org.catolicasc.rolingo.daos.*;
import br.org.catolicasc.rolingo.daos.entities.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cliente
 */
public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "RolingoPersistensePU";

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        UserDAO userDao = new UserDAO(factory);
//        createNewUser("Will", "w@gmail.com", "123qwe", false, false);

        DrinkDAO daoDrink = new DrinkDAO(factory);
        for (int i = 0; i < 12; i++) {
            Drink ds = new Drink("Suco de Laranja",
                    "Esprema o limão e as 3 laranjas."
                    + " Coloque o suco do limão e das 3 laranjas no liquidificador."
                    + " Coloque o açúcar, o gelo e complete com água até chegar na medida de 1,5 litros marcadas no liquidificador."
                    + " Bata até o gelo ficar bem picadinho."
                    + " Sirva à vontade.",
                    "Laranja, água, açúcar (caso desejado) e gelo",
                    "Suco (português brasileiro) ou sumo (português europeu) de laranja é uma bebida produzida através da extração do líquido da polpa da laranja. "
                    + "Pode ser adicionado açúcar ou adoçante ao sumo para deixá-lo mais saboroso, de acordo com o gosto.\n\n Está disponível no comércio o "
                    + "suco concentrado, que requer a adição de água para reconstituir o líquido ao estado (aproximado) do suco original. O suco de laranja "
                    + "está entre os mais apreciados e consumidos, sendo uma boa fonte de vitamina C e outros nutrientes. Seu comércio e produção envolvem grandes movimentações financeiras.",
                    "https://i.pinimg.com/736x/cf/01/5b/cf015bb368357c198508fb1e94f6367d--orange-crush-drink-orange-crush-cocktail.jpg"
            );
            daoDrink.create(ds);
        }

        PizzaDAO daoPizza = new PizzaDAO(factory);
        for (int i = 0; i < 12; i++) {
            Pizza pz = new Pizza("Napolitana",
                    "1ª camada: A massa (propriamente feita, conforme acima), "
                    + "2ª camada: fatias de presunto, "
                    + "3ª camada: fatias de queijo mussarela, "
                    + "4ª camada: fatias de tomate bem maduro, "
                    + "5ª camada: salsa, cebola de cabeça, orégano, sal, pimenta do reino e azeite.",
                    "100 gramas de fermento biológico (daqueles que se usam em padaria), "
                    + "1 copo (americano) de leite morno, "
                    + "1 ovo, "
                    + "1 xícara (chá) de azeite ou óleo de cozinha, "
                    + "1 colher (sopa) rasa, de açúcar refinado, "
                    + "1/2 colher de sal, "
                    + "Farinha de trigo até o ponto de abrir.",
                    "A pizza feita em casa é muito mais saborosa que as encontradas no comércio, e é muito fácil preparar essa massa de pão enriquecida com azeite de oliva. "
                    + "Além disso, você pode preparar as coberturas que quiser. A desta receita, com tomate, mozarela, anchovas e azeitonas, é a clássica napolitana.",
                    "https://i2.wp.com/apizzapaulistana.com.br/wp-content/uploads/sites/4/2016/03/pizza-napolitana.jpg?fit=420%2C300"
            );
            daoPizza.create(pz);
        }

        DessertDAO daoDs = new DessertDAO(factory);
        for (int i = 0; i < 12; i++) {
            Dessert ds = new Dessert("Pudim de chocolate",
                    "Bata o leite condensado, o leite, a manteiga, o chocolate em pó e os ovos no liquidificador, "
                    + "Unte com manteiga uma forma com buraco no meio e polvilhe com açúcar, "
                    + "Coloque a mistura na forma e cubra a forma com papel alumínio, "
                    + "Leve ao forno, à 240ºC, em banho-maria por 1 hora, "
                    + "Retire o papel alumínio, fure com um palito, se ele sair quase limpo está pronto, se a massa ainda estiver líquida deixe mais tempo, até que o palito saia quase limpo, "
                    + "Depois retire do forno e deixe esfriar, "
                    + "Desinforme, decore com o granulado e leve à geladeira por no mínimo 4 horas, ",
                    "2 latas de leite condensado, "
                    + "1 lata de leite (use a lata de leite condensado como medida), "
                    + "1 colher de manteiga, "
                    + "200 g de chocolate em pó, "
                    + "4 ovos, "
                    + "Açúcar para polvilhar, "
                    + "Granulado de chocolate para decorar",
                    "Para quem ama pudim o brigadeirão é um sonho realizado, ele não tem a calda do pudim, mas a textura é a mesma e o sabor de chocolate é irresistível. "
                    + "Essa receita não fica muito doce, pois é utilizado o chocolate em pó e não vai calda de caramelo, então para quem procura um pudim menos doce é perfeita. "
                    + "Amo qualquer tipo de pudim e esse me deixou maravilhada. Você pode colocar calda nele também ou assar já com a calda igual um pudim tradicional, fica delicioso de qualquer forma.",
                    "http://s.glbimg.com/po/rc/media/2015/09/14/22_51_28_362_pudim_gourmet_e_chocolate.jpg"
            );
            daoDs.create(ds);
        }

    }

    private static void userAuthenticatedTest(String login, String passwd) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO userDao = new UserDAO(factory);

        try {
            User user = userDao.findUser(login, passwd);

            System.out.println(String.format("User authenticated: %s", user.getName()));
        } catch (Exception e) {
            System.err.println(String.format("Fail to authenticate with login: %s & pass: %s", login, passwd));
        }

    }

    private static void createNewUser(String name, String email, String passwd, boolean isAdmin, boolean isBlock) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO userDao = new UserDAO(factory);

        User user = new User(name, email, passwd, false, false);
        userDao.create(user);

    }

}
