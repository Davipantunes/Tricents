import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = {"steps"},
		features = "src/main/resources/features",
		tags = "not @ignore",
		plugin = {"pretty","html:target/cucumber.report.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		)

public class RunCucumberTest {

	@AfterClass
	public static void generateAndServeAllureReport() {
		try {

			System.out.println("Gerando relatório Maven Surefire plugin...");

			// Configura o comando Maven para gerar o relatório Surefire
//			ProcessBuilder surefireBuilder = new ProcessBuilder();
//			surefireBuilder.command("C:\\Program Files\\apache-maven-3.6.3\\bin\\mvn.cmd", "report:report");
//			surefireBuilder.directory(new java.io.File("C:\\Users\\not\\git\\Tricents\\Tricents"));
//			executeProcess(surefireBuilder);
			
			System.out.println("Gerando dados do relatório...");

			// Configura o comando Maven para servir o relatório
			ProcessBuilder serveBuilder = new ProcessBuilder();
			serveBuilder.command("C:\\Program Files\\apache-maven-3.6.3\\bin\\mvn.cmd", "allure:serve");
			serveBuilder.directory(new java.io.File("C:\\Users\\not\\git\\Tricents\\Tricents"));
			executeProcess(serveBuilder);

			System.out.println("Gerando relatório allure...");

			// Configura o comando Maven para gerar o relatório
			ProcessBuilder reportBuilder = new ProcessBuilder();
			reportBuilder.command("C:\\Program Files\\apache-maven-3.6.3\\bin\\mvn.cmd", "allure:report");
			reportBuilder.directory(new java.io.File("C:\\Users\\not\\git\\Tricents\\Tricents"));
			executeProcess(reportBuilder);
			
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.err.println("Ocorreu um erro ao gerar dados ou relatório Allure.");
		}
	}

	private static void executeProcess(ProcessBuilder processBuilder) throws IOException, InterruptedException {
		// Inicia o processo
		Process process = processBuilder.start();

		// Captura e exibe a saída do processo
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}

		int exitCode = process.waitFor();
		if (exitCode != 0) {
			throw new IOException("Processo falhado com código: " + exitCode);
		}
	}
}
