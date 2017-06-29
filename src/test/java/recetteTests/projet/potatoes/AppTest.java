package recetteTests.projet.potatoes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{
	GameShould.class,
	PlotShould.class,
	PlotViewShould.class,
	PotatoShould.class,
})
public class AppTest
{

}
