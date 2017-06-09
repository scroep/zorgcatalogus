package nl.wizardit.zorgcatalogus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.wizardit.zorgcatalogus.repositories.GebruikerRepository.Gebruikersfunctie;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class ZorgcatalogusApplication extends Application {

	private static ConfigurableApplicationContext springContext;
	private static Parent rootNode;
	
	private static Gebruikersfunctie gebruikersfunctie = Gebruikersfunctie.ONBEKEND;
	private static int gemeentecode = -1;

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public static void createSpringContext(String gebruikersnaam, String wachtwoord) {
		SpringApplicationBuilder springBuilder = new SpringApplicationBuilder(ZorgcatalogusApplication.class);
		
		springBuilder.properties(
				"spring.datasource.url=jdbc:postgresql://localhost/zorgcatalogus",
				"spring.datasource.username=" + gebruikersnaam.toLowerCase(),
				"spring.datasource.password=" + wachtwoord,
				"spring.datasource.driver-class-name=org.postgresql.Driver"
				);
		
		if (springContext != null)
			springContext.close();
		
		springContext = springBuilder.run();
	}
	
	public static Gebruikersfunctie getGebruikersfunctie() {
		return gebruikersfunctie;
	}
	
	public static int getGemeentecode() {
		return gemeentecode;
	}
	
	public static void setGebruikersInfo(Gebruikersfunctie gebruikersfunctie, int gemeentecode) {
		ZorgcatalogusApplication.gebruikersfunctie = gebruikersfunctie;
		ZorgcatalogusApplication.gemeentecode = gemeentecode;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(rootNode));
		primaryStage.show();
	}

	@Override
	public void init() throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Inloggen.fxml"));
		rootNode = fxmlLoader.load();
	}

	@Override
	public void stop() throws Exception {
		if (springContext != null)
			springContext.close();
		
		gebruikersfunctie = Gebruikersfunctie.ONBEKEND;
		gemeentecode = -1;
	}
}
