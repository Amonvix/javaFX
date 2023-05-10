package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application {

	private int cont = 0;

	private void atualizarCor(Label label) {
		label.setText(Integer.toString(cont));
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");

		if (cont > 0) {
			label.getStyleClass().add("verde");
		} else if(cont < 0){
			label.getStyleClass().add("vermelho");
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label labelTitulo = new Label("Contador");
		Label labelNumero = new Label("0");
		labelTitulo.getStyleClass().add("titulo");
		labelNumero.getStyleClass().add("numero");

		Button botaoInc = new Button(" + ");
		Button botaoDec = new Button(" - ");
		botaoInc.getStyleClass().add("botaoInc");
		botaoDec.getStyleClass().add("botaoDec");
		botaoInc.setOnAction(e -> {
			cont++;
			atualizarCor(labelNumero);
		});

		botaoDec.setOnAction(e -> {
			cont--;
			atualizarCor(labelNumero);
		});

		HBox boxBotoes = new HBox();
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxBotoes.getChildren().add(botaoDec);
		boxBotoes.getChildren().add(botaoInc);

		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.setSpacing(10);
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNumero);
		boxConteudo.getChildren().add(boxBotoes);

		String caminhoDoCss = getClass().getResource("/basico/Contador.css").toExternalForm();
		Scene cenaPrincipal = new Scene(boxConteudo, 300, 300);
		cenaPrincipal.getStylesheets().add(caminhoDoCss);
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");

		primaryStage.setScene(cenaPrincipal);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
