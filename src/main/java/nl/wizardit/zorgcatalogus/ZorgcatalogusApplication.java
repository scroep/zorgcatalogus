package nl.wizardit.zorgcatalogus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class ZorgcatalogusApplication extends Application{

	
	private ConfigurableApplicationContext springContext;
	private Parent rootNode;
	
	
	public static void main(String[] args) {
	Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	  primaryStage.setScene(new Scene(rootNode));
	  primaryStage.show();
		
	}

	@Override
	public void init() throws Exception {
	    springContext = SpringApplication.run(ZorgcatalogusApplication.class);
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
	    fxmlLoader.setControllerFactory(springContext::getBean);
	    rootNode = fxmlLoader.load();

	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
